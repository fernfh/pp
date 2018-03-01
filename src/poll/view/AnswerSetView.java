package poll.view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import poll.controllers.SetController;

@SuppressWarnings("serial")
public class AnswerSetView extends JPanel {
	private JTextField textField;

	public AnswerSetView(RMIClient polls, String q, String a) {
		JLabel label = new JLabel(a);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setText(a);
		textField = new JTextField();
		textField.setName(a);
		SetController controller = new SetController(polls, q, a);
		textField.addActionListener(controller);
		setLayout(new GridLayout(0, 2, 5, 5));
		add(label);
		add(textField);
	}

	public void update(int count) {
		textField.setText("" + count);
	}
}
