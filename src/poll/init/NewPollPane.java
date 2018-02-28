package poll.init;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import poll.model.Poll;
import poll.model.PollList;

public class NewPollPane extends JPanel {
	NewPollPane(PollList polls) {
		super(new BorderLayout());
		JPanel newPollForm = new JPanel(new GridLayout(2, 2, 5, 5));
		add(newPollForm, BorderLayout.CENTER);
		JTextField kennung = new JTextField();
		JTextField frage = new JTextField();
		newPollForm.add(new JLabel("Kennung:"));
		newPollForm.add(kennung);
		newPollForm.add(new JLabel("Frage:"));
		newPollForm.add(frage);
		JButton newPollButton = new JButton("Neue Umfrage anlegen!");
		newPollButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				polls.addPoll(new Poll(frage.getText()));
			}
		});
		add(newPollButton, BorderLayout.SOUTH);
	}
}
