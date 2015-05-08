package clashtools.util;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import clashtools.core.ClashList;
import clashtools.core.ClashRule;
import clashtools.core.Course;

/**
 * This rule checks that every course in a list of courses is clashed against
 * each other.
 *
 * @author David J. Pearce
 *
 */
public class CheckAllAgainstEachOther extends ClashRule {
	private final Set<Course> courses;

	public CheckAllAgainstEachOther(Collection<Course> courses, Course... more) {
		this.courses = new HashSet<Course>();
		for(Course s : courses) {
			this.courses.add(s);
		}
		for(Course s : more) {
			this.courses.add(s);
		}
	}

	@Override
	public Set<Course> generate(ClashList c) {
		if(courses.contains(c.course())) {
			HashSet<Course> courses = new HashSet<Course>(this.courses);
			courses.remove(c.course()); // can't clash against self
			return courses;
		} else {
			return Collections.EMPTY_SET;
		}
	}
}
