package poll.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import java.rmi.RemoteException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import poll.model.Poll;

public class AnswerSetView extends JPanel {
	private String answer;
	private Poll model;
	private JTextField textField;

	public AnswerSetView(Poll model, String ans, ActionListener controller) {
		this.answer = ans;
		this.model = model;
		JLabel label = new JLabel(answer);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setText(answer);
		textField = new JTextField();
		textField.setName(answer);
		textField.addActionListener(controller);
		myDataWasUpdated();

		setLayout(new GridLayout(0, 2, 5, 5));
		add(label);
		add(textField);
	}

	public void myDataWasUpdated() {
		try {
			textField.setText("" + model.getCount(answer));
		} catch (RemoteException re) {
			new RemoteExceptionView(re);
		}
	}
}
