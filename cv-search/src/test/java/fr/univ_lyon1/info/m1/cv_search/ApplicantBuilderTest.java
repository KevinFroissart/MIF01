package fr.univ_lyon1.info.m1.cv_search;

import fr.univ_lyon1.info.m1.cv_search.model.Applicant;
import fr.univ_lyon1.info.m1.cv_search.model.ApplicantBuilder;
import fr.univ_lyon1.info.m1.cv_search.model.ApplicantList;
import fr.univ_lyon1.info.m1.cv_search.model.ApplicantListBuilder;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ApplicantBuilderTest {
    @Test
    public void testBuildApplicant() {
        System.out.println("--------------ApplicantBuilderTest---------------");

        ApplicantListBuilder builder = new ApplicantListBuilder(new File("."));
        ApplicantList a = builder.build();
        Applicant applicant = new Applicant();
        applicant.setName("toto");
        a.addApplicant(applicant);
        assertThat("toto", is(a.getList().get(a.size()-1).getName()));

    }
}
