package Q2Deadlock;
//Irmak Kavasoglu
//2013400090
//irmakkavasoglu@gmail.com
//CmpE436 Assignment 2.
public class Main {
	static BinarySemaphore[] forks;
	static Philosopher[] phils;
	
	public static void main(String[] args) {
		// Say we have 3 forks.
		forks = new BinarySemaphore[3];
		forks[0] = new BinarySemaphore();
		forks[1] = new BinarySemaphore();
		forks[2] = new BinarySemaphore();
		
		// Also say we have 3 hungry philosophers.
		phils = new Philosopher[3];
		phils[0] = new Philosopher(0);
		phils[1] = new Philosopher(1);
		phils[2] = new Philosopher(2);
		
		// They all want to eat with 2 forks. They all start with left fork.
		phils[0].start();
		phils[1].start();
		phils[2].start();
		
		// NOBODY EATS BECAUSE DEADLOCK. :(
		// Everybody has the fork on their left, and only that.
	}
}
