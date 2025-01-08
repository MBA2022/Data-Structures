package ics202.lab03;

import ics202.*;

import javax.swing.text.Element;
import java.util.Scanner;

public class TestMyLinkedList {
	static	Scanner stdin = new Scanner(System.in);

	public static void main (String[] args){
		MyLinkedList list = new MyLinkedList();
    	int choice;
		Integer data;
		MyLinkedList.Element element;
    	do {
    	   showMenu();
    	   choice = getChoice();

		   switch (choice) {
			   case 1 :  System.out.print("Enter the element to prepend: ");
			             data = stdin.nextInt();
			             list.prepend(data);

			  		     break;

			   case 2 :  System.out.print("Enter the element to append: ");
				         // to be completed by students
			             data = stdin.nextInt();
						 list.append(data);
			  		     break;

			   case 3 :  System.out.print("Insert before which element? :  ");
				         // to be completed by students
			             element = (list.find(stdin.nextInt()));

						 System.out.print("Enter the element to insert: ");
				         data = stdin.nextInt();
						 element.insertBefore(data);

			  		     break;

			   case 4 :  System.out.print("Insert after which element? :  ");
			             // to be completed by students
				         element = (list.find(stdin.nextInt()));
			             
						 System.out.print("Enter the element to insert: ");
			             // to be completed by students
				         data = stdin.nextInt();
				         element.insertAfter(data);
			             
			  		     break;
			   case 5 :  // to be completed by students
				         list.extractFirst();
			  		     break;
			   case 6 :  // to be completed by students
			             list.extractLast();
					     break;
			   case 7 :  System.out.print("Enter Element to Remove :  ");
			             // to be completed by students
				         element = (list.find(stdin.nextInt()));
						 if (element != null){
							 element.extract();
						 }
			}
			 System.out.println("\n"+list);

		} while (choice != 8);
    }

	static int getChoice(){
      int choice;
      do {
         System.out.print("\nYour choice? : ");
         choice = stdin.nextInt();
		} while (choice < 1 || choice > 8);
      return choice;
	}

	static void showMenu() {
 		System.out.println("\n***************************");
 		System.out.println("*   Testing Linked List  *");
 		System.out.println("***************************\n");
 		System.out.println("1.  Prepend an element");
 		System.out.println("2.  Append an element");
 		System.out.println("3.  Insert before an element");
 		System.out.println("4.  Insert after an element");
		System.out.println("5.  Remove first element");
		System.out.println("6.  Remove last element");
		System.out.println("7.  Remove an element");
 		System.out.println("8.  Quit");
 	}
}
