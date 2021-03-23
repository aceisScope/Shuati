class Solution {
    // 通过映射，把黑名单中的数字都“交换”到区间 [size, N), 这样 [0, size)都是有效数字
    int size; 
    Map<Integer, Integer> mapping = new HashMap<>();
    Random random = new Random();

    public Solution(int N, int[] blacklist) {
        size = N - blacklist.length;
        for (int b: blacklist) {
            mapping.put(b, 666);
        }

        int last = N - 1;
        for (int b: blacklist) {
            if (b >= size) continue; // 如果 b 已经在区间 [sz, N) 就忽略

            while (mapping.containsKey(last)) {
                last--;
            }
            mapping.put(b, last);
            last--;
        }
    }

    public int pick() {
        int pick = randomVal.nextInt(size);
        if (mapping.containsKey(pick)) {
            return mapping(pick);
        }

        return pick;
    }
}