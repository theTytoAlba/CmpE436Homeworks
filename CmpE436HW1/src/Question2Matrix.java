import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
//Irmak Kavasoglu
//2013400090
//irmakkavasoglu@gmail.com
//CmpE436 Assignment 1 - Question 2, helper class.
public class Question2Matrix {
	private int[][] matrix;
	private int maxGenerations;
	
	/**
	 * Constructor expects the dimensions
	 * @param n rows
	 * @param m columns
	 */
	public Question2Matrix(int n, int m) {
		matrix = new int[n][m];
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
						matrix[i][j] = in.nextInt();
					} catch (Exception e) {
						System.out.println("Error reading element [" + i + ", " + j + "].");
						System.out.println("Please make sure all elements are integers");
						System.exit(0);
					}
					if (!(matrix[i][j] == 0 || matrix [i][j] == 1)) {
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
				matrix[i][j] = rand.nextInt(2);
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
		this.maxGenerations = maxGenerations;
	}

	/**
	 * Runs the simulation for given number of generations.
	 */
	public void runSimulation() {
		for (int i = 0; i < maxGenerations; i++) {
			matrix = generateStep();
		}
	}
	
	/**
	 * Using the current matrix, creates another matrix which is the next generation.
	 * @return next generation matrix
	 */
	private int[][] generateStep() {
		int [][] step = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < step.length; i++) {
			for (int j = 0; j < step[0].length; j++) {
				step[i][j] = nextValue(i, j);
			}
		}
		return step;
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
	private int nextValue(int i, int j) {
		if (matrix[i][j] == 1) {
			return (countNeighbors(i, j) == 2 || countNeighbors(i, j) == 3) ? 1 : 0;
		} else {
			return (countNeighbors(i, j) == 3) ? 1 : 0;	
		}
	}

	/**
	 * Counts the neighbors with value 1.
	 * @param i x coordinate of the center cell
	 * @param j y coordinate of the center cell
	 * @return total number of neighbors with value 1
	 */
	private int countNeighbors(int i, int j) {
		int sum = 0;
		// Add upper left
		if (i != 0 && j != 0) {
			sum += matrix[i-1][j-1];
		}
		// Add up
		if (i != 0) {
			sum += matrix[i-1][j];
		}
		// Add upper right
		if (i != 0 && j+1 != matrix[0].length) {
			sum += matrix[i-1][j+1];
		}
		// Add left
		if (j != 0) {
			sum += matrix[i][j-1];
		}
		// Add right
		if (j+1 != matrix[0].length) {
			sum += matrix[i][j+1];
		}
		// Add bottom left
		if (i+1 != matrix.length && j != 0) {
			sum += matrix[i+1][j-1];
		}
		// Add bottom
		if (i+1 != matrix.length) {
			sum += matrix[i+1][j];
		}
		// Add bottom right
		if (i+1 != matrix.length && j+1 != matrix[0].length) {
			sum += matrix[i+1][j+1];
		}
		return sum;
	}
	
	/**
	 * Prints out the current matrix.
	 */
	public void printMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
 }
