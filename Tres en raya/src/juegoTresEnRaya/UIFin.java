package juegoTresEnRaya;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class UIFin extends JDialog {

	/**
	 * 
	 */
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public UIFin(final TresEnRaya juego) {
		setResizable(false);
		setTitle("Partida Finalizada");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 240, 220);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextArea txtrTresEnRaya = new JTextArea();
			txtrTresEnRaya.setLineWrap(true);
			txtrTresEnRaya.setWrapStyleWord(true);
			txtrTresEnRaya.setEditable(false);
			txtrTresEnRaya.setBackground(UIManager.getColor("Panel.background"));
			txtrTresEnRaya.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtrTresEnRaya.setBounds(10, 57, 212, 94);
			txtrTresEnRaya.setText("¡" + juego.jugadorActual.getNombre() + " gana la partida! ¡Enhorabuena!\r\n\r\n¿Quieres comenzar otra partida?");
			contentPanel.add(txtrTresEnRaya);
		}
		
		JLabel lblTresEnRaya = new JLabel("¡Has ganado!");
		lblTresEnRaya.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTresEnRaya.setHorizontalAlignment(SwingConstants.CENTER);
		lblTresEnRaya.setBounds(10, 11, 212, 35);
		contentPanel.add(lblTresEnRaya);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						juego.iniciarPartida();
						dispose();
					}
				});
				buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						juego.setEstado(Estado.FINALIZADO_ESPERAR);
						dispose();
					}
				});
				cancelButton.setActionCommand("OK");
				buttonPane.add(cancelButton);
			}
		}
	}
}
