package Chapter13Graphs;

public class DepthFirstSerachAlgorithm {

	public static void main(String[] args) {
		DFSGraph dfs=new DFSGraph();
		/**dfs.addVertex('A');//0
		dfs.addVertex('B');//1
		dfs.addVertex('C');//2
		dfs.addVertex('D');//3
		dfs.addVertex('E');//4
		dfs.addVertex('F');//5
		dfs.addVertex('G');//6
		dfs.addVertex('H');//7
		dfs.addVertex('I');//8

		dfs.addEdge(0, 1); // AB
		dfs.addEdge(1, 5); // BF
		dfs.addEdge(5, 7); // FH
		dfs.addEdge(0, 2); // AC
		dfs.addEdge(0, 3); // AD
		dfs.addEdge(3, 6); // DG
		dfs.addEdge(6, 8); // GI
		dfs.addEdge(0, 4); // AE
		
		//ABFHCDGIE
		
		
		System.out.print("Visits: ");
		dfs.DFS(); // depth-first search
		System.out.println();
		
		dfs.resetVertexArray();**/
		
		dfs.addVertex('A'); // 0 (start for mst)
		dfs.addVertex('B'); // 1
		dfs.addVertex('C'); // 2
		dfs.addVertex('D'); // 3
		dfs.addVertex('E'); // 4
		dfs.addEdge(0, 1); // AB
		dfs.addEdge(0, 2); // AC
		dfs.addEdge(0, 3); // AD
		dfs.addEdge(0, 4); // AE
		dfs.addEdge(1, 2); // BC
		dfs.addEdge(1, 3); // BD
		dfs.addEdge(1, 4); // BE
		dfs.addEdge(2, 3); // CD
		dfs.addEdge(2, 4); // CE
		dfs.addEdge(3, 4); // DE
		
		System.out.print("Visits: ");
		dfs.MST(); // depth-first search
		System.out.println();
	}

}

 class StackX{
	 
	private int[] stack;
	private final int MAX_LIMIT=20;
	private int top;
	
	
	public StackX(){
		stack=new int[MAX_LIMIT];
		top=-1;
	}
	
	public void push(int vxt){
		stack[++top]=vxt;
	}
	
	public int pop(){
		return stack[top--];
		
	}
	
	public boolean isEmpty(){
		return top==-1;
	}
	
	public int peep(){
		return stack[top];
	}
}
 
class Vertex{
	boolean isVisited;
	private char label;
	
	public Vertex(char lbl){
		isVisited=false;
		label=lbl;
	}
	
	public void display(){
		System.out.print(label);
	}
	
}


class DFSGraph{
	private final int MAX_VERTS=20;
	private StackX stack;
	private Vertex[] vertex;
	private int[][] adjMatrix;
	private int nVerts;
	
   public DFSGraph(){
	   vertex=new Vertex[MAX_VERTS];
	   adjMatrix=new int[MAX_VERTS][MAX_VERTS];
	   stack=new StackX();
	   nVerts=0;
	   resetEdges();
   }
   
   public void addVertex(char a){
	   vertex[nVerts++] =new Vertex(a);
   }
   
   public void addEdge(int start,int End){
	   adjMatrix[start][End]=1;
	   adjMatrix[End][start]=1;
   }
   
   public void resetEdges(){
	   for(int i=0;i<MAX_VERTS;i++){
		   for(int j=0;j<MAX_VERTS;j++){
			   adjMatrix[i][j]=0;
		   }
	   }
   }
   
   public void resetVertexes(){
	   for(int i=0;i<nVerts;i++){
		   vertex[i].isVisited=false;  
	   }
   }
   
   public void resetVertexArray(){
	   for(int i=0;i<nVerts;i++){
		   vertex[i]=null;  
	   }
	   nVerts=0;
   }
   
   public void displayVertex(int v){
	   vertex[v].display();
   }
   
   public int getAdjVertexVisited(int v){
	   
	   for(int i=0;i<MAX_VERTS;i++){
		   if (adjMatrix[v][i]==1&&vertex[i].isVisited==false)
			   return i;
	   }
   return -1;
   }// end getAdjVertexVisited
   
   public void DFS(){
	   vertex[0].isVisited=true;
	   displayVertex(0);
	   stack.push(0);
	   
	   while(!stack.isEmpty()){
		   
		   int v=getAdjVertexVisited(stack.peep());
		   if(v==-1){
			   stack.pop();
			   //System.out.println();
		   }
		   else{
			   vertex[v].isVisited=true;
			   displayVertex(v);
			   stack.push(v);
			   
			  
		   }
	   }
	   
	   resetVertexes();
	   
   }/// end DFS
   
   public void MST(){
	   vertex[0].isVisited=true;
	  // displayVertex(0);
	   stack.push(0);
	   
	   while(!stack.isEmpty()){
		   int current=stack.peep();
		   int v=getAdjVertexVisited(current);
		   if(v==-1){
			   stack.pop();
			   //System.out.println();
		   }
		   else{
			   
			   vertex[v].isVisited=true;
			 
			   stack.push(v);
			   
			   displayVertex(current);
			   displayVertex(v);
			 System.out.print(" ");
		   }
	   }
	   
	   resetVertexes();
	   
   }/// end DFS
   
}