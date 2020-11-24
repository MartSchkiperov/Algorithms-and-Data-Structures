package ee.ttu.algoritmid.hackathon;

import java.util.*;

public class NodeOperationsSpeed {

    public static void main(String[] args) {
        SmallNode s = new SmallNode(new Participant(0));
        s.list.add(new Participant(5));
        int thousandCycles = 2_000_000_000;

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < thousandCycles; i++) {
            for (int j = 0; j < 1000; j++) {
                int a = s.getExtroversion1() + 5;
            }
        }
        long stopTime = System.currentTimeMillis();
        System.out.println("s.getExtroversion1(): " + (stopTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < thousandCycles; i++) {
            for (int j = 0; j < 1000; j++) {
                int a = s.getList().get(0).getExtroversion2() + 5;
            }
        }
        stopTime = System.currentTimeMillis();
        System.out.println("s.getList().get(0).getExtroversion2(): " + (stopTime - startTime) + "ms");
    }


    public static class SmallNode {
        int extroversion = 5;
        Participant participant;
        List<Participant> list = new ArrayList<>();

        public SmallNode(Participant patricipant) {
            this.participant = participant;
        }

        public int getExtroversion1() {
            return extroversion;
        }

        public List<Participant> getList() {
            return list;
        }
    }

    public static class Participant {
        int extroversion;

        public Participant(int extroversion) {
            this.extroversion = extroversion;
        }

        public int getExtroversion2() {
            return extroversion;
        }
    }
}
