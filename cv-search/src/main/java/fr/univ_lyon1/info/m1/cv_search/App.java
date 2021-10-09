package fr.univ_lyon1.info.m1.cv_search;

import fr.univ_lyon1.info.m1.cv_search.controller.CvController;
import fr.univ_lyon1.info.m1.cv_search.model.ApplicantList;
import fr.univ_lyon1.info.m1.cv_search.model.SkillList;
import fr.univ_lyon1.info.m1.cv_search.view.JfxView;
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
        SkillList skillList = new SkillList();
        ApplicantList applicantList = new ApplicantList();
        CvController cvController = new CvController(skillList, applicantList);
        new JfxView(cvController, stage, 600, 600);
        new JfxView(cvController, new Stage(), 600, 600);
    }

    /**
     * A main method in case the user launches the application using
     * App as the main class.
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
}
