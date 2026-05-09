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
