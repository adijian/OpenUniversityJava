package Maman014;

public class Question1b1 {
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
