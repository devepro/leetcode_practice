class Trie {
    
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(null==curr.trie[c-'a']){
                curr.trie[c-'a'] = new TrieNode();
            }
            curr = curr.trie[c-'a'];
        }
        curr.end = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(null==curr.trie[c-'a']){
                return false;
            }else{
                curr = curr.trie[c-'a'];
            }
        }
        return curr.end;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c: prefix.toCharArray()){
            if(null==curr.trie[c-'a']){
                return false;
            }else{
                curr = curr.trie[c-'a'];
            }
        }
        return true;
    }
}

class TrieNode{
    boolean end;
    TrieNode[] trie = new TrieNode[26];
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */