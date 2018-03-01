package poll.init;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import poll.model.PollList;
import poll.view.ExceptionDialog;

public class PollProgram {

	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry(2018);
			PollList pollList = (PollList) registry.lookup("PollList");
			new PollListFrame(pollList, "Alle Umfragen");
		} catch (Exception e) {
			new ExceptionDialog(e);
		}
	}
}
