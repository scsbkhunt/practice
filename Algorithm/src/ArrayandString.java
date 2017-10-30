
public class ArrayandString {
	
	//URLify
	public void replaceSpaces(char[] str, int trueLength) {
		int spaceCount = 0;
		int i = 0;
		
		for(i = 0; i < trueLength; i++) {
			if(str[i] == ' ') {
				spaceCount++;
			}
		}
		
		int index = trueLength + 2 * spaceCount;
		
		if(trueLength < str.length) str[trueLength] = '\0';
		for(i = trueLength  - 1; i >= 0; i--) {
			if(str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index = index - 3;
			} else {
				str[index - 1] = str[i];
				index--;
			}
		}
	}
	
	//palindrome permutation
	public boolean isPermutationOfPalindrome(String s) {
		int[] map = new int[128];
		for(int i = 0; i < s.length(); i++) {
			map[s.charAt(i)]++;
		}
		int count = 0;
        for (int key = 0; key < map.length && count <= 1; key++) {
            count += map[key] % 2;
        }
        return count <= 1;
	}
	
	//One way
	boolean oneEditaway(String s, String t) {
		if(Math.abs(s.length() - t.length()) > 1) return false;
		
		String s1 = s.length() < t.length() ? s: t;
		String s2 = s.length() < t.length() ? t: s;
		
		int index1 = 0;
		int index2 = 0;
		
		boolean foundDiff = false;
		
		while(index1 < s1.length() && index2 < s2.length()) {
			if(s1.charAt(index1) != s2.charAt(index2)) {
				if(foundDiff) return false;
				foundDiff = true;
				if(s1.length() == s2.length()) index1++;
			} else {
				index1++;
			}
			index2++;
		}
		return true;
	}
	
	//String Compression
	String compress(String s) {
		int result = countCompress(s);
		if(result >= s.length()) return s;
		
		StringBuilder compressed = new StringBuilder(result);
		int consec = 0;
		for(int i = 0; i < s.length(); i++) {
			consec++;
			if(i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
				compressed.append(s.charAt(i));
				compressed.append(consec);
				consec = 0;
			}
		}
		return compressed.toString();
	}
	
	int countCompress(String s) {
		int result = 0;
		for(int i = 0; i < s.length(); i++) {
			
			//System.out.println(s.charAt(i + 1));
			if(i + 1 == s.length() || s.charAt(i) != s.charAt(i + 1)) {
				result += 2;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		ArrayandString s = new ArrayandString();
		
		char[] test = {'a', 'r', 'e', ' ', 'o', 'k', ' ', ' '};
		
		s.replaceSpaces(test, 6);
		
		System.out.println(s.compress("fferrrrtgghhh"));// a2b2c2d3e2f1
	}
}
