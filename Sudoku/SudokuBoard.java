package sudoku;

import javax.swing.*;

public class SudokuBoard {
	private int[][] answer;
	private int[][] game_board;
	private int board_size = 4;
	private int empty;
	private int difficulty;
	
	public SudokuBoard(int d) {
		difficulty = d;
		if (difficulty == 1) empty = 6;
		else if (difficulty == 2) empty = 8;
		else if (difficulty == 3) empty = 10;
		answer = new int[board_size][board_size];
		game_board = new int[board_size][board_size];
		rowMaker();
		gameBoardMaker();
	}
	
	//정답 배열 제작
	private void rowMaker() {
		//첫째 줄
		for (int i = 0; i != board_size; i++)
			answer[0][i] = i + 1;
		//둘째 줄
		answer[1][0] = answer[0][2];
		answer[1][1] = answer[0][3];
		answer[1][2] = answer[0][0];
		answer[1][3] = answer[0][1];
		//셋째 줄
		answer[2][0] = answer[0][1];
		answer[2][1] = answer[0][0];
		answer[2][2] = answer[0][3];
		answer[2][3] = answer[0][2];
		//넷째 줄
		answer[3][0] = answer[2][2];
		answer[3][1] = answer[2][3];
		answer[3][2] = answer[2][0];
		answer[3][3] = answer[2][1];
		shuffle();
	}
	
	private void shuffle() {
		int i;
		i = (int)(Math.random() * 2);
		if (i == 1) {
			int[] r = answer[0];
			answer[0] = answer[1];
			answer[1] = r;
		}
		i = (int)(Math.random() * 2);
		if (i == 1) {
			int[] r = answer[2];
			answer[2] = answer[3];
			answer[3] = r;
		}
		i = (int)(Math.random() * 2);
		if (i == 1) {
			for (int j = 0; j != board_size; j++) {
				int k = answer[j][0];
				answer[j][0] = answer[j][1];
				answer[j][1] = k;
			}
		}
		i = (int)(Math.random() * 2);
		if (i == 1) {
			for (int j = 0; j != board_size; j++) {
				int k = answer[j][2];
				answer[j][2] = answer[j][3];
				answer[j][3] = k;
			}
		}
	}
	
	//게임용 배열 제작
	private void gameBoardMaker() {
		for (int i = 0; i != board_size; i++)
			for (int j = 0; j != board_size; j++)
				game_board[i][j] = answer[i][j];
		int i = 0;
		int x, y;
		while (i < empty) {
			x = (int)(Math.random() * 4.0);
			y = (int)(Math.random() * 4.0);
			if (game_board[x][y] != 0) {
				game_board[x][y] = 0;
				i++;
			}
		}
	}
	
	//답 입력
	public void checkAnswer(int i, int j, int a) {
		if (a == answer[i][j] && game_board[i][j] == 0) {
			game_board[i][j] = answer[i][j];
			empty--;
		}
		else if(game_board[i][j] != 0) {
			JOptionPane.showMessageDialog(null, "이미 숫자가 채워져 있습니다.");
		}
		else {
			JOptionPane.showMessageDialog(null, "틀렸습니다. 다시 시도해보세요.");
		}
	}
	 
	public int returnEmpty() { return empty; }
	public String returnDif() { 
		if (difficulty == 1)
			return "쉬움";
		else if (difficulty == 2)
			return "보통";
		else
			return "어려움";
	}
	public int[][] returnAnswer() { return answer; }
	public int[][] contents() { return game_board; }
}