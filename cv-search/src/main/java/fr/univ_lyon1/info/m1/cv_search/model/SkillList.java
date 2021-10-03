package fr.univ_lyon1.info.m1.cv_search.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SkillList implements Iterable<String> {

    private PropertyChangeSupport propertyChangeSupport;

    private List<String> skillList = new ArrayList<>();

    /**
     * Calls the extended Observable constructor.
     *
     */
    public SkillList() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    /**
     * Add a PropertyChangeListener to the listener list.
     * @param propertyChangeListener The PropertyChangeListener to be added
     */
    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
    }

    /**
     * Remove a PropertyChangeListener from the listener list.
     * @param propertyChangeListener The PropertyChangeListener to be removed
     */
    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
    }

    /**
     * Adds a skill to the skill list.
     * @param skill The skill skill to be added
     */
    public void addSkill(String skill) {
        List<String> oldSkillList = new ArrayList<>(skillList);
        skillList.add(skill);
        propertyChangeSupport.firePropertyChange("skillList", oldSkillList, this.skillList);
    }

    /**
     * Removes a skill from the skill list.
     * @param skill The skill to be removed
     * @return a boolean depending on the method's success
     */
    public boolean removeSkill(String skill) {
        List<String> oldSkillList =  new ArrayList<>(skillList);
        if (skillList.remove(skill)) {
            propertyChangeSupport.firePropertyChange("skillList", oldSkillList, this.skillList);
            return true;
        }
        return false;
    }

    /**
     * Returns the skill list size.
     * @return The size of the list
     */
    public int size() {
        return skillList.size();
    }


    /**
     * Iterator for the skill list.
     * @return The iterator
     */
    @Override
    public Iterator<String> iterator() {
        return skillList.iterator();
    }

    /**
     * Returns a string of the list content.
     * @return The list content
     */
    @Override
    public String toString() {
        return skillList.toString();
    }
}
