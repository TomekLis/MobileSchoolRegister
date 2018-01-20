package com.example.tomasz.mobileschoolregister.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tomasz.mobileschoolregister.R;
import com.example.tomasz.mobileschoolregister.model.Student;

import java.util.ArrayList;

/**
 * Created by Tomasz on 19-Jan-18.
 */

public class StudentAdapter extends BaseAdapter{
    private Activity context;
    private ArrayList<Student> students;
    private static LayoutInflater inflater = null;

    public StudentAdapter(Activity context, ArrayList<Student> students){
        this.context = context;
        this.students =   students;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        itemView = (itemView == null)? inflater.inflate(R.layout.student_attendance_list_item, null): itemView;
        TextView textViewLastName = (TextView) itemView.findViewById(R.id.AttendancesStudentLastName);
        TextView textViewFirstName = (TextView) itemView.findViewById(R.id.AttendancesStudentFirstName);
        Student selectedStudent = students.get(i);
        textViewLastName.setText(selectedStudent.getLastName());
        textViewFirstName.setText(selectedStudent.getFirstName());
        return itemView;
    }
}
