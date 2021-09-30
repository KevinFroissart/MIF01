package fr.univ_lyon1.info.m1.cv_search.controller;

import fr.univ_lyon1.info.m1.cv_search.model.ApplicantList;
import fr.univ_lyon1.info.m1.cv_search.model.ApplicantListBuilder;
import fr.univ_lyon1.info.m1.cv_search.model.FilterStrategy;
import fr.univ_lyon1.info.m1.cv_search.model.SkillList;

import java.io.File;

public final class CvController {

    private SkillList skillList;

    public CvController(SkillList skillList) {
        this.skillList = skillList;
    }

    /**
     * Adds a skill to the skillList.
     * @param skill The skill to be added
     */
    public void addSkill(String skill) {
        if (!skill.equals("")) {
            skillList.addSkill(skill);
        }
    }

    /**
     * Removes a skill of the skillList.
     * @param skill The skill to be removed
     */
    public void removeSkill(String skill) {
        skillList.removeSkill(skill);
    }

    /**
     * Selects applicants within a list depending on a set of skills and a filter strategy.
     * @param strategy
     * @return the list of selected applicants.
     */
    public ApplicantList selectApplicant(FilterStrategy strategy) {
        ApplicantList listApplicants = new ApplicantListBuilder(new File(".")).build();
        return skillList.size() > 0
                ? strategy.getApplicants(listApplicants, skillList)
                : new ApplicantList();
    }

}
