package poll.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import java.rmi.RemoteException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import poll.model.PollList;
import poll.controllers.SetController;

public class AnswerSetView extends JPanel {
	private String answer;
	private String question;
	private PollList polls;
	private JTextField textField;

	public AnswerSetView(PollList polls, String q, String a) {
		this.polls = polls;
		question = q;
		answer = a;
		JLabel label = new JLabel(answer);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setText(answer);
		textField = new JTextField();
		textField.setName(answer);
		SetController controller = new SetController(polls, q, a);
		textField.addActionListener(controller);
		setLayout(new GridLayout(0, 2, 5, 5));
		add(label);
		add(textField);
	}

	public void update (int count) {
		textField.setText("" + count);
	}
}
