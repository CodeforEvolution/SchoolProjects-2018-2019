import javax.swing.*;

public class DialogViewer {
	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog("Hello, what is your name?");
		JOptionPane.showMessageDialog(null, "Hello, " + name + "!");
		System.exit(0);
	}
}
