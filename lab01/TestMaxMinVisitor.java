// TestMaxMinVisitor
package ics202.lab01;
import ics202.*;
public class TestMaxMinVisitor {
    public static void main(String[] args) {
        MyContainer c = new MyContainer();

        c.insert(8);
        c.insert(3);
        c.insert(12);
        c.insert(5);
        c.insert(10);
        c.insert(22);
        c.insert(58);
        c.insert(50);
        c.insert(12);

        MaxMinVisitor v = new MaxMinVisitor();
        c.accept(v);

        System.out.println("Min value: " + v.getMin());
        System.out.println("Max value: " + v.getMax());
    }
}
