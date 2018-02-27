package poll.init;

import java.awt.BorderLayout;

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
		JPanel questionPanel = new JPanel();
		add(questionPanel, BorderLayout.NORTH);
		questionPanel.add(new JLabel("Was woll'n Sie denn trink'n?"));
		questionPanel.setBorder(BorderFactory.createTitledBorder("Frage"));
		JPanel answerPanel = new JPanel();
		add(answerPanel, BorderLayout.CENTER);
		answerPanel.add(new LabelView(model));
		answerPanel.setBorder(BorderFactory.createTitledBorder("Erhöhen"));
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
