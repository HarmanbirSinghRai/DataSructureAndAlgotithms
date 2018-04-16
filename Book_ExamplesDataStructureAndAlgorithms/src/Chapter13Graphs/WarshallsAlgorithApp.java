package Chapter13Graphs;

/**
 **  Java Program to Implement Warshall Algorithm
 **/
 
import java.util.Scanner;
 
/** Class Warshall **/
public class WarshallsAlgorithApp
{
   // private int V;    
  //  private boolean[][] tc;
    /** Function to make the transitive closure **/
   /** public void getTC(int[][] graph)
    {
        this.V = graph.length;
        tc = new boolean[V][V];
        for (int i = 0; i < V; i++) 
        {    
            for (int j = 0; j < V; j++) 
                if (graph[i][j] != 0)
                    tc[i][j] = true;
            //tc[i][i] = true;
        }
        for (int i = 0; i < V; i++) 
        {
            for (int j = 0; j < V; j++) 
            {
                if (tc[i][j]) 
                    for (int k = 0; k < V; k++) 
                        //if (tc[j][i] && tc[i][k])
                        	if (tc[j][k]) 
                            tc[i][k] = true;             
            }
        }
    }**/
    
    public void getTC2(int[][] graph)
    {
         int V = graph.length;
        for (int i = 0; i < V; i++) 
        {
            for (int j = 0; j < V; j++) 
            {
                if (graph[i][j]==1) 
                    for (int k = 0; k < V; k++) 
                        //if (tc[j][i] && tc[i][k])
                        	if (graph[j][k]==1) 
                        		graph[i][k] = 1;             
            }
        }
    }
    /** Funtion to display the trasitive closure **/
  /**  public void displayTC()
    {
        System.out.println("\nTransitive closure :\n");
        System.out.print(" ");
        for (int v = 0; v < V; v++)
           System.out.print(" " + v );
        System.out.println();
        for (int v = 0; v < V; v++) 
        {
            System.out.print(v +" ");
            for (int w = 0; w < V; w++) 
            {
                if (tc[v][w]) 
                    System.out.print("1 ");
                else                  
                    System.out.print("0 ");
            }
            System.out.println();
        }
    } **/
    
    public void displayTC2(int[][] graph)
    {
    	int V = graph.length;
        System.out.println("\nTransitive closure :\n");
        System.out.print(" ");
        for (int v = 0; v < V; v++)
           System.out.print(" " + v );
        System.out.println();
        for (int v = 0; v < V; v++) 
        {
            System.out.print(v +" ");
            for (int w = 0; w < V; w++) 
            {
               
                    System.out.print(graph[v][w]+" ");
              
            }
            System.out.println();
        }
    } 
 
    /** Main function **/
    public static void main (String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Warshall Algorithm Test\n");
        /** Make an object of Warshall class **/
        WarshallsAlgorithApp w = new WarshallsAlgorithApp();
 
        /** Accept number of vertices **/
        System.out.println("Enter number of vertices\n");
        int V = scan.nextInt();
 
        /** get graph **/
        System.out.println("\nEnter matrix\n");
        int[][] graph = new int[V][V];
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                graph[i][j] = scan.nextInt();
 
       // w.getTC(graph);
       // w.displayTC();
        
        w.getTC2(graph);
        w.displayTC2(graph);
    }
}
