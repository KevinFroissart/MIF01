package fr.univ_lyon1.info.m1.cv_search.model;

import java.util.HashMap;
import java.util.Map;

public class Applicant {
    Map<String, Integer> skills = new HashMap<>();
    String name;

    /** 
     * Returns applicant's skill level.
     * @param string the skill name.
     * @return int the skill level.
     */
    public int getSkill(String string) {
        return skills.getOrDefault(string, 0);
    }

    /** 
     * Sets applicant's skill.
     * @param string the skill.
     * @param value the skill level.
     */
    public void setSkill(String string, int value) {
        skills.put(string, value);
    }
    
    /** 
     * Returns applicant's name.
     * @return String the applicant's name.
     */
    public String getName() {
        return name;
    }
    
    /** 
     * Sets applicant's name.
     * @param name the applicant's name.
     */
    public void setName(String name) {
        this.name = name;
    }
}
