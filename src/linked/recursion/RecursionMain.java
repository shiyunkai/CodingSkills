package linked.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import linked.common.Node;

/**
 * @Auther: shiyunkai
 * @Date: 2019/05/21 20:57
 * @Description:
 */
public class RecursionMain {

    public static void main(String[] args) {
        //Node node1 = createLinkedList(new ArrayList<>());
        //Node.printList(node1);
        //Node node2 = createLinkedList(Arrays.asList(1));
        //Node.printList(node2);
        //Node node3 = createLinkedList(Arrays.asList(1, 2, 3, 4, 5));
        //Node.printList(node3);
        //System.out.println("-----------reverser--------------------");
        //Node newNode1 = reverserLinkedList(node1);
        //Node newNode2 = reverserLinkedList(node2);
        //Node newNode3 = reverserLinkedList(node3);
        //Node.printList(newNode1);
        //Node.printList(newNode2);
        //Node.printList(newNode3);

        combinations(new ArrayList<>(),Arrays.asList(1,2,3,4,5),1);


    }

    /**
     *  创建链表
     * @param list 传入的值
     * @return 链表的头节点, 如果链表为空链表，则返回null
     */
    public static Node createLinkedList(List<Integer> list){
        if(list.isEmpty()){
            return null;
        }
        Node node = new Node(list.get(0));
        Node nextNode = createLinkedList(list.subList(1,list.size()));
        node.setNextNode(nextNode);
        return node;
    }

    /**
     *  链表反转
     * @param head 当前链表头节点
     * @return 反转后的链表头节点
     */
    public static Node reverserLinkedList(Node head){
        if(head==null || head.getNextNode()==null){
            return head;
        }
        Node newHead = reverserLinkedList(head.getNextNode());
        head.getNextNode().setNextNode(head);
        head.setNextNode(null);
        return newHead;
    }

    /**
     *  列出所有组合
     * @param data 从data中选
     * @param n  选几个
     */
    public static void combinations(List<Integer> selected,List<Integer> data, Integer n){

        // 选好了，打印选择出来的组合
        if(n == 0){
            // output all selected elements
            for(Integer i:selected){
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
            return;
        }

        if(data.isEmpty()){
            return;
        }

        if(n < 0){
            return;
        }

        // select 0 from data
        selected.add(data.get(0));
        combinations(selected,data.subList(1,data.size()),n-1);

        // un-select 0 from data
        selected.remove(selected.size()-1);
        combinations(selected,data.subList(1,data.size()),n);
    }
}
