package Q1;

//Irmak Kavasoglu
//2013400090
//irmakkavasoglu@gmail.com
//CmpE436 Assignment 2.
public class Cell extends Thread{
	private int i, j, value;
	// Starts w 1
	private CountingSemaphore s1;
	// Starts w 0
	private CountingSemaphore b1;
	// Starts n*m
	private CountingSemaphore cycle;
	int maxGeneration;
	
	public Cell(int i, int j, int value, int maxGeneration) {
		this.i = i;
		this.j = j;
		this.value = value;
		this.maxGeneration = maxGeneration;
	}
	
	@Override
	public void run() {
		for(int gen = 0; gen < maxGeneration; gen++) {
			// Everybody gets in the current cycle.
			cycle.P();
			// Take s1 (there is only 1 and i am taking it).
			s1.P(); 
			// One more thread is doing its job. (Calculation)
			Board.count = Board.count + 1; 
			int next = getNextValue();
			// If all threads are done, we are ready to lift the barrier. Ready to assign.
			if (Board.count == Board.getHeight() * Board.getWidth()) {
				// Release b1
		        b1.V(); 
			}
			// Release s1 (there was only one and i am releasing it).
			s1.V(); 
		    
			// Take b1. (Only available after the last thread is done).
			b1.P();
			// Take s1
			s1.P();
			// One more thread is doing its job (Assign)
			Board.count = Board.count - 1; 
			this.value = next;
			// Release b1 (Let the next thread calculate).
			b1.V();
			// If all threads are done, start the next generation.
			if  (Board.count==0)
			{
				// Print completed generation
				System.out.println("\nGeneration " + (gen+1));
				Board.printMatrix();
				// Take b1
				b1.P();
				
				// Let the next cycle begin.
				for (int c = 0; c < Board.getHeight() * Board.getWidth(); c++) {
					cycle.V();
				}
			}
			// Release s1
			s1.V();
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

	public void setSemaphores(CountingSemaphore s1, CountingSemaphore b1, CountingSemaphore cycle) {
		this.s1 = s1;
		this.b1 = b1;
		this.cycle = cycle;
	}
	
}
