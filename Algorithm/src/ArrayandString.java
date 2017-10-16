
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
	
	public static void main(String[] args) {
		ArrayandString s = new ArrayandString();
		
		char[] test = {'a', 'r', 'e', ' ', 'o', 'k', ' ', ' '};
		
		s.replaceSpaces(test, 6);
		
		System.out.println(test);
	}
}
