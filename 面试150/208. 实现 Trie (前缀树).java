class Trie {
    boolean isEnd;
    Trie[] next;

    public Trie() {
        next = new Trie[26];    // 只是创建next的空间,而没有创建next里面元素的空间
        isEnd = false;
    }
    
    public void insert(String word) {
        Trie node = this;
        int n = word.length();
        for(int i=0; i<n; ++i){
            char ch = word.charAt(i);
            if(node.next[ch-'a'] == null){  // 空节点
                node.next[ch-'a'] = new Trie();
            }
            node = node.next[ch-'a'];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        Trie node = this;
        int n = word.length();
        for(int i=0; i<n; ++i){
            char ch = word.charAt(i);
            if(node.next[ch-'a'] == null)
                return false;
            node = node.next[ch-'a'];
        }
        return node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Trie node = this;
        int n = prefix.length();
        for(int i=0; i<n; ++i){
            char ch = prefix.charAt(i);
            if(node.next[ch-'a'] == null)
                return false;
            node = node.next[ch-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
