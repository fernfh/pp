package poll.controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.rmi.RemoteException;

import poll.model.PollList;

public class RemovePollController implements ActionListener, Serializable {

	private PollList polls;
	private String question;

	public RemovePollController(PollList polls, String q) {
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
