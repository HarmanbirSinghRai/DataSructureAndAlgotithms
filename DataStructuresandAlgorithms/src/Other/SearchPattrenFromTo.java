

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**Given a log file: 
some garbage...from:123.54,78.21...more garbage..to:56,82,124.54...more 
some more garbage...from:11.54,45.84...garbage..to:115.87,98.65 
... 

Write a program or shell script to return pairs of (from, to) coordinates. 

Assumption: these coordinates will always appear in sequence: from ... to... from ... to... 
But these from - to pair may or may not be on same line.
**/

public class SearchPattrenFromTo {
	
	public static void main(String[] args){
		
		InputStreamReader inStream = null;
		BufferedReader bis = null;
		String string;
		try{
			inStream=new FileReader("GarbageLog.txt");
		  bis=new BufferedReader(inStream);
			
			while((string=bis.readLine())!=null){
				//System.out.println(string);
				Pattern pattern = Pattern.compile("(from:-?\\d+.\\d+,-?\\d+.\\d+)|(to:-?\\d+.\\d+,-?\\d+.\\d+)");
				//pattern=Pattern.compile("(from:-?\\d+.\\d,?\\d+.\\d)|(to:)")
				Matcher matcher = pattern.matcher(string);
				while (matcher.find()) {
					if(matcher.group(1) != null) System.out.println(matcher.group(1));
					if(matcher.group(2) != null) System.out.println(matcher.group(2));
				}
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}

}
