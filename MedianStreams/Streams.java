//Jose Escobar & Jacob Wennersten

import java.util.*;
import java.util.stream.*;
import java.io.IOException;


public class Streams{
	public static void main(String[] args){
		//given an input stream of n integrs, insert ints to stream and print the median of the new stream formed by 
		//each insertion of x into stream 

		//get input from user with first int N being # of inputs, and then any next int being data values
		System.out.println("Please enter stream size.");
		int streamSize = Integer.parseInt(System.console().readLine());
		ArrayList<Integer> inputStream = new ArrayList<Integer>();

		for(int i = 1; i <= streamSize; i++){
			System.out.println("Please enter next value");
			int streamData = Integer.parseInt(System.console().readLine());	
			inputStream.add(streamData);
			if(i%2 == 1){
				//if our current size is odd, just use the middle value
				//to access middle element in stream, we must truncate to middle of stream (because streams are not indexed)
				// Integer median = 
				System.out.println("median " + inputStream.stream()
										.sorted()
										.skip(i/2)
									// .limit(1)
										.findFirst()
										.get()+ " " + inputStream);

			}
			else{
				//if current size is even, find the middle two numbers and find their average
				// int median = ;	
				System.out.println("median " + inputStream.stream()
										.sorted()
										.skip((i/2)-1)
										.limit(2)
										.reduce((a,b)->((a+b)/2))
										.get() + " " + inputStream);

			}
		}

		System.out.println("Finished");
	}
}