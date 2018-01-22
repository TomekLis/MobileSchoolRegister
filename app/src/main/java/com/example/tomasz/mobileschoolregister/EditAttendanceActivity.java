package com.example.tomasz.mobileschoolregister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tomasz.mobileschoolregister.interfaces.IFetchDataCallback;
import com.example.tomasz.mobileschoolregister.model.Attendance;
import com.example.tomasz.mobileschoolregister.service.DeleteAttendanceService;
import com.example.tomasz.mobileschoolregister.service.SaveEditedAttendanceService;

public class EditAttendanceActivity extends AppCompatActivity implements IFetchDataCallback{

    private Attendance attendance;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_attendance);
        spinner = findViewById(R.id.wasPresentSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.presence_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        attendance = (Attendance) getIntent().getExtras().get("attendance");

        int spinnerSelection = attendance.getWasPresent() ? 0:1;
        spinner.setSelection(spinnerSelection);


        TextView dateTextView = findViewById(R.id.edtiAttendanceDateTextView);
        dateTextView.setText("Edycja");

        ImageButton saveAttendanceButton = findViewById(R.id.saveAttendanceButton);
        saveAttendanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveEditedAttendance();
            }
        });

        ImageButton deleteAttendanceButton = findViewById(R.id.deleteAttendanceButton);
        deleteAttendanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteAttendance();
            }
        });
    }

    private void deleteAttendance() {
        DeleteAttendanceService deleteAttendanceService= new DeleteAttendanceService(this, attendance, this);
        deleteAttendanceService.execute();
    }

    private void saveEditedAttendance() {
        Boolean wasPresent = spinner.getSelectedItemPosition() == 0 ? true:false;
        attendance.setWasPresent(wasPresent);
        SaveEditedAttendanceService saveEditedAttendanceService = new SaveEditedAttendanceService(this, attendance, this);
        saveEditedAttendanceService.execute();
    }

    @Override
    public void fetchDataCallback(Object object) {
        
    }
}
