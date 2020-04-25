import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;
	private JRadioButton rdbtnRedBlackTree;
	private JRadioButton rdbtnHashMap;
	private JButton btnContinuar;
	private JPanel background;
	private JLabel lblImplementacionError;
	private JLabel lblLogo;
	private JPanel welcome;
	private JLabel lblUVGLogo;
	private JLabel lblBienvenido;
	private JLabel lblImplementacionSeleccionado;
	private JLabel lblCargarArchivoSpanishtxt;
	private JButton btnCargarSpanish;
	private JLabel lblCargarArchivoTexttxt;
	private JButton btnCargarTexto;
	private JLabel lblChechmarkSpanish;
	private JLabel lblCheckmarkTexto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setIconImage(new ImageIcon(Main.class.getResource("resources/google.png")).getImage());
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		// UVG LOGO IMPLEMENTATION SCREEN
		ImageIcon hospitalImage = new ImageIcon(Main.class.getResource("resources/uvg.png"));	
		Image imageH = hospitalImage.getImage();
		Image hispitalImg = imageH.getScaledInstance(200, 100, Image.SCALE_DEFAULT);
		hospitalImage = new ImageIcon(hispitalImg);
		
		// UVG LOGO WELCOME SCREEN
		ImageIcon UVGImage = new ImageIcon(Main.class.getResource("resources/uvg.png"));	
		Image UVGH = UVGImage.getImage();
		Image UVGImg = UVGH.getScaledInstance(400, 200, Image.SCALE_DEFAULT);
		UVGImage = new ImageIcon(UVGImg);
		
		Icon checkIcono = new ImageIcon(Main.class.getResource("resources/checkmark.png"));
		
		
		JPanel seleccionar = new JPanel();
		seleccionar.setBackground(Color.WHITE);
		frame.getContentPane().add(seleccionar, "name_160085950341400");
		seleccionar.setLayout(null);
		
		JLabel lblSeleccionarImplementacion = new JLabel("Seleccionar implementacion");
		lblSeleccionarImplementacion.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSeleccionarImplementacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionarImplementacion.setBounds(0, 134, 984, 30);
		seleccionar.add(lblSeleccionarImplementacion);
		
		rdbtnRedBlackTree = new JRadioButton("Red Black Tree", true);
		rdbtnRedBlackTree.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnRedBlackTree.setBounds(431, 208, 120, 23);
		seleccionar.add(rdbtnRedBlackTree);
		
		rdbtnHashMap = new JRadioButton("Hash Map");
		rdbtnHashMap.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnHashMap.setBounds(431, 242, 120, 23);
		seleccionar.add(rdbtnHashMap);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnRedBlackTree);
		bg.add(rdbtnHashMap);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (rdbtnRedBlackTree.isSelected() || rdbtnHashMap.isSelected()) {
					if (rdbtnRedBlackTree.isSelected()) {
//						controller = new Controller("VectorHeap");
						lblImplementacionSeleccionado.setText("Red Black Tree");
					}else if (rdbtnHashMap.isSelected()) {
//						controller = new Controller("PriorityQueue");
						lblImplementacionSeleccionado.setText("Hash Map");
					}
					
					background.setVisible(true);
					seleccionar.setVisible(false);
										
				}else {
					lblImplementacionError.setText("No hay implementacion seleccionado... Intentar de nuevo ");
				}
			}
		});
		btnContinuar.setBorder(null);
		btnContinuar.setForeground(new Color(255, 255, 255));
		btnContinuar.setFont(new Font("Arial", Font.BOLD, 12));
		btnContinuar.setBackground(new Color(0, 153, 204));
		btnContinuar.setBounds(425, 316, 150, 30);
		seleccionar.add(btnContinuar);
		
		lblImplementacionError = new JLabel("");
		lblImplementacionError.setHorizontalAlignment(SwingConstants.CENTER);
		lblImplementacionError.setFont(new Font("Arial", Font.BOLD, 13));
		lblImplementacionError.setForeground(new Color(255, 51, 102));
		lblImplementacionError.setBounds(0, 365, 984, 30);
		seleccionar.add(lblImplementacionError);
		
		lblLogo = new JLabel("", hospitalImage, JLabel.CENTER);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(10, 11, 100, 100);
		seleccionar.add(lblLogo);
		
		background = new JPanel();
		background.setBackground(Color.WHITE);
		frame.getContentPane().add(background, "name_34822438972700");
		background.setLayout(null);
		
		JPanel panelButtons = new JPanel();
		panelButtons.setBackground(new Color(255, 255, 255));
		panelButtons.setBounds(0, 0, 400, 611);
		background.add(panelButtons);
		panelButtons.setLayout(null);
		
		lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setFont(new Font("Arial", Font.BOLD, 17));
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setBounds(0, 30, 400, 30);
		panelButtons.add(lblBienvenido);
		
		lblImplementacionSeleccionado = new JLabel("");
		lblImplementacionSeleccionado.setFont(new Font("Arial", Font.PLAIN, 15));
		lblImplementacionSeleccionado.setHorizontalAlignment(SwingConstants.CENTER);
		lblImplementacionSeleccionado.setBounds(0, 87, 400, 30);
		panelButtons.add(lblImplementacionSeleccionado);
		
		lblCargarArchivoSpanishtxt = new JLabel("Cargar archivo Spanish.txt");
		lblCargarArchivoSpanishtxt.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargarArchivoSpanishtxt.setFont(new Font("Arial", Font.PLAIN, 13));
		lblCargarArchivoSpanishtxt.setBounds(0, 166, 400, 30);
		panelButtons.add(lblCargarArchivoSpanishtxt);
		
		btnCargarSpanish = new JButton("Cargar");
		btnCargarSpanish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblChechmarkSpanish.setVisible(true);
				btnCargarSpanish.setVisible(false);
				btnCargarTexto.setEnabled(true);
			}
		});
		btnCargarSpanish.setBorder(null);
		btnCargarSpanish.setForeground(new Color(255, 255, 255));
		btnCargarSpanish.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCargarSpanish.setBackground(new Color(0, 153, 204));
		btnCargarSpanish.setBounds(125, 210, 150, 30);
		panelButtons.add(btnCargarSpanish);
		
		lblCargarArchivoTexttxt = new JLabel("Cargar archivo texto.txt");
		lblCargarArchivoTexttxt.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargarArchivoTexttxt.setFont(new Font("Arial", Font.PLAIN, 13));
		lblCargarArchivoTexttxt.setBounds(0, 301, 400, 30);
		panelButtons.add(lblCargarArchivoTexttxt);
		
		btnCargarTexto = new JButton("Cargar");
		btnCargarTexto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblChechmarkSpanish.setVisible(true);
				btnCargarTexto.setVisible(false);
			}
		});
		btnCargarTexto.setEnabled(false);
		btnCargarTexto.setForeground(Color.WHITE);
		btnCargarTexto.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCargarTexto.setBorder(null);
		btnCargarTexto.setBackground(new Color(0, 153, 204));
		btnCargarTexto.setBounds(125, 342, 150, 30);
		panelButtons.add(btnCargarTexto);
		
		lblChechmarkSpanish = new JLabel("", checkIcono, JLabel.CENTER);
		lblChechmarkSpanish.setVisible(false);
		lblChechmarkSpanish.setHorizontalAlignment(SwingConstants.CENTER);
		lblChechmarkSpanish.setBounds(0, 210, 400, 30);
		panelButtons.add(lblChechmarkSpanish);
		
		lblCheckmarkTexto = new JLabel("", checkIcono, JLabel.CENTER); 
		lblCheckmarkTexto.setBounds(0, 342, 400, 30);
		panelButtons.add(lblCheckmarkTexto);
		
		JPanel panelContent = new JPanel();
		panelContent.setBackground(new Color(251, 251, 251));
		panelContent.setBounds(401, 0, 583, 611);
		background.add(panelContent);
		panelContent.setLayout(new CardLayout(0, 0));
		
		welcome = new JPanel();
		welcome.setBackground(new Color(251, 251, 251));
		panelContent.add(welcome, "name_163379221078400");
		welcome.setLayout(null);
		
		lblUVGLogo = new JLabel("", UVGImage, JLabel.CENTER);
		lblUVGLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblUVGLogo.setBounds(200, 190, 200, 200);
		welcome.add(lblUVGLogo);
		frame.setBackground(Color.WHITE);
		frame.setSize(1000, 650);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
