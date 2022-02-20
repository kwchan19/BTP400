
// Java Tutorials - RMI Client
// A Simplified Version

// command-line: java ComputePi 5678 45

package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


import java.math.BigDecimal;

import compute.Compute;

public class ComputePi {
    public static void main(String args[]) {
        /*if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
		*/
        try {
		
		    // args[0]: the name of the remote host
			
            String name = "Compute";
            Registry registry = LocateRegistry.getRegistry( Integer.parseInt(args[0]) );
			
            Compute comp = (Compute) registry.lookup(name);
			
			// Pass the Task object to the remote object!
			// The remote object executes this task and return the RESULT
            Pi task = new Pi(Integer.parseInt(args[1]));
			
            BigDecimal pi = comp.executeTask(task);
			
            System.out.println(pi);
			
        } catch (Exception e) {
            System.err.println("ComputePi exception:");
            e.printStackTrace();
        }
    }    
}