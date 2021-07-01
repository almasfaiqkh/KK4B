package com.xirpl4.project_kk4b;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class Daftar extends AppCompatActivity {

    TextView masuk;
    View daftar;
    EditText etNama, etEmail, etPassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        mAuth = FirebaseAuth.getInstance();

        masuk = (TextView) findViewById(R.id.loginindatar_button);

        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Daftar.this, Login.class));
            }
        });

        daftar = (View) findViewById(R.id.daftar_button);
        etNama = findViewById(R.id.etdaftar_nama);
        etEmail = findViewById(R.id.etdaftar_email);
        etPassword = findViewById(R.id.etdaftar_password);

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                final String nama = etNama.getText().toString();

                if (email.equals("")) {
                    Toast.makeText(Daftar.this, "Silahkan isi email Anda",
                            Toast.LENGTH_SHORT).show();
                } else if (password.equals("")) {
                    Toast.makeText(Daftar.this, "Silahkan isi password Anda",
                            Toast.LENGTH_SHORT).show();
                } else {
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Daftar.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder().setDisplayName(nama).build();
                                        user.updateProfile(profileUpdates);
                                        Toast.makeText(Daftar.this, "Authentication success.",
                                                Toast.LENGTH_SHORT).show();
                                        finish();
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(Daftar.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
    }
}
