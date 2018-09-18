//Jose Escobar & Jacob Wennersten
//Hashmap

import java.util.*;

public class Hashy{
	public static void main(String[] args){
		//build a hashmap given a string args that will count the number of instances of a character 
		int count = 1;
		Map<Character, Integer> hashy = new HashMap<Character, Integer>();
		String str = args[0];
		for(int i = 0; i < str.length(); i++){
			char key = str.charAt(i);
			if(hashy.containsKey(key)){
				//characters are the key and the number of times the character appears wil be the integer value
				hashy.put(key , hashy.get(key)+1);
			}
			else{
				//if character does not exist in HashMap, add it
				hashy.put(key , count);
			}
		}

		System.out.println(hashy);		
	}

}