package Stack;

import java.util.Stack;

//Java program to print next
//greater element using stack

public class NextGreaterElement 
{
 /* prints element and NGE pair for 
    all elements of arr[] of size n */
 static void printNGE(int arr[], int n,Stack<Integer> s) 
 {
     int i = 0;
    
     int element, next;

     /* push the first element to stack */;

     // iterate for  of the elements and push then to stack if there 
     for (i = 0; i < n; i++) 
     {
         next = arr[i];

       if (s.isEmpty() == false) 
         {
              
             // if stack is not empty, then 
             // pop an element from stack
             element = s.pop();

             /* If the popped element is smaller than 
                next, then a) print the pair b) keep 
                popping while elements are smaller and 
                stack is not empty */
             while (element < next) 
             {
                 System.out.println(element + " -- " + next);
                 if (s.isEmpty() == true)
                     break;
                 element = s.pop();
             }

             /* If element is greater than next, then 
                push the element back */
             if (element > next)
                 s.push(element);
         }

         /* push next to stack so that we can find next
            greater for it */
         s.push(next);
     }

     /* After iterating over the loop, the remaining 
        elements in stack do not have the next greater 
        element, so print -1 for them */
     while (s.isEmpty() == false) 
     {
         element = s.pop();
         next = -1;
         System.out.println(element + " -- " + next);
     }
 }

 public static void main(String[] args) 
 {
     int arr[] = { 11,10,9,7,13,23,3 };
     int n = arr.length;
     Stack<Integer> stack=new Stack<Integer>();
     printNGE(arr, n,stack);
 }
}

//Thanks to Rishabh Mahrsee for contributing this code
