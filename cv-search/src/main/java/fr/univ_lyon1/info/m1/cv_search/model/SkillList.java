package fr.univ_lyon1.info.m1.cv_search.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SkillList extends CustomObservable implements Iterable<String> {

    private List<String> list = new ArrayList<>();

    public SkillList() {
        super();
    }

    /**
     * Add a skill to the skill list.
     * @param skill The skill to be added
     */
    public void addSkill(String skill) {
        List<String> oldSkillList = new ArrayList<>(list);
        list.add(skill);
        getPropertyChangeSupport().firePropertyChange("skillList", oldSkillList, list);
    }

    /**
     * Remove a skill from the skill list.
     * @param skill The skill to be removed
     */
    public void removeSkill(String skill) {
        List<String> oldSkillList =  new ArrayList<>(list);
        list.remove(skill);
        getPropertyChangeSupport().firePropertyChange("skillList", oldSkillList, list);
    }

    /**
     * Return the list size.
     * @return The size of the list
     */
    public int size() {
        return list.size();
    }

    /**
     * Clear the list.
     */
    public void clear() {
        list.clear();
    }

    /**
     * Return the list.
     * @return
     */
    public List<String> getList() {
        return list;
    }

    /**
     * Set the current list to a list passed in param.
     * @param list
     */
    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public Iterator<String> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
