package juegoTresEnRaya;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class UIRanking extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblSegundoNombre;
	private JLabel lblPrimeroNombre;
	private JLabel lblTerceroNombre;
	private JLabel lblTerceroVictorias;
	private JLabel lblSegundoVictorias;
	private JLabel lblPrimeroVictorias;
	private String[] top3Nombres;
	private Integer[] top3Puntos;
	
	/**
	 * Create the dialog.
	 */
	public UIRanking(final Ranking ranking) {
		top3Nombres = ranking.top3Nombres();
		top3Puntos = ranking.top3Puntos();
		setTitle("Ranking");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 253, 264);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 25, 27, 70, 20, 65, 0 };
		gbl_contentPanel.rowHeights = new int[] { 30, 30, 30, 29, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNombre = new JLabel("Nombre");
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre.gridx = 2;
			gbc_lblNombre.gridy = 0;
			contentPanel.add(lblNombre, gbc_lblNombre);
		}
		{
			JLabel lblNVictorias = new JLabel("Victorias");
			lblNVictorias.setFont(new Font("Tahoma", Font.BOLD, 11));
			GridBagConstraints gbc_lblNVictorias = new GridBagConstraints();
			gbc_lblNVictorias.insets = new Insets(0, 0, 5, 0);
			gbc_lblNVictorias.gridx = 4;
			gbc_lblNVictorias.gridy = 0;
			contentPanel.add(lblNVictorias, gbc_lblNVictorias);
		}
		{
			JLabel labelPrimeraPuntacion = new JLabel("1.");
			labelPrimeraPuntacion.setFont(new Font("Tahoma", Font.BOLD, 11));
			GridBagConstraints gbc_labelPrimeraPuntacion = new GridBagConstraints();
			gbc_labelPrimeraPuntacion.insets = new Insets(0, 0, 5, 5);
			gbc_labelPrimeraPuntacion.gridx = 0;
			gbc_labelPrimeraPuntacion.gridy = 1;
			contentPanel.add(labelPrimeraPuntacion, gbc_labelPrimeraPuntacion);
		}
		{
			lblPrimeroNombre = new JLabel(top3Nombres[0]);
			lblPrimeroNombre.setFont(new Font("Verdana", Font.ITALIC, 12));
			GridBagConstraints gbc_lblPrimeroNombre = new GridBagConstraints();
			gbc_lblPrimeroNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblPrimeroNombre.gridx = 2;
			gbc_lblPrimeroNombre.gridy = 1;
			contentPanel.add(lblPrimeroNombre, gbc_lblPrimeroNombre);
		}
		{
			lblPrimeroVictorias = new JLabel(top3Puntos[0].toString());
			GridBagConstraints gbc_lblPrimeroVictorias = new GridBagConstraints();
			gbc_lblPrimeroVictorias.insets = new Insets(0, 0, 5, 0);
			gbc_lblPrimeroVictorias.gridx = 4;
			gbc_lblPrimeroVictorias.gridy = 1;
			contentPanel.add(lblPrimeroVictorias, gbc_lblPrimeroVictorias);
		}
		{
			JLabel labelSegundaPuntuacion = new JLabel("2.");
			labelSegundaPuntuacion.setFont(new Font("Tahoma", Font.BOLD, 11));
			GridBagConstraints gbc_labelSegundaPuntuacion = new GridBagConstraints();
			gbc_labelSegundaPuntuacion.insets = new Insets(0, 0, 5, 5);
			gbc_labelSegundaPuntuacion.gridx = 0;
			gbc_labelSegundaPuntuacion.gridy = 2;
			contentPanel
					.add(labelSegundaPuntuacion, gbc_labelSegundaPuntuacion);
		}
		{
			lblSegundoNombre = new JLabel(top3Nombres[1]);
			lblSegundoNombre.setFont(new Font("Verdana", Font.ITALIC, 12));
			GridBagConstraints gbc_lblSegundoNombre = new GridBagConstraints();
			gbc_lblSegundoNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblSegundoNombre.gridx = 2;
			gbc_lblSegundoNombre.gridy = 2;
			contentPanel.add(lblSegundoNombre, gbc_lblSegundoNombre);
		}
		{
			lblSegundoVictorias = new JLabel(top3Puntos[1].toString());
			GridBagConstraints gbc_lblSegundoVictorias = new GridBagConstraints();
			gbc_lblSegundoVictorias.insets = new Insets(0, 0, 5, 0);
			gbc_lblSegundoVictorias.gridx = 4;
			gbc_lblSegundoVictorias.gridy = 2;
			contentPanel.add(lblSegundoVictorias, gbc_lblSegundoVictorias);
		}
		{
			JLabel labelTerceraPuntuacion = new JLabel("3.");
			labelTerceraPuntuacion.setFont(new Font("Tahoma", Font.BOLD, 11));
			GridBagConstraints gbc_labelTerceraPuntuacion = new GridBagConstraints();
			gbc_labelTerceraPuntuacion.insets = new Insets(0, 0, 5, 5);
			gbc_labelTerceraPuntuacion.gridx = 0;
			gbc_labelTerceraPuntuacion.gridy = 3;
			contentPanel
					.add(labelTerceraPuntuacion, gbc_labelTerceraPuntuacion);
		}
		{
			lblTerceroNombre = new JLabel(top3Nombres[2]);
			lblTerceroNombre.setFont(new Font("Verdana", Font.ITALIC, 12));
			GridBagConstraints gbc_lblTerceroNombre = new GridBagConstraints();
			gbc_lblTerceroNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblTerceroNombre.gridx = 2;
			gbc_lblTerceroNombre.gridy = 3;
			contentPanel.add(lblTerceroNombre, gbc_lblTerceroNombre);
		}
		{
			lblTerceroVictorias = new JLabel(top3Puntos[2].toString());
			GridBagConstraints gbc_labelTerceroVictorias = new GridBagConstraints();
			gbc_labelTerceroVictorias.insets = new Insets(0, 0, 5, 0);
			gbc_labelTerceroVictorias.gridx = 4;
			gbc_labelTerceroVictorias.gridy = 3;
			contentPanel.add(lblTerceroVictorias, gbc_labelTerceroVictorias);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Reiniciar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						ranking.reiniciar();
						top3Nombres = ranking.top3Nombres();
						top3Puntos = ranking.top3Puntos();
						lblPrimeroNombre.setText(top3Nombres[0]);
						lblSegundoNombre.setText(top3Nombres[1]);
						lblTerceroNombre.setText(top3Nombres[2]);
						lblPrimeroVictorias.setText(top3Puntos[0].toString());
						lblSegundoVictorias.setText(top3Puntos[1].toString());
						lblTerceroVictorias.setText(top3Puntos[2].toString());
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
