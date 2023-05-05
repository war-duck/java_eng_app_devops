package test;

import javafx.fxml.FXMLLoader;

import java.util.ArrayList;

public class QuestionHandler {
    private static ArrayList<QuestionInfo> QuestionList;
    public static void readFromFile(){
        QuestionList = new ArrayList<>(2); //Tworzy listę na pytania
        QuestionInfo questionInfo = new QuestionInfo();
        String[] optionContent = {"dsa", "das", "test", "esc"};
        questionInfo.setAll("test", "Który ciąg znaków?", "hint hint git gud", optionContent); //Dodaje informacje o pytaniu
        QuestionList.add(questionInfo); //Dodaje pytanie do listy
    }

    public static void writeToFile(){
        //Do zaimplementowania
    }

    public static QuestionInfo getRandomQuestion(){
        return QuestionList.get(0); //Tymczasowo funkcja zwraca pierwsze pytanie z listy, należy zrobić tak aby losowo wybierała pytanie z listy
    }

    public static void sendTaskInfoToController(QuestionInfo questionInfo, FXMLLoader loader) // wysyła dane o zadaniu do kontrolera
    {
        SingleChoiceTaskController controller = loader.getController(); // znajdujemy obecną instancję kontrolera
        controller.setCorrectAnswer(questionInfo.correctAnswer);
        controller.setQuestionContent(questionInfo.questionContent);
        controller.setHintContent(questionInfo.hintContent);
        controller.setOptionButtons(questionInfo.answerOptions);
    }
}
