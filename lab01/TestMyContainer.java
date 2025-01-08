package ics202.lab01;

import ics202.*;

public class TestMyContainer {
	
	public static void main(String[] args) {
		Integer N = 0;
		MyContainer c = new MyContainer();
		for (int i=0; i<10; i++) {
			N = (Integer) i;
			c.insert(N);
		}
	    System.out.println(c);   
	}
}
				