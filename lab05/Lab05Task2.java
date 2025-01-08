package ics202.lab05;
import java.util.Scanner;

public class Lab05Task2 {
    public static void main(String args[]) {
        Scanner stdin = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("Enter array size: ");
            int size = stdin.nextInt();
            int[] array = new int[size];
            for (int k = 0; k < size; k++) {
                System.out.print("Enter element#" + (k + 1) + ": ");
                array[k] = stdin.nextInt();
            }

            System.out.print("The array is: ");
            for (int k = 0; k < size; k++)
                System.out.print(array[k] + "   ");

            System.out.print("\nEnter the integer to test: ");
            int value = stdin.nextInt();

            if (hasLessThan(array, value))
                System.out.println("THE ARRAY HAS AN ELEMENT LESS THAN " + value);
            else
                System.out.println("THE ARRAY HAS NO ELEMENT LESS THAN " + value);

            System.out.println("Enter 1 to continue, any other digit to exit");
            choice = stdin.nextInt();
        } while (choice == 1);
    }

    public static boolean hasLessThan(int[] x, int value) {
        // call to the auxillary method to be implemented by students
        int index = 0;
        if ( auxillary(x[index],value,index , x.length) ) {
            return true;
        }
        else {
            return false;
        }
    }

    // a private auxillary method to be implemented by students
    private static boolean auxillary(int x, int value , int currentIndex ,int size) {
        if (value > x){
            return true;
        }
        else if (value < x && currentIndex + 1 < size){
            return auxillary(x, value , currentIndex+1 , size);
        }
        else {
            return false;
        }
    }


}





