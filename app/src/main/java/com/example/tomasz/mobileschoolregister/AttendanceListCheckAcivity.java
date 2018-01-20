package com.example.tomasz.mobileschoolregister;

import android.media.session.MediaSession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.tomasz.mobileschoolregister.R;
import com.example.tomasz.mobileschoolregister.adapters.StudentAdapter;
import com.example.tomasz.mobileschoolregister.api.ApiConnector;
import com.example.tomasz.mobileschoolregister.api.IStudentClient;
import com.example.tomasz.mobileschoolregister.api.ITeacherClient;
import com.example.tomasz.mobileschoolregister.helper.Token;
import com.example.tomasz.mobileschoolregister.helper.TokenHolder;
import com.example.tomasz.mobileschoolregister.interfaces.IFetchDataCallback;
import com.example.tomasz.mobileschoolregister.model.Student;
import com.example.tomasz.mobileschoolregister.model.Teacher;
import com.example.tomasz.mobileschoolregister.service.StudentService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class AttendanceListCheckAcivity extends AppCompatActivity implements IFetchDataCallback {

    private ListView listViewStudentsAttendances;
    private ArrayList<Student> students = new ArrayList<>();
    private StudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_list_check);
        populateListView();
    }

    private void populateListView() {
        listViewStudentsAttendances = (ListView) findViewById(R.id.listViewStudentsAttendances);
        Token token = TokenHolder.getInstance().getSecurityToken();

        StudentService studentService = new StudentService(token, this);
        studentService.execute();
    }

    @Override
    public void fetchDataCallback(Object result) {
        students = (ArrayList<Student>)result;
        renderStudentsAttendancesData();
    }

    private void renderStudentsAttendancesData() {
        adapter = new StudentAdapter(this, students);
        listViewStudentsAttendances.setAdapter(adapter);
    }
}
