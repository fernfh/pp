package poll.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import poll.model.PollList;

public class Server {
	public static void main(String args[]) {
		try {
			Service obj = new Service();
			Registry registry = LocateRegistry.createRegistry(2018);
			PollList stub = (PollList) UnicastRemoteObject.exportObject(obj, 0);
			registry.bind("PollList", stub);
			System.err.println("Server Ready");
		} catch (Exception e) {
			System.err.println(e.toString());
			e.printStackTrace();
		}
	}
}
