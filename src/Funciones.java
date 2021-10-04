import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Funciones {
	private Connection conexion;

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
