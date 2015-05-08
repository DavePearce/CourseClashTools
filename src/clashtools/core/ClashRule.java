package clashtools.core;

import java.util.Set;

public abstract class ClashRule {

	/**
	 * Check a given course clashlist against this rule
	 *
	 * @param c
	 * @return
	 */
	public abstract Set<Course> generate(ClashList c);
}
