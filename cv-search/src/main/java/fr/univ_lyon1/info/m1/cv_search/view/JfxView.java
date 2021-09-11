package fr.univ_lyon1.info.m1.cv_search.view;

import java.io.File;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import fr.univ_lyon1.info.m1.cv_search.controller.CvController;
import fr.univ_lyon1.info.m1.cv_search.model.Applicant;
import fr.univ_lyon1.info.m1.cv_search.model.ApplicantList;
import fr.univ_lyon1.info.m1.cv_search.model.ApplicantListBuilder;
import fr.univ_lyon1.info.m1.cv_search.model.SkillList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.awt.event.ActionListener;

public class JfxView implements Observer {
    private HBox searchSkillsBox;
    private VBox resultBox;
    private HBox skillLevelBox;
    private SkillList skillList;

    private Button search = new Button("Search");
    Button submitButton = new Button("Add skill");
    Button skillBtn = new Button();

    TextField textField = new TextField();
    ComboBox skillLevel = new ComboBox<>();
    /**
     * Create the main view of the application.
     */
    public JfxView(Stage stage, int width, int height, CvController cvController) {
        // Name of window
        stage.setTitle("Search for CV");

        VBox root = new VBox();

        Node newSkillBox = createNewSkillWidget();
        root.getChildren().add(newSkillBox);

        Node searchSkillsBox = createCurrentSearchSkillsWidget();
        root.getChildren().add(searchSkillsBox);

        Node skillLevelBox = createComboBoxWidget();
        root.getChildren().add(skillLevelBox);

        Node search = createSearchWidget();
        root.getChildren().add(search);

        Node resultBox = createResultsWidget();
        root.getChildren().add(resultBox);

        // Everything's ready: add it to the scene and display it
        Scene scene = new Scene(root, width, height);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * customNotify Create the text field to enter a new skill.
     */
    private Node createNewSkillWidget() {
        HBox newSkillBox = new HBox();
        Label labelSkill = new Label("Skill:");
        newSkillBox.getChildren().addAll(labelSkill, textField, submitButton);
        newSkillBox.setSpacing(10);
        return newSkillBox;
    }

    /**
     * Create the widget showing the list of applicants.
     */
    private Node createResultsWidget() {
        resultBox = new VBox();
        return resultBox;
    }

    /**
     * Create the widget used to trigger the search.
     */
    private Node createSearchWidget() {
        System.out.println("non");
        return search;
    }

    /**
     * Create the widget showing the list of skills currently searched for.
     */
    private Node createCurrentSearchSkillsWidget() {
        searchSkillsBox = new HBox();
        return searchSkillsBox;
    }

    /**
     * Create the widget showing the list of skills currently searched for.
     */
    private Node createComboBoxWidget() {
        skillLevelBox = new HBox();
        ComboBox comboBox = new ComboBox();

        comboBox.getItems().addAll("All >= 50", "All >= 60", "Average => 50");
        comboBox.getSelectionModel().selectFirst();

        Label skillLevelLabel = new Label("Stategy: ");
        skillLevelBox.getChildren().addAll(skillLevelLabel, comboBox);
        return skillLevelBox;
    }

    public Button getSearch() {
        return search;
    }
    public Button getSubmitButton() {
        return submitButton;
    }
    public Button getSkillBtn() {
        return skillBtn;
    }
    public TextField getTextField(){
        return textField;
    }
    public SkillList getSkillList(){
        return skillList;
    }
    public HBox getSearchSkillsBox(){
        return searchSkillsBox;
    }
    public VBox getResultBox(){
        return resultBox;
    }
    public ComboBox getSkillLevel(){
        return skillLevel;
    }
    public HBox getSkillLevelBox(){
        return skillLevelBox;
    }

    public void addLabel(String a){
        resultBox.getChildren().add(new Label(a));
    }

    @Override
    public void update(Observable observable, Object object) {
        skillList = (SkillList) observable;
        System.out.println(skillList.toString());

    }
}
