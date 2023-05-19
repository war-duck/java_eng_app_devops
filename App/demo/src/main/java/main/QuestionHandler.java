package main;

import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.net.URI;

public class QuestionHandler {
    private static ArrayList<QuestionInfo> QuestionList;
    public static void readFromFile(URI filePath) throws IOException {
        if (filePath == null)
            throw new IOException("Niepoprawna (null) ścieżka do pliku", new Throwable("correctBehaviour"));
        QuestionList = new ArrayList<QuestionInfo>(2); //Tworzy listę na pytania
        QuestionInfo questionInfo;
        String[] splitInfo, optionButtonStrings;
        List<String> Lines = Files.readAllLines(Paths.get(filePath));
        for (String line : Lines)
        {
            questionInfo = new QuestionInfo();
            splitInfo = line.split(";"); // info o pytaniu oddzielone jest ';'
            optionButtonStrings = splitInfo[3].split("\\|"); // treść przycisków jest oddzielona '|'
            questionInfo.setAll(splitInfo[0], splitInfo[1], splitInfo[2], optionButtonStrings);            
            QuestionList.add(questionInfo); //Dodaje pytanie do listy
        }
    }
    public static ArrayList<QuestionInfo> getQuestionList() {
        return QuestionList;
    }
    public static void writeToFile(){
        //Do zaimplementowania
    }

    public static QuestionInfo getRandomQuestion(){
        Random random = new Random();
        int randomNumber = random.nextInt(QuestionList.size()); // zwraca liczbę od 0 do questionList.size()
        return QuestionList.get(randomNumber);
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
