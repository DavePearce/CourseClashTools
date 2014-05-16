import java.util.*;


public class ClashListGenerator {
	
	// =====================================
	// SWEN
	// =====================================
	
	public static String[] SWEN_2nd_YEAR = {
		"SWEN221","SWEN222","SWEN223","SWEN224"
	};
	
	public static String[] SWEN_3rd_YEAR = {
		"SWEN301","SWEN302","SWEN303","SWEN304"
	};

	public static String[] SWEN_4th_YEAR = {
		"SWEN421","SWEN422","SWEN423","SWEN424","SWEN425","SWEN426","SWEN427","SWEN430","SWEN431","SWEN432","SWEN433","SWEN434","SWEN438","SWEN439"
	};
	
	// =====================================
	// NWEN
	// =====================================
		
	public static String[] NWEN_2nd_YEAR = {
		"NWEN241","NWEN242","NWEN243"
	};
		
	public static String[] NWEN_3rd_YEAR = {
		"NWEN301","NWEN302","NWEN303","NWEN304"
	};

	public static String[] NWEN_4th_YEAR = {
		"NWEN401", "NWEN402", "NWEN403", "NWEN404", "NWEN405", "NWEN406","NWEN438","NWEN439"
	};
	
	// =====================================
	// ECEN
	// =====================================
			
	public static String[] ECEN_2nd_YEAR = {
		"ECEN201", "ECEN202", "ECEN203", "ECEN220"
	};
			
	public static String[] ECEN_3rd_YEAR = {
		"ECEN301","ECEN302","ECEN303","ECEN310","ECEN315","ECEN320","ECEN330"
	};

	public static String[] ECEN_4th_YEAR = {
		"ECEN403", "ECEN405", "ECEN410", "ECEN415", "ECEN421", "ECEN425", "ECEN426", "ECEN430" 
	};
	
	// =====================================
	// ENGR
	// =====================================
			
	public static String[] ENGR_1st_YEAR = {
		"ENGR101","ENGR110","ENGR121", "ENGR122", "ENGR123"
	};
			
	public static String[] ENGR_3rd_YEAR = {
		"ENGR301","ENGR302"
	};

	public static String[] ENGR_4th_YEAR = {
		"ENGR401", "ENGR489"
	};

	// =====================================
	// COMP
	// =====================================
	public static String[] COMP_1st_YEAR = {
		"COMP102","COMP112","COMP103"
	};
	
	public static String[] COMP_2nd_YEAR = {
		"COMP261"
	};
	
	public static String[] COMP_3rd_YEAR = {
		"COMP304","COMP307","COMP308","COMP312","COMP313","COMP361"
	};
	
	public static String[] COMP_4th_YEAR = {
		"COMP408","COMP409","COMP421","COMP422","COMP423","COMP425","COMP471","COMP472","COMP488","COMP489"
	};
	
	// =====================================
	// GENERAL
	// =====================================
	public static String[] ALL_1st_YEAR = concat(ENGR_1st_YEAR, COMP_1st_YEAR);
	
	public static String[] ALL_2nd_YEAR = concat(SWEN_2nd_YEAR, NWEN_2nd_YEAR, ECEN_2nd_YEAR, COMP_2nd_YEAR);
	
	public static String[] ALL_3rd_YEAR = concat(SWEN_3rd_YEAR, NWEN_3rd_YEAR, ECEN_3rd_YEAR, ENGR_3rd_YEAR, COMP_3rd_YEAR);
	
	public static String[] ALL_4th_YEAR = concat(SWEN_4th_YEAR, NWEN_4th_YEAR, ECEN_4th_YEAR, ENGR_4th_YEAR, COMP_4th_YEAR);
		
	public static String[] ALL_COURSES = concat(ALL_1st_YEAR, ALL_2nd_YEAR, ALL_3rd_YEAR, ALL_4th_YEAR);

	// =====================================
	// MATH
	// =====================================
		
	public static String[] MATH_2nd_YEAR = {
		"MATH211", "MATH243", "MATH244", "MATH251", "MATH261", "MATH277", "OPRE253","STAT292", "STAT293"
	};

	// =====================================
	// HARD PREREQUISITES
	// =====================================
	
	// These are prerequisites which must be observed.
	
