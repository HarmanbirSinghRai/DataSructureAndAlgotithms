package Chapter13Graphs;

public class TopoGraphicalSearchApp {
	
	public static void main(String[] args){
		TopoGraphicalSearch theGraph=new TopoGraphicalSearch();
		theGraph.addVertex('A'); // 0
		theGraph.addVertex('B'); // 1
		theGraph.addVertex('C'); // 2
		theGraph.addVertex('D'); // 3
		theGraph.addVertex('E'); // 4
		theGraph.addVertex('F'); // 5
		theGraph.addVertex('G'); // 6
		theGraph.addVertex('H'); // 7
		
		theGraph.addEdge(0, 3); // AD
		theGraph.addEdge(0, 4); // AE
		theGraph.addEdge(1, 4); // BE
		theGraph.addEdge(2, 5); // CF
		theGraph.addEdge(3, 6); // DG
		theGraph.addEdge(4, 6); // EG
		theGraph.addEdge(5, 7); // FH
		theGraph.addEdge(6, 7); // GH
		theGraph.topo(); // do the sort
		
	}

}


class VertexTop{
	
	private char label;
	
	VertexTop(char a){
		label=a;
	}
	
	public void display(){
		System.out.print(label);
	}
}

class TopoGraphicalSearch{
	private final int MAX_VERTS=20;
	private VertexTop[] vertex;
	private int[][] adjMatrix;
	private int nVerts;
	private VertexTop[] sortedlist ;
	
	public TopoGraphicalSearch(){
		vertex=new VertexTop[MAX_VERTS];
		nVerts=0;
		adjMatrix=new int[MAX_VERTS][MAX_VERTS];
		sortedlist=new VertexTop[MAX_VERTS];
		resetMatrix();
		
	}
	
	public void resetMatrix(){
		for (int i=0;i<MAX_VERTS;i++){
			for (int j=0;j<MAX_VERTS;j++){
				adjMatrix[i][j]=0;
			}
		}
	}
	
	public void addVertex(char a){
		vertex[nVerts++]=new VertexTop(a);
	}
	
	public void addEdge(int start , int end){
		adjMatrix[start][end]=1;
	}
	
	public int getNoSuccesor(){
		
		boolean isEdge;
		
		for (int row=0;row<nVerts;row++){
			isEdge=false;
			for (int col=0;col<nVerts;col++){
				if(adjMatrix[row][col]==1){
					isEdge=true;
					break;
				}
			}
			
			if(!isEdge){
				return row;
			}
		}
		
		return -1;
	}
	
	public void moveRowUp(int row,int length){
		
			for(int col=0;col<length;col++){
				adjMatrix[row][col]=adjMatrix[row+1][col];
			}
		
	}
	
	public void moveColLeft(int col,int length){
		for(int row=0;row<length;row++){
				adjMatrix[row][col]=adjMatrix[row][col+1];
			}
	}
	
	public void deleteVertex(int delvert){
		if(delvert!=nVerts-1){
			
			for(int vert=delvert;vert<nVerts-1;vert++){
				vertex[vert]=vertex[vert+1];
			}
			
			for(int row=delvert;row<nVerts-1;row++){
			moveRowUp(row,nVerts);
			}
			
			for(int col=delvert;col<nVerts-1;col++){
			moveColLeft(col,nVerts-1);
			}
		}
		
		nVerts--;
		
	}
	
	
	public void topo(){
		 int orig_verts=nVerts;
		 
		while(nVerts>0){
			int delVert=getNoSuccesor();
			if(delVert==-1){
				System.out.println("ERROR: Graph has cycles");
				return;
			}
			
			sortedlist[nVerts-1]=vertex[delVert];
			
			deleteVertex(delVert);
		}
		
		System.out.println("Topographically sorted order:");
		for(int i=0;i<orig_verts;i++){
			sortedlist[i].display();
		}
		System.out.println("");
		
	}
	
}