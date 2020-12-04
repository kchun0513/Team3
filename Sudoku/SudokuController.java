package sudoku;

import javax.swing.*;

public class SudokuController {
	private SudokuFrame frame;
	private SudokuBoard board;

	public SudokuController(SudokuBoard b, SudokuFrame f) {
		frame = f;
		board = b;
	}
	
	public void play() {
		long t1 = System.currentTimeMillis();
		while (board.returnEmpty() > 0) {
			frame.update();
		}
		long t2 = System.currentTimeMillis();
		JOptionPane.showMessageDialog(null, "다음에 또 만나요! \n" + "난이도: " + board.returnDif()
									  + "\n클리어 시간: " + (t2-t1)/1000.00 + " sec");
	}
}
