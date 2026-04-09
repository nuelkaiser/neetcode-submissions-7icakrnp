class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            Set<Character> seen = new HashSet<>();

            for(int row = 0; row < 9; row++) {
                if(board[row][i] == '.') continue;

                if(seen.contains(board[row][i])) {
                    return false;
                }
                seen.add(board[row][i]);
            }
        }  

        for(int i = 0; i < 9; i++) {
            Set<Character> seen = new HashSet<>();

            for(int col = 0; col < 9; col++) {
                if(board[i][col] == '.') continue;

                if(seen.contains(board[i][col])) {
                    return false;
                }
                seen.add(board[i][col]);
            }
        }      


        for(int sqr = 0; sqr < 9; sqr++) {
            Set<Character> seen = new HashSet<>();

            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    int row = (sqr / 3) * 3 + i;
                    int col = (sqr % 3) * 3 + j;


                    if(board[row][col] == '.') continue;

                    if(seen.contains(board[row][col])) {
                        return false;
                    }
                    seen.add(board[row][col]);
                }
            }
        }
        return true;
    }
}
