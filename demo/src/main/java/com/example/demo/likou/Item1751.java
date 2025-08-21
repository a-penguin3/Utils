package com.example.demo.likou;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Item1751 {

    class meeting {
        private int[] time;
        private int value;

        meeting(int[] time, int value) {
            this.time = time;
            this.value = value;
        }

        public int[] getTime() {
            return time;
        }

        public int getValue() {
            return value;
        }

        public void setTime(int[] time) {
            this.time = time;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }


    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(e -> e[1]));
        int n = events.length;
//        meeting[] meetings = new meeting[events.length];
        int maxValue = 0;
        int[] c = new int[k];
        for (int i = 0; i < k; i++) {
            if (events[i][2] > maxValue) {
                maxValue = events[i][2];
                c[0] = events[i][0];
                c[1] = events[i][1];
//                meetings[i] = new meeting(c, events[i][3]);
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        Item1751 item1751 = new Item1751();
        int[][] events = {{1, 2, 4}, {3, 4, 3}, {2, 3, 1}};
        System.out.println(item1751.maxValue(events, 3));
    }
}
