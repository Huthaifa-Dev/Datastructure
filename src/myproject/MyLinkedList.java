/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 *
 * @author Huthaifa J Salman
 */
public class MyLinkedList<E> implements MyList<E> {

    private Node HEAD;
    private Node TAIL;
    private int SIZE;

    private class Node<E> {

        E data;
        Node next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }

    }

    public Iterator<E> iterator() {
        return new MyLinkedList.IteratorHelper();
    }

    class IteratorHelper<E> implements Iterator<E> {

        Node<E> index;

        public IteratorHelper() {
            index = HEAD;
        }

        @Override
        public boolean hasNext() {
            return (index!= null);
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("The List is Empty!");
            }
            Node<E> val = index;
            index = index.next;
            return val.data;
        }

        @Override
        public void remove() {
            Iterator.super.remove(); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            Iterator.super.forEachRemaining(action); //To change body of generated methods, choose Tools | Templates.
        }
    }

    public MyLinkedList() {
        HEAD = null;
        TAIL = null;
        SIZE = 0;
    }

    public void addFirst(E data) {
        Node<E> newNode = new Node<>(data);
        if (SIZE == 0) {
            HEAD = TAIL = newNode;
            SIZE++;
            return;
        }
        newNode.next = HEAD;
        HEAD = newNode;
        SIZE++;
    }

    public void addLast(E data) {
        Node<E> newNode = new Node<>(data);
        if (HEAD == null) {
            HEAD = TAIL = newNode;
            SIZE++;
            return;
        }
        TAIL.next = newNode;
        TAIL = newNode;
        SIZE++;
    }

    public void add(E data, int index) {

        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == SIZE - 1) {
            addLast(data);
            return;
        }
        Node<E> newNode = new Node<>(data);
        Node<E> curr = HEAD;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        SIZE++;
    }

    public E removeFirst() {
        if (HEAD == null) {
            return null;
        }
        E temp = (E) HEAD.data;
        HEAD = HEAD.next;
        SIZE--;
        return temp;
    }

    public E removeLast() {
        if (HEAD == null) {
            return null;
        } else if (HEAD == TAIL) {
            return removeFirst();
        }
        Node<E> curr = HEAD;
        Node<E> pre = null;
        while (curr != TAIL) {
            pre = curr;
            curr = curr.next;
        }
        pre.next = TAIL;
        TAIL = pre;
        SIZE--;
        return curr.data;
    }

    public E remove(int index) {
        if (index == 0) {
            return removeFirst();
        }
        if (index == SIZE - 1) {
            return removeLast();
        }
        if (index >= SIZE && index < 0) {
            return null;
        }
        Node<E> curr = HEAD;
        Node<E> pre = null;
        for (int i = 0; i < index; i++) {
            pre = curr;
            curr = curr.next;
        }
        E data = curr.data;
        pre.next = curr;
        curr = pre;
        SIZE--;
        return data;
    }

    public E get(int index) {
        if (index >= SIZE && index < 0) {
            return null;
        }
        if (index == 0) {
            return (E) HEAD.data;
        }
        if (index == SIZE - 1) {
            return (E) TAIL.data;
        }
        Node<E> curr = HEAD;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return (E) curr.data;
    }

    public E peek() {
        return (E) HEAD.data;
    }

    public int size() {
        return SIZE;
    }

}