	public static Prerequisites[] prereqs = {
		// 100-level
		new Prerequisites("COMP112","COMP102"), // Not necessary, but allows them to clash
		new Prerequisites("COMP103","COMP102","COMP112"),		
		
		// 200-level
		new Prerequisites("COMP261","COMP103","MATH161"),
		
		new Prerequisites("ECEN201"),
		new Prerequisites("ECEN202"),
		new Prerequisites("ECEN203"),
		new Prerequisites("ECEN220"),		
		
		new Prerequisites("ENGR301"),
		new Prerequisites("ENGR302","ENGR301"),
		
		new Prerequisites("SWEN221","COMP103"),		
		new Prerequisites("SWEN222","SWEN221"),
		new Prerequisites("SWEN223","COMP103","ENGR110"),
		new Prerequisites("SWEN224","COMP103","MATH161"),
		
		new Prerequisites("NWEN241","COMP103"),
		new Prerequisites("NWEN242","COMP103","MATH161"),
		new Prerequisites("NWEN243","COMP103"),
									
		// 300-level
		new Prerequisites("COMP304","MATH161","SWEN224"),
		new Prerequisites("COMP307"),
		new Prerequisites("COMP308","COMP261"),
		new Prerequisites("COMP312"),
		new Prerequisites("COMP313"),
		new Prerequisites("COMP361","COMP261"),
	
		new Prerequisites("ECEN301","ECEN201"),
		new Prerequisites("ECEN302","ECEN202"),
		new Prerequisites("ECEN303","ECEN203"),
		new Prerequisites("ECEN310","ECEN220"),
		new Prerequisites("ECEN315","ECEN220"),
		new Prerequisites("ECEN330","ECEN203"),
				
		new Prerequisites("NWEN301","MATH161","NWEN241","NWEN242"),
		new Prerequisites("NWEN302","NWEN241","NWEN242"),
		new Prerequisites("NWEN303","MATH161","NWEN242"),
		new Prerequisites("NWEN304","MATH161","NWEN243"),
		
		new Prerequisites("SWEN301","SWEN222","SWEN223"),
		new Prerequisites("SWEN302","SWEN222"),
		new Prerequisites("SWEN303"),
		new Prerequisites("SWEN304","COMP261","MATH161"),
		
		// 400-level
		new Prerequisites("COMP408","COMP308"),
		new Prerequisites("COMP409","COMP308"),
		new Prerequisites("COMP421","COMP307"),
		new Prerequisites("COMP422","COMP307"),
		new Prerequisites("COMP423","COMP307"),
		
		new Prerequisites("ECEN403","ECEN303"),
		new Prerequisites("ECEN410","ECEN310"),
		new Prerequisites("ECEN415","ECEN315"),
		new Prerequisites("ECEN421","ECEN320"),
		new Prerequisites("ECEN421","ECEN320"),
		new Prerequisites("ECEN425","ECEN301"),
		new Prerequisites("ECEN430","ECEN301"),
		
		new Prerequisites("ENGR401"),
		new Prerequisites("ENGR489"),
		
		new Prerequisites("NWEN401"),
		new Prerequisites("NWEN402","NWEN302","NWEN304"),
		new Prerequisites("NWEN403","NWEN302"),
		new Prerequisites("NWEN404","NWEN302"),
		new Prerequisites("NWEN405","NWEN304"),
		new Prerequisites("NWEN406","NWEN301"),
		
		new Prerequisites("SWEN421","SWEN224"),
		new Prerequisites("SWEN422","SWEN303"),
		new Prerequisites("SWEN423"),
		new Prerequisites("SWEN424"),
		new Prerequisites("SWEN425","SWEN301"),
		new Prerequisites("SWEN426","SWEN301"),
		new Prerequisites("SWEN427","SWEN301"),
		new Prerequisites("SWEN430"),
		new Prerequisites("SWEN431","COMP304"),
		new Prerequisites("SWEN432","SWEN304"),
		new Prerequisites("SWEN433","SWEN304"),
		new Prerequisites("SWEN434","SWEN304"),
	};
	
	// =====================================
	// MAIN
	// =====================================

