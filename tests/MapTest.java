package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import controlador.MapManager;
import controlador.MapManagerDBImplementation;
import exceptions.ExceptionManager;

public class MapTest {
	String name = "Split";
	MapManager newMap = new MapManagerDBImplementation();

	@Test
	public void testGetMapByName() throws ExceptionManager {
		assertNotNull(newMap.getMapByName(name));
	}

	@Test
	public void testMakeStadisctic() {
	}

	@Test
	public void testGetAllMaps() {
	}
}
