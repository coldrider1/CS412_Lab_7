import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MatrixAdditionClient {

    private MatrixAdditionClient() {}

    public static void main(String[] args) {

        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            MatrixAddition stub = (MatrixAddition) registry.lookup("MatrixAddition");
            System.err.println("Client connected\n");
            
            //System.out.println("Please );
            //TODO
            //String response = stub.sayHello();
            
            System.out.println("It worked!");
            
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}