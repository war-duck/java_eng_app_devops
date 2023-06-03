package test;

import main.Difficulty;
import main.QuestionHandler;
import main.QuestionInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;


import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RunWith(BlockJUnit4ClassRunner.class)
public class MWTest {

    @Test public void readFromFileQuestionIDTest() {
        try {
            QuestionHandler.readFromFile(Objects.requireNonNull(MWTest.class.getResource("testTaskContent.txt")).toURI());
            ArrayList<QuestionInfo> receivedList = (ArrayList<QuestionInfo>) QuestionHandler.getQuestionList();
            for (int i = 0; i < receivedList.size(); ++i) { // w żadnym pytaniu nie powinno być pustych wartości
                if (receivedList.get(i).questionID < 0 || receivedList.get(i).questionID>= receivedList.size())
                    throw new AssertionError("Niepoprawna wartość questionID ("+receivedList.get(i).questionID+") we wczytanym pytaniu nr " + (i + 1));
            }
        }
        catch (URISyntaxException ue) {
            System.err.println("Niepoprawna nazwa pliku, błąd konwersji na URI. Msg:\n\t" + ue.getLocalizedMessage());
            throw new AssertionError(ue.getLocalizedMessage());
        }
        catch (IOException ie) {
            System.err.println("Błąd w metodzie QuestionHandler.readFromFile(). Msg:\n\t" + ie.getLocalizedMessage());
            throw new AssertionError(ie.getLocalizedMessage());
        }
        catch (NullPointerException npe) {
            System.err.println("Niepoprawny URL do pliku, nie można przekonwertować na URI. Msg:\n\t" + npe.getLocalizedMessage());
            throw new AssertionError(npe.getLocalizedMessage());
        }
    }

    @Test public void readFromFileQuestionDifficultyTest() {
        try {
            QuestionHandler.readFromFile(Objects.requireNonNull(MWTest.class.getResource("testTaskContent.txt")).toURI());
            ArrayList<QuestionInfo> receivedList = (ArrayList<QuestionInfo>) QuestionHandler.getQuestionList();
            for (int i = 0; i < receivedList.size(); ++i) { // w żadnym pytaniu nie powinno być pustych wartości
                if (receivedList.get(i).questionDifficulty == null)
                    throw new AssertionError("Niepoprawna wartość questionDifficulty (null) we wczytanym pytaniu nr " + (i + 1));
            }
        }
        catch (URISyntaxException ue) {
            System.err.println("Niepoprawna nazwa pliku, błąd konwersji na URI. Msg:\n\t" + ue.getLocalizedMessage());
            throw new AssertionError(ue.getLocalizedMessage());
        }
        catch (IOException ie) {
            System.err.println("Błąd w metodzie QuestionHandler.readFromFile(). Msg:\n\t" + ie.getLocalizedMessage());
            throw new AssertionError(ie.getLocalizedMessage());
        }
        catch (NullPointerException npe) {
            System.err.println("Niepoprawny URL do pliku, nie można przekonwertować na URI. Msg:\n\t" + npe.getLocalizedMessage());
            throw new AssertionError(npe.getLocalizedMessage());
        }
    }

    @Test public void readFromFileCorrectAnswerTest() {
        try {
            QuestionHandler.readFromFile(Objects.requireNonNull(MWTest.class.getResource("testTaskContent.txt")).toURI());
            ArrayList<QuestionInfo> receivedList = (ArrayList<QuestionInfo>) QuestionHandler.getQuestionList();
            for (int i = 0; i < receivedList.size(); ++i) { // w żadnym pytaniu nie powinno być pustych wartości
                if (receivedList.get(i).correctAnswer == null)
                    throw new AssertionError("Niepoprawna wartość correctAnswer (null) we wczytanym pytaniu nr " + (i + 1));
            }
        }
        catch (URISyntaxException ue) {
            System.err.println("Niepoprawna nazwa pliku, błąd konwersji na URI. Msg:\n\t" + ue.getLocalizedMessage());
            throw new AssertionError(ue.getLocalizedMessage());
        }
        catch (IOException ie) {
            System.err.println("Błąd w metodzie QuestionHandler.readFromFile(). Msg:\n\t" + ie.getLocalizedMessage());
            throw new AssertionError(ie.getLocalizedMessage());
        }
        catch (NullPointerException npe) {
            System.err.println("Niepoprawny URL do pliku, nie można przekonwertować na URI. Msg:\n\t" + npe.getLocalizedMessage());
            throw new AssertionError(npe.getLocalizedMessage());
        }
    }

