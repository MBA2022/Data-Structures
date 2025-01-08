package ics202.lab04;
import ics202.*;

import java.util.Scanner;

public class postfix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a postfix expression: ");
        String str = input.nextLine();

        String[] numbersArray = str.split(" ");
        StackAsLinkedList stack = new StackAsLinkedList();
        Integer x, y;
        Integer k;
        for (int i = 0; i < numbersArray.length; i++) {
            if (numbersArray[i].equals("-") || numbersArray[i].equals("+") || numbersArray[i].equals("*") || numbersArray[i].equals("/") || numbersArray[i].equals("%") ){
                if (numbersArray[i].equals("-")){
                    x = (Integer) stack.pop();
                    y = (Integer) stack.pop();
                    stack.push(y-x);
                }
                else if (numbersArray[i].equals("+")){
                    x = (Integer) stack.pop();
                    y = (Integer) stack.pop();
                    stack.push(y+x);
                }
                else if (numbersArray[i].equals("*")){
                    x = (Integer) stack.pop();
                    y = (Integer) stack.pop();
                    stack.push(y*x);
                }
                else if (numbersArray[i].equals("/")){
                    x = (Integer) stack.pop();
                    y = (Integer) stack.pop();
                    stack.push(y/x);
                }
                else if (numbersArray[i].equals("%")){
                    x = (Integer) stack.pop();
                    y = (Integer) stack.pop();
                    stack.push(y%x);
                }


            }
            else {
                stack.push((Object) Integer.parseInt(numbersArray[i]));
            }

        }
        System.out.println("The answer of the expression is: " + stack.getTop());

    }
}
