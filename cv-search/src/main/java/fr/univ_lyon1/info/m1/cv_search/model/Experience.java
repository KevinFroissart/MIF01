package fr.univ_lyon1.info.m1.cv_search.model;

import java.util.ArrayList;
import java.util.List;

public class Experience {

    private String company;
    private int start;
    private int end;
    private List<String> keywords;

    public Experience() {
        keywords = new ArrayList<>();
    }

    /**
     * Return the company.
     * @return
     */
    public String getCompany() {
        return company;
    }

    /**
     * Return the starting date.
     * @return
     */
    public int getStart() {
        return start;
    }

    /**
     * Return the ending date.
     * @return
     */
    public int getEnd() {
        return end;
    }

    /**
     * Return the list of keywords.
     * @return
     */
    public List<String> getKeywords() {
        return keywords;
    }

    /**
     * Set the company.
     * @param company the company to be set.
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * Set the starting date.
     * @param start the date to be set.
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * Set the ending date.
     * @param end the date to be set.
     */
    public void setEnd(int end) {
        this.end = end;
    }

    /**
     * Set the list of keywords.
     * @param keywords the list to be set.
     */
    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public String toString() {
        return "Experience{company='" + company + "\', start=" + start
                + ", stop=" + end + ", keyword=" + keywords + '}';
    }
}
