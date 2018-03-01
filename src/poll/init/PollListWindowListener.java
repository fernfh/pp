package poll.init;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import poll.model.PollList;
import poll.view.RMIClient;
import poll.view.ExceptionDialog;

public class PollListWindowListener implements WindowListener {

	private PollListFrame frame;
	private PollList polls;
	private RMIClient rmiClient;

	public PollListWindowListener(PollListFrame pollListFrame, PollList polls, RMIClient rmiClient) {
		this.frame = pollListFrame;
		this.polls = polls;
		this.rmiClient = rmiClient;
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		try {
			UnicastRemoteObject.unexportObject(rmiClient, true);
		} catch (NoSuchObjectException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		try {
			UnicastRemoteObject.exportObject(rmiClient, 0);
			polls.addPollListListener(rmiClient);
			for (String question : polls.getPolls()) {
				frame.pollAdded(question);
			}
		} catch (RemoteException e1) {
			new ExceptionDialog(e1);
		}
	}

}
