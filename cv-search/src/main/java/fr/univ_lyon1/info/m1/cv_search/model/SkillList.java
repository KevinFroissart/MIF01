package fr.univ_lyon1.info.m1.cv_search.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

public class SkillList extends Observable implements Iterable<String> {

    private List<String> skillList = new ArrayList<>();

    /**
     * Calls the extended Observable constructor.
     */
    public SkillList() {
        super();
    }

    /**
     * Adds a skill to the skill list.
     * @param skill the skill
     */
    public void addSkill(String skill) {
        skillList.add(skill);
        customNotify();
    }

    /**
     * Removes a skill from the skill list.
     * @param skill the skill
     * @return a boolean depending on the method's success
     */
    public boolean removeSkill(String skill) {
        if (skillList.remove(skill)) {
            customNotify();
            return true;
        }
        return false;
    }

    /**
     * Returns the skill list size.
     * @return the size
     */
    public int size() {
        return skillList.size();
    }

    /**
     * Notifies observers observing this class.
     */
    public void customNotify() {
        setChanged();
        notifyObservers();
    }

    /**
     * Iterator for the skill list.
     * @return the iterator
     */
    @Override
    public Iterator<String> iterator() {
        return skillList.iterator();
    }

    /**
     * Returns a string of the list content.
     * @return a string
     */
    @Override
    public String toString() {
        return skillList.toString();
    }
}
