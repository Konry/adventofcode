package four;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class MD5Gen {
	ArrayList<Integer> listOfAccepted;
	
	/*MD5 hash
	 * Starts with: 00000
	 * 
	 * secret key: bgvyzdsv
	 * Find lowest decimal number
	 * 
	 * Beispiel A:
	 * abcdef
	 * 609043
	 * 
	 * result 000001dbbfa...
	 * 
	 * Beispiel B:
	 * pqrstv
	 * 104897
	 * result: 000006136ef...
	 * */

	public MD5Gen() {
		listOfAccepted = new ArrayList<Integer>();
		// TODO Auto-generated constructor stub
	}
	
	public String getMD5(String input){
		byte[] source;
        try {
            //Get byte according by specified coding.
            source = input.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            source = input.getBytes();
        }
        String result = null;
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source);
            //The result should be one 128 integer
            byte temp[] = md.digest();
            char str[] = new char[16 * 2];
            int k = 0;
            for (int i = 0; i < 16; i++) {
                byte byte0 = temp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            result = new String(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
	}
	
	public void calculateLowestMD5(String secretKey){
		int i = 1;
		while (true){
//		for(int i = 1; i <= 9999999; i++){
			if(i%100000 == 0) {
				System.out.println("\t\tCalculate "+i);
			}
			String temp = getMD5(secretKey+String.valueOf(i));
//			System.out.println(temp);
			if(checkLeadingZeros(temp)){
				System.out.println("Add "+i);
				listOfAccepted.add(i);
				break;
			}
			i++;
		}
	}
	
	private boolean checkLeadingZeros(String temp) {
		if(temp.startsWith("000000")){
			System.out.println("Accepted: "+temp);			
			System.out.println();
			return true;
		}
		return false;
	}

	public void run() {
		// TODO Auto-generated method stub
//		System.out.println(getMD5("abcdef609043"));
//		System.out.println(getMD5("pqrstuv1048970"));
		
		calculateLowestMD5("abcdef");
		calculateLowestMD5("pqrstuv");
		calculateLowestMD5("bgvyzdsv");
	}

}
