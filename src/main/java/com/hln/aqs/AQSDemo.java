package com.hln.aqs;

import java.util.Arrays;
import java.util.List;

public class AQSDemo {

    private static class Node<E> {
        E val;
        Node<E> next;
        public Node(){}
        public Node(E val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node node = new Node();
        List<Integer> list = Arrays.asList(1,3,6,10);

        Node cur = node;
        for (int i = 0; i < list.size(); i++) {
            cur.next = new Node(list.get(i));
            cur = cur.next;
        }
        System.out.println("");
    }
}
