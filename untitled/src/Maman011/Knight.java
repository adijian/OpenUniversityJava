/** Locates every possible move a knight can make on a chess board
 * @author Adi Jian
 * @version 3.9.2022
 */
package Maman011;

import java.util.Scanner;

public class Knight
{
    /**
     * Computes the possible moves a knight can make
     */
    public static void main (String [] args)
    {
        Scanner scan = new Scanner (System.in);
        System.out.println ("This program reads two integers which " + "represent the knight's location on the chess board: ");
        System.out.println ("Please enter the number of row");
        int row = scan.nextInt(); // The row which the knight is placed
        System.out.println ("Please enter the number of column");
        int col = scan.nextInt(); // The column which the knight is placed

        // Find all possible positions the knight can move from the input location
        // If row and column are valid
        if (row >= 1 && row <= 8 && col >= 1 && col <=8) {
            System.out.println("Moves:");

            // Determine whether the knight can move forward in every variation
            if((row + 2) >= 1 && (row + 2) <=8 &&
                    (col - 1) >= 1 && (col - 1) <=8 ) {
                System.out.println((row + 2) + " " + (col - 1));
            }

            if((row + 2) >= 1 && (row + 2) <=8 &&
                    (col + 1) >= 1 && (col + 1) <=8 ) {
                System.out.println((row + 2) + " " + (col + 1));
            }

            if((row - 2) >= 1 && (row - 2) <=8 &&
                    (col + 1) >= 1 && (col + 1) <=8 ) {
                System.out.println((row - 2) + " " + (col + 1));
            }

            if((row - 2) >= 1 && (row - 2) <=8 &&
                    (col - 1) >= 1 && (col - 1) <=8 ) {
                System.out.println((row - 2) + " " + (col - 1));
            }

            if((row + 1) >= 1 && (row + 1) <=8 &&
                    (col + 2) >= 1 && (col + 2) <=8 ) {
                System.out.println((row + 1) + " " + (col + 2));
            }

            if((row - 1) >= 1 && (row - 1) <=8 &&
                    (col + 2) >= 1 && (col + 2) <=8 ) {
                System.out.println((row - 1) + " " + (col + 2));
            }

            if((row + 1) >= 1 && (row + 1) <=8 &&
                    (col - 2) >= 1 && (col - 2) <=8 ) {
                System.out.println((row + 1) + " " + (col - 2));
            }

            if((row - 1) >= 1 && (row - 1) <=8 &&
                    (col - 2) >= 1 && (col - 2) <=8 ) {
                System.out.println((row - 1) + " " + (col - 2));
            }
        } else { // If row and column aren't valid, let the user know the input is invalid
            System.out.println("Input is illegal");
        }
    } // end of method main
} //end of class Knight