package test;

import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

public class SceneInfo {
    public String name;
    public FXMLLoader loader;
    public Scene scene;
    public SceneInfo (String name, FXMLLoader loader, Scene scene)
    {
        this.name = name;
        this.loader = loader;
        this.scene = scene;
    }
}