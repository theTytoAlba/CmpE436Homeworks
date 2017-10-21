package Q1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
//Irmak Kavasoglu
//2013400090
//irmakkavasoglu@gmail.com
//CmpE436 Assignment 2.
public class Board {
	private static Cell[][] matrix;
	public static Integer maxGenerations;
	public static Integer count;
	
	/**
	 * Constructor expects the dimensions
	 * @param n rows
	 * @param m columns
	 */
	public Board(int n, int m) {
		matrix = new Cell[n][m];
	}
	
	public static int getWidth() {
		return matrix.length;
	}
	
	public static int getHeight() {
		return matrix[0].length;
	}
	
	/**
	 * Reads the matrix from file
	 * @param fileName the name of the file
	 * @return the integer matrix
	 */
	public void fillFromFile(String fileName) {
		if (fileName == null || fileName.isEmpty()) {
			System.out.println("There is no file name to fill the matrix from.");
			return;
		}
		try {
			Scanner in = new Scanner(new File(fileName));
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					try {
						matrix[i][j] = new Cell(i, j, in.nextInt(), maxGenerations);
					} catch (Exception e) {
						System.out.println("Error reading element [" + i + ", " + j + "].");
						System.out.println("Please make sure all elements are integers");
						System.exit(0);
					}
					if (!(matrix[i][j].getValue() == 0 || matrix [i][j].getValue() == 1)) {
						System.out.println("All elements must be 1 or 0.");
						System.exit(0);
					}
				}
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("File " + fileName + " not found.");
		}
	}
	
	/**
	 * Fills the matrix with random {0, 1} values.
	 */
	public void fillRandomly() {
		Random rand = new Random(); 
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = new Cell(i, j, rand.nextInt(2), maxGenerations);
			}
		}
	}
	
	/**
	 * Setter for max generations variable.
	 * @param maxGenerations
	 */
	public void setMaxGenerations(int maxGenerations) {
		if (maxGenerations < 0) {
			System.out.println("Max generations cannot be negative.");
			return;
		}
		Board.maxGenerations = new Integer(maxGenerations);
	}

	/**
	 * Runs the simulation for given number of generations.
	 */
	public void runSimulation() {
		count = new Integer(0); 		
		CountingSemaphore s1 = new CountingSemaphore(1);
		CountingSemaphore b1 = new CountingSemaphore(0);
		CountingSemaphore cycle = new CountingSemaphore(matrix[0].length*matrix.length);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j <matrix[0].length; j++) {
				matrix[i][j].setSemaphores(s1, b1, cycle);
				matrix[i][j].start();
			}
		}
	}	
	/**
	 * Counts the neighbors with value 1.
	 * @param i x coordinate of the center cell
	 * @param j y coordinate of the center cell
	 * @return total number of neighbors with value 1
	 */
	public static int countNeighbors(int i, int j) {
		int sum = 0;
		// Add upper left
		if (i != 0 && j != 0) {
			sum += matrix[i-1][j-1].getValue();
		}
		// Add up
		if (i != 0) {
			sum += matrix[i-1][j].getValue();
		}
		// Add upper right
		if (i != 0 && j+1 != matrix[0].length) {
			sum += matrix[i-1][j+1].getValue();
		}
		// Add left
		if (j != 0) {
			sum += matrix[i][j-1].getValue();
		}
		// Add right
		if (j+1 != matrix[0].length) {
			sum += matrix[i][j+1].getValue();
		}
		// Add bottom left
		if (i+1 != matrix.length && j != 0) {
			sum += matrix[i+1][j-1].getValue();
		}
		// Add bottom
		if (i+1 != matrix.length) {
			sum += matrix[i+1][j].getValue();
		}
		// Add bottom right
		if (i+1 != matrix.length && j+1 != matrix[0].length) {
			sum += matrix[i+1][j+1].getValue();
		}
		return sum;
	}
	
	/**
	 * Prints out the current matrix.
	 */
	public static void printMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j].getValue() + " ");
			}
			System.out.println();
		}
	}
 }
