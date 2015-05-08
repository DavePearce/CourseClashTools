package clashtools.core;

import java.util.Set;

public abstract class ClashRule {

	/**
	 * Check a given course clashlist against this rule
	 *
	 * @param c
	 * @return
	 */
	public abstract Diff check(Course c);

	public static class Diff {
		public final Set<String> extra;
		public final Set<String> missing;

		public Diff(Set<String> extra, Set<String> missing) {
			this.extra = extra;
			this.missing = missing;
		}
	}
}
