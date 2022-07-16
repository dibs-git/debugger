package com.javatechie.immutable;

import java.util.*;
import java.util.stream.Collectors;

public final class Employee {

	private final String name;
	private final Date doj;// mutable
	private final List<String> mobile;
	private final Map<Integer, String> student;
	private final Address address;

	public Employee(String name, Date doj, List<String> mobile, Address address, Map<Integer, String> student) {
		this.name = name;
		this.doj = doj;
		this.mobile = mobile;
		this.student = student;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public Date getDoj() {
		return (Date) doj.clone();
	}

	public List<String> getMobile() {
//    	return Collections.unmodifiableList(mobile);
		return new ArrayList<>(mobile);
	}

	public Address getAddress() {
		return new Address(address.getCity(), address.getZip());
	}
	
	public Map<Integer, String> getStudent() {
//		return student;
//		return Collections.unmodifiableMap(student);
		return new HashMap<Integer, String>(student);
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", doj=" + doj + ", mobile=" + mobile + ", student=" + student + ", address="
				+ address + "]";
	}

	public static void main(String[] args) {
		Address address = new Address("blr", "1012");
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Dibakar");
		map.put(2, "Santosh");
		map.put(3, "Amritesh");
		Employee employee = new Employee("Basant", new Date(),
				Arrays.stream(new String[] { "1234", "5678" }).collect(Collectors.toList()), address, map);
		employee.getStudent().put(4, "Madhab");
		employee.getDoj().setDate(20);
		employee.getMobile().add("9010");
		employee.getAddress().setCity("Pune");

		System.out.println(employee);

	}
}
