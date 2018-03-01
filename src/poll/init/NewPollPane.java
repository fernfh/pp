package poll.init;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import poll.model.PollList;
import poll.view.RemoteExceptionView;

public class NewPollPane extends JPanel implements ActionListener {
	PollList polls;
	JTextField frage;
	NewPollPane(PollList polls) {
		super(new BorderLayout());
		this.polls = polls;
		JPanel newPollForm = new JPanel(new GridLayout(2, 2, 5, 5));
		add(newPollForm, BorderLayout.CENTER);
		JTextField kennung = new JTextField();
		frage = new JTextField();
		newPollForm.add(new JLabel("Kennung:"));
		newPollForm.add(kennung);
		newPollForm.add(new JLabel("Frage:"));
		newPollForm.add(frage);
		JButton newPollButton = new JButton("Neue Umfrage anlegen!");
		newPollButton.addActionListener(this);
		add(newPollButton, BorderLayout.SOUTH);
	}
	public void actionPerformed(ActionEvent e) {
		try {
			polls.addPoll(frage.getText());
		} catch (RemoteException re) {
			new RemoteExceptionView(re);
		}
	}
}
