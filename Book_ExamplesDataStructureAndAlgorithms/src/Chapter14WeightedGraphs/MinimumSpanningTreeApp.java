package Chapter14WeightedGraphs;

public class MinimumSpanningTreeApp {

	public static void main(String[] args){
		MSTGraph theGraph=new MSTGraph();
		
		theGraph.addVertex('A'); // 0 (start for mst)
		theGraph.addVertex('B'); // 1
		theGraph.addVertex('C'); // 2
		theGraph.addVertex('D'); // 3
		theGraph.addVertex('E'); // 4
		theGraph.addVertex('F'); // 5
		theGraph.addEdge(0, 1, 6); // AB 6
		theGraph.addEdge(0, 3, 4); // AD 4
		theGraph.addEdge(1, 2, 10); // BC 10
		theGraph.addEdge(1, 3, 7); // BD 7
		theGraph.addEdge(1, 4, 7); // BE 7
		theGraph.addEdge(2, 3, 8); // CD 8
		theGraph.addEdge(2, 4, 5); // CE 5
		theGraph.addEdge(2, 5, 6); // CF 6
		theGraph.addEdge(3, 4, 12); // DE 12
		theGraph.addEdge(4, 5, 7); // EF 7
		System.out.print("Minimum spanning tree: ");
		theGraph.mst(); // minimum spanning tree
		//theGraph.mst_harman(); // minimum spanning tree
		System.out.println();
		
	}
	
}


class Edge{
	
 int sourceVert;
 int destVert;
 int distance;
 
 public Edge(int sourceVert,int destVert,int distance){
	 this.sourceVert=sourceVert;
	 this.destVert=destVert;
	 this.distance=distance;
	 
 }
}

class VertexMST{
	char label;
	boolean isInTree;
	
	public VertexMST( char lbl){
		label=lbl;
		isInTree=false;
	}
	
	public void display(){
		System.out.print(label);
	}
	
}

class PriorityQ{
	private final int  MAX_SIZE=20;
	private Edge[] edges;
	private int size;
	
	public PriorityQ(){
		edges=new Edge[MAX_SIZE];
		size=0;
	}
	
	public void insert(Edge edge){
		
		int index;
		
		for ( index=0;index<size;index++)
		{
			if(edge.distance>=edges[index].distance){
				break;
			}
		}
		
		for(int k=size-1;k>=index;k--){
			edges[k+1]=edges[k];
		}
		
		edges[index]=edge;
		size++;
		
	}
	
	public Edge removemin(){
		return edges[--size];
	}
	
	public Edge peekmin(){
		return edges[size-1];
	}
	
	public Edge peekN(int N){
		return edges[N];
	}
	
	public int size(){
		return size;
	}
	
	public Edge removeN(int N){
		
		Edge edgeN=edges[N];
		for(int i=N;i<size-1;i++){
			edges[i]=edges[i+1];
		}
		size--;
		return edgeN;
	}
	
	public int find(int N){
		
		for(int i=0;i<size;i++){
			if(N==edges[i].destVert){
				return i;
			}
		}
		
		return -1;
	}
}


class MSTGraph{
	private final int MAX_VERTS=20;
    private VertexMST[] vertex;
    private int[][] adjMatrix;
    private int nVerts;
    private int nTree;
    private int currentVertex;
    PriorityQ pq;
    private final int INFINITY=1000000;
    
    
    
    public MSTGraph(){
    	vertex=new VertexMST[MAX_VERTS];
    	nVerts=0;
    	nTree=0;
    	pq=new PriorityQ();
    	adjMatrix=new int[MAX_VERTS][MAX_VERTS];
    	resetMatrxi();
    }
    
    public void resetMatrxi(){
    	for(int i=0;i<MAX_VERTS;i++){
    		for(int j=0;j<MAX_VERTS;j++){
    			adjMatrix[i][j]=INFINITY;
    		}
    	}
    }
    
    public void resetVertexes(){
    	for(int i=0;i<nVerts;i++){
    		vertex[i].isInTree=false;
    	}
    }
	
    public void addVertex(char a){
    	vertex[nVerts++]=new  VertexMST(a);
    }
    
    
    public void addEdge(int srcVert,int destVert,int weight){
    	adjMatrix[srcVert][destVert]=weight;
     	adjMatrix[destVert][srcVert]=weight;
    }
    
    public void insertPQ(int newVert,int distance){
    	int index;
    	Edge newEdge=new Edge(currentVertex,newVert,distance);
    	index=pq.find(newVert);
    	if(index!=-1){
    		
    		Edge Old=pq.peekN(index);
    		if(distance<Old.distance){
    			pq.removeN(index);
    			pq.insert(newEdge);
    		}
    	}else{
    		pq.insert(newEdge);
    	}
    }
    
    
    public void mst(){
    	currentVertex=0;
    	
    	while(nTree<nVerts-1){
    		vertex[currentVertex].isInTree=true;
    		nTree++;
    		
    		for(int i=0;i<nVerts;i++){
    			if(i==currentVertex){
    				continue;
    			}
    			if(vertex[i].isInTree==true){
    				continue;
    			}
    			int distance=adjMatrix[currentVertex][i];
    			
    			if(distance==INFINITY){
    				continue;
    			}
    			
    			insertPQ(i,distance);
    		}
    			if(pq.size()==0){
    				System.out.println("Graph is not connected");
    				return;
    			}
    	
    			Edge min=pq.removemin();
    			
    			VertexMST source=vertex[min.sourceVert];
    			VertexMST dest=vertex[min.destVert];
    			currentVertex=min.destVert;
    			
    			source.display();
    			dest.display();
    			System.out.print(" ");
    		
    		
    		
    		
    	}
    	
    	resetVertexes();
    	
    }
    
    
  /**  public void mst_harman(){
    	currentVertex=0;
    	vertex[currentVertex].isInTree=true;
		//nTree++;
    	while(nTree<nVerts-1){
    		nTree++;
    		
    		for(int i=0;i<nVerts;i++){
    			if(i==currentVertex){
    				continue;
    			}
    			if(vertex[i].isInTree==true){
    				continue;
    			}
    			int distance=adjMatrix[currentVertex][i];
    			
    			if(distance==INFINITY){
    				continue;
    			}
    			
    			insertPQ(i,distance);
    		}
    			if(pq.size()==0){
    				System.out.println("Graph is not connected");
    				return;
    			}
    	
    			Edge min=pq.removemin();
    			
    			VertexMST source=vertex[min.sourceVert];
    			VertexMST dest=vertex[min.destVert];
    			currentVertex=min.destVert;
    			
    			source.display();
    			dest.display();
    			System.out.print(" ");
    			vertex[currentVertex].isInTree=true;
        		
    		
    		
    		
    	}
    	
    	resetVertexes();
    	
    }**/
}
