package ics202.lab03;

import ics202.AbstractContainer;
import ics202.ContainerFullException;
import ics202.Iterator;
import ics202.MyLinkedList;

public class MyContainer2 extends AbstractContainer {
    protected MyLinkedList list = new MyLinkedList();

    public boolean isFull() {
        return false; // the the linked lists is dynamic, so there is no full untill the storage is full :)
    }
    public void purge() {
        list.purge();
    }
    public Iterator iterator(){
       return list.iterator();
    }
    public int getSize(){
        count = 0;
        while (list.iterator().hasNext()){
            count++;
        }
        return count;
    }

    public void insert(Comparable object) {
        list.append(object);
    }
}
