package components;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * @author Grupo-E
 *
 */
public class RowsRenderer extends DefaultTableCellRenderer {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private int columna;

	/**
	 * Permite cargar los datos en la variable columna
	 * 
	 * @param Colpatron Int con la columna seleccionada
	 */
	public RowsRenderer(int Colpatron) {
		this.columna = Colpatron;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused,
			int row, int column) {
		setBackground(Color.white);
		table.setForeground(Color.black);
		super.getTableCellRendererComponent(table, value, selected, focused, row, column);
		if (table.getValueAt(row, columna) != null) {
			if (table.getValueAt(row, columna).equals("false")) {
				this.setForeground(Color.ORANGE);
			} else if (table.getValueAt(row, columna).equals("true")) {
				this.setForeground(Color.GREEN);
			}
		}
		return this;
	}
}
