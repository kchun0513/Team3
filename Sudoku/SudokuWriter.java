package sudoku;

import java.awt.*;
import javax.swing.*;

/** SudokuWriter displays the contents of a slide puzzle */
public class SudokuWriter extends JPanel {
	private SudokuBoard board;
	//private InputNumber number;
	private int board_size; //스도쿠 보드의 크기
	private int size = 30; // 스도쿠 보드 한 칸의 크기
	private int panel_width; // 패널의 너비
	private int panel_height; // 패널의 높이
	
	/** Constructor - PuzzleWriter 그래픽스 윈도
	 * @param b - 스도쿠 보드
	 * @param n - InputNumber 객체
	 * @param s - 스도쿠 보드의 크기 */
	public SudokuWriter(SudokuBoard b, int s) {
		board = b;
		//number = new InputNumber();
		board_size = s;
		panel_width = (board_size + 4) * size;
		panel_height = (board_size + 2) * size;
		JFrame f = new JFrame();
		f.getContentPane().add(this);
		f.setTitle("Sudoku Game");
		f.setSize(panel_width+10, panel_height+30);
		f.setVisible(true);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	/** 창에 row 번째 행 col 번째 열의 칸을 그리고 i를 적거나 적지 않음 */
	public void paintPiece(Graphics g, int i, int col, int row) {
		int s = size;
		int x_pos = s * (1+col);
		int y_pos = s * (1+row);
		g.setColor(Color.white);
		g.fillRect(x_pos, y_pos, s, s);
		g.setColor(Color.black);
		g.drawRect(x_pos, y_pos, s, s);
		if (i != 0)
			g.drawString(i + "", x_pos + 10, y_pos + 20);
	}
	
	/** paintComponent - 스도쿠 보드 그림 */
	public void paintComponent(Graphics g) { 
		g.setColor(Color.lightGray);
		g.fillRect(0, 0, panel_width, panel_height);
		int[][] r = board.contents();
		for (int i = 0; i != board_size; i = i + 1) {
			for (int j = 0; j != board_size; j = j + 1) {
				paintPiece(g, r[i][j], i, j);
			}
		}
		for (int i = 1; i <= board_size; i++)
			paintPiece(g, i, board_size + 1, i - 1);
	}
	
	/** displayPuzzle - 현재 상태로 스도쿠 보드를 다시 그림 */
	public void displaySudoku() {
		this.repaint();
	}
}