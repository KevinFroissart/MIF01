package fr.univ_lyon1.info.m1.cv_search;

import fr.univ_lyon1.info.m1.cv_search.model.applicant.Applicant;
import fr.univ_lyon1.info.m1.cv_search.model.applicant.ApplicantList;
import fr.univ_lyon1.info.m1.cv_search.model.applicant.ApplicantListBuilder;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ApplicantBuilderTest {
    @Test
    public void testBuildApplicant() {
        System.out.println("--------------ApplicantBuilderTest---------------");

        // Given
        ApplicantListBuilder builder = new ApplicantListBuilder(new File("."));
        Applicant applicant = new Applicant();
        applicant.setName("toto");

        // When
        ApplicantList a = builder.build();
        a.addApplicant(applicant);

        // Then
        assertThat("toto", is(a.getList().get(a.size()-1).getName()));
    }
}
