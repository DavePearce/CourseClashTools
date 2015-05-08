package clashtools.core;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import clashtools.core.ClashList.Diff;


/**
 * Represents an individual course and its no-class list
 *
 * @author David J. Pearce
 *
 */
public class ClashList {
	private final Course course;
	private final HashSet<Course> noClashes;

	public ClashList(Course course, Collection<Course> noClashList) {
		this.course = course;
		this.noClashes = new HashSet<Course>(noClashList);
	}

	public ClashList(Course course, Course... noClash) {
		this.course = course;
		this.noClashes = new HashSet<Course>();
		for(int i=0;i!=noClash.length;++i) {
			this.noClashes.add(noClash[i]);
		}
	}

	public Course course() {
		return course;
	}

	public Set<Course> noClashes() {
		return noClashes;
	}


	public static class Diff {
		public final Set<Course> extra;
		public final Set<Course> missing;

		public Diff(Set<Course> extra, Set<Course> missing) {
			this.extra = extra;
			this.missing = missing;
		}

		public String toString() {
			String r = "";
			boolean firstTime = true;
			for(Course s : extra) {
				if(!firstTime) {
					r += ", ";
				}
				firstTime = false;
				r += "+" + s;
			}
			for(Course s : missing) {
				if(!firstTime) {
					r += ", ";
				}
				firstTime = false;
				r += "-" + s;
			}
			return r;
		}
	}


	public Diff differenceFrom(HashSet<Course> expected) {
		Set<Course> missing = diff(expected,noClashes);
		Set<Course> extra = diff(noClashes,expected);
		if(missing.isEmpty() && extra.isEmpty()) {
			return null;
		} else {
			return new Diff(extra,missing);
		}
	}

	private Set<Course> diff(Set<Course> s1, Set<Course> s2) {
		HashSet<Course> result = new HashSet<Course>();
		for(Course s : s1) {
			if(!s2.contains(s)) {
				result.add(s);
			}
		}
		return result;
	}
}
