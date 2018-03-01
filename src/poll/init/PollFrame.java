package poll.init;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.rmi.RemoteException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import poll.model.PollList;

import poll.view.AnswerAddView;
import poll.view.BarView;
import poll.view.LabelView;
import poll.view.TextfieldView;
import poll.view.RemoteExceptionView;

public class PollFrame extends JFrame {
	public PollFrame(PollList polls, String q) throws RemoteException {
		super(q);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel topPanel = new JPanel(new GridLayout(1, 0, 2, 2));
		add(topPanel, BorderLayout.NORTH);
		JPanel questionPanel = new JPanel();
		topPanel.add(questionPanel);
		questionPanel.add(new JLabel(q));
		questionPanel.setBorder(BorderFactory.createTitledBorder("Frage"));
		JPanel newAnswerPanel = new JPanel();
		topPanel.add(newAnswerPanel);
		JPanel centerPanel = new JPanel(new GridLayout(1, 0, 2, 2));
		add(centerPanel, BorderLayout.CENTER);
		newAnswerPanel.add(new AnswerAddView(polls, q));
		newAnswerPanel.setBorder(BorderFactory.createTitledBorder("Neue Antwortmöglichkeit hinzufügen"));
		JPanel incrementPanel = new JPanel();
		centerPanel.add(incrementPanel);
		incrementPanel.add(new LabelView(polls, q));
		incrementPanel.setBorder(BorderFactory.createTitledBorder("Erhöhen"));
		JPanel setPanel = new JPanel();
		centerPanel.add(setPanel, BorderLayout.EAST);
		setPanel.setBorder(BorderFactory.createTitledBorder("Setzen"));
		setPanel.add(new TextfieldView(polls, q));
		JPanel lowerPanel = new JPanel(new GridLayout(1, 0, 2, 2));
		add(lowerPanel, BorderLayout.SOUTH);
		JPanel barPanel = new JPanel();
		barPanel.add(new BarView(polls, q));
		barPanel.setBorder(BorderFactory.createTitledBorder("Balkendiagramm"));
		lowerPanel.add(barPanel);
		setSize(800, 600);
		setLocation(100, 100);
		setVisible(true);
	}
}
