package OOP;

import java.util.Scanner;

public class Array {

    public static void arrayExport(int[] arr) {
        for (int j : arr) {
            System.out.printf("arr[%d]: ", arr[j]);
        }
    }

    public class intArrayInput {
        public static Scanner input = new Scanner(System.in);

        static int[] arrayInput(int[][] arr, int n) {
            for (int i = 0; i < n; i++) {
                System.out.printf("Enter arr[%d}: ", i);
                arr[i] = new int[]{input.nextInt()};
            }
            return arr[n];
        }
    }

    public static int[] addNewElement(int[] arr, int x, int index) {
//  Step1: make a new array
        int[] brr = new int[arr.length + 1];

//  Step2: duplicate array 1 to array 2
        for (int i = 0; i < index; i++) {
            brr[i] = arr[i];
        }

        for (int i = index; i < arr.length; i++) {
            brr[i + 1] = arr[i];
        }

//  Step3: insert new element to end of array
        brr[index] = x;

//  Step 4: reference to new array
        return brr;
    }

    public static boolean isPalindromeArray(int[] arr) {
        if (arr.length == 0 || arr.length == 1) {
            return true;
        }
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            if (arr[start] != arr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static int[] removeArrayElement(int[] arr, int index){
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }

        int[] newArr = new int[arr.length - 1];

        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }

        for (int i = index + 1; i < arr.length; i++) {
            newArr[i - 1] = arr[i];
        }
        return newArr;
    }
}
