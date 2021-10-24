package fr.univ_lyon1.info.m1.cv_search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.univ_lyon1.info.m1.cv_search.model.SkillList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SkillListTest {

    private SkillList s;

    @BeforeEach
    public void setUp() {
        // Given 
        s = new SkillList();;
    }

    @Test
    public void testAddSkill() {
        System.out.println("--------------SkillListTest---------------");
        // When
        s.addSkill("c");
        s.addSkill("c++");

        Boolean found = s.toString().contains("c++");
        found = s.toString().contains("c");
        //Then
        assertThat(found, is(true));

        s.removeSkill("c++");
        found = s.toString().contains("c++");
        //Then
        assertThat(found, is(false));
    }
}
