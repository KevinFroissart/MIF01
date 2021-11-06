package fr.univ_lyon1.info.m1.cv_search.model.applicant;

import fr.univ_lyon1.info.m1.cv_search.model.CustomObservable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ApplicantList extends CustomObservable implements Iterable<Applicant> {

    private List<Applicant> list = new ArrayList<>();

    public ApplicantList() {
        super();
    }

    /**
     * Add an applicant to the skill list.
     * Sort the list and fires the changes to the view.
     * @param applicant The {@link Applicant} to be added
     */
    public void addApplicant(Applicant applicant) {
        List<Applicant> oldList = new ArrayList<>(list);
        list.add(applicant);
        Collections.sort(list, new ApplicantComparator());
        getPropertyChangeSupport().firePropertyChange("applicantList", oldList, list);
    }

    /**
     * Remove an applicant from the list.
     * Sort the list and fires the changes to the view.
     * @param applicant The {@link Applicant} to be removed
     */
    public void removeApplicant(Applicant applicant) {
        List<Applicant> oldList =  new ArrayList<>(list);
        list.remove(applicant);
        Collections.sort(list, new ApplicantComparator());
        getPropertyChangeSupport().firePropertyChange("applicantList", oldList, list);
    }

    /**
     * Clear the {@link Applicant} from the list and fires changes to the view.
     */
    public void clear() {
        List<Applicant> oldList =  new ArrayList<>(list);
        list.clear();
        getPropertyChangeSupport().firePropertyChange("applicantList", oldList, list);
    }

    /**
     * Return the list size.
     * @return The size of the list
     */
    public int size() {
        return list.size();
    }

    /**
     * Return the list of {@link Applicant}.
     * @return
     */
    public List<Applicant> getList() {
        return list;
    }

    /**
     * Set the current list to a list passed in param.
     * @param list
     */
    public void setList(List<Applicant> list) {
        this.list = list;
    }

    @Override
    public Iterator<Applicant> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        return list.toString();
    }

}
