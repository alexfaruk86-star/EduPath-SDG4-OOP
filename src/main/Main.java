package main;

import model.Student;
import model.Teacher;
import model.User;

public class Main {

    public static void main(String[] args) {


        User student = new Student(
                "S001",
                "Alex",
                "1234",
                "ST001",
                "Computer Science"
        );


        User teacher = new Teacher(
                "T001",
                "Dr Ahmad",
                "5678",
                "TC001",
                "Programming"
        );


        student.displayDashboard();

        System.out.println("----------------");

        teacher.displayDashboard();

    }
}