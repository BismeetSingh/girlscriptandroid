package com.example.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Activity


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Reference
        Button btnClick=findViewById(R.id.btn);
        Button btnClick2=findViewById(R.id.btn2);
        btnClick.setOnClickListener(this);
        btnClick2.setOnClickListener(this);

        //Alternatively

//        btnClick.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
//                startActivity(intent);
//            }
//        });

    }

    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn:
                Toast.makeText(this, "1stbtn", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn2:
                Toast.makeText(this, "2ndbtn", Toast.LENGTH_SHORT).show();

        }


    }
}
