package adivinalo;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

/**
 * 
 * Interfaz del juego "Adivinalo"
 * 
 * @author Daniel GL, Alejandro GL
 * @version 1.0
 * 
 */
public class AdivinaloUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtfieldNumero;
	private JMenuItem mntmBorrar; 
	private JLabel lblValorintentos;
	private JLabel lblValorrecord;
	private JLabel lblError;
	private JLabel lblAyuda;
	private final Adivinalo partida;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdivinaloUI frame = new AdivinaloUI();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdivinaloUI() {
		partida = new Adivinalo();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 260, 344);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnJuego = new JMenu("Juego");
		menuBar.add(mnJuego);
		
		JMenuItem mntmNuevaPartida = new JMenuItem("Nueva partida");
		mntmNuevaPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				partida.reiniciarPartida();
				lblValorintentos.setText(partida.getIntentos().toString());
				lblValorrecord = new JLabel(partida.getRecordString());
			}
		});
		mnJuego.add(mntmNuevaPartida);
		
		mntmBorrar = new JMenuItem("Borrar record");
		if (partida.getRecord() == -1)
			mntmBorrar.setEnabled(false);
		mntmBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				partida.borrarRecord();
				mntmBorrar.setEnabled(false);
				lblValorrecord.setText(partida.getRecordString());
			}
		});
		mnJuego.add(mntmBorrar);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnJuego.add(mntmSalir);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmInstrucciones = new JMenuItem("Instrucciones");
		mntmInstrucciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdivinaloAyuda dialog = new AdivinaloAyuda();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);
			}
		});
		
		mnAyuda.add(mntmInstrucciones);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdivinaloAcercaDe dialog = new AdivinaloAcercaDe();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);
			}
		});
		
		mnAyuda.add(mntmAcercaDe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{250, 0};
		gbl_contentPane.rowHeights = new int[]{14, 30, 30, 34, 14, 0, 30, 0, 23, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{55, 65, 0};
		gbl_panel.rowHeights = new int[]{14, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblIntentos = new JLabel("Intentos: ");
		GridBagConstraints gbc_lblIntentos = new GridBagConstraints();
		gbc_lblIntentos.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblIntentos.insets = new Insets(0, 0, 5, 5);
		gbc_lblIntentos.gridx = 0;
		gbc_lblIntentos.gridy = 0;
		panel.add(lblIntentos, gbc_lblIntentos);
		lblIntentos.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblValorintentos = new JLabel(partida.getIntentos().toString());
		GridBagConstraints gbc_lblValorintentos = new GridBagConstraints();
		gbc_lblValorintentos.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblValorintentos.insets = new Insets(0, 0, 5, 0);
		gbc_lblValorintentos.gridx = 1;
		gbc_lblValorintentos.gridy = 0;
		panel.add(lblValorintentos, gbc_lblValorintentos);
		
		JLabel lblRecord = new JLabel("Record: ");
		GridBagConstraints gbc_lblRecord = new GridBagConstraints();
		gbc_lblRecord.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblRecord.insets = new Insets(0, 0, 0, 5);
		gbc_lblRecord.gridx = 0;
		gbc_lblRecord.gridy = 1;
		panel.add(lblRecord, gbc_lblRecord);
		lblRecord.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblValorrecord = new JLabel(partida.getRecordString());
		GridBagConstraints gbc_lblValorrecord = new GridBagConstraints();
		gbc_lblValorrecord.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblValorrecord.gridx = 1;
		gbc_lblValorrecord.gridy = 1;
		panel.add(lblValorrecord, gbc_lblValorrecord);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 3;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{60, 60, 60, 0};
		gbl_panel_1.rowHeights = new int[] {30, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		txtfieldNumero = new JTextField();
		GridBagConstraints gbc_txtfieldNumero = new GridBagConstraints();
		gbc_txtfieldNumero.insets = new Insets(0, 0, 0, 5);
		gbc_txtfieldNumero.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfieldNumero.gridx = 1;
		gbc_txtfieldNumero.gridy = 0;
		panel_1.add(txtfieldNumero, gbc_txtfieldNumero);
		txtfieldNumero.setColumns(5);
		txtfieldNumero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comprobarNumeroUI(partida);
			}
		});
		
		JButton btnComprobar = new JButton("Comprobar");
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comprobarNumeroUI(partida);
			}
		});
		
		lblAyuda = new JLabel("Introduce un numero entre " + partida.getValorMin() + " y " + partida.getValorMax());
		GridBagConstraints gbc_lblAyuda = new GridBagConstraints();
		gbc_lblAyuda.insets = new Insets(0, 0, 5, 0);
		gbc_lblAyuda.gridx = 0;
		gbc_lblAyuda.gridy = 4;
		contentPane.add(lblAyuda, gbc_lblAyuda);
		GridBagConstraints gbc_btnComprobar = new GridBagConstraints();
		gbc_btnComprobar.insets = new Insets(0, 0, 5, 0);
		gbc_btnComprobar.gridx = 0;
		gbc_btnComprobar.gridy = 6;
		contentPane.add(btnComprobar, gbc_btnComprobar);
		
		lblError = new JLabel(" ");
		lblError.setForeground(Color.RED);
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.insets = new Insets(0, 0, 5, 0);
		gbc_lblError.gridx = 0;
		gbc_lblError.gridy = 7;
		contentPane.add(lblError, gbc_lblError);
	}
	
	private void comprobarNumeroUI(Adivinalo partida) {
		try {
			ValorRetorno resultado = partida.comprobarNumero(Integer.parseInt(txtfieldNumero.getText()));
			
			lblValorintentos.setText(partida.getIntentos().toString());
			
			lblError.setText(" ");
			if (resultado == ValorRetorno.ES_MENOR) {
				lblError.setText("El número que buscas es menor.");
			}
			else if (resultado == ValorRetorno.ES_MAYOR) {
				lblError.setText("El número que buscas es mayor.");
			}
			
			else if (resultado == ValorRetorno.ES_CORRECTO || resultado == ValorRetorno.ES_CORRECTO_NUEVO_RECORD || resultado == ValorRetorno.ES_CORRECTO_MISMO_RECORD) {
				lblValorintentos.setText(partida.getIntentos().toString());
				lblValorrecord.setText(partida.setRecordString());
				AdivinaloDialogoCorrecto dialog = new AdivinaloDialogoCorrecto(resultado);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);
				
				partida.nuevaPartida();
				lblValorintentos.setText(partida.getIntentos().toString());
				lblValorrecord = new JLabel(partida.getRecordString());
				if (partida.getRecord() > -1)
					mntmBorrar.setEnabled(true);
			}
			
		}
		catch (NumberFormatException e) {
			lblError.setText("Introduce un número válido.");
		}
	}

}
