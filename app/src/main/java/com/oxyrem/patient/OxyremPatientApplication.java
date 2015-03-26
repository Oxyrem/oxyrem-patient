package com.oxyrem.patient;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Oxyrem:Patient Application class.
 * @author Patrick Reid
 * @see android.app.Application
 */
public class OxyremPatientApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
