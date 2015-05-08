package clashtools.util;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import clashtools.core.ClashList;
import clashtools.core.ClashRule;
import clashtools.core.Course;

/**
 * This rule checks that every course in one set (from) is clashed against every course
 * in another set (to).
 *
 * @author David J. Pearce
 *
 */
public class CheckAllAgainst extends ClashRule {
	private final Set<Course> from;
	private final Set<Course> to;

	public CheckAllAgainst(Collection<Course> from, Course... to) {
		this.from = new HashSet<Course>();
		for(Course s : from) {
			this.from.add(s);
		}
		this.to = new HashSet<Course>();
		for(Course s : to) {
			this.to.add(s);
		}
	}

	@Override
	public Set<Course> generate(ClashList c) {
		if(from.contains(c.course())) {
			return new HashSet<Course>(to);
		} else {
			return Collections.EMPTY_SET;
		}
	}
}
