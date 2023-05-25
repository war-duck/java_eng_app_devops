package main;

public class QuestionInfo
{
    public int questionID;
    public String correctAnswer;
    public String questionContent;
    public String hintContent;
    public String[] answerOptions;

    public void setAll (int questionID, String correctAnswer, String questionContent, String hintContent, String[] answerOptions)
    {
        this.questionID = questionID;
        this.correctAnswer = correctAnswer;
        this.questionContent = questionContent;
        this.hintContent = hintContent;
        this.answerOptions = answerOptions.clone();
    }
}