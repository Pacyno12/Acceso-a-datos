import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Funciones {
	private Connection conexion;

	// Inserta los datos introducidos en la base de datos
	public void registrarDatos(String usuario, String pass) {

		try {
			Statement stmt = conexion.createStatement();
			String qery = "INSERT INTO `users` (`Usuario`, `Password`) VALUES ('" + usuario + "','" + pass + "')";
			stmt.executeUpdate(qery);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// Borra los datos de la base de datos con los datos introducidos
	public void borrarDatos(String usuario, String pass) {

		try {
			Statement stmt = conexion.createStatement();
			String qery = "DELETE FROM `users` (`Usuario`, `Password`) VALUES ('" + usuario + "','" + pass + "')";
			stmt.executeUpdate(qery);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Actualiza los datos de la base de datos con los datos introducidos
	public void actualizarDatos(String usuario, String pass) {

		try {
			Statement stmt = conexion.createStatement();
			String qery = "UPDATE FROM `users` (`Usuario`, `Password`) WHERE ('" + usuario + "','" + pass + "')";
			stmt.executeUpdate(qery);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
