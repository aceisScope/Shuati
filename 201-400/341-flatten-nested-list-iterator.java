public class NestedIterator implements Iterator<Integer> {
    private LinkedList<NestedInteger> list;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new LinkedList<NestedInteger>(nestedList);
    }

    @Override
    public Integer next() {
        return list.remove(0).getInterger();
    }

    @Override
    public boolean hasNext() {
        while (!list.isEmpty() && !list.get(0).isInterger()) {
            List<NestedInteger> first = list.remove(0).getList();
            for (int i = first.size() - 1; i >= 0; i--) {
                list.addFirst(first.get(i));
            }
        }

        return !list.isEmpty();
    }
}