    @Test public void readFromFileQuestionContentTest() {
        try {
            QuestionHandler.readFromFile(Objects.requireNonNull(MWTest.class.getResource("testTaskContent.txt")).toURI());
            ArrayList<QuestionInfo> receivedList = (ArrayList<QuestionInfo>) QuestionHandler.getQuestionList();
            for (int i = 0; i < receivedList.size(); ++i) { // w żadnym pytaniu nie powinno być pustych wartości
                if (receivedList.get(i).questionContent == null)
                    throw new AssertionError("Niepoprawna wartość questionContent (null) we wczytanym pytaniu nr " + (i + 1));
                }
        }
        catch (URISyntaxException ue) {
            System.err.println("Niepoprawna nazwa pliku, błąd konwersji na URI. Msg:\n\t" + ue.getLocalizedMessage());
            throw new AssertionError(ue.getLocalizedMessage());
        }
        catch (IOException ie) {
            System.err.println("Błąd w metodzie QuestionHandler.readFromFile(). Msg:\n\t" + ie.getLocalizedMessage());
            throw new AssertionError(ie.getLocalizedMessage());
        }
        catch (NullPointerException npe) {
            System.err.println("Niepoprawny URL do pliku, nie można przekonwertować na URI. Msg:\n\t" + npe.getLocalizedMessage());
            throw new AssertionError(npe.getLocalizedMessage());
        }
    }

    @Test public void readFromFileHintContentTest() {
        try {
            QuestionHandler.readFromFile(Objects.requireNonNull(MWTest.class.getResource("testTaskContent.txt")).toURI());
            ArrayList<QuestionInfo> receivedList = (ArrayList<QuestionInfo>) QuestionHandler.getQuestionList();
            for (int i = 0; i < receivedList.size(); ++i) { // w żadnym pytaniu nie powinno być pustych wartości
                if (receivedList.get(i).hintContent == null)
                    throw new AssertionError("Niepoprawna wartość hintContent (null) we wczytanym pytaniu nr " + (i + 1));
            }
        }
        catch (URISyntaxException ue) {
            System.err.println("Niepoprawna nazwa pliku, błąd konwersji na URI. Msg:\n\t" + ue.getLocalizedMessage());
            throw new AssertionError(ue.getLocalizedMessage());
        }
        catch (IOException ie) {
            System.err.println("Błąd w metodzie QuestionHandler.readFromFile(). Msg:\n\t" + ie.getLocalizedMessage());
            throw new AssertionError(ie.getLocalizedMessage());
        }
        catch (NullPointerException npe) {
            System.err.println("Niepoprawny URL do pliku, nie można przekonwertować na URI. Msg:\n\t" + npe.getLocalizedMessage());
            throw new AssertionError(npe.getLocalizedMessage());
        }
    }

    @Test public void readFromFileAnswerOptionsTest() {
        try {
            QuestionHandler.readFromFile(Objects.requireNonNull(MWTest.class.getResource("testTaskContent.txt")).toURI());
            ArrayList<QuestionInfo> receivedList = (ArrayList<QuestionInfo>) QuestionHandler.getQuestionList();
            for (int i = 0; i < receivedList.size(); ++i) { // w żadnym pytaniu nie powinno być pustych wartości
                if (receivedList.get(i).answerOptions.length != 4)
                    throw new AssertionError("Niepoprawna ilość opcji (" + receivedList.get(i).answerOptions.length + ") w answerOptions we wczytanym pytaniu nr " + (i + 1));
            }
        }
        catch (URISyntaxException ue) {
            System.err.println("Niepoprawna nazwa pliku, błąd konwersji na URI. Msg:\n\t" + ue.getLocalizedMessage());
            throw new AssertionError(ue.getLocalizedMessage());
        }
        catch (IOException ie) {
            System.err.println("Błąd w metodzie QuestionHandler.readFromFile(). Msg:\n\t" + ie.getLocalizedMessage());
            throw new AssertionError(ie.getLocalizedMessage());
        }
        catch (NullPointerException npe) {
            System.err.println("Niepoprawny URL do pliku, nie można przekonwertować na URI. Msg:\n\t" + npe.getLocalizedMessage());
            throw new AssertionError(npe.getLocalizedMessage());
        }
    }

