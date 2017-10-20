import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
// Irmak Kavasoglu
// 2013400090
// irmakkavasoglu@gmail.com
// CmpE436 Assignment 1 - Question 1.
public class Question1 {
	public static void main(String[] args) {
		// Check if user gives us 2 input and 1 output file names.
		if (args.length != 3) {
			System.out.println("Expected 3 arguments but found " + args.length + ".");
			System.exit(0);
		}
		// Get matrices.
		int[][] matrix1 = readMatrix(args[0]);
		int[][] matrix2 = readMatrix(args[1]);
		// Write the solution.
		writeMatrix(args[2], multiply(matrix1, matrix2));
	}
	
	/**
	 * Reads the matrix from file
	 * @param fileName the name of the file
	 * @return the integer matrix
	 */
	private static int[][] readMatrix(String fileName) {
		try {
			Scanner in = new Scanner(new File(fileName));
			int rows = in.nextInt();
			int cols = in.nextInt();
			if (rows <= 0 || cols <= 0) {
				System.out.println("Rows and columns have to be positive integers.");
				System.exit(0);
			}
			int[][] matrix = new int[rows][cols];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					try {
						matrix[i][j] = in.nextInt(); 
					} catch (Exception e) {
						System.out.println("Error while reading element [" + i + ", " + j + "].");
						System.out.println("Please make sure all elements are integers.");
						System.exit(0);
					}
				}
			}
			in.close();
			return matrix;
		} catch (FileNotFoundException e) {
			System.out.println("File " + fileName + " not found.");
			System.exit(0);
			return null;
		}
	}
	
	/**
	 * Writes a matrix to a file
	 * @param fileName the file name that is going to be written
	 * @param matrix the matrix to be written
	 */
	private static void writeMatrix(String fileName, int[][] matrix) {
		try {
			PrintWriter 	writer = new PrintWriter(fileName, "UTF-8");
			writer.print(matrix.length + " " + matrix[0].length);
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					writer.print(matrix[i][j] + " ");
				}
				writer.println();
			}
			writer.close();
		} catch (Exception e) {
			System.out.println("Error while writing the result.");
			System.exit(0);
		}
	    
	}
	
	/**
	 * Multiplies two matrices.
	 * @param mat1 matrix 1
	 * @param mat2 matrix 2
	 * @return multiplication
	 */
	private static int[][] multiply(int[][] mat1, int[][] mat2) {
		if (mat1[0].length != mat2.length) {
			System.out.println("Matrix sizes don't meet.");
			System.exit(0);
		}
		int[][] matrix = new int[mat1.length][mat2[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int sum = 0;
				for (int k = 0; k < mat1[0].length; k++) {
					sum += mat1[i][k] * mat2[k][j];
				}
				matrix[i][j] = sum;
			}
		}
		return matrix;
	}
}