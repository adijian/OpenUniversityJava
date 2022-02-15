package com.company;

import java.util.Scanner;

public class Chess
{
    public static void main (String [] args) {
        // Variables:
        boolean thereIsAThreat = false;

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the type" + " of the first chessman");
        char first = scan.next().charAt(0);
        System.out.println("Please enter the number of row");
        int row1 = scan.nextInt();
        System.out.println("Please enter the number of column");
        int col1 = scan.nextInt();
        System.out.println("Please enter the type" + " of the second chessman");
        char second = scan.next().charAt(0);
        System.out.println("Please enter the number of row");
        int row2 = scan.nextInt();
        System.out.println("Please enter the number of column");
        int col2 = scan.nextInt();

        // If first chess piece is different from second chess piece
        if (first != second) {
            if (row1 >= 1 && row1 <= 8 && col1 >= 1 && col1 <= 8 &&
                    row2 >= 1 && row2 <= 8 && col2 >= 1 && col2 <= 8) {
                if (row1 != row2 && col1 != col2) {
                    // Detect if either piece is threating the other
                    switch (first) {
                        // If chess piece is equal rook
                        case 'r':
                            // When either input columns or rows are equal, the rook threats the other chess piece
                            if (col1 == col2 || row1 == row2) {
                                thereIsAThreat = true;
                            }
                            if (thereIsAThreat) {
                                // Print the relevant chess pieces' names
                                switch (second) {
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
                            if ((row1 + 1) == row2 || (row1 - 1) == row2) {
                                if ((col1 + 1) == col2 || (col1 - 1) == col2) {
                                    thereIsAThreat = true;
                                }
                            }

                            if ((row1 + 2) == row2 || (row1 - 2) == row2) {
                                if ((col1 + 2) == col2 || (col1 - 2) == col2) {
                                    thereIsAThreat = true;
                                }
                            }

                            if ((row1 + 3) == row2 || (row1 - 3) == row2) {
                                if ((col1 + 3) == col2 || (col1 - 3) == col2) {
                                    thereIsAThreat = true;
                                }
                            }
                            if ((row1 + 4) == row2 || (row1 - 4) == row2) {
                                if ((col1 + 4) == col2 || (col1 - 4) == col2) {
                                    thereIsAThreat = true;
                                }
                            }
                            if ((row1 + 5) == row2 || (row1 - 5) == row2) {
                                if ((col1 + 5) == col2 || (col1 - 5) == col2) {
                                    thereIsAThreat = true;
                                }
                            }

                            if ((row1 + 6) == row2 || (row1 - 6) == row2) {
                                if ((col1 + 6) == col2 || (col1 - 6) == col2) {
                                    thereIsAThreat = true;
                                }
                            }

                            if ((row1 + 7) == row2 || (row1 - 7) == row2) {
                                if ((col1 + 7) == col2 || (col1 - 7) == col2) {
                                    thereIsAThreat = true;
                                }
                            }

                            if (thereIsAThreat)
                                // Print the relevant chess pieces' names
                                switch (second) {
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
                            if(((row1 + 2) == row2 && (((col1 + 1) == col2) || (col1 - 1) == col2))) {
                                thereIsAThreat = true;
                            }

                            if(((row1 - 2) == row2 && (((col1 + 1) == col2) || (col1 - 1) == col2))) {
                                thereIsAThreat = true;
                            }

                            if(((((row1 + 1) == row2) || ((row1 - 1) == row2)) && (col1 + 2) == col2)) {
                                thereIsAThreat = true;
                            }

                            if(((((row1 + 1) == row2) || ((row1 - 1) == row2)) && (col1 - 2) == col2)) {
                                thereIsAThreat = true;
                            }

                            if (thereIsAThreat)
                                // Print the relevant chess pieces' names
                                switch (second) {
                                    case 'r':
                                        System.out.println("knight" + " threats " + "rook");
                                        break;
                                    case 'b':
                                        System.out.println("knight" + " threats " + "bishop");
                                        break;
                                }
                            break;
                    } // End first chess piece switch case

                } // End threat detection
                // Let the user know the chessmen positions shouldn't be identical
                else {
                    System.out.println("Chessmen positions should not be identical");
                }
            // End of check if input is valid
            } else { // Let the user know if the position of the chest pieces is not legal
                System.out.println("Position is not legal");
            }
        }// End of check whether first chess piece is different from second
        else { // If first char is equal to second char, let the user know the chess pieces must be different
            System.out.println("Chessmen should be different from each other");
        }

        if (!thereIsAThreat) { // Eventually, if there are no threats
            System.out.println("No threats");
        }
    }// end of method main
} //end of class Chess