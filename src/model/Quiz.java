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


    public String getQuizId() {
        return quizId;
    }


    public String getTitle() {
        return title;
    }


    public ArrayList<Question> getQuestions() {
        return questions;
    }


    public int getNumberOfQuestions() {
        return questions.size();
    }


    public int calculateScore(ArrayList<String> answers) {

        int score = 0;

        for (int i = 0; i < questions.size(); i++) {

            String answer = "";

            if (i < answers.size()) {
                answer = answers.get(i);
            }

            if (questions.get(i).checkAnswer(answer)) {
                score++;
            }
        }

        return score;
    }


    public void displayQuiz() {

        System.out.println("Quiz ID: " + quizId);
        System.out.println("Quiz Title: " + title);
        System.out.println("----------------");

        for (Question question : questions) {

            question.displayQuestion();
            System.out.println();
        }
    }
}