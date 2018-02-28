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
import poll.model.Poll;
import poll.view.AnswerAddView;
import poll.view.BarView;
import poll.view.LabelView;
import poll.view.TextfieldView;

public class PollFrame extends JFrame {
	public PollFrame(Poll model, String title) {
		super(title);
		SetController setController = new SetController(model);
		AddAnswersController addAnswerController = new AddAnswersController(model);
		IncrementController incrController = new IncrementController(model);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel topPanel = new JPanel(new GridLayout(1, 0, 2, 2));
		add(topPanel, BorderLayout.NORTH);
		JPanel questionPanel = new JPanel();
		topPanel.add(questionPanel);
		questionPanel.add(new JLabel(model.getQuestion()));
		questionPanel.setBorder(BorderFactory.createTitledBorder("Frage"));
		JPanel newAnswerPanel = new JPanel();
		topPanel.add(newAnswerPanel);
		JPanel centerPanel = new JPanel(new GridLayout(1, 0, 2, 2));
		add(centerPanel, BorderLayout.CENTER);
		newAnswerPanel.add(new AnswerAddView(model, addAnswerController));
		newAnswerPanel.setBorder(BorderFactory.createTitledBorder("Neue Antwortmöglichkeit hinzufügen"));
		JPanel incrementPanel = new JPanel();
		centerPanel.add(incrementPanel);
		incrementPanel.add(new LabelView(model, incrController));
		incrementPanel.setBorder(BorderFactory.createTitledBorder("Erhöhen"));
		JPanel setPanel = new JPanel();
		centerPanel.add(setPanel, BorderLayout.EAST);
		setPanel.setBorder(BorderFactory.createTitledBorder("Setzen"));
		setPanel.add(new TextfieldView(model, setController));
		JPanel lowerPanel = new JPanel(new GridLayout(1, 0, 2, 2));
		add(lowerPanel, BorderLayout.SOUTH);
		JPanel barPanel = new JPanel();
		barPanel.add(new BarView(model));
		barPanel.setBorder(BorderFactory.createTitledBorder("Balkendiagramm"));
		lowerPanel.add(barPanel);
		setSize(800, 600);
		setLocation(100, 100);
		setVisible(true);
	}
}
