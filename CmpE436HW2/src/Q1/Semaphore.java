package Q1;
//Irmak Kavasoglu
//2013400090
//irmakkavasoglu@gmail.com
//CmpE436 Assignment 2.
public class Semaphore {
	int saturation;
	int assigned;
	int calculated;
	int generation;
	
	public Semaphore(int saturation, int generation) {
		this.saturation = saturation;
		// Every cell is assigned to uptodate values.
		assigned = saturation;
		// No next values are calculated yet.
		calculated = 0;
		// Generation countdown will happen/
		this.generation = generation;
	}
	
	public synchronized void calcNext() {
		// Wait until every cell is assigned to its uptodate value.
		while(assigned != saturation)
			try {
				wait();
			} catch (InterruptedException e) {
			}
		// When everybody is assigned, everybody will calculate.
		calculated++;
		// When everybody finishes calculating, we will notify for the assigning.
	    if (calculated == saturation) {
	    		// Check if generations are done.
	    		if (generation == 0) {
	    			Board.printMatrix();
	    			System.exit(0);
	    		} 
	    		// Reset assigned number before starting assigning.
	    		assigned = 0;
	    		notifyAll();
	    }
	}
	
	public synchronized void assignNext(){
		// Wait until every body calculated their things.
		while(calculated != saturation)
			try {
				wait();
			} catch (InterruptedException e) {
			}
		// When everybody has their value ready, assign.
		assigned++;
		// If everybody assigned, one generation is done. Start next generation by calculating again.
		if (assigned == saturation) {
			calculated = 0;
			generation--;
			notifyAll();
		}
	}	
}
