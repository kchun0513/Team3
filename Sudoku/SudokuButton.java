package sudoku;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SudokuButton extends JButton implements ActionListener{
	
	private SudokuBoard board;
	private SudokuFrame frame;
	private int x;
	private int y;

	public SudokuButton(int a, int b, SudokuBoard n, SudokuFrame f) {
		x = a;
		y = b;
		board = n;
		frame = f;
		addActionListener(this);
	}
		
	public void actionPerformed(ActionEvent e) {
		int n = frame.return_input();
		board.checkAnswer(x, y, n);
		frame.update();
		System.out.println("적용 완료!");
	}
	
	
}
