package com.example.fortnitestats;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    Context context;
    String email;
    String password;
    EditText txtEmail;
    EditText txtPass;
    Button btnLog;
    TextView txtRegistro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context = this;
        txtEmail = findViewById(R.id.txtEmail);
        txtPass = findViewById(R.id.txtPass);
        btnLog = findViewById(R.id.btnLog);
        txtRegistro = findViewById(R.id.txtRegistro);
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        txtRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,RegistroActivity.class);
                startActivity(intent);
            }
        });



    }

    private void login(){
        email = txtEmail.getText().toString().trim();
        password = txtPass.getText().toString().trim();
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Log.d("FIREBASE LOGIN", "signInWithEmail:success");
                            Intent intent = new Intent(context, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {

                            Log.w("FIREBASE LOGIN", "signInWithEmail:failure", task.getException());
                            Toast.makeText(context, "Datos de inicio de sesión incorrectos.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


}
