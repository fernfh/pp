package poll.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import poll.model.PollModel;
import poll.model.PollModelListener;

public class AnswerIncrementView extends JPanel implements PollModelListener {
	private String answer;
	private JLabel label;
	private PollModel model;

	public AnswerIncrementView(PollModel model, String ans, ActionListener listener) {
		this.answer = ans;
		this.model = model;
		this.label = new JLabel(answer);
		this.label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setText(currentText());
		JButton button = new JButton("Erhöhen");
		button.setName(answer);
		button.addActionListener(listener);

		setLayout(new GridLayout(0, 2, 5, 5));
		add(label);
		add(button);
	}

	public void myDataWasUpdated() {
		label.setText(currentText());
	}

	private String currentText() {
		return answer + ": " + model.getCount(answer) + " von " + model.sumAnswers() + " ("
				+ model.getPercentage(answer) + "%)";
	}

	@Override
	public void valueChanged() {
		myDataWasUpdated();
	}
}
