class Solution {
    public boolean isValidSudoku(char[][] board) {
        /*
         ->Check all rows
         ->Check all columns
         ->Check all 3 x 3 boxes
        */

        // Validate each row
        for (int row = 0; row < 9; row++) {
            Set<Character> seen = new HashSet<>();

            for (int col = 0; col < 9; col++) {
                char cell = board[row][col];
                if (cell == '.') {
                    continue; // empty cell skip
                }
                // HashSet.add() returns false if elemnt already exists
                // Means duplicate is found hence invalid
                if (!seen.add(cell))
                    return false;
            }
        }

        // Validate each column
        for (int col = 0; col < 9; col++) {
            Set<Character> seen = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                char cell = board[row][col];
                if (cell == '.') {
                    continue;
                }
                if (!seen.add(cell))
                    return false;
            }
        }

        // Validate 3 x 3 Box
        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {
                Set<Character> seen = new HashSet<>();

                // Top-left corner of this 3x3 box
                int startRow = boxRow * 3;
                int startCol = boxCol * 3;

                // Walk the 9 cells inside this box
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char cell = board[startRow + i][startCol + j];

                        if (cell == '.')
                            continue;

                        if (!seen.add(cell))
                            return false;
                    }
                }
            }
        }

        return true;
    }
}
