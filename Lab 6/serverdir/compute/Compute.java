

// Java Tutorials - RMI
package compute;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Task<T>: a Java interface declared by a client
// RemoteException: a checked exception
// different kinds of tasks can be run by a Compute object (a Compute Engine)

public interface Compute extends Remote {
    <T> T executeTask( Task<T> t ) throws RemoteException;
}