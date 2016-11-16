// Christian Garcia, Jackson Jones
// CS 412 Lab 7
// November 17th, 2016

package src;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class MatrixAdditionClient2 {

	private MatrixAdditionClient2() {
	}

	public static void main(String[] args) {

		String host = (args.length < 1) ? null : args[0];
		try {
			Registry registry = LocateRegistry.getRegistry(2000);
			MatrixAddition stub = (MatrixAddition) registry.lookup("MatrixAddition");
			System.out.println("Client connected\n");

			// Prompt user to create matrices
			System.out.println("You will be prompted to create matrix B. Assure that you matrix looks like this: \n"
					+ "4 8 3\n5 1 4\n9 2 6\nAlso make sure that the spaces are included in your input. This will not"
					+ " work properly any other way.");

			Scanner scan = new Scanner(System.in);

			int rows;
			int cols;

			System.out.print("Enter row count: ");
			rows = scan.nextInt();
			System.out.print("Enter column count: ");
			cols = scan.nextInt();

			System.out.print("");
			
			int[][] matrixB = new int[rows][cols];

			System.out.println("\nEnter matrix B values: ");
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					matrixB[i][j] = scan.nextInt();
				}
			}

			// Send matrix A to the server
			stub.getMatrixB(matrixB);
			
			int sum[][] = stub.addMatrices();
			
			System.out.println("\nSum of matrices:");
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					System.out.print(sum[i][j] + " ");
				}
				System.out.println();
			}

		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}
}