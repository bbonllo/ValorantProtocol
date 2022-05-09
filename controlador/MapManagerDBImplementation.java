package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import exceptions.ExceptionManager;
import model.Map;

public class MapManagerDBImplementation implements MapManager {

	private Connection con;
	private PreparedStatement stmt;
	private ConnectionOpenClose conection = new ConnectionOpenClose();


	@Override
	public Map getMapByName(String mapName) {
		ResultSet rs = null;
		Map mapIntro = null;

		try {
			con = conection.openConnection();
		} catch (ExceptionManager e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String SEARCHMap = "SELECT * from map where mapName = ?";

		try {
			stmt = con.prepareStatement(SEARCHMap);
			stmt.setString(1, mapName);

			rs = stmt.executeQuery();
			if (rs.next()) {
				mapIntro = new Map();
				mapIntro.setMapName(mapName);
				mapIntro.setMapDesc(rs.getString("mapDesc"));
				// mapIntro.setMapCoords(rs.getString("mapCoords"));
			} else
				mapIntro = null;

			if (rs != null)
				rs.close();

			conection.closeConnection(stmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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

		try {
			con = conection.openConnection();
		} catch (ExceptionManager e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String SEARCHMap = "SELECT * from map";

		try {
			stmt = con.prepareStatement(SEARCHMap);
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

			conection.closeConnection(stmt, con);
		} catch (SQLException e) {
			String msg = "Error en recuperar todos los mapas";
			ExceptionManager x = new ExceptionManager(msg);
			throw x;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maps;
	}

}
