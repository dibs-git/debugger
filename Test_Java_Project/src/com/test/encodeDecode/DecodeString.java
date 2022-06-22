package com.test.encodeDecode;

public class DecodeString {

	public static void main(String[] args) {
		DecodeString obj = new DecodeString();
		String encodeText = obj.encodeText("Hi! How are you?");
		System.out.println("Result -- " + encodeText);
		String decodeText = obj.decodeText(encodeText);
//		String str = obj.decodeText("?85O89*69R65*87O104*33I1043");
		System.out.println("Result -- " + decodeText);
	}

	public String encodeText(String normal) {
		StringBuilder str = new StringBuilder();
		for (int i = normal.length() - 1; i >= 0; i--) {
			Character ch = normal.charAt(i);
			if (Character.isUpperCase(ch))
				str.append(ch.toString().toLowerCase());
			else
				str.append(ch.toString().toUpperCase());
		}
		String str1 = str.toString().replace(' ', '*');

		StringBuilder str2 = new StringBuilder();

		for (int i = 0; i < str1.length(); i++) {
			if (i % 2 == 0)
				str2.append(str1.charAt(i));
			else
				str2.append((int) str1.charAt(i));
		}
		str2.append(3);
		// System.out.println(str2.toString());
		return str2.toString();
	}

	public String decodeText(String ciphered) {
		String str = ciphered.substring(0, ciphered.length() - 1);
		StringBuilder str1 = new StringBuilder();
		int i = 0;
		int subIndex = 0;
		StringBuilder intStr = new StringBuilder();
		while (i < str.length()) {
			if (Character.isDigit(str.charAt(i))) {
				subIndex++;
				intStr.append(str.charAt(i));
				// int num = Integer.parseInt(str.substring(i,i+2));
				// str1.append((char)num);
				i++;
			} else {
				if (subIndex != 0) {
					int num = Integer.parseInt(intStr.toString());
					subIndex = 0;
					intStr = new StringBuilder();
					str1.append((char) num);
				}
				str1.append(str.charAt(i));
				i++;
			}
		}
		if (subIndex != 0) {
			int num = Integer.parseInt(intStr.toString());
			subIndex = 0;
			intStr = new StringBuilder();
			str1.append((char) num);
		}
		String str2 = str1.toString().replace('*', ' ');

		StringBuilder str3 = new StringBuilder();
		for (int j = str2.length() - 1; j >= 0; j--) {
			Character ch = str2.charAt(j);
			if (Character.isUpperCase(ch))
				str3.append(ch.toString().toLowerCase());
			else
				str3.append(ch.toString().toUpperCase());
		}
		return str3.toString();
	}
}
