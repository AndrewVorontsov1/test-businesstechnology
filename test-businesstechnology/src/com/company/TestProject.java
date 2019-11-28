package com.company;
import java.util.Scanner;

public class TestProject {
    public static void main(String[] args) {
        int[] arr = readArr();
        System.out.print("Массив до сортировки: ");
        printArr(arr);
        arr = sort(arr);
        System.out.print("Массив после сортировки: ");
        printArr(arr);
    }
    public static int[] readArr () {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число элементов массива:");
        int n = in.nextInt();
        while(n<=0) {
            System.out.println("Введите положительное число:");
            n = in.nextInt();
        }
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        return arr;
    }
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }

    public static int[] sort(int x[]) {
        if (x.length == 1)
            return x;
        else {
            int half = (int) Math.floor(x.length / 2);
            int halfFirst[] = new int[half];
            int halfSecond[] = new int[x.length - half];
            for (int i = 0; i < x.length; i++) {
                if (i < half)
                    halfFirst[i] = x[i];
                else
                    halfSecond[i - half] = x[i];
            }
            halfFirst = sort(halfFirst);
            halfSecond = sort(halfSecond);
            x = sortNext(halfFirst, halfSecond);
            return x;
        }
    }

    public static int[] sortNext(int x[], int y[]) {
        int c[] = new int [x.length + y.length];
        int a = 0, b = 0;
        for (int i = 0; i < x.length + y.length; i++) {
            if (a == x.length) {
                c[i] = y[b];
                b++;
            }
            else if (b == y.length) {
                c[i] = x[a];
                a++;
            }
            else if (x[a] > y[b]) {
                c[i] = y[b];
                b++;
            }
            else {
                c[i] = x[a];
                a++;
            }
        }
        return c;
    }
}
