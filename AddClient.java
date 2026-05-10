package ds_2;

import java.rmi.*;


public class AddClient {
	public static void main(String[] args) {
	try {
		AddServerIntf addObAddServerIntf = (AddServerIntf)Naming.lookup("rmi://127.0.0.1/AddServer");
		
		double num1 = 10;
		double num2 = 20;
		
		double result = addObAddServerIntf.add(num1, num2);
		
		System.out.println("Addition Result = "+ result);
	}
	catch(Exception e) {
		e.printStackTrace();
	}}
}




// to run this assignment, we have to start rmiregistry from bin folder of workspace. 
// command to do this -> rmiregistry
// eg. \Users\dumbr\eclipse-workspace\ds_2\bin> rmiregistry


// then run AddServer
// then run the client
// make sure that that version of java compiler and eclips should be same. 
// to check which version your pc is using, run command java -version
// to change the version from eclips, navigate to project->properties->java_compiler and change to appropriate version
// the go to  project->properties->java_compiler. go to libraries path and delete older librabry and add new labrary with proper version.
// Make sure to delete the module-info.java file from the project. 

package ds_2;

import java.rmi.*;

public class AddServer {
	public static void main(String[] args) {
		try {
			AddServerImpl addoAddServerImpl = new AddServerImpl();
			
			Naming.rebind("AddServer", addoAddServerImpl);
			
			System.out.println("Server Started...");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

///////////////////////
package ds_2;

import java.rmi.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class AddServerImpl extends UnicastRemoteObject implements AddServerIntf {
	public AddServerImpl() throws RemoteException {
		super();
	}
	
	public double add(double num1, double num2) throws RemoteException{
		System.out.println("Processing request in thread : "+ Thread.currentThread().getName());
		
		return num1 + num2;
	}

}

//////////////////////

package ds_2;

import java.rmi.*;
import java.rmi.RemoteException;

public interface AddServerIntf extends Remote {
	double add(double num1, double num2)throws RemoteException;
}
