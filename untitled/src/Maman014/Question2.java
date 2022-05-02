package Maman014;

public class Question2 {
    public static void main(String[] args) {
//     int[] a = {1,2,4,4,3,4,5};
//     int[] a = {1,2,2,3,4,4,5,6,6,6,6,7,8,9};
//     int[] a = {1,3,2};
//     int[] a = {5,4,3,2,1};
     int[] a = {1,2,4,4,5};

    System.out.println(strictlyIncreasing(a));
    }

    public static int strictlyIncreasing (int[] a) {
        int counter = 0;
        int finalCounter = 0;
        int n = a.length;

        for (int i = 1; i < n;i++) {
            System.out.println(a[i - 1] + " " + a[i]);
                if(a[i - 1] < a[i]) {
                    System.out.println("+1");
                    counter++;
                } else {
                    if(counter > 0){
                        System.out.println("finalCounter: " + finalCounter + " counter: " + counter);
                        finalCounter += counter;
                        counter--;
                    }
            }
        }

        if(counter > 0){
            System.out.println("finalCounter: " + finalCounter + " counter: " + counter);
            finalCounter += counter;
            counter--;
        }

        return finalCounter;
    }
}


