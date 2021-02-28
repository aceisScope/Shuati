class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length())
            return false;

        Map<Character, Integer> goal = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c: s1.toCharArray()) {
            goal.put(c, goal.getOrDefault(c, 0)+ 1);
        }

        int left = 0, right = 0, valid = 0;
        while (right < s2.length) {
            char c = s2.charAt(right);
            right++;

            if (goal.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (goal.get(c).equals(window.get(c))) 
                    valid++;
            }

            while (right - left >= s1.length()) { // 缩小窗口的时机是窗口大小大于 s1.size() 时
                if (valid == goal.size()) 
                    return true;

                char d = s2.charAt(left);
                left++;
                if (goal.containsKey(c)) {
                    if (goal.get(d).equals(window.get(d))) 
                        valid--;
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }

        return false;
    }
}