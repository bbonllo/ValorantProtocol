package controlador;

public class DataFactoryWeapon {
	private static WeaponManager data;

	public static synchronized WeaponManager getWeaponData() {
		if (data == null) {
			data = new WeaponManagerDBImplementation();
		}
		return data;
	}

}
