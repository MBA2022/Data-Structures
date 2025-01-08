package ics202.lab03;

import ics202.*;

class Shop implements Comparable{
	private String name;
	private MySearchableContainer2 itemContainer;
	
	public Shop(String name, MySearchableContainer2 itemContainer){
		this.name = name;
		this.itemContainer = itemContainer;
	}
	
	public String getName(){
		return name;
	}
	
	public MySearchableContainer2 getItemContainer(){
		return itemContainer;
	}
	
	public void modifyItemContainer(MySearchableContainer2 modifiedContainer){
		itemContainer = modifiedContainer;
	}
	
	public int compareTo(Object object){
		Shop shop = (Shop) object;
		return this.name.compareTo(shop.name);
	}
	
	public String toString(){
		return "{ " + name + ", " + itemContainer + " }";
	}
}