package Q1;
// Irmak Kavasoglu
// 2013400090
// irmakkavasoglu@gmail.com
// CmpE436 Assignment 2.
public class Main {
	public static void main(String[] args) {
		// Create the matrix first.
		Board matrix;
		if (args.length == 3) {
			System.out.println("No filename received. Generating the initial matrix randomly.");
			try {
				matrix = new Board(Integer.parseInt(args[0]), Integer.parseInt(args[1]));	
			} catch (Exception e) {
				System.out.println("Matrix dimentions must be positive integer values.");
				System.exit(0);
				return;
			}
			try {
				matrix.setMaxGenerations(Integer.parseInt(args[2]));	
			} catch (Exception e) {
				System.out.println("Max generation number must be an integer.");
				System.exit(0);
			}
			matrix.fillRandomly();
		} else if (args.length == 4) {
			try {
				matrix = new Board(Integer.parseInt(args[0]), Integer.parseInt(args[1]));	
			} catch (Exception e) {
				System.out.println("Matrix dimensions must be positive integer values.");
				System.exit(0);
				return;
			}
			System.out.println("Getting initial matrix from " + args[3] + ".");
			try {
				matrix.setMaxGenerations(Integer.parseInt(args[2]));	
			} catch (Exception e) {
				System.out.println("Max generation number must be an integer.");
				System.exit(0);
				return;
			}
			matrix.fillFromFile(args[3]);
		} else {
			System.out.println("Expected 3 or 4 arguments but found " + args.length + ".");
			System.exit(0);
			return;
		}
		
		matrix.runSimulation();
	}

}
