package juegoTresEnRaya;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dialog.ModalityType;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;

public class UIAcercaDe extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public UIAcercaDe() {
		setResizable(false);
		setTitle("Acerca de");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 240, 220);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextArea txtrTresEnRaya = new JTextArea();
			txtrTresEnRaya.setEditable(false);
			txtrTresEnRaya.setBackground(UIManager.getColor("Panel.background"));
			txtrTresEnRaya.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtrTresEnRaya.setBounds(10, 57, 212, 94);
			txtrTresEnRaya.setText("Programa realizado por:\r\n\r\nAlejandro Gutiérrez Lozano\r\nDaniel Gutiérrez Lozano\r\n\r\nProgramación - 1º DAW");
			contentPanel.add(txtrTresEnRaya);
		}
		
		JLabel lblTresEnRaya = new JLabel("Tres en raya");
		lblTresEnRaya.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTresEnRaya.setHorizontalAlignment(SwingConstants.CENTER);
		lblTresEnRaya.setBounds(10, 11, 212, 35);
		contentPanel.add(lblTresEnRaya);
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
