package com.example.nguyenduongquochuylab;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnToast, btnDialog;
    private Button btnEmojiLeftTop, btnEmojiLeftBottom, btnEmojiRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToast  = findViewById(R.id.btnToast);
        btnDialog = findViewById(R.id.btnDialog);

        btnEmojiLeftTop    = findViewById(R.id.btnEmojiLeftTop);
        btnEmojiLeftBottom = findViewById(R.id.btnEmojiLeftBottom);
        btnEmojiRight      = findViewById(R.id.btnEmojiRight);

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomToast();
            }
        });

        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });

        setupEmojiToggle(btnEmojiLeftTop);
        setupEmojiToggle(btnEmojiLeftBottom);
        setupEmojiToggle(btnEmojiRight);
    }

    private void setupEmojiToggle(final Button btn) {

        btn.setText("😊");
        btn.setTag(false);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isSunglasses = (Boolean) btn.getTag();
                if (isSunglasses) {
                    btn.setText("😊");
                } else {
                    btn.setText("😎");
                }
                btn.setTag(!isSunglasses);
            }
        });
    }

    private void showCustomToast() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(
                R.layout.layout_custom_toast,
                (ViewGroup) findViewById(R.id.toast_root)
        );

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 150);
        toast.show();
    }

    private void showCustomDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.layout_custom_dialog, null);
        builder.setView(dialogView);
        builder.setCancelable(false);

        final AlertDialog dialog = builder.create();

        EditText edtUsername = dialogView.findViewById(R.id.edtUsername);
        EditText edtPassword = dialogView.findViewById(R.id.edtPassword);
        Button btnDongY      = dialogView.findViewById(R.id.btnDongY);
        Button btnThoat      = dialogView.findViewById(R.id.btnThoat);


        btnDongY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUsername.getText().toString().trim();
                String pass = edtPassword.getText().toString().trim();

                if (user.equals("admin") && pass.equals("admin")) {
                    Toast.makeText(MainActivity.this,
                            "Đăng nhập thành công (admin/admin)", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this,
                            "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }
                dialog.dismiss();
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
