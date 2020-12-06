package sudoku;

import javax.swing.*;

public class SudokuStarter {

	public static void main(String[] args) {
		int board_size = 4;
		int d = Integer.parseInt(JOptionPane.showInputDialog("1. 쉬움, 2. 보통, 3. 어려움"));
		SudokuBoard board = new SudokuBoard(d, board_size);
		//SudokuWriter writer = new SudokuWriter(board, board_size);
		SudokuFrame frame = new SudokuFrame(board_size,board,new InputNumber());
		SudokuController controller = new SudokuController(board, frame);
		controller.play();
	}
}
