// Christian Garcia, Jackson Jones
// CS 412 Lab 7
// November 17th, 2016

package src;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MatrixAddition extends Remote {
	
	int[][] getMatrixA(int[][] a) throws RemoteException;
	int[][] getMatrixB(int[][] b) throws RemoteException;
    int[][] addMatrices() throws RemoteException;
}