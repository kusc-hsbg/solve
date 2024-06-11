import java.util.*;

public class _2239 {

    private static final int SIZE = 9;
    private static int[][] board = new int[SIZE][SIZE];
    private static List<int[]> emptyCells = new ArrayList<>();
    private static boolean[][] rows = new boolean[SIZE][SIZE + 1];
    private static boolean[][] cols = new boolean[SIZE][SIZE + 1];
    private static boolean[][] boxes = new boolean[SIZE][SIZE + 1];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        for (int i = 0; i < SIZE; i++) {
            String line = scanner.next();
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = line.charAt(j) - '0';
                if (board[i][j] == 0) {
                    emptyCells.add(new int[]{i, j});
                } else {
                    int num = board[i][j];
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[boxIndex(i, j)][num] = true;
                }
            }
        }
        
        scanner.close();

        if (solveSudoku(0)) {
            printBoard();
        } else {
            System.out.println("No solution exists");
        }
    }

    private static boolean solveSudoku(int index) {
        if (index == emptyCells.size()) {
            return true;
        }

        int[] cell = emptyCells.get(index);
        int row = cell[0];
        int col = cell[1];

        for (int num = 1; num <= 9; num++) {
            if (isValid(row, col, num)) {
                placeNumber(row, col, num);
                if (solveSudoku(index + 1)) {
                    return true;
                }
                removeNumber(row, col, num);
            }
        }
        return false;
    }

    private static void placeNumber(int row, int col, int num) {
        board[row][col] = num;
        rows[row][num] = true;
        cols[col][num] = true;
        boxes[boxIndex(row, col)][num] = true;
    }

    private static void removeNumber(int row, int col, int num) {
        board[row][col] = 0;
        rows[row][num] = false;
        cols[col][num] = false;
        boxes[boxIndex(row, col)][num] = false;
    }

    private static boolean isValid(int row, int col, int num) {
        return !rows[row][num] && !cols[col][num] && !boxes[boxIndex(row, col)][num];
    }

    private static int boxIndex(int row, int col) {
        return (row / 3) * 3 + col / 3;
    }

    private static void printBoard() {
        for (int r = 0; r < SIZE; r++) {
            for (int d = 0; d < SIZE; d++) {
                System.out.print(board[r][d]);
            }
            System.out.println();
        }
    }
}
