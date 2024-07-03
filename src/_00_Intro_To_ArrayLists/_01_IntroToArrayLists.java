package _00_Intro_To_ArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
    public static void main(String[] args) {
        // 1. Create an array list of Strings
        //    Don't forget to import the ArrayList class
    	ArrayList<String> strings = new ArrayList();
        // 2. Add five Strings to your list
    	strings.add("hello");
    	strings.add("coding");
    	strings.add("food");
    	strings.add("airplane");
    	strings.add("shell");

        // 3. Print all the Strings using a standard for-loop
    	for(int i = 0; i < strings.size(); i++) {
    		System.out.println(strings.get(i));
    	}
    	System.out.println();
        // 4. Print all the Strings using a for-each loop
    	for(String s: strings) {
    		System.out.println(s);
    	}
    	System.out.println();
        // 5. Print only the even numbered elements in the list.
    	for(int i = 1; i < strings.size(); i+=2) {
    		System.out.println(strings.get(i));
    	}
    	System.out.println();
        // 6. Print all the Strings in reverse order.
    	for(int i = strings.size()-1; i>=0; i--) {
    		System.out.println(strings.get(i));
    	}
    	System.out.println();
        // 7. Print only the Strings that have the letter 'e' in them.
    	for(String s: strings) {
    		for(int i = 0; i < s.length(); i++) {
    			char e = s.charAt(i);
    			if(e == 'e') {
    				System.out.println(s);
    			}
        }
    }
    }
}
