package fr.univ_lyon1.info.m1.cv_search.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class SkillList extends Observable {

    List<String> skillList;

    public SkillList() {
        super();
        skillList = new ArrayList<>();
    }

    public SkillList(String skill) {
        super();
        skillList = new ArrayList<>();
        skillList.add(skill);
    }

    public SkillList(List<String> skills) {
        super();
        skillList = skills;
    }

    public void addSkill(String skill) {
        skillList.add(skill);
        customNotify();
    }

    public int getSize() {
        return skillList.size();
    }

    public boolean removeSkill(String skill) {
        if (skillList.remove(skill)) {
            customNotify();
            return true;
        }
        return false;
    }

    public void customNotify() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        String res = "";
        for (String skill : skillList) {
            res += skill + ",";
        }
        return res;
    }

}
