/*
RMI uses the Java object serialization mechanism to transport objects by value 
between Java virtual machines. For an object to be considered serializable, 
its class must implement the java.io.Serializable marker interface. 
Therefore, classes that implement the Task interface must also implement Serializable, 
as must the classes of objects used for task results.

*/
package compute;

// a Java interface declared by a client
// T: the return type of execute()

public interface Task<T> {
    T execute();
}