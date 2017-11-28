package team6.projectcs246;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DeaconAdministerRequirement extends AppCompatActivity implements RequirementInterface {

    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    String user = "Avery";
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_deacon_administer_requirement);
        }

        boolean complete;

        @Override
        public Boolean getIsComplete(){
            return complete;
        }

        @Override
        public void setIsComplete(Boolean complete) {
            this.complete = complete;
        }

        public void updateComplete(View view) {

            ref.child("users").child(user).child("requirements").child("administerRequirement").setValue("true");
        }
    }

