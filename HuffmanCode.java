package ics202;

import ics202.lab02.MySearchableContainer;

import java.io.*;
import java.util.*;

public class HuffmanCode {
    protected String code;
    protected BinaryTree hcTree;

    public HuffmanCode(MySearchableContainer container) {
        hcTree = encode(container);
    }

    public HuffmanCode(String text) {
        hcTree = encode(calculateFrequency(text));
    }

    public HuffmanCode(Scanner in) {
        hcTree = encode(calculateFrequency(in));
    }

    public BinaryTree getHuffmanCodeTree() {
        return hcTree;
    }

    //======================================================================================================
    // To be implemented by students

    public MySearchableContainer updateContainer(String text, MySearchableContainer container) {
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            HuffmanChar hc = new HuffmanChar(character);
            HuffmanChar existing = (HuffmanChar) container.find(hc);

            if (existing != null) {
                existing.setFrequency(existing.getFrequency() + 1);
            } else {
                container.insert(new HuffmanChar(character, 1));
            }
        }
        return container;
    }


    public MySearchableContainer calculateFrequency(String text) {
        MySearchableContainer container = new MySearchableContainer();
        container = updateContainer(text, container);
        return container;
    }

    public MySearchableContainer calculateFrequency(Scanner file) {
        MySearchableContainer container = new MySearchableContainer();
        String text = null;
        while (file.hasNextLine()) {
            container = updateContainer(file.nextLine(), container);
        }
        return container;
    }

    //========================================================================================================
    public BinaryTree encode(MySearchableContainer container) {
        final ics202.PriorityQueue queue = new BinaryHeap(container.getCount());

        Visitor enqueueVisitor = new AbstractVisitor() {
            public void visit(Object object) {
                HuffmanNode node = new HuffmanNode((HuffmanChar) object);
                queue.enqueue(new BinaryTree(node));
            }
        };

        /* Use the enqueueVisitor to initialize queue with one-node BinaryTrees; each having a distinct character
           and its frequency */
        container.accept(enqueueVisitor);

        // Build the huffmanCodeTree
        while (queue.getCount() > 1) {
            BinaryTree left = (BinaryTree) queue.dequeueMin();
            BinaryTree right = (BinaryTree) queue.dequeueMin();
            int sum = ((HuffmanNode) left.getKey()).getFrequency() + ((HuffmanNode) right.getKey()).getFrequency();
            HuffmanNode object = new HuffmanNode(sum);
            queue.enqueue(new BinaryTree(object, left, right));
        }

        // Get the huffmanCodeTree and then create its codeWords
        BinaryTree hcTree = (BinaryTree) queue.dequeueMin();
        code = "";
        createCodeWords(hcTree, code);
        return hcTree;
    }
    //=============================================================================================================


    private void createCodeWords(BinaryTree hcTree, String code) {
        if (hcTree.getCount() == 1)
            ((HuffmanNode) hcTree.getKey()).setCode("0");
        else
            createCodeWordsAux(hcTree, code);
    }

    protected void createCodeWordsAux(BinaryTree hcTree, String code) {

        if (!hcTree.isLeaf()) {
            createCodeWordsAux(hcTree.getLeft(), code + "0");
            createCodeWordsAux(hcTree.getRight(), code + "1");
        } else {
            ((HuffmanNode) hcTree.getKey()).setCode(code);
        }
    }

    //============================================================================================================
    //to be implemented by students
    public String decode(String bits) {
        StringBuilder decodedString = new StringBuilder();
        BinaryTree currentNode = hcTree;

        for (int i = 0; i < bits.length(); i++) {
            char bit = bits.charAt(i);

            if (bit == '0') {
                currentNode = currentNode.getLeft();
            } else if (bit == '1') {
                currentNode = currentNode.getRight();
            }

            if (currentNode.isLeaf()) {
                HuffmanNode node = (HuffmanNode) currentNode.getKey();
                decodedString.append(node.getChar());
                currentNode = hcTree; // Reset to the root for the next character
            }
        }

        return decodedString.toString();
    }

}
