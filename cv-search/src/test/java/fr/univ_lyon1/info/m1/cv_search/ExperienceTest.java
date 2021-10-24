package fr.univ_lyon1.info.m1.cv_search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.univ_lyon1.info.m1.cv_search.model.Experience;
import fr.univ_lyon1.info.m1.cv_search.model.SkillList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ExperienceTest {

    private Experience experience;

    @BeforeEach
    public void setUp() {
        // Given 
        experience = new Experience();
    }

    @Test
    public void testAddSkill() {
        // When
        experience.setCompany("UCBL");
        experience.setStart(2010);

        //Then
        assertThat(2010, is(experience.getStart()));
    }
}
