package clashtools.util;

import java.util.Arrays;
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
			Set<Course> courses = filter(c.course().trimester());
			courses.remove(c.course()); // can't clash against self
			return courses;
		} else {
			return Collections.EMPTY_SET;
		}
	}

	private Set<Course> filter(int... trimesters) {
		HashSet<Course> r = new HashSet<Course>();
		for(Course c : courses) {
			if(intersects(c.trimester(),trimesters)) {
				r.add(c);
			}
		}
		return r;
	}


	private static boolean intersects(int[] t1s, int[] t2s) {
		for(int i=0;i!=t1s.length;++i) {
			for(int j=0;j!=t2s.length;++j) {
				if(t1s[i] == t2s[j]) {
					return true;
				}
			}
		}
		return false;
	}
}
