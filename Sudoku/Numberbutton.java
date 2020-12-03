package sudoku;

import java.awt.event.*;
import javax.swing.*;

public class Numberbutton extends JButton implements ActionListener {
	private InputNumber number;
	private SudokuFrame view;
	
	public Numberbutton(InputNumber n, SudokuFrame v) {
		number = n;
		view = v;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String s = getText();
		number.select(Integer.parseInt(s));
		//view.update();
	}
}
