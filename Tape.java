package turing;

public class Tape {

	private Cell currentCell;  // Pointer to the current cell.
	
	public Tape() {
		Cell cell = new Cell();
		cell.content = ' ';
		cell.prev = null;
		cell.next = null;
		currentCell = cell;
	}
	
	/**
	 * Returns the pointer that points to the current cell.
	 */
	public Cell getCurrentCell() {
		return currentCell;
	}
	
	/**
	 * Returns the char from the current cell.
	 */
	public char getContent() {
		return currentCell.content;
	}
	
	/**
	 * Changes the char in the current cell to ch.
	 */
	public void setContent(char ch) {
		currentCell.content = ch;
	}
	
	/**
	 * Moves the current cell one position to the left along the tape.
	 */
	public void moveLeft() {
		if (currentCell.prev == null) {
			Cell newCell = new Cell();
			newCell.content = ' ';
			newCell.prev = null;
			currentCell.prev = newCell;
			newCell.next = currentCell;
			currentCell = newCell;
		} else {
			currentCell = currentCell.prev;
		}
	}
	
	/**
	 * Moves the current cell one position to the right along the tape.
	 */
	public void moveRight() {
		if (currentCell.next == null) {
			Cell newCell = new Cell();
			newCell.content = ' ';
			newCell.next = null;
			currentCell.next = newCell;
			newCell.prev = currentCell;
			currentCell = newCell;
		} else {
			currentCell = currentCell.next;
		}
	}
	
	/**
	 * Returns a String consisting of the chars from all the cells on the
	 * tape, read left to right.  Trailing blank characters are discarded.
	 */
	public String getTapeContents() {
		
		Cell runner;  // A pointer to traverse the list.
		
		// Start with the runner pointing to the current cell.
		runner = currentCell;
		
		// After the loop, runner should point to the farthest left cell.
		while (runner.prev != null) {
			runner = runner.prev;
		}
		
		StringBuilder sb = new StringBuilder();
		
		while (runner != null) {
			sb.append(runner.content);
			runner = runner.next;
		}
		
		// Returns a string of all the characters in the tape with
		// leading and trailing blank spaces discarded.
		return sb.toString().trim();
	}
}
