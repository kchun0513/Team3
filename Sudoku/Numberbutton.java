package sudoku;

import java.awt.event.*;
import javax.swing.*;

public class Numberbutton extends JButton implements ActionListener {
	private InputNumber number;
	private SudokuFrame frame;
	
	public Numberbutton(InputNumber n, SudokuFrame f) {
		number = n;
		frame = f;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String s = getText();
		number.select(Integer.parseInt(s));
	}
}
