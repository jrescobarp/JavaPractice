//Jose Escobar & Jacob Wennersten

import java.util.*;

public class Sums{
	public static void main(String[] args){
		//Given an array, we have to find if 2 elements a + b can be = to 2 distinct elements c + d within the array
		//to do this, sums will be stored in a hash table as keys. if key exists in the table, 1 will be returned 

		Integer[] arguments = new Integer[args.length]; 
		for(int i = 0; i < args.length; i++){
			arguments[i] = Integer.parseInt(args[i]);
		}

		int equalSum = intervalSum(arguments);
		
		System.out.println(equalSum);
	}

	public static int intervalSum(Integer[] args){
		//there have to be more than 4 distinct variables
		int argSize = args.length;
		if(argSize < 4){
			return 0;
		}

		int equalSum = 0;

		HashSet<Integer> sumMap = new HashSet<Integer>();

		//build HashSet with initial adjacent touples of args
		for(int i = 1; i < argSize - 2; i++){
			int sum = args[i] + args[i+1];
			sumMap.add(sum);
		}


		//find and compare new sums to values in sumMap
		for(int interval = 3; interval < argSize; interval++){
			for(int i = 0; i < (argSize - interval); i++){
				int sum = args[i] + args[i+interval];
				if(sumMap.contains(sum)){
					return 1;
				}
				else{
					sumMap.add(sum);
				}
			}
		}
		return 0;
	}

}