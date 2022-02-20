
// Java Tutorials
// A Simplified Version

package engine;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import compute.Compute;
import compute.Task;

public class ComputeEngine implements Compute {

    public ComputeEngine() {
        super();
    }

    public <T> T executeTask(Task<T> t) {
        return t.execute();
    }

    public static void main(String[] args) {
      
        try {
            String name = "Compute";
			
            Compute engine = new ComputeEngine();
			
            Compute stub =
                (Compute) UnicastRemoteObject.exportObject(engine, 0); // 0: TCP port number
				
			// RMI registry: a particular type of remote object;
			//               a simple remote object naming service 
			// The java.rmi.registry.Registry remote interface is the API for 
			// binding (or registering) and looking up remote objects in the registry. 
			
			// LocateRegistry also provides static methods for 
			// creating a new registry in the current Java virtual machine.
            //Registry registry = LocateRegistry.getRegistry();
			java.rmi.registry.Registry registry = 
	        java.rmi.registry.LocateRegistry.createRegistry(5678);
			
            registry.rebind(name, stub);
			
            System.out.println("ComputeEngine bound");
        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }
}