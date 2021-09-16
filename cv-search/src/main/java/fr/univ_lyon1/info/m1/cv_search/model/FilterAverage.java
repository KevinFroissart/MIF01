package fr.univ_lyon1.info.m1.cv_search.model;

public class FilterAverage implements FilterStrategy {

    @Override
    public ApplicantList getApplicants(ApplicantList applicants, SkillList skills) {
        int level = 50;
        ApplicantList selectedApplicants = new ApplicantList();
        for (Applicant applicant : applicants) {
            int total = 0;
            int cpt = 0;
            for (String skill : skills) {
                total += applicant.getSkill(skill);
                cpt++;
            }
            if (total / cpt >= level) {
                selectedApplicants.add(applicant);
            }
        }
        return selectedApplicants;
    }

    public String toString() {
        return "Average => 50";
    }
}
