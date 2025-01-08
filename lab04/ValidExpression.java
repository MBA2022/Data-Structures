package ics202.lab04;

import java.util.Scanner;
import java.util.Stack;
public class ValidExpression {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();

        Scanner in = new Scanner(System.in);
        System.out.println("Enter an Expression: ");
        String str = in.nextLine();

        Character[] charArray = new Character[str.length()];

        for (int i = 0; i < str.length(); i++) {
            charArray[i] = str.charAt(i);
        }
        boolean correct = true;
        for (Character c: charArray){

            if (c == '('){
                stack.push(c);
            }
            else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    correct = false;
                    break;
                }
            }
        }
        if (!stack.isEmpty()){
            correct = false;
        }
        if (correct) {
            System.out.println("Correct !");
        }
        else {
            System.out.println("Not Correct");
        }
    }
}