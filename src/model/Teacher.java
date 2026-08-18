package model;

public class Teacher extends User {

    private String teacherId;
    private String subject;


    public Teacher(String id, String name, String password,
                   String teacherId, String subject) {

        super(id, name, password);

        this.teacherId = teacherId;
        this.subject = subject;

    }


    public String getTeacherId() {

        return teacherId;

    }


    public String getSubject() {

        return subject;

    }


    public void setSubject(String subject) {

        this.subject = subject;

    }


    @Override
    public void displayDashboard() {

        System.out.println("Welcome to Teacher Dashboard");

        System.out.println("Teacher Name: " + getName());

        System.out.println("Subject: " + subject);

    }

}