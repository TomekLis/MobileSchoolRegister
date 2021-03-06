package com.example.tomasz.mobileschoolregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tomasz.mobileschoolregister.adapters.UpcomingClassesAdapter;
import com.example.tomasz.mobileschoolregister.helper.Logout;
import com.example.tomasz.mobileschoolregister.helper.Token;
import com.example.tomasz.mobileschoolregister.interfaces.IFetchDataCallback;
import com.example.tomasz.mobileschoolregister.model.Course;
import com.example.tomasz.mobileschoolregister.model.Teacher;
import com.example.tomasz.mobileschoolregister.service.TeacherService;

public class TeacherMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, IFetchDataCallback{

    private Token securityToken;
    private TeacherService teacherService;
    private UpcomingClassesAdapter upcomingClassesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fabCreateLesson = (FloatingActionButton) findViewById(R.id.create_lesson);
        fabCreateLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAttendancesList();
            }
        });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        PrepareTeacherData();
    }
    private void logoutUser() {
        Logout.Logout(this);
    }

    private void checkAttendancesList() {
        Intent intent = new Intent(TeacherMainActivity.this, AttendanceListCheckAcivity.class);
        Course course = (Course) upcomingClassesAdapter.getItem(0);
        intent.putExtra("course", course);
        startActivity(intent);
    }

    private void PrepareTeacherData() {
        Intent sourceIntent = getIntent();
        securityToken = (Token)sourceIntent.getSerializableExtra("token");
        teacherService = new TeacherService(securityToken, this);
        teacherService.execute();
    }

    @Override
    public void fetchDataCallback(Object result) {
        Teacher teacher = (Teacher)result;
        renderTeacherData(teacher);
    }

    private void renderTeacherData(Teacher teacher) {
        TextView teacherFullNameTextView = (TextView) findViewById(R.id.teacher_nav_header_name);
        teacherFullNameTextView.setText(teacher.getFullName());
        upcomingClassesAdapter = new UpcomingClassesAdapter(this,teacher.getUpcomingCourses());
        ListView upcommingClasses =  (ListView) findViewById(R.id.upcoming_courses_list);
        upcommingClasses.setAdapter(upcomingClassesAdapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem logout = menu.getItem(0);
        logout.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                logoutUser();
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_my_schedule) {
            // Handle the camera action
        } else if (id == R.id.nav_student_marks) {

        } else if (id == R.id.nav_student_attendances) {
            Intent intent = new Intent(TeacherMainActivity.this, StudentAttendancesActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
