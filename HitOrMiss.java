
public class HitOrMiss {
	
	static Boolean hitToken = true;
	
	public static Boolean trueHit(int column, int row) {
		return hitToken;
	}
	
	public static void main(String[] args) {

		System.out.println(trueHit(0,0));
		

	}

}
