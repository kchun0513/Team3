package Sudoku;

import javax.swing.*;

public class Sudoku_W {

	public static void main(String[] args) {
		
		int d = Integer.parseInt(JOptionPane.showInputDialog("1. 쉬움, 2. 보통, 3. 어려움"));
		Sudoku_C s = new Sudoku_C(d);
		int[][] row = s.RowMaker();
		int[][] g_row = s.GameMaker(row);
		int e = s.Return_empty();
		int x, y, n;
		
		while (e > 0) {
			
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					System.out.print(g_row[i][j]+" ");
				}
				System.out.println("");
			}
			x = Integer.parseInt(JOptionPane.showInputDialog("가로 줄 입력(1~4)"));
			y = Integer.parseInt(JOptionPane.showInputDialog("세로 줄 입력(1~4)"));
			n = Integer.parseInt(JOptionPane.showInputDialog("답 입력(1~4)"));
			g_row = s.CheckAnswer(g_row, x-1, y-1, n);
			e = s.Return_empty();
			System.out.println("========================");
			
		}
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.print(g_row[i][j]+" ");
			}
			System.out.println("");
		}
		JOptionPane.showMessageDialog(null, "다음에 또 봐요!");

	}

}
