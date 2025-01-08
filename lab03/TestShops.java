package ics202.lab03;
import ics202.*;

import java.sql.SQLOutput;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TestShops {
	static	Scanner stdin = new Scanner(System.in);

	public static void main (String[] args){
		MyLinkedList shoplist = new MyLinkedList();
    	int choice;
    	String shopName, itemName;

    	initializeList(shoplist);

    	do {
    	   showMenu();
    	   choice = getChoice();

		   switch (choice) {
			   case 1 :  System.out.println("Enter the shop name");
			             shopName = stdin.nextLine();
			             System.out.println("Enter the item name");
			             itemName = stdin.nextLine();

			             buyItem(itemName, shopName, shoplist);
			  	     break;

			   case 2 :  displayShops(shoplist);
			  	     break;
			}

		} while (choice != 3);
    }

	static int getChoice(){
      int choice;
      do {
         System.out.print("\nYour choice? : ");
         choice = stdin.nextInt();
		  stdin.nextLine();
		} while (choice < 1 || choice > 3);
      return choice;
	}

	static void showMenu() {
 		System.out.println("\n***************************");
 		System.out.println("1.  Buy an item");
 		System.out.println("2.  Display all shops");
 		System.out.println("3.  Quit");
 	}

 	static void initializeList(MyLinkedList shoplist){
 		// to be completed by students
		for (int i = 0 ; i < 3 ; i++){
			MySearchableContainer2 itemContainer = new MySearchableContainer2();
			for (int j = 0; j < 2; j++){
				Item item = new Item("Item "+ (j+1),10*(j+1),5*(j+1));
				itemContainer.insert(item);
			}
			Shop shop = new Shop("Shop " + (i+1), itemContainer);
			shoplist.append(shop);
		}
 	}

 	public static void buyItem(String itemName, String shopName, MyLinkedList shoplist){
 		// to be completed by students
		Shop shop = null;
		boolean shopFound = false;

		Iterator shoplistIterator = shoplist.iterator();
		while (shoplistIterator.hasNext()){
			shop = (Shop) shoplistIterator.next();
			if(shop.getName().equals(shopName)){
				shopFound = true;
				break;
			}
		}
		if (!shopFound) {
			System.out.println("Error: Shop not found.");
			return;

		}
		Item item = null;
		boolean itemFound = false;
		if (shopFound){
			MySearchableContainer2 itemContainer = (MySearchableContainer2) shop.getItemContainer();
			Iterator itemIterator = itemContainer.iterator();
			while (itemIterator.hasNext()){
				item = (Item) itemIterator.next();
				if(item.getName().equals(itemName)){
					itemFound = true;
					break;
				}
			}


			if (!itemFound) {
				System.out.println("Error: Item not found.");
				return;
			}
			System.out.println("Enter the Quantity that you want to buy: ");
			int q = stdin.nextInt();

			if (q>item.getStockQuantity()){
				System.out.println("Error: Insufficient stock.");
			}
			else{
				System.out.println("The unit price for this item is "+item.getUnitPrice());
				item.modifyStockQuantity((item.getStockQuantity() - q));
				System.out.println("\nTOTAL COST: "+item.getUnitPrice()*q);
			}


		}
 	}

 	public static void displayShops(MyLinkedList shoplist){
 		// to be completed by students
		System.out.println("Shop List:");
		int count = 1;
		Iterator shopsIterator = shoplist.iterator();

 		while (shopsIterator.hasNext()){
			 Shop shop = (Shop) shopsIterator.next();
			 MySearchableContainer2 itemConataner = shop.getItemContainer();
			 Iterator itemIterator =  itemConataner.iterator();
			 System.out.println("**********************");
			 System.out.println(count + ". " + shop.getName());

			 System.out.println("--- Items ---");
			 while (itemIterator.hasNext()){
				 Item item = (Item) itemIterator.next();
				 System.out.println("name: "+item.getName());
				 System.out.println("Stock Quantity " + item.getStockQuantity());
				 System.out.println("Unit Price "+item.getUnitPrice());
				 System.out.println("--------------");
			 }


			 count++;
		}
 	}
}
