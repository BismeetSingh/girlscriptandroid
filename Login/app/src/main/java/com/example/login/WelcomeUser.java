package com.example.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeUser extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "loginPreferences";
    private static final String LOGIN  = "loginStatus";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_user);
        Button logout=findViewById(R.id.logoutBtn);
        TextView usernameTview=findViewById(R.id.username);
        sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        Intent intent=getIntent();
        String username=intent.getStringExtra("username");
        if (username!=null) {
            String partName = username.substring(0, username.indexOf("@"));
            usernameTview.setText("Hello "+partName);
        }
        else {
            usernameTview.setText(username);
        }


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        sharedPreferences.edit().putBoolean(LOGIN,false).apply();
                        startActivity(new Intent(WelcomeUser.this,MainActivity.class));
                        finish();

            }
        });
    }
}
