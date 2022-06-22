package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CharPattern {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("Please enter the number of line (Not more than 26) : ");
			int totalRows = sc.nextInt();
			if (totalRows < 1 || totalRows > 26) {
				throw new Exception("Wrong Input. Please enter between 1 to 26");
			}
//			int totalCols = totalRows + (totalRows - 1);
//			for (int i = 0; i < totalRows; i++) {
//				int count = 1;
//				for (int j = 0; j < totalRows - i; j++) {
//					System.out.print((char) (65 + j)+ " ");
//					count++;
//				}
//				for (int j = 0; j < (i + (i - 1)); j++) {
//					System.out.print("  ");
//					count++;
//				}
//				for (int j = totalCols - count; j >= 0; j--) {
//					System.out.print((char) (65 + j)+ " ");
//				}
//				System.out.println();
//			}
			StringBuilder str = new StringBuilder();
			IntStream.range(0, totalRows).forEach(i -> str.append((char)(65+i)));
			String totalChars = str.toString();
			String reverseChars = str.reverse().substring(1);
			StringBuilder space = new StringBuilder();
			IntStream.range(0, 2*(totalRows-1)-1).forEach(i -> space.append(" "));
			IntStream.range(0, totalRows).forEach(i -> System.out.println(totalChars.substring(0,totalRows-i) + space.substring(0,(2*i)-1<0?0:(2*i)-1) + reverseChars.substring((i-1)<0?0:(i-1),reverseChars.length())));
		} catch (Exception e) {
			System.out.println("Error: " + (e.getMessage()!=null?e.getMessage():e.toString()));
		}
	}
}
