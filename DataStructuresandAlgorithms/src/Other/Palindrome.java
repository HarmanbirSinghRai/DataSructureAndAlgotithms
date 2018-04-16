
public class Palindrome {
    public static boolean isPalindrome(String str) {
    	str=str.replaceAll("\\W", "").toLowerCase();
    	int length = str.length();
    	System.out.println(str);
    	StringBuilder reverse=new StringBuilder();
    	 
        for ( int i = length - 1; i >= 0; i-- )
           reverse = reverse.append(str.charAt(i));
        
   System.out.println(reverse);
   
        return str.equals(reverse.toString());
       
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("Nitin"));
    }
}
