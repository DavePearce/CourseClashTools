package clashtools.core;

import java.util.Set;

public abstract class ClashRule {

	/**
	 * Check a given course clashlist against this rule
	 *
	 * @param c
	 * @return
	 */
	public abstract Diff check(ClashList c);

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
}
