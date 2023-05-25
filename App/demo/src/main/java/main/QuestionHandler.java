package main;

import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.net.URI;

public class QuestionHandler {
    private static ArrayList<QuestionInfo> QuestionList;
    private static final HashSet<Integer> failedQuestions = new HashSet<>();
    public static void readFromFile(URI filePath) throws IOException {
        if (filePath == null)
            throw new IOException("Niepoprawna (null) ścieżka do pliku", new Throwable("correctBehaviour"));
        QuestionList = new ArrayList<QuestionInfo>(); //Tworzy listę na pytania
        QuestionInfo questionInfo;
        String[] splitInfo, optionButtonStrings;
        int questionID;
        List<String> Lines = Files.readAllLines(Paths.get(filePath));
        for (String line : Lines)
        {
            questionInfo = new QuestionInfo();
            splitInfo = line.split(";"); // info o pytaniu oddzielone jest ';'
            if (splitInfo.length != 5)
                throw new IOException("Niepoprawna (" + splitInfo.length + ", oczekiwano 5) danych o zadaniu");
            questionID = Integer.parseInt(splitInfo[0]);
            optionButtonStrings = splitInfo[4].split("\\|"); // treść przycisków jest oddzielona '|'
            if (optionButtonStrings.length != 4)
                throw new IOException("Niepoprawna ilość (" + optionButtonStrings.length + ", oczekiwano 4) odpowiedzi");
            questionInfo.setAll(questionID, splitInfo[1], splitInfo[2], splitInfo[3], optionButtonStrings);
            QuestionList.add(questionInfo); //Dodaje pytanie do listy
        }
    }
    public static ArrayList<QuestionInfo> getQuestionList() {
        return QuestionList;
    }
    public static void addFailedQuestionID (int questionID) {
        failedQuestions.add(questionID);
    }
    public static void writeToFile() {
        //Do zaimplementowania
    }

    public static QuestionInfo getRandomQuestion() {
        Random random = new Random();
        int randomNumber = random.nextInt(QuestionList.size()); // zwraca liczbę od 0 do questionList.size()
        return QuestionList.get(randomNumber);
    }

    public static void sendTaskInfoToController(QuestionInfo questionInfo, FXMLLoader loader) // wysyła dane o zadaniu do kontrolera
    {
        SingleChoiceTaskController controller = loader.getController(); // znajdujemy obecną instancję kontrolera
        controller.setQuestionInfo(questionInfo);
        controller.setCorrectAnswer(questionInfo.correctAnswer);
        controller.setQuestionContent(questionInfo.questionContent);
        controller.setHintContent(questionInfo.hintContent);
        controller.setOptionButtons(questionInfo.answerOptions);
    }
    private static HashSet<Integer> readQuestionIDFromLine (String line) {
        String[] prevFailedQuestions = line.split(";");
        HashSet<Integer> questionIDSet = new HashSet<>();
        for (String s : prevFailedQuestions) {
            try {
                questionIDSet.add(Integer.parseInt(s));
            }
            catch (NumberFormatException nfe) {
                System.err.println("String '" + s + "' nie mógł być przekonwertowany na Integer");
            }
        }
        return questionIDSet;
    }
    private static String buildQuestionIDString () {
        StringBuilder formattedOutput = new StringBuilder();
        Iterator<Integer> setIter = failedQuestions.iterator();
        while (setIter.hasNext()) {
            formattedOutput.append(setIter.next());
            if (setIter.hasNext())
                formattedOutput.append(";");
        }
        return formattedOutput.toString();
    }
    public static void saveFailedQuestionsToFile() throws IOException {
        try {
            // czytamy poprzednie zadania z pliku
            Path filePath = Paths.get(QuestionHandler.class.getResource("FailedQuestions.txt").toURI());
            List<String> lines = Files.readAllLines(filePath);
            if (lines.size() > 0) {
                failedQuestions.addAll(readQuestionIDFromLine(lines.get(0)));
            }
            Files.delete(filePath);
            Files.createFile(filePath); // wstawia nowy, pusty plik -- nie ma opcji nadpisania zawartości istniejącego pliku
            // dodajemy wszystkie ID zadań - te uprzednio znajdujące się w pliku i te nowe
            if (failedQuestions.size() > 0) {
                String outputString = buildQuestionIDString();
                System.out.println(outputString);
                Files.write(filePath, outputString.getBytes());
            }
        }
        catch (NumberFormatException nfe) {
            throw new IOException("Błędny format ID zadania. Msg:\n\t" + nfe.getLocalizedMessage());
        }
        catch (URISyntaxException urie) {
            throw new IOException("Błąd konwersji na URI. Msg:\n\t" + urie.getLocalizedMessage());
        }
    }
}