package fr.univ_lyon1.info.m1.cv_search.model.filter;

import java.util.LinkedHashSet;

public final class FilterListSingleton {

    private LinkedHashSet<FilterStrategy> skillStrategies;
    private LinkedHashSet<FilterStrategy> experienceStragies;

    private static FilterListSingleton instance = null;

    /**
     * Private constructor.
     */
    private FilterListSingleton() {
        this.skillStrategies = new LinkedHashSet<>();
        this.experienceStragies = new LinkedHashSet<>();
    }

    /**
     * Return the singleton instance.
     * @return
     */
    public static FilterListSingleton getInstance() {
        if (instance == null) {
            instance = new FilterListSingleton();
        }
        return instance;
    }

    /**
     * Return the set of skill related strategies.
     * @return
     */
    public LinkedHashSet<FilterStrategy> getSkillStrategies() {
        return skillStrategies;
    }

    /**
     * Return the set of experience related strategies.
     * @return
     */
    public LinkedHashSet<FilterStrategy> getExperienceStragies() {
        return experienceStragies;
    }

    /**
     * Return a set containing all strategies.
     * @return
     */
    public LinkedHashSet<FilterStrategy> getStrategies() {
        LinkedHashSet<FilterStrategy> strategies = new LinkedHashSet<>(skillStrategies);
        strategies.addAll(experienceStragies);
        return strategies;
    }

    /**
     * Add a {@link FilterStrategy} to the set of skill related strategies.
     * @param strategy the strategy to be added
     */
    public void addSkillStrategy(FilterStrategy strategy) {
        this.skillStrategies.add(strategy);
    }

    /**
     * Add a {@link FilterStrategy} to the set of experience related strategies.
     * @param strategy the strategy to be added
     */
    public void addExperienceStrategy(FilterStrategy strategy) {
        this.experienceStragies.add(strategy);
    }

    /**
     * Remove a {@link FilterStrategy} off the set of skill related strategies.
     * @param strategy the strategy to be removed
     */
    public void removeSkillStrategy(FilterStrategy strategy) {
        this.skillStrategies.remove(strategy);
    }

    /**
     * Remove a {@link FilterStrategy} off the set of experience related strategies.
     * @param strategy the strategy to be removed
     */
    public void removeExperienceStrategy(FilterStrategy strategy) {
        this.experienceStragies.remove(strategy);
    }

    /**
     * Set a set of skill related strategies.
     * @param skillStrategies the set to be set
     */
    public void setSkillStrategies(LinkedHashSet<FilterStrategy> skillStrategies) {
        this.skillStrategies = skillStrategies;
    }

    /**
     * Set a set of experience related strategies.
     * @param experienceStragies the set to be set
     */
    public void setExperienceStragies(LinkedHashSet<FilterStrategy> experienceStragies) {
        this.experienceStragies = experienceStragies;
    }
}
