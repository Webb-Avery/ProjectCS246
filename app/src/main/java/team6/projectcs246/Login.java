package team6.projectcs246;


import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private Button buttonSignin;
    private EditText editEmailText, editPasswordText;
    private TextView textViewSignup;
    private FirebaseAuth firebaseAuth;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInsanceState) {
        super.onCreate(savedInsanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth =FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() !=null){
            finish();
            startActivity(new Intent(getApplicationContext(), Progress.class));
        }

        editEmailText = (EditText) findViewById(R.id.editTextEmail);
        editPasswordText = (EditText) findViewById(R.id.editTextPassword);
        buttonSignin = (Button) findViewById(R.id.signIn);
        textViewSignup = (TextView) findViewById(R.id.textViewSignin);

        buttonSignin.setOnClickListener(this);
        textViewSignup.setOnClickListener(this);


    }

private void userLogin(){

        String email = editEmailText.getText().toString().trim();
        String password=editPasswordText.getText().toString().trim();

    if (TextUtils.isEmpty(email)) {
        //email is empty
        Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
        //stop the method
        return;
    }
    if (TextUtils.isEmpty(password)) {
        //password is empty
        Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
        return;
    }

    progressDialog.setMessage("Loading");
    progressDialog.show();

    firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progressDialog.dismiss();
                    if (task.isSuccessful()) {
                        finish();
                        startActivity(new Intent(getApplicationContext(), Progress.class));

                    }else
                        Toast.makeText(Login.this, "Login failed, please try again", Toast.LENGTH_SHORT).show();
                }
            });


}
    @Override
    public void onClick(View view) {
        if(view == buttonSignin){
            userLogin();

        }
        if(view == textViewSignup){
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }

    }
}
