import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import javafx.scene.control.Alert;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JScrollPane;

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
	

	private JPanel translator;
	private JLabel lblErrorSpanish;
	private JLabel lblErrorTexto;
	
	  
    //Se llama y empieza el BinarySearchTree
    private final Tree_2_3<Association<String, String>> myTree = new Tree_2_3<>();
	private JTextArea inputTextArea;
	
	private boolean isSpanishLoaded, isTextoLoaded = false;
	
	
	private JTextArea outputTextArea;
	private JButton btnTranslate;
	private JLabel lblTraducir;
	private JLabel lblCheckmarkTranslate;
	private JLabel lblErrorTranslate;
	

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
		
		rdbtnHashMap = new JRadioButton("2-3 Tree");
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
				
				// METODO PARA CARGAR SPANISH.TXT
				cargarSpanish();
				
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
				
				welcome.setVisible(false);
				translator.setVisible(true);
				
				BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new FileReader("src/texto.txt"));
                    String text;
                    while ((text = reader.readLine()) != null) {
                        inputTextArea.append("\n" + text);
                    }

                } catch (final IOException ex) {
                	lblErrorTexto.setVisible(true);
                	JOptionPane.showMessageDialog(null, "Archivo no encontrado. Verificar archivo texto.txt en directorio src/...");
                } 
                
                isTextoLoaded = true;
				
                lblCheckmarkTexto.setVisible(true);
				btnCargarTexto.setVisible(false);
				btnTranslate.setVisible(true);
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
		lblCheckmarkTexto.setVisible(false);
		lblCheckmarkTexto.setBounds(0, 342, 400, 30);
		panelButtons.add(lblCheckmarkTexto);
		
		lblErrorSpanish = new JLabel("X");
		lblErrorSpanish.setVisible(false);
		lblErrorSpanish.setForeground(Color.RED);
		lblErrorSpanish.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorSpanish.setFont(new Font("Arial", Font.BOLD, 20));
		lblErrorSpanish.setBounds(0, 210, 400, 30);
		panelButtons.add(lblErrorSpanish);
		
		lblErrorTexto = new JLabel("X");
		lblErrorTexto.setVisible(false);
		lblErrorTexto.setForeground(Color.RED);
		lblErrorTexto.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorTexto.setFont(new Font("Arial", Font.BOLD, 20));
		lblErrorTexto.setBounds(0, 342, 400, 30);
		panelButtons.add(lblErrorTexto);
		
		btnTranslate = new JButton("Translate");
		btnTranslate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (isTextoLoaded && isSpanishLoaded) {
	                // Separa el inputTextArea en lineas y las guarda como Array
	                final List<String> initLines = Arrays.asList(inputTextArea.getText().split("\n"));

	                for (final String line : initLines) {
	                    
	                    final String[] textToTranslate = line.split(" ");
	                    for (final String word : textToTranslate) {
	                        // Para cada palabra obtiene la asociacion que coincide con el key
	                        final Association<String, String> a = myTree.get(new Association<>(word, null));
	                        if (a != null) {
	                            // Si es que existe una asociacion la agrega en el outputTextArea 
	                            outputTextArea.append(" " + a.getValue().toString() + " ");
	                        } else {
	                            outputTextArea.append(" " + "*" + word + "*" + " ");
	                        }
	                    }
	                    outputTextArea.append("\n");

	                }

	            } else {
	            	lblErrorTranslate.setVisible(true);
                	JOptionPane.showMessageDialog(null, "Error encontrado al traducir oracion. Intentar de nuevo");
	            }
				
				btnTranslate.setVisible(false);
				lblTraducir.setVisible(true);
				lblCheckmarkTranslate.setVisible(true);
				
			}
		});
		btnTranslate.setVisible(false);
		btnTranslate.setForeground(Color.WHITE);
		btnTranslate.setFont(new Font("Arial", Font.PLAIN, 12));
		btnTranslate.setBorder(null);
		btnTranslate.setBackground(new Color(0, 153, 204));
		btnTranslate.setBounds(125, 430, 150, 30);
		panelButtons.add(btnTranslate);
		
		lblTraducir = new JLabel("Traducir");
		lblTraducir.setVisible(false);
		lblTraducir.setHorizontalAlignment(SwingConstants.CENTER);
		lblTraducir.setFont(new Font("Arial", Font.PLAIN, 13));
		lblTraducir.setBounds(0, 430, 400, 30);
		panelButtons.add(lblTraducir);
		
		lblCheckmarkTranslate = new JLabel("", checkIcono, JLabel.CENTER);
		lblCheckmarkTranslate.setVisible(false);
		lblCheckmarkTranslate.setBounds(0, 470, 400, 30);
		panelButtons.add(lblCheckmarkTranslate);
		
		lblErrorTranslate = new JLabel("X");
		lblErrorTranslate.setForeground(Color.RED);
		lblErrorTranslate.setVisible(false);
		lblErrorTranslate.setFont(new Font("Arial", Font.BOLD, 20));
		lblErrorTranslate.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorTranslate.setBounds(0, 470, 400, 30);
		panelButtons.add(lblErrorTranslate);
		
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
		
		translator = new JPanel();
		translator.setBackground(new Color(251, 251, 251));
		panelContent.add(translator, "name_201743215252300");
		translator.setLayout(null);
		
		JLabel lblTraductor = new JLabel("Traductor");
		lblTraductor.setHorizontalAlignment(SwingConstants.CENTER);
		lblTraductor.setFont(new Font("Arial", Font.BOLD, 17));
		lblTraductor.setBounds(0, 63, 583, 30);
		translator.add(lblTraductor);
		
		inputTextArea = new JTextArea();
		inputTextArea.setBackground(new Color(251, 251, 251));
		inputTextArea.setRows(2);
		inputTextArea.setLineWrap(true);
		inputTextArea.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "     Oracion     ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		inputTextArea.setBounds(0, 160, 583, 100);
		translator.add(inputTextArea);
		
		outputTextArea = new JTextArea();
		outputTextArea.setBackground(new Color(251, 251, 251));
		outputTextArea.setRows(2);
		outputTextArea.setLineWrap(true);
		outputTextArea.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "       Traduccion       ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		outputTextArea.setBounds(0, 340, 583, 100);
		translator.add(outputTextArea);
		frame.setBackground(Color.WHITE);
		frame.setSize(1000, 650);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	// METODO PARA CARGAR SPANISH.TXT
	public void cargarSpanish(){
		BufferedReader reader = null;
		
        try {
            reader = new BufferedReader(new FileReader("src/Spanish.txt"));
            String text;
            String secondString = "";
            while ((text = reader.readLine()) != null) {
            	
            	if (text.charAt(0) == '#') {
                    continue;
                } else {
                	
                	final String[] temp = text.split("\\s+");
                	
                    if(temp.length > 2) {
                    	secondString = temp[1] + " " + temp[2];
                    	temp[1] = secondString;
                    } else if(temp.length == 2) {
                    	secondString = temp[1];
                    	temp[1] = secondString;
                    } else if(temp.length < 1) {
                    	secondString = "|";
                    	temp[1] = secondString;
                    }
                                                 
                    if (temp.length > 1) {
                        // Crea una nueva associacion con el valor de temp[0] = palabra en ingles. 
                        // Crea una nueva associacion con el valor de temp[1] = palabra en español 
                        final Association<String, String> a = new Association(temp[0], temp[1]);
                        myTree.add(a);
                    }
                }

                
            }

        } catch (IOException ex) {
        	lblErrorSpanish.setVisible(true);
        	JOptionPane.showMessageDialog(null, "Archivo no encontrado. Verificar archivo Spanish.txt en directorio src/...");
		}
        
        isSpanishLoaded = true;
        
        final List<Association<String, String>> list = myTree.inOrder();
        String dictionaryContent = "";

        for (final Association association : list)
            dictionaryContent += association.getKey() + "," + association.getValue() + "\n";
	}
}

















