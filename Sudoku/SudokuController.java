package sudoku;

import javax.swing.*;

public class SudokuController {
	private SudokuWriter writer;
	private SudokuBoard board;
	
	public SudokuController(SudokuBoard b, SudokuWriter w) {
		writer = w;
		board = b;
	}
	
	public void play() {
		boolean b = true;
		while(b) {
			writer.displaySudoku();
			int y = Integer.parseInt(JOptionPane.showInputDialog("가로 줄 입력(0~3)"));
			int x = Integer.parseInt(JOptionPane.showInputDialog("세로 줄 입력(0~3)"));
			int n = Integer.parseInt(JOptionPane.showInputDialog("숫자 입력(1~4)"));
			board.checkAnswer(x, y, n);
			if (board.returnEmpty() == 0)
				b = false;
		}
		writer.displaySudoku();
		JOptionPane.showMessageDialog(null, "다음에 또 봐요!");
	}
}