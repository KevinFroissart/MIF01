package fr.univ_lyon1.info.m1.cv_search.controller;

import fr.univ_lyon1.info.m1.cv_search.model.applicant.Applicant;
import fr.univ_lyon1.info.m1.cv_search.model.applicant.ApplicantList;
import fr.univ_lyon1.info.m1.cv_search.model.applicant.ApplicantListBuilder;
import fr.univ_lyon1.info.m1.cv_search.model.filter.FilterAverage;
import fr.univ_lyon1.info.m1.cv_search.model.filter.FilterExperience;
import fr.univ_lyon1.info.m1.cv_search.model.filter.FilterGreaterEqual;
import fr.univ_lyon1.info.m1.cv_search.model.filter.FilterLesserEqual;
import fr.univ_lyon1.info.m1.cv_search.model.filter.FilterListSingleton;
import fr.univ_lyon1.info.m1.cv_search.model.filter.FilterStrategy;
import fr.univ_lyon1.info.m1.cv_search.model.SkillList;

import java.io.File;

public final class CvController {

    private SkillList skillList;
    private ApplicantList applicantList;

    public CvController(SkillList skillList, ApplicantList applicantList) {
        this.skillList = skillList;
        this.applicantList = applicantList;
        initStrategies();
    }

    /**
     * Initialise the lists of {@link FilterStrategy}.
     */
    public void initStrategies() {
        FilterListSingleton filterList = FilterListSingleton.getInstance();
        filterList.addSkillStrategy(new FilterLesserEqual(50));
        filterList.addSkillStrategy(new FilterGreaterEqual(50));
        filterList.addSkillStrategy(new FilterGreaterEqual(60));
        filterList.addSkillStrategy(new FilterAverage(50));
        filterList.addExperienceStrategy(new FilterExperience(0));
        filterList.addExperienceStrategy(new FilterExperience(2));
        filterList.addExperienceStrategy(new FilterExperience(3));
        filterList.addExperienceStrategy(new FilterExperience(5));
        filterList.addExperienceStrategy(new FilterExperience(10));
        filterList.addExperienceStrategy(new FilterExperience(20));
    }

    /**
     * Return the current {@link SkillList}.
     * @return the {@link SkillList} to be returned
     */
    public SkillList getSkillList() {
        return skillList;
    }

    /**
     * Return the current {@link ApplicantList}.
     * @return the {@link ApplicantList} to be returned
     */
    public ApplicantList getApplicantList() {
        return applicantList;
    }

    /**
     * Add a skill to the {@link SkillList}.
     * @param skill The skill to be added
     */
    public void addSkill(String skill) {
        if (!skill.equals("")) {
            skillList.addSkill(skill);
        }
    }

    /**
     * Remove a skill of the {@link SkillList}.
     * @param skill The skill to be removed
     */
    public void removeSkill(String skill) {
        skillList.removeSkill(skill);
    }

    /**
     * Add a skill to the {@link SkillList}.
     * @param applicant The {@link Applicant} to be added
     */
    public void addApplicant(Applicant applicant) {
        if (applicant != null) {
            applicantList.addApplicant(applicant);
        }
    }

    /**
     * Remove a skill of the {@link SkillList}.
     * @param applicant The {@link Applicant} to be removed
     */
    public void removeApplicant(Applicant applicant) {
        applicantList.removeApplicant(applicant);
    }

    /**
     * Clear the {@link ApplicantList}.
     */
    public void clearApplicants() {
        applicantList.clear();
    }

    /**
     * Select applicants within a list depending on a set of skills and a filter strategy.
     * @param skillStrategy The {@link FilterStrategy}
     */
    public void selectApplicant(FilterStrategy skillStrategy, FilterStrategy experienceStrategy) {
        clearApplicants();
        if (skillList.size() > 0) {
            ApplicantList listApplicants = new ApplicantListBuilder(new File(".")).build();
            ApplicantList firstSet = skillStrategy.getApplicants(listApplicants, skillList);
            ApplicantList secondSet = experienceStrategy.getApplicants(firstSet);
            for (Applicant applicant : secondSet) {
                addApplicant(applicant);
            }
        }
    }
}
