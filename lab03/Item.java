package ics202.lab03;
import ics202.*;

class Item implements Comparable{
	private String name;
	private double unitPrice;
	private int stockQuantity;
	
	public Item(String name, double unitPrice, int stockQuantity){
		this.name = name;
		this.unitPrice = unitPrice;
		this.stockQuantity = stockQuantity;
	}
	
	public String getName(){
		return name;
	}
	
	public double getUnitPrice(){
		return unitPrice;
	}
	
	public int getStockQuantity(){
		return stockQuantity;
	}
	
	public void modifyUnitPrice(double newUnitPrice){
		unitPrice = newUnitPrice;
	}
	
	public void modifyStockQuantity(int newStockQuantity){
		stockQuantity = newStockQuantity;
	}
	
	public int compareTo(Object object){
		Item item = (Item) object;
		return this.name.compareTo(item.name);
	}
	
	public String toString(){
		return "{ Item:" + name + ", unitPrice:  " + unitPrice + " , StockQuantity: " + stockQuantity + " }";
	}
}