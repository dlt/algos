# @param {String} s
# @param {String[]} word_dict
# @return {Boolean}
# https://leetcode.com/problems/word-break/
def word_break(string, word_dict)
  helper(string, Set.new(word_dict), 0, {})
end

def helper(string, dict, start, memo)
  return true if start == string.size
  return memo[start] if memo.key?(start)
  
  for i in (start + 1)..string.size
    if dict.member?(string[start...i]) && helper(string, dict, i, memo)
      return memo[start] = true
    end
  end
  return memo[start] = false
end

