package sudoku;

import javax.swing.*;
import java.util.*;

public class SudokuBoard {
	private int[][] answer;
	private int[][] game_board;
	private int board_size;
	private int empty;
	private int difficulty;
	
	public SudokuBoard(int d, int b) {
		difficulty = d;
		board_size = b;
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
		List<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i != board_size; i++)
			a.add(i + 1);
		Collections.shuffle(a);
		for (int i = 0; i != board_size; i++)
			answer[0][i] = a.get(i);
		if (board_size == 4) {
			fillBoard4x4();
			shuffleRibbons(0);
		}
		else if (board_size == 6) {
			fillBoard6x6();
			shuffleRibbons(2);
		}
		else if (board_size == 9) {
			fillBoard9x9();
			shuffleRibbons(0);
		}
		transpose();
		shuffleRibbons(0);
		transpose();
	}
	
	private void fillBoard4x4() {
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
	}
	
	private void fillBoard6x6() {
		int[] a1 = {4,5,6,1,2,3};
		int j = 0;
		for(int i : a1) {
			answer[1][j] = answer[0][i-1];
			j++;
		}
		int[] a2 = {3,1,2,6,4,5};
		j = 0;
		for(int i : a2) {
			answer[2][j] = answer[0][i-1];
			j++;
		}
		int[] a3 = {6,4,5,3,1,2};
		j = 0;
		for(int i : a3) {
			answer[3][j] = answer[0][i-1];
			j++;
		}
		int[] a4 = {2,3,1,5,6,4};
		j = 0;
		for(int i : a4) {
			answer[4][j] = answer[0][i-1];
			j++;
		}
		int[] a5 = {5,6,4,2,3,1};
		j = 0;
		for(int i : a5) {
			answer[5][j] = answer[0][i-1];
			j++;
		}
	}
	
	private void fillBoard9x9() {
		int[] a1 = {4,5,6,7,8,9,1,2,3};
		int j = 0;
		for(int i : a1) {
			answer[1][j] = answer[0][i-1];
			j++;
		}
		int[] a2 = {7,8,9,1,2,3,4,5,6};
		j = 0;
		for(int i : a2) {
			answer[2][j] = answer[0][i-1];
			j++;
		}
		int[] a3 = {2,3,1,5,6,4,8,9,7};
		j = 0;
		for(int i : a3) {
			answer[3][j] = answer[0][i-1];
			j++;
		}
		int[] a4 = {5,6,4,8,9,7,2,3,1};
		j = 0;
		for(int i : a4) {
			answer[4][j] = answer[0][i-1];
			j++;
		}
		int[] a5 = {8,9,7,2,3,1,5,6,4};
		j = 0;
		for(int i : a5) {
			answer[5][j] = answer[0][i-1];
			j++;
		}
		int[] a6 = {3,1,2,6,4,5,9,7,8};
		j = 0;
		for(int i : a6) {
			answer[6][j] = answer[0][i-1];
			j++;
		}
		int[] a7 = {6,4,5,9,7,8,3,1,2};
		j = 0;
		for(int i : a7) {
			answer[7][j] = answer[0][i-1];
			j++;
		}
		int[] a8 = {9,7,8,3,1,2,6,4,5};
		j = 0;
		for(int i : a8) {
			answer[8][j] = answer[0][i-1];
			j++;
		}
	}
	
	private void shuffleRibbons(int a) {
		int[][] r = new int[board_size][board_size];
		for (int i = 0; i != board_size; i++)
			for (int j = 0; j != board_size; j++)
				r[i][j] = answer[i][j];
		List<int[]> a1 = new ArrayList<int[]>();
		List<int[]> a2 = new ArrayList<int[]>();
		List<int[]> a3 = new ArrayList<int[]>();
		int[][] result = new int[board_size][board_size];
		if (board_size == 4) {
			a1.add(r[0]);
			a1.add(r[1]);
			a2.add(r[2]);
			a2.add(r[3]);
			Collections.shuffle(a1);
			Collections.shuffle(a2);
			a1.addAll(a2);
			for (int i = 0; i != 4; i++)
				result[i] = a1.get(i);
		}
		if (board_size == 6) {
			if (a == 2) {
				a1.add(r[0]);
				a1.add(r[1]);
				a2.add(r[2]);
				a2.add(r[3]);
				a3.add(r[4]);
				a3.add(r[5]);
				Collections.shuffle(a1);
				Collections.shuffle(a2);
				Collections.shuffle(a3);
				a1.addAll(a2);
				a1.addAll(a3);
			}
			else {
				for (int i = 0; i != 3; i++)
					a1.add(r[i]);
				for (int i = 3; i != 6; i++)
					a2.add(r[i]);
				Collections.shuffle(a1);
				Collections.shuffle(a2);
				a1.addAll(a2);
			}
			for (int i = 0; i != 6; i++)
				result[i] = a1.get(i);
		}
		if (board_size == 9) {
			for (int i = 0; i != 3; i++)
				a1.add(r[i]);
			for (int i = 3; i != 6; i++)
				a2.add(r[i]);
			for (int i = 6; i != 9; i++)
				a3.add(r[i]);
			Collections.shuffle(a1);
			Collections.shuffle(a2);
			Collections.shuffle(a3);
			a1.addAll(a2);
			a1.addAll(a3);
			for (int i = 0; i != 9; i++)
				result[i] = a1.get(i);
		}
		for (int i = 0; i != board_size; i++)
			for (int j = 0; j != board_size; j++)
				answer[i][j] = result[i][j];
	}
	
	private void transpose() {
		int[][] result = new int[board_size][board_size];
		for (int i = 0; i != board_size; i++)
			for (int j = 0; j != board_size; j++)
				result[i][j] = answer[j][i];
		for (int i = 0; i != board_size; i++)
			for (int j = 0; j != board_size; j++)
				answer[i][j] = result[i][j];
	}
	
	//게임용 배열 제작
	private void gameBoardMaker() {
		for (int i = 0; i != board_size; i++)
			for (int j = 0; j != board_size; j++)
				game_board[i][j] = answer[i][j];
		int i = 0;
		int x, y;
		while (i < empty) {
			x = (int)(Math.random() * (double)board_size);
			y = (int)(Math.random() * (double)board_size);
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
	
	public String returnDif() {
		if (difficulty == 1)
			return "쉬움";
		else if (difficulty == 2)
			return "보통";
		else
			return "어려움";
	}
	
	public int returnEmpty() { return empty; }

	public int[][] contents() { return game_board; }
}
