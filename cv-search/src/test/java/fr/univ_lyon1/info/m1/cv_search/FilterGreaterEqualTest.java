package fr.univ_lyon1.info.m1.cv_search;

import fr.univ_lyon1.info.m1.cv_search.model.*;
import fr.univ_lyon1.info.m1.cv_search.model.applicant.Applicant;
import fr.univ_lyon1.info.m1.cv_search.model.applicant.ApplicantList;
import fr.univ_lyon1.info.m1.cv_search.model.filter.FilterGreaterEqual;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FilterGreaterEqualTest {
    @Test
    public void testGreaterEqualFilter() {
        System.out.println("--------------FilterGreaterEqualTest---------------");

        ApplicantList list = new ApplicantList();
        String[] skills = {"java", "c", "c++", "js"};

        Applicant a = new Applicant();
        a.setName("Hamza");
        a.setSkill("java", 10);
        a.setSkill("c", 20);

        Applicant b = new Applicant();
        b.setName("Kevin");
        b.setSkill("js", 30);
        b.setSkill("c++", 40);

        Applicant c = new Applicant();
        c.setName("Toto");
        c.setSkill("java", 50);
        c.setSkill("js", 60);

        list.addApplicant(a);
        list.addApplicant(b);
        list.addApplicant(c);

        FilterGreaterEqual filterGreaterEqual = new FilterGreaterEqual(35);
        //assertThat("All >= 70", is(filterGreaterEqual.toString()));
        SkillList skillList = new SkillList();
        for (String s : skills) {
            skillList.addSkill(s.toString());
        }
        //filterGreaterEqual.getApplicants(list, skillList);



        System.out.println("La liste: " + filterGreaterEqual.getApplicants(list, skillList));


    }
}
