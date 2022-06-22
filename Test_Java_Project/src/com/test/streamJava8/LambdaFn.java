package com.test.streamJava8;

import java.util.*;
import java.util.stream.Collectors;

public class LambdaFn {
    
    public List<Long> functionalProgramming(List<String> listOfIntegers)
    {
        //Write your code here
        // for(String str: listOfIntegers){
          
        // }

        List<Long> outputList = listOfIntegers.stream().filter(st -> checkNarcissistic(st).equals(st))
        .map(st -> Long.valueOf(st)).collect(Collectors.toList());
        // List<Long> outputList = Collections.emptyList();
        return outputList;
    }

    public String checkNarcissistic(String str){
    	int len = str.length();
    	Long val = Long.valueOf(str);
    	double sum = 0.0;
    	while (val!=0) {
    		Long rm = val % 10;
    		val = val / 10;
    		sum = sum + Math.pow(rm, len);
    	}
    	Long res = (long)sum;
      return res.toString();
    }
    
	/*
	 * public static void main(String[] args) { LambdaFn obj = new LambdaFn();
	 * System.out.println(obj.checkNarcissistic("153")); }
	 */
    
}
