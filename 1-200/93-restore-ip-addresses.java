class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<String> ip = new ArrayList<>();
        dfs(res, ip, s, 0);
        return res;
    }

    void dfs(List<String> res, List<String> ip, String s, int start) {
        if (ip.size() == 4 && start == s.length()) {
            res.add(ip.get(0) + "." + ip.get(1) + "." + ip.get(2) + "." + ip.get(3));
            return;
        }

        if (s.length() - start > (4 - ip.size()) * 3) return;
        if (s.length() - start < 4 - ip.size()) return;

        int num = 0;
        for (int i = start; i < 3 && i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) - '0');

            if (num < 0 || num > 255) continue;

            ip.add(s.subString(start,i + 1));
            dfs(res, ip, s, i + 1);
            ip.remove(ip.size() - 1);

            if (num == 0) break;   // 只可以首位为0
        }
    }
}