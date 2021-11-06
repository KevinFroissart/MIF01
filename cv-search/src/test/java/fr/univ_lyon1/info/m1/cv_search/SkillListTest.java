package fr.univ_lyon1.info.m1.cv_search;

import org.junit.jupiter.api.Test;

import fr.univ_lyon1.info.m1.cv_search.model.SkillList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SkillListTest {

    @Test
    public void testAddSkill() {
        // Given
        SkillList s = new SkillList();
        s.addSkill("c");
        s.addSkill("c++");

        // When
        Boolean found = s.toString().contains("c++");
        assertThat(found, is(true));
        found = s.toString().contains("c");
        assertThat(found, is(true));
        
        s.removeSkill("c++");
        found = s.toString().contains("c++");
        assertThat(found, is(false));
        assertThat(found, matches(hasSize(1)).and(contains(42)));
    }



    @Test
    public void testRemoveSkill() {
        // Given
        SkillList s = new SkillList();
        Boolean found = false;

        // When  
        s.addSkill("c++");    
        s.removeSkill("c++");
        found = s.toString().contains("c++");

        // Then
        assertThat(found, is(false));
    }

    @Test
    public void testRemoveEmptySkill() {
        // Given
        SkillList s = new SkillList();
        Boolean found = false;

        // When  
        found = s.toString().contains("c++");

        // Then
        assertThat(found, is(false));
    }
}
