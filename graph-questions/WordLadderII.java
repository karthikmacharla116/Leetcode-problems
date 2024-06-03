Problem Link: https://leetcode.com/problems/word-ladder-ii/description/

Intuition: 
  BFS with observations, little tricky compare to Word Ladder I

Solution: Brute Force - Time Limit Eceeded
class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> wordSet = new HashSet(wordList);
        wordSet.remove(beginWord);

        //BFS with observations - Tricky
        Queue<List<String>> queue = new LinkedList();

        queue.add(new ArrayList());
        queue.peek().add(beginWord);

        List<List<String>> ans = new ArrayList();
        bfs(queue, wordSet, ans, endWord);
        return ans;
    }

    void bfs(Queue<List<String>> queue, Set<String> wordSet, List<List<String>> ans, String endWord) {
        if(queue.isEmpty())
            return;
        
        int level = queue.size();
        while(level>0) {
            List<String> list = queue.poll();
            String word = list.get(list.size()-1);

            //check if this word matches with endWord
            if(word.equals(endWord)) {
                ans.add(list);
            } else {
                //check all the strings differ by one character
                Iterator<String> itr = wordSet.iterator();
                while(itr.hasNext()) {
                    String w = itr.next();
                    if(isDifferByOne(word, w)) {
                        list.add(w);
                        queue.add(new ArrayList(list));
                        list.remove(w);
                    }
                }
            }
            level--;
        }

        //After successful insertion of  X level strings remove those from Wordset
        Iterator<List<String>> itr = queue.iterator();
        while(itr.hasNext()) {
            List<String> li = itr.next();
            wordSet.remove(li.get(li.size()-1));
        }
        bfs(queue, wordSet, ans, endWord);
    }

    boolean isDifferByOne(String word1, String word2) {
        int count = 0;
        //comparing character by character
        for(int i=0;i<word1.length();i++) {
            if(word1.charAt(i) != word2.charAt(i))
                count++;
        }
        return count == 1;
    }

}
