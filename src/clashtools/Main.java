package clashtools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import clashtools.core.ClashList;
import clashtools.core.Course;
import clashtools.core.Prerequisites;
import clashtools.core.ClashRule;
import clashtools.io.ClashListReader;
import clashtools.util.CheckAllAgainst;
import clashtools.util.CheckAllAgainstEachOther;

public class Main {


	// =====================================
	// SWEN
	// =====================================

	public static Course SWEN221 = Course.create("SWEN221","18318",1);
	public static Course SWEN222 = Course.create("SWEN222","18319",2);
	public static Course SWEN223 = Course.create("SWEN223","18320",1);
	public static Course SWEN224 = Course.create("SWEN224","18321",2);

	public static Course SWEN301 = Course.create("SWEN301","17183",1);
	public static Course SWEN302 = Course.create("SWEN302","17184",2);
	public static Course SWEN303 = Course.create("SWEN303","17185",1);
	public static Course SWEN304 = Course.create("SWEN304","17186",2);

	public static Course SWEN421 = Course.create("SWEN421","18661",1);
	public static Course SWEN422 = Course.create("SWEN422","18662",2);
	public static Course SWEN423 = Course.create("SWEN423","18663",1);
	public static Course SWEN424 = Course.create("SWEN424","18664",2);
	public static Course SWEN425 = Course.create("SWEN425","18665");
	public static Course SWEN426 = Course.create("SWEN426","18666");
	public static Course SWEN427 = Course.create("SWEN427","18667");
	public static Course SWEN430 = Course.create("SWEN430","18668",1);
	public static Course SWEN431 = Course.create("SWEN431","18669");
	public static Course SWEN432 = Course.create("SWEN432","18670",1);
	public static Course SWEN433 = Course.create("SWEN433","18671",2);
	public static Course SWEN434 = Course.create("SWEN434","18672");
	public static Course SWEN438 = Course.create("SWEN438","18597");
	public static Course SWEN439 = Course.create("SWEN439","18598",2);

	// =====================================
	// NWEN
	// =====================================

	public static Course NWEN241 = Course.create("NWEN241","18315",1);
	public static Course NWEN242 = Course.create("NWEN242","18316",2);
	public static Course NWEN243 = Course.create("NWEN243","19863",2);

	public static Course NWEN301 = Course.create("NWEN301","17180",1);
	public static Course NWEN302 = Course.create("NWEN302","17181",2);
	public static Course NWEN303 = Course.create("NWEN303","17182",2);
	public static Course NWEN304 = Course.create("NWEN304","19864",1);

	public static Course NWEN401 = Course.create("NWEN401","18602");
	public static Course NWEN402 = Course.create("NWEN402","18603",2);
	public static Course NWEN403 = Course.create("NWEN403","18604",1);
	public static Course NWEN404 = Course.create("NWEN404","18605",1);
	public static Course NWEN405 = Course.create("NWEN405","18606",2);
	public static Course NWEN406 = Course.create("NWEN406","18592",2);
	public static Course NWEN438 = Course.create("NWEN439","18593");
	public static Course NWEN439 = Course.create("NWEN439","18594");

	// =====================================
	// ECEN
	// =====================================

	public static Course ECEN201 = Course.create("ECEN201","18508",2);
	public static Course ECEN202 = Course.create("ECEN202","18509",2);
	public static Course ECEN203 = Course.create("ECEN203","18510",1);
	public static Course ECEN201_Lab = Course.create("ECEN201","18508-Lab",2);
	public static Course ECEN202_Lab = Course.create("ECEN202","18509-Lab",2);
	public static Course ECEN203_Lab = Course.create("ECEN203","18510-Lab",1);
	public static Course ECEN220 = Course.create("ECEN220","18511",2);

	public static Course ECEN301 = Course.create("ECEN301","18512",1);
	public static Course ECEN302 = Course.create("ECEN302","18513",2);
	public static Course ECEN303 = Course.create("ECEN303","18514",2);
	public static Course ECEN310 = Course.create("ECEN310","18515",2);
	public static Course ECEN315 = Course.create("ECEN315","18516",1);
	public static Course ECEN320 = Course.create("ECEN320","18517",1);
	public static Course ECEN330 = Course.create("ECEN330","18518",2);

