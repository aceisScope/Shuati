class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<>();
        
        if (p.length() > s.length()) 
            return result;
        
        Map<Character, Integer> goal = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c: p.toCharArray()) {
            goal.put(c, goal.getOrDefault(c, 0) + 1);
        }
        
        int left = 0, right = 0, valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            
            if (goal.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(goal.get(c)))
                    valid++;
            }
            
            while (right - left >= p.length()) {
                if (valid == goal.size()) {
                    result.add(left);
                }
                
                char d = s.charAt(left);
                left++;
                if (goal.containsKey(d)) {
                    if (window.get(d).equals(goal.get(d)))
                        valid--; 
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        
        return result;
    }
}