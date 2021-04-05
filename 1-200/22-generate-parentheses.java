class Solution {
    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generate(0, 0, "", n);
        return list;
    }

    void generate(int left, int right, String res, int n) {
        if (left == n && right == n) {
            list.add(res);
            return;
        }

        if (left < n) {
            generate(left + 1, right, res + "(", n);
        } 

        if (left > right && right < n) {
            generate(left, right + 1, res + ")", n);
        }
    }
}