import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
/**
 * name:Milad Ghavami
 * assignment: final project
 * date: 04/21/2023
 *
 * LeafNode is a generic class and child of AbstractTreeNode.
 * This node allows for a single data element.
 * You'll have to include the needed imports, fix the class declaration, and then populate the body with the needed methods.
 */
// This is a leaf node in the tree that doesn't have any children. LeafNodes contain only T-type data.
public class LeafNode<T> extends AbstractTreeNode<T>{
    /**
     * Constructs a new LeafNode object with the given data.
     *
     * @param data the data to be stored in the node.
     */
    public LeafNode(T data){
        super(data);
    }
    /**
     * Adds a child node with the given data if the identifier test is true for this node, or passes the
     * child and identifier test to each of its children.
     *
     * @param identifier the predicate to determine if the child should be added to this node.
     * @param child the child node to be added.
     * @return the modified parent node.
     */
    @Override
    public TreeNode<T> addChild(Predicate<T> identifier, TreeNode<T>
            child) {
        if (identifier.test(data)) {
            //promote this to a group tree node
            GroupNode<T> newNode = new GroupNode<T>(this.data);
            newNode.addChild(identifier,child);
            return newNode;
        }
        return this;
    }
    /**
     * Returns a list containing all data in the node and its children.
     *
     * @return a list containing all data in the node and its children.
     */
    public List<T> toList() {
        List<T> result = new ArrayList<T>();
        result.add(this.data);
        return result;
    }
    /**
     * Returns a filtered list containing only the data in the node and its children that match the given predicate.
     *
     * @param predicate the predicate to filter the data by.
     * @return a filtered list containing only the data in the node and its children that match the given predicate.
     */
    public List<T> toList(Predicate<T> predicate) { // task3
        List<T> result = new ArrayList<T>();
        if (predicate.test(this.data))
            result.add(this.data);
        return result;
    }
    /**
     * Applies the given transform function to the data of the node and all its children to create a new tree
     * with the transformed data.
     *
     * @param transform the function to transform the data with.
     * @param <T> the type of the old data in the transformed tree.
     * @param <R> the type of the new data in the transformed tree.
     * @return a new tree with the transformed data.
     */
    @Override
    public <R> TreeNode<R> map(Function<T,R> transform) {
        return new LeafNode<R>(transform.apply(this.data));
    }
    /**
     * Applies the given combiner function to the data of the node and its children in a post-order traversal
     * to reduce the data to a single value.
     *
     * @param initialValue the initial value to start the reduction with.
     * @param combiner the function to combine the data with.
     * @return the final reduced value.
     */
    @Override
    public T reduce(T initialValue, BiFunction<T, T,T> combiner) {
        return combiner.apply(initialValue,this.data);
    }
    /**
     * Prints the data of the node and its children in a pre-order traversal.
     */
    @Override
    public void print() {
        System.out.println("Leaf Node: " + data.toString());
    }
}
