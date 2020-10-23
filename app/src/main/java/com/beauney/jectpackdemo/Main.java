package com.beauney.jectpackdemo;

/**
 * @author zengjiantao
 * @since 2020-10-22
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {15, 9, 2, 0, 11, 7, 10};
        int target = 21;
        int[] result = findIndex(nums, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    private static int[] findIndex(int[] array, int target) {
        int[] indexs = new int[2];
        for (int i = 0; i < array.length; i++) {
            int diff = target - array[i];
            int index = search(array, diff, i+1);
            if (index > -1) {
                indexs[0] = i;
                indexs[1] = index;
                break;
            }
        }
        return indexs;
    }
    private static int search(int[] array, int key, int start){
        int index = -1;
        for (int i = start; i < array.length; i++) {
            if (array[i] == key){
                index = i;
                break;
            }
        }
        return index;
    }
}
