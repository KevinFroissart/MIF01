package fr.univ_lyon1.info.m1.cv_search.controller;

import fr.univ_lyon1.info.m1.cv_search.model.FilterAverage;
import fr.univ_lyon1.info.m1.cv_search.model.FilterGreater;
import fr.univ_lyon1.info.m1.cv_search.model.FilterLesser;
import fr.univ_lyon1.info.m1.cv_search.model.ApplicantList;
import fr.univ_lyon1.info.m1.cv_search.model.ApplicantListBuilder;
import fr.univ_lyon1.info.m1.cv_search.model.FilterStrategy;
import fr.univ_lyon1.info.m1.cv_search.model.SkillList;

import java.io.File;
import java.util.Scanner;

public final class CvController {

    private SkillList skillList;
    private static FilterStrategy filterStrategy;

    public CvController(SkillList skillList) {
        this.skillList = skillList;
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
    public ApplicantList selectApplicant(String strategy) {
        ApplicantList listApplicants = new ApplicantListBuilder(new File(".")).build();
        int level = new Scanner(strategy).useDelimiter("\\D+").nextInt();

        if (strategy.contains("Average")) {
            filterStrategy = new FilterAverage();
        } else if (strategy.contains(">=")) {
            filterStrategy = new FilterGreater();
        } else if (strategy.contains("<=")) {
            filterStrategy = new FilterLesser();
        }
        return filterStrategy.getApplicants(level, listApplicants, skillList);
    }

}
