package com.test.studentClass;

public class StudentClass {
    
    public String getQuery(String studentData,String query){
        String output = "";
    	if(query.split(",")[0].equals("1")) {
    		String ch = query.split(",")[1];
    		String[] strArr = studentData.split(" ");
    		for(String str: strArr) {
    			if(str.toUpperCase().startsWith(ch.toUpperCase())) {
    				output = output + str + "\n";
    			}
    		}
    	} else if(query.split(",")[0].equals("2")) {
    		String[] strArr = studentData.split(" ");
    		String[] bloodArr = query.split(",")[1].split(" ");
    		String bloodGrp = query.split(",")[2];
    		for(int i = 0; i<bloodArr.length; i++) {
    			if(bloodArr[i].equals(bloodGrp)) {
    				output = output + strArr[i] + "\n";
    			}
    		}
    	} else if (query.split(",")[0].equals("3")) {
    		int num = Integer.parseInt(query.split(",")[1]);
    		String[] strArr = studentData.split(" ");
    		int count = 0;
    		for(String str: strArr) {
    			if(Integer.parseInt(str) >= num) {
    				count++;
    			}
    		}
    		output = count+" students scored "+num+" above";
    	} else if(query.split(",")[0].equals("4") || query.split(",")[0].equals("5")) {
    		String[] strArr = studentData.split(" ");
    		double sum = 0;
    		int count = 0;
    		for(String str: strArr) {
    			sum = sum + Double.parseDouble(str);
    			count++;
    		}
//    		double div = Double.parseDouble(count + ".0");
    		double result = sum / count;
    		output = String.format("%.2f", result);
    	}
    	
    	System.out.println(output);
		return output;
		
    }
    
}
