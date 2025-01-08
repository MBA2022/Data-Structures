package ics202.lab08;
import ics202.*;

public class MyAssociation implements Comparable
{

    private class Value
    {
    	int count;
    	MyLinkedList linkedlist = new MyLinkedList();
    }

    protected Comparable key;
    protected Value value;

    public MyAssociation(Comparable comparable, int lineNumber)
    {
        key = comparable;
        value = new Value();
        value.count = 1;
        value.linkedlist.append(new Integer(lineNumber));
    }

    public MyAssociation(Comparable comparable)
    {
        this(comparable, 0);
    }

    public Comparable getKey()
    {
        return key;
    }

    public Value getValue()
    {
        return value;
    }

    public int getLastLineNumber()
    {
    	return ((Integer) value.linkedlist.getLast()).intValue ();
    }

    public void incrementWordCount()
    {
    	value.count++;
    }

    public void appendLineNumber(int lineNumber)
    {
    	value.linkedlist.append(new Integer(lineNumber));
    	value.count++;
    }

    public int compareTo(Object obj)
    {
        MyAssociation association = (MyAssociation)obj;
        return key.compareTo(association.getKey());
    }

    public String toString()
    {
        String s = "" + key;
        if(value != null)
            s = s + "  " + "Count = " + value.count + " Line numbers: " + value.linkedlist + "\n";
        return s;
    }
}
