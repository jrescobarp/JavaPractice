//Jose Escobar & Jacob Wennersten

import java.util.Arrays;



public class Chains{
	public static void main(String[] args){
		//find the longest chain possible given args, where the first number is the number of integer tuples
		//then for the next given tuples (a,b)(c,d) the chain must be b<c, or d<a
		//given a<b, and c<d 
		int maxChain = 1;
		int size = Integer.parseInt(args[0]);
		Pair[] longChain = new Pair[size]; 

		for(int i = 2; i <= args.length; i+=2){
			//read args starting at 2-1, read parts.A at i-1
			Pair parts = new Pair(Integer.parseInt(args[i-1]),Integer.parseInt(args[i]));
			//fill chain @ i/2-1
			longChain[(i/2)-1] = parts;
		}//longChain is now filled but not sorted
	
		Arrays.sort(longChain);//longChain is now sorted by pair.b

		Pair endLink = longChain[0];
		for(int j = 1; j < longChain.length; j++){
			if(longChain[j].isChainable(endLink)){
				maxChain++;
				endLink = longChain[j];
			}
		}		

		System.out.println(maxChain);
	}
}