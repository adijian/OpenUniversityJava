package Maman014;

public class Question4 {
    public static void main(String[] args) {
        int[][] a = {
                {1,1,-1,1,1},
                {1,0,0,-1,1},
                {1,1,1,1,-1},
                {-1,-1,1,1,1},
                {1,1,-1,-1,1}
        };
        System.out.println(findMaximum(a, 0,0,0,true));
    }


    public static int findMaximum(int[][] mat, int counter, int rowIndex, int colIndex, boolean hi) {
        if (rowIndex == 0 && colIndex == 0 && mat[0][0] == 1) {
            counter += 1;
            System.out.println("Counter " + counter + " mat ["  + rowIndex + "][" + (colIndex) + "]");
            if(mat[rowIndex][colIndex + 1] == 1 && ((colIndex + 1) <= mat[rowIndex].length)) {
                counter += 1;
                System.out.println("Counter " + counter + " mat ["  + rowIndex + "][" + (colIndex + 1) + "]");
                return findMaximum(mat, counter, rowIndex, colIndex + 1);
            }
            else if(mat[rowIndex + 1][colIndex] == 1) {
                counter += 1;
                System.out.println("Counter " + counter + " mat ["  + (rowIndex + 1) + "][" + colIndex + "]");
                return findMaximum(mat, counter, rowIndex+ 1, colIndex);
            }
            else if(mat[rowIndex][colIndex + 1] == 0 && (colIndex + 1) <= mat[rowIndex].length) {
                System.out.println("Counter " + counter + " mat ["  + rowIndex + "][" + (colIndex + 1) + "]");
                return findMaximum(mat, counter, rowIndex, colIndex + 1);
            }
            else if(mat[rowIndex + 1][colIndex] == 0) {
                System.out.println("Counter " + counter + " mat ["  + (rowIndex + 1) + "][" + colIndex + "]");
                return findMaximum(mat, counter, rowIndex+ 1, colIndex);
            }
            return Math.max(findMaximum(mat, counter, rowIndex, colIndex + 1), findMaximum(mat, counter, rowIndex + 1, colIndex));
        } else if(rowIndex == 0 && colIndex == 0 && mat[0][0] == 0) {
            return Math.max(findMaximum(mat, counter, rowIndex, colIndex + 1), findMaximum(mat, counter, rowIndex + 1, colIndex));
        }
        return counter;
    }

    public static int findMaximum(int[][] mat, int counter, int rowIndex, int colIndex) {
        if((rowIndex % 2) == 0) {
            if(mat[rowIndex][colIndex + 1] == 1 && ((colIndex + 1) <= mat[rowIndex].length)) {
                counter += 1;
                System.out.println("Counter " + counter + " mat ["  + (rowIndex) + "][" + (colIndex + 1) + "]");
                return findMaximum(mat, counter, rowIndex, colIndex + 1);
            }
            else if(mat[rowIndex + 1][colIndex] == 1 && (rowIndex + 1) <= mat.length) {
                counter += 1;
                System.out.println("Counter " + counter + " mat ["  + (rowIndex + 1) + "][" + (colIndex) + "]");
                return findMaximum(mat, counter, rowIndex+ 1, colIndex);
            }
            else if(mat[rowIndex][colIndex + 1] == 0 && (colIndex + 1) <= mat[rowIndex].length) {
                System.out.println("Counter " + counter + " mat ["  + (rowIndex) + "][" + (colIndex + 1) + "]");
                return findMaximum(mat, counter, rowIndex, colIndex + 1);
            }
            else if(mat[rowIndex + 1][colIndex] == 0 && (rowIndex + 1) <= mat.length) {
                System.out.println("Counter " + counter + " mat ["  + (rowIndex + 1) + "][" + (colIndex) + "]");
                return findMaximum(mat, counter, rowIndex+ 1, colIndex);
            }
        } else {
            if(((colIndex - 1) >= 0) && mat[rowIndex][colIndex - 1] == 1 ) {
                counter += 1;
                System.out.println("Counter " + counter + " mat ["  + (rowIndex) + "][" + (colIndex - 1) + "]");
                return findMaximum(mat, counter, rowIndex, colIndex - 1);
            }
            else if(mat[rowIndex + 1][colIndex] == 1 && (rowIndex + 1) <= mat.length) {
                counter += 1;
                System.out.println("Counter " + counter + " mat ["  + (rowIndex + 1) + "][" + (colIndex) + "]");
                return findMaximum(mat, counter, rowIndex + 1, colIndex);
            }
            else if ((colIndex - 1) >= 0 && (mat[rowIndex][colIndex - 1] == 0)) {
                System.out.println("Counter " + counter + " mat ["  + (rowIndex) + "][" + (colIndex - 1) + "]");
                return findMaximum(mat, counter, rowIndex, colIndex - 1);
            }
            else if(mat[rowIndex + 1][colIndex] == 0 && (rowIndex + 1) <= mat.length) {
                System.out.println("Counter " + counter + " mat ["  + (rowIndex + 1) + "][" + (colIndex) + "]");
                return findMaximum(mat, counter, rowIndex + 1, colIndex);
            }
        }
        return counter;
    }
}
