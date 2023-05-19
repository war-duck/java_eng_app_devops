package main;

public class QuestionInfo
{
    public String correctAnswer;
    public String questionContent;
    public String hintContent;
    public String[] answerOptions;

    public void setAll (String correctAnswer, String questionContent, String hintContent, String[] answerOptions)
    {
        this.correctAnswer = correctAnswer;
        this.questionContent = questionContent;
        this.hintContent = hintContent;
        this.answerOptions = answerOptions.clone();
    }
}
