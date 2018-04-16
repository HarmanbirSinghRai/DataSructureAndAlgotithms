package Stack;

public class PermuteBraces {  
	  
    public final static String openBrace = "(";  
    public final static String closeBrace = ")";  
  
    public static void main(String[] args) {  
        printBrackets("", 0, 0, 4);  
    }  
  
      
    /** This method will print balanced brackets  
     * e.g for pairs = 3 output will be 
     *  ((())) 
        (()()) 
        (())() 
        ()(()) 
        ()()() 
     * @param output 
     * @param open 
     * @param close 
     * @param pairs 
     */  
    public static void printBrackets(String output, int open, int close, int pairs) {  
        if ((open == pairs) && (close == pairs)) {  
            System.out.println(output);  
        } else {  
            if (open < pairs)  
                printBrackets(output + openBrace, open + 1, close, pairs);  
            if (close < open)  
                printBrackets(output + closeBrace, open, close + 1, pairs);  
        }  
    }  
} 