package com.example.nguyenduongquochuylab3;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS = "ml_prefs";
    private static final String KEY_LANG = "lang";

    private Toolbar toolbar;
    private TextView tvTitle, tvSignup, tvVi, tvEn, tvFr;
    private EditText edtEmail, edtPassword;
    private Button btnLogin;

    private String lang = "en";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        tvTitle    = findViewById(R.id.tvTitle);
        edtEmail   = findViewById(R.id.edtEmail);
        edtPassword= findViewById(R.id.edtPassword);
        btnLogin   = findViewById(R.id.btnLogin);
        tvSignup   = findViewById(R.id.tvSignup);
        tvVi       = findViewById(R.id.tvVi);
        tvEn       = findViewById(R.id.tvEn);
        tvFr       = findViewById(R.id.tvFr);

        SharedPreferences sp = getSharedPreferences(PREFS, MODE_PRIVATE);
        lang = sp.getString(KEY_LANG, null);
        if (lang == null) {
            String sys = Locale.getDefault().getLanguage();
            lang = sys.equalsIgnoreCase("vi") ? "vi" : (sys.equalsIgnoreCase("fr") ? "fr" : "en");
            sp.edit().putString(KEY_LANG, lang).apply();
        }
        renderUi();

        tvVi.setOnClickListener(v -> setLang("vi"));
        tvEn.setOnClickListener(v -> setLang("en"));
        tvFr.setOnClickListener(v -> setLang("fr"));
    }

    private void setLang(String l) {
        lang = l;
        getSharedPreferences(PREFS, MODE_PRIVATE).edit().putString(KEY_LANG, lang).apply();
        renderUi();
    }

    private void renderUi() {
        switch (lang) {
            case "vi":
                setTitle(getString(R.string.app_name_vi));
                toolbar.setTitle(getString(R.string.app_name_vi));
                tvTitle.setText(getString(R.string.title_vi));
                edtEmail.setHint(getString(R.string.email_vi));
                edtPassword.setHint(getString(R.string.password_vi));
                btnLogin.setText(getString(R.string.login_vi));
                tvSignup.setText(getString(R.string.no_account_vi));
                tvVi.setText(getString(R.string.vi_vi));
                tvEn.setText(getString(R.string.en_vi));
                tvFr.setText(getString(R.string.fr_vi));
                break;
            case "fr":
                setTitle(getString(R.string.app_name_fr));
                toolbar.setTitle(getString(R.string.app_name_fr));
                tvTitle.setText(getString(R.string.title_fr));
                edtEmail.setHint(getString(R.string.email_fr));
                edtPassword.setHint(getString(R.string.password_fr));
                btnLogin.setText(getString(R.string.login_fr));
                tvSignup.setText(getString(R.string.no_account_fr));
                tvVi.setText(getString(R.string.vi_fr));
                tvEn.setText(getString(R.string.en_fr));
                tvFr.setText(getString(R.string.fr_fr));
                break;
            default:
                setTitle(getString(R.string.app_name_en));
                toolbar.setTitle(getString(R.string.app_name_en));
                tvTitle.setText(getString(R.string.title_en));
                edtEmail.setHint(getString(R.string.email_en));
                edtPassword.setHint(getString(R.string.password_en));
                btnLogin.setText(getString(R.string.login_en));
                tvSignup.setText(getString(R.string.no_account_en));
                tvVi.setText(getString(R.string.vi_en));
                tvEn.setText(getString(R.string.en_en));
                tvFr.setText(getString(R.string.fr_en));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_lang, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mnu_vi) { setLang("vi"); return true; }
        if (id == R.id.mnu_en) { setLang("en"); return true; }
        if (id == R.id.mnu_fr) { setLang("fr"); return true; }
        return super.onOptionsItemSelected(item);
    }
}
