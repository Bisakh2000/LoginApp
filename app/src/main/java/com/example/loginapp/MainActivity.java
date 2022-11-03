package com.example.loginapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    EditText user, pass, add;
    Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = findViewById(R.id.et_username);
        pass = findViewById(R.id.et_password);
        add = findViewById(R.id.et_address);
        button = findViewById(R.id.bt_register);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = user.getText().toString();
                String password = pass.getText().toString();
                String address = add.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("shared", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("key1", username);
                editor.putString("key2", password);
                editor.putString("key3", address);
                editor.apply();
                Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();


                Intent i=new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });
    }
}