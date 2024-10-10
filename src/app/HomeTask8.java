package app;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//import static java.util.Arrays.binarySearch;

public class HomeTask8 {
    public static void main(String[] args) {
        // create an array and fill it with random integers
        Random random = new SecureRandom();
        int[] arrayInt = new int[15];

        for (int index = 0; index < arrayInt.length; index++) {
            arrayInt[index] = random.nextInt(100) + 1;
        }

        System.out.println("Початковий вигляд масиву: " + Arrays.toString(arrayInt));

        // sort cloned array using Insertion Sort
        int[] newArrayInt = Arrays.copyOf(arrayInt, arrayInt.length);

        insertionSort(newArrayInt);
        System.out.println("Відсортований масив: " + Arrays.toString(newArrayInt));

        // input number and then find it`s index in the array
        Scanner incomeValue = new Scanner(System.in);
        System.out.print("Введіть число для пошуку: ");
        int number = incomeValue.nextInt();

        /*
        Arrays.sort(arrayInt);
        int foundIndex = Arrays.binarySearch(arrayInt, number);
        System.out.print("Індекс числа " + number + " у відсортованому масиві: " + foundIndex);
        */

        // search entered index using binary search
        int result = binarySearch(newArrayInt, number);

        if (result <= 0) {
            System.out.print("Введіть число для пошуку: " + number + " не знайдено в масиві.");
        } else {
            System.out.print("Введіть число для пошуку: " + " Індекс числа " + number + " у відсортованому масиві: " + result);
        }
    }

    public static void insertionSort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }
    }

    public static int binarySearch(int[] array, int number) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == number) {
                return mid;
            } else if (array[mid] < number) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

}

