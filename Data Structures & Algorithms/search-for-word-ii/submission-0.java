class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isWord;

    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
    }

    public void addWord(String word) {
        TrieNode cur = this;

        for (char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }
}

class Solution {
    private Set<String> res;
    private boolean[][] visited;

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        int ROW = board.length, COL = board[0].length;

        for(String word : words) {
            root.addWord(word);
        }

        res = new HashSet<>();
        visited = new boolean[ROW][COL];

        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                dfs(r, c, board, "", root);
            }
        }

        return new ArrayList<>(res);
    }

    public void dfs(int r, int c, char[][] board, String word, TrieNode node) {
        int ROW = board.length, COL = board[0].length;

        if (r < 0 || c < 0 || r >= ROW || c >= COL || visited[r][c]
            || !node.children.containsKey(board[r][c])) {
            return;
        }

        visited[r][c] = true;
        node = node.children.get(board[r][c]);
        word += board[r][c]; 

        if (node.isWord) {
            res.add(word);
        }

        dfs(r + 1, c, board, word, node);
        dfs(r - 1, c, board, word, node);
        dfs(r, c + 1, board, word, node);
        dfs(r, c - 1, board, word, node);

        visited[r][c] = false;
    }
}
