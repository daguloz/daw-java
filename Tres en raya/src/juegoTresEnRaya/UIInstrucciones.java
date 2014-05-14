package juegoTresEnRaya;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Dialog.ModalityType;

public class UIInstrucciones extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel txtTresEnRaya;

	/**
	 * Create the dialog.
	 */
	public UIInstrucciones() {
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("Instrucciones");
		setBounds(100, 100, 240, 320);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtTresEnRaya = new JLabel();
			txtTresEnRaya.setFont(new Font("Tahoma", Font.BOLD, 24));
			txtTresEnRaya.setBackground(UIManager.getColor("Panel.background"));
			txtTresEnRaya.setHorizontalAlignment(SwingConstants.CENTER);
			txtTresEnRaya.setBounds(10, 11, 214, 30);
			txtTresEnRaya.setText("Tres en raya");
			contentPanel.add(txtTresEnRaya);
		}
		
		JTextArea txtrHh = new JTextArea();
		txtrHh.setWrapStyleWord(true);
		txtrHh.setLineWrap(true);
		txtrHh.setEditable(false);
		txtrHh.setBackground(UIManager.getColor("Panel.background"));
		txtrHh.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtrHh.setText("El juego consiste en hacer una línea, usando solamente tres fichas.\r\n\r\nPara colocar una ficha, cada jugador debe hacer click sobre una casilla del tablero durante su turno.\r\n\r\nUna vez que un jugador tiene tres fichas en el tablero, durante su turno deberá mover una de las fichas a una posición adjunta y que no esté ocupada por otra ficha. Para ello, puedes seleccionar una ficha haciendo click, y posteriormente elegir la casilla a la que se hará el movimiento.");
		txtrHh.setBounds(10, 52, 214, 199);
		contentPanel.add(txtrHh);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
