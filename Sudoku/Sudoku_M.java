package sudoku;

import javax.swing.JOptionPane;

public class Sudoku_M {
	
	private int d;
	private int e;
	private Sudoku_C s;
	private int[][] row;
	private int[][] g_row;
	
	public Sudoku_M(int dif) {
		d = dif;
		s = new Sudoku_C(d);
		row = s.RowMaker();
		g_row = s.GameMaker(row);
		e = s.Return_empty();
	}
	
	public void Show_sudoku(int[][] gr, int em) {
		int x,y,n;
		int r = 4;
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < r; j++) {
				System.out.print(g_row[i][j]+" ");
			}
			System.out.println("");
		}
		if (em > 0) {
			x = Integer.parseInt(JOptionPane.showInputDialog("가로 줄 입력(1~4)"));
			y = Integer.parseInt(JOptionPane.showInputDialog("세로 줄 입력(1~4)"));
			n = Integer.parseInt(JOptionPane.showInputDialog("답 입력(1~4)"));
			g_row = s.CheckAnswer(g_row, x-1, y-1, n);
			e = s.Return_empty();
		}
		else {
			JOptionPane.showMessageDialog(null, "다음에 또 봐요!");
			e = -1;
		}
		
		System.out.println("========================");
	}
	
	public int[][] Return_GameRow() {return g_row;}
	public int Return_Empty() {return e;}
}
