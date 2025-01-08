package ics202.lab02;

import ics202.DuplicatedElementsFinder;
import ics202.PrintingVisitor;
import ics202.lab01.MyContainer;

public class TestDuplicatedElementsFinder {
    public static void main(String[] args) {
        MyContainer c = new MyContainer();
        c.insert(5);
        c.insert(5);
        c.insert(5);
        c.insert(20);
        c.insert(8);
        c.insert(1);
        c.insert(8);
        c.insert(20);
        c.insert(8);
        c.insert(3);
        c.insert(20);
        c.insert(8);
        c.insert(8);
        c.insert(20);
        // {5, 5, 5, 20, 8, 1, 8, 20, 8, 3,20, 8, 8, 20}

        DuplicatedElementsFinder d = new DuplicatedElementsFinder(c);


        PrintingVisitor visitor = new PrintingVisitor();
        (d.getDuplicates()).accept(visitor);
        System.out.println();
    }
}
