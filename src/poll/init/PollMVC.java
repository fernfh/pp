package poll.init;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import poll.model.PollModel;
import poll.view.LabelView;

public class PollMVC extends JFrame {
	public PollMVC(PollModel model, String title) {
		super(title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(0, 1));
		JPanel questionPanel = new JPanel();
		panel.add(questionPanel);
		questionPanel.add(new JLabel("Was woll'n Sie denn trink'n?"));
		questionPanel.setBorder(BorderFactory.createTitledBorder("Frage"));
		JPanel answerPanel = new JPanel();
		panel.add(answerPanel);
		answerPanel.add(new LabelView(model));
		setSize(800, 600);
		setLocation(100, 100);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PollModel model = new PollModel();
		new PollMVC(model, "Poll");
	}

}
