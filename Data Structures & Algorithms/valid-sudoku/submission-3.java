class Solution {

    public boolean isValidSudoku(char[][] board) {

        // ============================================================
        // NAIVE APPROACH: Three separate passes
        // - Pass 1: Check all rows
        // - Pass 2: Check all columns
        // - Pass 3: Check all 3x3 boxes
        //
        // Time:  O(1) — board is always 9x9, so it's constant
        // Space: O(1) — sets never hold more than 9 elements
        // ============================================================


        // ── PASS 1: Validate each ROW ────────────────────────────────
        for (int row = 0; row < 9; row++) {

            Set<Character> seen = new HashSet<>();

            for (int col = 0; col < 9; col++) {
                char cell = board[row][col];

                if (cell == '.') continue; // empty cell → skip

                // HashSet.add() returns FALSE if element already exists
                // → that means we found a duplicate → board is invalid
                if (!seen.add(cell)) return false;
            }
        }


        // ── PASS 2: Validate each COLUMN ────────────────────────────
        for (int col = 0; col < 9; col++) {

            Set<Character> seen = new HashSet<>();

            for (int row = 0; row < 9; row++) {
                char cell = board[row][col];

                if (cell == '.') continue;

                if (!seen.add(cell)) return false;
            }
        }


        // ── PASS 3: Validate each 3x3 BOX ───────────────────────────
        //
        //  Box layout (boxIndex = (row/3)*3 + col/3):
        //  ┌───────┬───────┬───────┐
        //  │   0   │   1   │   2   │  row 0-2
        //  ├───────┼───────┼───────┤
        //  │   3   │   4   │   5   │  row 3-5
        //  ├───────┼───────┼───────┤
        //  │   6   │   7   │   8   │  row 6-8
        //  └───────┴───────┴───────┘
        //
        //  boxRow = which "band" of boxes  (0, 1, or 2)
        //  boxCol = which box in that band (0, 1, or 2)
        //  We iterate cells inside the box using startRow + i, startCol + j

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

                        if (cell == '.') continue;

                        if (!seen.add(cell)) return false;
                    }
                }
            }
        }

        return true; // Passed all three checks → valid board
    }

}
