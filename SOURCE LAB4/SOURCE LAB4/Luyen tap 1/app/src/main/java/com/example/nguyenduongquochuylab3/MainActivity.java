package com.example.nguyenduongquochuylab3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtEmail, edtPassword;
    Button btnLogin;
    TextView tvForgot, tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvForgot = findViewById(R.id.tvForgot);
        tvRegister = findViewById(R.id.tvRegister);

        btnLogin.setOnClickListener(v ->
                Toast.makeText(this, "Login clicked", Toast.LENGTH_SHORT).show()
        );
        tvForgot.setOnClickListener(v ->
                Toast.makeText(this, "Forgot password?", Toast.LENGTH_SHORT).show()
        );
        tvRegister.setOnClickListener(v ->
                Toast.makeText(this, "Go to Register", Toast.LENGTH_SHORT).show()
        );
    }
}
