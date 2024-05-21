package Medium;

import java.util.*;

public class OpenTheLock {
    static class Pair {
        char[] val;
        int steps;
        private Pair(char[] val, int steps) {
            this.steps = steps;
            this.val = val;
        }
        public static Pair create(char[] val, int steps) {
            return new Pair(val, steps);
        }
    }

    private char[] nextVal(char[] value, int i) {
        char[] val = new char[4];
        System.arraycopy(value, 0, val, 0, 4);
        return switch (i) {
            case 0 -> {
                int t = val[0] - '0';
                if (t == 9) t = 0;
                else t++;
                val[0] = (char) ('0' + t);
                yield val;
            }
            case 1 -> {
                int t = val[1] - '0';
                if (t == 9) t = 0;
                else t++;
                val[1] = (char) ('0' + t);
                yield val;
            }
            case 2 -> {
                int t = val[2] - '0';
                if (t == 9) t = 0;
                else t++;
                val[2] = (char) ('0' + t);
                yield val;
            }
            case 3 -> {
                int t = val[3] - '0';
                if (t == 9) t = 0;
                else t++;
                val[3] = (char) ('0' + t);
                yield val;
            }
            case 4 -> {
                int t = val[0] - '0';
                if (t == 0) t = 9;
                else t--;
                val[0] = (char) ('0' + t);
                yield val;
            }
            case 5 -> {
                int t = val[1] - '0';
                if (t == 0) t = 9;
                else t--;
                val[1] = (char) ('0' + t);
                yield val;
            }
            case 6 -> {
                int t = val[2] - '0';
                if (t == 0) t = 9;
                else t--;
                val[2] = (char) ('0' + t);
                yield val;
            }
            case 7 -> {
                int t = val[3] - '0';
                if (t == 0) t = 9;
                else t--;
                val[3] = (char) ('0' + t);
                yield val;
            }
            default -> val;
        };
    }

    public int openLock(String[] deadends, String target) {
        char[] value = "0000".toCharArray();
        Map<String, Integer> dEnds = new HashMap<>();
        for (int i = 0; i < deadends.length; i++) dEnds.put(deadends[i], i);
        if (dEnds.containsKey(target)) return -1;
        if (target.equals("0000")) return 0;
        Queue<Pair> cache = new LinkedList<>();
        cache.add(new Pair(value, 0));
        Set<String> visited = new HashSet<>();
        Pair current;
        while (!cache.isEmpty()) {
            current = cache.poll();
            String temp = new String(current.val);
            if (temp.equals(target)) {
                return current.steps;
            }
            if (dEnds.containsKey(temp)) continue;
            visited.add(temp);
            for (int i = 0; i < 8; i++) {
                char[] next = nextVal(current.val, i);
                if (!visited.contains(new String(next)))
                    cache.add(Pair.create(next, current.steps + 1));
            }
        }
        return -1;
    }

}
