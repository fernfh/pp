package poll.rmi;

import java.rmi.RemoteException;
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

			sample1(obj);
			sample2(obj);
			sample3(obj);
			System.err.println("Server Ready");
		} catch (Exception e) {
			System.err.println(e.toString());
			e.printStackTrace();
		}
	}

	private static void sample1(PollList polls) throws RemoteException {
		String q = "Was woll'n Sie denn trink'n?";
		polls.addPoll(q);
		String[] answers = new String[] { "Wasser", "Kaffee", "Tee", "Pils", "Weizen", "Weißwein", "Rotwein", "Rosé" };
		int ix = 1;
		for (String a : answers) {
			polls.setPollAnswer(q, a, ix++ * 11);
		}
	}

	private static void sample2(PollList polls) throws RemoteException {
		String q = "Was woll'n Sie denn ess'n?";
		polls.addPoll(q);
		String[] answers = new String[] { "Wurst", "Currywurst", "Pistazienwurst", "Paprikawurst", "Wurst mit Eiern",
				"Wurst mit Wurst & Wurst" };
		int ix = 1;
		for (String a : answers) {
			polls.setPollAnswer(q, a, ix++ * 11);
		}
	}

	private static void sample3(PollList polls) throws RemoteException {
		String q = "Was woll'n Sie denn rauch'n?";
		polls.addPoll(q);
		String[] answers = new String[] { "Tabak", "Grünes Zeug", "Hashish", "Shisha" };
		int ix = 1;
		for (String a : answers) {
			polls.setPollAnswer(q, a, ix++ * 11);
		}
	}
}
