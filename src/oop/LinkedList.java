package oop;

import linked.common.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Auther: shiyunkai
 * @Date: 2019/05/30 09:17
 * @Description: 包装链表，实现iterable接口
 */
public class LinkedList implements Iterable<Integer>{

    private Node head;
    private Node tail;

    public LinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void add(int value){
        Node node = new Node(value);
        if(tail == null){
            // node是链表的第一个结点
            head = node;
        }else{
            tail.setNextNode(node);
        }
        tail = node;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new ListIterator(head);
    }


    class ListIterator implements Iterator<Integer>{
        private Node currentNode;

        public ListIterator(Node node){
            this.currentNode = node;
        }
        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Integer next() {
            if(currentNode==null){
                throw new NoSuchElementException();
            }
            int value = currentNode.getValue();
            currentNode = currentNode.getNextNode();
            return value;
        }
    }

}
