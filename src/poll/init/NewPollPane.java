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

import poll.view.RMIClient;
import poll.view.ExceptionDialog;

@SuppressWarnings("serial")
public class NewPollPane extends JPanel implements ActionListener {
	RMIClient polls;
	JTextField frage;

	NewPollPane(RMIClient polls2) {
		super(new BorderLayout());
		this.polls = polls2;
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
			new ExceptionDialog(re);
		}
	}
}
