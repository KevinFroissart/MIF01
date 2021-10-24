package fr.univ_lyon1.info.m1.cv_search;

import org.junit.jupiter.api.Test;

import fr.univ_lyon1.info.m1.cv_search.model.SkillList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SkillListTest {

    @Test
    public void testAddSkill() {
        System.out.println("--------------SkillListTest---------------");
        SkillList s = new SkillList();
        s.addSkill("c");
        s.addSkill("c++");

        Boolean found = s.toString().contains("c++");
        found = s.toString().contains("c");
        assertThat(found, is(true));

        s.removeSkill("c++");
        found = s.toString().contains("c++");
        assertThat(found, is(false));
    }
}
