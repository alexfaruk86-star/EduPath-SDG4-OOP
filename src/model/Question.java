package model;

public class Question {

    private String questionText;
    private String optionA;
    private String optionB;
    private String optionC;
    private String correctAnswer;


    public Question(
            String questionText,
            String optionA,
            String optionB,
            String optionC,
            String correctAnswer) {

        this.questionText = questionText;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.correctAnswer = correctAnswer;
    }


    public String getQuestionText() {
        return questionText;
    }


    public String getOptionA() {
        return optionA;
    }


    public String getOptionB() {
        return optionB;
    }


    public String getOptionC() {
        return optionC;
    }


    public String getCorrectAnswer() {
        return correctAnswer;
    }


    public boolean checkAnswer(String answer) {

        if (answer == null) {
            return false;
        }

        return correctAnswer.equalsIgnoreCase(answer);
    }


    public void displayQuestion() {

        System.out.println(questionText);
        System.out.println("A. " + optionA);
        System.out.println("B. " + optionB);
        System.out.println("C. " + optionC);
    }
}