package ics202;
import ics202.*;
import ics202.lab01.MyContainer;
import ics202.lab02.MySearchableContainer;

public class DuplicatedElementsFinder implements Visitor{
    MyContainer container;
    MySearchableContainer searchableContainer = new MySearchableContainer();
    MySearchableContainer duplicates = new MySearchableContainer();
    public DuplicatedElementsFinder (MyContainer container) {
        this.container = container;
    }

    @Override
    public void visit(Object object) {

        if (object instanceof Comparable) {
            Comparable c = (Comparable) object;
            Association association = (Association) searchableContainer.find(new Association(c));
            if (association == null) {
                association = new Association(c,1);
                searchableContainer.insert(association);
            }
            else {
                association.setValue((Integer)association.getValue()+1);
            }
            if((Integer)association.getValue() > 3) {
                Association duplicated = (Association) duplicates.find(association);
                if(duplicated == null) {
                    duplicates.insert(association);
                }
            }
        }

    }

    public MySearchableContainer getDuplicates() {
        container.accept(this);
        return duplicates;
    }

    @Override
    public boolean isDone() {
        return false;
    }
}
