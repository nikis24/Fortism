package com.example.fortism;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity {

   private EditText name,contact,password,password2,email;
    private Button signIn;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        auth = FirebaseAuth.getInstance();
        name = findViewById(R.id.regName);
        contact = findViewById(R.id.regContact);
        password = findViewById(R.id.regPassword);
        password2 = findViewById(R.id.regPassword2);
        signIn= findViewById(R.id.regSignin);
        email = findViewById(R.id.regEmail);


        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String Name = name.getText().toString();
                final   String mail = email.getText().toString();
                final   String pwd = password.getText().toString();
                final String pwd2 = password2.getText().toString();
                final String Contact = contact.getText().toString();

        if(mail.isEmpty() || pwd.isEmpty() || pwd2.isEmpty() || Contact.isEmpty() || Name.isEmpty())
        {
            Toast.makeText(Main2Activity.this,"Check All Fields!",Toast.LENGTH_SHORT).show();
        }else
        {




                    auth.createUserWithEmailAndPassword(mail,pwd2).addOnCompleteListener(Main2Activity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(Main2Activity.this, "Registered Successfully", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(Main2Activity.this, "Registered failed", Toast.LENGTH_LONG).show();
                            }

                        }

                    });
                }


        }});

        }

}


