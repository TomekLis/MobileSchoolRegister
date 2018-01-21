package com.example.tomasz.mobileschoolregister;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

import com.example.tomasz.mobileschoolregister.adapters.StudentAdapter;
import com.example.tomasz.mobileschoolregister.helper.Token;
import com.example.tomasz.mobileschoolregister.helper.TokenHolder;
import com.example.tomasz.mobileschoolregister.helper.ViewHelper;
import com.example.tomasz.mobileschoolregister.interfaces.IFetchDataCallback;
import com.example.tomasz.mobileschoolregister.model.Attendance;
import com.example.tomasz.mobileschoolregister.model.Course;
import com.example.tomasz.mobileschoolregister.model.Lesson;
import com.example.tomasz.mobileschoolregister.model.Student;
import com.example.tomasz.mobileschoolregister.service.CreateLessonService;
import com.example.tomasz.mobileschoolregister.service.LessonServiceExecutor;
import com.example.tomasz.mobileschoolregister.service.StudentService;

import java.util.ArrayList;
import java.util.List;

public class AttendanceListCheckAcivity extends AppCompatActivity implements IFetchDataCallback {

    private ListView listViewStudentsAttendances;
    private ArrayList<Student> students = new ArrayList<>();
    private StudentAdapter adapter;
    private Course course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_list_check);
        populateListView();
        Intent sourceIntent = getIntent();
        Bundle data = getIntent().getExtras();
        course = (Course) data.getParcelable("course");

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
        course.getStudentGroup().setStudents(students);
        renderStudentsAttendancesData();
    }

    private void renderStudentsAttendancesData() {
        adapter = new StudentAdapter(this, students);
        listViewStudentsAttendances.setAdapter(adapter);
        final FloatingActionButton saveLessonAttendancesButton = (FloatingActionButton) findViewById(R.id.saveLesson);
        saveLessonAttendancesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveLessonAttendances();
            }
        });

    }

    private void saveLessonAttendances() {
        Lesson lesson = new Lesson();
        for (int i = 0; i < course.getStudentGroup().getStudents().size(); i++) {
            View studentViewAttendance = ViewHelper.getViewByPosition(i, listViewStudentsAttendances);
            Student student = course.getStudentGroup().getStudents().get(i);
            CheckBox checkBoxAttendance = (CheckBox) studentViewAttendance.findViewById(R.id.checkBoxAttendance);
            Attendance attendance = new Attendance();
            attendance.setWasPresent(checkBoxAttendance.isChecked());
            ArrayList<Attendance> attendances = new ArrayList<>();
            attendances.add(attendance);
            student.setAttendances(attendances);
            course.getStudentGroup().getStudents().set(i, student);
        }


        lesson.setCourse(course);
        CreateLessonService createLessonService = new CreateLessonService(lesson, this);
        LessonServiceExecutor lessonServiceExecutor = new LessonServiceExecutor(createLessonService);
        lessonServiceExecutor.execute();
    }
}
