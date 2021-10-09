package fr.univ_lyon1.info.m1.cv_search.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ApplicantList extends ListObservable<Applicant> {

    public ApplicantList() {
        super();
    }

    /**
     * Adds an applicant to the skill list.
     * Sorts the list and fires the changes to the view.
     * @param applicant The {@link Applicant} to be added
     */
    public void addApplicant(Applicant applicant) {
        List<Applicant> oldList = new ArrayList<>(getList());
        getList().add(applicant);
        Collections.sort(getList(), new ApplicantComparator());
        getPropertyChangeSupport().firePropertyChange("applicantList", oldList, getList());
    }

    /**
     * Removes an applicant from the list.
     * Sorts the list and fires the changes to the view.
     * @param applicant The {@link Applicant} to be removed
     */
    public void removeApplicant(Applicant applicant) {
        List<Applicant> oldList =  new ArrayList<>(getList());
        getList().remove(applicant);
        Collections.sort(getList(), new ApplicantComparator());
        getPropertyChangeSupport().firePropertyChange("applicantList", oldList, getList());
    }
}
