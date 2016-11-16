package src;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.Scanner;

public class MatrixAdditionClient {

	private MatrixAdditionClient() {
	}

	public static void main(String[] args) {

		String host = (args.length < 1) ? null : args[0];
		try {
			Registry registry = LocateRegistry.getRegistry(2000);
			MatrixAddition stub = (MatrixAddition) registry.lookup("MatrixAddition");
			System.out.println("Client connected\n");

			System.out.println("You will be prompted to create a matrix. Assure that you matrix looks like this: \n"
					+ "4 8 3\n5 1 4\n9 2 6\nAssure that the spaces are also included in your input.");

			Scanner scan = new Scanner(System.in);

			int rows;
			int cols;

			System.out.print("Enter row count: ");
			rows = scan.nextInt();
			System.out.print("\nEnter column count: ");
			cols = scan.nextInt();

			System.out.print("");
			
			int[][] firstMatrix = new int[rows][cols];
			int[][] secondMatrix = new int[rows][cols];

			System.out.println("Enter first matrix values: ");
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					firstMatrix[i][j] = scan.nextInt();
				}
			}

			System.out.println("Enter second matrix values: ");
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					secondMatrix[i][j] = scan.nextInt();
				}
			}
			
			int sum[][] = stub.addMatrices(firstMatrix, secondMatrix);

			// Print sum of matrices
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