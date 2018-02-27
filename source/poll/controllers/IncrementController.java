package poll.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import poll.model.PollModel;

public class IncrementController implements ActionListener {
	private PollModel model;

	public IncrementController (PollModel pollModel) {
		this.model = pollModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO: über PollModel increment aufrufen.
	}
}
