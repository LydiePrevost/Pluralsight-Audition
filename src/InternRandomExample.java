import java.util.Random;


public class InternRandomExample {
	private static final int MAX = 500_000;
	public static void main(String[] args) throws Exception {
		System.out.println("starting");
		long t = System.currentTimeMillis();
//		Uses a String array to keep a strong reference to the String objects.
		Random rand = new Random();
	    String[] arr= new String[MAX];
		for(int i = 0; i < 1_000_000; i ++){
		       arr[i] = Long.toString(rand.nextLong(),36);
	    }
//	   Print the first element in the end to avoid removal of the structure due to optimization.		
		System.out.println("done " + arr[0] + "   , " + (System.currentTimeMillis() - t) + " ms");
		System.gc();
	}
}
