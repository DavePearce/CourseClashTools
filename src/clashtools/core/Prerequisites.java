package clashtools.core;

public class Prerequisites {
	public final Course course;
	public final Course[] prereqs;

	public Prerequisites(Course course, Course... prereqs) {
		this.course = course;
		this.prereqs = prereqs;
	}
}