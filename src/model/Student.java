package model;

public class Student extends User {

    private String studentId;
    private String course;


    public Student(String id, String name, String password, 
                   String studentId, String course) {

        super(id, name, password);

        this.studentId = studentId;
        this.course = course;

    }


    public String getStudentId() {

        return studentId;

    }


    public String getCourse() {

        return course;

    }


    public void setCourse(String course) {

        this.course = course;

    }


    @Override
    public void displayDashboard() {

        System.out.println("Welcome to Student Dashboard");

        System.out.println("Student Name: " + getName());

        System.out.println("Course: " + course);

    }

}