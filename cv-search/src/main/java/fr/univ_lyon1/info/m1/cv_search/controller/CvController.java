package fr.univ_lyon1.info.m1.cv_search.controller;

import fr.univ_lyon1.info.m1.cv_search.model.Applicant;
import fr.univ_lyon1.info.m1.cv_search.model.ApplicantList;
import fr.univ_lyon1.info.m1.cv_search.model.ApplicantListBuilder;
import fr.univ_lyon1.info.m1.cv_search.model.SkillList;
import fr.univ_lyon1.info.m1.cv_search.view.JfxView;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Scanner;

public class CvController extends Observable {

    private SkillList skillList;

    public CvController(Stage stage) {
        this.skillList = new SkillList();
        JfxView mainScreen = new JfxView(this, stage, 600, 600);
        skillList.addObserver(mainScreen);
        skillList.customNotify();
    }

    /**
     * Adds a skill to the skillList.
     * @param skill
     */
    public void addSkill(String skill) {
        if (!skill.equals("")) {
            skillList.addSkill(skill);
        }
    }

    /**
     * Removes a skill of the skillList.
     * @param skill
     */
    public void removeSkill(String skill) {
        skillList.removeSkill(skill);
    }

    /**
     * Selects applicants within a list depending on a set of skills and a filter strategy.
     * @param strategy
     * @return
     */
    public List<Applicant> selectApplicant(String strategy) {
        ApplicantList listApplicants = new ApplicantListBuilder(new File(".")).build();
        List<Applicant> selectedApplicants = new ArrayList<>();

        int level = new Scanner(strategy).useDelimiter("\\D+").nextInt();
        boolean average = strategy.contains("Average");

        for (Applicant applicant : listApplicants) {
            boolean selected = true;
            int total = 0;
            int cpt = 0;

            for (String skill : skillList) {
                if (!average && applicant.getSkill(skill) < level) {
                    selected = false;
                    break;
                } else {
                    total += applicant.getSkill(skill);
                    cpt++;
                }
            }
            if (average && total / cpt < 50) {
                selected = false;
            }
            if (selected) {
                selectedApplicants.add(applicant);
            }
        }
        return selectedApplicants;
    }

}
