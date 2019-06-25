package com.rathana.fragment_demo;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.btnLogin)
    Button btnLogin;

    @BindString(R.string.content)
    String content;

    @BindDrawable(R.drawable.ic_launcher_background)
    Drawable img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        //content=getResources().getString(R.string.content);

//        btnLogin.setOnClickListener(v->{
////            Toast.makeText(this, "username "+username.getText().toString()+
////                    "\npassword "+password.getText().toString(), Toast.LENGTH_SHORT).show();
////        });

    }

    @OnClick(R.id.btnLogin)
    public void onLogin(){
        Toast.makeText(this, "username "+username.getText().toString()+
                    "\npassword "+password.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}
