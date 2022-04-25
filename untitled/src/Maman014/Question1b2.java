package Maman014;

public class Question1b2 {
    public static void main(String[] args) {
        int[][] m = {
                {1,2,3},
                {1,2,3},
                {1,2,4}
        };

        int[][] m2 = {
                {1,2,3},
                {1,2,3},
                {1,2,4}
        };
    }

    public static boolean test(int [][] m)
    {
        int n=m.length;
        for(int r=0; r<(n-1); r++)
            for (int c=0; c<n; c++)
                for (int i=0; i<n; i++)
                    if(m[r][c] > m[r+1][i]) return false;
        return true;
    }

//
//    public static boolean findValTest (int [][] m, int val){
//
//    }

}
