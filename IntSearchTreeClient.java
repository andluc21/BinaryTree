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
public class IntSearchTreeClient {
    public static void main(String[] args) {
      
        int x;
        int i;
        int y;
        int j;
        

        IntSearchTree tree = new IntSearchTree();
        int[] list = {55, 29, 87, -3, 42, 60, 91};
        int[] list1 = {60, 55, 100, 45, 57};

                   
        for (i = 0; i < list.length; i++) { 
  
       
            x = list[i]; 
            tree.add(x); }
  
                  
        IntSearchTree tree2 = new IntSearchTree();
      

         for (j = 0; j < list1.length; j++) { 
  
       
            y = list1[j]; 
            tree2.add(y); }
        
 
        System.out.println();
        System.out.println("Here is a sample run");
        System.out.println();
        System.out.println("The orginal array is  ");
        System.out.println();
        
        for (j = 0; j < list.length; j++) { 
            y = list[j];
            System.out.print(y + " ");
       
            }

        System.out.println();
        System.out.println("Tree Structure: ");
        tree.printSideways();  
        System.out.println();
        System.out.println("Sorted list:");
        tree.print();
        System.out.println();       
        System.out.println("The number of left nodes is: " + tree.countLeftNodes());      
        System.out.println();
        System.out.println("This is a full binary tree: " + tree.isFull());
        
        
        
        
        
        System.out.println();
        System.out.println("Here is a sample run");
        System.out.println();
        System.out.println("The orginal array is  ");
        System.out.println();
       
         for (j = 0; j < list1.length; j++) { 
            y = list1[j];
            System.out.print(y + " ");
       
            }
        
        
        System.out.println();
        System.out.println("Tree Structure: ");
        tree2.printSideways();  
        System.out.println();
        System.out.println("Sorted list:");
        tree2.print();
        System.out.println();       
        System.out.println("The number of left nodes is: " + tree2.countLeftNodes());      
        System.out.println();
        System.out.println("This is a full binary tree: " + tree2.isFull());
        
        
     
        
        
    }
}