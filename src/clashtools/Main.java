package clashtools;

import java.io.IOException;

import clashtools.io.ClashListReader;

public class Main {


	public static void main(String[] args) throws IOException {
		ClashListReader reader = new ClashListReader(args[0]);
		reader.read();
	}
}
