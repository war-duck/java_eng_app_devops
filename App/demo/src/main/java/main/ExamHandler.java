package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ExamHandler {
    private ExamHandler(){}
    private static HashSet<Integer> failedQuestionLocalSet; // kopia wszystkich źle wykonanych zadań
    protected static final List<QuestionInfo> solvedQuestions = new ArrayList<>();
    public static QuestionInfo currentQuestionInfo; // zmienia się w trakcie trwania
    public static SceneInfo currentSceneInfo;
    public static void startExam() throws IOException {
        failedQuestionLocalSet = QuestionHandler.getFailedQuestionSet();
        if (failedQuestionLocalSet.isEmpty()) // jeżeli nie ma pytań do powtórzenia to nie zaczynany jest test
            return;
        nextQuestion();
    }
    public static void endExam(Boolean wasSuccessful) throws IOException {
        if (wasSuccessful) {
            QuestionHandler.getFailedQuestionSet().clear(); // egzamin zakończył się pomyślnie, można wyczyścić zestaw z zadaniami
            currentSceneInfo = SceneHandler.showScene("examResultScreen");
            loadExamResultToScreen((ExamScreenController)currentSceneInfo.loader.getController());
        }
        else {
            System.out.println("Egzamin przerwany");
            System.out.println("Sprawdzenie:\nIsEmpty? " + QuestionHandler.getQuestionList().isEmpty());
            SceneHandler.showScene("MainScreen"); // domyślnie będzie ładowana scena z wynikiem
        }
    }

    private static void loadExamResultToScreen(ExamScreenController controller) {
        controller.setWordNumberLabelText("Powtórzono " + solvedQuestions.size() + (solvedQuestions.size() >= 5 ? " słówek" : solvedQuestions.size() >= 1 ? " słówka" : "słówko"));
        StringBuilder words = new StringBuilder();
        for (QuestionInfo questionInfo : solvedQuestions)
            words.append(questionInfo.correctAnswer).append("; ");
        controller.setWordListLabelText("Słówka: " + words.toString());
    }

    private static void startQuestion() throws IOException {
        currentSceneInfo = SceneHandler.getSceneInfo("examScreen");
        QuestionHandler.sendTaskInfoToController(currentQuestionInfo, currentSceneInfo.loader); // wysyłamy info o zadaniu do kontrolera danego pliku
        App.stage.setScene(currentSceneInfo.scene);
        App.stage.show();
    }
    public static void nextQuestion() throws IOException {
        if (failedQuestionLocalSet.isEmpty()) {
            endExam(true);
            return;
        }
        else {
            System.out.println(failedQuestionLocalSet.size() + "\n\n");
        }
        currentQuestionInfo = QuestionHandler.getRandomFailedQuestion(failedQuestionLocalSet);
        System.out.println(currentQuestionInfo);
        startQuestion();
        popCurrentQuestion();
    }
    public static void popCurrentQuestion() {
        failedQuestionLocalSet.remove(currentQuestionInfo.questionID);
    }
    public static void addCurrentQuestionToSolved() {
        solvedQuestions.add(currentQuestionInfo);
    }
}
