package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import exceptions.ExceptionManager;


public class MapManagerDBImplementation implements MapManager {

	private Connection con;
	private PreparedStatement stmt;

	private void openConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/valorant_protocol?serverTimezone=Europe/Madrid&useSSL=false";
			con = DriverManager.getConnection(url, "root", "abcd*1234");
		} catch (SQLException e) {
			System.out.println("Error en la conexion");
			e.printStackTrace();
		}

	}

	private void closeConnection() throws SQLException {
		if (stmt != null)
			stmt.close();
		if (con != null)
			con.close();
	}

	@Override
	public Map getMapByName(String mapName) {
		ResultSet rs = null;
		Map mapIntro = null;

		openConnection();
		String SEARCHMap = "SELECT * from map where mapName = ?";

		try {
			stmt = con.prepareStatement(SEARCHMap);
			stmt.setString(1, mapName);

			rs = stmt.executeQuery();
			if (rs.next()) {
				mapIntro = new Map();
				mapIntro.setMapName(mapName);
				mapIntro.setMapDesc(rs.getString("mapDesc"));
				mapIntro.setMapCoords(rs.getString("mapCoords"));
			} else
				mapIntro = null;

			if (rs != null)
				rs.close();

			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapIntro;
	}

	@Override
	public void makeStadisctic(String mapName) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<Map> getAllMaps() throws ExceptionManager {
		Set<Map> maps = new HashSet<>();
		ResultSet rs = null;
		Map mapIntro = null;

		openConnection();
		String SEARCHProp = "SELECT * from propietario";

		try {
			stmt = con.prepareStatement(SEARCHProp);
			rs = stmt.executeQuery();

			while (rs.next()) {
				mapIntro = new Map();
				mapIntro.setMapName(rs.getString("mapName"));
				mapIntro.setMapDesc(rs.getString("mapDesc"));
				mapIntro.setMapCoords(rs.getString("mapCoords"));
				maps.add(mapIntro);
			}

			if (rs != null)
				rs.close();

			closeConnection();
		} catch (SQLException e) {
			String msg = "Error en el alta del propietario";
			ExceptionManager x = new ExceptionManager(msg);
			throw x;
		}
		return maps;
	}

}
