# https://leetcode.com/problems/add-and-search-word-data-structure-design/submissions/
class WordDictionary
  class Node
    attr_accessor :terminal
    attr_accessor :children
    
    def initialize()
      @terminal = nil
      @children = Hash.new {|h, k| h[k] = Node.new } 
    end
  end

  def initialize()
    @root = Node.new
  end
  
  def search(word)
    level = [@root]
    for c in word.each_char.to_a
      i = level.size
      while i > 0
        children = level.shift.children
        if c == '.'
          children.values.each { |ch| level.push(ch) }
        else
          level.push(children[c]) if children.key?(c)
        end
        i -= 1
      end
    end
    level.any? { |n| n.terminal != nil }
  end
    
  def add_word(word)
    node = @root
    for c in word.each_char.to_a
      node = node.children[c]
    end
    node.terminal = word
    true
  end
end