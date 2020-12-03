package sudoku;

import javax.swing.*;

public class Sudoku_C {
	private int[][] Row = new int[4][4];
	private int empty;
	private int d;
	
	public Sudoku_C(int difficulty) {
		d = difficulty;
	}
	
	//답안 배열 제작
	public int[][] RowMaker() {
		
		Row[0][0] = 0;
		Row[0][1] = 0;
		Row[0][2] = 0;
		Row[0][3] = 0;
		int i = 0;
		int n;
		int r = 4;
		
		//첫째 줄
		while (i < r) {
			boolean check1 = true;
			n = (int)(Math.random() * 4.0) + 1;
			for(int j = 0; j < 4; j++) {
				if (Row[0][j] == n) {
					check1 = false;
					break;
				}
			}
			if (check1) {
				Row[0][i] = n;
				i++;
			}
		}
		
		//둘째 줄
		Row[1][0] = Row[0][2];
		Row[1][1] = Row[0][3];
		Row[1][2] = Row[0][0];
		Row[1][3] = Row[0][1];
		
		//셋째 줄
		Row[2][0] = Row[0][1];
		Row[2][1] = Row[0][0];
		Row[2][2] = Row[0][3];
		Row[2][3] = Row[0][2];
		
		//넷째 줄
		Row[3][0] = Row[2][2];
		Row[3][1] = Row[2][3];
		Row[3][2] = Row[2][0];
		Row[3][3] = Row[2][1];
		
		
		return Row;
	}
	
	//게임용 배열 제작
	public int[][] GameMaker(int[][] row) {
		int r = 4;
		
		int [][] GameRow = new int[r][r];
		
		for(int m = 0; m<r; m++) 
			for(int n = 0; n<r;n++)
				GameRow[m][n] = row[m][n];

			
		int i = 0;
		int x, y;
		
		if (d == 1) empty = 6;
		if (d == 2) empty = 8;
		if (d == 3) empty = 10;
		
		while (i<empty) {
			x = (int)(Math.random() * 4.0);
			y = (int)(Math.random() * 4.0);
			if (GameRow[x][y] != 0) {
				GameRow[x][y] = 0;
				i++;
			}
		}
		
		return GameRow;
	}
	
	//답 확인
	public int[][] CheckAnswer(int[][] g_row, int h, int v, int a) {
		int[][] GameRow = g_row;
		if (a == Row[h][v] && GameRow[h][v] == 0) {
			GameRow[h][v] = Row[h][v];
			empty--;
			return GameRow;
		}
		else if(GameRow[h][v] != 0) {
			JOptionPane.showMessageDialog(null, "이미 숫자가 채워져 있습니다.");
			return GameRow;
		}
		else {
			JOptionPane.showMessageDialog(null, "틀렸습니다. 다시 시도해보세요.");
			return GameRow;
		}	
	}
	
	public int Return_empty() { return empty; }
}
