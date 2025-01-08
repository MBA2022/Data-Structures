package ics202.lab03;

import ics202.*;
import ics202.lab01.*;

public class MySearchableContainer2 extends MyContainer2 implements SearchableContainer {
    public Comparable find(Comparable target) {
        if(list.find(target) != null){
            return target;
        }
        return null;
    }

    public void withdraw(Comparable target){
        list.extract(list.find(target));
    }

    public boolean isMember(Comparable target) {
        if(list.find(target) != null){
            return true;
        }
        return false;
    }
}