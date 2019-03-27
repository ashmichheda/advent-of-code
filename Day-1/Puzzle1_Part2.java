package com.prog.AdventOfCode2018;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Puzzle1_Part2 {

	public static void main(String[] args) {
		BufferedReader reader;
		int sum = 0;
		
		HashSet<Integer> value = new HashSet<>();
		try {
			reader = new BufferedReader(new FileReader("D:\\AshmiD\\ASHMI\\GitHub\\advent-of-code-2018\\Puzzle-1\\input.txt"));
			String line = reader.readLine();
			outer: while(true) {
				while(line != null) {
					sum += Integer.parseInt(line);
					if(value.contains(sum)) {
						System.out.println("Frequency occurred twice: "+sum);
						break outer;
					}
					else
						value.add(sum);
					line = reader.readLine();
					
				}
				reader = new BufferedReader(new FileReader("D:\\AshmiD\\ASHMI\\GitHub\\advent-of-code-2018\\Puzzle-1\\input.txt"));
				line = reader.readLine();
			}
			 
		}
		catch(IOException e) {
			
		}

	}

}
