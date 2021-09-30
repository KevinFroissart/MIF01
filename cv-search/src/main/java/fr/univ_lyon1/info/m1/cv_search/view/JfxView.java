package fr.univ_lyon1.info.m1.cv_search.view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import fr.univ_lyon1.info.m1.cv_search.controller.CvController;
import fr.univ_lyon1.info.m1.cv_search.model.Applicant;
import fr.univ_lyon1.info.m1.cv_search.model.ApplicantList;
import fr.univ_lyon1.info.m1.cv_search.model.FilterAverageFifty;
import fr.univ_lyon1.info.m1.cv_search.model.FilterGEFifty;
import fr.univ_lyon1.info.m1.cv_search.model.FilterGESixty;
import fr.univ_lyon1.info.m1.cv_search.model.FilterLEFifty;
import fr.univ_lyon1.info.m1.cv_search.model.FilterStrategy;

import fr.univ_lyon1.info.m1.cv_search.model.SkillList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JfxView implements PropertyChangeListener {

    private CvController cvController;

    private HBox searchSkillsBox;
    private VBox resultBox;
    private HBox skillLevelBox;

    /**
     * Create the main view of the application.
     */
    public JfxView(Stage stage, int width, int height) {
        SkillList skillList = new SkillList();
        skillList.addPropertyChangeListener(this);

        this.cvController = new CvController(skillList);

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

        Scene scene = new Scene(root, width, height);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Create the text field to enter a new skill.
     */
    private Node createNewSkillWidget() {
        HBox newSkillBox = new HBox();
        Label labelSkill = new Label("Skill:");
        TextField textField = new TextField();
        Button submitButton = new Button("Add skill");
        newSkillBox.getChildren().addAll(labelSkill, textField, submitButton);
        newSkillBox.setSpacing(10);

        EventHandler<ActionEvent> skillHandler = event -> {
            cvController.addSkill(textField.getText().trim());
            textField.setText("");
            textField.requestFocus();
        };
        submitButton.setOnAction(skillHandler);
        textField.setOnAction(skillHandler);
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
        Button search = new Button("Search");
        search.setOnAction(event -> {
            resultBox.getChildren().clear();
            ComboBox comboBox = (ComboBox) skillLevelBox.getChildren().get(1);
            FilterStrategy strategy = (FilterStrategy) comboBox.getValue();
            ApplicantList applicantList = cvController.selectApplicant(strategy);
            for (Applicant applicant : applicantList) {
                resultBox.getChildren().add(new Label(applicant.getName()));
            }
        });
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
     * Create the widget showing the dropdown list of skill research strategies.
     */
    private Node createComboBoxWidget() {
        skillLevelBox = new HBox();
        ComboBox comboBox = new ComboBox();

        List<FilterStrategy> strategyList = new ArrayList<>();
        strategyList.add(new FilterLEFifty());
        strategyList.add(new FilterGEFifty());
        strategyList.add(new FilterGESixty());
        strategyList.add(new FilterAverageFifty());

        comboBox.getItems().addAll(strategyList);
        comboBox.getSelectionModel().selectFirst();

        Label skillLevelLabel = new Label("Stategy: ");
        skillLevelBox.getChildren().addAll(skillLevelLabel, comboBox);
        return skillLevelBox;
    }

    /**
     * Updates the skillWidget.
     */
    private void updateSkillWidget(List<String> skillList) {
        searchSkillsBox.getChildren().clear();

        for (String skill : skillList) {
            final HBox box = new HBox();

            final Button b = new Button("x");
            final Label labelContact = new Label(skill);
            b.setOnAction(event ->  cvController.removeSkill(skill));

            box.setStyle("-fx-padding: 2;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 1;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: black;");
            box.setAlignment(Pos.BASELINE_CENTER);
            box.getChildren().addAll(labelContact, b);
            searchSkillsBox.getChildren().addAll(box);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "skillList":
                updateSkillWidget((List<String>) evt.getNewValue());
                break;
            default: break;
        }

    }
}
