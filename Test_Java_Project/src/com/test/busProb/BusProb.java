package com.test.busProb;

import java.util.ArrayList;
import java.util.List;

class Passanger {
	int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getFare() {
		return fare;
	}

	public void setFare(float fare) {
		this.fare = fare;
	}

	float fare;

	public Passanger(int id, float fare) {
		this.id = id;
		this.fare = fare;
	}
}

public class BusProb {

	public String output(int capacity, int stops, List<String> listOfInputStrings, String query) {
		String query1 = query.split(",")[0];
		String pId = "";
		if (query1.equals("5") || query1.equals("4") || query1.equals("3"))
			pId = query.split(",")[1].trim();
		boolean case5 = false;
		String outstring = "";
//		DecimalFormat df = new DecimalFormat("#.#");
		double fare1 = capacity + (capacity * 0.6);
		double fare2 = capacity + capacity * 0.3;
		double fare3 = capacity;
		long cap25 = 0;
		long cap50 = 0;
		if (capacity % 4 == 0)
			cap25 = capacity / 4;
		else {
			double d = capacity / 4.0;
			cap25 = Math.round(d);
		}
		if (capacity % 2 == 0)
			cap50 = capacity / 2;
		else {
			double d = capacity / 2.0;
			cap50 = Math.round(d);
		}
//		System.out.println(cap25);
		int totalPgCount = 0;
		int inPgCount = 0;
		int outPgCount = 0;
		int totalInPgCount = 0;
		int totalOutPgCount = 0;
		List<Integer> pgCat1 = new ArrayList<>();
		List<Integer> pgCat2 = new ArrayList<>();
		List<Integer> pgCat3 = new ArrayList<>();
		List<String> pIdList = new ArrayList<>();
		double case3Sum = 0.0;
		int case6Count = 0;
		for (String str : listOfInputStrings) {
			pIdList = new ArrayList<>();
			inPgCount = 0;
			outPgCount = 0;
			String[] pgAr = str.split(" ");
			for (String pg : pgAr) {
				if (pg.startsWith("+")) {
					inPgCount++;
					totalInPgCount++;
					String tempStr = pg.substring(1);
					if (tempStr.equals(pId)) {
						case5 = true;
						pIdList.add(pId);
						case6Count++;
					}
				} else {
					outPgCount++;
					totalOutPgCount++;
					String tempStr = pg.substring(1);
					if (tempStr.equals(pId))
						case5 = false;
				}
			}
			totalPgCount = totalPgCount + inPgCount - outPgCount;
			if (totalPgCount <= cap25) {
				pgCat1.add(inPgCount);
				if (pIdList.contains(pId))
					case3Sum = case3Sum + fare1;
			} else if (totalPgCount > cap25 && totalPgCount <= cap50) {
				pgCat2.add(inPgCount);
				if (pIdList.contains(pId))
					case3Sum = case3Sum + fare2;
			} else {
				pgCat3.add(inPgCount);
				if (pIdList.contains(pId))
					case3Sum = case3Sum + fare3;
			}
		}
		int sum1 = 0;
		for (int cat : pgCat1) {
			sum1 = sum1 + cat;
		}
		int sum2 = 0;
		for (int cat : pgCat2) {
			sum2 = sum2 + cat;
		}
		int sum3 = 0;
		for (int cat : pgCat3) {
			sum3 = sum3 + cat;
		}
		if (query1.equals("2")) {

			outstring = sum1 + " passengers traveled with a fare of " + String.format("%.1f", fare1) + ", " + sum2
					+ " passengers traveled with a fare of " + fare2 + " and " + sum3
					+ " passengers traveled with a fare of " + fare3;
		} else if (query1.equals("1")) {
			outstring = totalInPgCount + " passengers got on the bus and " + totalOutPgCount + " passengers "
					+ "got out of the bus";
		} else if (query1.equals("5")) {
//			int pId = Integer.parseInt(query.split(",")[1].trim());
			if (case5) {
				outstring = "Passenger " + pId + " was inside the bus at the end of the trip";
			} else {
				outstring = "Passenger " + pId + " was not inside the bus at the end of the trip";
			}
		} else if (query1.equals("3")) {
			outstring = "Passenger " + pId + " spent a total fare of " + case3Sum;
		} else if (query1.equals("4")) {
			outstring = "Passenger " + pId + " has got on the bus for " + case6Count + " times";
		}
		System.out.println(outstring);
		return outstring;
	}
}
