package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    EditText email,password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        email= findViewById(R.id.et_email);
        password=findViewById(R.id.et_passCred);
        login=findViewById(R.id.bt_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user= email.getText().toString();
                String pass=password.getText().toString();

                SharedPreferences sh = getSharedPreferences("shared", MODE_PRIVATE);
                String value1= sh.getString("key1", "");
                String value2= sh.getString("key2", "");

                if(user.contains(value1) && pass.contains(value2)){
                    Intent i = new Intent(SecondActivity.this, ThirdActivity.class);
                    startActivity(i);
                } else{
                    Toast.makeText(SecondActivity.this, "Login Unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}