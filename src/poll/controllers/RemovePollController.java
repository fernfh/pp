package poll.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.rmi.RemoteException;

import poll.view.RMIClient;

@SuppressWarnings("serial")
public class RemovePollController implements ActionListener, Serializable {

	private RMIClient polls;
	private String question;

	public RemovePollController(RMIClient polls, String q) {
		this.polls = polls;
		question = q;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			polls.removePoll(question);
		} catch (RemoteException re) {
			re.printStackTrace();
		}
	}
}
