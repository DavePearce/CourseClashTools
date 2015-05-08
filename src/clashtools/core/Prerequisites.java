package clashtools.core;

public class Prerequisites {
	public final String course;
	public final String[] prereqs;

	public Prerequisites(String course, String... prereqs) {
		this.course = course;
		this.prereqs = prereqs;
	}
}