import java.util.Scanner;

/*
 *  1. Magic of 3

A number ending with 3 will have a multiple which is all 1. Eg­ multiple of 3 is 111 and of

13 is 111111. Given a number ending with 3 find its least multiple which is all 1. The

2 multiple of the given number can be beyond the range of int,long etc. Optimize for time.

 */
public class Magicof3 {
@SuppressWarnings("resource")
public static void main(String[] args){
	System.out.println(ones(new Scanner(System.in).nextInt()));
}
public static String ones(int n)
{
   int i, m = 1;
   String num="1";

    for (i = 1; i <= n; i++) {
             if (m == 0)
             return num;
            /* Solution found */
            num=num+"1";
           m = (10*m + 1) % n;
   }
   return null;  /* No solution */
}
}