	public static Course ECEN405 = Course.create("ECEN405","18521",1);
	public static Course ECEN410 = Course.create("ECEN410","18522",2);
	public static Course ECEN415 = Course.create("ECEN415","18519",2);
	public static Course ECEN421 = Course.create("ECEN421","18523",1);
	public static Course ECEN425 = Course.create("ECEN425","18524",1);
	public static Course ECEN426 = Course.create("ECEN426","18574",2);
	public static Course ECEN427 = Course.create("ECEN427","18575"); // NOT OFFERED

	public static Course ECEN403 = Course.create("ECEN403","18520",2);
	public static Course ECEN430 = Course.create("ECEN430","18576",2);

	// =====================================
	// ENGR
	// =====================================

	public static Course ENGR101 = Course.create("ENGR101","15243",1);
	public static Course ENGR110 = Course.create("ENGR110","26051",2);
	public static Course ENGR121 = Course.create("ENGR121","26052",1);
	public static Course ENGR122 = Course.create("ENGR122","26053",2);
	public static Course ENGR123 = Course.create("ENGR123","27044",2);
	public static Course ENGR142 = Course.create("ENGR142","27045",2);
	public static Course ENGR291 = Course.create("ENGR291","18717",1,2);
	public static Course ENGR391 = Course.create("ENGR391","18718",1,2);
	public static Course ENGR491 = Course.create("ENGR491","18701",1,2);

	public static Course ENGR301 = Course.create("ENGR301","17178",1);
	public static Course ENGR302 = Course.create("ENGR302","17179",2);

	public static Course ENGR401 = Course.create("ENGR401","18690",1);
	public static Course ENGR489 = Course.create("ENGR489","18688",1, 2);

	// =====================================
	// COMP
	// =====================================

	public static Course COMP102T1 = Course.create("COMP102","943",1);
	public static Course COMP102T2 = Course.create("COMP102","9792",2);
	public static Course COMP103T1 = Course.create("COMP103","7223"); // NOT OFFERED
	public static Course COMP103T2 = Course.create("COMP103","945",2);
	public static Course COMP112 = Course.create("COMP112","26034",1);

	public static Course COMP261 = Course.create("COMP261","18314",1);

	public static Course COMP304 = Course.create("COMP304","964",1);
	public static Course COMP307 = Course.create("COMP307","968",1);
	public static Course COMP308 = Course.create("COMP308","23085",2);
	public static Course COMP312 = Course.create("COMP312","10444",1);
	public static Course COMP313 = Course.create("COMP313","25049",1);
	public static Course COMP361 = Course.create("COMP361","26060",2);

	public static Course COMP408 = Course.create("COMP408","23084",2);
	public static Course COMP409 = Course.create("COMP409","23083",2);
	public static Course COMP421 = Course.create("COMP421","986",2);
	public static Course COMP422 = Course.create("COMP422","2324",2);
	public static Course COMP423 = Course.create("COMP423","4962",1);
	public static Course COMP425 = Course.create("COMP425","990",1);
	public static Course COMP471 = Course.create("COMP471","26217",1);
	public static Course COMP472 = Course.create("COMP472","10767",1);
	public static Course COMP488 = Course.create("COMP488","23082",1,2);
	public static Course COMP489 = Course.create("COMP489","1027",1,2);
	public static Course COMP489T3 = Course.create("COMP489","8243");

	public static Course COMP588 = Course.create("COMP588","8245",1,2);


	// =====================================
	// OTHER
	// =====================================

	public static Course MATH132T1 = Course.create("MATH132","17150",1);
	public static Course MATH132T2 = Course.create("MATH132","17286",2);
	public static Course MATH141 = Course.create("MATH141","17151",1);
	public static Course MATH142 = Course.create("MATH142","17160",2);
	public static Course MATH151 = Course.create("MATH151","17161",1);
	public static Course MATH161 = Course.create("MATH161","17162",2);
	public static Course MATH177 = Course.create("MATH177","19803",2);

