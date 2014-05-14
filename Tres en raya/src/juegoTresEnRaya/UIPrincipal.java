package juegoTresEnRaya;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class UIPrincipal extends JFrame {

	private JPanel contentPane;
	private static UIPrincipal frame;
	
	private ArrayList<JButton> casillasUI = new ArrayList<JButton>();
	
	private static final TresEnRaya juego = new TresEnRaya();
	private JLabel lblTurnoActual;
	private JLabel lblNombreJ2;
	private JLabel lblNombreJ1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
			
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new UIPrincipal();
					frame.setLocationRelativeTo(frame);
					frame.setVisible(true);
					
					UIOpciones opciones = new UIOpciones(juego);
					opciones.setDefaultCloseOperation(opciones.DISPOSE_ON_CLOSE);
					opciones.setLocationRelativeTo(frame);
					opciones.setVisible(true);
					juego.iniciarPartida();
					
					frame.actualizarTextosUI();
					frame.actualizarTurnoUI();
					
					//while (juego.getEstado() == Estado.EN_PARTIDA)
						//esperarTurno();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UIPrincipal() {
		setResizable(false);
		setTitle("Tres en raya");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 356);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnJuego = new JMenu("Juego");
		menuBar.add(mnJuego);
		
		JMenuItem mntmNuevaPartida = new JMenuItem("Nueva partida");
		mntmNuevaPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juego.iniciarPartida();
				borrarTablero();
			}
		});
		mnJuego.add(mntmNuevaPartida);
		
		JMenuItem mntmOpciones = new JMenuItem("Opciones");
		mntmOpciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{UIOpciones opciones = new UIOpciones(juego);
				opciones.setDefaultCloseOperation(opciones.DISPOSE_ON_CLOSE);
				opciones.setLocationRelativeTo(frame);
				opciones.setVisible(true);
				actualizarTablero();
				actualizarTextosUI();
			} catch (Exception g) {
				g.printStackTrace();
			}
			}
		});
		mnJuego.add(mntmOpciones);
		
		JMenuItem mntmRanking = new JMenuItem("Ranking");
		mntmRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					UIRanking ranking = new UIRanking(juego.getRanking());
					ranking.setDefaultCloseOperation(ranking.DISPOSE_ON_CLOSE);
					ranking.setLocationRelativeTo(frame);
					ranking.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		mnJuego.add(mntmRanking);
		
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
				try{UIInstrucciones ayuda = new UIInstrucciones();
				ayuda.setDefaultCloseOperation(ayuda.DISPOSE_ON_CLOSE);
				ayuda.setLocationRelativeTo(frame);
				ayuda.setVisible(true);
			} catch (Exception f) {
				f.printStackTrace();
			}
			}
		});
		mnAyuda.add(mntmInstrucciones);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{UIAcercaDe acerca = new UIAcercaDe();
				acerca.setDefaultCloseOperation(acerca.DISPOSE_ON_CLOSE);
				acerca.setLocationRelativeTo(frame);
				acerca.setVisible(true);
			} catch (Exception f) {
				f.printStackTrace();
			}
			}
		});
		mnAyuda.add(mntmAcercaDe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_tablero = new JPanel();
		panel_tablero.setBounds(5, 5, 292, 292);
		contentPane.add(panel_tablero);
		panel_tablero.setLayout(null);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_11.setBounds(10, 10, 90, 90);
		panel_tablero.add(panel_11);
		panel_11.setLayout(null);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_12.setBounds(100, 10, 90, 90);
		panel_tablero.add(panel_12);
		panel_12.setLayout(null);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_13.setBounds(190, 10, 90, 90);
		panel_tablero.add(panel_13);
		panel_13.setLayout(null);
		
		JPanel panel_21 = new JPanel();
		panel_21.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_21.setBounds(10, 100, 90, 90);
		panel_tablero.add(panel_21);
		panel_21.setLayout(null);
		
		JPanel panel_22 = new JPanel();
		panel_22.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_22.setBounds(100, 100, 90, 90);
		panel_tablero.add(panel_22);
		panel_22.setLayout(null);
		
		JPanel panel_23 = new JPanel();
		panel_23.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_23.setBounds(190, 100, 90, 90);
		panel_tablero.add(panel_23);
		panel_23.setLayout(null);
		
		JPanel panel_31 = new JPanel();
		panel_31.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_31.setBounds(10, 190, 90, 90);
		panel_tablero.add(panel_31);
		panel_31.setLayout(null);
		
		JPanel panel_32 = new JPanel();
		panel_32.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_32.setBounds(100, 190, 90, 90);
		panel_tablero.add(panel_32);
		panel_32.setLayout(null);
		
		JPanel panel_33 = new JPanel();
		panel_33.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_33.setBounds(190, 190, 90, 90);
		panel_tablero.add(panel_33);
		panel_33.setLayout(null);
		
		for (Integer i = 0; i < 9; i++) {
			JButton casilla = (new JButton());
			casilla.setFocusable(false);
			casilla.setBorder(null);
			casilla.setBackground(UIManager.getColor("Panel.background"));
			casilla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			casilla.setBounds(10, 11, 70, 70);
			
			casillasUI.add(casilla);
			
		}
		
		
		casillasUI.get(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				juego.casillaPulsada(0);
				actualizarTablero();
			}
		});
		
		casillasUI.get(1).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				juego.casillaPulsada(1);
				actualizarTablero();
			}
		});
		
		casillasUI.get(2).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				juego.casillaPulsada(2);
				actualizarTablero();
			}
		});
		
		casillasUI.get(3).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				juego.casillaPulsada(3);
				actualizarTablero();
			}
		});
		
		casillasUI.get(4).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				juego.casillaPulsada(4);
				actualizarTablero();
			}
		});
		
		casillasUI.get(5).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				juego.casillaPulsada(5);
				actualizarTablero();
			}
		});
		
		casillasUI.get(6).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				juego.casillaPulsada(6);
				actualizarTablero();
			}
		});
		
		casillasUI.get(7).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				juego.casillaPulsada(7);
				actualizarTablero();
			}
		});
		
		casillasUI.get(8).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				juego.casillaPulsada(8);
				actualizarTablero();
			}
		});
		
		panel_11.add(casillasUI.get(0));
		panel_12.add(casillasUI.get(1));
		panel_13.add(casillasUI.get(2));
		panel_21.add(casillasUI.get(3));
		panel_22.add(casillasUI.get(4));
		panel_23.add(casillasUI.get(5));
		panel_31.add(casillasUI.get(6));
		panel_32.add(casillasUI.get(7));
		panel_33.add(casillasUI.get(8));
		
		
		JPanel panel_info = new JPanel();
		panel_info.setBounds(307, 5, 150, 292);
		contentPane.add(panel_info);
		panel_info.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(20, 11, 100, 50);
		panel_info.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTurno = new JLabel("Turno");
		lblTurno.setBounds(29, 5, 42, 17);
		panel_2.add(lblTurno);
		lblTurno.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblTurnoActual = new JLabel("turnoActual");
		lblTurnoActual.setBounds(18, 27, 64, 15);
		panel_2.add(lblTurnoActual);
		lblTurnoActual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(20, 170, 100, 50);
		panel_info.add(panel_3);
		panel_3.setLayout(null);
		
		lblNombreJ1 = new JLabel("nombreJ1");
		lblNombreJ1.setBounds(15, 5, 70, 17);
		panel_3.add(lblNombreJ1);
		lblNombreJ1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(20, 231, 100, 50);
		panel_info.add(panel_4);
		panel_4.setLayout(null);
		
		lblNombreJ2 = new JLabel("nombreJ2");
		lblNombreJ2.setBounds(15, 5, 70, 17);
		lblNombreJ2.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_4.add(lblNombreJ2);
		
	}
	
	private void actualizarTablero() {
		Tablero tablero = juego.getTablero();
		
		actualizarFichas(tablero);
		
		if (juego.getEstado() == Estado.FINALIZADO) {
			UIFin fin = new UIFin(juego);
			fin.setDefaultCloseOperation(fin.DISPOSE_ON_CLOSE);
			fin.setLocationRelativeTo(frame);
			fin.setVisible(true);
			if (juego.getEstado() == Estado.FINALIZADO)
				borrarTablero();
		}
		actualizarTurnoUI();
	
	}

	private void actualizarFichas(Tablero tablero) {
		for (int i = 0; i < casillasUI.size(); i++) {
			Casilla casilla = tablero.getCasilla(i);
			if (casilla.getFicha() != null) {
				if (juego.getCasillaSeleccionada() == casilla) {
					// Si la casilla esta seleccionada, la pintamos de un color más claro.
					Color colorAntiguo = casilla.getJugador().getTipoFicha();
					int r = colorAntiguo.getRed() + 160;
					int g = colorAntiguo.getGreen() + 160;
					int b = colorAntiguo.getBlue() + 160;
					if (r > 255)
						r = 255;
					if (g > 255)
						g = 255;
					if (b > 255)
						b = 255;
					Color colorNuevo = new Color(r, g, b);
					casillasUI.get(i).setBackground(colorNuevo);
				}
				else
					casillasUI.get(i).setBackground(casilla.getJugador().getTipoFicha());
			}
			else
				casillasUI.get(i).setBackground(UIManager.getColor("Panel.background"));
		}
	}
	
	private void borrarTablero() {
		for (int i = 0; i < casillasUI.size(); i++) {
			casillasUI.get(i).setBackground(UIManager.getColor("Panel.background"));
		}
	}
	
	private void actualizarTurnoUI() {
		lblTurnoActual.setText(juego.jugadorActual.getNombre());
		lblTurnoActual.setForeground(juego.jugadorActual.getTipoFicha());
	}

	private void actualizarTextosUI() {
		lblNombreJ1.setText(juego.jugador1.getNombre());
		lblNombreJ2.setText(juego.jugador2.getNombre());
		
		lblNombreJ1.setForeground(juego.jugador1.getTipoFicha());
		lblNombreJ2.setForeground(juego.jugador2.getTipoFicha());
	}
}
