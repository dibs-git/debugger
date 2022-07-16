package com.javatechie.oop;

public class Child extends Parent {

//	@Override // not override static method
    public static void m2() {
        System.out.println("child static m1()");
    }


    public static void main(String[] args) {
    	Parent p = new Child();
    	p.m2();
        Parent.m2();
        Child.m2();
    }
}
