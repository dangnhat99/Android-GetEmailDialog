package com.dialog.email;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.dialog.getemaildialog.GetEmailDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetEmailDialog emailDialog = new GetEmailDialog(new GetEmailDialog.GetEmailCallback() {

            @Override
            public void onYesButtonClick(String email) {
                Toast.makeText(MainActivity.this, email, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNoButtonClick() {
                Toast.makeText(MainActivity.this, "cancel", Toast.LENGTH_SHORT).show();
            }
        });

        emailDialog.show(getSupportFragmentManager(), "h");
    }
}