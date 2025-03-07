package ics202;

public interface SearchableContainer extends Container {
	boolean isMember (Comparable object);
	void insert (Comparable object);
	void withdraw (Comparable obj);
	Comparable find (Comparable object);
}