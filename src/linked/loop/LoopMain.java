package linked.loop;

import linked.common.Node;

/**
 * @Auther: shiyunkai
 * @Date: 2019/05/27 14:47
 * @Description:
 */
public class LoopMain {

    public static void main(String[] args) {
        //Node.printList(reverseLikdedList(RecursionMain.createLinkedList(Arrays.asList(1,2,3,4,5))));
        //Node.printList(reverseLikdedList(RecursionMain.createLinkedList(Arrays.asList())));
        //Node.printList(reverseLikdedList(RecursionMain.createLinkedList(Arrays.asList(1))));

        //Node.printList(deleteIfEquals(RecursionMain.createLinkedList(Arrays.asList(1,2,3,4,5)),2));
        //Node.printList(deleteIfEquals(RecursionMain.createLinkedList(Arrays.asList(1,2,3,2,5)),2));
        //Node.printList(deleteIfEquals(RecursionMain.createLinkedList(Arrays.asList(1,2,2,4,5)),2));
        //Node.printList(deleteIfEquals(RecursionMain.createLinkedList(Arrays.asList(2,2,2,2,2)),2));
    }

    /**
     *  反转链表
     * @param head 链表头节点
     * @return 反转后的链表头节点
     */
    public static Node reverseLikdedList(Node head){
        // 指向成功反转后的链表
        Node newHead = null;
        // 指向还没有反转的链表
        Node currentHead = head;

        while(currentHead!=null){
            Node next = currentHead.getNextNode();
            currentHead.setNextNode(newHead);
            newHead = currentHead;
            currentHead = next;
        }
        return newHead;
    }

    /**
     *  删除链表中指定的节点
     * @param head 链表头节点
     * @param value
     */
    public static Node deleteIfEquals(Node head, Integer value){

        while(head!=null && head.getValue() == value){
            head = head.getNextNode();
        }

        if(head == null){
            return head;
        }

        Node prev = head;

        while(prev.getNextNode()!=null){
            if(prev.getNextNode().getValue() == value){
                prev.setNextNode(prev.getNextNode().getNextNode());
            }else{
                prev = prev.getNextNode();
            }
        }
        return head;
    }

    /**
     *  在arr中查找k,返回下标
     * @param arr
     * @param k
     * @return
     */
    public static int BinarySearch(int[] arr, int k){
        return 0;
    }
}
