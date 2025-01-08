// MaxMinVisitor Class
package ics202;
import ics202.lab01.*;
public class MaxMinVisitor extends AbstractVisitor {
    private Comparable min;
    private Comparable max;
    private boolean firstVisit = true;

    public void visit(Object object) {
        if (object instanceof Comparable) {
            Comparable e = (Comparable) object;
            if (firstVisit) {
                min = e;
                max = e;
                firstVisit = false;
            } else {
                if (e.compareTo(min) < 0) {
                    min = e;
                }
                if (e.compareTo(max) > 0) {
                    max = e;
                }
            }
        }
    }
    public Comparable getMin() {
        return min;
    }

    public Comparable getMax() {
        return max;
    }
}
