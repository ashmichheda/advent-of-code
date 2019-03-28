package com.prog.AdventOfCode2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Puzzle2_Part2 {

	public static void main(String[] args) throws FileNotFoundException {

		// Compare 2 words letter by letter
		// fileContent reads the entire file into a String 
		@SuppressWarnings("resource")
		String fileContent = new Scanner(new File("input.txt"))
				.useDelimiter("\\Z").next();
		
		String commonString = getCommonString(fileContent);
		System.out.println("IDs differing by 1 character is: "+commonString);

	}

	private static String getCommonString(String fileContent) {

		String words[] = fileContent.split("[\\r\\n]+");
		String word1, word2, same;
		int difference;
		
		for(int i = 0; i< words.length-1; i++) {
			for(int j = i+1; j< words.length; j++) {
				
				word1 = words[i];
				word2 = words[j];
				difference = 0;
				same = "";
				
				for(int k = 0; k < word1.length(); k++) {
					if(word1.charAt(k) != word2.charAt(k))
						difference++;
					else
						same += word1.charAt(k);
					if(difference > 1)
						break;
				}
				if(difference == 1)
					return same;
			}
		}
		
	return "Not Found";
	}

}
