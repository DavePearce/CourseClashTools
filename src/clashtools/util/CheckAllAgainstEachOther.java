package clashtools.util;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import clashtools.core.ClashList;
import clashtools.core.ClashRule;

/**
 * This rule checks that every course in a list of courses is clashed against
 * each other.
 *
 * @author David J. Pearce
 *
 */
public class CheckAllAgainstEachOther extends ClashRule {
	private final Set<String> courses;

	public CheckAllAgainstEachOther(String... courses) {
		this.courses = new HashSet<String>();
		for(String s : courses) {
			this.courses.add(s);
		}
	}

	@Override
	public Set<String> generate(ClashList c) {
		if(courses.contains(c.name())) {
			HashSet<String> courses = new HashSet<String>(this.courses);
			courses.remove(c.name()); // can't clash against self
			return courses;
		} else {
			return Collections.EMPTY_SET;
		}
	}
}
