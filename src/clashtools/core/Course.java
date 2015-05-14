package clashtools.core;

import java.util.*;

public class Course {
	private final String code;
	private final String crn;
	private final int[] trimesters;

	public Course(String code, String crn, int... trimesters) {
		this.code = code;
		this.crn = crn;
		this.trimesters = trimesters;
	}

	public String label() {
		return code.substring(0, 4);
	}

	public int year() {
		return Integer.parseInt(code.substring(4, 5))*100;
	}

	public String code() {
		return code;
	}

	public String crn() {
		return crn;
	}

	public boolean isOffered() {
		return trimesters.length > 0;
	}

	public String toString() {
		return code + "-" + crn;
	}

	public int[] trimester() {
		return trimesters;
	}

	public boolean equals(Object o) {
		if (o instanceof Course) {
			Course c = (Course) o;
			return c.code.equals(code) && c.crn.equals(crn)
					&& Arrays.equals(c.trimesters, trimesters);
		}
		return false;
	}

	public int hashCode() {
		return code.hashCode() ^ crn.hashCode() ^ trimesters.hashCode();
	}

	private static final Map<String,Course> database = new HashMap<String,Course>();

	public static Course create(String code, String crn, int... trimesters) {
		Course c = database.get(crn);
		if (c != null) {
			if (!c.code().equals(code)
					|| !Arrays.equals(c.trimester(), trimesters)) {
				throw new IllegalArgumentException(
						"Attempt to create non-identical course with identical crn (" + c.code() + " vs " + code + ")");
			}
		} else {
			c = new Course(code, crn, trimesters);
			database.put(crn, c);
		}

		return c;
	}

	public static Course get(String crn) {
		return database.get(crn);
	}

	public static Set<Course> getAll() {
		return new HashSet<Course>(database.values());
	}

	public static List<Course> byLabel(String label) {
		ArrayList<Course> courses = new ArrayList<Course>();
		for(Course c : database.values()) {
			if(c.label().equals(label)) {
				courses.add(c);
			}
		}
		return courses;
	}

	public static List<Course> byYear(int year) {
		ArrayList<Course> courses = new ArrayList<Course>();
		for(Course c : database.values()) {
			if(c.year() == year) {
				courses.add(c);
			}
		}
		return courses;
	}

	public static List<Course> byLabelYear(String label, int year) {
		ArrayList<Course> courses = new ArrayList<Course>();
		for(Course c : database.values()) {
			if(c.label().equals(label) && c.year() == year) {
				courses.add(c);
			}
		}
		return courses;
	}

	public static List<Course> byLabelYearExcept(String label, int year, Course... exceptions) {
		ArrayList<Course> courses = new ArrayList<Course>();
		for(Course c : database.values()) {
			if(c.label().equals(label) && c.year() == year) {
				courses.add(c);
			}
		}
		for(Course c : exceptions) {
			courses.remove(c);
		}
		return courses;
	}
}
