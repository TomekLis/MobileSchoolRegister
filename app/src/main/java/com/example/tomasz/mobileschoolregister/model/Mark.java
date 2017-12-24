package com.example.tomasz.mobileschoolregister.model;

/**
 * Created by Tomasz on 23-Dec-17.
 */

public class Mark extends StudentActivity{
    private MarkValue markValue;
    private Importance importance;

    public MarkValue getMarkValue() {
        return markValue;
    }

    public void setMarkValue(MarkValue markValue) {
        this.markValue = markValue;
    }

    public Importance getImportance() {
        return importance;
    }

    public void setImportance(Importance importance) {
        this.importance = importance;
    }
}