	public static Course MATH244 = Course.create("MATH244","18324",1); // need to keep clash
	public static Course MATH251 = Course.create("MATH251","18325",1);
	public static Course MATH261 = Course.create("MATH261","18326",1);

	public static Course PHYS114 = Course.create("PHYS114","7534",1);
	public static Course PHYS115 = Course.create("PHYS115","7535",2);
	public static Course PHYS122 = Course.create("PHYS122","18194",1);

	public static Course DSDN101 = Course.create("DSDN101","17120",1);
	public static Course DSDN111 = Course.create("DSDN111","17123",1);
	public static Course DSDN112 = Course.create("DSDN112","17124",1);
	public static Course DSDN142 = Course.create("DSDN142","17154",1);
	public static Course DSDN171 = Course.create("DSDN171","17129",1);


	// =====================================
	// HARD PREREQUISITES
	// =====================================

	// These are prerequisites which *must* be observed. They should be
	// considered as disjunctions. For example, COMP103 depends on either
	// COMP102T1 or COMP102T2.

	public static Prerequisites[] prereqs = {
		// 100-level
		new Prerequisites(COMP112,COMP102T1,COMP102T2), // Not necessary, but allows them to clash
		new Prerequisites(COMP103T2,COMP102T1,COMP102T2,COMP112),

		// 200-level
		new Prerequisites(COMP261,COMP103T2,MATH161),

		new Prerequisites(ECEN201),
		new Prerequisites(ECEN202),
		new Prerequisites(ECEN203),
		new Prerequisites(ECEN220),

		new Prerequisites(ENGR301),
		new Prerequisites(ENGR302,ENGR301),

		new Prerequisites(SWEN221,COMP103T2),
		new Prerequisites(SWEN222,SWEN221),
		new Prerequisites(SWEN223,COMP103T2,ENGR110),
		new Prerequisites(SWEN224,COMP103T2,MATH161),

		new Prerequisites(NWEN241,COMP103T2),
		new Prerequisites(NWEN242,COMP103T2,MATH161),
		new Prerequisites(NWEN243,COMP103T2),

		// 300-level
		new Prerequisites(COMP304,MATH161,SWEN224),
		new Prerequisites(COMP307),
		new Prerequisites(COMP308,COMP261),
		new Prerequisites(COMP312),
		new Prerequisites(COMP313),
		new Prerequisites(COMP361,COMP261),

		new Prerequisites(ECEN301,ECEN201),
		new Prerequisites(ECEN302,ECEN202),
		new Prerequisites(ECEN303,ECEN203),
		new Prerequisites(ECEN310,ECEN220),
		new Prerequisites(ECEN315,ECEN220),
		new Prerequisites(ECEN330,ECEN203),

		new Prerequisites(NWEN301,MATH161,NWEN241,NWEN242),
		new Prerequisites(NWEN302,NWEN241,NWEN242),
		new Prerequisites(NWEN303,MATH161,NWEN242),
		new Prerequisites(NWEN304,MATH161,NWEN243),

		new Prerequisites(SWEN301,SWEN222,SWEN223),
		new Prerequisites(SWEN302,SWEN222),
		new Prerequisites(SWEN303),
		new Prerequisites(SWEN304,COMP261,MATH161),

		// 400-level
		new Prerequisites(COMP408,COMP308),
		new Prerequisites(COMP409,COMP308),
		new Prerequisites(COMP421,COMP307),
		new Prerequisites(COMP422,COMP307),
		new Prerequisites(COMP423,COMP307),

		new Prerequisites(ECEN403,ECEN303),
		new Prerequisites(ECEN410,ECEN310),
		new Prerequisites(ECEN415,ECEN315),
		new Prerequisites(ECEN421,ECEN320),
		new Prerequisites(ECEN421,ECEN320),
		new Prerequisites(ECEN425,ECEN301),
		new Prerequisites(ECEN430,ECEN301),

		new Prerequisites(ENGR401),
		new Prerequisites(ENGR489),

		new Prerequisites(NWEN401),
		new Prerequisites(NWEN402,NWEN302,NWEN304),
		new Prerequisites(NWEN403,NWEN302),
		new Prerequisites(NWEN404,NWEN302),
		new Prerequisites(NWEN405,NWEN304),
		new Prerequisites(NWEN406,NWEN301),

		new Prerequisites(SWEN421,SWEN224),
		new Prerequisites(SWEN422,SWEN303),
		new Prerequisites(SWEN423),
		new Prerequisites(SWEN424),
		new Prerequisites(SWEN425,SWEN301),
		new Prerequisites(SWEN430),
		new Prerequisites(SWEN431,COMP304),
		new Prerequisites(SWEN432,SWEN304),
		new Prerequisites(SWEN433,SWEN304)
	};

