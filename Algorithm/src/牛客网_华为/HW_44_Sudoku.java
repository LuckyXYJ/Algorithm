package 牛客网_华为;
import java.util.*;

public class HW_44_Sudoku {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[9][9];
        while (sc.hasNext()) {
            for (int i = 0; i < 9; i ++) {
                for (int j = 0; j < 9; j ++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            sudoku(matrix, 0, 0);
            for (int i = 0; i < 9; i ++) {
                for (int j = 0; j < 9; j ++) {
                    if(j == 8) System.out.println(matrix[i][j]);
                    else System.out.print(matrix[i][j] + " ");
                }
            }
        }
    }
    public static boolean sudoku(int[][] matrix, int i, int j) {
        if(i > 8) return true;
        if(matrix[i][j] != 0) {
            if(j < 8 && sudoku(matrix, i, j + 1)) return true; // 未到行位,求解同行下一个
            else if(j >= 8 && sudoku(matrix, i + 1, 0)) return true; // 已到行位,求解下一行第一个
        } else {
            for (int num = 1; num <= 9; num ++) {
                if(check(matrix, i, j, num)) {
                    matrix[i][j] = num;
                    if(j < 8 && sudoku(matrix, i, j + 1)) return true;
                    else if(j >= 8 && sudoku(matrix, i + 1, 0)) return true;
                    matrix[i][j] = 0; // 回溯
                }
            }
        }
        return false;
    }
    // 检查行、列、3*3格
    public static boolean check(int[][] matrix, int i, int j, int num) {
        if(check_row(matrix, i, j, num) && check_col(matrix, i, j, num) && check_3_by_3(matrix, i, j, num)) return true;
        return false;
    }
    // 检查所在行
    public static boolean check_row(int[][] matrix, int i, int j, int num) {
        for (int k = 0; k < 9; k ++) {
            if(matrix[i][k] == num) return false;
        }
        return true;
    }
    // 检查所在列
    public static boolean check_col(int[][] matrix, int i, int j, int num) {
        for (int k = 0; k < 9; k ++) {
            if(matrix[k][j] == num) return false;
        }
        return true;
    }
    // 检查所在3*3格
    public static boolean check_3_by_3(int[][] matrix, int i, int j, int num) {
        int row_from = i / 3 * 3;
        int row_to = row_from + 2;
        int col_from = j / 3 * 3;
        int col_to = col_from + 2;
        for (int x = row_from; x <= row_to; x ++) {
            for (int y = col_from; y <= col_to; y ++) {
                if(matrix[x][y] == num) return false;
            }
        }
        return true;
    }
    /*


    * */
}


//DFS算法

/*
import java.util.*;

public class Main {

	public static void main(String[] args) {
		int[][] board = new int[9][9];
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < board[0].length; i++)
			for (int j = 0; j < board.length; j++)
				board[i][j] = in.nextInt();
		in.close();
		solveSudoku(board);
		for (int i = 0; i < board[0].length; i++) {
			for (int j = 0; j < board.length - 1; j++)
				System.out.print(board[i][j] + " ");
			System.out.println(board[i][board.length - 1]);
		}

	}

	static int solveSudoku(int[][] board) {
		int depth = 0;
		for (int i[] : board)
			for (int j : i)
				if (j == 0)
					depth++;
		return dfs(board, depth);
	}

	static int dfs(int[][] board, int depth) {
		if (depth == 0)
			return 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 0) {
					for (int k = 1; k <= 10; k++) {
						if (k == 10)
							return depth;
						board[i][j] = k;
						if (!isValid(board, i, j))
							board[i][j] = 0;
						else {
							depth--;
							depth = dfs(board, depth);
							if (depth == 0)
								return depth;
							depth++;
							board[i][j] = 0;
						}
					}
				}
			}
		}
		return depth;
	}

	static boolean isValid(int[][] board, int row, int col) {
		boolean[] check = new boolean[10];
		for (int i = 0; i < check.length; i++)
			check[i] = true;
		for (int i = 0; i < board[0].length; i++) {
			if (check[board[row][i]])
				check[board[row][i]] = false;
			else if (board[row][i] != 0)
				return false;
		}

		for (int i = 0; i < check.length; i++)
			check[i] = true;
		for (int i = 0; i < board.length; i++) {
			if (check[board[i][col]])
				check[board[i][col]] = false;
			else if (board[i][col] != 0)
				return false;
		}

		for (int i = 0; i < check.length; i++)
			check[i] = true;
		int rowTemp = (row / 3) * 3;
		int colTemp = (col / 3) * 3;
		for (int k = 0; k < 9; k++) {
			row = rowTemp + k / 3;
			col = colTemp + k % 3;
			if (check[board[row][col]])
				check[board[row][col]] = false;
			else if (board[row][col] != 0)
				return false;
		}
		return true;
	}
}
* */