package fr.univ_lyon1.info.m1.cv_search.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CustomObservable {

    private PropertyChangeSupport propertyChangeSupport;

    public CustomObservable() {
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
     * Return the {@link PropertyChangeSupport}.
     * @return
     */
    public PropertyChangeSupport getPropertyChangeSupport() {
        return propertyChangeSupport;
    }

}
