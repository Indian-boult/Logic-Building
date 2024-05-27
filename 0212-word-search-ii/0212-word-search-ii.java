class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
}

    public TrieNode constructer(String[] words) {
        TrieNode root = new TrieNode();
        for(String str : words) {
            TrieNode Node = root;
            for(char c : str.toCharArray()) {
                int ind = c - 'a';
                if(Node.children[ind] == null) {
                    Node.children[ind] = new TrieNode();
                }
                Node = Node.children[ind];
            }
            Node.word = str;
        }

        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length, m = board[0].length;

        List<String> res = new ArrayList<>();
        TrieNode root = constructer(words);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dfs(board, i, j, root, res);
            }
        }

        return res;
    }

    public void dfs(char[][] board, int x, int y, TrieNode root, List<String> res) {
        int n = board.length, m = board[0].length;
        if(x < 0 || x >= n || y < 0 || y >= m || board[x][y] == '*' || root.children[board[x][y] - 'a'] == null) {
            return;
        }
        char c = board[x][y];
        root = root.children[c - 'a'];

        if(root.word != null) {
            res.add(root.word);
            root.word = null;
        }
        board[x][y] = '*';
        dfs(board, x+1, y, root, res);
        dfs(board, x-1, y, root, res);
        dfs(board, x, y+1, root, res);
        dfs(board, x, y-1, root, res);
        board[x][y] = c;
    }
}