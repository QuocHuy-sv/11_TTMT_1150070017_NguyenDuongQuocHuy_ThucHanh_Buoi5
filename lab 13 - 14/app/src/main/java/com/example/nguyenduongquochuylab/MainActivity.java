package com.example.nguyenduongquochuylab;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText edtEmail, edtPassword;
    Button btnLogin;
    TextView tvForgot, tvRegister;


    String API_URL = "http://10.0.2.2:3000/api/auth/login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail    = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin    = findViewById(R.id.btnLogin);
        tvForgot    = findViewById(R.id.tvForgot);
        tvRegister  = findViewById(R.id.tvRegister);

        btnLogin.setOnClickListener(view -> {
            String email = edtEmail.getText().toString().trim();
            String pass  = edtPassword.getText().toString().trim();

            if (email.isEmpty() || pass.isEmpty()) {
                showCustomToast("Vui lòng nhập email và mật khẩu");
                return;
            }

            loginAPI(email, pass);
        });

        tvRegister.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, RegisterActivity.class));
        });

        tvForgot.setOnClickListener(v ->
                showCustomToast("Tính năng quên mật khẩu đang phát triển..."));
    }

    private void loginAPI(String email, String password) {

        new Thread(() -> {
            try {
                URL url = new URL(API_URL);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                conn.setRequestMethod("POST");
                conn.setConnectTimeout(6000);
                conn.setReadTimeout(6000);
                conn.setDoOutput(true);
                conn.setRequestProperty("Content-Type", "application/json");

                JSONObject jsonBody = new JSONObject();
                jsonBody.put("email", email);
                jsonBody.put("password", password);

                OutputStream os = new BufferedOutputStream(conn.getOutputStream());
                os.write(jsonBody.toString().getBytes());
                os.flush();
                os.close();

                int status = conn.getResponseCode();
                BufferedReader br;

                if (status >= 400) {
                    br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                } else {
                    br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                }

                StringBuilder sb = new StringBuilder();
                String line;

                while ((line = br.readLine()) != null)
                    sb.append(line);

                String response = sb.toString();
                br.close();
                conn.disconnect();

                runOnUiThread(() -> handleAPIResponse(response));

            } catch (Exception e) {
                runOnUiThread(() ->
                        showCustomToast("Không thể kết nối API: " + e.getMessage()));
            }
        }).start();
    }

    private void handleAPIResponse(String response) {
        try {
            JSONObject obj = new JSONObject(response);

            boolean success = obj.optBoolean("success", false);
            String message = obj.optString("message", "Không rõ lỗi");

            if (!success) {
                showCustomToast(message);
                return;
            }

            JSONObject user = obj.getJSONObject("user");
            String fullname = user.getString("fullname");

            showCustomToast("Đăng nhập thành công! Xin chào " + fullname);

        } catch (Exception e) {
            showCustomToast("Lỗi xử lý dữ liệu: " + e.getMessage());
        }
    }

    private void showCustomToast(String message) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.view_toast, findViewById(R.id.toastRoot));

        TextView tv = layout.findViewById(R.id.tvToast);
        tv.setText(message);

        Toast t = new Toast(getApplicationContext());
        t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 140);
        t.setDuration(Toast.LENGTH_LONG);
        t.setView(layout);
        t.show();
    }
}
