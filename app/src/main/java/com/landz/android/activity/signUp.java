package com.landz.android.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.landz.android.R;
import com.landz.android.database.Database;
import com.landz.android.databinding.ActivitySignUpBinding;

public class signUp extends AppCompatActivity {
    ActivitySignUpBinding binding;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = new Database(this);
        binding.signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String  username = binding.username.getText().toString();
                String  password = binding.password.getText().toString();
                String  checkpass = binding.checkpassword.getText().toString();

                if (username.equals("") || password.equals("") || checkpass.equals(""))
                    Toast.makeText(signUp.this, "ALL fields are madatory", Toast.LENGTH_SHORT).show();
                else {
                    if (password.equals(checkpass)){
                        Boolean checkUser = db.checkUserName(username);

                        if (checkUser == false){
                            Boolean insert = db.insertUser(username, password);

                            if (insert == true){
                                Toast.makeText(signUp.this, "Signup Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Login.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(signUp.this, "Signup failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(signUp.this, "User already exists, Please Login", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(signUp.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        binding.tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }
}