	public static void main(String[] args) {
		HashMap<String,Set<String>> clashes = new HashMap<String,Set<String>>();
		
		initialiseEmptyClashList(clashes,ALL_COURSES);
		
		// For more information on these rules, see:
		//
		// http://ecs.victoria.ac.nz/Staff/TimetableClashPolicy
		
		/*******************************************************
		 *  100 Level
		 */
		
		// All 100-level ECS courses should not clash with each other nor with
		// MATH 132, 141, 142, 151, 161, 177, ENGR 121, 122, 123, PHYS 114, 115,
		// 122
		
		clashAllAgainstEachOther(clashes,ALL_1st_YEAR);
		
		for(String course : new String[]{"MATH132","MATH141","MATH142","MATH151","MATH161","MATH177","PHYS114","PHYS115","PHYS122"}) {
			addClashAgainstAll(clashes,course,ALL_1st_YEAR);
		}
		
		// ENGR 110 should not clash with any COMP, ECEN, ENGR, NWEN or SWEN 200-level paper.
		for(String course : new String[]{"ENGR110"}) {
			addClashAgainstAll(clashes,course,ALL_2nd_YEAR);
		}
		
		//COMP 102/112 and 103 should not clash with DSDN 101,111,142 and 171 
		for(String course : new String[]{"DSDN101","DSDN111","DSDN112","DSDN142","DSDN171"}) {
			addClashAgainstAll(clashes,course,COMP_1st_YEAR);
		}
		
		/*******************************************************
		 *  200 Level
		 */
		
		// All 200-level COMP, ECEN, ENGR, NWEN and SWEN courses should not clash with
		clashAllAgainstEachOther(clashes,ALL_2nd_YEAR);
		
		// 200-level ECEN should not clash with MATH 243, 244, 251, PHYS 222, 223
		for(String course : new String[]{"MATH243","MATH244", "MATH251", "PHYS222", "PHYS223"}) {
			addClashAgainstAll(clashes,course,ECEN_2nd_YEAR);
		}
		
		// 200-level ECEN should not clash with PHYS 114, 115, MATH 142 nor COMP 103 
		for(String course : new String[]{"PHYS114","PHYS115", "MATH142", "COMP103"}) {
			addClashAgainstAll(clashes,course,ECEN_2nd_YEAR);
		}
				
		// 200-level SWEN/COMP should not clash with ENGR121/123
		for(String course : new String[]{"ENGR121","ENGR123"}) {
			addClashAgainstAll(clashes,course,SWEN_2nd_YEAR);
			addClashAgainstAll(clashes,course,COMP_2nd_YEAR);
		}
		
		// 200-level NWEN/ECEN should not clash with ENGR121/122,123
		for(String course : new String[]{"ENGR121","ENGR122","ENGR123"}) {
			addClashAgainstAll(clashes,course,NWEN_2nd_YEAR);
			addClashAgainstAll(clashes,course,ECEN_2nd_YEAR);
		}
		
		// 200-level SWEN should not clash with PHYS122
		for(String course : new String[]{"PHYS122"}) {
			addClashAgainstAll(clashes,course,SWEN_2nd_YEAR);
			addClashAgainstAll(clashes,course,COMP_2nd_YEAR);
		}
		
		// 200-level NWEN should not clash with PHYS122/PHYS115
		for(String course : new String[]{"PHYS122","PHYS115"}) {
			addClashAgainstAll(clashes,course,NWEN_2nd_YEAR);			
		}
		
		// 200-level NWEN should not clash with MATH 142, 244 or 261
		for(String course : new String[]{"MATH142","MATH244", "MATH261"}) {
			addClashAgainstAll(clashes,course,NWEN_2nd_YEAR);
		}
						
		// 200-level SWEN should not clash with MATH 261
		for(String course : new String[]{"MATH261"}) {
			addClashAgainstAll(clashes,course,SWEN_2nd_YEAR);
		}		
		
		// NWEN 241, SWEN221 should not clash with MDDN 242 
		addClashAgainstAll(clashes,"SWEN221","MDDN242");
		addClashAgainstAll(clashes,"NWEN241","MDDN242");
		
		// COMP 261 should not clash with any MATH 200-level paper, or with MDDN211, MDDN241, MDDN242
		for(String course : MATH_2nd_YEAR) {
			addClashAgainstAll(clashes,course,ECEN_2nd_YEAR);
		}
		for(String course : new String[]{"MDDN211","MDDN241","MDDN242"}) {
			addClashAgainstAll(clashes,course,ECEN_2nd_YEAR);
		}
		
		/*******************************************************
		 *  300 Level
		 */

		// 300-level COMP/SWEN/NWEN/ECEN courses should not clash with 300-level ENGR courses. 
		clashAllAgainstEachOther(clashes,concat(SWEN_3rd_YEAR,ENGR_3rd_YEAR));		
		clashAllAgainstEachOther(clashes,concat(NWEN_3rd_YEAR,ENGR_3rd_YEAR));
		clashAllAgainstEachOther(clashes,concat(ECEN_3rd_YEAR,ENGR_3rd_YEAR));
		clashAllAgainstEachOther(clashes,concat(COMP_3rd_YEAR,ENGR_3rd_YEAR));

		
		// 300-level COMP/SWEN/NWEN courses should not clash with each other; 
		clashAllAgainstEachOther(clashes,concat(COMP_3rd_YEAR,SWEN_3rd_YEAR,NWEN_3rd_YEAR));
		
		// 300-level ECEN courses should not clash with each other. 
		clashAllAgainstEachOther(clashes,ECEN_3rd_YEAR);
		
		// 300-level courses within each specialisation should not clash with
		// any 300-level courses permitted for the specialisation
		for(String course : new String[]{"COMP307", "NWEN301","NWEN302","NWEN304", "SWEN303"}) {
			addClashAgainstAll(clashes,course,ECEN_3rd_YEAR);
		}
		clashAllAgainstEachOther(clashes,concat(NWEN_3rd_YEAR,ECEN_3rd_YEAR));
		
		// 300-level ECEN should not clash with MATH244.
		for(String course : new String[]{"MATH244"}) {
			addClashAgainstAll(clashes,course,ECEN_3rd_YEAR);
		}
		
		// 200-level SWEN/NWEN/COMP should not clash with all 300-level COMP/SWEN/NWEN/ENGR
		clashAllAgainstEachOther(clashes,concat(
				SWEN_2nd_YEAR,
				NWEN_2nd_YEAR,
				COMP_2nd_YEAR,
				SWEN_3rd_YEAR,
				NWEN_3rd_YEAR,
				COMP_3rd_YEAR,
				ENGR_3rd_YEAR));
		
		/*******************************************************
		 *  400 Level
		 */

		//400-level courses within each specialisation should not clash with ENGR 401 or 489; 
		clashAllAgainstEachOther(clashes,concat(SWEN_4th_YEAR,ENGR_4th_YEAR));		
		clashAllAgainstEachOther(clashes,concat(NWEN_4th_YEAR,ENGR_4th_YEAR));
		clashAllAgainstEachOther(clashes,concat(ECEN_4th_YEAR,ENGR_4th_YEAR));
		clashAllAgainstEachOther(clashes,concat(COMP_4th_YEAR,ENGR_4th_YEAR));
	
		// 400-level courses within COMP/SWEN/NWEN should not clash with all 300
		// and 400-level courses within COMP/SWEN/NWEN
		clashAllAgainstEachOther(clashes,concat(
				SWEN_4th_YEAR,SWEN_3rd_YEAR,
				NWEN_4th_YEAR,NWEN_3rd_YEAR,
				COMP_4th_YEAR,COMP_3rd_YEAR));
		
		// 400-level courses within each specialisation should not clash with
		// any 400-level courses permitted for the specialisation
		
		// 400-level courses within each specialisation should not clash with
		// any 400-level courses permitted for the specialisation. This ensures
		// that students can take all courses that may be part of the
		// specialisation requirements. Currently, this means ECEN 400-level
		// courses should not clash with COMP421, NWEN402/403/404 and SWEN422;
		// also that NWEN 400-level courses should not clash with
		// ECEN403/410/421/425/430 (considered the currently feasible subset of
		// courses permitted under NWEN specialisation). 

		for(String course : new String[]{"ECEN403","ECEN410","ECEN421","ECEN423","ECEN430"}) {
			addClashAgainstAll(clashes,course,NWEN_4th_YEAR);
		}
		 
		for(String course : new String[]{"COMP421","NWEN402","NWEN403","NWEN404","SWEN422"}) {
			addClashAgainstAll(clashes,course,ECEN_4th_YEAR);
		}				
		
		// Finally, print out all clashes (in alphabetic order)
		printClashList(clashes);
	}

