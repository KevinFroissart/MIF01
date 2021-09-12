package fr.univ_lyon1.info.m1.cv_search;

import fr.univ_lyon1.info.m1.cv_search.controller.CvController;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main class for the application (structure imposed by JavaFX).
 */
public class App extends Application {

    /**
     * With javafx, start() is called when the application is launched.
     */
    @Override
    public void start(Stage stage) {
        new CvController(stage);
    }

    /**
     * A main method in case the user launches the application using
     * App as the main class.
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
}
