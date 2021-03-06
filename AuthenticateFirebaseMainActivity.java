package com.example.authenticatloginreg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    //login
    EditText email,password;
    Button btnlogin,btnRegister;


    //Declare the variable  (create object)
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create the object regiatration
        mAuth = FirebaseAuth.getInstance();
        //create object login
        email=findViewById(R.id.txtemail);
        password=findViewById(R.id.txtpassword);
        btnlogin=findViewById(R.id.btnlogin);
        btnRegister=findViewById(R.id.btnregister);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information

                                    FirebaseUser user = mAuth.getCurrentUser();
                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user
                                    String error=task.getException().getMessage();
                                    Toast.makeText(MainActivity.this,error,
                                            Toast.LENGTH_SHORT).show();
                                    updateUI(null);
                                }


                            }
                        });


            }
        });



        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information

                                    FirebaseUser user = mAuth.getCurrentUser();
                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                            String error=task.getException().getMessage();
                                    Toast.makeText(MainActivity.this, error,
                                            Toast.LENGTH_SHORT).show();
                                    updateUI(null);
                                }


                            }
                        });

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    //create the updateUi method and go to the second activity
    public void updateUI(FirebaseUser currentUser)
    {
        if(currentUser!=null)
        {
            Intent i =new Intent(getApplicationContext(),Welcome.class);
            startActivity(i);
        }
    }
}
