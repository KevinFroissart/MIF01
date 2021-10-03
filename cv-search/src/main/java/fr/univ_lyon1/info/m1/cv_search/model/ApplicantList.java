package fr.univ_lyon1.info.m1.cv_search.model;

import java.util.ArrayList;
import java.util.List;

public class ApplicantList extends ListObservable<Applicant> {

    public ApplicantList() {
        super();
    }

    /**
     * Adds an applicant to the skill list.
     * @param applicant The {@link Applicant} to be added
     */
    public void addApplicant(Applicant applicant) {
        List<Applicant> oldList = new ArrayList<>(getList());
        getList().add(applicant);
        getPropertyChangeSupport().firePropertyChange("applicantList", oldList, getList());
    }

    /**
     * Removes an applicant from the list.
     * @param applicant The {@link Applicant} to be removed
     * @return a boolean depending on the method's success
     */
    public boolean removeApplicant(Applicant applicant) {
        List<Applicant> oldList =  new ArrayList<>(getList());
        if (getList().remove(applicant)) {
            getPropertyChangeSupport().firePropertyChange("applicantList", oldList, getList());
            return true;
        }
        return false;
    }
}
