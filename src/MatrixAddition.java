import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MatrixAddition extends Remote {
	
    int[] addMatrices(int[] a, int[] b) throws RemoteException;
}