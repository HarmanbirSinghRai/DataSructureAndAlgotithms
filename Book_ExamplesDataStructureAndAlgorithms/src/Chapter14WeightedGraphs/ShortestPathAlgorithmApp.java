package Chapter14WeightedGraphs;

public class ShortestPathAlgorithmApp {

	public static void main(String[] args) {
		SPAGraph theGraph = new SPAGraph();
		theGraph.addVertex('A'); // 0 (start)
		theGraph.addVertex('B'); // 1
		theGraph.addVertex('C'); // 2
		theGraph.addVertex('D'); // 3
		theGraph.addVertex('E'); // 4
		theGraph.addVertex('F'); // 4
		theGraph.addEdge(0, 1, 50); // AB 50
		theGraph.addEdge(0, 3, 80); // AD 80
		theGraph.addEdge(1, 2, 60); // BC 60
		theGraph.addEdge(1, 3, 90); // BD 90
		theGraph.addEdge(2, 4, 40); // CE 40
		theGraph.addEdge(3, 2, 20); // DC 20
		theGraph.addEdge(3, 4, 70); // DE 70
		theGraph.addEdge(4, 1, 50); // EB 50
		theGraph.addEdge(2, 5, 30); // EB 50
		theGraph.addEdge(3, 5, 70); // EB 50
		System.out.println("Shortest paths");
		theGraph.spa(); // shortest paths
		System.out.println();

	}

}

class DistPar {
	int distance;
	int parentvert;

	public DistPar(int distance, int parentvert) {
		this.distance = distance;
		this.parentvert = parentvert;
	}

}

class VertexSPA {

	char label;
	boolean IsinTree;

	public VertexSPA(char label) {
		this.label = label;
		this.IsinTree = IsinTree;
	}

	public void display() {
		System.out.println(label);
	}
}

class SPAGraph {
	private final int MAX_VERTS = 20;
	private VertexSPA[] vertex;
	private int[][] adjMatrix;
	private int nVerts;
	private int ntree;
	private DistPar[] spath;
	private int currentIndex;
	private int starttocurrent;
	private final int INFINITY = 10000000;

	public SPAGraph() {
		vertex = new VertexSPA[MAX_VERTS];
		adjMatrix = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		ntree = 0;
		spath = new DistPar[MAX_VERTS];
		resetMatrix();
	}

	public void resetMatrix() {
		for (int i = 0; i < MAX_VERTS; i++) {
			for (int j = 0; j < MAX_VERTS; j++) {
				adjMatrix[i][j] = INFINITY;
			}
		}
	}

	public void addVertex(char a) {
		vertex[nVerts++] = new VertexSPA(a);
	}

	public void addEdge(int start, int end, int weight) {
		adjMatrix[start][end] = weight;
	}

	public int getMin() {
		int index = 0;
		;
		int min = INFINITY;
		for (int i = 0; i < nVerts; i++) {
			if (!vertex[i].IsinTree && spath[i].distance < min) {
				min = spath[i].distance;
				index = i;
			}
		}
		return index;
	}

	public void adjustPath() {
		int currenttofringe;
		int startTofringe;
		int column = 1;
		while (column < nVerts) {
			if (vertex[column].IsinTree) {
				column++;
				continue;
			}
			currenttofringe = adjMatrix[currentIndex][column];
			startTofringe = currenttofringe + starttocurrent;
			int countdistance = spath[column].distance;
			if (startTofringe < countdistance) {
				spath[column].distance = startTofringe;
				spath[column].parentvert = currentIndex;
			}
			column++;
		}
	}

	public void spa() {
		int startIndex = 0;
		// spath[currentIndex]=new DistPar(INFINITY,currentIndex);
		vertex[startIndex].IsinTree = true;
		ntree = 1;
		for (int i = 0; i < nVerts; i++) {
			int distance = adjMatrix[startIndex][i];
			spath[i] = new DistPar(distance, startIndex);
		}

		while (ntree < nVerts) {
			int minIndex = getMin();
			int mindistacne = spath[minIndex].distance;
			if (mindistacne == INFINITY) {
				System.out.println("Graph is not connected");
				break;
			} else {
				currentIndex = minIndex;
				starttocurrent = spath[minIndex].distance;

			}
			vertex[currentIndex].IsinTree = true;
			ntree++;
			adjustPath();

		}

		displaypaths();
		System.out.println(" ");
		displaypaths_harman();

		resetVertex();
	}

	public void resetVertex() {
		for (int i = 0; i < nVerts; i++) {
			vertex[i].IsinTree = false;
		}
		nVerts = 0;
	}

	public void displaypaths() {
		for (int i = 0; i < nVerts; i++) {
			int parent = spath[i].parentvert;
			int distance = spath[i].distance;
			char parentlabel = vertex[parent].label;
			char label = vertex[i].label;
			System.out.print(label + "=>");
			if (distance == INFINITY) {
				System.out.print("inf");
			} else {
				System.out.print(distance);
			}
			System.out.print("(" + parentlabel + ")");
			System.out.print(" ");

		}
	}

	public void displaypaths_harman() {
		char indexlabel=vertex[spath[0].parentvert].label;
		//or (int i = 0; i < nVerts; i++) {
		for (int i = 1; i < nVerts; i++) {
			int parent = spath[i].parentvert;
			int distance = spath[i].distance;
			char parentlabel = vertex[parent].label;
			char label = vertex[i].label;
			System.out.print(label + "=>");
			if (distance == INFINITY) {
				System.out.print("inf");
			} else {
				System.out.print(distance);
			}
			System.out.print("(" + parentlabel );
			while (!(parentlabel == indexlabel)) {
				parent = spath[parent].parentvert;
				parentlabel= vertex[parent].label;
				System.out.print( parentlabel);

			}
			System.out.print(") ");

		}

	}

}
