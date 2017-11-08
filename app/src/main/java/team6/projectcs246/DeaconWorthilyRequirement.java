package team6.projectcs246;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DeaconWorthilyRequirement extends AppCompatActivity implements RequirementInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deacon_worthily_requirement);
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

}
