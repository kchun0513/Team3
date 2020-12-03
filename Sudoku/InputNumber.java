package sudoku;

public class InputNumber {
	private int number;
	
	public InputNumber(int b) {
		number = 1;
	}
	
	public void select(int n) {
		number = n;
	}
	
	public int valueOf() {
		return number;
	}
}