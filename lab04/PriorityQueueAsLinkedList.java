package ics202.lab04;
import ics202.*;
import ics202.MyLinkedList;

public class PriorityQueueAsLinkedList extends QueueAsLinkedList {
    public void enqueue(Object obj) {
        // to be completed by students
        Association association = (Association) obj;
        Comparable key = association.getKey();

        if (list.isEmpty()){
            list.append(association);
            count++;
            return;
        }
        else {
            MyLinkedList.Element current = list.getHead();
            MyLinkedList.Element previous = null;


            while (current != null){
                Association currentAssoc = (Association) current.getData();
                Comparable currentKey = currentAssoc.getKey();
                if (key.compareTo(currentKey) < 0 ){
                    break;
                }
                previous = current;
                current = current.getNext();

            }
            if (previous == null){
                list.prepend(association);
            }
            else if (current == null) {
                list.append(association);
            }
            else {
                current.insertBefore(association);
            }

        }
    }
}


////////////                The Big O is Big O for n  --  O(n)