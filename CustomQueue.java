/*
 * Custom Queue implementation for BFS
 *
 * @variables:
    * front: Index of the front element
    * rear: Index of the rear element
    * size: Number of elements in the queue
    * capacity: Maximum capacity of the queue
    * queue: Array to store the elements of the queue
 *
 * @methods:
    * CustomQueue(int capacity): Constructor to initialize the queue with a given capacity
    * enqueue(Vertex vertex): Add a vertex to the queue
    * dequeue(): Remove and return the front vertex from the queue
    * isEmpty(): Check if the queue is empty
*/

class CustomQueue {
    private int front;
    private int rear;
    private int size;
    private int capacity;
    private Vertex[] queue;

    public CustomQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new Vertex[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(Vertex vertex) {
        if (size == capacity) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = vertex;
        size++;
    }

    public Vertex dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        Vertex vertex = queue[front];
        front = (front + 1) % capacity;
        size--;
        return vertex;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
