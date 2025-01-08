package ics202.lab03.Task5;

import ics202.*;

import java.util.*;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> a = new LinkedList<>();
        LinkedList<Integer> b = new LinkedList<>();
        LinkedList<Integer> mergedList = new LinkedList<>();
        Random rand = new Random();

        for (int i = 0 ; i<5 ; i++){
            a.add(rand.nextInt(100));
            b.add(rand.nextInt(100));
        }

        System.out.println("Linked List A before shifting\n" + a);
        System.out.println("Linked List B before shifting\n" + b);


        Iterator<Integer> iteratorA = a.iterator();
        while (iteratorA.hasNext()) {
            int element = iteratorA.next();
            if (element % 2 == 0) {
                b.add(element);
                iteratorA.remove();
            }
        }

        Iterator<Integer> iteratorB = b.iterator();
        while (iteratorB.hasNext()) {
            int element = iteratorB.next();
            if (element % 2 != 0) {
                a.add(element);
                iteratorB.remove();
            }
        }
        System.out.println("Linked List A after shifting\n" + a);
        System.out.println("Linked List B after shifting\n" + b);

        Iterator<Integer> iteratorAAfter = a.iterator();
        Iterator<Integer> iteratorBAfter = b.iterator();

        do{
            int element1 = iteratorAAfter.next();
            mergedList.add(element1);
            int element2 = iteratorBAfter.next();
            mergedList.add(element2);
        }while (iteratorAAfter.hasNext() && iteratorBAfter.hasNext());

        System.out.println("Merged List (alternating even and odd numbers) "+mergedList);


///////////////////////// - Two Solutions - ///////////////////////////////////////////////////////////////////////

//        MyLinkedList a = new MyLinkedList();
//        MyLinkedList b = new MyLinkedList();
//        MyLinkedList odd = new MyLinkedList();
//        MyLinkedList even = new MyLinkedList();
//
//        MyLinkedList mergedList = new MyLinkedList();
//
//        Random rand = new Random();
//        for (int i = 0 ; i < 5 ; i++){
//            a.append(rand.nextInt(100));
//            b.append(rand.nextInt(100));
//        }
//        System.out.println("Linked List A before shifting");
//        Iterator aIterator = a.iterator();
//        while (aIterator.hasNext()){
//            Integer element = (Integer) aIterator.next();
//            System.out.print(element+ " ");
//            if(element%2 == 0){
//                even.append(element);
//            }
//            else {
//                odd.append(element);
//            }
//        }
//        System.out.println("\nLinked List b before shifting");
//        Iterator bIterator = b.iterator();
//        while (bIterator.hasNext()){
//            Integer element = (Integer) bIterator.next();
//            System.out.print(element+" ");
//            if(element%2 == 0){
//                even.append(element);
//            }
//            else {
//                odd.append(element);
//            }
//        }
//
//        System.out.println();
//        a.assign(odd);
//        b.assign(even);
//        System.out.println("Linked List A after shifting (Odd numbers)");
//        Iterator evenIterator = b.iterator();
//        Iterator oddIterator = a.iterator();
//        while (oddIterator.hasNext()){
//            Integer element = (Integer) oddIterator.next();
//            System.out.print(element+" ");
//        }
//        System.out.println("\nLinked List b after shifting (Even numbers)");
//        while (evenIterator.hasNext()){
//            Integer element = (Integer) evenIterator.next();
//            System.out.print(element+ " ");
//
//        }
//
//        Iterator aI = a.iterator();
//        Iterator bI = b.iterator();
//        while (aI.hasNext() && bI.hasNext()){
//            mergedList.append(aI.next());
//            mergedList.append(bI.next());
//
//        }
//
//        Iterator mergedIterator = mergedList.iterator();
//        System.out.println("\nMerged List (alternating even and odd numbers)");
//        while (mergedIterator.hasNext()){
//            Integer element = (Integer) mergedIterator.next();
//            System.out.print(element+" ");
//
//        }


    }


}
