package fr.univ_lyon1.info.m1.cv_search.model;

import java.util.ArrayList;
import java.util.List;

public class FilterLesserEqual implements FilterStrategy {

    private int level;

    public FilterLesserEqual(int level) {
        this.level = level;
    }

    /**
     * Strategy to select applicants with a set of skill
     * lesser or equal to an integer specified in the constructor.
     * @param applicants
     * @param skills
     * @return the selected applicants.
     */
    @Override
    public ApplicantList getApplicants(ApplicantList applicants, SkillList skills) {
        ApplicantList selectedApplicants = new ApplicantList();
        for (Applicant applicant : applicants) {
            boolean selected = true;
            List<Integer> marks = new ArrayList<>();
            for (String skill : skills) {
                if (applicant.getSkill(skill) > level) {
                    selected = false;
                    break;
                } else {
                    marks.add(applicant.getSkill(skill));
                }
            }
            if (selected) {
                applicant.setAverage(marks.stream().mapToDouble(a -> a).average().getAsDouble());
                selectedApplicants.addApplicant(applicant);
            }
        }
        return selectedApplicants;
    }

    public String toString() {
        return "All <= " + level;
    }
}
