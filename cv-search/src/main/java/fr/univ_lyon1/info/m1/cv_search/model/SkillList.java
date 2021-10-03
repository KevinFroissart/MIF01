package fr.univ_lyon1.info.m1.cv_search.model;

import java.util.ArrayList;
import java.util.List;

public class SkillList extends ListObservable<String> {

    public SkillList() {
        super();
    }

    /**
     * Adds a skill to the skill list.
     * @param skill The skill to be added
     */
    public void addSkill(String skill) {
        List<String> oldSkillList = new ArrayList<>(getList());
        getList().add(skill);
        getPropertyChangeSupport().firePropertyChange("skillList", oldSkillList, getList());
    }

    /**
     * Removes a skill from the skill list.
     * @param skill The skill to be removed
     * @return a boolean depending on the method's success
     */
    public boolean removeSkill(String skill) {
        List<String> oldSkillList =  new ArrayList<>(getList());
        if (getList().remove(skill)) {
            getPropertyChangeSupport().firePropertyChange("skillList", oldSkillList, getList());
            return true;
        }
        return false;
    }
}
