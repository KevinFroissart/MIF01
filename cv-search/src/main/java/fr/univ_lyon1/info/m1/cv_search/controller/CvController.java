package fr.univ_lyon1.info.m1.cv_search.controller;

import fr.univ_lyon1.info.m1.cv_search.model.ApplicantList;
import fr.univ_lyon1.info.m1.cv_search.model.ApplicantListBuilder;
import fr.univ_lyon1.info.m1.cv_search.model.FilterStrategy;
import fr.univ_lyon1.info.m1.cv_search.model.SkillList;
import fr.univ_lyon1.info.m1.cv_search.view.JfxView;

import java.io.File;

public final class CvController {

    private static volatile CvController instance = null;

    private SkillList skillList;
    private static FilterStrategy filterStrategy;

    private CvController(JfxView view) {
        this.skillList = new SkillList();
        skillList.addObserver(view);
        skillList.customNotify();
    }

    public static CvController getInstance(JfxView view) {
        if (CvController.instance == null) {
            synchronized (CvController.class) {
                if (CvController.instance == null) {
                    CvController.instance = new CvController(view);
                }
            }
        }
        return instance;
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
    public ApplicantList selectApplicant(FilterStrategy strategy) {
        ApplicantList listApplicants = new ApplicantListBuilder(new File(".")).build();
        return strategy.getApplicants(listApplicants, skillList);
    }

}
