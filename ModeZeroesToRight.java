class Solution {
    public void _moveZeroes(int[] nums) {
        int p1 = 0, p2 = 1;
        int len = nums.length;
        
        while (p1 < len - 1 && p2 < len) {
            int n1 = nums[p1];
            int n2 = nums[p2];
            
            if (n1 == 0 && n2 != 0) {
                swap(nums, p1, p2);
                if (p1 < len -1) p1++;
                if (p2 < len) p2++;
            } else if (n1 == 0 && n2 == 0) {
                if (p2 < len) p2++;
            } else {
                if (p1 < len - 1) p1++;
                if (p2 < len) p2++;
            }
        }
    }
    public void moveZeroes(int[] nums) {
        int i = -1, j = 0;
        while (++i < nums.length) if (nums[i] != 0) nums[j++] = nums[i];
        while (j < nums.length) nums[j++] = 0;
    }
    
    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}