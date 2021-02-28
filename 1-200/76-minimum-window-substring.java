class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> goal = new HashMap<>(); // 记录t中每个字符各出现多少次
        Map<Character, Integer> window = new HashMap<>(); // 记录窗口中包含t的每个字符各多少次
        for (char c: t.toCharArray()) {
            goal.put(c, goal.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, start = 0,  minLen = Integer.MAX_VALUE, valid = 0; // when valid equals to goal.size(), all the chars in t are contained in the window
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if (goal.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (goal.get(c).equals(window.get(c))) { // there are the same number of c's in window and goal, meaning one char in t is found in window
                    valid++;
                }
            }

            while (valid == goal.size()) { // 缩小窗口的时机是窗口含有t中所有字符且数目相符
                // shrink window
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }

                char d = s.charAt(left);
                left++; 

                if (goal.containsKey(d)) {
                    if (goal.get(d).equals(window.get(d)))
                        valid--;           
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }
}   