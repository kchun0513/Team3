package Sudoku;

import javax.swing.*;

public class Sudoku_S {

	public static void main(String[] args) {
		int d = Integer.parseInt(JOptionPane.showInputDialog("1. 쉬움, 2. 보통, 3. 어려움"));
		Sudoku_M sm = new Sudoku_M(d);
		int e = sm.Return_Empty();
		int[][] game_row = sm.Return_GameRow();
		while (e > -1) {
			sm.Show_sudoku(game_row, e);
			game_row = sm.Return_GameRow();
			e = sm.Return_Empty();
		}

	}

}
