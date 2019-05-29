package linked.common;

/**
 * @Auther: shiyunkai
 * @Date: 2019/05/21 20:36
 * @Description: 节点类
 */
public class Node {

    private final int value;
    private Node nextNode;

    public Node(int value) {
        this.value = value;
        this.nextNode = null;
    }

    public int getValue() {
        return value;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.getValue() + " ");
            node = node.nextNode;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", nextNode=" + nextNode +
                '}';
    }
}
