import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
/**
 * name:Milad Ghavami
 * assignment: final project.
 * date: 04/21/2023
 *
 * Basic tree node interface. I've left this body populated, but I've removed all comments.
 * The only thing you'll have to do is add comments and imports.
 */
// This interface defines a blueprint for tree node classes.
public interface TreeNode <T>{
    /*** Adds a child node with the given data if the identifier test is true for this node, or passes the
     * child and identifier test to each of its children.
     *
     * @param identifier the predicate to determine if the child should be added to this node.
     * @param child the child node to be added.
     * @return the modified parent node.
     */
    TreeNode<T> addChild(Predicate<T> identifier, TreeNode<T> child);
    /**
     * Returns a list containing all data in the node and its children.
     *
     * @return a list containing all data in the node and its children.
     */
    List<T> toList();
    /**
     * Returns a filtered list containing only the data in the node and its children that match the given predicate.
     *
     * @param predicate the predicate to filter the data by.
     * @return a filtered list containing only the data in the node and its children that match the given predicate.
     */
    List<T> toList(Predicate<T> predicate);
    /**
     * Applies the given transform function to the data of the node and all its children to create a new tree
     * with the transformed data.
     *
     * @param transform the function to transform the data with.
     * @param <T> the type of the old data in the transformed tree.
     * @param <R> the type of the new data in the transformed tree.
     * @return a new tree with the transformed data.
     */
    <R> TreeNode<R> map(Function<T,R> transform);
    /**
     * Applies the given combiner function to the data of the node and its children in a post-order traversal
     * to reduce the data to a single value.
     *
     * @param initialValue the initial value to start the reduction with.
     * @param combiner the function to combine the data with.
     * @return the final reduced value.
     */
    T reduce(T initialValue, BiFunction<T,T,T> combiner);
    /**
     * Prints the data of the node and its children in a pre-order traversal.
     */
    void print();
}
