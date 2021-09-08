package fr.univ_lyon1.info.m1.cv_search.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApplicantList implements Iterable<Applicant> {
    private List<Applicant> list = new ArrayList<Applicant>();
    
    /** 
     * Add applicant to applicant list.
     * @param a the applicant.
     */
    void add(Applicant a) {
        list.add(a);
    }

    
    /** 
     * Returns the applicant list size.
     * @return the size.
     */
    public int size() {
        return list.size();
    }

    
    /** 
     * Iterator for the applicant list.
     * @return the iterator.
     */
    @Override
    public Iterator<Applicant> iterator() {
        return list.iterator();
    }

    /** Clear the list of applicants. */
    public void clear() {
        list.clear();
    }

    /** Sets the content of the applicant list. */
    public void setList(ApplicantList list) {
        this.list = list.list;
    }
}
