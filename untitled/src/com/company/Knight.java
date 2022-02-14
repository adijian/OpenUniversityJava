package com.company;

import java.util.Scanner;

public class Knight
{
    public static void main (String [] args)
    {
        //Variables:
        int tempCol;
        int tempRow;

        Scanner scan = new Scanner (System.in);
        System.out.println ("This program reads two integers which " + "represent the knight's location on the chess board: ");
        System.out.println ("Please enter the number of row");
        int row = scan.nextInt();
        System.out.println ("Please enter the number of column");
        int col = scan.nextInt();

        // If row and column are valid
        if (row >= 1 && row <= 8 && col >= 1 && col <=8) {
            System.out.println("Moves:");

            // Assign two temporary variables
            tempRow = row;
            tempCol = col;

            // First coordinate
            tempRow -= 2;
            tempCol++;

            // Validate if row and column coordinate
            if (tempRow >= 1 && tempRow <= 8 && tempCol >= 1 && tempCol <=8)
                System.out.println(tempRow + " " + tempCol);

            // Reset temporary variables
            tempCol = col;

            // Second coordinate
            tempCol--;

            // Validate if row and column coordinate
            if (tempRow >= 1 && tempRow <= 8 && tempCol >= 1 && tempCol <=8)
                System.out.println(tempRow + " " + tempCol);

            // Reset temporary variables
            tempRow = row;
            tempCol = col;

            // Third coordinate
            tempRow--;

            // Validate if row and column coordinate
            if (tempRow >= 1 && tempRow <= 8 && tempCol >= 1 && tempCol <=8)
                System.out.println(tempRow + " " + tempCol);

            // Reset temporary variables
            tempRow = row;

            // Fourth coordinate
            tempRow++;
            tempCol -= 2;

            // Validate if row and column coordinate
            if (tempRow >= 1 && tempRow <= 8 && tempCol >= 1 && tempCol <=8)
                System.out.println(tempRow + " " + tempCol);

            // Reset temporary variables
            tempRow = row;
            tempCol = col;

            // Fifth coordinate
            tempRow += 2;
            tempCol--;

            // Validate if row and column coordinate
            if (tempRow >= 1 && tempRow <= 8 && tempCol >= 1 && tempCol <=8)
                System.out.println(tempRow + " " + tempCol);

            // Reset temporary variables
            tempCol = col;

            // Sixth coordinate
            tempCol++;

            // Validate if row and column coordinate
            if (tempRow >= 1 && tempRow <= 8 && tempCol >= 1 && tempCol <=8)
                System.out.println(tempRow + " " + tempCol);

            // Reset temporary variables
            tempRow = row;
            tempCol = col;

            // Seventh coordinate
            tempRow++;
            tempCol += 2;

            // Validate if row and column coordinate
            if (tempRow >= 1 && tempRow <= 8 && tempCol >= 1 && tempCol <=8)
                System.out.println(tempRow + " " + tempCol);

            // Reset temporary variables
            tempRow = row;

            // Eighth coordinate
            tempRow--;

            // Validate if row and column coordinate
            if (tempRow >= 1 && tempRow <= 8 && tempCol >= 1 && tempCol <=8)
                System.out.println(tempRow + " " + tempCol);
        } else {
        // If row and column aren't valid, let the user know the input is invalid
            System.out.println("Input is illegal");
        }
    } // end of method main
} //end of class Knight