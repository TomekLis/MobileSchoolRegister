package com.example.tomasz.mobileschoolregister.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tomasz.mobileschoolregister.R;
import com.example.tomasz.mobileschoolregister.model.Course;

import java.util.ArrayList;

/**
 * Created by Tomasz on 21-Jan-18.
 */

public class UpcomingClassesAdapter extends BaseAdapter {
    private Activity context;
    private ArrayList<Course> courses;
    private static LayoutInflater inflater = null;

    public UpcomingClassesAdapter(Activity context, ArrayList<Course> courses) {
        this.context = context;
        this.courses = courses;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return courses.size();
    }

    @Override
    public Object getItem(int i) {
        return courses.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        itemView = (itemView == null)? inflater.inflate(R.layout.upcoming_course_list_item, null): itemView;
        TextView textViewCourseName = itemView.findViewById(R.id.CourseName);
        Course selectedCourse = courses.get(i);
        textViewCourseName.setText(selectedCourse.getName());
        return itemView;
    }
}
