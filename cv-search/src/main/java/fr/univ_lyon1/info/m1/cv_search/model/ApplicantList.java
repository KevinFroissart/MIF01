package fr.univ_lyon1.info.m1.cv_search.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ApplicantList extends ListObservable<Applicant> {

    public ApplicantList() {
        super();
    }

    /**
     * Add an applicant to the skill list.
     * Sort the list and fires the changes to the view.
     * @param applicant The {@link Applicant} to be added
     */
    public void addApplicant(Applicant applicant) {
        List<Applicant> oldList = new ArrayList<>(getList());
        getList().add(applicant);
        Collections.sort(getList(), new ApplicantComparator());
        getPropertyChangeSupport().firePropertyChange("applicantList", oldList, getList());
    }

    /**
     * Remove an applicant from the list.
     * Sort the list and fires the changes to the view.
     * @param applicant The {@link Applicant} to be removed
     */
    public void removeApplicant(Applicant applicant) {
        List<Applicant> oldList =  new ArrayList<>(getList());
        getList().remove(applicant);
        Collections.sort(getList(), new ApplicantComparator());
        getPropertyChangeSupport().firePropertyChange("applicantList", oldList, getList());
    }

    /**
     * Clear the {@link Applicant} from the list and fires changes to the view.
     */
    @Override
    public void clear() {
        List<Applicant> oldList =  new ArrayList<>(getList());
        getList().clear();
        getPropertyChangeSupport().firePropertyChange("applicantList", oldList, getList());
    }
}
