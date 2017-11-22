package team6.projectcs246;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Progress extends AppCompatActivity {


    ProgressBar mPrayProgress;
    TextView mPrayText;
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mPrayRef  = ref.child("users").child("Avery").child("requirements").child("prayRequirement");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        mPrayProgress = (ProgressBar)findViewById(R.id.prayProgress);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("progress", "onStart");

        mPrayRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String progress = dataSnapshot.getValue(String.class);
                Toast.makeText(Progress.this, progress, Toast.LENGTH_SHORT).show();
                int progressNum = 0;
                try {
                    progressNum = Integer.parseInt(progress);
                } catch (NumberFormatException nfe) {}
                mPrayProgress.setProgress(progressNum);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {


            }
        });

   }

    // Pray Requirement
    public void getPray(View theButton) {
        Log.d("ProgressActivity", "Attempting to create intent to get Pray Activity ");

        Intent requirementIntent = new Intent(this, DeaconPrayRequirement.class);
        startActivity(requirementIntent);
    }

    // Worthily Requirement
    public void getWorthily(View theButton) {
        Log.d("ProgressActivity", "Attempting to create intent to get Worthily Activity ");

        Intent requirementIntent = new Intent(this, DeaconWorthilyRequirement.class);
        startActivity(requirementIntent);
    }

    // Doctrine Requirement
    public void getDoctrine(View theButton) {
        Log.d("ProgressActivity", "Attempting to create intent to get Doctrine Activity ");

        Intent requirementIntent = new Intent(this, DeaconDoctrineRequirement.class);
        startActivity(requirementIntent);
    }

    // Administer Requirement
    public void getAdminister(View theButton) {


        Intent requirementIntent = new Intent(this, DeaconAdministerRequirement.class);
        startActivity(requirementIntent);
    }

    // Serve Requirement
    public void getServe(View theButton) {
        Log.d("ProgressActivity", "Attempting to create intent to get Serve Activity ");

        Intent requirementIntent = new Intent(this, DeaconServeRequirement.class);
        startActivity(requirementIntent);
    }

    // Invite Requirement
    public void getInvite(View theButton) {
        Log.d("ProgressActivity", "Attempting to create intent to get Invite Activity ");

        Intent requirementIntent = new Intent(this, DeaconInviteRequirement.class);
        startActivity(requirementIntent);
    }

    // Create Project Requirement
    public void getCreateProject(View theButton) {
        Log.d("ProgressActivity", "Attempting to create intent to get CreateProject Activity ");

        Intent requirementIntent = new Intent(this, DeaconCreateProjectRequirement.class);
        startActivity(requirementIntent);
    }

    // Project Requirement
    public void getProject(View theButton) {
        Log.d("ProgressActivity", "Attempting to create intent to get Project Activity ");

        Intent requirementIntent = new Intent(this, DeaconProjectRequirement.class);
        startActivity(requirementIntent);
    }

}