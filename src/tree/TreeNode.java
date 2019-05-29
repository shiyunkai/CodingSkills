package tree;

/**
 * @Auther: shiyunkai
 * @Date: 2019/05/27 18:46
 * @Description: 树结点
 */
public class TreeNode {

    private final char value;
    private TreeNode leftChild;
    private TreeNode rightChild;
    private TreeNode parent;

    public TreeNode(char value){
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
        this.parent = null;
    }

    public char getValue() {
        return value;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
        if(leftChild!=null){
            this.leftChild.parent = this;
        }
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
        if(rightChild!=null){
            this.rightChild.parent = this;
        }
    }

    public TreeNode getParent(){
        return this.parent;
    }

}
