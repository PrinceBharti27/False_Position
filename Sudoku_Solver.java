package Back_Tracking;

import java.util.Scanner;

public class Sudoku_Solver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] board = new int[n][n];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		System.out.println();
		Sudoku(board, 0, 0);

	}

	public static void Sudoku(int[][] board, int row, int col) {

		if (col == board[0].length) {
			row++;
			col = 0;
		}

		if (row == board.length) {
			Print_Sudoku(board);
			return;
		}
		if (board[row][col] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (isSafe(board, row, col, i)) {
					board[row][col] = i;
					Sudoku(board, row, col + 1);
					board[row][col] = 0;
				}
			}
		} else {
			Sudoku(board, row, col + 1);
		}
	}

	public static boolean isSafe(int[][] board, int row, int col, int ele) {

		for (int i = 0; i < board.length; i++) {
			if (board[i][col] == ele) {
				return false;
			}
		}
		for (int i = 0; i < board[0].length; i++) {
			if (board[row][i] == ele) {
				return false;
			}
		}
		int box_r = row/3;
		int box_c = col/3;
		for(int i = 0 ; i < 3 ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				if(board[box_r*3+i][box_c*3+j] == ele) {
					return false;
				}
			}
		}

		return true;
	}

	public static void Print_Sudoku(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

}
