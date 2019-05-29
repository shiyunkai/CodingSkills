package tree;

/**
 * @Auther: shiyunkai
 * @Date: 2019/05/27 19:04
 * @Description:
 */
public class TraversalTree {

    /**
     *  前序遍历：根左右
     * @param root
     */
    public static void preOrder(TreeNode root){
        if(null == root){
            return ;
        }
        System.out.print(root.getValue());
        preOrder(root.getLeftChild());
        preOrder(root.getRightChild());
    }

    /**
     *  中序遍历：左根右
     * @param root
     */
    public static void inOrder(TreeNode root){
        if(null == root){
            return ;
        }
        inOrder(root.getLeftChild());
        System.out.print(root.getValue());
        inOrder(root.getRightChild());

    }

    /**
     *  后序遍历：左右根
     * @param root
     */
    public static void postOrder(TreeNode root){
        if(null == root){
            return;
        }
        postOrder(root.getLeftChild());
        postOrder(root.getRightChild());
        System.out.print(root.getValue());
    }
}
