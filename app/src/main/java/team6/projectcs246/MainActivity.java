package team6.projectcs246;

import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    public String TAG;

    //Views and Widget Fields
    Button createUser, moveToLogin;
    EditText userEmailEdit, userPassWordEdit;




    public void onCreate() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "The app started");

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

/*
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };
        */

        // Assign ID
        createUser = (Button) findViewById(R.id.createUserBtn);
        moveToLogin = (Button) findViewById(R.id.moveToLogin);
        userEmailEdit = (EditText) findViewById(R.id.emailEditTextCreate);
        userPassWordEdit = (EditText) findViewById(R.id.passEditTextCreate);

        //Assign Instances
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {


            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user != null) {


                } else {

                }
            }
        };

        // On Click Listeners

        createUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userEmailString, userPassString;
                userEmailString = userEmailEdit.getText().toString().trim();
                userPassString  = userPassWordEdit.getText().toString().trim();

                if(!TextUtils.isEmpty(userEmailString) && !TextUtils.isEmpty(userPassString)){

                    mAuth.createUserWithEmailAndPassword(userEmailString, userPassString).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                       if(task.isSuccessful()){
                           Toast.makeText(MainActivity.this, "User Account Created", Toast.LENGTH_LONG).show();
                           startActivity(new Intent(MainActivity.this, Progress.class));
                       }
                       else {
                           Toast.makeText(MainActivity.this, "Failed to create user account", Toast.LENGTH_SHORT).show();
                       }

                        }
                    });
                }

            }
        });
        // Move to Login
        moveToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, Login.class));
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
        if(mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    public void getProgress(View theButton){
        startActivity(new Intent(MainActivity.this, Progress.class));
    }

}