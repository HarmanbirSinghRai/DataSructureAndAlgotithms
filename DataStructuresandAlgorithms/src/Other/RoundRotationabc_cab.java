/*
 * Coding questions:
1) Given two words, find if second word is the round rotation of first word.
For example: abc, cab
return 1
since cab is round rotation of abc

Example2: ab, aa
return -1
since aa is not round rotation for aa



 */
		
public class RoundRotationabc_cab {
public static void main(String[] args){
	String s="abc";
	String check="cab";
	boolean decision=checkRoundRotation(s,check);
	System.out.println(decision);
}
public static boolean checkRoundRotation(String real, String check){
	int lenght=real.length();
	char[] array=real.toCharArray();
	for(int i=0;i<lenght;i++){
		char temp=array[0];
		int j=0;
		for( j=1;j<lenght;j++){
			array[j-1]=array[j];
		}
		array[j-1]=temp;
		String str = String.valueOf(array);
		if(str.equals(check)){
			return true;
		}
		}
	
	return false;
}
}
