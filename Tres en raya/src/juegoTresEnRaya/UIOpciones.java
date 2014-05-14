package juegoTresEnRaya;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

public class UIOpciones extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private JTextField lblNombreJ1;
	private JTextField lblNombreJ2;
	
	private JList tipoFichaJ1;
	private JList tipoFichaJ2;
	
	private JRadioButton rdbtnTipoJ1Humano;
	private JRadioButton rdbtnTipoJ2Humano;
	private JRadioButton rdbtnTipoJ1CPU;
	private JRadioButton rdbtnTipoJ2CPU;
	private ButtonGroup grupoJ1;
	private ButtonGroup grupoJ2;
	
	/**
	 * Create the dialog.
	 */
	public UIOpciones(final TresEnRaya juego) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				guardarOpciones(juego);
				dispose();
			}
		});
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				
		setResizable(false);
		setModal(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("Opciones");
		setBounds(100, 100, 440, 240);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(180, 180, 180)), "Jugador 1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 197, 156);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				lblNombreJ1 = new JTextField("Jugador 1");
				lblNombreJ1.setSelectionStart(0);
				lblNombreJ1.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblNombreJ1.setBounds(21, 21, 154, 23);
				panel.add(lblNombreJ1);
				
				rdbtnTipoJ1Humano = new JRadioButton("Humano");
				rdbtnTipoJ1Humano.setActionCommand("Humano");
				rdbtnTipoJ1Humano.setSelected(true);
				rdbtnTipoJ1Humano.setBounds(24, 79, 65, 23);
				panel.add(rdbtnTipoJ1Humano);
				
				rdbtnTipoJ1CPU = new JRadioButton("CPU");
				rdbtnTipoJ1CPU.setActionCommand("CPU");
				rdbtnTipoJ1CPU.setBounds(24, 105, 45, 23);
				panel.add(rdbtnTipoJ1CPU);

				grupoJ1 = new ButtonGroup();
				grupoJ1.add(rdbtnTipoJ1Humano);
				grupoJ1.add(rdbtnTipoJ1CPU);
				
				tipoFichaJ1 = new JList();
				tipoFichaJ1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				tipoFichaJ1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tipoFichaJ1.setModel(new AbstractListModel() {
					String[] values = new String[] {"Azul", "Naranja", "Rojo", "Verde"};
					public int getSize() {
						return values.length;
					}
					public Object getElementAt(int index) {
						return values[index];
					}
				});
				tipoFichaJ1.setSelectedIndex(0);
				tipoFichaJ1.setBounds(110, 79, 65, 66);
				panel.add(tipoFichaJ1);
				
				JLabel lblControl = new JLabel("Control");
				lblControl.setBounds(43, 55, 46, 14);
				panel.add(lblControl);
				
				JLabel lblColor = new JLabel("Ficha");
				lblColor.setBounds(129, 55, 46, 14);
				panel.add(lblColor);
				
				JPanel panel_J2 = new JPanel();
				panel_J2.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(180, 180, 180)), "Jugador 2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_J2.setLayout(null);
				panel_J2.setBounds(227, 11, 197, 156);
				contentPanel.add(panel_J2);
				
				lblNombreJ2 = new JTextField("Máquina");
				lblNombreJ2.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblNombreJ2.setBounds(21, 21, 154, 23);
				panel_J2.add(lblNombreJ2);
				
				rdbtnTipoJ2Humano = new JRadioButton("Humano");
				rdbtnTipoJ2Humano.setActionCommand("Humano");
				rdbtnTipoJ2Humano.setBounds(23, 79, 65, 23);
				panel_J2.add(rdbtnTipoJ2Humano);
				
				rdbtnTipoJ2CPU = new JRadioButton("CPU");
				rdbtnTipoJ2CPU.setActionCommand("CPU");
				rdbtnTipoJ2CPU.setSelected(true);
				rdbtnTipoJ2CPU.setBounds(23, 105, 45, 23);
				panel_J2.add(rdbtnTipoJ2CPU);
				
				tipoFichaJ2 = new JList();
				tipoFichaJ2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tipoFichaJ2.setModel(new AbstractListModel() {
					String[] values = new String[] {"Azul", "Naranja", "Rojo", "Verde"};
					public int getSize() {
						return values.length;
					}
					public Object getElementAt(int index) {
						return values[index];
					}
				});
				tipoFichaJ2.setSelectedIndex(1);
				tipoFichaJ2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				tipoFichaJ2.setBounds(109, 79, 65, 66);
				panel_J2.add(tipoFichaJ2);
				
				JLabel label_1 = new JLabel("Control");
				label_1.setBounds(42, 55, 46, 14);
				panel_J2.add(label_1);
				
				JLabel lblFicha = new JLabel("Ficha");
				lblFicha.setBounds(128, 55, 46, 14);
				panel_J2.add(lblFicha);
				
				grupoJ2 = new ButtonGroup();
				grupoJ2.add(rdbtnTipoJ2Humano);
				grupoJ2.add(rdbtnTipoJ2CPU);
				
				// Obtiene valores de los jugadores si ya existen.
				if (juego.getEstado() != Estado.INICIANDO) {
					// Nombre
					lblNombreJ1.setText(juego.jugador1.getNombre());
					lblNombreJ2.setText(juego.jugador2.getNombre());
					
					// Humano o CPU
					if (juego.jugador1.getTipoJugador() == TipoJugador.HUMANO) {
						rdbtnTipoJ1Humano.setSelected(true);
						rdbtnTipoJ1CPU.setSelected(false);
					}
					else {
						rdbtnTipoJ1Humano.setSelected(false);
						rdbtnTipoJ1CPU.setSelected(true);
					}
					if (juego.jugador2.getTipoJugador() == TipoJugador.HUMANO) {
						rdbtnTipoJ2Humano.setSelected(true);
						rdbtnTipoJ2CPU.setSelected(false);
					}
					else {
						rdbtnTipoJ2Humano.setSelected(false);
						rdbtnTipoJ2CPU.setSelected(true);
					}

					// Fichas
					// "Azul", "Naranja", "Rojo", "Verde"
					if (juego.jugador1.getTipoFicha() == Color.BLUE)
						tipoFichaJ1.setSelectedIndex(0);
					if (juego.jugador1.getTipoFicha() == Color.ORANGE)
						tipoFichaJ1.setSelectedIndex(1);
					if (juego.jugador1.getTipoFicha() == Color.RED)
						tipoFichaJ1.setSelectedIndex(2);
					if (juego.jugador1.getTipoFicha() == Color.GREEN)
						tipoFichaJ1.setSelectedIndex(3);
					
					if (juego.jugador2.getTipoFicha() == Color.BLUE)
						tipoFichaJ2.setSelectedIndex(0);
					if (juego.jugador2.getTipoFicha() == Color.ORANGE)
						tipoFichaJ2.setSelectedIndex(1);
					if (juego.jugador2.getTipoFicha() == Color.RED)
						tipoFichaJ2.setSelectedIndex(2);
					if (juego.jugador2.getTipoFicha() == Color.GREEN)
						tipoFichaJ2.setSelectedIndex(3);
					
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (tipoFichaJ1.getSelectedIndex() == tipoFichaJ2.getSelectedIndex())
						{
							UIError error = new UIError();
							error.setDefaultCloseOperation(error.DISPOSE_ON_CLOSE);
							error.setLocationRelativeTo(contentPanel);
							error.setVisible(true);
						}
						else {
							guardarOpciones(juego);
							dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			if (juego.getEstado() != Estado.INICIANDO)
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void guardarOpciones(final TresEnRaya juego) {			
			// Obtiene el nombre de los jugadores
			String nombreJ1 = lblNombreJ1.getText();
			String nombreJ2 = lblNombreJ2.getText();
			
			// Obtiene el tipo de los jugadores
			TipoJugador tipoJ1;
			TipoJugador tipoJ2;
			if (grupoJ1.getSelection().getActionCommand().equals("Humano"))
				tipoJ1 = TipoJugador.HUMANO;
			else
				tipoJ1 = TipoJugador.CPU;
			if (grupoJ2.getSelection().getActionCommand().equals("Humano"))
				tipoJ2 = TipoJugador.HUMANO;
			else
				tipoJ2 = TipoJugador.CPU;
			
			// Obtiene el tipo de ficha de los jugadores
			Color fichaJ1 = null;
			Color fichaJ2 = null;
			switch(tipoFichaJ1.getSelectedValue().toString()) {
				case "Azul":
					fichaJ1 = Color.BLUE;
					break;
				case "Naranja":
					fichaJ1 = Color.ORANGE;
					break;
				case "Rojo":
					fichaJ1 = Color.RED;
					break;
				case "Verde":
					fichaJ1 = Color.GREEN;
					break;
			}

			switch(tipoFichaJ2.getSelectedValue().toString()) {
				case "Azul":
					fichaJ2 = Color.BLUE;
					break;
				case "Naranja":
					fichaJ2 = Color.ORANGE;
					break;
				case "Rojo":
					fichaJ2 = Color.RED;
					break;
				case "Verde":
					fichaJ2 = Color.GREEN;
					break;
			}

			if (juego.getEstado() == Estado.INICIANDO) {
				// Crea los objetos de Jugador en el juego con los datos obtenidos.
				juego.setJugador1(new Jugador(nombreJ1, tipoJ1, fichaJ1));
				juego.setJugador2(new Jugador(nombreJ2, tipoJ2, fichaJ2));
			}
			else {
				juego.getJugador1().setNombre(nombreJ1);
				juego.getJugador2().setNombre(nombreJ2);
				juego.getJugador1().setTipoJugador(tipoJ1);
				juego.getJugador2().setTipoJugador(tipoJ2);
				juego.getJugador1().setTipoFicha(fichaJ1);
				juego.getJugador2().setTipoFicha(fichaJ2);
			}
			
			System.out.println("Jugador 1: " + nombreJ1 + ", tipo: " + tipoJ1.toString() + ", ficha: " + fichaJ1);
			System.out.println("Jugador 2: " + nombreJ2 + ", tipo: " + tipoJ2.toString() + ", ficha: " + fichaJ2);
			
			
	}
}
