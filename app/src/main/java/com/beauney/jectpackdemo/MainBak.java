package com.beauney.jectpackdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainBak {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bf.readLine()) != null) {

            boolean[] stu = new boolean[1001];
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(str);
            for (int i = 0; i < n; i++)
                stu[Integer.parseInt(bf.readLine())] = true;
            for (int i = 0; i < 1001; i++)
                if (stu[i])
                    sb.append(i).append("\n");
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
        }
    }


    static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string1 = scanner.nextLine().toUpperCase();
        String string2 = scanner.nextLine().toUpperCase();
        char[] array = string1.toCharArray();
        char c = string2.charAt(0);
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == c) {
                num++;
            }
        }
        System.out.println(num);
    }*/

    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inString = scanner.nextLine();

        System.out.println(inString);
        System.out.println(getLastLength(inString));
    }

    public static int getLastLength(String string) {
        if (string == null || string.length() == 0) {
            return 0;
        }
        String[] results = string.split(" ");
        System.out.println(Arrays.toString(results));
        System.out.println(results[results.length - 1]);
        if (results.length > 0) {
            return results[results.length - 1].length();
        }
        return 0;
    }*/
}
