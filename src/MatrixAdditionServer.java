package src;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
        
public class MatrixAdditionServer implements MatrixAddition {
        
    public MatrixAdditionServer() {}

    public int[][] addMatrices(int[][] a, int[][] b) throws RemoteException {
    	
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