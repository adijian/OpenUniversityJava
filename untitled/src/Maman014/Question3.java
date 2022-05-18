package Maman014;

public class Question3 {
    public static void main(String[] args) {
        int[] a = {4, 5, 6, 5, 4, 3}; //3
        System.out.println(longestFlatSequence(a));
    }
    public static int longestFlatSequence(int[] arr) {
        return longestFlatSequence(arr, 1, 0, 0, arr[0], arr[1]);
    }

    public static int longestFlatSequence(int[] arr, int index, int counter, int counter1, int num1, int num2) {
        if(index < arr.length - 1) {
            if (counter == 0) {
                if(arr[index] == arr[index - 1] &&
                   arr[index] == arr[index + 1]) {
                    num1 = arr[index];
                    num2 = arr[index];
                } else if(arr[index - 1] == arr[index + 1] &&
                  (arr[index - 1] == arr[index] + 1 ||
                   arr[index - 1] == arr[index] - 1)) {
                    num1 = arr[index - 1];
                    num2 = arr[index];
                } else if(arr[index] == arr[index + 1] &&
                (arr[index - 1] == arr[index] - 1 ||
                arr[index - 1] == arr[index] + 1)) {
                    num1 = arr[index];
                    num2 = arr[index - 1];
                }
            }
            if(lengthFlat(arr, index, num1, num2) != 0) {
                counter += lengthFlat(arr, index, num1, num2);
            } else {
                if (counter > counter1)
                    counter1 = counter;
                counter = 0;
            }
            System.out.println("counter = " + counter + " counter1 = " + counter1 + " num1 = " + num1 + " num2 " + num2);

            return longestFlatSequence(arr, index + 1, counter, counter1, num1, num2);
        }
        return Math.max(counter, counter1);
    }

    public static int lengthFlat(int[] arr, int index, int num1, int num2) {
        //111
        //112
        //110
        if(arr[index] == arr[index - 1]) {
            if (((arr[index] == num1 || arr[index] == num2) &&
               (arr[index + 1] == num1 || arr[index + 1] == num2))) {
                if((arr[index + 1] == arr[index] ||
                    arr[index + 1] == arr[index] + 1 ||
                    arr[index + 1] == arr[index] - 1)){
                    return 3;
                }
                return 2;
            }
        }

        //121
        //101
        if(arr[index - 1] == arr[index + 1]) {
            if((arr[index - 1] == num1 || arr[index - 1] == num2) &&
                (arr[index] == num1 || arr[index] == num2)) {
                if((arr[index] == arr[index - 1] + 1 ||
                    arr[index] == arr[index - 1] - 1)) {
                    return 3;
                }
                return 2;
            }
        }

        //211
        //011
        if(arr[index] == arr[index + 1]) {
            if((arr[index] == num1 || arr[index] == num2) &&
                (arr[index - 1] == num1 || arr[index - 1] == num2)) {
                if((arr[index - 1] == arr[index] - 1 ||
                    arr[index - 1] == arr[index] + 1)){
                    return 3;
                }
                return 2;
            }
        }

        return 0;
    }

//    public static int longestFlatSequence(int[] arr) {
//        if (arr.length == 0) {
//            return 0;
//        }
//
//        if (arr.length == 1) {
//            return 1;
//        }
//
////        return lengthFlat(arr, 0, 0);
//        return lengthFlat(arr, 0, 0);
//    }
//
//    public static int lengthFlat(int[] arr, int index, int counter) {
//        System.out.println("Index: " + index);
//        if (
//            (index == 0) &&
//            (arr[index + 1] == arr[index] + 1 ||
//             arr[index + 1] == arr[index] - 1)
//        ) {
//            System.out.println("1 First number is smaller or bigger than next, counter = 2");
//            counter = 2;
//            return lengthFlat(arr, index + 1, counter);
//        } else if (
//                ((index + 1) == arr.length) &&
//                 (arr[index - 1] == arr[index] + 1 ||
//                  arr[index - 1] == arr[index] - 1)
//        ) {
//            System.out.println("2 Last number is bigger or smaller than previous, counter = 2");
//            return 2;
//        } else if (index != 0 && index < arr.length - 1) {
//            if (
//                ((arr[index - 1] == arr[index] + 1 ||
//                  arr[index - 1] == arr[index] - 1) &&
//                  arr[index + 1] == arr[index - 1])
//            ) {
//                System.out.println("3 Found a number smaller or bigger than its previous and after, counter = 3");
//                return 3;
//            } else if (
//                    (arr[index + 1] == arr[index] + 1 ||
//                     arr[index + 1] == arr[index] - 1)
//            ) {
//                System.out.println("4 Found a number that is smaller or bigger than its previous, counter = 2");
//                counter = 2;
//                return lengthFlat(arr, index + 1, counter);
//            }
//        }
//        return counter;
//    }
}


