class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadsets = new HashSet<>();
        for (String s: deadends) {
            deadsets.add(s);
        }

        int step = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        visited.add("0000");

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();

                if (deadsets.contains(cur))
                    continue;
                if (cur.equals(target)) {
                    return step;
                }

                for (int j = 0; j < 4 ; j++) {
                    String plus = plusOne(cur, j);
                    if (!visited.contains(plus)) {
                        q.offer(plus);
                        visited.add(plus);
                    }

                    String minus = minusOne(cur, j);
                    if (!visited.contains(minus)) {
                        q.offer(minusOne);
                        visited.add(minus);
                    }
                }
            }
            step++;
        }

        return -1;
    }

    String plusOne(String s, int j) {
        char[] c = s.toCharArray();
        if (c[j] == '9') {
            c[j] = '0';
        } else {
            c[j]++;
        }

        return  new String(c);
    }

    String minusOne(String s, int j) {
        char[] c = s.toCharArray();
        if (c[j] == '0') {
            c[j] = '9';
        } else {
            c[j]--;
        }

        return  new String(c);
    }
}