package poll.view;

import javax.swing.JOptionPane;

public class ExceptionDialog {
	public ExceptionDialog(Exception e) {
		String message = e.getMessage() + "\nStack Trace:\n";
		for (StackTraceElement line : e.getStackTrace()) {
			message += line.toString() + "\n";
		}
		JOptionPane.showMessageDialog(null, message, "RMI Exception", JOptionPane.ERROR_MESSAGE);
	}
}
