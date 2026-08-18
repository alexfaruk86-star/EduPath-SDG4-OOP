package model;

import java.util.ArrayList;

public class Quiz {

    private String quizId;
    private String title;
    private ArrayList<Question> questions;


    public Quiz(String quizId, String title) {

        this.quizId = quizId;
        this.title = title;
        this.questions = new ArrayList<>();

    }


    public void addQuestion(Question question) {

        questions.add(question);

    }


    public String getTitle() {

        return title;

    }


    public void displayQuiz() {

        System.out.println("Quiz ID: " + quizId);
        System.out.println("Quiz Title: " + title);
        System.out.println("----------------");


        for (Question q : questions) {

            q.displayQuestion();

            System.out.println();

        }

    }


    public int getNumberOfQuestions() {

        return questions.size();

    }

}