/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Huthaifa J Salman
 */
public class MyProject {

    /**
     * @param args the command line arguments
     */
    public static int sumOfLastN(MyList list, int n) {
        int sum = 0;
        if (n > list.size() - 1 && n <= 0) {
            throw new IndexOutOfBoundsException("This Argument : " + n + " is illegal!");
        }
        for (int i = list.size()-n; i<list.size(); i++) {
            sum += (int) list.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        MyLinkedList<String> l = new MyLinkedList<>();
        l.addLast("Great Work!");
        l.addLast("Statement_1");
        l.addLast("Statement_2");
        l.addLast("Statement_3");
        l.addLast("Statement_4");
        l.addLast("Statement_5");
        l.addLast("Statement_6");
//        for(int i=0;i<l.getSIZE();i++){
//            System.out.println(l.get(i));
//        }
        Iterator<String> i = l.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        MyArrayList<Integer> integerA = new MyArrayList<>();
        integerA.add(1);
        integerA.add(10);
        integerA.add(50);
        integerA.add(33);
        integerA.add(40);
        integerA.add(99);
        integerA.add(68);

        System.out.println(sumOfLastN(integerA, 1));
        MyLinkedList<Integer> integerB = new MyLinkedList<>();
        integerB.addLast(1);
        integerB.addLast(10);
        integerB.addLast(50);
        integerB.addLast(33);
        integerB.addLast(40);
        integerB.addLast(99);
        integerB.addLast(68);
        System.out.println(sumOfLastN(integerB, 5));
    }

}
