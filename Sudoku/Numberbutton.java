package sudoku;

import java.awt.event.*;
import javax.swing.*;

public class Numberbutton extends JButton implements ActionListener {
	
	private InputNumber number;
	private SudokuFrame frame;
	
	public Numberbutton(InputNumber n, SudokuFrame f) {
		number = n;
<<<<<<< HEAD
		frame = f;
=======
		view = v;
>>>>>>> 5ee8e68affbe991a3403d3fdd95be1edcb3362b0
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String s = getText();
		number.select(Integer.parseInt(s));
		frame.number_update(number.valueOf());
		System.out.println(""+number.valueOf());
	}
}
