//Jose Escobar & Jacob Wennersten

public class Pair implements Comparable<Pair>{
	public int a = 0;
	public int b = 0;
	public Pair(int a, int b){
		this.a = a;
		this.b = b;
	}


	@Override
	public int compareTo(Pair duo){
		return this.b - duo.b;
	}

	public boolean isChainable(Pair two){
		//check if the chain can be built on the tuple
		return (this.a > two.b);
	}
}