package test;

public class QuestionInfo
{
    String correctAnswer;
    String questionContent;
    String hintContent;
    String[] answerOptions;

    public void setAll (String correctAnswer, String questionContent, String hintContent, String[] answerOptions)
    {
        this.correctAnswer = correctAnswer;
        this.questionContent = questionContent;
        this.hintContent = hintContent;
        this.answerOptions = answerOptions.clone();
    }
}
