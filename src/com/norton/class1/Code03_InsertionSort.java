package com.norton.class1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Code03_InsertionSort {
    public static void swap(int[] arr,int i,int j){
        arr[i]=arr[i] ^ arr[j];
        arr[j]=arr[i] ^ arr[j];
        arr[i]=arr[i] ^ arr[j];
    }

    public static void insertSort(int[] arr){
        if (arr==null||arr.length<2)
            return;
        for (int i = 1; i <arr.length ; i++) {
            for (int j = i; j >0 &&
                     arr[j]<arr[j-1] ; j--) {
                    swap(arr,j,j-1);
            }
        }
    }
    public static int[] generateRandomArray(int maxSize,int maxValue){
        int[] arr=new int[(int) ((maxSize+1)*Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= (int) ((int) ((maxValue+1)*Math.random())-maxValue*Math.random());
        }
        return arr;
    }

    //for test
    public static void comparotor(int[] arr){
        Arrays.sort(arr);
    }

    //for test
    public static int[] copy(int[] arr){
        if (arr==null)
            return null;
        int[] res=new int[arr.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    //for test
    public static boolean isEqual(int [] arr1,int[] arr2){
        if (arr1==null&&arr2!=null || arr1!=null&&arr2==null)
            return false;
        if (arr1==null && arr2==null)
            return true;
        if (arr1.length!=arr2.length)
            return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i]!=arr2[i])
                return false;
        }
        return true;
    }

    public static void prinArray(int[] arr){
        if (arr==null)
            return;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testTime=10000;
        int maxSize=100;
        int maxValue=200;
        boolean success=true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1=generateRandomArray(maxSize,maxValue);
            int[] arr2=copy(arr1);
            insertSort(arr1);
            comparotor(arr2);
            if (!isEqual(arr1,arr2)){
                success=false;
                prinArray(arr1);
                prinArray(arr2);
                break;
            }
        }
        System.out.println(success ? "Nice":"Fucking fucked!");
        int[] arr=generateRandomArray(maxSize,maxValue);
        prinArray(arr);
        insertSort(arr);
        prinArray(arr);

    }
}
