package model;

public class Progress {

    private Student student;
    private Course course;
    private int completedPercentage;
    private int quizScore;


    public Progress(Student student, Course course) {

        this.student = student;
        this.course = course;
        this.completedPercentage = 0;
        this.quizScore = 0;

    }


    public void updateProgress(int percentage) {

        this.completedPercentage = percentage;

    }


    public void updateQuizScore(int score) {

        this.quizScore = score;

    }


    public Student getStudent() {

        return student;

    }


    public Course getCourse() {

        return course;

    }


    public int getCompletedPercentage() {

        return completedPercentage;

    }


    public int getQuizScore() {

        return quizScore;

    }


    public void displayProgress() {

        System.out.println("Student: " + student.getName());

        System.out.println("Course: " + course.getCourseName());

        System.out.println("Completion: "
                + completedPercentage + "%");

        System.out.println("Quiz Score: "
                + quizScore);

    }

}