    @Test public void readFromFileNullTest() {
        try {
            QuestionHandler.readFromFile(null);
            throw new Exception("Funkcja powinna wyrzucić Exception dla podanej wartości null"); // funkcja powinna zwracać IOException dla parametru null
        } catch (IOException ie) {
            if (!(ie.getCause().getMessage().equals("correctBehaviour"))) { // poprawną reakcją jest IOException z Cause zawierającą msg "CorrectBehaviour"
                System.err.println("Niespodziewany wyjątek IOException w metodzie readFromFile. Msg:\n\t" + ie.getLocalizedMessage());
                throw new AssertionError(ie.getLocalizedMessage());
            }
        } catch (Exception e) {
            System.err.println("Niespodziewane zachowanie w metodzie readFromFile. Msg:\n\t" + e.getLocalizedMessage());
            throw new AssertionError(e.getLocalizedMessage());
        }
    }

    @Test public void getRandomQuestionQuestionIDTest() {
        try{
            QuestionHandler.readFromFile(Objects.requireNonNull(MWTest.class.getResource("testTaskContent.txt")).toURI());
            QuestionInfo testQuestionInfo = QuestionHandler.getRandomQuestion();
            if (testQuestionInfo.questionID < 0 || testQuestionInfo.questionID>= QuestionHandler.getQuestionList().size())
                throw new AssertionError("Niepoprawna wartość questionID ("+testQuestionInfo.questionID+")");
        }
        catch (URISyntaxException ue) {
            System.err.println("Niepoprawna nazwa pliku, błąd konwersji na URI. Msg:\n\t" + ue.getLocalizedMessage());
            throw new AssertionError(ue.getLocalizedMessage());
        }
        catch (IOException ie) {
            System.err.println("Błąd w metodzie QuestionHandler.getRandomQuestion(). Msg:\n\t" + ie.getLocalizedMessage());
            throw new AssertionError(ie.getLocalizedMessage());
        }
        catch (NullPointerException npe) {
            System.err.println("Niepoprawny URL do pliku, nie można przekonwertować na URI. Msg:\n\t" + npe.getLocalizedMessage());
            throw new AssertionError(npe.getLocalizedMessage());
        }
    }

    @Test public void getRandomQuestionQuestionDifficultyTest() {
        try{
            QuestionHandler.readFromFile(Objects.requireNonNull(MWTest.class.getResource("testTaskContent.txt")).toURI());
            QuestionInfo testQuestionInfo = QuestionHandler.getRandomQuestion();
            if (testQuestionInfo.questionDifficulty == null)
                throw new AssertionError("Niepoprawna wartość questionDifficculty (null) wylosowanego pytania");
        }
        catch (URISyntaxException ue) {
            System.err.println("Niepoprawna nazwa pliku, błąd konwersji na URI. Msg:\n\t" + ue.getLocalizedMessage());
            throw new AssertionError(ue.getLocalizedMessage());
        }
        catch (IOException ie) {
            System.err.println("Błąd w metodzie QuestionHandler.getRandomQuestion(). Msg:\n\t" + ie.getLocalizedMessage());
            throw new AssertionError(ie.getLocalizedMessage());
        }
        catch (NullPointerException npe) {
            System.err.println("Niepoprawny URL do pliku, nie można przekonwertować na URI. Msg:\n\t" + npe.getLocalizedMessage());
            throw new AssertionError(npe.getLocalizedMessage());
        }
    }

