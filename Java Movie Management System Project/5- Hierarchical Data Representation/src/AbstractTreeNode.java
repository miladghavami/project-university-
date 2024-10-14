/**
 * name:Milad Ghavami
 * assignment: final project
 * date: 04/21/2023
 *
 * AbstractTreeNode takes it's orders from TreeNode and sets up the basic, very simple, structure of a tree node.
 * You'll have to fix the class declaration and complete this file.
 * this class is abstracted class and has a protected T type of data.
 */
// AbstractTreeNode is an abstract class that implements tree nodes.
// AbstractTreeNode provides a foundation for implementing concrete tree node classes,
// like GroupNode and LeafNode.  These classes inherit the data field and constructor from AbstractTreeNode,
// while implementing the specific behavior required by their respective types.
abstract class AbstractTreeNode<T> implements TreeNode<T>{
    protected T data;
    /**
     * @param data <T> the type of data stored in the tree node.
     */
    public AbstractTreeNode(T data){
        this.data = data;
    }
}
