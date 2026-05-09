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
