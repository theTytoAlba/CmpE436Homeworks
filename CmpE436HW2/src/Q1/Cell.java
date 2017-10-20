package Q1;

//Irmak Kavasoglu
//2013400090
//irmakkavasoglu@gmail.com
//CmpE436 Assignment 2.
public class Cell extends Thread{
	private int i, j, value;
	private Semaphore semaphore;
	
	public Cell(int i, int j, int value) {
		this.i = i;
		this.j = j;
		this.value = value;
	}
	
	@Override
	public void run() {
		while (true) {
			// Get permission to calculate (wait until everyone assigns)
			semaphore.calcNext();
			int next = getNextValue();
			// Get permission to assign (wait until everyone calculates)
			semaphore.assignNext();
			this.value = next;
		}
	}
	
	public int getValue() {
		return value;
	}
	
	/**
	 * Calculates the value of a single cell for the next step.
	 * A 1 cell value stays 1 if exactly two or three neighbors are 1 valued.
	 * A 1 cell value goes to 0 if less than two or greater than three neighbors are 1 valued.
	 * A 0 cell value goes to 1 if exactly three neighbors are 1 valued.
 	 * A 0 cell value stays 0 if less than three or greater than three neighbors are 1 valued. 
	 * @param i x coordinate of the cell
	 * @param j y coordinate of the cell
	 * @return
	 */
	private int getNextValue() {
		if (value == 1) {
			return (Board.countNeighbors(i, j) == 2 || Board.countNeighbors(i, j) == 3) ? 1 : 0;
		} else {
			return (Board.countNeighbors(i, j) == 3) ? 1 : 0;	
		}
	}

	public void setSemaphore(Semaphore s) {
		semaphore = s;
	}
	
}
