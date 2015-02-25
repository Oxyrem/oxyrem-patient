package com.oxyrem.patient.security;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * TextEncryptionService, adopted from PasswordEncryptionService. Provides
 * PBKDF2 text encryption.
 *
 *
 * @version 1.0
 * @author Patrick Reid
 * @see <a href="http://en.wikipedia.org/wiki/PBKDF2">PBKDF2</a>
 */
public class TextEncryptionService {

    /**
     * @param attemptedText
     * @param encryptedPassword
     * @param salt
     * @return True if authentication is successful.
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public boolean authenticate(String attemptedText, byte[] encryptedPassword,
                                byte[] salt) throws NoSuchAlgorithmException,
            InvalidKeySpecException {
        // encrypt the original text
        byte[] encryptedAttemptedPassword = getEncryptedText(attemptedText,
                salt);
        // Authentication succeeds if encrypted text that the user entered
        // is equal to the stored hash
        return Arrays.equals(encryptedPassword, encryptedAttemptedPassword);

    }

    /**
     * @param text
     * @param salt
     * @return Encrypted text.
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public byte[] getEncryptedText(String text, byte[] salt)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
		/*
		 * PBKDF2 with SHA-1 as the hashing algorithm. Note that the NIST
		 * specifically names SHA-1 as an acceptable hashing algorithm for
		 * PBKDF2
		 */
        String algorithm = "PBKDF2WithHmacSHA1";
        //SHA-1 generates 160 bit hashes, so that's what makes sense here
        int derivedKeyLength = 160;
		/*
		 * Pick an iteration count that works for you. The NIST recommends at
		 * least 1,000 iterations:
		 * http://csrc.nist.gov/publications/nistpubs/800-132/nist-sp800-132.pdf
		 * iOS 4.x reportedly uses 10,000:
		 * http://blog.crackpassword.com/2010/09/
		 * smartphone-forensics-cracking-blackberry-backup-passwords/
		 */
        int iterations = 10021;
        KeySpec spec = new PBEKeySpec(text.toCharArray(), salt, iterations,
                derivedKeyLength);
        SecretKeyFactory f = SecretKeyFactory.getInstance(algorithm);

        return f.generateSecret(spec).getEncoded();

    }

    /**
     * @return An 8 byte (64 bit) salt as recommended by RSA PKCS5
     * @throws NoSuchAlgorithmException
     */
    public byte[] generateSalt() throws NoSuchAlgorithmException {
        // VERY important to use SecureRandom instead of just Random
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        // Generate a 8 byte (64 bit) salt as recommended by RSA PKCS5
        byte[] salt = new byte[8];
        random.nextBytes(salt);
        return salt;
    }

}