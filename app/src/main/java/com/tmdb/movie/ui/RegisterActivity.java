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

public class RegisterActivity extends AppCompatActivity {
    Intent next_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        next_activity=new Intent(this,LoginActivity.class);

        final EditText user_field=(EditText)findViewById(R.id.username);
        final EditText password_field=(EditText)findViewById(R.id.Password);
        final EditText confirm_password_field=(EditText)findViewById(R.id.confirm_password);
        Button registerbutton=(Button)findViewById(R.id.register);
        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user_id=user_field.getText().toString();
                String password_1=password_field.getText().toString();
                String password_2=confirm_password_field.getText().toString();
                if(password_1.equals(password_2))
                {
                    //your code to register the user like an entry in the database
                    SharedPreferences sharedPreferences=getSharedPreferences("USER_CREDENTIALS",MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("USERNAME",user_id);
                    editor.putString("PASSWORD",password_1);
                    editor.putBoolean("ISLOGGEDIN",true);
                    editor.commit();
                    startActivity(next_activity);
                }
                else
                {
                    Toast.makeText(RegisterActivity.this,"Passwords don't match", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
