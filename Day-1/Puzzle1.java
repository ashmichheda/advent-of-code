package com.prog.AdventOfCode2018;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Puzzle1 {

	public static void main(String[] args) {
		
		BufferedReader reader;
		int sum = 0;
		try {
			reader = new BufferedReader(new FileReader("input.txt"));
			String line = reader.readLine();
			while(line != null) {
				sum += Integer.parseInt(line);
				System.out.println("sum = "+line);
				line = reader.readLine();
			}
			System.out.println(sum);
		}
		catch(IOException e) {
			
		}

	}

}
