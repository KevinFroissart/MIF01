package fr.univ_lyon1.info.m1.cv_search.model.filter;

import fr.univ_lyon1.info.m1.cv_search.model.applicant.Applicant;
import fr.univ_lyon1.info.m1.cv_search.model.applicant.ApplicantList;
import fr.univ_lyon1.info.m1.cv_search.model.Experience;
import fr.univ_lyon1.info.m1.cv_search.model.SkillList;

public class FilterExperience implements FilterStrategy {

    private int yearsOfExperience;

    public FilterExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    /**
     * Strategy to select applicants depending on their experience.
     * @param applicants
     * @param skills
     * @return the selected applicants.
     */
    @Override
    public ApplicantList getApplicants(ApplicantList applicants, SkillList... skills) {
        ApplicantList selectedApplicants = new ApplicantList();
        for (Applicant applicant : applicants) {
            int start = 9999;
            int end = 0;
            for (Experience experience : applicant.getExperiences()) {
                if (experience.getStart() < start) {
                    start = experience.getStart();
                }
                if (experience.getEnd() > end) {
                    end = experience.getEnd();
                }
            }
            if (Math.abs(end - start) >= yearsOfExperience) {
                selectedApplicants.addApplicant(applicant);
            }
        }
        return selectedApplicants;
    }

    public String toString() {
        return yearsOfExperience == 0
                ? "None required"
                : "At least " + yearsOfExperience + " years";
    }
}
