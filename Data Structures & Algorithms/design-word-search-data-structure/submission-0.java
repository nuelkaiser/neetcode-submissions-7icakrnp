class TrieNode {
    TrieNode[] children;
    boolean word;

    public TrieNode() {
        children = new TrieNode[26];
        word = false;
    }
}

class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.word = true;
    }

    public boolean search(String word) {
        return dfs(0, word, root);
    }

    public boolean dfs(int j, String word, TrieNode root) {
        TrieNode curr = root;

        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c == '.') {
                for (TrieNode child : curr.children) {
                    if (child != null && dfs(i + 1, word, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (curr.children[c - 'a'] == null) {
                    return false;
                }
                curr = curr.children[c - 'a'];
            }
        }
        return curr.word;
    }
}
