package ics202.lab05;
import java.util.Scanner;

public class Lab05Task1{
	public static void main(String args []){
		Scanner stdin = new Scanner(System.in);
		System.out.print("Enter a positive integer value for n: ");
		int n = stdin.nextInt();
		
    	welcomeShabaab(n);
  	}
	
	public static void welcomeShabaab(int n){
		//to be implemented as a recursive method by students
		if (n>0){
			System.out.println("ICS Shabaab, welcome to Lab05.");
			welcomeShabaab(n-1);
			System.out.println("COE Shabaab, welcome to Lab05.");
		}
	}
}
