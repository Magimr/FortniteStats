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

public class RegistroActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    Context context;
    String email;
    String password;
    EditText txtEmail;
    EditText txtPass;
    Button btnRegistro;
    TextView txtRegistrado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        context = this;
        txtEmail = findViewById(R.id.txtEmail);
        txtPass = findViewById(R.id.txtPass);
        btnRegistro = findViewById(R.id.btnRegistro);
        txtRegistrado = findViewById(R.id.txtRegistrado);
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registro();
            }
        });

        txtRegistrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
    }

    private void registro() {
        email = txtEmail.getText().toString().trim();
        password = txtPass.getText().toString().trim();
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(RegistroActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Log.d("REGISTRO", "createUserWithEmail:onComplete:" + task.isSuccessful());


                            Intent intent = new Intent(context, LoginActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(context, "Refistro fallido." + task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
