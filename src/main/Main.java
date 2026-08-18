package main;

import model.*;

public class Main {

    public static void main(String[] args) {


        // Create teacher
        Teacher teacher = new Teacher(
                "T001",
                "Dr Ahmad",
                "5678",
                "TC001",
                "Programming"
        );


        // Create course
        Course course = new Course(
                "C001",
                "Java Programming",
                "Learn Object Oriented Programming",
                teacher
        );


        // Create student
        Student student = new Student(
                "S001",
                "Alex",
                "1234",
                "ST001",
                "Computer Science"
        );


        // Display course
        System.out.println("===== COURSE INFORMATION =====");

        course.displayCourseInfo();


        System.out.println();


        // Create quiz
        Quiz quiz = new Quiz(
                "Q001",
                "Java Basics Quiz"
        );


        // Create questions
        Question q1 = new Question(
                "What is Java?",
                "Programming Language",
                "Database",
                "Operating System",
                "A"
        );


        Question q2 = new Question(
                "Java supports OOP?",
                "Yes",
                "No",
                "Maybe",
                "A"
        );


        // Add questions into quiz
        quiz.addQuestion(q1);
        quiz.addQuestion(q2);


        System.out.println("===== QUIZ =====");

        quiz.displayQuiz();


        // Track progress
        Progress progress = new Progress(
                student,
                course
        );


        progress.updateProgress(80);
        progress.updateQuizScore(9);


        System.out.println("===== STUDENT PROGRESS =====");

        progress.displayProgress();

    }

}