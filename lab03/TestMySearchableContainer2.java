package ics202.lab03;

import ics202.*;
import java.util.Scanner;

public class TestMySearchableContainer2{

    public static void main(String[] args){

        Scanner stdin = new Scanner(System.in);

        MySearchableContainer2 c = new MySearchableContainer2();

        int choice;
        while((choice = menu(stdin)) != 5){
            switch(choice){
                case 1: insert(c, stdin); break;
                case 2: delete(c, stdin); break;
                case 3: search(c, stdin);break;
                case 4: display(c);
            }

        }
    }

    public static int menu(Scanner stdin){
        int choice = 0;
        do{
            System.out.println("1. Add element(s)");
            System.out.println("2. Delete an element");
            System.out.println("3. Search for an element");
            System.out.println("4. Display all elements");
            System.out.println("5. Exit");

            System.out.println("Please enter your choice");
            choice = stdin.nextInt();

            if(choice < 1 || choice > 5)
                System.out.println("Error - Wrong choice");
        }while(choice < 1 || choice > 5);

        return choice;
    }

    public static void insert(MySearchableContainer2 c, Scanner stdin){
        int number;
        System.out.println("Enter number of elements to insert <=");
        number = stdin.nextInt();

        // Insert the elements. To be completed by students
        Comparable element;
        for (int i = 1; i <= number; i++) {
            System.out.println("Enter element to insert <=" + i);
            element = stdin.nextInt();
            c.insert(element);
        }
    }

    public static void delete(MySearchableContainer2 c, Scanner stdin){
        System.out.print("Enter element to remove: ");
        // To be completed by students
        Comparable element = stdin.nextInt();
        if (c.isMember(element)){
            c.withdraw(element);
            System.out.println("Element removed");
        }
        else{
            System.out.println("Error - wrong input");
        }

    }

    public static void search(MySearchableContainer2 c, Scanner stdin){
        System.out.print("Enter an element to search for: ");
        // To be completed by students

        Comparable element = stdin.nextInt();
        if(c.isMember(element)) {
            System.out.println("Element found");
        }
        else{
            System.out.println("Element not found");
        }
    }

    public static void display(MySearchableContainer2 c){
        // To be completed by students
        PrintingVisitor visitor = new PrintingVisitor();
        c.accept(visitor);
        System.out.println();
    }
}