package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 
 * @author hsingh
 * You are given a graph and a node in the graph. 
 * Group the nodes connected to this node if they are also connected to each other.
 *  For example, the graph has nodes 1, 2, 3, 4, 5 where 1 is connected to 2, 3, 4;
 *   2 and 3 are also connected to each other, 4 is just connected to 1 and 5 is a separate node. 
 *   You are given node 1 as input. Output should be:
 *   2 3
 *   4
 *
 */

class Vertex{ 
	boolean isVisited;
	char label;
	ArrayList<Integer> arry=new ArrayList<Integer>();
	
	Vertex(char label){
		 this.label=label;
		 isVisited=false;
	 }
	@Override
	public String toString(){
		return ""+ label;
	}
	public void add(int i){
		arry.add(i);
		
	}
}
class Graph{
	private final int MAX_VALUE=10;
	private int[][]adjMatrix;
	private Vertex[] vertex;
	private int nVerts;
	private StackX stackx;
	
	Graph(){
		stackx=new StackX();
		nVerts=0;
		vertex=new Vertex[MAX_VALUE];
		adjMatrix=new int[MAX_VALUE][MAX_VALUE];
		for(int i=0;i<MAX_VALUE;i++){
			for(int j=0;j<MAX_VALUE;j++){
				adjMatrix[i][j]=0;
			}
		}
	}
	
public void insert(char label){
	vertex[nVerts]=new Vertex(label);
	nVerts++;
}

public void addEdge(int start,int end){
	adjMatrix[start][end]=1;
	vertex[start].add(end);
	
	adjMatrix[end][start]=1;
	vertex[end].add(start);
}

	


  public void printConnectedVertex(int start){
		System.out.println("Starting point " + vertex[start].toString());
	  HashSet<Integer> connected=new HashSet<Integer>();
	  Integer[] neighbours=new Integer[vertex[start].arry.size()];
	ArrayList<Integer> vertices =vertex[start].arry;
	vertices.toArray(neighbours);
	// Integer[] neighbours = Arrays.copyOf(vertices, vertices.size(), Integer[].class);
	// Object[] obj =(Integer[])vertices.toArray(); 
	// Integer[] neighbours =(Integer[])obj; 
	 for(Integer p : neighbours){
		 
		 for(int i=0;i<nVerts;i++){
			 if(i==p||i==start){
				 continue;
			 }
			 if(adjMatrix[p][i]==1){
				 connected.add(i);
				 connected.add(p);
				 
			 }
		 }
		 //vertex[p].arry.contains(o)
	 }
	 System.out.println("Connected");
	 for(Integer i:connected){
		 System.out.println(vertex[i].toString()+" ");
		 vertices.remove(i);
	 }
	 System.out.println("Not Connected");
	 for(Integer i:vertices){
		 System.out.println(vertex[i].toString()+" ");
	 }
}
}

class StackX{
	private int size;
	private final int MAX_SIZE=20;
	int[] arry;
	
	StackX(){
		size=0;
		arry=new int[MAX_SIZE];
	}
	
	public void push(int a){
		arry[size++]=a;
	}
	
	public int pop(){
		if(size==0){
			return  -1;
		}
		return arry[size--];
	}
	
	//public int()
	
}

public class NodesConnectedGroupsTogether {
	public static void main(String[] args){
		Graph graph=new Graph();
		graph.insert('1');
		graph.insert('2');
		graph.insert('3');
		graph.insert('4');
		graph.insert('5');
		
		graph.addEdge(0, 1);// 1 ,2
		graph.addEdge(0, 2);// 1, 3
		graph.addEdge(0, 3);// 1, 4
		graph.addEdge(1, 2);// 2,3
		graph.printConnectedVertex(0);
		//graph.addEdge(1, 3);// 1,4
		// Node 5 is not connected to anything
		
		// write a method to connect as per instructions
		
	}

}


