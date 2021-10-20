package fr.univ_lyon1.info.m1.cv_search.model.filter;

import fr.univ_lyon1.info.m1.cv_search.model.applicant.ApplicantList;
import fr.univ_lyon1.info.m1.cv_search.model.SkillList;

public interface FilterStrategy {
    ApplicantList getApplicants(ApplicantList applicantList, SkillList... skillList);
}
