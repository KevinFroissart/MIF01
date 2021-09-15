package fr.univ_lyon1.info.m1.cv_search.model;

public class FilterLesser implements FilterStrategy {

    @Override
    public ApplicantList getApplicants(int level, ApplicantList applicants, SkillList skills) {
        ApplicantList selectedApplicants = new ApplicantList();
        for (Applicant applicant : applicants) {
            boolean selected = true;
            for (String skill : skills) {
                if (applicant.getSkill(skill) > level) {
                    selected = false;
                    break;
                }
            }
            if (selected) {
                selectedApplicants.add(applicant);
            }
        }
        return selectedApplicants;
    }
}
