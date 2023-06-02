package main;

import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

public class SceneInfo {
    public final String name;
    public final FXMLLoader loader;
    public Scene scene;
    public SceneInfo (String name, FXMLLoader loader, Scene scene)
    {
        this.name = name;
        this.loader = loader;
        this.scene = scene;
    }
}