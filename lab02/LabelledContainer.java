package ics202.lab02;

import ics202.*;
import ics202.lab01.*;

public class LabelledContainer extends MySearchableContainer{
	protected String label;
	public LabelledContainer(String label){
		super();
		this.label = label;
	}
	
	public String getLabel(){
	  return label;
	 }

	public int compareTo(Object obj){
		LabelledContainer container = (LabelledContainer) obj;
		return label.compareTo(container.label);
	}

	public boolean equals(Object obj){
		LabelledContainer container = (LabelledContainer)obj;
		return compareTo(container) == 0;
    }
}			