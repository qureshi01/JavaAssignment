package com.example.java_assignments;

import java.util.Scanner;

import static com.sun.tools.javac.util.StringUtils.toLowerCase;
import static com.sun.tools.javac.util.StringUtils.toUpperCase;

public class InputValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Prompt the user to enter their name
        System.out.print("Enter your String 1: ");
        // Read the input entered by the user
        String String1 = scanner.nextLine();

        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Enter your String 2: ");
        String String2 = scanner.nextLine();

        //Concatenation
        System.out.println(String1 +" "+ String2);

        //Length of a string
        System.out.println("Length : "+String1.length());
        System.out.println("Length : "+String2.length());

        //Uppercase and Lowercase
        System.out.println("UPPERCASE : "+String1.toUpperCase());
        System.out.println("UPPERCASE : "+String2.toUpperCase());
        System.out.println("LOWERCASE : "+String1.toLowerCase());
        System.out.println("LOWERCASE : "+String2.toLowerCase());

        //Extract Substring
        System.out.println("SUBSTRING : " +String1.substring(1,4));
        //System.out.println("SUBSTRING : " +String2.substring(0,4));

        //Split a sentence
        // Split the sentence into words using whitespace as the delimiter
        String[] words = String1.split(" ");

        // Display each word
        System.out.println("Words in the sentence:");
        for (String word : words) {
            System.out.println(word);
        }

        //Reverse String
        String reversed = reverseString(String1);
        System.out.println("Original string: " + String1);
        System.out.println("Reversed string: " + reversed);

    }

    public static String reverseString(String String1) {
        // Convert the string to a character array
        char[] charArray = String1.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        // Swap characters from both ends until we reach the middle
        while (left < right) {
            // Swap charArray[left] and charArray[right]
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            // Move towards the middle
            left++;
            right--;
        }

        // Convert the character array back to a string
        return new String(charArray);
    }
}

