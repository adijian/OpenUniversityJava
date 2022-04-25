package practice.A2022_87.question2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] a = {22,24,26,32,34,36,38,40};//3
//        int[] a = {22,26,28};//1
//        int[] a = {2,4,6,8,10};//5

        System.out.println(findMissingIndex(a));

    }


//    static int findMissingIndex(int[] a) {
//        System.out.println(Arrays.toString(a));
//        int d = 0;
//        int previousD = 0;
//        for (int i = 1; i < a.length; i++) {
//            d = a[i] - a[i-1];
//            if (previousD == 0) {
//                previousD = d;
//            }
//
//            if(d != previousD) {
//                System.out.println("Previous d != d index = " + i);
//                return i;
//            }
//            System.out.println("Current: " + d);
//
//            if (i == a.length-1) {
//                return a.length;
//            }
//        }
//
//        System.out.println("End d: " + d);
//        return d;
//    }


    static int findMissingIndex(int[] a) {
        int d1,d2,d;
        d1 = a[a.length-1] - a[a.length-2];
        d2 = a[1] - a[0];
        d = Math.min(d1,d2);

        int hi = a.length-1, lo = 0, mid, elementAmount, largestValue;
        while(lo <= hi) {
            mid = (hi+lo)/2;
            if(((mid-1) > 0) && (a[mid] - a[mid] > d)){
                return mid;
            }

            elementAmount = hi -mid;
            largestValue = a[mid] + elementAmount * d;
            if(a[hi] == largestValue) {
                hi = mid-1;
            }
            else {
                lo = mid + 1;
            }
        }
        return a.length;
    }
}
