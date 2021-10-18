package fr.univ_lyon1.info.m1.cv_search.model;

import java.util.Comparator;

public class ApplicantComparator implements Comparator<Applicant> {

	/**
	 * Compare two applicants based on their average score.
	 * @param applicant1 The first {@link Applicant} to be compared
	 * @param applicant2 The second {@link Applicant} to be compared
	 * @return a negative integer, zero, or a positive integer
	 * as the first argument is less than, equal to, or greater than the second.
	 */
	@Override
	public int compare(Applicant applicant1, Applicant applicant2) {
		if (applicant1.getAverage() == null && applicant2.getAverage() == null) {
			return 0;
		}
		if (applicant1.getAverage() == null) {
			return -1;
		}
		if (applicant2.getAverage() == null) {
			return 1;
		}
		return Double.compare(applicant2.getAverage(), applicant1.getAverage());
	}
}
