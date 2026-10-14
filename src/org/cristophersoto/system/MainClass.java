package org.cristophersoto.system;

import javafx.application.Application;
import javafx.stage.Stage;
import org.cristophersoto.system.utils.SceneManager;
import org.cristophersoto.system.utils.ViewFactory;

public class MainClass extends Application {

    @Override
    public void start(Stage stage) {
        SceneManager.setStage(stage);
        ViewFactory.mostrarLogin();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
