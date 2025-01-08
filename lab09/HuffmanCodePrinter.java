package ics202.lab09;

import ics202.*;

public class HuffmanCodePrinter extends AbstractVisitor {

    @Override
    public void visit(Object obj) {
        if (obj instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode) obj;
            // Only print leaf nodes
            if (node.getChar() != (char) 1) { // Assuming (char) 1 is a placeholder for non-leaf nodes
                System.out.println(node);
            }
        }
    }
}
