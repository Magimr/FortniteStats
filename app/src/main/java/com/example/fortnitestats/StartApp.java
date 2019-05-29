package com.example.fortnitestats;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StartApp extends AppCompatActivity { //SPLASH

    Context context;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_app);

        context = this;
        firebaseAuth = FirebaseAuth.getInstance();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() { //COMPROBAR SI ESTA REGISTRADO
                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user != null) { //MAIN (SI ESTA LOGUEADO)
                    Intent intent = new Intent(context, MainActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 1500);
    }
}
