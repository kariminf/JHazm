package aak.tools;

public class Strings {

	public static void showcharcodes(String word){

		for (char c: word.toCharArray()){

			System.out.println(c + "=" + Character.getType(c));
		}

	}
	
	public static String specialTrim(String word){
		char[] wordChars = word.toCharArray();
		int start = 0;
		while (start < wordChars.length && delChar(wordChars[start]))
			start++;
		
		int end = wordChars.length-1;
		while(end >= 0 && delChar(wordChars[end]))
			end--;
		
		if (start > end) return "";
		
		return word.substring(start, end+1);
	}
	
	private static boolean delChar(char c){
		int charType = Character.getType(c);
		return (11 <charType && charType <20);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
