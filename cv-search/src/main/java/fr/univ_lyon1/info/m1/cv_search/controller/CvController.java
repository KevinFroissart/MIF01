package fr.univ_lyon1.info.m1.cv_search.controller;

import java.io.File;
import java.util.Observable;
import java.util.Scanner;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionListener;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import fr.univ_lyon1.info.m1.cv_search.model.Applicant;
import fr.univ_lyon1.info.m1.cv_search.model.ApplicantList;
import fr.univ_lyon1.info.m1.cv_search.model.ApplicantListBuilder;
import fr.univ_lyon1.info.m1.cv_search.view.JfxView;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class CvController extends Observable { 

    public CvController(){
        
    }
    public CvController(JfxView view){
        setView(view);
    }

    public void setView(JfxView view){

        //link Controller to View - methods for buttons
        view.getSearch().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ApplicantList listApplicants = new ApplicantListBuilder(new File(".")).build();
                view.getResultBox().getChildren().clear();
                for (Applicant a : listApplicants) {
                    boolean selected = true;
                    int total = 0;
                    int cpt = 0;
                    for (Node skill : view.getSearchSkillsBox().getChildren()) {
                        String skillName = ((Button) skill).getText();
                        ComboBox skillLevel = (ComboBox) view.getSkillLevelBox().getChildren().get(1);
                        if (skillLevel.getValue().toString().contains("Average")) {
                            total += a.getSkill(skillName);
                            cpt++;
                        } else {
                            String levelString = skillLevel.getValue().toString();
                            int level = new Scanner(levelString).useDelimiter("\\D+").nextInt();
                            if (a.getSkill(skillName) < level) {
                                selected = false;
                                break;
                            }
                        }
                    }
                    if (total != 0 && total / cpt < 50) {
                        selected = false;
                    }
                    if (selected) {
                        view.addLabel(a.getName());
                    }
                }
            }
        });
        view.getSkillBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("supprimer le bouton");
                view.getSearchSkillsBox().getChildren().remove(view.getSkillBtn());
            }
        });
        view.getSubmitButton().setOnAction(event -> {
            System.out.println( view.getTextField().getText());

            String text = view.getTextField().getText().strip();
            if (text.equals("")) {
                return; // Do nothing
            }
            view.getSkillList().addSkill(text);
            Button btn =  new Button(text);
            view.getSearchSkillsBox().getChildren().add(btn);

            view.getTextField().setText("");
            view.getTextField().requestFocus();

            event.consume();
        });    
    }
}
