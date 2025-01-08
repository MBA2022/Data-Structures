package ics202.lab02;
import java.io.*;
import java.util.Scanner;
import ics202.*;

public class TestAssociation{

	public static void main(String[] args)throws IOException{
		MySearchableContainer container = new MySearchableContainer();
		Scanner reader = new Scanner(new File("D:\\InteliJ\\ics202\\lab02\\input.txt"));
		reader.useDelimiter("[ :;,.?\"\n\r\t!-]+");
		Association association;



		while(reader.hasNext()){
			String word = reader.next();
			// to be completed by students

			association = (Association) container.find(new Association(word));
			if(association == null){
				association = new Association(word,1);
				container.insert(association);
			}
			else{
				association.setValue((Integer)association.getValue()+1);
			}
		}

		// Display the container contents using a PrintingVisitor object
		// to be completed by students

		PrintingVisitor visitor = new PrintingVisitor();
		container.accept(visitor);
		System.out.println();
		
		
	}
}				