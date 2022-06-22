package com.test.studentMark;

import java.util.ArrayList;
import java.util.List;

public class Aided extends Student {

	public String result(String allMarks) {
		System.out.println("Marks -- " + allMarks);

		String subjectMarks = allMarks.split("\\|")[0];
		String nccMarks = allMarks.split("\\|")[1];
		String sportMarks = allMarks.split("\\|")[2];
		String[] arr = subjectMarks.split(",");
		List<Integer> marksArr = new ArrayList<>();
		List<Integer> creditArr = new ArrayList<>();
		for (String st : arr) {
			System.out.println(st);
			String[] subArr = st.split(" ");
			marksArr.add(Integer.parseInt(subArr[0]));
			creditArr.add(Integer.parseInt(subArr[1]));
		}
		if (nccMarks.split(",")[0].equals("1")) {
			System.out.println("inn..");
			marksArr.add(Integer.parseInt(nccMarks.split(",")[1]));
			creditArr.add(Integer.parseInt(nccMarks.split(",")[2]));
		}
		if (sportMarks.split(",")[0].equals("1")) {
			System.out.println("innnnnn....");
			marksArr.add(Integer.parseInt(sportMarks.split(",")[1]));
			creditArr.add(Integer.parseInt(sportMarks.split(",")[2]));
		}
		int maxCr = 1;
		for (int cr : creditArr) {
			if (cr > maxCr)
				maxCr = cr;
		}
		System.out.println(marksArr.size());
		List<Double> gradeArr = new ArrayList<>();
		int totalCredit = 0;
		for (int mark : marksArr) {
			gradeArr.add(getGrade(mark));
			totalCredit = totalCredit + maxCr;
		}
		System.out.println(totalCredit);
		int count = 0;
		double sum = 0;
		for (double grade : gradeArr) {
			sum = sum + (grade * creditArr.get(count));
			System.out.println(sum);
			count++;
		}
		Double result = sum / totalCredit;
		// Double result = 9.1;
		// DecimalFormat formatter = new DecimalFormat("#.00#");
		System.out.println(String.format("%.2f", result));
		// System.out.println(formatter.format(result));
		System.out.println(String.format("%.2f", result).hashCode());
		return String.format("%.2f", result);

	}

	public double getGrade(int num) {
		double grade = 0.0;
		String gradeFormat = "";
		if (num >= 75 && num <= 100) {
			int diff = num - 75;
			grade = 9 + (diff * 0.04);
		} else if (num >= 60 && num <= 74) {
			int diff = num - 60;
//			grade = 8 + (diff * 0.0642857143);
			grade = 8 + (diff * 0.06);
		} else if (num >= 50 && num <= 59) {
			int diff = num - 50;
			grade = 7 + (diff * 0.1);
		} else if (num >= 40 && num <= 49) {
			int diff = num - 40;
			grade = 6 + (diff * 0.1);
		} else {
			grade = 0;
		}
		gradeFormat = String.format("%.1f", grade);
		return Double.parseDouble(gradeFormat);
	}

}
