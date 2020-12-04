package sudoku;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import slidepuzzle.PuzzleButton;


public class SudokuFrame extends JFrame {
	
	private SudokuBoard board;
	private InputNumber number;
	private SudokuButton[][] sb;
	private Numberbutton[] nb;
	private int[][] game_board;
	private int panel_width;
	private int panel_height;
	private int board_size;
	private int size = 60;
	private Container c;
	
	public SudokuFrame(int bs, SudokuBoard b, InputNumber n) {
		board_size = bs;
		sb = new SudokuButton[bs][bs];
		nb = new Numberbutton[bs];
		board = b;
		number = n;
		panel_width = (board_size + 4) * size;
		panel_height = (board_size + 2) * size;
		game_board = b.contents();
		
		c = getContentPane();
		c.setLayout(null);
		for(int i = 0; i < board_size; i++) {
			nb[i] = new Numberbutton(number,this);
			nb[i].setBounds(size*(board_size+2), size*(i+1), size, size);
			c.add(nb[i]);
			nb[i].setText(""+(i+1));
		}
		
		for (int x = 0; x < board_size; x++) 
			for (int y = 0; y < board_size; y++) {
				sb[x][y] = new SudokuButton(x,y, board, this);
				sb[x][y].setBounds((x+1)*size, (y+1)*size, size, size);
				sb[x][y].setBackground(Color.white);
				c.add(sb[x][y]);
			}
		
		update();
		setTitle("Sudoku Game");
		setSize(panel_width, panel_height);
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
		
		System.out.println("update check");
	}
	
	/** return_input - 현재 선택한 숫자
	 * @return 현재 선택한 숫자의 값
	 */
	public int return_input() { return number.valueOf(); }
	
	/** number_update - 새로 선택한 숫자 업데이트
	 * @param num - 새로 선택한 숫자
	 */
	public void number_update(int num) { 
		number.select(num); 
		System.out.println(num);
	}
	

}
