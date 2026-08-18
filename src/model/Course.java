package model;

public class Course {

    private String courseId;
    private String courseName;
    private String description;
    private Teacher teacher;


    public Course(String courseId, String courseName, 
                  String description, Teacher teacher) {

        this.courseId = courseId;
        this.courseName = courseName;
        this.description = description;
        this.teacher = teacher;

    }


    public String getCourseId() {

        return courseId;

    }


    public String getCourseName() {

        return courseName;

    }


    public String getDescription() {

        return description;

    }


    public Teacher getTeacher() {

        return teacher;

    }


    public void displayCourseInfo() {

        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Description: " + description);
        System.out.println("Teacher: " + teacher.getName());

    }

}