package clashtools.core;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Represents an individual course and its no-class list
 *
 * @author David J. Pearce
 *
 */
public class Course {
	private final String name;
	private final HashSet<String> noClashes;

	public Course(String name, Collection<String> noClashList) {
		this.name = name;
		this.noClashes = new HashSet<String>(noClashList);
	}

	public Course(String name, String... noClash) {
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
}
