package com.oxyrem.patient.gui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.rengwuxian.materialedittext.MaterialEditText;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.oxyrem.patient.R;

public class LoginActivity extends Activity {

    @InjectView(R.id.editTextEmail) MaterialEditText mUsernameField;
    @InjectView(R.id.editTextPassword) MaterialEditText mPasswordField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.inject(this); // Injects the annotated MaterialEditTexts

        mUsernameField.setBaseColor(getResources().getColor(R.color.turquoise1));
        mUsernameField.setPrimaryColor(getResources().getColor(R.color.steel_blue3));
        mPasswordField.setBaseColor(getResources().getColor(R.color.turquoise1));
        mPasswordField.setPrimaryColor(getResources().getColor(R.color.steel_blue3));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
