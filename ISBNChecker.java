package cs207;

public class ISBNChecker {
	public static int digitSum (String isbn) {
		int leng = isbn.length(); 
		int sum = 0;
		for (int i = 0; i < (leng - 1); i++) {
			int digit = Character.getNumericValue(isbn.charAt(i));
			sum += (i + 1) * digit;
		}
		return sum;
	}
	
	public static boolean isISBN(String isbn){
		int leng = isbn.length();
		int sum = digitSum(isbn);
		String lastChar = Character.toString(isbn.charAt(leng - 1));
		if ((sum % 11) == 10) {
			boolean output = (lastChar.equals("X")); 
			return output;
		}
		else { 
			int remainder = (sum % 11);
			int lastDigit = Character.getNumericValue(isbn.charAt(leng - 1));
			boolean output = (remainder == lastDigit);
			return output;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("0205080057 is " + isISBN("0205080057"));
		System.out.println("0136091812 is " + isISBN("0136091812"));
		System.out.println("123456789X is " + isISBN("123456789X"));
	}

}
