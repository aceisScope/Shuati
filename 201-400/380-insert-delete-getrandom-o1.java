class RandomizedSet {
    List<Integer> nums = new ArrayList<>();
    Map<Integer, Integer> index = new HashMap<>();
    Random random = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) { 
        if (index.containsKey(val)) return false;
        // 新元素放到末尾
        index.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!index.containsKey(val)) return false;

        // 把要删除的元素同末尾元素交换并删除
        int lastIndex = nums.size() - 1;
        int valIndex = index.get(val);
        int lastVal = nums.get(lastIndex);

        index.put(lastVal, valIndex);
        nums.set(valIndex, lastVal);
        index.remove(val);
        nums.remove(lastIndex);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int randomVal = random.nextInt(nums.size());
        return nums.get(randomVal);
    }
}