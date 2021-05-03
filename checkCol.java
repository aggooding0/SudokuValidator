/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokuvalidator;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author AyokaGooding
 * @version 3.12.19 Multi-Threaded Sudoku Validator. The goal of this project is
 * to run multiple threads that will check every row, column, and square in a
 * Sudoku puzzle.
 */
public class checkCol implements Runnable {

    public static boolean TF = true;

    /*
    *This is the constructor that will check every column in the puzzle 
    * for duplicates and print out which column the duplicate is in.
    */
    public checkCol(int x[][]) {

        int tot = 0;
        int counter = 0;
        //Iterates through the columns of the sudoku puzzle 
        //and calculates the total of each column
        for (int col = 0; col < x.length; col++) {
            for (int row = 0; row < x[col].length; row++) {
                tot = tot + x[row][col];

            }

            counter++;
            // if the sum of the column is not equal to 45 there must be a duplicate
            if (tot != 45) {

                System.out.println("There are duplicates in column " + counter);
                TF = false;
                break;
            }
            tot = 0;
        }
        if (TF == true) {
            System.out.println("There are no duplicates in any column ");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(checkCol.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //implemented run method
    @Override
    public void run() {

    }

}
