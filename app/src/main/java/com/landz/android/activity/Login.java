package com.landz.android.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.landz.android.R;
import com.landz.android.database.Database;
import com.landz.android.databinding.ActivityLoginBinding;

public class Login extends AppCompatActivity {
    ActivityLoginBinding binding;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = new Database(this);

        binding.Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.username.getText().toString();
                String pass = binding.password.getText().toString();

                if (username.equals("") || pass.equals(""))
                    Toast.makeText(Login.this, "ALL fields are madatory", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkCredental = db.checkUserNamePass(username, pass);

                    if (checkCredental == true)
                    {
                        Toast.makeText(Login.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(Login.this, "Invalid Credental", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        TextView Signup = findViewById(R.id.tvSignUp);
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, signUp.class);
                startActivity(intent);
            }
        });
    }
}