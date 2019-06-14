package com.tmdb.movie.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tmdb.movie.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final SharedPreferences sharedPreferences=getSharedPreferences("USER_CREDENTIALS",MODE_PRIVATE);
        final Boolean isloggedin=sharedPreferences.getBoolean("ISLOGGEDIN",false);
        if(isloggedin)
        {
            Intent main = new Intent(LoginActivity.this, MovieActivity.class);
            startActivity(main);
        }
        final String required_email=sharedPreferences.getString("USERNAME","DEFAULT_USER");
        final String required_password=sharedPreferences.getString("PASSWORD","DEFAULT_PASSWORD");
        final EditText user_field=(EditText)findViewById(R.id.login_user);
        final EditText password_field=(EditText)findViewById(R.id.login_password);
        Button login=(Button)findViewById(R.id.login_button);
        Button register=(Button)findViewById(R.id.register_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=user_field.getText().toString();
                String password=password_field.getText().toString();
                if(email.equals(required_email)&&password.equals(required_password)) {
                    sharedPreferences.edit().putBoolean("ISLOGGEDIN",false).commit();
                    Intent main = new Intent(LoginActivity.this, MovieActivity.class);
                    startActivity(main);
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"Username  or password is incorrect",Toast.LENGTH_LONG).show();
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(register);
                finish();
            }
        });



    }
}
