package sudoku;

import java.awt.event.*;
import javax.swing.*;

public class SudokuButton extends JButton implements ActionListener {
	private SudokuBoard board;
	private InputNumber number;
	private SudokuFrame frame;
	private int x;
	private int y;

	public SudokuButton(int a, int b, SudokuBoard s, SudokuFrame f, InputNumber n) {
		x = a;
		y = b;
		number = n;
		board = s;
		frame = f;
		addActionListener(this);
	}
		
	public void actionPerformed(ActionEvent e) {
		int n = number.valueOf();
		board.checkAnswer(x, y, n);
		frame.update();
	}
}
