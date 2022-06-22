package com.test;

import java.io.IOException;

public class TestJava {
	
	 static public void main(String[] args) {
		
		System.out.println(0.0 %0.0);
		
		TestJava j = new TestJava();
		j.method();
		
//		 arr =  int[4];
		
		int age = 0;
		age = age + 7;
		System.out.println(age);
		
		boolean b1 = true;
		boolean b2 = false;
		
		if(b2=true && b1) {
			System.out.println("3");
		}
		int i = 10;
		boolean b = (i++>10 && ++i<15);
		System.out.println(i);
		int l = 12;
		switch (l) {
		case 2: System.out.println("heello");
		case 12: System.out.println("Hiii");
		default:
			throw new IllegalArgumentException("Unexpected value: " + l);
		}
		
//		try {
//			throw new IOException();
//		} catch (Exception e) {
//			System.out.println("Exception");
//		} catch (IOException e) {
//			System.out.println("IOexception");
//		}
	}
	 
	 public static void method() {
		 System.out.println("hsdjhs");
	 }

}
