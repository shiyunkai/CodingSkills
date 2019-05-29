package tree;

/**
 * @Auther: shiyunkai
 * @Date: 2019/05/27 18:45
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        // 前序、中序、后序遍历test
        //TreeNode tree = createTree();
        //TraversalTree.preOrder(tree);
        //System.out.println();
        //System.out.println("------------------------");
        //TraversalTree.inOrder(tree);
        //System.out.println();
        //System.out.println("------------------------");
        //TraversalTree.postOrder(tree);

        // 根据前序遍历结果和中序遍历结果构建出二叉树测试
        //TreeNode tree = createTree("ABDEGCF", "DBGEACF");
        //String postTraversal = findPostTraversal("ABDEGCF", "DBGEACF");

        //TreeNode tree = createTree("ABDEGCF", "DBGEACF");
        //TraversalTree.inOrder(tree);
        
        // 测试寻找中序遍历下一个节点
        //inOrderTraversal(createTree("A","A"));
        //inOrderTraversal(createTree("",""));
        //inOrderTraversal(createTree("AB","BA"));
        //inOrderTraversal(createTree("ABCD","DCBA"));
        //inOrderTraversal(createTree("ABCD","ABCD"));

        // 二分查找测试
        int[] arr = {1, 2, 10, 15, 100,101,120,130,150,200,201,202,203,205,206,400};
        int result = binarySearch(arr,400);
        System.out.println(result);
    }

    private static void inOrderTraversal(TreeNode tree) {
        for(TreeNode curNode = getFirst(tree); curNode!=null;curNode = findNext(curNode)){
            System.out.print(curNode.getValue());
        }
        System.out.println();
    }

    /**
     * 创建一棵简单二叉树
     *
     * @return
     */
    public static TreeNode createTree() {
        TreeNode root = new TreeNode('A');
        root.setLeftChild(new TreeNode('B'));
        root.getLeftChild().setLeftChild(new TreeNode('D'));
        root.getLeftChild().setRightChild(new TreeNode('E'));
        root.getLeftChild().getRightChild().setLeftChild(new TreeNode('G'));

        root.setRightChild(new TreeNode('C'));
        root.getRightChild().setRightChild(new TreeNode('F'));

        return root;
    }

    /**
     * 根据前序遍历结果和中序遍历结果构建出二叉树
     *
     * @param preOrder
     * @param inOrder
     * @return
     */
    public static TreeNode createTree(String preOrder, String inOrder) {
        if(preOrder.isEmpty()){
            return null;
        }
        //取出根结点
        char root = preOrder.charAt(0);
        //在中序遍历中找到根节点的index，即找到左子树
        int rootIndex = inOrder.indexOf(root);
        // 构造树
        TreeNode rootNode = new TreeNode(root);
        rootNode.setLeftChild(
                createTree(preOrder.substring(1, rootIndex + 1), inOrder.substring(0, rootIndex))
        );

        rootNode.setRightChild(
                createTree(preOrder.substring(rootIndex + 1), inOrder.substring(rootIndex + 1))
        );

        return rootNode;
    }

    /**
     *  根据前序遍历和中序遍历输出后序遍历
     * @param preOrder
     * @param inOrder
     */
    public static String findPostTraversal(String preOrder, String inOrder){
        if(preOrder.isEmpty()){
            return "";
        }
        char rootValue = preOrder.charAt(0);
        int rootIndex = inOrder.indexOf(rootValue);
        return findPostTraversal(preOrder.substring(1,rootIndex+1),inOrder.substring(0,rootIndex))+
                findPostTraversal(preOrder.substring(rootIndex+1),inOrder.substring(rootIndex+1))+rootValue;
    }

    /**
     *  根据前序遍历和后序遍历构建二叉树
     * @param preOrder
     * @param postOrder
     * @return
     */
    public static TreeNode createTree2(String preOrder,String postOrder){
        if(preOrder.isEmpty()){
            return null;
        }
        // 获得树的根节点值
        char rootValue = preOrder.charAt(0);
        // 获得左子树根节点的值
        char selfValue = preOrder.charAt(1);
        // 在后序遍历中获得selfChild根结点的index
        int selfIndex = postOrder.indexOf(selfValue);
        TreeNode rootNode = new TreeNode(rootValue);
        rootNode.setLeftChild(
                createTree2(preOrder.substring(1,selfIndex+2),postOrder.substring(0,selfIndex+1))
        );
        rootNode.setRightChild(
                createTree2(preOrder.substring(selfIndex+2),postOrder.substring(selfIndex+1,postOrder.length()-1))
        );
        return rootNode;
    }

    /**
     *  寻找中序遍历时的下一个节点
     * @param node
     * @return
     */
    public static TreeNode findNext(TreeNode node){

        if(node == null){
            return null;
        }

        // 1 判断该节点是否有右子树
        if(node.getRightChild()!=null){
            // 1.1 有右子树，找到右子树的第一个节点（右子树中序遍历的第一个节点）
            return getFirst(node.getRightChild());
        }else{
            // 1.2 没有右子树，一直往上找，直到该节点是某个节点的左节点，返回找到的父结点
            while(node.getParent()!=null && node != node.getParent().getLeftChild()){
                node = node.getParent();
            }
            return node.getParent();
        }
    }

    // 获取某个子树的中序遍历第一个节点
    private static TreeNode getFirst(TreeNode node) {
        if(node==null){
            return null;
        }
        TreeNode next = node;
        while(next.getLeftChild()!=null){
            next = next.getLeftChild();
        }
        return next;
    }

    /**
     *  二分查找，返回要查找的元素的下标，如果没有找到则返回-1
     * @param arr
     * @param value
     * @return
     */
    public static int binarySearch(int[] arr, int value){

        // 规定要查找的值k可能在的数组arr内下标区间a,b
        int a = 0;
        int b = arr.length;
        while(a<b){
            // 计算区间a,b的中间点m
            int m = a+(b-a)/2;  // (a+b)/2 may be overflow
            if(value<arr[m]){
                // 若value<arr[m],将区间缩小为a,m，继续二分查找
                b = m -1 ;
            }else if(value>arr[m]){
                // 若k>arr[m]，将区间缩小为m,b，继续二分查找
                a = m + 1;
            }else{
                // 若k==arr[m]，则找到元素位于位置m
                return m;
            }
        }
        return -1;
    }



}
