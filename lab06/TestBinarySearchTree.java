package ics202.lab06;

import ics202.*;

import ics202.lab01.AdditionVisitor;
import java.util.Scanner;

public class TestBinarySearchTree {
	static	Scanner stdin = new Scanner(System.in);

	public static void main (String[] args){
		// Create an instance of BinarySearchTree called tree
		// to be completed by students
        BinarySearchTree tree = new BinarySearchTree();


		int choice;
		initializeTree(tree);
		printTree(tree);

		do {
			showMenu();
			choice = getChoice();

			switch (choice) {
			case 1: System.out.print("Enter the key to be inserted: ");
					addElement(tree);
					break;
			case 2: deleteElement(tree);
				    break;
			case 3: checkElement(tree);
				    break;
			case 4: printCounts(tree);
				    break;
			case 5: printSum(tree);
				    break;
			case 6:
                   System.out.println();
				   // Display tree in bracketed form by invoking the treePrinter method
				   // to be completed by students
                   treePrinter(tree);

				   break;
			}
			printTree(tree);
		} while (choice != 7);
	}

	public static void addElement(BinarySearchTree tree){
		boolean inputDone = false;
		while (! inputDone) {

			try {
				int key = stdin.nextInt();

				// Insert the key in tree
				// to be completed by students
				tree.insert(key);

				inputDone = true;
			}
			catch(IllegalArgumentException e)
			{
				System.out.println("Error - " +  e);
				System.out.print("Enter another key: ");
			}
		}
	}

	public static void initializeTree(BinarySearchTree tree){
		System.out.print("Enter number of nodes: ");
		int	numberOfNodes = stdin.nextInt();
		for(int i = 1; i <= numberOfNodes; i++){
		   System.out.print("Enter the key#" + i+ ": ");
		   addElement(tree);
		}
	}

	public static void printTree(BinarySearchTree tree) {
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

	public static void deleteElement(BinarySearchTree tree){
		boolean inputDone = false;
		while (! inputDone) {
			System.out.print("\nEnter the key to be deleted: ");
			try {
				int key = stdin.nextInt();

				// Delete the entered key from tree
				// to be completed by students
				tree.withdraw(key);

				inputDone = true;
			}
			catch(IllegalArgumentException e)
			{
				System.out.println("Error - " +  e);
			}
		}
	}

	public static void checkElement(BinarySearchTree tree){
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

	public static void printCounts(BinarySearchTree tree) {
		// Display the total number of nodes in tree
		System.out.println("Total nodes: " + tree.getCount());
		// Display the number of internal nodes in tree
		int internalNodes = tree.getCount() - tree.leavesCount();
		System.out.println("Internal nodes: " + internalNodes);
		// Display the number of leaf nodes in tree
		// to be completed by students
		System.out.println("Leaf nodes: " + tree.leavesCount());


	}

	public static void printSum(BinarySearchTree tree) {
        // Display the sum of the keys of tree using the AdditionVisitor of lab01 and a preorder depthFirstTraversal
        // to be completed by students

		AdditionVisitor v = new AdditionVisitor();
		tree.preorderTraversal(v);
		System.out.println("Sum of keys: " + v.getSum());
	}

	static int getChoice(){
      int choice;
      do {
         System.out.print("\rYour choice? : ");
         choice = stdin.nextInt();
		} while (choice < 1 || choice > 7);
      return choice;
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

 	static void showMenu() {
 		System.out.println("\n********************************");
 		System.out.println("*   Testing Binary Search Tree  *");
 		System.out.println("********************************");
 		System.out.println("1.  Insert An Element");
 		System.out.println("2.  Delete An Element");
 		System.out.println("3.  Check for an Element");
 		System.out.println("4.  Print Counts");
		System.out.println("5.  Print Sum");
		System.out.println("6.  Print with Brackets");
		System.out.println("7.  Quit");
 	}
}