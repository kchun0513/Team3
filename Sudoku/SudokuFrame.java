package sudoku;

import java.awt.*;
import javax.swing.*;

public class SudokuFrame extends JFrame {
	private SudokuBoard board;
	private InputNumber number;
	private SudokuButton[][] sb;
	private Numberbutton[] nb;
	private int[][] game_board;
	private int board_size;
	private int button_size = 60;
	
	public SudokuFrame(int bs, SudokuBoard b, InputNumber n) {
		board_size = bs;
		sb = new SudokuButton[bs][bs];
		nb = new Numberbutton[bs];
		board = b;
		number = n;
		game_board = b.contents();
		Container c = getContentPane();
		c.setLayout(null);
		for(int i = 0; i < board_size; i++) {
			nb[i] = new Numberbutton(number,this);
			nb[i].setBounds(button_size*(board_size+2), button_size*(i+1), button_size, button_size);
			c.add(nb[i]);
			nb[i].setText(""+(i+1));
		}
		for (int x = 0; x < board_size; x++) 
			for (int y = 0; y < board_size; y++) {
				sb[x][y] = new SudokuButton(x,y, board, this, number);
				sb[x][y].setBounds((x+1)*button_size, (y+1)*button_size, button_size, button_size);
				sb[x][y].setBackground(Color.white);
				c.add(sb[x][y]);
			}
		update();
		setTitle("Sudoku Game");
		setSize((board_size + 4) * button_size, (board_size + 2) * button_size);
		setVisible(true);
	}
	
	/** update - board 업데이트 후 버튼 표시 재설정 */
	public void update() {	
		for (int x = 0; x < board_size; x++) 
			for (int y = 0; y < board_size; y++) {
				if (game_board[x][y] != 0) 
					sb[x][y].setText(""+game_board[x][y]);
				else
					sb[x][y].setText("");
			}
		for (int i = 0; i < board_size; i++) {
			if (i+1 == number.valueOf()) nb[i].setBackground(Color.yellow);
			else nb[i].setBackground(Color.white);
		}
	}
}
