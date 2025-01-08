package ics202.lab03;

import ics202.lab01.MyContainer;

public class TestMyContainer2 {
    public static void main(String[] args) {
        Integer N = 0;
        MyContainer2 c = new MyContainer2();
        for (int i=0; i<10; i++) {
            N = (Integer) i;
            c.insert(N);
        }

        System.out.println(c);
    }
}
