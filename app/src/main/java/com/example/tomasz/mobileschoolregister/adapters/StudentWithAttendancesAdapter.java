package com.example.tomasz.mobileschoolregister.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.tomasz.mobileschoolregister.EditAttendanceActivity;
import com.example.tomasz.mobileschoolregister.R;
import com.example.tomasz.mobileschoolregister.model.Attendance;
import com.example.tomasz.mobileschoolregister.model.Student;

import java.util.List;

/**
 * Created by Tomasz on 21-Jan-18.
 */

public class StudentWithAttendancesAdapter extends BaseExpandableListAdapter {
    private Activity context;
    private List<Student> students;
    private static LayoutInflater inflater = null;

    public StudentWithAttendancesAdapter(Activity context, List<Student> students) {
        this.context = context;
        this.students = students;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getGroupCount() {
        return students.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return students.get(i).getAttendances().size();
    }

    @Override
    public Object getGroup(int i) {
        return students.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return students.get(i).getAttendances().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        View itemView = view;
        itemView = (itemView == null)? inflater.inflate(R.layout.student_attendances_group_item, null): itemView;
        TextView textViewFullName =  itemView.findViewById(R.id.lblStudentAttendancesGroup);

        Student selectedStudent = students.get(i);
        textViewFullName.setText(selectedStudent.getLastName() + " " + selectedStudent.getFirstName());
        return itemView;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        View itemView = view;

        itemView = (itemView == null)? inflater.inflate(R.layout.student_attendances_child_item, null): itemView;
        TextView textViewDate = itemView.findViewById(R.id.lblStudentAttendancesListItem);
        final Attendance attendance = students.get(i).getAttendances().get(i1);

        int backgroundColor = attendance.getWasPresent() ? Color.GREEN : Color.RED;
        itemView.setBackgroundColor(backgroundColor);
        textViewDate.setText(attendance.getLesson().getDate().toString());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EditAttendanceActivity.class);
                intent.putExtra("attendance", attendance);
                context.startActivity(intent);
                context.finish();
            }
        });
        return itemView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
