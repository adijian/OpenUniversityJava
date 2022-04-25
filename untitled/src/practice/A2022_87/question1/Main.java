package practice.A2022_87.question1;

/**
 * Question 1
 */
public class Main {

    public static void main(String[] args) {
        int[][] mat = {
                       {1,2,3,2,0,1,2},
                       {0,1,0,0,0,3,0},
                       {0,0,1,0,0,0,0},
                       {5,0,0,1,0,0,0},
                       {7,0,0,0,1,0,0},
                       {8,0,0,0,0,1,0},
                       {1,0,0,0,0,0,0},
                       };
        System.out.println(isIdentity(mat, 4, 3));
    }

    static boolean isIdentity(int[][] mat, int x, int size) {
        if((size == 1) && (mat[x][x] == 1)) {
            return true;
        }

        return checkRow(mat, x, x, size);
    }

    static boolean checkRow(int[][] mat,int i, int x, int size){
        if(i == x + size) {
            return true;
        }

        return checkRow(mat, i+1, x, size) && checkCol(mat, i, 0, x, size);
    }

    static boolean checkCol(int[][] mat, int i, int j, int x, int size) {
        if(j == x + size) {
            return true;
        }

        if(i != j) {
            if(mat[i][j] != 0) {
                return false;
            }
        }

        if (i == j) {
            if (mat[i][j] != 1) {
                return false;
            }
        }

        return checkCol(mat, i, j+1, x, size);
    }
}