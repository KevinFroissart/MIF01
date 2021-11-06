package fr.univ_lyon1.info.m1.cv_search;

import org.junit.jupiter.api.Test;

import fr.univ_lyon1.info.m1.cv_search.model.Experience;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ExperienceTest {

    @Test
    public void testAddExperience() {

        // Given
        Experience experience = new Experience();

        // When
        experience.setCompany("UCBL");
        experience.setStart(2010);

        //Then
        assertThat(2010, is(experience.getStart()));
    }
}
