class Solution {// bbbb l = 0, u = 0
    // c = b, set = {b}, sub = "b", longest = "b"; u = 1, l = 0
    // c = b, set = {}, longest = "b", u = 2, l = 1
    // c = b, set = {b}, sub = 
    
    
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int lower = 0, upper = 0, len = s.length();
        int longest = 0;
        
        while (lower < len && upper < len) {
            char c = s.charAt(upper);
            
            if (!set.contains(c)) {
                set.add(c);
                upper++;
                longest = Math.max(longest, s.substring(lower, upper).length());
            } else {
                set.remove(s.charAt(lower));
                lower++;
            }
        }
        
        return longest;
    }
}