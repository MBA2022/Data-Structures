package ics202.lab05;

import java.util.Scanner;

public class  SubstringFrequency {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Text: ");
        String text = input.next();
        System.out.println("Enter the Sub: ");
        String sub = input.next();

        int non_overlapping = non_overlapping(text, sub);
        int overlapping = overlapping(text, sub);
        System.out.println("Non-overlapping occurrences of '" + sub + "' in '" + text + "': " + non_overlapping );
        System.out.println("overlapping occurrences of '" + sub + "' in '" + text + "': " + overlapping);
    }

    public static int non_overlapping(String text, String sub) {
        if (text.length() < sub.length()) {
            return 0;
        }
        if (text.startsWith(sub)) {
            return 1 + non_overlapping(text.substring(sub.length()), sub);
        } else {
            return non_overlapping(text.substring(1), sub);
        }
    }

    public static int overlapping(String text, String sub) {
        if (text.length() < sub.length()) {
            return 0;
        }
        if (text.startsWith(sub)) {
            return 1 + non_overlapping(text, sub);
        } else {
            return non_overlapping(text.substring(1), sub);
        }
    }

}