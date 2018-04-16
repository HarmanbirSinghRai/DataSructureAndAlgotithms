

/**
 ** Java Program to implement Knuth Morris Pratt Algorithm
 **/
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
/** Class KnuthMorrisPratt **/
public class KnuthMorrisPratt
{
    /** Failure array **/
    private int[] failure;
    /** Constructor **/
    public KnuthMorrisPratt(String text, String pat)
    {
        /** pre construct failure array for a pattern **/
        failure = new int[pat.length()];
        fail(pat);
        /** find match **/
        int pos = posMatch(text, pat);
        if (pos == -1)
            System.out.println("\nNo match found");
        else
            System.out.println("\nMatch found at index "+ pos);
    }
    
    
    private void fail(String pat)
    {
        int n = pat.length();
       failure[0] = 0;
       int index=0;
        for (int j = 1; j < n;)
        { 
            if(pat.charAt(j) == pat.charAt(index)){
            	failure[j] = index + 1;
                index++;
                j++;
            }else{
                if(index != 0){
                    index = failure[index-1];
                }else{
                	failure[j] =0;
                    j++;
                }
            }
        }
    }
    /** Function to find match for a pattern **/
    private int posMatch(String text, String pat)
    {
        int i = 0, j = 0;
        int lens = text.length();
        int lenp = pat.length();
        while (i < lens && j < lenp)
        {
            if (text.charAt(i) == pat.charAt(j))
            {
                i++;
                j++;
            }
            else if (j == 0)
                i++;
            else
            j = failure[j - 1] ;
            
        }
        return ((j == lenp) ? (i - lenp) : -1);
    }
    /** Main Function **/
    public static void main(String[] args) throws IOException
    {    
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       // System.out.println("Knuth Morris Pratt Test\n");
       // System.out.println("\nEnter Text\n");
      ////  String text = br.readLine();
       // System.out.println("\nEnter Pattern\n");
       // String pattern = br.readLine();
        String text = "abxabcabcaby";
        String pattern = "abcaby";
        KnuthMorrisPratt kmp = new KnuthMorrisPratt(text, pattern);        
    }
}

