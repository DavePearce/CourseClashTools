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
		"ECEN201-18508", "ECEN202-18509", "ECEN203-18510", "ECEN220-18511"
	};

	public static String[] ECEN_3rd_YEAR = {
		"ECEN301-18512","ECEN302-18513","ECEN303-18514","ECEN310-18515","ECEN315-18516","ECEN320-18517","ECEN330-18518"
	};

	public static String[] ECEN_4th_YEAR = {
		"ECEN403-18520", "ECEN405-18521", "ECEN410-18522", "ECEN415-18519", "ECEN421-18523", "ECEN425-18524", "ECEN426-18574", "ECEN430-18576"
	};

	// =====================================
	// ENGR
	// =====================================

	public static String[] ENGR_1st_YEAR = {
		"ENGR101-15243","ENGR110-26051","ENGR121-26052", "ENGR122-26053", "ENGR123-27044"
	};

	public static String[] ENGR_3rd_YEAR = {
		"ENGR301-17178","ENGR302-17179"
	};

	public static String[] ENGR_4th_YEAR = {
		"ENGR401-18690", "ENGR489-18688"
	};

	// =====================================
	// COMP
	// =====================================
	public static String[] COMP_1st_YEAR = {
		"COMP102-943","COMP112-26034","COMP103-945"
	};

	public static String[] COMP_2nd_YEAR = {
		"COMP261-183141"
	};

	public static String[] COMP_3rd_YEAR = {
		"COMP304-964","COMP307-968","COMP308-23085","COMP312-10444","COMP313-25049","COMP361-26060"
	};

	public static String[] COMP_4th_YEAR = {
		"COMP408-23084","COMP409-23083","COMP421-986","COMP422-2324","COMP423-4962","COMP425-990","COMP471-26217","COMP472-10767","COMP488-23082","COMP489-8243"
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
		new Prerequisites("COMP112-26034","COMP102-943"), // Not necessary, but allows them to clash
		new Prerequisites("COMP103-945","COMP102-943","COMP112-26034"),

		// 200-level
		new Prerequisites("COMP261-183141","COMP103-945","MATH161"),

		new Prerequisites("ECEN201-18508"),
		new Prerequisites("ECEN202-18509"),
		new Prerequisites("ECEN203-18510"),
		new Prerequisites("ECEN220-18511"),

		new Prerequisites("ENGR301-17178"),
		new Prerequisites("ENGR302-17179","ENGR301-17178"),

		new Prerequisites("SWEN221-18318","COMP103-945"),
		new Prerequisites("SWEN222-18319","SWEN221-18318"),
		new Prerequisites("SWEN223-18320","COMP103-945","ENGR110-26051"),
		new Prerequisites("SWEN224-18321","COMP103-945","MATH161"),

		new Prerequisites("NWEN241-18315","COMP103-945"),
		new Prerequisites("NWEN242-18316","COMP103-945","MATH161"),
		new Prerequisites("NWEN243-18363","COMP103-945"),

		// 300-level
		new Prerequisites("COMP304-964","MATH161","SWEN224-18321"),
		new Prerequisites("COMP307-968"),
		new Prerequisites("COMP308-23085","COMP261-183141"),
		new Prerequisites("COMP312-10444"),
		new Prerequisites("COMP313-25049"),
		new Prerequisites("COMP361-26060","COMP261-183141"),

		new Prerequisites("ECEN301-18512","ECEN201-18508"),
		new Prerequisites("ECEN302-18513","ECEN202-18509"),
		new Prerequisites("ECEN303-18514","ECEN203-18510"),
		new Prerequisites("ECEN310-18515","ECEN220-18511"),
		new Prerequisites("ECEN315-18516","ECEN220-18511"),
		new Prerequisites("ECEN330-18518","ECEN203-18510"),

		new Prerequisites("NWEN301-17180","MATH161","NWEN241-18315","NWEN242-18316"),
		new Prerequisites("NWEN302-17181","NWEN241-18315","NWEN242-18316"),
		new Prerequisites("NWEN303-17182","MATH161","NWEN242-18316"),
		new Prerequisites("NWEN304-17184","MATH161","NWEN243-18363"),

		new Prerequisites("SWEN301-17183","SWEN222-18319","SWEN223-18320"),
		new Prerequisites("SWEN302-17184","SWEN222-18319"),
		new Prerequisites("SWEN303-17185"),
		new Prerequisites("SWEN304-17186","COMP261-183141","MATH161"),

		// 400-level
		new Prerequisites("COMP408-23084","COMP308-23085"),
		new Prerequisites("COMP409-23083","COMP308-23085"),
		new Prerequisites("COMP421-986","COMP307-968"),
		new Prerequisites("COMP422-2324","COMP307-968"),
		new Prerequisites("COMP423-4962","COMP307-968"),

		new Prerequisites("ECEN403-18520","ECEN303-18514"),
		new Prerequisites("ECEN410-18522","ECEN310-18515"),
		new Prerequisites("ECEN415-18519","ECEN315-18516"),
		new Prerequisites("ECEN421-18523","ECEN320-18517"),
		new Prerequisites("ECEN421-18523","ECEN320-18517"),
		new Prerequisites("ECEN425-18524","ECEN301-18512"),
		new Prerequisites("ECEN430-18576","ECEN301-18512"),

		new Prerequisites("ENGR401-18690"),
		new Prerequisites("ENGR489-18688"),

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
		new Prerequisites("SWEN431-18669","COMP304-964"),
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

