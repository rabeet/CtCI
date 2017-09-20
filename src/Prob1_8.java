
public class Prob1_8 {
	
	/*
	 * 1.8:
	 * Assume two strings s1 and s2 are given. Figure out if
	 * s1 is a rotation of s2. Eg: water is a rotation of rwate
	 * using only one call to isSubstring method.
	 * 
	 * Basic HashMap question except it has to be thru rotation
	 * First find the start of the s2 in s1, then traverse thru both strings
	 * matching each letter one by one. If either of the chain breaks then return false
	 * else return true.
	 * But then the problem is that oww is not a rotation of wow when it should be.
	 *
	 * the bruteforce way is to keep rotating s1 and equate it to s2 in each try
	 * 
	 * Easier way is to concatenate s1 to itself and see if s2 is a
	 * substring of s1.
	 */

	public static void main(String[] args) {
		System.out.println(isRotation("police", "elic"));
	}
	
	public static boolean isRotation(String s1, String s2) {
//		if (!isSubstring()) return false;
		
		if (s2.length() < s1.length()) {
			return false;
		} else {
			// Assuming we have  helper func which rotates a string once
			for (int i = 0; i < s1.length(); i++) {
				s1 = rotateOnce(s1);
				if (s1.equals(s2)) return true;
			}
		}
		return false;
	}
	
	/*
	 * eg: "police", inp: "licepo"
	 * 
	 *
	 */
	
	// Rotate a string once
	public static String rotateOnce(String s) {
		String ans = ""+s.charAt(s.length()-1);
		for (int i = 0; i < s.length(); i++) {
			if (i == s.length()-1) continue;
			ans += ""+s.charAt(i);
		}
		return ans;
	}

	public static boolean isSubstring() {
		return true;
	}
}
