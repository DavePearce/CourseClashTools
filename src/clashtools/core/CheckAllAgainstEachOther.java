package clashtools.core;

import java.util.HashSet;
import java.util.Set;

/**
 * This rule checks that every course in a list of courses is clashed against
 * each other.
 *
 * @author David J. Pearce
 *
 */
public class CheckAllAgainstEachOther extends ClashRule {
	private final Set<String> courses;

	public CheckAllAgainstEachOther(Set<String> courses) {
		this.courses = courses;
	}

	@Override
	public Diff check(Course c) {
		HashSet<String> courses = new HashSet<String>(this.courses);
		courses.remove(c.name()); // can't clash against self
		Set<String> missing = diff(courses,c.noClashes());
		Set<String> extra = diff(c.noClashes(),courses);
		return new Diff(extra,missing);
	}

	private Set<String> intersect(Set<String> s1, Set<String> s2) {
		HashSet<String> result = new HashSet<String>();
		for(String s : s1) {
			if(s2.contains(s)) {
				result.add(s);
			}
		}
		return result;
	}

	private Set<String> diff(Set<String> s1, Set<String> s2) {
		HashSet<String> result = new HashSet<String>();
		for(String s : s1) {
			if(!s2.contains(s)) {
				result.add(s);
			}
		}
		return result;
	}
}
