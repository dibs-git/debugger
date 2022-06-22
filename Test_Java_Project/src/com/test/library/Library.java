package com.test.library;

import java.util.*;

public class Library {

	String bookName;
	String author;

	Library() {
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 83 * hash + Objects.hashCode(this.bookName);
		hash = 83 * hash + Objects.hashCode(this.author);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Library other = (Library) obj;
		if (!Objects.equals(this.bookName, other.bookName)) {
			return false;
		}
		if (!Objects.equals(this.author, other.author)) {
			return false;
		}
		return true;
	}

	Library(String bookName, String author) {
		this.bookName = bookName;
		this.author = author;
	}

	public HashMap<Integer, Library> createLibraryMap(String booksInLibrary) {
		String[] strArr = booksInLibrary.split("\\|");
		HashMap<Integer, Library> libraryMap = new HashMap<Integer, Library>();
		for (String str : strArr) {
			libraryMap.put(Integer.parseInt(str.split(",")[0]), new Library(str.split(",")[1], str.split(",")[2]));
		}
		return libraryMap;
	}

	public HashMap<Integer, Integer> createUserMap(String borrowedUsers) {

		String[] strArr = borrowedUsers.split("\\|");
		HashMap<Integer, Integer> userMap = new HashMap<Integer, Integer>();
		for (String str : strArr) {
			userMap.put(Integer.parseInt(str.split(",")[0]), Integer.parseInt(str.split(",")[1]));
		}
		return userMap;
	}

//	@SuppressWarnings("unlikely-arg-type")
	public String getQuery(String booksInLibrary, String borrowedUsers, String query) {
		HashMap<Integer, Library> libraryMap = createLibraryMap(booksInLibrary);
		HashMap<Integer, Integer> userMap = createUserMap(borrowedUsers);
		String output = "";
		if(query.split(",")[0].equals("1")) {
			String key = query.split(",")[1];
			for(Map.Entry<Integer, Library> map: libraryMap.entrySet()) {
				if(Integer.toString(map.getKey()).equals(key)) {
					Library obj = map.getValue();
					output = "It is available\nAuthor is "+obj.author+"\n";
				}
			}
			for(Map.Entry<Integer, Integer> map: userMap.entrySet()) {
				if(Integer.toString(map.getKey()).equals(query.split(",")[1])) {
					int userId = map.getValue();
					output = "No Stock\nIt is owned by "+userId+"\n";
				}
			}
		} else if(query.split(",")[0].equals("2")) {
			for(Map.Entry<Integer, Integer> map: userMap.entrySet()) {
				if(Integer.toString(map.getValue()).equals(query.split(",")[1])) {
					int bookId = map.getKey();
					output = output + map.getKey() + " "+libraryMap.get(bookId).bookName+"\n";
				}
			}
		} else if(query.split(",")[0].equals("3")) {
			int borrow = 0;
			int books = 0;
			for(Map.Entry<Integer, Library> map: libraryMap.entrySet()) {
				if(map.getValue().bookName.equals(query.split(",")[1])) {
					if(userMap.containsKey(map.getKey())) {
						borrow++;
					}
					books++;
				}
			}
			output = borrow+" out\n"+books+" in\n";
		} else if(query.split(",")[0].equals("4")) {
			for(Map.Entry<Integer, Library> map: libraryMap.entrySet()) {
				if(map.getValue().author.equals(query.split(",")[1])) {
					output = output + map.getValue().bookName+"\n";
				}
			}
		} else if(query.split(",")[0].equals("5")) {
			for(Map.Entry<Integer, Library> map: libraryMap.entrySet()) {
				if(map.getValue().bookName.toUpperCase().contains(query.split(",")[1].toUpperCase())) {
					output = output + map.getKey()+ " " + map.getValue().bookName+"\n";
				}
			}
		}
		System.out.println(output);
		return output;
	}

}
