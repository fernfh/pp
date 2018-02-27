package poll.init;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import poll.controllers.AddAnswersController;
import poll.controllers.IncrementController;
import poll.controllers.SetController;
import poll.model.PollModel;
import poll.view.AnswerAddView;
import poll.view.LabelView;
import poll.view.TextfieldView;

public class PollMVC extends JFrame {
	public PollMVC(PollModel model, String title) {
		super(title);
		SetController setController = new SetController(model);
		AddAnswersController addAnswerController = new AddAnswersController(model);
		IncrementController incrController = new IncrementController(model);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new GridLayout(2, 2));
		JPanel questionPanel = new JPanel();
		add(questionPanel);
		questionPanel.add(new JLabel(model.getQuestion()));
		questionPanel.setBorder(BorderFactory.createTitledBorder("Frage"));
		JPanel newAnswerPanel = new JPanel();
		add(newAnswerPanel);
		newAnswerPanel.add(new AnswerAddView(model, addAnswerController));
		newAnswerPanel.setBorder(BorderFactory.createTitledBorder("Neue Antwortmöglichkeit hinzufügen"));
		JPanel incrementPanel = new JPanel();
		add(incrementPanel);
		incrementPanel.add(new LabelView(model, incrController));
		incrementPanel.setBorder(BorderFactory.createTitledBorder("Erhöhen"));
		JPanel setPanel = new JPanel();
		add(setPanel, BorderLayout.EAST);
		setPanel.setBorder(BorderFactory.createTitledBorder("Setzen"));
		setPanel.add(new TextfieldView(model, setController));
		setSize(800, 600);
		setLocation(100, 100);
		setVisible(true);
	}

	public static void main(String[] args) {
		PollModel model = new PollModel("Was woll'n Sie denn trink'n?");
		String[] answers = new String[] { "Wasser", "Kaffee", "Tee", "Pils", "Weizen", "Weißwein", "Rotwein", "Rosé" };
		for (String s : answers) {
			model.addAnswer(s);
		}
		new PollMVC(model, "Poll");
	}
}
