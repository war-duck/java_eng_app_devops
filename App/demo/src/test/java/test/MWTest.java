package test;

import main.QuestionHandler;
import main.QuestionInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;

@RunWith(BlockJUnit4ClassRunner.class)
public class MWTest {
    @Test public void readFromFileTest() {
        try {
            QuestionHandler.readFromFile(MWTest.class.getResource("testTaskContent.txt").toURI());
            ArrayList<QuestionInfo> receivedList = QuestionHandler.getQuestionList();
            if (receivedList.size() != 4)
                throw new AssertionError("Niepoprawna ilość (" + receivedList.size() + ") wczytanych pytań");
            for (int i = 0; i < receivedList.size(); ++i) { // w żadnym pytaniu nie powinno być pustych wartości
                if (receivedList.get(i).correctAnswer == null)
                    throw new AssertionError("Niepoprawna wartość correctAnswer (null) we wczytanym pytaniu nr " + (i + 1));
                if (receivedList.get(i).questionContent == null)
                    throw new AssertionError("Niepoprawna wartość questionContent (null) we wczytanym pytaniu nr " + (i + 1));
                if (receivedList.get(i).hintContent == null)
                    throw new AssertionError("Niepoprawna wartość hintContent (null) we wczytanym pytaniu nr " + (i + 1));
                if (receivedList.get(i).answerOptions.length != 4)
                    throw new AssertionError("Niepoprawna ilość opcji (" + receivedList.get(i).answerOptions.length + ") w answerOptions we wczytanym pytaniu nr " + (i + 1));
            }
            try {
                    QuestionHandler.readFromFile(null);
                    throw new Exception("Funkcja powinna wyrzucić Exception dla podanej wartości null"); // funkcja powinna zwracać IOException dla parametru null
            }
            catch (IOException ie) {
                if (!(ie.getCause().getMessage().equals("correctBehaviour"))) { // poprawną reakcją jest IOException z Cause zawierającą msg "CorrectBehaviour"
                    System.err.println("Niespodziewany wyjątek IOException w metodzie readFromFile. Msg:\n\t" + ie.getLocalizedMessage());
                    throw ie;
                }
            }
            catch (Exception e) {
                System.err.println("Niespodziewane zachowanie w metodzie readFromFile. Msg:\n\t" + e.getLocalizedMessage());
                throw new AssertionError(e.getLocalizedMessage());
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
    @Test public void getRandomQuestionTest() {
        readFromFileTest();
        QuestionInfo testQuestionInfo = QuestionHandler.getRandomQuestion();
        if (testQuestionInfo.questionContent == null)
            throw new AssertionError("Niepoprawna treść (null) wylosowanego pytania");
        if (testQuestionInfo.correctAnswer == null)
            throw new AssertionError("Niepoprawna odpowiedź (null) do wylosowanego pytania");
        if (testQuestionInfo.hintContent == null)
            throw new AssertionError("Niepoprawna treść (null) podpowiedzi do wylosowanego pytania");
        if (testQuestionInfo.answerOptions.length != 4)
            throw new AssertionError("Niepoprawna ilość odpowiedzi (" + testQuestionInfo.answerOptions.length + ") w wylosowanym pytaniu");
    }
    @Test public void QuestionInfo_setAllTest() {
        QuestionInfo testQuestionInfo = new QuestionInfo();
        String[] testAnswerOptions = new String[]{"A","B","C","D"};
        testQuestionInfo.setAll(0, "correctAnswer", "questionContent", "hintContent", testAnswerOptions);
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