class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] count = new int[256];
        boolean[] inStack = new int[256];

        char[] charArray = s.toCharArray();

        for (char c: charArray) {
            count[c]++;
        }

        for (char c: charArray) {
            count[c]--;
            if (inStack[c]) continue;

            // 连续 pop 出比当前字符小的栈顶字符，直到栈顶元素比当前元素的字典序还小为止
            while (!inStack.isEmpty() && stack.peek() > c) {
                if (count[stack.peek()] == 0) break; // 若c之后不存在栈顶元素了，则停止 pop
                inStack[stack.pop()] = false; 
            }
            stack.push(c);
            inStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}