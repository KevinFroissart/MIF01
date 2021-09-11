package fr.univ_lyon1.info.m1.cv_search.view;

import java.util.Observable;
import java.util.Observer;

import fr.univ_lyon1.info.m1.cv_search.controller.CvController;
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

public class JfxView implements Observer {
    private HBox searchSkillsBox;
    private VBox resultBox;
    private HBox skillLevelBox;
    private SkillList skillList;
    private CvController cvController;

    /**
     * Create the main view of the application.
     */
    public JfxView(Stage stage, int width, int height, CvController cvController) {
        this.cvController = cvController;
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

        EventHandler<ActionEvent> skillHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cvController.addSkill(skillList, textField.getText().strip());
                textField.setText("");
                textField.requestFocus();
            }
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
        search.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                resultBox.getChildren().clear();
                ComboBox comboBox = (ComboBox) skillLevelBox.getChildren().get(1);
                String strategy = comboBox.getValue().toString();
                cvController.selectApplicant(strategy, skillList).forEach(
                        applicant -> resultBox.getChildren().add(new Label(applicant.getName()))
                );
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

    /**
     * Adds or removes buttons on the searchSkillBox
     * depending on the skillList state.
     */
    private void updateSkill() {
        searchSkillsBox.getChildren().clear();
        for (String skill : skillList.getSkillList()) {
            Button skillBtn = new Button(skill);
            searchSkillsBox.getChildren().add(skillBtn);
            skillBtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    cvController.removeSkill(skillList, skill);
                }
            });
        }
    }

    @Override
    public void update(Observable observable, Object object) {
        skillList = (SkillList) observable;
        updateSkill();
    }
}
