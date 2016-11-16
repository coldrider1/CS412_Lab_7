// Christian Garcia, Jackson Jones
// CS 412 Lab 7
// November 17th, 2016

package src;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
        
public class MatrixAdditionServer implements MatrixAddition {
        
    public MatrixAdditionServer() {}

    int[][] a;
    int[][] b;
    
	@Override
	public int[][] getMatrixA(int[][] a) throws RemoteException {
		this.a = a;
		
		return a;
	}

	@Override
	public int[][] getMatrixB(int[][] b) throws RemoteException {
		this.b = b;
		
		return b;
	}
    
    // Takes in two two-dimensional matrices (arrays) from the client and adds them
    public int[][] addMatrices() throws RemoteException {
    	
        int[][] sum = new int[a.length][a[0].length];
        
         for (int i = 0; i < a.length; i++ ){
         	for (int j = 0; j < a[i].length; j++){
         		sum[i][j] = a[i][j] + b[i][j];
         	} 
         }
          
        return sum;
    }
        
    public static void main(String args[]) {
        
        try {
        	MatrixAdditionServer obj = new MatrixAdditionServer();
            MatrixAddition stub = (MatrixAddition) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.createRegistry(2000);
            registry.bind("MatrixAddition", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}