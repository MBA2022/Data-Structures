package ics202.lab06;

import ics202.*;
import ics202.lab01.AdditionVisitor;
import java.util.Scanner;

public class TestBinaryTree {
	static	Scanner stdin = new Scanner(System.in);

	public static void main (String[] args){
		// Create an instance of BinaryTree called tree
		// to be completed by students
        BinaryTree tree;
        tree = new BinaryTree(new Integer(6), new BinaryTree( new Integer(4)), new BinaryTree(new
                Integer(50)));
        tree.left.left = new BinaryTree(new Integer(30));
        tree.left.right = new BinaryTree(new Integer(7));
        tree.left.right.left = new BinaryTree(new Integer(15));
        tree.right.right = new BinaryTree(new Integer(50));
        tree.right.right.right = new BinaryTree(new Integer(20));


		int choice;
		printTree(tree);

		do {
			showMenu();
			choice = getChoice();

			switch (choice) {
			case 1: checkElement(tree);
				    break;
			case 2: printCounts(tree);
				    break;
			case 3: printSum(tree);
				    break;
			case 4:
                   System.out.println();
				   // Display tree in bracketed form by invoking the treePrinter method
				   // to be completed by students
                   treePrinter(tree);



				   break;
			}
			printTree(tree);
		} while (choice != 5);
	}

	public static void printTree(BinaryTree tree) {


        Visitor v = new PrintingVisitor();

        System.out.print("\nPreorder traversal:      ");
        // Perform a preorder traversal on tree using the visitor v
        // to be completed by students
        tree.preorderTraversal(v);

        System.out.print("\nInorder traversal:       ");
        // Perform an inorder traversal on tree using the visitor v
        // to be completed by students
        tree.inorderTraversal(v);

        System.out.print("\nPostorder traversal:     ");
        // Perform a postorder traversal on tree using the visitor v
        // to be completed by students
        tree.postorderTraversal(v);

        System.out.print("\nBreadth first traversal: ");
        // Perform a breadthFirst traversal on tree using the visitor v
        // to be completed by students
        tree.breadthFirstTraversal(v);

        System.out.println();
	}

	public static void checkElement(BinaryTree tree){
		System.out.print("\nEnter the key to be searched for: ");
		int key = stdin.nextInt();
		// Search for key in tree and display a message whether the key is found or not
		// to be completed by students
        if (tree.isMember(key)) {
            System.out.println("Key " + key + " is found in the tree.");
        } else {
            System.out.println("Key " + key + " is not found in the tree.");
        }
	}

	public static void printCounts(BinaryTree tree) {
        // Display the total number of nodes in the tree
        System.out.println("Total nodes: " + tree.getCount());

        // Display the number of internal nodes in the tree
        int internalNodes = tree.getCount() - tree.leavesCount();
        System.out.println("Internal nodes: " + internalNodes);

        // Display the number of leaf nodes in the tree
        // to be completed by students
        System.out.println("Leaf nodes: " + tree.leavesCount());

	}

	public static void printSum(BinaryTree tree) {
        // Display the sum of the keys of tree using the AdditionVisitor of lab01 and a preorder depthFirstTraversal
        // to be completed by students
        AdditionVisitor v = new AdditionVisitor();
        tree.preorderTraversal(v);
        System.out.println("Sum of keys: " + v.getSum());
	}

	public static void treePrinter(BinaryTree t){
		// to be completed by students as a recursive method.
		if(t.isEmpty()){
			return;
		}
		System.out.print("{ ");
		treePrinter(t.getLeft());
		System.out.print(t.getKey() + " ");
		treePrinter(t.getRight());
		System.out.print("}");
	}

 	static int getChoice(){
      int choice;
      do {
         System.out.print("\rYour choice? : ");
         choice = stdin.nextInt();
		} while (choice < 1 || choice > 5);
      return choice;
	}

 	static void showMenu() {
 		System.out.println("\n********************************");
 		System.out.println("*   Testing Binary Tree  *");
 		System.out.println("********************************");
 		System.out.println("1.  Check for an Element");
 		System.out.println("2.  Print Counts");
		System.out.println("3.  Print Sum");
		System.out.println("4.  Print with Brackets");
		System.out.println("5.  Quit");
 	}
}
