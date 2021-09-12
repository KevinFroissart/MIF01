package fr.univ_lyon1.info.m1.cv_search.model;

public interface FilterStrategy {
    ApplicantList getApplicants(int amount, ApplicantList applicantList, SkillList skillList);
}
