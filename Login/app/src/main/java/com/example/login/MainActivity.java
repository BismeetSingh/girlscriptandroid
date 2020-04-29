package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "loginPreferences";
    private static final String LOGIN  = "loginStatus";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText email=findViewById(R.id.email);
        final EditText pwd=findViewById(R.id.password);
        Button login=findViewById(R.id.btnLogin);
        sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE) ;
        if (sharedPreferences.getBoolean(LOGIN,false)){
            startActivity(new Intent(MainActivity.this,WelcomeUser.class));
            finish();
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(pwd.getText().toString())){
                    Toast.makeText(MainActivity.this, "Please enter valid credentials", Toast.LENGTH_SHORT).show();
                }
                else {
                    sharedPreferences.edit().putBoolean(LOGIN,true).apply();
                    Intent intent=new Intent(MainActivity.this,WelcomeUser.class);
                    intent.putExtra("username",email.getText().toString());
                    startActivity(intent);
//                    startActivity(new Intent(MainActivity.this,WelcomeUser.class));
                    finish();
                }

            }
        });
    }
}
