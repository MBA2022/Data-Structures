package ics202.lab05;

import ics202.*;

public class MyLinkedList2 {

     protected Element head;
     protected Element tail;
     
     
     public int length(){
	     return auxLength(head);
      }
	
	 private int auxLength(Element element){
	   if(element == null)
	     return 0;
	   else
	    return 1 + auxLength(element.next);
	 }
	
      
      public void purge(){
        head = null;
        tail = null;
      }

    public Element getHead(){
        return head;
    }

    public Element getTail(){
        return tail;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public Object getFirst(){
        if(head == null)
            throw new ListEmptyException();
        else
            return head.datum;
    }

    public Object getLast(){
        if(tail == null)
            throw new ListEmptyException();
        else
            return tail.datum;
    }

    public void prepend(Object obj){
        Element element = new Element(obj, head);
        if(head == null)
            tail = element;
        head = element;
    }

    public void append(Object obj){
        Element element = new Element(obj, null);
        if(head == null)
            head = element;
        else
            tail.next = element;
        tail = element;
    }

    public void assign(MyLinkedList2 linkedlist){
        if(linkedlist != this) {
            purge();
	    Element element = linkedlist.head;
            while (element != null) {
                append(element.datum);
		element = element.next;
	    }
        }
    }

    public void extract(Object obj){
        Element element = head;
        Element lastElement = null;
        while(element != null && ! element.datum.equals(obj)){
            lastElement = element;
	        element = element.next;
	     }

        if(element == null)
            throw new IllegalArgumentException("item not found");
        if(element == head)
            head = element.next;
        else
            lastElement.next = element.next;
        if(element == tail)
            tail = lastElement;
    }

    public void extractFirst(){
        if(head == null)
            throw new IllegalArgumentException("item not found");
        head = head.next;
        if(head == null)
            tail = null;
    }

     public void extractLast() {
       if(tail == null)
         throw new IllegalArgumentException("item not found");
       if(head == tail)
          head = tail = null;
       else {
         Element previous = head;
         while (previous.next != tail)
            previous = previous.next;
         previous.next = null;
         tail = previous;
       }
    }


    public String toString() {
        return "{" + toStringRecursive(head, true) + "}";
    }
    private String toStringRecursive(Element element, boolean isFirst) {
        if (element == null) {
            return "";
        }

        String result;
        if (isFirst) {
            result = element.datum.toString();
        } else {
            result = ", " + element.datum.toString();
        }
        return (result + toStringRecursive(element.next, false));
    }



    public Element find(Object obj){
	   Element element = head;
       return auxillaryFind(obj, element);
	}

    private Element auxillaryFind(Object obj , Element element){
        if (element != null && element.datum.equals(obj)){
            return element;
        }
        else if(element != null){
            element = element.next;
            return auxillaryFind(obj, element);
        }
        else {
            return null;
        }
    }
	

	public final class Element{

           Object datum;
           Element next;

           Element(Object obj, Element element){
             datum = obj;
             next = element;
           }
       
	   public Object getDatum(){
              return datum;
           }

           public Element getNext(){
             return next;
           }

           public void insertAfter(Object obj){
             next = new Element(obj, next);
             if(this == tail)
                tail = next;
          }


          public void insertBefore(Object obj){
            Element element = new Element(obj, this);
            if(this == head){
                head = element;
                return;
            }
            auxiliary(head,element);
          }
          private void auxiliary(Element currentElement , Element newElement){
               if ( currentElement == null ){
                 return;
               }
               if (currentElement.next == this.getDatum()){
                   newElement = this;
                   newElement.next = currentElement;
                   return;
               }
               else {
                   auxiliary(currentElement.next, newElement);
               }
          }

        public void extract(){
		  Element element = null;
		  if(this == head)
              head = next;
           else{
              element = head;
              while(element != null && element.next != this){
			     element = element.next;
		       }
				
                  if(element == null)
                     throw new InvalidOperationException();
                  element.next = next;
            }
            if(this == tail)
               tail = element;
         }
      }
  }