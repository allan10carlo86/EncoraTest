package Utilities;


import java.text.ParseException;
import java.security.SecureRandom;

public class Utilities {
	
	public String getAmount(String str_amount) {
	    String[] result = str_amount.split(" ");
	    //System.out.println(result[0]);
	    return result[0]; 
	
	}
	
	public double formatNumber(String str_amount) {
		return Double.parseDouble(str_amount.replaceAll("[$,]", ""));
	}
	
	public static void main(String args[]) throws ParseException {
		String amount = "$5,000.00";
		Utilities util = new Utilities();
		Double number = util.formatNumber(amount);
		System.out.println(number+500);
        int len = 10;
        System.out.println(util.generateRandomPassword(len));
	}
	
	public String generateRandomPassword(int len)
    {
        // ASCII range – alphanumeric (0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
 
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
 
        // each iteration of the loop randomly chooses a character from the given
        // ASCII range and appends it to the `StringBuilder` instance
 
        for (int i = 0; i < len; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
 
        return sb.toString() + "$";
    } 
}
