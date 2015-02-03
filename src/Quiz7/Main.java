package Quiz7;
 /*Connor Michel
  * IS 247-03
  * Quiz 7
  */
public class Main {
	
	public static int f(int lo, int hi){
		if(lo > hi)
			return 0;
		if(lo == hi)
			return lo;
		return lo++ + f(lo,hi);		
	}

	public static void main(String[]args){
		System.out.println(f(1,8));
	}
}
