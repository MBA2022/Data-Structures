// TestSpecialVisitor
package ics202.lab01;
import ics202.SpecialVisitor;

import java.util.*;

public class TestSpecialVisitor {
    public static void main(String[] args) {
        MyContainer c = new MyContainer();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an Integer value: ");
        for (int i=0; i<12; i++) {
            Integer N = in.nextInt();
            c.insert(N);
        }
        System.out.println("Enter the target object: ");
        Integer target = in.nextInt();
        System.out.println("Enter the number of times the container should include the object: ");
        Integer n = in.nextInt();
        SpecialVisitor s = new SpecialVisitor(target,n);
        c.accept(s);
        System.out.println("Has At Least "+ n +" times of "+target+": " + s.hasAtLeastNobjects());
    }
}
