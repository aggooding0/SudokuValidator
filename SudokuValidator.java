package sudokuvalidator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author AyokaGooding
 * @version 3.12.19 Multi-Threaded Sudoku Validator. The goal of this project is
 * to run multiple threads that will check every row, column, and square in a
 * Sudoku puzzle.
 */
public class SudokuValidator {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        int[][] hard = { 
        {2,9,4, 3,6,5, 7,8,1}, 
        {7,5,1, 8,2,9, 3,4,6},
        {8,6,3, 4,1,7, 5,2,9},
        
        {1,4,6, 9,5,3, 2,7,8},
        {9,3,8, 6,7,2, 4,1,5},
        {5,2,7, 1,4,8, 9,6,3},
        
        {3,7,9, 2,8,1, 6,5,4},
        {6,8,5, 7,3,4, 1,9,2},
        {4,1,2, 5,9,6, 8,3,7}
        
        };
        
        int[][] evil = { 
        {7,9,5, 1,6,4, 2,8,3}, 
        {6,4,3, 2,7,7, 9,1,5},
        {2,1,8, 5,9,3, 6,4,7},
        
        {8,3,1, 6,2,5, 4,7,9},
        {4,7,2, 3,8,1, 1,5,6},
        {9,5,3, 4,1,7, 8,3,2},
        
        {1,8,9, 7,5,2, 3,6,4},
        {5,2,4, 8,3,6, 7,9,1},
        {3,6,7, 9,4,1, 5,2,8}
        
        };
     
        int[][] easy = { 
        {9,8,4, 6,1,3, 2,5,7},
        {1,7,3, 5,8,2, 4,9,6},
        {5,2,6, 9,7,4, 3,1,8},

        {2,6,1, 4,9,5, 7,8,3},
        {8,9,5, 7,3,6, 1,4,2},
        {3,4,7, 1,2,8, 5,6,9},

        {6,3,9, 2,4,1, 8,7,5},
        {7,1,2, 8,5,9, 6,3,4},
        {4,5,8, 3,6,7, 9,2,1}
        };
        
        //This was the code to imput the numbers from the files but I could not 
        //get it to go in the 2d array properly so I just created the array myself
        
        
        
        /*
        int SudokuPuzzle[][] = new int[9][9];
        File dictionary = new File("/Users/AyokaGooding/Desktop/hard.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(dictionary));
            int index = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                String [] nums = line.split("-");
                
               for(int r1 = 0 ; r1 < 9; r1++ ){
                   int iter = Integer.parseInt(nums[r1]);
                   SudokuPuzzle[index][r1] = iter;
               }
                
            }
            reader.close();
           
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } 
        for (int colum = 0; colum < SudokuPuzzle.length; colum++) {
            for (int row = 0; row < SudokuPuzzle[colum].length; row++) {
                System.out.print(SudokuPuzzle[colum][row]);
            }
        }
        */
        
        
        
        //Creating an instance of the thread class
        //You can change which sudoku puzzle by changing the arr below to another puzzle
        Thread rowThread = new Thread((Runnable)new checkRow(hard));
        Thread colThread = new Thread((Runnable)new checkCol(hard));
        Thread squThread = new Thread((Runnable)new checkSquare(hard));
       
       //Starting the threads
       rowThread.start();
       colThread.start();
       squThread.start();
      
        try {
            colThread.join();
            rowThread.join();         
            squThread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(SudokuValidator.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    
    
   

}


