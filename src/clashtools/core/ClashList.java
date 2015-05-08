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
	private final String name;
	private final HashSet<String> noClashes;

	public ClashList(String CRN, Collection<String> noClashList) {
		this.name = CRN;
		this.noClashes = new HashSet<String>(noClashList);
	}

	public ClashList(String name, String... noClash) {
		this.name = name;
		this.noClashes = new HashSet<String>();
		for(int i=0;i!=noClash.length;++i) {
			this.noClashes.add(noClash[i]);
		}
	}

	public String name() {
		return name;
	}

	public Set<String> noClashes() {
		return noClashes;
	}


	public static class Diff {
		public final Set<String> extra;
		public final Set<String> missing;

		public Diff(Set<String> extra, Set<String> missing) {
			this.extra = extra;
			this.missing = missing;
		}

		public String toString() {
			String r = "";
			boolean firstTime = true;
			for(String s : extra) {
				if(!firstTime) {
					r += ", ";
				}
				firstTime = false;
				r += "+" + s;
			}
			for(String s : missing) {
				if(!firstTime) {
					r += ", ";
				}
				firstTime = false;
				r += "-" + s;
			}
			return r;
		}
	}


	public Diff differenceFrom(HashSet<String> expected) {
		Set<String> missing = diff(expected,noClashes);
		Set<String> extra = diff(noClashes,expected);
		if(missing.isEmpty() && extra.isEmpty()) {
			return null;
		} else {
			return new Diff(extra,missing);
		}
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