	// =====================================
	// HELPERS
	// =====================================

	/**
	 * Clash each course in a list against all courses in that list, except for
	 * itself.
	 * 
	 * @param courses
	 * @return
	 */
	public static void clashAllAgainstEachOther(Map<String,Set<String>> clashes, String... courses) {
		for(String c1 : courses) {
			for(String c2 : courses) {
				addClash(clashes,c1,c2);
			}	
		}
	}
	
	/**
	 * Add a clash of one course against every course in a list.
	 * 
	 * @param clashes
	 * @param c1
	 * @param courses
	 */
	public static void addClashAgainstAll(Map<String,Set<String>> clashes, String c1, String ... courses) {
		for(String c2 : courses) {
			addClash(clashes,c1,c2);
		}
	}
	
	/**
	 * Add a clash of one course against another. Note that clashes are not
	 * added for a course against itself. Also, clashes between courses with
	 * prerequisites are ignored.
	 * 
	 * @param clashes
	 * @param c1
	 * @param c2
	 */
	public static void addClash(Map<String,Set<String>> clashes, String c1, String c2) {
		// First, check if they're the same course.
		if(c1.equals(c2)) {
			// yes, ignore
			return; 
		}
		
		// Second, check whether they are prerequisites
		if(hasPrerequisite(c1,c2)) {
			return;
		}
				
		// Ok, add the clash!
		Set<String> c1_clashes = clashes.get(c1);
		Set<String> c2_clashes = clashes.get(c2);
		if(c1_clashes != null) { c1_clashes.add(c2); }
		if(c2_clashes != null) { c2_clashes.add(c1); }		
	}
	
