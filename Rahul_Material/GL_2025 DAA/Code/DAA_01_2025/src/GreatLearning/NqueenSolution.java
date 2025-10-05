package GreatLearning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NqueenSolution {
	public List<List<String>> solveNQueens(int n) {
		// Create n*n character array to represent the dash board
		char[][] board = new char[n][n];
		// initialize

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				board[i][j]='.';
			
		List<List<String>> res = new ArrayList<List<String>>();
		// this array tracks if the queen attacks in row
		int leftRow[] = new int[n];
		// track the lower dia
		int lowerDia[] = new int[2 * n - 1];
		// track to upper dia
		int upperDia[] = new int[2 * n - 1];

		solve(0, board, res, leftRow, lowerDia, upperDia);
		return res;
	}

	private void solve(int col, char[][] board, List<List<String>> res, int[] leftRow, int[] lowerDia, int[] upperDia) {

		if (col == board.length) {
			res.add(construct(board));
			return;
		}
		for (int row = 0; row < board.length; row++)
			if (leftRow[col] == 0 && lowerDia[col + row] == 0 && upperDia[board.length - 1 + col - row] == 0) {
				board[row][col] = 'Q';
				leftRow[col] = 1;
				lowerDia[col + row] = 1;
				upperDia[board.length - 1 + col - row] = 1;
				solve(col + 1, board, res, leftRow, lowerDia, upperDia);
				board[row][col] = '.';
				leftRow[col] = 0;
				lowerDia[col + row] = 0;
				upperDia[board.length - 1 + col - row] = 0;

			}

	}

//Construct Method Which Converts The Solution contain by the Char Array into List
	private List<String> construct(char[][] board) {
		List<String> res = new LinkedList<String>();
		// TODO Auto-generated method stub
		for (int i = 0; i < board.length; i++) {
			String s = new String(board[i]);
			res.add(s);
		}
		return res;
	}
}
