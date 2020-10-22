package com.beauney.jectpackdemo;

import java.util.Scanner;

/**
 * @author zengjiantao
 * @since 2020-10-17
 */

public class Main{
    public static void main(String[] args) {
//        char[] array = {'A', 'B', 'C', 'D', 'E'};
        char[] array ={'A'};
        System.out.println("位移前：");
        if (array!=null){
            System.out.println(array);
        }
        char[] result = move(array, Integer.MIN_VALUE);
        System.out.println("位移后：");
        if (result!=null){
            System.out.println(result);
        }
    }

    private static char[] move(char[] array, int fix){
        if (array == null || array.length<=1){
            return array;
        }
        fix = fix % array.length;
        if (fix < 0){
            fix += array.length;
        }
        char[] newArray = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            int position = array.length + i - fix;
            if (position >= array.length){
                position -= array.length;
            }
            newArray[i] = array[position];
        }
        return newArray;
    }
}
/*public class Main{
    public static void main(String[] args) {
        char[] array = {'A', 'B', 'C', 'D', 'E'};
        System.out.println("位移前：");
        System.out.println(array);
        move(array, 2);
        System.out.println("位移后：");
        System.out.println(array);
    }

    private static void move(char[] array, int fix){
        fix = fix % array.length;
//        char[] newArray = new char[array.length];
        for (int j = 0; j < fix; j++) {
            char temp = array[0];
            for (int i = 0; i < array.length; i++) {
                int position = array.length + i - fix;
                if (position >= array.length){
                    position -= array.length;
                }
                array[i] = array[position];
            }
        }

//        return newArray;
    }
}*/
/*public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] array = string.split(" ");
        int x = Integer.parseInt(array[0]);
        int y = Integer.parseInt(array[1]);
        int ctnX = Integer.parseInt(array[2]);
        int ctnY = Integer.parseInt(array[3]);

        int min = ctnX + ctnY;
        int countX = 0;
        int countY = 0;
        for (int i = 1; i <= min; i++) {
            if ((countX < ctnX) && (i % x != 0)){
                countX ++;
            }else if ((countY < ctnY) && (i % y != 0)){
                countY ++;
            }else if (countX == ctnX && countY == ctnY){
                break;
            }else{
                min++;
            }
        }
        System.out.println(min);
    }
}*/

/*public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pString = scanner.nextLine();
        String[] pArray = pString.split(" ");
        String cString = scanner.nextLine();
        String[] cArray = cString.split(" ");

        List<Producer> producers = new ArrayList<>();
        for (int i = 0; i < pArray.length - 1; i++) {
            int time = Integer.parseInt(pArray[i]);
            int content = Integer.parseInt(pArray[++i]);
            producers.add(new Producer(time, content));
        }
//        System.out.println(producers);

        Collections.sort(producers, new Comparator<Producer>() {
            @Override
            public int compare(Producer o1, Producer o2) {
                return o1.time < o2.time ? -1 : o1.time == o2.time ? 0 : 1;
            }
        });
//        System.out.println(producers);


        List<Consumer> consumers = new ArrayList<>();
        for (int i = 0; i < cArray.length - 1; i++) {
            int start = Integer.parseInt(cArray[i]);
            int end = Integer.parseInt(cArray[++i]);
            consumers.add(new Consumer(start, end));
        }
//        System.out.println(consumers);

        for (Producer producer : producers) {
            for (int i = consumers.size() - 1; i >= 0; i--) {
                Consumer consumer = consumers.get(i);
                if (producer.time >= consumer.start && producer.time < consumer.end) {
                    consumer.getContent().append(producer.content).append(" ");
                    break;
                }
            }
        }

        for (Consumer consumer : consumers) {
            String content = consumer.getContent().toString().trim();
            if (content.length() == 0) {
                System.out.println(-1);
            } else {
                System.out.println(content);
            }
        }
    }
}

class Producer {
    int time;
    int content;

    public Producer(int time, int content) {
        this.time = time;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "time=" + time +
                ", content=" + content +
                '}';
    }
}

class Consumer {
    int start;
    int end;
    StringBuilder content;

    public Consumer(int start, int end) {
        this.start = start;
        this.end = end;
        content = new StringBuilder();
    }

    public StringBuilder getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}*/

/*public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int index = scanner.nextInt();
        char[] array = string.toCharArray();
        sort(array);

        char c;
        if (index > string.length()) {
            c = array[array.length - 1];
        } else {
            c = array[index-1];
        }
        System.out.println(string.indexOf(c));
    }

    private static void sort(char[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}*/
