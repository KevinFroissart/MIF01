package fr.univ_lyon1.info.m1.cv_search.model;

public class FilterGreaterEqual implements FilterStrategy {

    private int level;

    public FilterGreaterEqual(int level) {
        this.level = level;
    }

    /**
     * Strategy to select applicants with a set of skill greater or equal to 60.
     * @param applicants
     * @param skills
     * @return the selected applicants.
     */
    @Override
    public ApplicantList getApplicants(ApplicantList applicants, SkillList skills) {
        ApplicantList selectedApplicants = new ApplicantList();
        for (Applicant applicant : applicants) {
            boolean selected = true;
            for (String skill : skills) {
                if (applicant.getSkill(skill) < level) {
                    selected = false;
                    break;
                }
            }
            if (selected) {
                selectedApplicants.addApplicant(applicant);
            }
        }
        return selectedApplicants;
    }

    public String toString() {
        return "All >= " + level;
    }
}
