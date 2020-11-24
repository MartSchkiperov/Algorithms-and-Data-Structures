package ee.ttu.algoritmid.hackathon;

import java.util.*;

public class NodeOperationsSpeed {

    public static void main(String[] args) {
        SmallNode s = new SmallNode();
        int thousandCycles = 2_000_000_000;

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < thousandCycles; i++) {
            for (int j = 0; j < 1000; j++) {
                int a = s.getValue() + 5;
            }
        }
        long stopTime = System.currentTimeMillis();
        System.out.println("getValue(): " + (stopTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < thousandCycles; i++) {
            for (int j = 0; j < 1000; j++) {
                int a = (int) s.getList().get(0) + 5;
            }
        }
        stopTime = System.currentTimeMillis();
        System.out.println("getList().get(0): " + (stopTime - startTime) + "ms");
    }


    public static class SmallNode {
        int value = 5;
        List<Integer> list = Arrays.asList(1, 2);

        public int getValue() {
            return value;
        }

        public List getList() {
            return list;
        }
    }
}
