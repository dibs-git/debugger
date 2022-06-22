package com.test.manualException;

import java.util.Scanner;


class Validator {
    public static boolean validate(String message) {
        return message.matches("[A-Za-z0-9 ]+");
    }
}

class Encrypter {
	public static String encryptMessage(String msg) {
		String output = "";
		try {
			if(Validator.validate(msg)) {
				StringBuilder res = new StringBuilder();
				char[] chArr = msg.toCharArray();
				for(int i = chArr.length-1; i >=0; i--) {
					res.append(chArr[i]);
				}
				output = res.toString();
			} else {
				throw new ManualException("InvalidMessageException: Try again with valid message");
			}
		} catch (Exception e) {
			output = e.getMessage().toString();
			throw new ManualException("InvalidMessageException: Try again with valid message");
		}
//		System.out.println(Character.toUpperCase('w'));
//		System.out.println(output);
		return output;
	}
}

class ManualException extends RuntimeException{
	public ManualException(String msg) {
		super(msg);
	}
}
public class Solution1 {
    private static final Scanner INPUT_READER = new Scanner(System.in);
    
    public static void main(String[] args) {
        String message = INPUT_READER.nextLine();
        
        try {
            String encrypted_message = Encrypter.encryptMessage(message);
            if(! encrypted_message.startsWith("InvalidMessageException"))
                System.out.println(encrypted_message);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
