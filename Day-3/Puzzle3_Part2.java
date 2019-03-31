package com.prog.AdventOfCode2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Puzzle3_Part2 {

	public static void main(String[] args) throws FileNotFoundException {
		@SuppressWarnings("resource")
		String fileContent = new Scanner(new File("input.txt"))
				.useDelimiter("\\Z").next();

		String claims = getClaims(fileContent);
		System.out.println("Claims made: "+claims);
	}

	private static String getClaims(String fileContent) {

		HashMap<String, Integer> fabric = new HashMap<String, Integer>();
		HashMap<Integer, Boolean> codes = new HashMap<Integer, Boolean>();
		for(String line : fileContent.split("\\r?\\n")) {
			int parsed[] = parseLine(line);
			int code = parsed[0], left = parsed[1], top = parsed[2], width = parsed[3], height = parsed[4];
			boolean claimed = true;
			
			for(int i = left; i < left+width; i++) {
				for(int j = top; j< top+height; j++) {
					
					if(fabric.get(i +"," + j) == null)
						
						// for each inch, specify which code it has been claimed
						fabric.put(i + "," + j, code);
												
					else {
						
						claimed = false;
						int otherCode = fabric.get(i+ "," +j);
						codes.put(otherCode, false);
					}
				}
			}
			codes.put(code, claimed);
			
		}
		
		for(int code : codes.keySet()) {
			// iterate through all the codes to get the one which is valid
			if(codes.get(code))
				return Integer.toString(code);
		}
				
		return "Not found";
	}

	private static int[] parseLine(String line) {

		String parsed[] = line.split("[ #@,x:]+");
		int code = Integer.parseInt(parsed[1]);
		int left = Integer.parseInt(parsed[2]);
		int top = Integer.parseInt(parsed[3]);
		int width = Integer.parseInt(parsed[4]);
		int height = Integer.parseInt(parsed[5]);
		
		return new int[] {code, left, top, width, height};
	}

}
