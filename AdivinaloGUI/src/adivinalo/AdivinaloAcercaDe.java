package adivinalo;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdivinaloAcercaDe extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AdivinaloAcercaDe dialog = new AdivinaloAcercaDe();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AdivinaloAcercaDe() {
		setTitle("Acerca de");
		setBounds(100, 100, 200, 216);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			okButton.setBounds(65, 143, 49, 23);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JTextArea txtpnAdivinaNumeros = new JTextArea();
			txtpnAdivinaNumeros.setBounds(10, 11, 172, 99);
			txtpnAdivinaNumeros.setLineWrap(true);
			txtpnAdivinaNumeros.setEditable(false);
			txtpnAdivinaNumeros.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtpnAdivinaNumeros.setBackground(Color.WHITE);
			txtpnAdivinaNumeros.setText("Programa realizado por:\n"
					+ "Alejandro Gutiérrez Lozano\n"
					+ "Daniel Gutiérrez Lozano\n\n"
					+ "Programación 1º DAW");
			contentPanel.add(txtpnAdivinaNumeros);
		}
	}

}
