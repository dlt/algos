class Solution {

    // (ab)(cd
    public String minRemoveToMakeValid(String s) {
        if (s == null) return "";
        if (s == "") return "";


        char openp = '(';
        char closep = ')';

        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        Set<Integer> charsToRemove = new HashSet<>();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (c == openp) {
                stack.push(i);

            } else if (c == closep) {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    charsToRemove.add(i);
                }
            }
        }

        while (!stack.isEmpty())
            charsToRemove.add(stack.pop());

        StringBuilder b = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            if (!charsToRemove.contains(i)) {
                b.append(chars[i]);
            }
        }

        return b.toString();
    }
}