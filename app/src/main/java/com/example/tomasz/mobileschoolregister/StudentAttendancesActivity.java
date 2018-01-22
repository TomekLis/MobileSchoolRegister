package com.example.tomasz.mobileschoolregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ListView;

import com.example.tomasz.mobileschoolregister.adapters.StudentWithAttendancesAdapter;
import com.example.tomasz.mobileschoolregister.helper.TokenHolder;
import com.example.tomasz.mobileschoolregister.interfaces.IFetchDataCallback;
import com.example.tomasz.mobileschoolregister.model.Student;
import com.example.tomasz.mobileschoolregister.service.StudentActivityService;

import java.util.List;

public class StudentAttendancesActivity extends AppCompatActivity implements IFetchDataCallback{

    private StudentWithAttendancesAdapter studentWithAttendancesAdapter;

    ExpandableListView studentAttendances;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_attendances);
        PrepareStudentAttendancesData();
         studentAttendances = findViewById(R.id.StudentAttendancesListView);

    }

    private void PrepareStudentAttendancesData() {
        String teacherId = TokenHolder.getInstance().getSecurityToken().getUserId();
        StudentActivityService service = new StudentActivityService(this, teacherId);
        service.execute();
    }

    @Override
    public void fetchDataCallback(Object result) {
        List<Student> students = (List<Student>) result;
        studentWithAttendancesAdapter = new StudentWithAttendancesAdapter(this,students);
        studentAttendances.setAdapter(studentWithAttendancesAdapter);
    }

}