	// ============================================================
	// The Rules
	// ============================================================

	private static ClashRule[] clashRules;

	private static void initClashRules() {
		clashRules = new ClashRule[] {

				// --------------------------------------------------------
				// 100 Level
				// --------------------------------------------------------

				// All 100-level ECS courses *in the same trimester* should not
				// clash with each other ...
				new CheckAllAgainstEachOther(concat(
						Course.byLabelYear("ENGR", 100),
						Course.byLabelYear("COMP", 100))),

				// nor with MATH 132, 141, 142, 151, 161, 177, ENGR 121, 122,
				// 123, PHYS 114, 115, 122
				new CheckAllAgainst(concat(Course.byLabelYear("ENGR", 100),
						Course.byLabelYear("COMP", 100)), concat(MATH132T1,
						MATH132T2, MATH141, MATH142, MATH151, MATH161, MATH142,
						MATH177, PHYS114, PHYS115, PHYS122)),

				// --------------------------------------------------------
				// --------------------------------------------------------

				// COMP,SWEN,NWEN
				new CheckAllAgainstEachOther(concat(
						Course.byLabelYear("SWEN", 200),
						Course.byLabelYear("NWEN", 200),
						Course.byLabelYear("ENGR", 200),
						Course.byLabelYear("COMP", 200))),

				// ECEN
				new CheckAllAgainstEachOther(Course.byLabelYear("ECEN", 200)),

				// Specials
				new CheckAllAgainstEachOther(concat(
						Course.byLabelYear("ECEN", 200), MATH244, NWEN241,
						NWEN242, NWEN243, COMP261, SWEN221)),

				// --------------------------------------------------------
				// 300 Level
				// --------------------------------------------------------

				// COMP,SWEN,NWEN
				new CheckAllAgainstEachOther(concat(
						Course.byLabelYear("SWEN", 300),
						Course.byLabelYear("NWEN", 300),
						Course.byLabelYear("ENGR", 300),
						Course.byLabelYear("COMP", 300))),

				// ECEN
				new CheckAllAgainstEachOther(concat(
						Course.byLabelYear("ECEN", 300),
						Course.byLabelYear("ENGR", 300))),

				// Specials
				new CheckAllAgainstEachOther(concat(
						Course.byLabelYear("ECEN", 300), NWEN301, NWEN302,
						NWEN304, COMP307, SWEN303)),

				// --------------------------------------------------------
				// 400 Level
				// --------------------------------------------------------

				// COMP,SWEN,NWEN
				new CheckAllAgainstEachOther(concat(
						Course.byLabelYear("SWEN", 400),
						Course.byLabelYear("NWEN", 400),
						Course.byLabelYear("ENGR", 400),
						Course.byLabelYear("COMP", 400))),

				// ECEN
				new CheckAllAgainstEachOther(concat(
						Course.byLabelYear("ECEN", 400),
						Course.byLabelYear("ENGR", 400))),

				// Specials
				new CheckAllAgainstEachOther(concat(
						Course.byLabelYear("ECEN", 400), COMP421, NWEN402, NWEN403,
						NWEN404, SWEN422))

		};
	}


