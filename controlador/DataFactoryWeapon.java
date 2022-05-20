package controlador;

public class DataFactoryWeapon {
	private static WeaponManager data;

	/**
	 * Carga la variable data, si esta no esta cargada previamente
	 * @return data Modelo de datos de tipo Arma {@link WeaponManager}
	 */
	public static WeaponManager getWeaponData() {
		if (data == null) {
			data = new WeaponManagerDBImplementation();
		}
		return data;
	}

}
