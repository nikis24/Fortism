package com.example.fortism;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText emailId,password;
    Button btnlogin,btnsignup;

    FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId= findViewById(R.id.email);
        password = findViewById(R.id.password);
        btnlogin = findViewById(R.id.loginBtn);
        btnsignup = findViewById(R.id.signupBtn);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = emailId.getText().toString();
                String pwd = password.getText().toString();
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(MainActivity.this,"Please enter the email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(pwd)) {
                    Toast.makeText(MainActivity.this, "Please enter the Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                else
                {
                    mFirebaseAuth.signInWithEmailAndPassword(email, pwd)
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {

                                Intent intent =  new Intent(MainActivity.this, Main3Activity.class);
                                startActivity(intent);
                                Toast.makeText(MainActivity.this, "Login successful",Toast.LENGTH_LONG).show();


                            }else
                            {

                                Toast.makeText(MainActivity.this, "Failed",Toast.LENGTH_LONG).show();

                            }

                        }
                    });
                }


            }
        });

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent =  new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                finish();

            }
        });




    }
    public void Login ()  {
        Intent intent =  new Intent(this, Main3Activity.class);
        startActivity(intent);

        }

    @Override
    public void onClick(View v) {

    }
}





