package test;

import javafx.event.ActionEvent;

import java.io.IOException;

public class RankingScreenController {
    public void goBack(ActionEvent actionEvent) throws IOException {
        SceneHandler.showScene("mainScreen");
    }
}
