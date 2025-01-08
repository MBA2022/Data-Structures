package ics202.lab04;

import ics202.Association;
import ics202.Iterator;
import ics202.QueueAsLinkedList;

import java.util.Scanner;

public class TestPriorityQueue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        PriorityQueueAsLinkedList q = new PriorityQueueAsLinkedList();
        String id;
        int priorityKey = 0;

        Association association;



        while (true){
            System.out.println("Enter patient ID: ");
            id = input.next();
            if (id.equals("!")){
                break;
            }

            System.out.println("Enter the priority of the patient (an integer between 1 and 5): ");
            priorityKey = input.nextInt();

            while (priorityKey < 1 || priorityKey > 5){
                System.out.println("Enter the priority of the patient (an integer between 1 and 5): ");
                priorityKey = input.nextInt();
            }

            association = new Association(priorityKey,id);
            q.enqueue(association);
        }


        Iterator qIterator = q.iterator();
        while (qIterator.hasNext()){
            Association dAssociation  = (Association) qIterator.next();

            System.out.print("ID: "+ dAssociation.getValue());

            System.out.println(" Priority Key: "+ dAssociation.getKey());
        }



    }
}
