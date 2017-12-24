package com.example.tomasz.mobileschoolregister.model;

/**
 * Created by Tomasz on 23-Dec-17.
 */

public class Attendance extends StudentActivity{
    private boolean wasPresent;

    public boolean isWasPresent() {
        return wasPresent;
    }

    public void setWasPresent(boolean wasPresent) {
        this.wasPresent = wasPresent;
    }
}
