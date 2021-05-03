
package sudokuvalidator;

import java.util.logging.Level;
import java.util.logging.Logger;
import static sudokuvalidator.checkRow.TF;

/**
 * @author AyokaGooding
 * @version 3.12.19 Multi-Threaded Sudoku Validator. The goal of this project is
 * to run multiple threads that will check every row, column, and square in a
 * Sudoku puzzle.
 */
public class checkSquare implements Runnable {

    public static boolean TF = true;
    
    
    public checkSquare(int x[][]) {

        int tot = 0;
        int counter = 0;
        int mult = 0;
        int count1  = 0;
        int count2  = 3;
        int count3  = 6;
        
        
        // Finds any squares in the rows 1-3 for any duplicates and prints out which square the duplicate is in
        for (int i= 0; i<3; i++ ){    
            for (int row = 0; row < 3 ; row++) {   
                for (int col = 0 + mult; col < x.length/3+mult ; col++) {
                    tot = tot + x[row][col];
                    
                   
                }
            }     
                count1++;  
                if(tot!= 45 ){
                    System.out.println("There are duplicates in square"+ count1);
                    TF = false;
                    break;
                }
            tot = 0;
            mult +=3;
            
        }
        
        tot=0;
        mult=0;
        
        
        
        // Finds any squares in the rows 4-6 for any duplicates and prints out which square the duplicate is in
        for (int i= 0; i<3; i++ ){    
            for (int row = 3; row < 6 ; row++) {   
                for (int col = 0 + mult; col < x.length/3+mult ; col++) {
                    tot = tot + x[row][col];
                    
                   
                }
            }     
                count2++;  
                if(tot!= 45 ){
                    System.out.println("There are duplicates in square "+ count2);
                    TF = false;
                    break;
                }
            tot = 0;
            mult +=3;
            
        }
        
        

        tot=0;
        mult =0;
        // Finds any squares in the rows 7-9 for any duplicates and prints out which square the duplicate is in
        for (int i= 0; i<3; i++ ){    
            for (int row = 6; row < 9 ; row++) {   
                for (int col = 0 + mult; col < x.length/3+mult ; col++) {
                    tot = tot + x[row][col];
                    
                   
                }
            }     
                count3++;  
                if(tot!= 45 ){
                    System.out.println("There are duplicates in square "+ count3);
                    TF = false;
                    break;
                }
            tot = 0;
            mult +=3;
           
        }
        
        
        
        if (TF == true) {
            System.out.println("There are no duplicates in any square ");
        }
        
    }
//  implemented run method
    @Override
    public void run() {
        
    }
}
 
    