    @Test public void getRandomQuestionQuestionContentTest() {
        try{
            QuestionHandler.readFromFile(Objects.requireNonNull(MWTest.class.getResource("testTaskContent.txt")).toURI());
            QuestionInfo testQuestionInfo = QuestionHandler.getRandomQuestion();
            if (testQuestionInfo.questionContent == null)
                throw new AssertionError("Niepoprawna treść (null) wylosowanego pytania");
        }
        catch (URISyntaxException ue) {
            System.err.println("Niepoprawna nazwa pliku, błąd konwersji na URI. Msg:\n\t" + ue.getLocalizedMessage());
            throw new AssertionError(ue.getLocalizedMessage());
        }
        catch (IOException ie) {
            System.err.println("Błąd w metodzie QuestionHandler.getRandomQuestion(). Msg:\n\t" + ie.getLocalizedMessage());
            throw new AssertionError(ie.getLocalizedMessage());
        }
        catch (NullPointerException npe) {
            System.err.println("Niepoprawny URL do pliku, nie można przekonwertować na URI. Msg:\n\t" + npe.getLocalizedMessage());
            throw new AssertionError(npe.getLocalizedMessage());
        }
    }

    @Test public void getRandomQuestionCorrectAnswerTest() {
        try{
            QuestionHandler.readFromFile(Objects.requireNonNull(MWTest.class.getResource("testTaskContent.txt")).toURI());
            QuestionInfo testQuestionInfo = QuestionHandler.getRandomQuestion();
            if (testQuestionInfo.correctAnswer == null)
                throw new AssertionError("Niepoprawna odpowiedź (null) do wylosowanego pytania");
        }
        catch (URISyntaxException ue) {
            System.err.println("Niepoprawna nazwa pliku, błąd konwersji na URI. Msg:\n\t" + ue.getLocalizedMessage());
            throw new AssertionError(ue.getLocalizedMessage());
        }
        catch (IOException ie) {
            System.err.println("Błąd w metodzie QuestionHandler.getRandomQuestion(). Msg:\n\t" + ie.getLocalizedMessage());
            throw new AssertionError(ie.getLocalizedMessage());
        }
        catch (NullPointerException npe) {
            System.err.println("Niepoprawny URL do pliku, nie można przekonwertować na URI. Msg:\n\t" + npe.getLocalizedMessage());
            throw new AssertionError(npe.getLocalizedMessage());
        }
    }

    @Test public void getRandomQuestionHintContentTest() {
        try{
            QuestionHandler.readFromFile(Objects.requireNonNull(MWTest.class.getResource("testTaskContent.txt")).toURI());
            QuestionInfo testQuestionInfo = QuestionHandler.getRandomQuestion();
            if (testQuestionInfo.hintContent == null)
                throw new AssertionError("Niepoprawna treść (null) podpowiedzi do wylosowanego pytania");
        }
        catch (URISyntaxException ue) {
            System.err.println("Niepoprawna nazwa pliku, błąd konwersji na URI. Msg:\n\t" + ue.getLocalizedMessage());
            throw new AssertionError(ue.getLocalizedMessage());
        }
        catch (IOException ie) {
            System.err.println("Błąd w metodzie QuestionHandler.getRandomQuestion(). Msg:\n\t" + ie.getLocalizedMessage());
            throw new AssertionError(ie.getLocalizedMessage());
        }
        catch (NullPointerException npe) {
            System.err.println("Niepoprawny URL do pliku, nie można przekonwertować na URI. Msg:\n\t" + npe.getLocalizedMessage());
            throw new AssertionError(npe.getLocalizedMessage());
        }
    }

    @Test public void getRandomQuestionAnswerOptionsTest() {
        try{
            QuestionHandler.readFromFile(Objects.requireNonNull(MWTest.class.getResource("testTaskContent.txt")).toURI());
            QuestionInfo testQuestionInfo = QuestionHandler.getRandomQuestion();
            if (testQuestionInfo.answerOptions.length != 4)
                throw new AssertionError("Niepoprawna ilość odpowiedzi (" + testQuestionInfo.answerOptions.length + ") w wylosowanym pytaniu");
        }
        catch (URISyntaxException ue) {
            System.err.println("Niepoprawna nazwa pliku, błąd konwersji na URI. Msg:\n\t" + ue.getLocalizedMessage());
            throw new AssertionError(ue.getLocalizedMessage());
        }
        catch (IOException ie) {
            System.err.println("Błąd w metodzie QuestionHandler.getRandomQuestion(). Msg:\n\t" + ie.getLocalizedMessage());
            throw new AssertionError(ie.getLocalizedMessage());
        }
        catch (NullPointerException npe) {
            System.err.println("Niepoprawny URL do pliku, nie można przekonwertować na URI. Msg:\n\t" + npe.getLocalizedMessage());
            throw new AssertionError(npe.getLocalizedMessage());
        }
    }

