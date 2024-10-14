/**
 * name:Milad Ghavami
 * assignment: final project
 * date: 04/19/2023
 * Represents a  linked list that holds Movie objects.
 */
// the first class is the link list, the link list is the list I created for this project.
// The nodes of the linked list are represented by this class.
public class LinkList {
    // There is a private class node in the link list class
    /**
     * Represents a node in the linked list that has Movie object and next Node.
     */
    private class Node{ // I could define another public class, but I decided to limit the number of public classes.
        private Movie movie;
        private Node next;
        /**
         * Constructs a new Node with the specified Movie object.
         *
         * @param movie The Movie object to be stored in the node.
         */
        public Node(Movie movie){
            this.movie = movie;
        }
    }
    // Next, I declare two object nodes for the first and last node of the link list, plus addLast, addFirst, indexOF,
    // contain methods,
    private Node first; //first node in the list
    private Node last; // last nos in list
    /**
     * Checks if the linked list is empty.
     *
     * @return true if the list is empty.
     */
    public Boolean isEmpty(){
        return first == null;
    }
    /**
     * Adds a new movie object node at the end of the list.
     *
     * @param item The Movie object to be added to the list.
     */
    public void addLast(Movie item){
        var node = new Node(item);
        if(isEmpty()){
            first =  last = node;
        }else {
            last.next = node;
            last = node;
        }
    }
    /**
     * Adds a new movie object node at the beginning of the list.
     *
     * @param item The Movie object to be added to the list.
     */
    public void addFirst(Movie item){
        var node = new Node(item);
        if(isEmpty()){
            first =  last = node;
        }else {
            node.next = first;
            first = node;
        }
    }
    /**
     * Returns the index of the specified Movie object in the list.
     *
     * @param item The Movie object to search for.
     * @return The index of the Movie object.
     */
    public int indexOf(Movie item){
        int index =0;
        var current = first;
        while (current != null){
            if(current.movie == item){
                return index;
            }
            current = current.next;
            index ++;
        }
        return -1;
    }
    /**
     * Checks if the list contains the specified Movie object.
     *
     * @param item The Movie object to search for.
     * @return true if the list contains the Movie object, false otherwise.
     */
    public boolean contain(Movie item){
        return indexOf(item) != -1;
    }
    /**
     * Returns the size of the linked list using a recursive helper method.
     *
     * @return The size of the linked list.
     */
    // and at the end, I create two special recursive methods (size and print methods).
    public int size() {
        return sizeHelper(first);
    }

    /**
     * A helper method for calculating the size of the linked list recursively.
     *
     * @param current The current node in the list.
     * @return The size of the list from the current node onwards.
     */
    private int sizeHelper(Node current) {// recursive method 1
        // This helper method is to hide the recursive implementation details from the user
        if (current == null) {
            return 0;
        } else {
            return 1 + sizeHelper(current.next);
        }
    }
    /**
     * Prints the linked list using a recursive helper method.
     */
    public void print() {
        printHelper(first);
    }
    // recursive method 2
    // This helper method is to hide the recursive implementation details from the user
    /**
     * A helper method for printing the linked list recursively.
     *
     * @param current The current node in the list.
     */
    private void printHelper(Node current) {// recursive method 2
        // This helper method is to hide the recursive implementation details from the user
        if (current == null) {
            System.out.print("null");
        } else {
            System.out.print(current.movie + " ");
            printHelper(current.next);
        }
    }
}
