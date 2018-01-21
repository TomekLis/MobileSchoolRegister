package com.example.tomasz.mobileschoolregister.helper;

import com.example.tomasz.mobileschoolregister.model.Course;
import com.example.tomasz.mobileschoolregister.model.DaySchedule;
import com.example.tomasz.mobileschoolregister.model.StudentGroup;
import com.example.tomasz.mobileschoolregister.model.Teacher;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Tomasz on 21-Jan-18.
 */

public class CustomTeacherDeserializer implements JsonDeserializer<Teacher> {
    @Override
    public Teacher deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonElement content = json.getAsJsonObject();
        JsonArray serializedCourses = ((JsonObject) content).get("UpcomingCourses").getAsJsonArray();
        ArrayList<Course> courses = new ArrayList<>();
        for (JsonElement jsonElement:
                serializedCourses) {
            Course course = new Gson().fromJson(jsonElement, Course.class);

            course.setName(((JsonObject) jsonElement).get("Name").getAsString());
            StudentGroup studentGroup = new StudentGroup();

            studentGroup.setId(((JsonObject) jsonElement).get("StudentsGroupId").getAsInt());
            course.setStudentGroup(studentGroup);

            JsonArray serializedDaySchedules = ((JsonObject) jsonElement).get("DaySchedules").getAsJsonArray();
            ArrayList<DaySchedule> daySchedules = new ArrayList<>();

            for(JsonElement jsonNestedElement:
                    serializedDaySchedules){
                DaySchedule daySchedule = new Gson().fromJson(jsonNestedElement, DaySchedule.class);
                daySchedules.add(daySchedule);
            }
            course.setDaySchedules(daySchedules);
            courses.add(course);
        }
        // Deserialize it. You use a new instance of Gson to avoid infinite recursion
        // to this deserializer
        Teacher teacher = new Gson().fromJson(content, Teacher.class);
        teacher.setUpcomingCourses(courses);
        return teacher;
    }
}
