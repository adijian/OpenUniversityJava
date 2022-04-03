package practice;
public class Main {

    public static void main(String[] args) {
        final int MAX_ARR_SIZE = 1000;
        int[] a = new int[MAX_ARR_SIZE];

        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }

        System.out.println(binarySearch(a, 500));
    }

    public static int binarySearch(int[] a, int x) {
        int low = 0, high = a.length-1, mid;
        System.out.println("low = " + low + " high = " + high + " x = " + x);

        while (low <= high)
        {
            mid = (low + high)/2;
            if (a[mid] == x) {
                System.out.println("a[mid] == x, a[mid] = " + a[mid] + " x = " + x);
                return mid;
            }
            if (a[mid] < x) {
                low = mid + 1;
                System.out.println("low = mid + 1, low = " + low + " mid = " + mid);
            }
            else {
                high = mid - 1;
                System.out.println("high = mid - 1, high = " + high + " mid = " + mid);
            }
        }
        return -1;
    }
}