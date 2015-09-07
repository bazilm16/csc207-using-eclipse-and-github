import java.util.Scanner;

public class VigenereCipher {

	public static int mod( int num, int divisor){
		int val = num % divisor;
		if(val<0){
			val+=divisor;
		}
		return val;
	}//mod
	
	//method to encrypt a string
	public static String encrypt(String un_str, String key){
		int strLeng = un_str.length();
		int keyLeng = key.length();
		char[] strArray = un_str.toCharArray();
		char[] keyArray = key.toCharArray();
		//if the key's length is smaller than that of the string, lengthen it
		int base = (int) 'a';
		for(int i = 0; i < strLeng; i++){
			int remain = i % keyLeng;
			int intVal = ((int)strArray[i] - base) + ((int)keyArray[remain] - base);
			strArray[i] = (char)(mod(intVal, 26) + base);
		}
		return new String(strArray);
	}//encrypt
	
	public static String decrypt(String un_str, String key){
		int strLeng = un_str.length();
		int keyLeng = key.length();
		char[] strArray = un_str.toCharArray();
		char[] keyArray = key.toCharArray();
		//if the key's length is smaller than that of the string, lengthen it
		int base = (int) 'a';
		for(int i = 0; i < strLeng; i++){
			int remain = i % keyLeng;
			int intVal = mod((int)strArray[i] - (int)keyArray[remain], 26) + base;
			strArray[i] = (char)intVal;
		}
		return new String(strArray);
	}
	
	public static void main(String[] args) {
		System.out.println("This program encrypts and decrypts messages using the Caeser Cipher.");
		System.out.println("Would you like to encode or decode a message?");
		//Get the user input
		Scanner in = new Scanner(System.in);
		String response = in.nextLine();
		if(!(response.equals("encode") || response.equals("decode"))){
			System.out.println("Valid options are \"encode\" or \"decode\"");
		}else if(response.equals("encode")){
			System.out.println("Enter the string to encode:");
			String str = in.nextLine();
			System.out.println("Enter your keyword:");
			String key = in.nextLine();
			System.out.println("Your encrypted message is:");
			System.out.println(encrypt(str, key));
		}
		else {
			System.out.println("Enter the string to decode:");
			String str = in.nextLine();
			System.out.println("Enter your keyword:");
			String key = in.nextLine();
			System.out.println("Your decrypted message is:");
			System.out.println(decrypt(str, key));
		}
		
	}
}
