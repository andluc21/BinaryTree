/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw6;

/**
 *
 * @author lucaandolina
 */

import java.util.*;


// An IntSearchTree object represents an entire binary tree of ints.
public class IntSearchTree {
    private IntTreeNode overallRoot;   // null for an empty tree
    
	 // post: constructs an empty tree
    public IntSearchTree() {
        overallRoot = null;
    }
    
    public void print() {
        printInorder(overallRoot);
        System.out.println();   // end the line of output
    }

    private void printInorder(IntTreeNode root) {
        // (base case is implicitly to do nothing on null)
        if (root != null) {
            // recursive case: print left, center, right
            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);
        }
    }



    public void printSideways() {
        printSideways(overallRoot, "");
    }

    private void printSideways(IntTreeNode root,
            String indent) {
        if (root != null) {
            printSideways(root.right, indent + "    ");
            System.out.println(indent + root.data);
            printSideways(root.left, indent + "    ");
        }
    }
    
    
    // Returns whether this tree contains the given integer.
    public boolean contains(int value) {
        return contains(overallRoot, value);
    }

    private boolean contains(IntTreeNode root, int value) {
        if (root == null) {
            return false;
        } else if (root.data == value) {
            return true;
        } else if (root.data > value) {
            return contains(root.left, value);
        } else {   // root.data < value
            return contains(root.right, value);
        }
    }

// Adds the given value to this BST in sorted order.
    public void add(int value) {
        overallRoot = add(overallRoot, value);
    }

    private IntTreeNode add(IntTreeNode root, int value) {
        if (root == null) {
            root = new IntTreeNode(value);
        } else if (root.data > value) {
            root.left = add(root.left, value);
        } else if (root.data < value) {
            root.right = add(root.right, value);
        } // else a duplicate

        return root;
    }

// Returns the minimum value from this BST.
// Throws a NoSuchElementException if the tree is empty.
    public int getMin() {
        if (overallRoot == null) {
            throw new NoSuchElementException();
        }
        return getMin(overallRoot);
    }

    private int getMin(IntTreeNode root) {
        if (root.left == null) {
            return root.data;
        } else {
            return getMin(root.left);
        }
    }
    
    
 public int countLeftNodes() {
    return countLeftNodes(overallRoot);
}

private int countLeftNodes(IntTreeNode node) {
    if(node == null)
        return 0;
        
    int count = countLeftNodes(node.right);
    
    if(node.left != null)
        count += 1 + countLeftNodes(node.left);
        
    return count;
}





        
        public boolean isFull() {
        return isFull(overallRoot);
    }

    public boolean isFull(IntTreeNode root) {
        if (root == null) {
            return true;
        } else if (root.left == null && root.right != null) {
            return false;
        } else if (root.right == null && root.left != null) {
            return false;
        } else {
            return isFull(root.left) && isFull(root.right);
        }
    }
    
    
    
    
    

    public void remove(int value) {
        overallRoot = remove(overallRoot, value);
    }

    private IntTreeNode remove(IntTreeNode root, int value) {
        if (root == null) {
            return null;
        } else if (root.data > value) {
            root.left = remove(root.left, value);
        } else if (root.data < value) {
            root.right = remove(root.right, value);
        } else {  // root.data == value; remove this node
            if (root.right == null) {
                return root.left;    // no R child; replace w/ L
            } else if (root.left == null) {
                return root.right;   // no L child; replace w/ R
            } else {
                // both children; replace w/ min from R
                root.data = getMin(root.right);
                root.right = remove(root.right, root.data);
            }
        }
        return root;
    }

}
