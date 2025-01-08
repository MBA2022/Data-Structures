// SpecialVisitor Class
package ics202;
import ics202.lab01.*;
public class SpecialVisitor implements Visitor {
    private Comparable target;
    private int n, count = 0;

    public SpecialVisitor(Comparable target, int n){
        this.target = target;
        this.n = n;
    }
    @Override
    public void visit (Object object) {
        if (object instanceof Comparable) {
            Comparable c = (Comparable) object;
            if (c.equals(target)) {
                count++;
                if (count == n) {
                    return;
                }
            }
        }
    }
    public boolean hasAtLeastNobjects()  {
        return count >= n;
    }
    public boolean isDone () {
        return count >= n;
    }
}