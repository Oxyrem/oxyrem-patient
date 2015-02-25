package com.oxyrem.patient.util;

import java.util.regex.Pattern;

import android.text.TextUtils;
import android.util.Log;

/**
 * A utility class for text validation.
 *
 * @author Patrick Reid
 */
public class ValidTextUtility {
    private static final String TAG = "OXPA/ValidTextUtility";

    /**
     * Validate password.
     *
     * @param password
     * @return boolean True if password is valid.
     */
    public static boolean validPassword(String password) {
        if (!TextUtils.isEmpty(password) && (password.length() > 4)) {
            return true;
        }
        return false;
    }

    /**
     * Validate email.
     *
     * @param email
     * @return boolean True if email is valid.
     */
    public static boolean validEmail(String email) {
        final String validPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        try{
            if (Pattern.matches(validPattern, email)) {
                return true;
            }
        }catch(NullPointerException e){
            Log.d(TAG, "NullPointerException caught in pattern match.");
        }
        return false;
    }

    /**
     * Validate number.
     *
     * @param number
     * @return boolean True if number is valid.
     */
    public static boolean validNumber(String number) {
        final String validPattern = "^(\\d{7}|\\d{10}|\\d{11})$";

        try{
            if (Pattern.matches(validPattern, number)) {
                return true;
            }
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        return false;
    }

}
