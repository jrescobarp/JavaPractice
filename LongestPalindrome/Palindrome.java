//Jose Escobar & Jacob Wennersten

// import java.util.*;

public class Palindrome{
	public static void main(String[] args){
		//Given a string, find the longest palindrome in O(n) time
		String paLongDrome = findPalindrome(args[0]);
		System.out.println(paLongDrome);
	}

	public static String findPalindrome(String input){
		String paLongDrome = "";
		//Search string for a letter with equal left & right (odd palindrome), or two consecutive equal letters (even palindrome)
		for(int i = 1; i < (input.length()-1); i++){
			String drome = "";
			if(input.charAt(i-1) == input.charAt(i+1)){//odd
				drome = palChecker(i-1, i+1, input);
			}
			else if(input.charAt(i) == input.charAt(i-1)){//even
				drome = palChecker(i-1, i, input);
			} 
			else if(input.charAt(i) == input.charAt(i+1)){//even
				drome = palChecker(i, i+1,input);
			}

			if(drome.length() > paLongDrome.length()){
				paLongDrome = drome;
			}
		}
		return paLongDrome;
	}

	public static String palChecker(int left, int right, String input){
		//check either sides of left and right until they are no longer equal, 
		//then return substring defined by left and right as indeces
		while((left - 1) >= 0  &&  (right+1) < input.length()  &&  input.charAt(left-1) == input.charAt(right+1)){
			left--;
			right++;
		}
		return input.substring(left, (right+1));
	}
}