    @Test public void getQuestionsWithSpecifiedDifficultyTest() {
        try{
            QuestionHandler.readFromFile(Objects.requireNonNull(MWTest.class.getResource("testTaskContent.txt")).toURI());
            List<QuestionInfo> selectedQuestions = QuestionHandler.getQuestionsWithSpecifiedDifficulty(Difficulty.EASY);
            for (int i = 0; i < selectedQuestions.size(); ++i) {
                if (selectedQuestions.get(i).questionDifficulty != Difficulty.EASY)
                    throw new AssertionError("Niepoprawny poziom trudności (" + selectedQuestions.get(i).questionDifficulty + ") powinno być EASY");
            }
        }
        catch (URISyntaxException ue) {
            System.err.println("Niepoprawna nazwa pliku, błąd konwersji na URI. Msg:\n\t" + ue.getLocalizedMessage());
            throw new AssertionError(ue.getLocalizedMessage());
        }
        catch (IOException ie) {
            System.err.println("Błąd w metodzie QuestionHandler.getQuestionsWithSpecifiedDifficulty(). Msg:\n\t" + ie.getLocalizedMessage());
            throw new AssertionError(ie.getLocalizedMessage());
        }
        catch (NullPointerException npe) {
            System.err.println("Niepoprawny URL do pliku, nie można przekonwertować na URI. Msg:\n\t" + npe.getLocalizedMessage());
            throw new AssertionError(npe.getLocalizedMessage());
        }
    }

    @Test public void addPrevFailedQuestionsFromFileTest(){
        try {
            QuestionHandler.readFromFile(Objects.requireNonNull(MWTest.class.getResource("testTaskContent.txt")).toURI());
            QuestionHandler.failedQuestionsFilePath = Paths.get(Objects.requireNonNull(MWTest.class.getResource("testFailedQuestions.txt")).toURI());
            QuestionHandler.addPrevFailedQuestionsFromFile();
            if(QuestionHandler.getFailedQuestionSet().isEmpty()){
                throw new AssertionError("Lista z zadaniami do powtórzenia jest pusta");
            }
        }
        catch (URISyntaxException ue) {
            System.err.println("Niepoprawna nazwa pliku, błąd konwersji na URI. Msg:\n\t" + ue.getLocalizedMessage());
            throw new AssertionError(ue.getLocalizedMessage());
        }
        catch (IOException ie) {
            System.err.println("Błąd w metodzie QuestionHandler.addPrevFailedQuestionsFromFile(). Msg:\n\t" + ie.getLocalizedMessage());
            throw new AssertionError(ie.getLocalizedMessage());
        }
        catch (NullPointerException npe) {
            System.err.println("Niepoprawny URL do pliku, nie można przekonwertować na URI. Msg:\n\t" + npe.getLocalizedMessage());
            throw new AssertionError(npe.getLocalizedMessage());
        }
    }

    @Test public void QuestionInfo_setAllTest() {
        QuestionInfo testQuestionInfo = new QuestionInfo();
        String[] testAnswerOptions = new String[]{"A","B","C","D"};
        testQuestionInfo.setAll(0, "correctAnswer", "questionContent", "hintContent", testAnswerOptions, Difficulty.EASY);
        if (!(testQuestionInfo.questionID == 0))
            throw new AssertionError("Niepoprawnie ustawiona wartość questionID");
        if (!Arrays.equals(testQuestionInfo.answerOptions, testAnswerOptions))
            throw new AssertionError("Niepoprawnie ustawiona wartość answerOptions");
        if (!testQuestionInfo.questionContent.equals("questionContent"))
            throw new AssertionError("Niepoprawnie ustawiona wartość questionContent");
        if (!testQuestionInfo.hintContent.equals("hintContent"))
            throw new AssertionError("Niepoprawnie ustawiona wartość hintContent");
        if (!testQuestionInfo.correctAnswer.equals("correctAnswer"))
            throw new AssertionError("Niepoprawnie ustawiona wartość correctAnswer");
    }
}