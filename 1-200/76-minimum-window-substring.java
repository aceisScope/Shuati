class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> goal = new HashMap<>();
        for (char c: t) {
            goal.put(c, goal.getOrDefault(c, 0) + 1);
        }

        int left = 0, start = 0,  minLen = Integer.MAX_VALUE, goalCount = goal.size(); // when goalCount is 0, all the chars in t are contained in the window
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (goal.containsKey(c)) {
                goal.put(c, goal.get(c) - 1);
                if (goal.get(c) == 0) {
                    goalCount--;
                }
            }

            while (goalCount <= 0) {
                char d = s.charAt(left);
                if (right - left + 1 < minLen) {
                    start = left;
                    minLen = right - left + 1;
                }
                left++; 

                if (goal.containsKey(d)) {
                    goal.put(d, goal.get(d) + 1);
                    if (goal.get(d) > 0) {
                        goalCount++;
                    }
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }
}