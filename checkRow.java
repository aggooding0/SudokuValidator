package sudokuvalidator;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author AyokaGooding
 * @version 3.12.19 Multi-Threaded Sudoku Validator. The goal of this project is
 * to run multiple threads that will check every row, column, and square in a
 * Sudoku puzzle.
 */
public class checkRow implements Runnable {

    public static boolean TF = true;

    /*
    *This is the constructor that will check every row in the puzzle
    *for duplicates and print out which column the duplicate is in.
    * Accepts an integer 2d array
     */
    public checkRow(int x[][]) {

        int tot = 0;
        int counter = 0;
        //Iterates through the rows of the sudoku puzzle 
        //and calculates the total of each row
        for (int row = 0; row < x.length; row++) {
            for (int col = 0; col < x[row].length; col++) {
                tot = tot + x[row][col];
            }

            counter++;
        // if the sum of the row is not equal to 45 there must be a duplicate
            if (tot != 45) {
                System.out.println("There are duplicates in row " + counter);
                TF = false;
                break;
            }
            tot = 0;
        }

        if (TF == true) {
            System.out.println("There are no duplicates in any row ");
        }
        // Using the sleep method from the thread class to make the result print slower
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
