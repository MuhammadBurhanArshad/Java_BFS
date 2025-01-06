/*
 * Vertex class for representing a graph vertex
 *
 * @variables:
    * label: Label of the vertex
    * visited: To track whether the vertex has been visited
 *
 * @methods:
    * Vertex(char label): Constructor to initialize the vertex with a label, and with false visited status

*/
class Vertex {
    char label;
    boolean visited;

    public Vertex(char label) {
        this.label = label;
        this.visited = false;
    }
}