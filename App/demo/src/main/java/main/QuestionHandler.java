package main;

import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.net.URI;

public class QuestionHandler {
    private QuestionHandler(){}
    public static List<QuestionInfo> questionList = new ArrayList<QuestionInfo>(1);
    private static int maxQuestionID = 0;

    private static final Path failedQuestionsFilePath = Paths.get("src/main/resources/main/failedQuestions.txt");
    private static final HashSet<Integer> failedQuestions = new HashSet<>();
    public static void readFromFile(URI filePath) throws IOException {
        if (filePath == null)
            throw new IOException("Niepoprawna (null) ścieżka do pliku", new Throwable("correctBehaviour"));
        questionList = new ArrayList<>(); //Tworzy listę na pytania QuestionInfo
        QuestionInfo questionInfo;
        String[] splitInfo;
        String[] optionButtonStrings;
        int questionID;
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        for (String line : lines)
        {
            questionInfo = new QuestionInfo();
            splitInfo = line.split(";"); // info o pytaniu oddzielone jest ';'
            if (splitInfo.length != 5)
                throw new IOException("Niepoprawna (" + splitInfo.length + ", oczekiwano 5) danych o zadaniu");
            questionID = Integer.parseInt(splitInfo[0]);
            if (questionID > maxQuestionID)
                maxQuestionID = questionID;
            optionButtonStrings = splitInfo[4].split("\\|"); // treść przycisków jest oddzielona '|'
            if (optionButtonStrings.length != 4)
                throw new IOException("Niepoprawna ilość (" + optionButtonStrings.length + ", oczekiwano 4) odpowiedzi");
            questionInfo.setAll(questionID, splitInfo[1], splitInfo[2], splitInfo[3], optionButtonStrings);
            questionList.add(questionID, questionInfo); //Dodaje pytanie do listy na indeksie questionID
        }
    }
    public static List<QuestionInfo> getQuestionList() {
        return questionList;
    }
    public static HashSet<Integer> getFailedQuestionSet() {
        return failedQuestions;
    }
    public static void addFailedQuestionID (int questionID) {
        failedQuestions.add(questionID);
    }
    public static QuestionInfo getRandomQuestion() {
        Random random = new Random();
        int randomNumber = random.nextInt(questionList.size()); // zwraca liczbę od 0 do questionList.size()
        return questionList.get(randomNumber);
    }
    public static QuestionInfo getRandomFailedQuestion(HashSet<Integer> set) {
        Random random = new Random();
        int randomNumber = random.nextInt(set.size());
        Iterator<Integer> iter = set.iterator();
        for (int i = 0; i < randomNumber && iter.hasNext(); ++i)
            iter.next();
        Integer returnedQuestion = iter.next();
        return questionList.get(returnedQuestion);
    }

    public static void sendTaskInfoToController(QuestionInfo questionInfo, FXMLLoader loader) // wysyła dane o zadaniu do kontrolera
    {
        TaskControllerInterface controller = loader.getController(); // znajdujemy obecną instancję kontrolera
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
            Files.delete(failedQuestionsFilePath);
            Files.createFile(failedQuestionsFilePath); // wstawia nowy, pusty plik -- nie ma opcji nadpisania zawartości istniejącego pliku
            // dodajemy wszystkie ID zadań - te uprzednio znajdujące się w pliku i te nowe
            if (!failedQuestions.isEmpty()) {
                String outputString = buildQuestionIDString();
                System.out.println(outputString);
                Files.write(failedQuestionsFilePath, outputString.getBytes());
            }
        }
        catch (NumberFormatException nfe) {
            throw new IOException("Błędny format ID zadania. Msg:\n\t" + nfe.getLocalizedMessage());
        }
    }
    public static void addPrevFailedQuestionsFromFile() throws IOException {
        List<String> lines = Files.readAllLines(failedQuestionsFilePath);
        if (!lines.isEmpty()) {
            failedQuestions.addAll(readQuestionIDFromLine(lines.get(0)));
        }
    }
    public static Boolean createFailedQuestionFile() throws IOException {
        if (Files.notExists(failedQuestionsFilePath)) {
            Files.createFile(failedQuestionsFilePath);
            return true;
        }
        else return false; // istnieje
    }
}