package Maman014;

public class Main {

    public static void main(String[] args) {


        int[][] m2 = {
                {1,2},
                {3,4}
        };

        int[][] m1 = {
                {1,1,1,1,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };

//        System.out.println(what(m1));
//        System.out.println(test(m2));

        int[][] m = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };
        System.out.println(findValTest(m, 1));
        System.out.println(findValTest(m, 11));
        System.out.println(findValTest(m, 10));
        System.out.println(findValTest(m, 18));
        System.out.println(findValTest(m, 23));
    }

    public static boolean findValTest (int [][] m, int val) {
        int j = 0;
        int n = m.length;

//        System.out.println("first check max min vals " + m[n-1][n-1] + " "  + m[0][0]);
        if(m[n-1][n-1] < val) {
            return false;
        } else if(m[0][0] > val) {
            return false;
        }

        for (int i = 0; i < n; i++) {
//            System.out.println("first loop " + m[i][n-1]);

            if(m[i][n-1] == val) {
                return true;
            } else if (m[i][n-1] > val){
                j = i;
                break;
            }
        }

        for(int i = 0; i < n; i++) {
//            System.out.println("second loop " + m[j][i]);

            if(m[j][i] == val) {
                return true;
            }
        }

        for(int i = 0; i < n; i++) {
//            System.out.println("third loop " + m[i][j - 1]);

            if(m[i][j - 1] == val) {
                return true;
            }
        }

        return false;
    }

    public static boolean test(int [][] m)
    {
        int n=m.length;
        for(int r=0; r<(n-1); r++)
            for (int c=0; c<n; c++)
                for (int i=0; i<n; i++) {
                    System.out.println(m[r][c] + " "  + m[r+1][i]);
                    if(m[r][c] > m[r+1][i]) return false;
                }
        return true;
    }

    public static boolean what(int [][] m)
    {
        int n=m.length;
        for(int x=0; x<n; x++)
            for (int y=0; y<(n-1); y++)
                if(m[x][y] > m[x][y+1]) return false;
        for(int x=0; x<n; x++)
            for (int y=0; y<(n-1); y++)
                if(m[y][x] > m[y+1][x]) return false;
        return true;
    }

    public static boolean findValWhat (int [][] m, int val){
        int j = 0;
        int n = m.length;

        if(m[n-1][n-1] < val) {
            return false;
        } else if(m[0][0] > val) {
            return false;
        }

        for(int i = 0; i < n; i++) {
//            System.out.println("diagonal value: " + m[i][i]);
            if (val == m[i][i]){
                return true;
            } else if (val < m[i][i]) {
                j = i;
                break;
            }
        }

        for(int t = j - 1;t >= 0; t--) {
            // scan left of diagonal high
//            System.out.println("second loop: " + m[j][t]);
            if (val == m[j][t]){
                return true;
            }
        }

//        System.out.println("cell check: " + m[j-1][j]);
        if (val == m[j-1][j]) {
            // check the cell above the previously found higher value
            return true;
        } else {
            for (int i = j + 1; i < n; i++) {
//                System.out.println("third loop: " + m[j - 1][i]);

                // check the line right of the lower value
                if (val == m[j - 1][i]) {
                    return true;
                }
            }
        }

        return false;
    }

}
