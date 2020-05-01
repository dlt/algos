import java.io.*;
import java.util.*;

/*
Word Count Engine
Implement a document scanning function wordCountEngine, which receives a string document and returns a list of all unique words in it and their number of occurrences, sorted by the number of occurrences in a descending order. If two or more words have the same count, they should be sorted according to their order in the original sentence. Assume that all letters are in english alphabet. You function should be case-insensitive, so for instance, the words “Perfect” and “perfect” should be considered the same word.

The engine should strip out punctuation (even in the middle of a word) and use whitespaces to separate words.

Analyze the time and space complexities of your solution. Try to optimize for time while keeping a polynomial space complexity.

Examples:
input:  document = "Practice makes perfect. you'll only
                    get Perfect by practice. just practice!"

output: [ ["practice", "3"], ["perfect", "2"],
          ["makes", "1"], ["youll", "1"], ["only", "1"], 
          ["get", "1"], ["by", "1"], ["just", "1"] ]
Important: please convert the occurrence integers in the output list to strings (e.g. "3" instead of 3). We ask this because in compiled languages such as C#, Java, C++, C etc., it’s not straightforward to create mixed-type arrays (as it is, for instance, in scripted languages like JavaScript, Python, Ruby etc.). The expected output will simply be an array of string arrays.

Constraints:

[time limit] 5000ms
[input] string document
[output] array.array.string

*/
class Solution {

    static class Entry {
        int count;
        int order;
        String word;

        public Entry(int count, int order, String word) {
            this.count = count;
            this.order = order;
            this.word = word;
        }
    }

    static String[] parse(String document) {
        return document.toLowerCase().replaceAll("\\W", " ").split("\\s+");
    }

    static class EntryComparator implements Comparator<Entry> {
        public int compare(Entry dis, Entry dat) {
            if (dis.count == dat.count) {
                return dis.order - dat.order;
            }
            return dat.count - dis.count;
        }
    }

    static String[][] wordCountEngine(String document) {
        Map<String, Entry> entries = new HashMap<>();
        String[] words = parse(document);

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!entries.containsKey(word)) {
                entries.put(word, new Entry(0, i, word));
            }

            Entry entry = entries.get(word);
            entry.count += 1;
        }

        List<Entry> entryList = new ArrayList<>(entries.values());
        Collections.sort(entryList, new EntryComparator());

        String[][] result = new String[entryList.size()][2];
        for (int i = 0; i < entryList.size(); i++) {
            Entry e = entryList.get(i);
            result[i][0] = e.word;
            result[i][1] = String.valueOf(e.count);
        }
        return result;
    }

    public static void main(String[] args) {

    }

}