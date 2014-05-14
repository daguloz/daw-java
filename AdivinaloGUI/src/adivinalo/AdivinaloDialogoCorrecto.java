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

/**
 * 
 * Dialogo de numero correcto del juego "Adivinalo"
 * 
 * @author Daniel GL, Alejandro GL
 * @version 1.0
 * 
 */
public class AdivinaloDialogoCorrecto extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public AdivinaloDialogoCorrecto(ValorRetorno valorRetorno) {
		setTitle("Correcto");
		setBounds(100, 100, 200, 158);
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
			okButton.setBounds(65, 85, 49, 23);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JTextArea txtpnAdivinaNumeros = new JTextArea();
			txtpnAdivinaNumeros.setBounds(10, 11, 164, 50);
			txtpnAdivinaNumeros.setLineWrap(true);
			txtpnAdivinaNumeros.setEditable(false);
			txtpnAdivinaNumeros.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtpnAdivinaNumeros.setBackground(Color.WHITE);
			String texto;
			if (valorRetorno == ValorRetorno.ES_CORRECTO_NUEVO_RECORD)
				texto = "¡Sí! ¡El número es correcto, y has conseguido un nuevo record!";
			else if (valorRetorno == ValorRetorno.ES_CORRECTO_MISMO_RECORD)
				texto = "¡Sí! ¡El número es correcto, y has igualado el record!";
			else
				texto = "¡Sí! ¡El número es correcto!";
			
			txtpnAdivinaNumeros.setText(texto);
			contentPanel.add(txtpnAdivinaNumeros);
		}
	}

}
