package src;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MatrixAdditionClient {

    private MatrixAdditionClient() {}

    public static void main(String[] args) {

        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(2000);
            MatrixAddition stub = (MatrixAddition) registry.lookup("MatrixAddition");
            System.out.println("Client connected\n");
            
            System.out.println("You will be prompted to create a matrix. Assure that you matrix looks like this: \n"
            		+ "4 8 3\n5 1 4\n9 2 6\nAssure that the spaces are also included in your input.");
            
            //TODO
            
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}