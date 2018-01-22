package com.example.tomasz.mobileschoolregister.helper;

import com.example.tomasz.mobileschoolregister.model.Attendance;
import com.example.tomasz.mobileschoolregister.model.Course;
import com.example.tomasz.mobileschoolregister.model.DaySchedule;
import com.example.tomasz.mobileschoolregister.model.Lesson;
import com.example.tomasz.mobileschoolregister.model.Mark;
import com.example.tomasz.mobileschoolregister.model.Student;
import com.example.tomasz.mobileschoolregister.model.StudentActivity;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Tomasz on 21-Jan-18.
 */

public class CustomStudentWithActivitiesDeserlializer implements JsonDeserializer<List<Student>> {
    private DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
    @Override
    public List<Student> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        List<Student> students = new ArrayList<>();
        JsonArray serializedStudentArray = json.getAsJsonArray();

        for (JsonElement serializedStudent :
                serializedStudentArray) {

            Student student = new Gson().fromJson(serializedStudent, Student.class);
            JsonElement serializedAttendances = ((JsonObject) serializedStudent).get("Attendances");

            if(!serializedAttendances.isJsonNull()) {

                JsonArray serializedAttendancesNotNull = serializedAttendances.getAsJsonArray();
                ArrayList<Attendance> attendances = new ArrayList<>();

                for (JsonElement serializedAttendance :
                        serializedAttendancesNotNull) {
                    Attendance attendance = new Gson().fromJson(serializedAttendance, Attendance.class);

                    StudentActivity studentActivityToDeserialize = DeserializeStudentActivityPart(serializedAttendance);
                    attendance.setId(studentActivityToDeserialize.getId());
                    attendance.setLesson(studentActivityToDeserialize.getLesson());

                    attendances.add(attendance);
                }
                student.setAttendances(attendances);
            }
            JsonElement serializedMarks = ((JsonObject) serializedStudent).get("Marks");

            if(!serializedMarks.isJsonNull()) {

                JsonArray serializedMarksNotNull =  serializedMarks.getAsJsonArray();
                ArrayList<Mark> marks = new ArrayList<>();

                for (JsonElement serializedMark :
                        serializedMarksNotNull) {
                    Mark mark = new Gson().fromJson(serializedMark, Mark.class);

                    StudentActivity studentActivityToDeserialize = DeserializeStudentActivityPart(serializedMark);
                    mark.setId(studentActivityToDeserialize.getId());
                    mark.setLesson(studentActivityToDeserialize.getLesson());

                    marks.add(mark);
                }
                student.setMarks(marks);
            }
            students.add(student);
        }
        return students;
    }

    private StudentActivity DeserializeStudentActivityPart(JsonElement jsonElement) {
        JsonObject serializedLesson = ((JsonObject) jsonElement).get("Lesson").getAsJsonObject();
        StudentActivity studentActivity = new Gson().fromJson(jsonElement, StudentActivity.class);

        Lesson lesson = new Gson().fromJson(serializedLesson, Lesson.class);
        lesson.setId(serializedLesson.get("Id").getAsInt());
        try {
            if(!serializedLesson.get("Date").isJsonNull())
            lesson.setDate(format.parse(serializedLesson.get("Date").getAsString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        studentActivity.setLesson(lesson);
        studentActivity.setId(((JsonObject) jsonElement).get("Id").getAsInt());
        return studentActivity;
    }
}
