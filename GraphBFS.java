/*
 * Graph class for BFS using adjacency matrix
 *
 * @vaiables:
    *     vertices: Array of vertices
    *     adjacencyMatrix: Adjacency matrix representation
    *     vertexCount: Number of vertices
 *
 * @methods:
    *     GraphBFS(char[] vertexLabels): Constructor to initialize the graph with given vertices
    *     addEdge(u, v): Add an edge (u, v) to the graph
    *     bfs(startVertex): Perform BFS starting from the given start vertex
    *     getIndex(vertex): Get the index of a vertex in the vertices array

*/
class GraphBFS {
    private Vertex[] vertices;
    private int[][] adjacencyMatrix;
    private int vertexCount;

    public GraphBFS(char[] vertexLabels) {
        vertexCount = vertexLabels.length;
        vertices = new Vertex[vertexCount];
        adjacencyMatrix = new int[vertexCount][vertexCount];

        for (int i = 0; i < vertexCount; i++) {
            vertices[i] = new Vertex(vertexLabels[i]);
            for (int j = 0; j < vertexCount; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }
    }

    public void addEdge(char u, char v) {
        int uIndex = getIndex(u);
        int vIndex = getIndex(v);
        if (uIndex != -1 && vIndex != -1) {
            adjacencyMatrix[uIndex][vIndex] = 1;
            adjacencyMatrix[vIndex][uIndex] = 1;
        }
    }

    private int getIndex(char vertex) {
        for (int i = 0; i < vertexCount; i++) {
            if (vertices[i].label == vertex) {
                return i;
            }
        }
        return -1;
    }

    public void bfs(char startVertex) {
        int startIndex = getIndex(startVertex);
        if (startIndex == -1) {
            System.out.println("Start vertex not found");
            return;
        }

        CustomQueue queue = new CustomQueue(vertexCount);

        vertices[startIndex].visited = true;
        queue.enqueue(vertices[startIndex]);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.dequeue();
            System.out.print(currentVertex.label + " ");

            int currentIndex = getIndex(currentVertex.label);
            for (int i = 0; i < vertexCount; i++) {
                if (adjacencyMatrix[currentIndex][i] == 1 && !vertices[i].visited) {
                    vertices[i].visited = true;
                    queue.enqueue(vertices[i]);
                }
            }
        }

        System.out.println();
    }
}