	public static void main(String[] args) throws IOException {
		initClashRules();
		ClashListReader reader = new ClashListReader(args[0]);
		List<ClashList> clashLists = reader.read();
		for(ClashList c : clashLists) {
			// First add all expected clashes
			HashSet<Course> expected = new HashSet<Course>();
			for(ClashRule r : clashRules) {
				expected.addAll(r.generate(c));
			}
			// Second, remove all prerequisites
			removeAllPrequisites(c.course(),expected);

			// Third, report any differences
			ClashList.Diff diff = c.differenceFrom(expected);
			if(diff != null) {

				// FIXME: applying filtering from 2015
				HashSet<Course> nExtra = new HashSet<Course>();
				for(Course x : diff.extra) {
					if(x.year() == c.course().year() &&
							intersects(x.trimester(),c.course().trimester())) {
						nExtra.add(x);
					} else {
						c.noClashes().remove(x);
					}
				}
				// add missing courses
				HashSet<Course> nMissing = new HashSet<Course>();
				for(Course x : diff.missing) {
					if(x.isOffered()) {
						c.noClashes().add(x);
					} else {
						nMissing.add(x);
					}
				}
				diff = new ClashList.Diff(nExtra,nMissing);

				// --- END ---

				if(diff.extra.size() > 0 || diff.missing.size() > 0) {
					// At this point, I want to apply the filter. That is check the
					// differences are because of the new rules introduced in 2015.
					System.err.println("*** Invalid clash list for " + c.course() + " : " + diff + "\n");
				}
			}
		}

		printClashLists(clashLists);
	}

	private static void printClashLists(List<ClashList> clashLists) {
		for(ClashList c : clashLists) {
			if(c.course().isOffered()) {
				System.out.print("SECS," + c.course().code() + "," + c.course() + ",");
				printTrimesters(c.course().trimester());
				System.out.print(",\"");
				boolean firstTime=true;
				for(Course noClash : c.noClashes()) {
					if(noClash.isOffered()) {
						if(!firstTime) {
							System.out.print(", ");
						}
						firstTime=false;
						System.out.print(noClash);
					}
				}
				System.out.println("\",,");
			}
		}
	}

	private static void printTrimesters(int[] trimester) {
		if(trimester.length == 1) {
			System.out.print(trimester[0]);
		} else {
			System.out.print("F");
		}
	}

	private static void removeAllPrequisites(Course course,
			HashSet<Course> expected) {
		for(Prerequisites p : prereqs) {
			if(p.course == course) {
				for(Course c : p.prereqs) {
					expected.remove(c);
				}
			}
		}
	}


	private static boolean intersects(int[] t1s, int[] t2s) {
		for(int i=0;i!=t1s.length;++i) {
			for(int j=0;j!=t2s.length;++j) {
				if(t1s[i] == t2s[j]) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Concatenate an arbitrary number of lists together.
	 *
	 * @param lists
	 * @return
	 */
	public static ArrayList<Course> concat(List<Course>... lists) {
		ArrayList<Course> r = new ArrayList<Course>();
		for (List<Course> l : lists) {
			r.addAll(l);
		}
		return r;
	}

	/**
	 * Concatenate an arbitrary number of lists together.
	 *
	 * @param lists
	 * @return
	 */
	public static ArrayList<Course> concat(List<Course> l1, Course... lists) {
		ArrayList<Course> r = new ArrayList<Course>(l1);
		for (Course c : lists) {
			r.add(c);
		}
		return r;
	}

	/**
	 * Concatenate an arbitrary number of lists together.
	 *
	 * @param lists
	 * @return
	 */
	public static ArrayList<Course> concat(Course... lists) {
		ArrayList<Course> r = new ArrayList<Course>();
		for (Course c : lists) {
			r.add(c);
		}
		return r;
	}

	/**
	 * Concatenate an arbitrary number of lists together.
	 *
	 * @param lists
	 * @return
	 */
	public static String[] concat(String[] ... lists) {
		int total = 0;
		for(String[] list : lists) {
			total += list.length;
		}
		String[] result = new String[total];
		int i=0;
		for(String[] list : lists) {
			for(String item : list) {
				result[i++] = item;
			}
		}

		Arrays.sort(result);

		return result;
	}

	/**
	 * Concatenate an arbitrary number of lists together.
	 *
	 * @param lists
	 * @return
	 */
	public static String[] concat(String[] l1, String... l2) {
		String[] result = new String[l1.length + l2.length];
		System.arraycopy(l1, 0, result, 0, l1.length);
		System.arraycopy(l2, 0, result, l1.length, l2.length);
		return result;
	}
}

