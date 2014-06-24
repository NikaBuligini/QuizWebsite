package model;

public class CipherPass {
	
	final int key = 7;
	
	public CipherPass(){
		
	}
	
	public String Cipher(String pass){
		String result="";
		char chars[] = pass.toCharArray();
		for(int i=0; i<chars.length; i++){
			int sum = chars[i]+key;
			if (sum>126) sum=32+sum-127;
			chars[i]=(char) (sum);
			result=result+chars[i];
		}
		
		
		return result;
	}
	public String Decipher(String ciphered){
		String result="";
		char chars[] = ciphered.toCharArray();
		for(int i=0; i<chars.length; i++){
			int sum = chars[i]-key;
			if (sum<32) sum=126-31+sum;
			chars[i]=(char) (sum);
			result=result+chars[i];
		}
		
		
		return result;
	}
	
}