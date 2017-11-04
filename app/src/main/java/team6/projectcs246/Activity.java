package team6.projectcs246;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Activity implements DeaconforStrengthofYouth, DeaconPriesthoodDuties, DeaconSpiritualStrength {
    private String actGoals;
    private String shareNotes;
    private boolean isComplete;
    private boolean isSigned;

    public String getActGoals() {
        return actGoals;
    }

    public void setActGoals(String goals) {
        actGoals=goals;
    }

    public String getShareNotes() {
        return shareNotes;
    }

    public void setShareNotes(String notes) {
        shareNotes=notes;
    }

    public boolean getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(boolean isComp) {
        isComplete=isComp;
    }

    public void saveGoals() {
    }

    public void saveNotes() {
    }

    public void displayLearn() {
    }

    public void setSigned(boolean isSign) {
        isSigned=isSign;
    }

    public boolean getSigned() {
        return isSigned;
    }
}
