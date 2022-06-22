package com.test.fileHandling;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

// Write your code below.
//
class EncryptDecryptFile{
	public String readEncryptionFile() {
		String messageFromFile = "";
		try {
			String encryptFilename = FileHandling.filepath + "EncryptionFile.txt";
	        BufferedReader reader = new BufferedReader(new FileReader(encryptFilename));
	        messageFromFile = reader.readLine();
	        reader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return messageFromFile;	
	}
	
	public void writeDecryptionFile(String msg) {
		try {
			String decryptFilename = FileHandling.filepath + "DecryptionFile.txt";
//            String generatedString = generateString();
            BufferedWriter writer = new BufferedWriter(new FileWriter(decryptFilename));
            writer.write(msg);
            writer.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

public class FileHandling {
    public static String filepath = System.getenv("OUTPUT_PATH").substring(0, System.getenv("OUTPUT_PATH").lastIndexOf("\\") + 1);

    private static String generateString()
    {
        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        StringBuilder generatedString = new StringBuilder(20);
        Random random = new Random();
        for (int i = 0; i < 40; i++) {
            char c = chars[random.nextInt(chars.length)];
            generatedString.append(c);
        }
        return generatedString.toString();
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();

        try{
            EncryptDecryptFile f = new EncryptDecryptFile ();

            String encryptFilename = FileHandling.filepath + "EncryptionFile.txt";
            String generatedString = generateString();
            BufferedWriter writer = new BufferedWriter(new FileWriter(encryptFilename));
            writer.write(generatedString);
            writer.close();

            if(f.readEncryptionFile().equals(generatedString))
            {
                f.writeDecryptionFile(message);

                String decryptFilename = FileHandling.filepath + "DecryptionFile.txt";
                BufferedReader reader = new BufferedReader(new FileReader(decryptFilename));
                String messageFromFile = reader.readLine();
                reader.close();

                System.out.println(messageFromFile);
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }

}
