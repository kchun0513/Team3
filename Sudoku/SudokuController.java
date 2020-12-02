package Sudoku;

import javax.swing.*;

public class SudokuController {
	private SudokuWriter writer;
	private SudokuBoard board;
	private int x;
	private int y;
	private int n;
	
	public SudokuController(SudokuBoard b, SudokuWriter w) {
		writer = w;
		board = b;
	}
	
	public void play() {
		
		boolean b = true;
		while(b) {
			GetNum();
			writer.displaySudoku();
			while (!((0 < x && x < 5) && (0 < y && y < 5) && (0 < n && n < 5))) {
				JOptionPane.showMessageDialog(null, "주어진 범위 내의 숫자를 입력해주세요!");
				GetNum();
			}
			board.checkAnswer(x-1, y-1, n);
			if (board.returnEmpty() == 0)
				b = false;
		}
		writer.displaySudoku();
		JOptionPane.showMessageDialog(null, "다음에 또 봐요!");
	}
	
	public void GetNum() {
		y = Integer.parseInt(JOptionPane.showInputDialog("가로 줄 입력(1~4)"));
	 	x = Integer.parseInt(JOptionPane.showInputDialog("세로 줄 입력(1~4)"));
	    n = Integer.parseInt(JOptionPane.showInputDialog("숫자 입력(1~4)"));
	}
}