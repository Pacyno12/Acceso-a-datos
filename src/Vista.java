import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Vista extends JFrame {

	private Funciones misFunciones;
	private static String bd = "acceso a datos";
	private static String login = "root";
	private static String pwd = "";
	private static String url = "jdbc:mysql://localhost/" + bd;
	private static Connection conexion;
	private JButton btnInsertar;
	private JPanel panel;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnLectura;
	private JLabel lblUser;
	private JLabel lblPass;
	private JTextField txtUser;
	private JTextField txtPass;
	String usuario = txtUser.getText();
	String pass = txtPass.getText();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					conexion = DriverManager.getConnection(url, login, pwd);

					conexion.close();
					if (conexion != null) {
						System.out.println("Conexión a la bd " + url + "...OK");
						conexion.close();
					}
					Vista window = new Vista();
					window.setVisible(true);
				} catch (ClassNotFoundException cnfe) {
					System.out.println("Driver JBDC no encontrado");
					cnfe.printStackTrace();
				} catch (SQLException sqle) {
					System.out.println("Error al conectarse a la BD");
					sqle.printStackTrace();
				} catch (Exception e) {
					System.out.println("Error general");
					e.printStackTrace();
				}
			}
		});
	}

	public Vista() {
		initialize();
	}

	private void initialize() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		lblUser = new JLabel("Usuario");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUser.setBounds(100, 11, 86, 39);
		getContentPane().add(lblUser);

		lblPass = new JLabel("Contrase\u00F1a");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPass.setBounds(240, 11, 86, 39);
		getContentPane().add(lblPass);

		txtUser = new JTextField();
		txtUser.setBounds(85, 45, 86, 20);
		getContentPane().add(txtUser);
		txtUser.setColumns(10);

		txtPass = new JTextField();
		txtPass.setBounds(240, 45, 86, 20);
		getContentPane().add(txtPass);
		txtPass.setColumns(10);

		btnInsertar = new JButton("Insertar");
		btnInsertar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				misFunciones.registrarDatos(usuario, pass);
			}
		});
		btnInsertar.setBounds(20, 76, 89, 23);
		getContentPane().add(btnInsertar);

		btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				misFunciones.actualizarDatos(usuario, pass);
			}
		});
		btnModificar.setBounds(119, 76, 89, 23);
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				misFunciones.borrarDatos(usuario, pass);
			}
		});
		btnEliminar.setBounds(218, 76, 89, 23);
		getContentPane().add(btnEliminar);

		btnLectura = new JButton("Lectura");
		btnLectura.setBounds(320, 76, 89, 23);
		getContentPane().add(btnLectura);

		panel = new JPanel();
		panel.setBounds(10, 110, 414, 140);
		getContentPane().add(panel);
	}
}
