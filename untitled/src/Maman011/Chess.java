/** Determine if a chess piece is attacking another chess piece on a chess board
 * @author Adi Jian
 * @version 17.3.2022
 */

package Maman011;

import java.util.Scanner;

public class Chess
{
    /**
     * The user enters two chess pieces and the function prints if there is a threat between the two
     */
    public static void main (String [] args) {
        // Variables:
        boolean thereIsAThreat = false;

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the type" + " of the first chessman");
        char firstChessPiece = scan.next().charAt(0);
        System.out.println("Please enter the number of row");
        int row1 = scan.nextInt();
        System.out.println("Please enter the number of column");
        int col1 = scan.nextInt();
        System.out.println("Please enter the type" + " of the second chessman");
        char secondChessPiece = scan.next().charAt(0);
        System.out.println("Please enter the number of row");
        int row2 = scan.nextInt();
        System.out.println("Please enter the number of column");
        int col2 = scan.nextInt();

        // If first chess piece is different from second chess piece
        if (firstChessPiece != secondChessPiece) {
            if (row1 >= 1 && row1 <= 8 && col1 >= 1 && col1 <= 8 &&
                row2 >= 1 && row2 <= 8 && col2 >= 1 && col2 <= 8) {
                if (row1 != row2 && col1 != col2) {
                    // Detect if either piece is threating the other
                    switch (firstChessPiece) {

                        // If chess piece is equal rook
                        case 'r':
                            // When either input columns or rows are equal, the rook threats the other chess piece
                            if (col1 == col2 || row1 == row2) {
                                thereIsAThreat = true;
                            }
                            if (thereIsAThreat) {
                                // Print the relevant chess pieces' names
                                switch (secondChessPiece) {
                                    case 'b':
                                        System.out.println("rook" + " threats " + "bishop");
                                        break;
                                    case 'k':
                                        System.out.println("rook" + " threats " + "knight");
                                        break;
                                }
                            }
                            break;

                        // If chess piece is equal bishop
                        case 'b':
                            // Scan the rows for all possible directions the bishop can travel
                            if ((((row1 + 1) == row2 || (row1 - 1) == row2) && ((col1 + 1) == col2 || (col1 - 1) == col2)) ||
                                (((row1 + 2) == row2 || (row1 - 2) == row2) && ((col1 + 2) == col2 || (col1 - 2) == col2)) ||
                                (((row1 + 3) == row2 || (row1 - 3) == row2) && ((col1 + 3) == col2 || (col1 - 3) == col2)) ||
                                (((row1 + 4) == row2 || (row1 - 4) == row2) && ((col1 + 4) == col2 || (col1 - 4) == col2)) ||
                                (((row1 + 5) == row2 || (row1 - 5) == row2) && ((col1 + 5) == col2 || (col1 - 5) == col2)) ||
                                (((row1 + 6) == row2 || (row1 - 6) == row2) && ((col1 + 6) == col2 || (col1 - 6) == col2)) ||
                                (((row1 + 7) == row2 || (row1 - 7) == row2) && ((col1 + 7) == col2 || (col1 - 7) == col2)))
                                    {
                                    thereIsAThreat = true;
                            }

                            if (thereIsAThreat)
                                // Print the relevant chess pieces' names
                                switch (secondChessPiece) {
                                    case 'r':
                                        System.out.println("bishop" + " threats " + "root");
                                        break;
                                    case 'k':
                                        System.out.println("bishop" + " threats " + "knight");
                                        break;
                                }
                            break;

                        case 'k':
                            // If chess piece is equal knight
                            // Scan for all the possible positions the knight can threaten another chess piece
                            if(((row1 + 2) == row2 && (((col1 + 1) == col2) || (col1 - 1) == col2)) ||
                                ((row1 - 2) == row2 && (((col1 + 1) == col2) || (col1 - 1) == col2)) ||
                                ((((row1 + 1) == row2) || ((row1 - 1) == row2)) && (col1 + 2) == col2) ||
                                ((((row1 + 1) == row2) || ((row1 - 1) == row2)) && (col1 - 2) == col2))
                                {
                                thereIsAThreat = true;
                            }

                            if (thereIsAThreat)
                                // Print the relevant chess pieces' names
                                switch (secondChessPiece) {
                                    case 'r':
                                        System.out.println("knight" + " threats " + "rook");
                                        break;
                                    case 'b':
                                        System.out.println("knight" + " threats " + "bishop");
                                        break;
                                }
                            break;
                    } // End first chess piece switch case
                    if (!thereIsAThreat) { // Eventually, if there are no threats
                        System.out.println("no threat");
                    }
                } // End threat detection
                // Let the user know the chessmen positions shouldn't be identical
                else {
                    System.out.println("Chessmen positions should not be identical");
                }
            // End of check if input is valid
            } else { // Let the user know if the position of the chest pieces is not legal
                System.out.println("Position is not legal");
            }
        }// End of check whether firstChessPiece chess piece is different from secondChessPiece
        else { // If firstChessPiece char is equal to secondChessPiece char, let the user know the chess pieces must be different
            System.out.println("Chessmen should be different from each other");
        }
    }// end of method main
} //end of class Chess