package Chapter13Graphs;

public class BreadthFirstSearchAlgorithm {
	
	public static void main(String[] args)
	{
		BreadthFirstSearch theGraph = new BreadthFirstSearch();
		theGraph.addVertex('A');//0
		theGraph.addVertex('B');//1
		theGraph.addVertex('C');//2
		theGraph.addVertex('D');//3
		theGraph.addVertex('E');//4
		theGraph.addVertex('F');//5
		theGraph.addVertex('G');//6
		theGraph.addVertex('H');//7
		theGraph.addVertex('I');//8

		theGraph.addEdge(0, 1); // AB
		theGraph.addEdge(1, 5); // BF
		theGraph.addEdge(5, 7); // FH
		theGraph.addEdge(0, 2); // AC
		theGraph.addEdge(0, 3); // AD
		theGraph.addEdge(3, 6); // DG
		theGraph.addEdge(6, 8); // GI
		theGraph.addEdge(0, 4); // AE
	System.out.print("Visits: ");
	theGraph.bfs(); // breadth-first search
	System.out.println();
	} // end main()

}

class Queue{
	private final int MAX_SIZE=20;
	private int[] queue;
	private int front;
	private int rear;
	
	
	Queue(){
		queue=new int[MAX_SIZE];
		front=0;
		rear=-1;
	}
	
	
	public void insert(int a){
		if(rear==MAX_SIZE-1 ){
			rear=-1;
		}
		queue[++rear]=a;
	}
	
	public int remove(){
		if(front==MAX_SIZE)
			front=0;
		int top=queue[front++];
		return top;
	}
	
	public boolean isEmpty(){
		return ((rear+1==front)||(front+MAX_SIZE-1==rear));
	}
	
	public boolean isFull(){
		return ((rear+2==front)||(front+MAX_SIZE-2==rear));
	}
}

class BreadthFirstSearch{
	private  final int MAX_VERTS=20;
	private Vertex[] vertex;
	private int nVerts;
	private int[][] adjMatrix;
	Queue queue;
	public BreadthFirstSearch(){
		vertex=new Vertex[MAX_VERTS];
		adjMatrix=new int[MAX_VERTS][MAX_VERTS];
		queue=new Queue();
		nVerts=0;
		resetMatrix();
		
	}
	
	public void resetMatrix(){
		for (int i=0;i<MAX_VERTS;i++){
			for (int j=0;j<MAX_VERTS;j++){
				adjMatrix[i][j]=0;
			}
		}
	}
	
	public void resetVertexs(){
		for (int i=0;i<nVerts;i++){
			vertex[i].isVisited=false;
		}
	}
	
	public void addVertex(char a){
		
		vertex[nVerts++]=new Vertex(a);
	}
	
	public void displayVertex(int v){
		vertex[v].display();
	}
	
	public void addEdge(int start,int End){
		
		adjMatrix[start][End]=1;
		adjMatrix[End][start]=1;
	}
	
	public int getAdjVertexVisited(int v){
		
		for(int i=0;i<MAX_VERTS;i++){
			if(adjMatrix[v][i]==1 && vertex[i].isVisited==false){
				return i;
			}
		}
		return -1;
	}
	
	public void bfs(){
		vertex[0].isVisited=true;
		displayVertex(0);
		queue.insert(0);
		
		while(!queue.isEmpty()){
			
			int v1;
			int v=queue.remove();
			
			while( (v1=getAdjVertexVisited(v))!=-1){
				
				vertex[v1].isVisited=true;
				displayVertex(v1);
				queue.insert(v1);
				
				
			}
			
		}
		resetVertexs();
		
	}
}
