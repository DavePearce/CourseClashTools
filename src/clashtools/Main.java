package clashtools;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import clashtools.core.ClashList;
import clashtools.core.Prerequisites;
import clashtools.core.ClashRule;
import clashtools.io.ClashListReader;
import clashtools.util.CheckAllAgainstEachOther;

public class Main {


	// =====================================
	// SWEN
	// =====================================

	public static String[] SWEN_2nd_YEAR = {
		"SWEN221-18318","SWEN222-18319","SWEN223-18320","SWEN224-18321"
	};

	public static String[] SWEN_3rd_YEAR = {
		"SWEN301-17183","SWEN302-17184","SWEN303-17185","SWEN304-17186"
	};

	public static String[] SWEN_4th_YEAR = {
			"SWEN421-18661", "SWEN422-18662",
			"SWEN423-18663", "SWEN424-18664", "SWEN425-18665", "SWEN426-18666",
			"SWEN427-18667", "SWEN430-18668", "SWEN431-18669", "SWEN432-18670",
			"SWEN433-18671", "SWEN434-18672", "SWEN438-18597", "SWEN439-18598"
	};

	// =====================================
	// NWEN
	// =====================================

	public static String[] NWEN_2nd_YEAR = {
		"NWEN241-18315","NWEN242-18316","NWEN243-18363"
	};

	public static String[] NWEN_3rd_YEAR = {
		"NWEN301-17180","NWEN302-17181","NWEN303-17182","NWEN304-17184"
	};

	public static String[] NWEN_4th_YEAR = {
		"NWEN401-18602", "NWEN402-18603", "NWEN403-18604", "NWEN404-18605", "NWEN405-18606", "NWEN406-18592","NWEN438-18593","NWEN439-18594"
	};

	// =====================================
	// ECEN
	// =====================================

	public static String[] ECEN_2nd_YEAR = {
		"ECEN201-18508", "ECEN202", "ECEN203", "ECEN220"
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

		new Prerequisites("ECEN201-18508"),
		new Prerequisites("ECEN202"),
		new Prerequisites("ECEN203"),
		new Prerequisites("ECEN220"),

		new Prerequisites("ENGR301"),
		new Prerequisites("ENGR302","ENGR301"),

		new Prerequisites("SWEN221-18318","COMP103"),
		new Prerequisites("SWEN222-18319","SWEN221-18318"),
		new Prerequisites("SWEN223-18320","COMP103","ENGR110"),
		new Prerequisites("SWEN224-18321","COMP103","MATH161"),

		new Prerequisites("NWEN241-18315","COMP103"),
		new Prerequisites("NWEN242-18316","COMP103","MATH161"),
		new Prerequisites("NWEN243-18363","COMP103"),

		// 300-level
		new Prerequisites("COMP304","MATH161","SWEN224-18321"),
		new Prerequisites("COMP307"),
		new Prerequisites("COMP308","COMP261"),
		new Prerequisites("COMP312"),
		new Prerequisites("COMP313"),
		new Prerequisites("COMP361","COMP261"),

		new Prerequisites("ECEN301","ECEN201-18508"),
		new Prerequisites("ECEN302","ECEN202"),
		new Prerequisites("ECEN303","ECEN203"),
		new Prerequisites("ECEN310","ECEN220"),
		new Prerequisites("ECEN315","ECEN220"),
		new Prerequisites("ECEN330","ECEN203"),

		new Prerequisites("NWEN301-17180","MATH161","NWEN241-18315","NWEN242-18316"),
		new Prerequisites("NWEN302-17181","NWEN241-18315","NWEN242-18316"),
		new Prerequisites("NWEN303-17182","MATH161","NWEN242-18316"),
		new Prerequisites("NWEN304-17184","MATH161","NWEN243-18363"),

		new Prerequisites("SWEN301-17183","SWEN222-18319","SWEN223-18320"),
		new Prerequisites("SWEN302-17184","SWEN222-18319"),
		new Prerequisites("SWEN303-17185"),
		new Prerequisites("SWEN304-17186","COMP261","MATH161"),

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

		new Prerequisites("NWEN401-18602"),
		new Prerequisites("NWEN402-18603","NWEN302-17181","NWEN304-17184"),
		new Prerequisites("NWEN403-18604","NWEN302-17181"),
		new Prerequisites("NWEN404-18605","NWEN302-17181"),
		new Prerequisites("NWEN405-18606","NWEN304-17184"),
		new Prerequisites("NWEN406-18592","NWEN301-17180"),

		new Prerequisites("SWEN421-18661","SWEN224-18321"),
		new Prerequisites("SWEN422-18662","SWEN303-17185"),
		new Prerequisites("SWEN423-18663"),
		new Prerequisites("SWEN424-18664"),
		new Prerequisites("SWEN425-18665","SWEN301-17183"),
		new Prerequisites("SWEN426-18666","SWEN301-17183"),
		new Prerequisites("SWEN427-18667","SWEN301-17183"),
		new Prerequisites("SWEN430-18668"),
		new Prerequisites("SWEN431-18669","COMP304"),
		new Prerequisites("SWEN432-18670","SWEN304-17186"),
		new Prerequisites("SWEN433-18671","SWEN304-17186"),
		new Prerequisites("SWEN434-18672","SWEN304-17186"),
	};

	// ============================================================
	// The Rules
	// ============================================================

	private static final ClashRule[] clashRules = {

		// All 100-level ECS courses should not clash with each other ...
		new CheckAllAgainstEachOther(ALL_1st_YEAR),

		// nor with MATH 132, 141, 142, 151, 161, 177, ENGR 121, 122, 123, PHYS 114,
		// 115, 122
	};

	public static void main(String[] args) throws IOException {
		ClashListReader reader = new ClashListReader(args[0]);
		List<ClashList> clashLists = reader.read();
		for(ClashList c : clashLists) {
			for(ClashRule r : clashRules) {
				ClashRule.Diff diff = r.check(c);
				if(diff != null) {
					System.out.println("*** ERROR: different clash lists for " + c.name() + " " + diff);
				}
			}
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
}

