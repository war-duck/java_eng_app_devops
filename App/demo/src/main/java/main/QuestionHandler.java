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

    private static final Random random = new Random();
    protected static final List<QuestionInfo> questionList = new ArrayList<>(1);
    private static int maxQuestionID = 0;

    public static Path failedQuestionsFilePath = Paths.get("src/main/resources/main/failedQuestions.txt");
    private static final Set<Integer> failedQuestions = new HashSet<>();
    public static void readFromFile(URI filePath) throws IOException {
        if (filePath == null)
            throw new IOException("Niepoprawna (null) ścieżka do pliku", new Throwable("correctBehaviour"));
        QuestionInfo questionInfo;
        String[] splitInfo;
        String[] optionButtonStrings;
        Difficulty questionDifficulty = null;
        int questionID;
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        for (String line : lines)
        {
            questionInfo = new QuestionInfo();
            splitInfo = line.split(";"); // info o pytaniu oddzielone jest ';'
            if (splitInfo.length != 6)
                throw new IOException("Niepoprawna (" + splitInfo.length + ", oczekiwano 6) danych o zadaniu");
            questionID = Integer.parseInt(splitInfo[0]);
            if (questionID > maxQuestionID)
                maxQuestionID = questionID;
            optionButtonStrings = splitInfo[5].split("\\|"); // treść przycisków jest oddzielona '|'
            if (optionButtonStrings.length != 4)
                throw new IOException("Niepoprawna ilość (" + optionButtonStrings.length + ", oczekiwano 4) odpowiedzi");
            switch(splitInfo[1]){
                case "easy":
                    questionDifficulty = Difficulty.EASY;
                    break;
                case "medium":
                    questionDifficulty = Difficulty.MEDIUM;
                    break;
                case "hard":
                    questionDifficulty = Difficulty.HARD;
                    break;
                default:
                    throw new IOException("Niepoprawna trudność pytania ("+splitInfo[1]+") możliwe do wyboru (easy, medium, hard)");
            }
            questionInfo.setAll(questionID, splitInfo[2], splitInfo[3], splitInfo[4], optionButtonStrings, questionDifficulty);
            questionList.add(questionID, questionInfo); //Dodaje pytanie do listy na indeksie questionID
        }
    }
    public static List<QuestionInfo> getQuestionList() {
        return questionList;
    }
    public static Set<Integer> getFailedQuestionSet() {
        return failedQuestions;
    }
    public static void addFailedQuestionID (int questionID) {
        failedQuestions.add(questionID);
    }

    public static List<QuestionInfo> getQuestionsWithSpecifiedDifficulty(Difficulty questionDifficulty){
        List<QuestionInfo> outputQuestionList = new ArrayList<>(1);
        for (int i = 0; i < questionList.size(); ++i){
            if(questionList.get(i).questionDifficulty == questionDifficulty) {
                outputQuestionList.add(questionList.get(i));
            }
        }
        return outputQuestionList;
    }
    public static QuestionInfo getRandomQuestion() {
        List<QuestionInfo> selectedQuestions = getQuestionsWithSpecifiedDifficulty(App.questionDifficulty);
        if(selectedQuestions.isEmpty()){
            return null;
        }
        int randomNumber = random.nextInt(selectedQuestions.size()); // zwraca liczbę od 0 do questionList.size()
        return selectedQuestions.get(randomNumber);
    }
    public static QuestionInfo getRandomFailedQuestion(Set<Integer> set) {
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
    private static Set<Integer> readQuestionIDFromLine (String line) {
        String[] prevFailedQuestions = line.split(";");
        Set<Integer> questionIDSet = new HashSet<>();
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