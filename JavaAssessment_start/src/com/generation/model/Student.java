package com.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.text.ParseException;
import java.util.*;
import com.generation.model.Course;
import com.generation.service.CourseService;

public class Student extends Person
{
    public static final double PASS_MIN_GRADE = 3.0;

    private final HashMap<String, EnrolledCourse> enrolledCourses = new HashMap<>();


    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
    }

    public boolean enrollToCourse( Course course ) {
        //TODO Check if student has already enrolled to the course, if not add the course to enrolledCourses hashmap
        if (this.enrolledCourses.containsKey(course.getCode())) {
            return true;
        }

        EnrolledCourse newCourse = new EnrolledCourse(course);
        this.enrolledCourses.put(newCourse.getCode(), newCourse);
        return false;
    }

    public HashMap<String, EnrolledCourse> getEnrolledCourses()
    {
        //TODO return a Hashmap of all the enrolledCourses
        for (String i : enrolledCourses.keySet()){
            EnrolledCourse enrolledCourse = this.enrolledCourses.get(i);
            System.out.println(enrolledCourse);
                }
        return null;
    }

    public void gradeCourse( String courseCode, double grade )
    {
        //TODO set the grade for the enrolled Course

        this.enrolledCourses.get(courseCode).getGrade();

    }

    public Course findCourseById( String courseId )
    {
        //TODO return a Course from the course Id

        return this.enrolledCourses.get(courseId);




    }

    public HashMap<String, EnrolledCourse> findPassedCourses()
    {
        //TODO Check the enrolled courses grade and compare to the passing grade

       return null;
    }

    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }
}
