package fr.univ_lyon1.info.m1.cv_search.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListObservable<T> implements Iterable<T> {

    private PropertyChangeSupport propertyChangeSupport;

    private List<T> list = new ArrayList<>();

    public ListObservable() {
        this.propertyChangeSupport = new PropertyChangeSupport(this);
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
     * Return the {@link PropertyChangeSupport}.
     * @return
     */
    public PropertyChangeSupport getPropertyChangeSupport() {
        return propertyChangeSupport;
    }

    /**
     * Return the list.
     * @return
     */
    public List<T> getList() {
        return list;
    }

    /**
     * Set the current list to a list passed in param.
     * @param list
     */
    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
