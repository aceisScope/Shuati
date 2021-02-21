class Solution {
    LinkedList<List<String>> result = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) { 
        int[] track = new int[n]; // 第n行的Q在第几列
        backtrace(n, 0, track);
        return result;
    }

    public void backtrace(int n, int row, int[] track) {
        if (row == n) {
            result.add(buildLine(n, track));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col, track)) {
                track[row] = col;
                backtrace(n, row + 1, track);
            }
        }
    }

    // 判断放置Q在第row行的col位置，是否与之前行有冲突
    public boolean isValid(int row, int col, int[] track) {
        for (int i = 0; i < row; i++) {
            int pos = track[i];
            if (post == col || pos + row - i == col || pos - row + 1 == col) {
                return false;
            }
        }

        return true;
    }

    public List<String> buildLine(int n, int[] track) {
        LinkedList<String> line = new LinkedList<>();
        for (int row = 0; row < n; row++) {
            String str = "";
            for (int col = 0; col < n; col++) {
                if (trackp[row] == col) {
                    str += "Q";
                } else {
                     str += ".";
                }
            }
        }
    }
}