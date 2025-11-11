package com.example.nguyenduongquochuylab3;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
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

        edtEmail   = findViewById(R.id.edtEmail);
        edtPassword= findViewById(R.id.edtPassword);
        btnLogin   = findViewById(R.id.btnLogin);
        tvForgot   = findViewById(R.id.tvForgot);
        tvRegister = findViewById(R.id.tvRegister);

        btnLogin.setOnClickListener(v -> {
            String email = edtEmail.getText().toString().trim();
            String pass  = edtPassword.getText().toString();

            if (email.isEmpty() || pass.isEmpty()) {
                showCustomToast("Vui lòng nhập đầy đủ email và mật khẩu");
                return;
            }

            String msg = "Bạn đã đăng nhập thành công với email: " + email
                    + " và mật khẩu " + pass;
            showCustomToast(msg);
        });

        tvForgot.setOnClickListener(v -> showCustomToast("Quên mật khẩu?"));
        tvRegister.setOnClickListener(v -> showCustomToast("Đi tới đăng ký"));
    }

    private void showCustomToast(String message) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.view_toast, findViewById(R.id.toastRoot));
        TextView tv = layout.findViewById(R.id.tvToast);
        tv.setText(message);

        Toast t = new Toast(getApplicationContext());
        t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 140); // vị trí trên giữa
        t.setDuration(Toast.LENGTH_LONG);
        t.setView(layout);
        t.show();
    }
}
