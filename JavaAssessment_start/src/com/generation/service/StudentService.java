package com.generation.service;

import com.generation.model.Course;
import com.generation.model.EnrolledCourse;
import com.generation.model.Student;
import java.util.Scanner;
import java.text.DateFormat;
import java.util.Date;

import java.util.HashMap;

public class StudentService
{
    private final HashMap<String, Student> students = new HashMap<>();

    public void registerStudent( Student student )

    {
        //TODO Add new student to the students hashmap

       this.students.put(student.getId(),student);

    }

    public Student findStudent( String studentId )
    {
        //TODO Find the student from the Hashmap with the student id
        if (this.students.containsKey(studentId)){
            return this.students.get(studentId);
        }
        return null;
    }

    public void enrollToCourse( String studentId, Course course )
    {
        //TODO check if students hashmap contains the studentsId, if have not add the course to the student enrollToCourses for the course
        if(this.students.containsKey(studentId)){
            Student getStudent = this.students.get(studentId);
            getStudent.enrollToCourse(course);
            }
    }

    public void showSummary()
    {
        //TODO Loop through students hashmap and print out students' details including the enrolled courses
        for (String i : students.keySet()){
            System.out.println( "Key : " + i + "students Information : " + this.students.get(i) + enrolledCourses(this.students.get(i)));
        }

    }

    public HashMap<String, EnrolledCourse> enrolledCourses(Student student)
    {
        //TODO return a HashMap of all the enrolledCourses

        for (EnrolledCourse a : this.enrolledCourses(student).values()){
            return this.enrolledCourses(student);

        }
        return null;
    }

    public Course findEnrolledCourse( Student student, String courseId )
    {
        //TODO return the course enrolled by the student from the course Id
        if(this.students.containsKey(student.getId())) {
            Student getStudent = this.students.get(student.getId());
            if (this.enrolledCourses(student).containsKey(courseId)) {
                EnrolledCourse getEnrolledCourse = this.enrolledCourses(student).get(courseId);
                return getEnrolledCourse;
            } else {
                System.out.println(" This is not a valid course code");
            }
        }
        else {
            System.out.println(" this is not a valid student ID");
        }
        return null;

    }

    public void gradeStudent(Student student, Course course, double grade) {
        //Get the student Object / e,g Student 111 - studentService
        //1) Get the Student Object / e.g Student 111 - from studentService object
        //2) Get all the enrolledCourses for that student 111 - studentService object
        //HashMap<String, EnrolledCourse> getEnrolledCourse = studentService.getEnrolledCourses();
        // For Loop to loop through getEnrolledCourse and print out
        //3) allow user to enter the course code (find the enrolledCourse object - use findEnrolledCourse( student, courseId ))
        //4) allow user to enter the grade
        //5) studentService.gradeStudent(student, course, grade)

        Scanner inputId  = new Scanner (System.in);
        System.out.printf("Enter Student Id  ");
        String addId = inputId.nextLine();

        Scanner inputCourse = new Scanner (System.in);
        System.out.printf("Enter Course Code:  ");
        int addCourse = inputCourse.nextInt();

        Scanner inputGrade = new Scanner (System.in);
        System.out.printf("Enter The Grade:   ");
        double addGrade = inputGrade.nextInt();

        EnrolledCourse addC = this.enrolledCourses(student).get(addId);
        //EnrolledCourse addC = this.students.get(addId).enrollToCourse(student).get(addCourse);
        addC.setGrade(addGrade);

        student.gradeCourse(course.getCode(), grade);

    }



    public HashMap<String, EnrolledCourse> getPassedCourses(Student student) {

        /*Student getStudent = this.students.get(student.getId());
        Course passCourseGrade = this.enrolledCourses(getStudent).get(Course.get(code), grade);
        if ( passCourseGrade >=3) {


        }


        for(this.enrolledCourses(getStudent).get(grade) >=3){



        }
        */


        return student.findPassedCourses();
    }
}
