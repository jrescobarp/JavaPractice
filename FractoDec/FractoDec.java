//Jose Escobar & Jacob Wennersten

public class FractoDec{
	public static void main(String[] args){
		//given a fraction, convert it into a decimal
		//if the decimal has consecutive repeating numbers, return them inside ()
		//example: 8/3 = 2.(6)

		System.out.println("Please enter how many fractions you want converted to decimal.");
		int numFractions = Integer.parseInt(System.console().readLine());
		int[] numerFracs = new int[numFractions];
		int[] demonFracs = new int[numFractions];

		//create and fill an array with numerators on even indeces, and denominators on the odd indeces
		for(int i = 0; i < numFractions; i++){
			//take numerator
			System.out.println("Please enter a numerator.");
			numerFracs[i] = Integer.parseInt(System.console().readLine());
			//take denominator
			System.out.println("Please enter a denominator");
			demonFracs[i] = Integer.parseInt(System.console().readLine());
		}

		//now, take numbers at equal indeces and divide
		//integer division gives us all the values before the decimal
		//use modulo to find the first remainder that will give us the first decimal point
		//build the quotient as a string adding numbers one at a time
		for(int j = 0; j < numFractions ; j++){
			String quotient = Integer.toString(numerFracs[j] / demonFracs[j]);
			int currRemainder = numerFracs[j]%demonFracs[j];//initial remainder
			int prevRemainder = 0;//used to find repeating numbers
			int fixedRemainder = 0;//used to match magnitudes while dividing
			String lastNum = ".";
			if(currRemainder != 0){
				int limit = 0;//sets limit for repeating decimal groups
				//answer has a decimal point
				while(currRemainder != prevRemainder && limit < 100){
					quotient += lastNum;
					fixedRemainder = currRemainder * 10;//increase magnitude for long division
					while(fixedRemainder/demonFracs[j] == 0){
						//while you still cannot divide, increase magnitude by another 10, and add 0s to quotient
						fixedRemainder *= 10;
						quotient += "0";
					}
					lastNum = Integer.toString(fixedRemainder/demonFracs[j]);
					prevRemainder = currRemainder;
					currRemainder = fixedRemainder%demonFracs[j];
					limit++;
				}
				if(limit<100){
					quotient += "(" + lastNum + ")";
				}
				else{
					quotient += lastNum;
				}
			}
			System.out.println(quotient);
		}
	}
}