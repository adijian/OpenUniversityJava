package Maman014;

public class Question3 {
    public static void main(String[] args) {
        int[] a = {4, 5, 6, 5, 4, 3};
        System.out.println(longestFlatSequence(a));
    }

    public static int longestFlatSequence(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        if (arr.length == 1) {
            return 1;
        }

        return lengthFlat(arr, 0, 0);
    }

    public static int lengthFlat(int[] arr, int index, int counter) {
        System.out.println("Index: " + index);
        if (
            (index == 0) &&
            (arr[index + 1] == arr[index] + 1 ||
             arr[index + 1] == arr[index] - 1)
        ) {
            System.out.println("1 First number is smaller or bigger than next, counter = 2");
            counter = 2;
            return lengthFlat(arr, index + 1, counter);
        } else if (
                ((index + 1) == arr.length) &&
                 (arr[index - 1] == arr[index] + 1 || arr[index - 1] == arr[index] - 1)
        ) {
            System.out.println("2 Last number is bigger or smaller than previous, counter = 2");
            return 2;
        } else if (index != 0 && index < arr.length - 1) {
            if (
                ((arr[index - 1] == arr[index] + 1 || arr[index - 1] == arr[index] - 1) &&
                  arr[index + 1] == arr[index - 1])
            ) {
                System.out.println("3 Found a number smaller or bigger than its previous and after, counter = 3");
                return 3;
            } else if (
                    (arr[index + 1] == arr[index] + 1 || arr[index + 1] == arr[index] - 1)
            ) {
                System.out.println("4 Found a number that is smaller or bigger than its previous, counter = 2");
                counter = 2;
                return lengthFlat(arr, index + 1, counter);
            }
        }
        return counter;
    }
}


