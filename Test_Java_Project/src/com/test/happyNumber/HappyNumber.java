package com.test.happyNumber;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HappyNumber {
	public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        
        Parent p = new Parent();
        p.filter();
        p = new ChildOne();
        String res = p.filter();
        System.out.println(res);
        p = new ChildTwo();
        String result = p.filter();
        System.out.println(result);
    }
}

class Parent{
    public static int startElement, endElement;
    public String filter(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            // Scanner sc = new Scanner(System.in);
            startElement = Integer.parseInt(br.readLine());
            endElement = Integer.parseInt(br.readLine());
            System.out.println("Hii -- "+ startElement);
            System.out.println("Hii -- "+ endElement);
        } catch(Exception e){
            
        }
                
        return null;
    }
}

class ChildOne extends Parent{
    
    public String filter(){
        System.out.println(startElement);
        System.out.println(endElement);
        StringBuilder str = new StringBuilder();
        for(int i = startElement; i<= endElement; i++) {
        	int res = checkPrime(i);
        	if(res == 2) {
        		str.append(i + " ");
        	}
        }
        return str.toString();
    }
    
    public int checkPrime(int element) {
    	int count = 0;
    	for(int i= 1; i<=element; i++) {
    		if(element % i == 0) {
    			count ++;
    		}
    	}
    	return count;
    }
    
}

class ChildTwo extends Parent{
    
    public String filter(){
        System.out.println(startElement);
        System.out.println(endElement);
        StringBuilder str = new StringBuilder();
        for(int i = startElement; i <= endElement; i++) {
    		int res = checkHappyNumber(i);
    		if (res == 1)
    			str.append(i + " ");
    	}
        return str.toString();
    }
    
    public int checkHappyNumber(int element) {
    	int sum = 0;
    	while(element != 0) {
    		int rm = element % 10;
    		sum = sum + rm * rm;
    		element = element / 10;
    	}
    	if(sum != 1 && sum != 4) {
    		return checkHappyNumber(sum);
    	} else {
    		return sum;
    	}
    }
}
