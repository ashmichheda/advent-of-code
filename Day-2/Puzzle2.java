package com.prog.AdventOfCode2018;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Puzzle2 {

	static final int NUMBER_OF_CHARS = 256;
	public static void main(String[] args) {
		int checksum = findCheckSum();
		System.out.println("Checksum is: "+checksum);
	}
	private static int findCheckSum() {
		
		int count[] = new int[NUMBER_OF_CHARS];
		int countTwos = 0, countThrees = 0;
		boolean twoOnce = false, threeOnce = false;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("input.txt"));
			String line = reader.readLine();
			while(line != null) {
				twoOnce = false; 
				threeOnce = false;
				count = new int[NUMBER_OF_CHARS];
				getFrequencyOfChars(line, count);
				for(int i = 0; i < NUMBER_OF_CHARS; i++) {
						
					if(count[i] == 2 && twoOnce != true) {
						twoOnce = true;
						countTwos++;
					}
						
					else if(count[i] == 3 && threeOnce != true){
						threeOnce = true;
						countThrees++;
					}
				}
				line = reader.readLine();
			}			 
		}
		catch(IOException e) {
			
		}		
		return (countThrees*countTwos);
	}
	private static void getFrequencyOfChars(String line, int[] count) {
		
		for(int i = 0; i < line.length(); i++) {
			count[line.charAt(i)]++;
		}
	}
}
