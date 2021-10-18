package fr.univ_lyon1.info.m1.cv_search.model;

import java.util.HashMap;
import java.util.Map;

public class Applicant {
    private Map<String, Integer> skills = new HashMap<>();
    private String name;
    private Double average;

    /** 
     * Return the applicant's skill level.
     * @param string the skill name.
     * @return int the skill level.
     */
    public int getSkill(String string) {
        return skills.getOrDefault(string, 0);
    }

    /** 
     * Set the applicant's skill.
     * @param string the skill.
     * @param value the skill level.
     */
    public void setSkill(String string, int value) {
        skills.put(string, value);
    }
    
    /** 
     * Return the applicant's name.
     * @return String the applicant's name.
     */
    public String getName() {
        return name;
    }
    
    /** 
     * Set the applicant's name.
     * @param name the applicant's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return the applicant's average mark.
     * @return average the mark to be returned.
     */
    public Double getAverage() {
        return average;
    }

    /**
     * Set the applicant's average mark.
     * @param average the mark to be set.
     */
    public void setAverage(Double average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "Applicant{\"" + name + "\", skills=" + skills + ", average=" + average + "}";
    }
}
