package FirstNonRepeatingChar;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class FirstNonRepeatedHashMap {
    
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        
        System.out.println(" Please enter the input string :" );
        Scanner in = new Scanner (System.in);
        String s=in.nextLine();
        //char c=firstNonRepeatedCharacter(s);
        char c=firstNonRepeatedCharacterLinked(s);
        System.out.println("The first non repeated character is :  " + c);
    }
    
    public static Character firstNonRepeatedCharacter(String str)
    {
        HashMap<Character,Integer>  characterhashtable= 
                     new HashMap<Character ,Integer>();
        int i,length ;
        Character c ;
        length= str.length();  // Scan string and build hash table
        for (i=0;i < length;i++)
        {
            c=str.charAt(i);
            if(characterhashtable.containsKey(c))
            {
                // increment count corresponding to c
                characterhashtable.put(  c ,  characterhashtable.get(c) +1 );
            }
            else
            {
                characterhashtable.put( c , 1 ) ;
            }
        }
        // Search characterhashtable in in order of string str
        
        
        
        for (i =0 ; i < length ; i++ )
        {
            c= str.charAt(i);
            if( characterhashtable.get(c)  == 1 )
            return c;
        }
        return null ;
    }


public static Character firstNonRepeatedCharacterLinked(String str)
{
    LinkedHashMap<Character,Integer>  characterhashtable= 
                 new LinkedHashMap<Character ,Integer>();
    int i,length ;
    Character c ;
    length= str.length();  // Scan string and build hash table
    for (i=0;i < length;i++)
    {
        c=str.charAt(i);
        if(characterhashtable.containsKey(c))
        {
            // increment count corresponding to c
            characterhashtable.put(  c ,  characterhashtable.get(c) +1 );
        }
        else
        {
            characterhashtable.put( c , 1 ) ;
        }
    }
    // Search characterhashtable in in order of string str
    
    Iterator<?> it=characterhashtable.entrySet().iterator();
    
    while(it.hasNext())
    {
    	Map.Entry<Character,Integer>  pair = (Map.Entry)it.next();
       if(pair.getValue().intValue()==1)
        return pair.getKey();
    }
    return null ;
}
} 
