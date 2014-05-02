import java.io.*;
import java.util.*;

public class ClashListChecker {
	public static Map<String,Set<String>> readFile(String filename) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		HashMap<String,Set<String>> clashes = new HashMap<String,Set<String>>();
		while(reader.ready()) {
			String line = reader.readLine();
			String[] split1 = line.split(":");
			String[] split2 = split1[1].split(" ");
			String course = split1[0].trim();
			Set<String> cs = clashes.get(course);
			if(cs == null) {
				cs = new HashSet<String>();
				clashes.put(course,cs);
			}
			for(String clash : split2) {
				clash = clash.trim();
				if(!clash.equals("")) {
					cs.add(clash);
				}
			}			
		}
		
		return clashes;
	}
	
	public static void sanityCheck(Map<String,Set<String>> clashes, String label) {
		// make sure matrix is a symmetric
		for(Map.Entry<String,Set<String>> e : clashes.entrySet()) {
			for(String clash : e.getValue()) {				
				if(clashes.get(clash) != null && !clashes.get(clash).contains(e.getKey())) {
					System.out.println("*** ERROR: course " + e.getKey() + " not in " + label + " clash list for " + clash);
				}
			}
		}								
	}
	
	public static void compare(Map<String,Set<String>> leftClashes, Map<String,Set<String>> rightClashes) {
		if(!leftClashes.keySet().equals(rightClashes.keySet())) {
			System.out.println(" *** ERROR: different set of courses listed in each clash list file : " + diff(leftClashes.keySet(),rightClashes.keySet()));
		}
		ArrayList<String> courses = new ArrayList<String>(leftClashes.keySet());
		Collections.sort(courses);
		
		for(String course : courses) {
			Set<String> left = leftClashes.get(course);
			Set<String> right = rightClashes.get(course);
			if(left != null && right != null && !left.equals(right)) {
				System.out.println(" *** ERROR: different clash lists for " + course + " : " + diff(left,right));
			}
		}
	}
	
	public static String diff(Set<String> left, Set<String> right) {
		String result = "";
		boolean firstTime=true;
		for(String l : left) {				
			if(!right.contains(l)) {
				if(!firstTime) {
					result += ", ";
				}
				firstTime=false;
				result += "-" + l;
			}
		}
		for(String r : right) {						
			if(!left.contains(r)) {
				if(!firstTime) {
					result += ", ";
				}
				firstTime=false;
				result += "+" + r;
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		Map<String,Set<String>> leftClashes = readFile(args[0]);
		sanityCheck(leftClashes,"LEFT");
		Map<String,Set<String>> rightClashes = readFile(args[1]);
		sanityCheck(rightClashes,"RIGHT");
		compare(leftClashes,rightClashes);
	}
}
