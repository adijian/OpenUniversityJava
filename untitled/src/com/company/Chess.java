package com.company;

import java.util.Scanner;

public class Chess
{
    public static void main (String [] args) {
        // Variables:
        boolean thereIsAThreat = false;
        int tempRow1_b;
        int tempCol1_b;


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
            if (row1 >= 1 || row1 <= 8 || col1 >= 1 || col1 <= 8 ||
                    row2 >= 1 || row2 <= 8 || col2 >= 1 || col2 <= 8) {
                if (row1 != row2 && col1 != col2) {
                    // Detect if either piece is threating the other
                    // If chess piece is equal r

                    switch (first) {
                        case 'r':
                            if (col1 == col2 || row1 == row2) {
                                thereIsAThreat = true;
                            }
                            if (thereIsAThreat)
                                switch (second) {
                                    case 'b':
                                        System.out.println("rook" + " threats " + "bishop");
                                        break;
                                    case 'k':
                                        System.out.println("rook" + " threats " + "knight");
                                        break;
                                }
                            break;

                        case 'b':
                            tempRow1_b = row1;
                            tempCol1_b = col1;

                            if ((tempRow1_b + 1) == row2) {
                                if ((tempCol1_b + 1) == col2 || (tempCol1_b - 1) == col2) {
                                    thereIsAThreat = true;
                                }
                            }

                            if ((tempRow1_b + 2) == row2) {
                                if ((tempCol1_b + 2) == col2 || (tempCol1_b - 2) == col2) {
                                    thereIsAThreat = true;
                                }
                            }

                            if ((tempRow1_b + 3) == row2) {
                                if ((tempCol1_b + 3) == col2 || (tempCol1_b - 3) == col2) {
                                    thereIsAThreat = true;
                                }
                            }
                            if ((tempRow1_b + 4) == row2) {
                                if ((tempCol1_b + 4) == col2 || (tempCol1_b - 4) == col2) {
                                    thereIsAThreat = true;
                                }
                            }
                            if ((tempRow1_b + 5) == row2) {
                                if ((tempCol1_b + 5) == col2 || (tempCol1_b - 5) == col2) {
                                    thereIsAThreat = true;
                                }
                            }

                            if ((tempRow1_b + 6) == row2) {
                                if ((tempCol1_b + 6) == col2 || (tempCol1_b - 6) == col2) {
                                    thereIsAThreat = true;
                                }
                            }

                            if ((tempRow1_b + 7) == row2) {
                                if ((tempCol1_b + 7) == col2 || (tempCol1_b - 7) == col2) {
                                    thereIsAThreat = true;
                                }
                            }

                            if ((tempRow1_b - 1) == row2) {
                                if ((tempCol1_b + 1) == col2 || (tempCol1_b - 1) == col2) {
                                    thereIsAThreat = true;
                                }
                            }

                            if ((tempRow1_b - 2) == row2) {
                                if ((tempCol1_b + 2) == col2 || (tempCol1_b - 2) == col2) {
                                    thereIsAThreat = true;
                                }
                            }

                            if ((tempRow1_b - 3) == row2) {
                                if ((tempCol1_b + 3) == col2 || (tempCol1_b - 3) == col2) {
                                    thereIsAThreat = true;
                                }
                            }
                            if ((tempRow1_b - 4) == row2) {
                                if ((tempCol1_b + 4) == col2 || (tempCol1_b - 4) == col2) {
                                    thereIsAThreat = true;
                                }
                            }


                            if ((tempRow1_b - 5) == row2) {
                                if ((tempCol1_b + 5) == col2 || (tempCol1_b - 5) == col2) {
                                    thereIsAThreat = true;
                                }
                            }

                            if ((tempRow1_b - 6) == row2) {
                                if ((tempCol1_b + 6) == col2 || (tempCol1_b - 6) == col2) {
                                    thereIsAThreat = true;
                                }
                            }

                            if ((tempRow1_b - 7) == row2) {
                                if ((tempCol1_b + 7) == col2 || (tempCol1_b - 7) == col2) {
                                    thereIsAThreat = true;
                                }
                            }

                            if (thereIsAThreat)
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
                            break;
                    } // end first switch
                } //end threat detect
                // Let the user know the chessmen positions shouldn't be identical
                else {
                    System.out.println("Chessmen positions should not be identical");
                }

                if (!thereIsAThreat) { // else no threats
                    System.out.println("No threats");
                }

            } else { // Let the user know if the position of the chest pieces is not legal
                System.out.println("Position is not legal");
            }
        }
        else { // If first char is equal to second char, let the user know the chess pieces must be different
            System.out.println("Chessmen should be different from each other");
        }
    }// end of method main
} //end of class Chess
