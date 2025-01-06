/*
 * Main class for testing BFS
 * 
 * @methods
    * main(String[] args): Main method to test BFS
*/

public class BFS {
    public static void main(String[] args) {
        char[] vertices = { 'A', 'B', 'C', 'D', 'E' };

        GraphBFS graph = new GraphBFS(vertices);
        graph.addEdge('A', 'B');
        graph.addEdge('A', 'C');
        graph.addEdge('B', 'C');
        graph.addEdge('B', 'D');
        graph.addEdge('C', 'E');

        graph.bfs('A');
    }
}
