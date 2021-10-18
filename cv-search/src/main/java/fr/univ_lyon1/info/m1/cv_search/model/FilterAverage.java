package fr.univ_lyon1.info.m1.cv_search.model;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class FilterAverage implements FilterStrategy {

    private int level;

    public FilterAverage(int level) {
        this.level = level;
    }

    /**
     * Strategy to select applicants with a set of skill
     * averaging an integer specified in the constructor.
     * @param applicants
     * @param skills
     * @return the selected applicants.
     */
    @Override
    public ApplicantList getApplicants(ApplicantList applicants, SkillList skills) {
        ApplicantList selectedApplicants = new ApplicantList();
        for (Applicant applicant : applicants) {
            List<Integer> marks = new ArrayList<>();
            for (String skill : skills) {
                marks.add(applicant.getSkill(skill));
            }
            OptionalDouble average = marks.stream().mapToDouble(a -> a).average();
            if (average.isPresent() && average.getAsDouble() >= level) {
                applicant.setAverage(average.getAsDouble());
                selectedApplicants.addApplicant(applicant);
            }
        }
        return selectedApplicants;
    }

    public String toString() {
        return "Average >= " + level;
    }
}
