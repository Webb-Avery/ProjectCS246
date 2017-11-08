package team6.projectcs246;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Progress extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
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
        Log.d("ProgressActivity", "Attempting to create intent to get Administer Activity ");

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