package main;

public interface TaskControllerInterface {
    void setQuestionInfo(QuestionInfo questionInfo);

    void setCorrectAnswer(String correctAnswer);

    void setQuestionContent(String questionContent);

    void setHintContent(String hintContent);

    void setOptionButtons(String[] buttonContent);
}
