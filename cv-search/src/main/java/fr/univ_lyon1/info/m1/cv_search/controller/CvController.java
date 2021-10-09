package fr.univ_lyon1.info.m1.cv_search.controller;

import fr.univ_lyon1.info.m1.cv_search.model.Applicant;
import fr.univ_lyon1.info.m1.cv_search.model.ApplicantList;
import fr.univ_lyon1.info.m1.cv_search.model.ApplicantListBuilder;
import fr.univ_lyon1.info.m1.cv_search.model.FilterStrategy;
import fr.univ_lyon1.info.m1.cv_search.model.SkillList;

import java.io.File;

public final class CvController {

    private SkillList skillList;
    private ApplicantList applicantList;

    public CvController(SkillList skillList, ApplicantList applicantList) {
        this.skillList = skillList;
        this.applicantList = applicantList;
    }

    /**
     * Returns the current {@link SkillList}.
     * @return the {@link SkillList} to be returned
     */
    public SkillList getSkillList() {
        return skillList;
    }

    /**
     * Returns the current {@link ApplicantList}.
     * @return the {@link ApplicantList} to be returned
     */
    public ApplicantList getApplicantList() {
        return applicantList;
    }

    /**
     * Adds a skill to the {@link SkillList}.
     * @param skill The skill to be added
     */
    public void addSkill(String skill) {
        if (!skill.equals("")) {
            skillList.addSkill(skill);
        }
    }

    /**
     * Removes a skill of the {@link SkillList}.
     * @param skill The skill to be removed
     */
    public void removeSkill(String skill) {
        skillList.removeSkill(skill);
    }

    /**
     * Adds a skill to the {@link SkillList}.
     * @param applicant The {@link Applicant} to be added
     */
    public void addApplicant(Applicant applicant) {
        if (applicant != null) {
            applicantList.addApplicant(applicant);
        }
    }

    /**
     * Removes a skill of the {@link SkillList}.
     * @param applicant The {@link Applicant} to be removed
     */
    public void removeApplicant(Applicant applicant) {
        applicantList.removeApplicant(applicant);
    }

    /**
     * Clears the {@link ApplicantList}.
     */
    public void clearApplicants() {
        applicantList.clear();
    }

    /**
     * Selects applicants within a list depending on a set of skills and a filter strategy.
     * @param strategy The {@link FilterStrategy}
     */
    public void selectApplicant(FilterStrategy strategy) {
        clearApplicants();
        if (skillList.size() > 0) {
            ApplicantList listApplicants = new ApplicantListBuilder(new File(".")).build();
            ApplicantList applicants = strategy.getApplicants(listApplicants, skillList);
            for (Applicant applicant : applicants) {
                addApplicant(applicant);
            }
        }
    }
}
