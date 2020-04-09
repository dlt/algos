/*
https://leetcode.com/problems/relative-sort-array/
*
*/
class Solution {
    class C implements Comparable<C> {
        int val;
        int order;
        
        public C(int val, int order) {
            this.val = val;
            this.order = order;
        }
        
        public int compareTo(C other) {
            return order - other.order;
        }
    }
    
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Queue<C> queue = new PriorityQueue();
        List<Integer> list = Arrays.stream(arr2).boxed().collect(Collectors.toList());
        
        int len = arr2.length;
        
        for (int el: arr1) {
            int order = list.indexOf(el) != -1 ? list.indexOf(el) : len + el;
            queue.offer(new C(el, order));
        }
        
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = queue.poll().val;
        }
        return arr1;
    }
}