	/**
	 * Initialise an empty clash list for each course.
	 * @param clashes
	 * @param courses
	 */
	public static void initialiseEmptyClashList(Map<String,Set<String>> clashes, String... courses) {
		for(String course : courses) {
			clashes.put(course,new HashSet<String>());
		}
	}
	
	/**
	 * Determine whether c1 is a transitive prerequisite for c2 (or vice versa);
	 * 
	 * @param c1
	 * @param c2
	 * @return
	 */
	public static boolean hasPrerequisite(String c1, String c2) {
		HashSet<String> c1_prereqs = new HashSet<String>();
		computeTransitivePrereqs(c1,c1_prereqs);
		if(c1_prereqs.contains(c2)) {
			return true;
		}
		HashSet<String> c2_prereqs = new HashSet<String>();
		computeTransitivePrereqs(c2,c2_prereqs);
		if(c2_prereqs.contains(c1)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Compute the full set of transitively implied prerequisites for a course.
	 * 
	 * @param c1
	 * @param c1_prereqs
	 */
	public static void computeTransitivePrereqs(String c1, HashSet<String> c1_prereqs) {
		HashSet<String> worklist = new HashSet<String>();
		
		worklist.add(c1);
		
		do {
			String item = worklist.iterator().next();
			worklist.remove(item);
			
			for(Prerequisites p : prereqs) {
				if(p.course == item) {
					for(String prereq : p.prereqs) {
						if(!c1_prereqs.contains(prereq)) {
							worklist.add(prereq);
							c1_prereqs.add(prereq);
						}
					}
				}
			}
			
		} while(!worklist.isEmpty());
				
	}
	
	/**
	 * Print out the clash list in alphabetical order.
	 * 
	 * @param clashes
	 */
	public static void printClashList(Map<String,Set<String>> clashes) {
		for(String course : ALL_COURSES) {
			System.out.print(course + " :");
			ArrayList<String> course_clashes = new ArrayList<String>(clashes.get(course));
			Collections.sort(course_clashes);
			for(String clash : course_clashes) {
				System.out.print(" " + clash);
			}
			System.out.println();
		}
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
	
	public static boolean contains(String item, String[] items) {
		for (String i : items) {
			if (i.equals(item)) {
				return true;
			}
		}
		return false;
	}
	
	public static class Prerequisites {
		public final String course;
		public final String[] prereqs;
		
		public Prerequisites(String course, String... prereqs) {
			this.course = course;
			this.prereqs = prereqs;
		}
	}
}
