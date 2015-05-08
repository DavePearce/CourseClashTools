package clashtools.io;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import clashtools.core.ClashList;

/**
 * This reads the course clash list as exported from Excel as a CSV file. This
 * needs to be updated as the input format changes (which it does regularly).
 *
 * @author David J. Pearce
 *
 */
public class ClashListReader {
	private BufferedReader reader;

	public ClashListReader(String filename) throws IOException {
		this(new InputStreamReader(new FileInputStream(filename), "UTF8"));
	}

	public ClashListReader(InputStream instream) throws IOException {
		this(new InputStreamReader(instream, "UTF8"));
	}

	public ClashListReader(Reader reader) throws IOException {
		this.reader = new BufferedReader(reader);
	}

	public List<ClashList> read() throws IOException {
		ArrayList<ClashList> courses = new ArrayList<ClashList>();

		int lineNumber = 1;
		while(reader.ready()) {
			String line = reader.readLine();
			List<String> split = split(line,lineNumber);
			if(split.size() != 0) {
				String department = split.get(0);
				String course = split.get(1);
				String module = split.get(2);
				String trimester = split.get(3);
				String noClashes = split.get(4);
				List<String> noClashList = split(noClashes.substring(1,noClashes.length()-1),lineNumber);
				System.out.println("NO CLASH: " + noClashList);
				courses.add(new ClashList(module,noClashList));
			}
			lineNumber = lineNumber+1;
		}

		return courses;
	}

	public static List<String> split(String line, int lineNumber) {
		ArrayList<String> rs = new ArrayList<String>();
		for (int i = 0; i != line.length(); i = skipWhiteSpace(i, line)) {
			if (!rs.isEmpty()) {
				i = match(',', i, line, lineNumber);
			}
			i = skipWhiteSpace(i,line);
			String item = parseItem(i, line, lineNumber);
			i += item.length();
			rs.add(item);
		}

		return rs;
	}

	private static String parseItem(int start, String line, int lineNumber) {
		int i = start;
		if(i < line.length() && line.charAt(i) == '\"') {
			i = match('"',i,line,lineNumber);
			while(i < line.length() && line.charAt(i) != '\"') {
				i = i + 1;
			}
			i = match('"',i,line,lineNumber);
			return line.substring(start,i);
		} else {
			while(i < line.length() && line.charAt(i) != ',') {
				i = i + 1;
			}
		}
		return line.substring(start,i);
	}

	private static int skipWhiteSpace(int i, String line) {
		while (i < line.length() && Character.isWhitespace(line.charAt(i))) {
			i = i + 1;
		}
		return i;
	}

	private static int match(char expected, int i, String line, int lineNumber) {
		i = skipWhiteSpace(i,line);
		if(i < line.length() && line.charAt(i) == expected) {
			return i+1;
		}
		throw new RuntimeException("line " + lineNumber + ": expected '" + expected + "', found '" + line.charAt(i) + "'");
	}
}
