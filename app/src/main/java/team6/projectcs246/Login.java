package team6.projectcs246;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    //Views and widget fields
    Button loginBtn, createAccount;
    EditText userEmailEdit, userPasswordEdit;

    // String fields
    String userEmailString, userPasswordString;

    //FireBase Authentication Fields
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Assign IDs
        loginBtn = (Button) findViewById(R.id.loginBtn);
        createAccount = (Button) findViewById(R.id.createAccount);
        userEmailEdit = (EditText) findViewById(R.id.loginEmailEditText);
        userPasswordEdit = (EditText) findViewById(R.id.loginPassWordEditText);


        //Assign Instances
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {


            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user != null) {


                } else {
                    startActivity(new Intent(Login.this, Progress.class));
                }
            }
        };
        // On click listner
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //perform login
                userEmailString = userEmailEdit.getText().toString().trim();
                userPasswordString = userPasswordEdit.getText().toString().trim();

                mAuth.createUserWithEmailAndPassword(userEmailString, userPasswordString).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(Login.this, Progress.class));
                        } else {
                            Toast.makeText(Login.this, "Failed to login", Toast.LENGTH_SHORT).show();
                        }

                    }

                });

            }
        });

        //move to create Login
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Login.this, MainActivity.class));
            }
        });


    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}