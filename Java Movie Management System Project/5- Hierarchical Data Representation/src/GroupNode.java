import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
/**
 * name:Milad Ghavami
 * assignment: Lab 05
 * date: 04/21/2023
 *
 * GroupNode is a generic class and child of AbstractTreeNode. This node basically take the place of a supervisor.
 * It allows for a single data element along with an array list of other elements.
 * You'll have to include the needed imports, fix the class declaration, and then populate the body with the needed methods.
 * this class a children as attribute.
 */
// Represents a node that can have children within a tree.
// GroupNodes contain data of type T and a list of children, either GroupNodes or LeafNodes.
public class GroupNode<T> extends AbstractTreeNode<T>{
    protected List<TreeNode<T>> children;
    /**
     * Constructs a new GroupNode object with the given data and an empty list of children.
     *
     * @param data the data to be stored in the node.
     */
    public GroupNode(T data){
        super(data);
        this.children = new ArrayList<TreeNode<T>>();
    }
    /**
     * Constructs a new GroupNode object with the given data and children.
     *
     * @param data the data to be stored in the node.
     * @param children the children to be added to the node.
     */
    public GroupNode(T data, List<TreeNode<T>> children){
        super(data);
        this.children = children;
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
    public TreeNode<T> addChild(Predicate<T> identifier, TreeNode<T> child) {
        if (identifier.test(this.data)) {
            this.children.add(child); //add it here and return
            return this;
        }
        for (int i=0;i<this.children.size();i++) {
            //add to child and mutate the child
            this.children.set(
                    i,
                    this.children.get(i).addChild(identifier,child));
        }
        return this;
    }
    /**
     * Returns a list containing all data in the node and its children.
     *
     * @return a list containing all data in the node and its children.
     */
    @Override
    public List<T> toList() {
        List<T> result = new ArrayList<T>();
        result.add(this.data);
        for (TreeNode<T> child: children) {
            result.addAll(child.toList());
        }
        return result;
    }
    /**
     * Returns a filtered list containing only the data in the node and its children that match the given predicate.
     *
     * @param predicate the predicate to filter the data by.
     * @return a filtered list containing only the data in the node and its children that match the given predicate.
     */
    public List<T> toList(Predicate<T> predicate) {
        List<T> result = new ArrayList<T>();
        if (predicate.test(data))
            result.add(data);
        for (TreeNode<T> child: children) {
            result.addAll(child.toList(predicate)); //recursively check.
        }
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
        GroupNode<R> newNode = new GroupNode<R>(transform.apply(this.data));
        for (TreeNode<T> child:children) {
            newNode.children.add(child.map(transform));
        }
        return newNode;
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
    public T reduce(T initialValue, BiFunction<T,T,T> combiner) {
        T result = this.data;
        for (TreeNode<T> child:children) {
            result = child.reduce(result,combiner);
        }
        //at this point result is the combination of this.data and reductions of its children
        return combiner.apply(initialValue,result); //combine result and initialValue and return
    }
    /**
     * Prints the data of the node and its children in a pre-order traversal.
     */
    @Override
    public void print(){
        {
            System.out.println("GroupNode " + data);

            for (TreeNode<T> e : children)
            {
                e.print();
            }
        }
    }

}
