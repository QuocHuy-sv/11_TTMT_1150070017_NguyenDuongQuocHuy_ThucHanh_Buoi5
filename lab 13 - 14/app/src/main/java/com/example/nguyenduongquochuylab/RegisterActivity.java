package com.example.nguyenduongquochuylab;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText edtFullName, edtEmail, edtPassword, edtConfirm;
    private Button btnRegister;
    private TextView tvLoginInstead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();
        setEvents();
    }

    private void initViews() {
        edtFullName = findViewById(R.id.edtFullName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtConfirm = findViewById(R.id.edtConfirm);

        btnRegister = findViewById(R.id.btnRegister);
        tvLoginInstead = findViewById(R.id.tvLoginInstead);
    }

    private void setEvents() {

        btnRegister.setOnClickListener(view -> {

            String fullName = edtFullName.getText().toString().trim();
            String email = edtEmail.getText().toString().trim();
            String pass = edtPassword.getText().toString().trim();
            String confirm = edtConfirm.getText().toString().trim();

            if (fullName.isEmpty()) {
                show("Vui lòng nhập Họ tên");
                return;
            }
            if (email.isEmpty()) {
                show("Vui lòng nhập Email");
                return;
            }
            if (pass.isEmpty()) {
                show("Vui lòng nhập mật khẩu");
                return;
            }
            if (!pass.equals(confirm)) {
                show("Mật khẩu xác nhận không trùng khớp");
                return;
            }

            show("Đăng ký thành công!");

            Intent i = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        });

        tvLoginInstead.setOnClickListener(view -> {
            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            finish();
        });
    }

    private void show(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
