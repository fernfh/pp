package poll.view;

import java.rmi.RemoteException;

import javax.swing.JOptionPane;

public class RemoteExceptionView {
	public RemoteExceptionView(RemoteException e) {
		String message = e.getMessage() + "\nStack Trace:\n";
		for (StackTraceElement line : e.getStackTrace()) {
			message += line.toString() + "\n";
		}
		JOptionPane.showMessageDialog(null, message, "RMI Exception", JOptionPane.ERROR_MESSAGE);
	}
}
