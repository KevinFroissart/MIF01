package fr.univ_lyon1.info.m1.cv_search;

import java.io.File;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

import fr.univ_lyon1.info.m1.cv_search.model.applicant.Applicant;
import fr.univ_lyon1.info.m1.cv_search.model.applicant.ApplicantList;
import fr.univ_lyon1.info.m1.cv_search.model.applicant.ApplicantListBuilder;
import fr.univ_lyon1.info.m1.cv_search.model.filter.FilterAverage;
import fr.univ_lyon1.info.m1.cv_search.model.SkillList;

public class FilterAverageTest {
    @Test
    public void testFilterAverage() {
        System.out.println("--------------FilterAverageTest---------------");

        // Given
        ApplicantListBuilder builder = new ApplicantListBuilder(new File("."));

        ApplicantList list = builder.build();

        Applicant a = new Applicant();
        a.setName("Hamza");
        a.setSkill("java", 20);
        a.setSkill("c", 30);

        Applicant b = new Applicant();
        b.setName("Kevin");
        b.setSkill("java", 70);
        b.setSkill("c", 70);

        SkillList skills = new SkillList();
        skills.addSkill("c");
        skills.addSkill("java");

        FilterAverage average = new FilterAverage(50);
        list.addApplicant(a);
        list.addApplicant(b);

        // When
        ApplicantList al = average.getApplicants(list, skills);

        boolean foundKevin = false;
        for(Applicant model : al) {
            if (model.getName() == "Kevin") {
                foundKevin = true;
            }
        }

        // Then
        assertThat(foundKevin, is(true));
    }
}
