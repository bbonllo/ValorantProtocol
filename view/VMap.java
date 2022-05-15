package view;

import javax.swing.JDialog;

import controlador.MapManager;
import model.Map;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;

public class VMap extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MapManager mapData;
	private JLabel lblMapName;
	private JLabel lblMapIcon;
	private JLabel lblAttackAgentName1;
	private JLabel lblAttackAgentName2;
	private JLabel lblAttackAgentName3;
	private JLabel lblDefendAgentName1;
	private JLabel lblDefendAgentName2;
	private JLabel lblDefendAgentName3;
	private JLabel lblWeaponAttack;
	private JLabel lblWeaponDefend;
	private JLabel lblAttack;
	private JLabel lblDefend;
	private JProgressBar progressBarDefendAgent1;
	private JProgressBar progressBarDefendAgent2;
	private JProgressBar progressBarDefendAgent3;
	private JProgressBar progressBarAttackAgent1;
	private JProgressBar progressBarAttackAgent2;
	private JProgressBar progressBarAttackAgent3;
	private JTextArea textArea;
	private String attackWeapon;
	private String defendWeapon;
	private JLabel lblWeaponAttackName;
	private JLabel lblWeaponDefendName;
	private List<String> agentNamesAttack = new ArrayList<>();
	private List<String> agentNamesDefend = new ArrayList<>();
	private List<Integer> agentPercentageMapAttack = new ArrayList<>();
	private List<Integer> agentPercentageMapDefend = new ArrayList<>();

	public VMap(MapManager map, VPestaniasAgente vPestaniasAgente, boolean b, String mapName) {
		mapData = map;
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VMap.class.getResource("/resources/rotGamesLogo.png")));
		setBounds(300, 100, 1300, 900);
		getContentPane().setLayout(null);

		Map newMap = mapData.getMapByName(mapName);
		String iconMap = "/resources/Loading_Screen_" + newMap.getMapName() + ".jpg";
		agentNamesAttack = mapData.getAttackMissionAgents(mapName);
		agentNamesDefend = mapData.getDefendMissionAgents(mapName);
		agentPercentageMapAttack = mapData.agentPercentageMapAttack(mapName);
		agentPercentageMapDefend = mapData.agentPercentageMapDefend(mapName);
		attackWeapon = "/resources/" + mapData.getAttackMissionWeapon(mapName) + ".png";
		defendWeapon = "/resources/" + mapData.getDefendMissionWeapon(mapName) + ".png";

		lblWeaponDefendName = new JLabel("");
		lblWeaponDefendName.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeaponDefendName.setForeground(Color.RED);
		lblWeaponDefendName.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblWeaponDefendName.setBounds(618, 707, 110, 33);
		getContentPane().add(lblWeaponDefendName);

		lblWeaponAttackName = new JLabel("");
		lblWeaponAttackName.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeaponAttackName.setForeground(new Color(51, 0, 255));
		lblWeaponAttackName.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblWeaponAttackName.setBounds(618, 275, 110, 33);
		getContentPane().add(lblWeaponAttackName);

		lblWeaponDefend = new JLabel("");
		lblWeaponDefend.setBounds(481, 540, 384, 138);
		getContentPane().add(lblWeaponDefend);

		lblWeaponAttack = new JLabel("");
		lblWeaponAttack.setBounds(481, 108, 384, 138);
		getContentPane().add(lblWeaponAttack);

		progressBarAttackAgent2 = new JProgressBar();
		progressBarAttackAgent2.setForeground(new Color(51, 51, 255));
		progressBarAttackAgent2.setBackground(new Color(201, 218, 248));
		progressBarAttackAgent2.setOrientation(SwingConstants.VERTICAL);
		progressBarAttackAgent2.setBounds(220, 68, 72, 215);
		getContentPane().add(progressBarAttackAgent2);

		lblAttackAgentName1 = new JLabel("");
		lblAttackAgentName1.setForeground(new Color(51, 0, 255));
		lblAttackAgentName1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttackAgentName1.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAttackAgentName1.setBounds(53, 294, 110, 33);
		getContentPane().add(lblAttackAgentName1);

		progressBarAttackAgent1 = new JProgressBar();
		progressBarAttackAgent1.setForeground(new Color(51, 51, 255));
		progressBarAttackAgent1.setBackground(new Color(201, 218, 248));
		progressBarAttackAgent1.setOrientation(SwingConstants.VERTICAL);
		progressBarAttackAgent1.setBounds(72, 68, 72, 215);
		getContentPane().add(progressBarAttackAgent1);

		lblAttackAgentName2 = new JLabel("");
		lblAttackAgentName2.setForeground(new Color(51, 0, 255));
		lblAttackAgentName2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttackAgentName2.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAttackAgentName2.setBounds(200, 294, 110, 33);
		getContentPane().add(lblAttackAgentName2);

		progressBarAttackAgent3 = new JProgressBar();
		progressBarAttackAgent3.setForeground(new Color(51, 51, 255));
		progressBarAttackAgent3.setBackground(new Color(201, 218, 248));
		progressBarAttackAgent3.setOrientation(SwingConstants.VERTICAL);
		progressBarAttackAgent3.setBounds(368, 68, 72, 215);
		getContentPane().add(progressBarAttackAgent3);

		lblAttackAgentName3 = new JLabel("");
		lblAttackAgentName3.setForeground(new Color(51, 0, 255));
		lblAttackAgentName3.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttackAgentName3.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAttackAgentName3.setBounds(350, 294, 110, 33);
		getContentPane().add(lblAttackAgentName3);

		lblDefendAgentName2 = new JLabel("");
		lblDefendAgentName2.setForeground(Color.RED);
		lblDefendAgentName2.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblDefendAgentName2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDefendAgentName2.setBounds(200, 732, 110, 33);
		getContentPane().add(lblDefendAgentName2);

		lblDefendAgentName3 = new JLabel("");
		lblDefendAgentName3.setForeground(Color.RED);
		lblDefendAgentName3.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblDefendAgentName3.setHorizontalAlignment(SwingConstants.CENTER);
		lblDefendAgentName3.setBounds(350, 732, 110, 33);
		getContentPane().add(lblDefendAgentName3);

		lblDefendAgentName1 = new JLabel("");
		lblDefendAgentName1.setForeground(Color.RED);
		lblDefendAgentName1.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblDefendAgentName1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDefendAgentName1.setBounds(53, 732, 110, 33);
		getContentPane().add(lblDefendAgentName1);

		progressBarDefendAgent3 = new JProgressBar();
		progressBarDefendAgent3.setForeground(new Color(255, 0, 51));
		progressBarDefendAgent3.setBackground(new Color(244, 204, 204));
		progressBarDefendAgent3.setOrientation(SwingConstants.VERTICAL);
		progressBarDefendAgent3.setBounds(368, 506, 72, 215);
		getContentPane().add(progressBarDefendAgent3);

		progressBarDefendAgent2 = new JProgressBar();
		progressBarDefendAgent2.setForeground(new Color(255, 0, 51));
		progressBarDefendAgent2.setBackground(new Color(244, 204, 204));
		progressBarDefendAgent2.setOrientation(SwingConstants.VERTICAL);
		progressBarDefendAgent2.setBounds(220, 506, 72, 215);
		getContentPane().add(progressBarDefendAgent2);

		progressBarDefendAgent1 = new JProgressBar();
		progressBarDefendAgent1.setForeground(new Color(255, 0, 51));
		progressBarDefendAgent1.setBackground(new Color(244, 204, 204));
		progressBarDefendAgent1.setOrientation(SwingConstants.VERTICAL);
		progressBarDefendAgent1.setBounds(72, 506, 72, 215);
		getContentPane().add(progressBarDefendAgent1);

		JLabel lblDefendMission = new JLabel("Mision de Defensa - Agents m\u00E1s usados");
		lblDefendMission.setForeground(Color.RED);
		lblDefendMission.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblDefendMission.setBounds(22, 828, 343, 25);
		getContentPane().add(lblDefendMission);

		JLabel lblAttackMission = new JLabel("Mision de Ataque - Agents m\u00E1s usados");
		lblAttackMission.setForeground(new Color(51, 0, 255));
		lblAttackMission.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAttackMission.setBounds(22, 393, 343, 25);
		getContentPane().add(lblAttackMission);

		lblMapName = new JLabel("");
		lblMapName.setHorizontalAlignment(SwingConstants.CENTER);
		lblMapName.setOpaque(true);
		lblMapName.setBackground(Color.WHITE);
		lblMapName.setForeground(Color.RED);
		lblMapName.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 16));
		lblMapName.setBounds(1014, 385, 150, 33);
		getContentPane().add(lblMapName);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		textArea.setForeground(Color.RED);
		textArea.setBackground(Color.WHITE);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBounds(920, 479, 337, 254);
		getContentPane().add(textArea);

		lblMapIcon = new JLabel("");
		lblMapIcon.setBounds(913, 154, 350, 197);
		getContentPane().add(lblMapIcon);

		JLabel lblMapInfo = new JLabel("");
		lblMapInfo.setOpaque(true);
		lblMapInfo.setBackground(Color.WHITE);
		lblMapInfo.setBounds(898, 0, 386, 864);
		getContentPane().add(lblMapInfo);

		lblAttack = new JLabel("");
		lblAttack.setBackground(new Color(201, 218, 248));
		lblAttack.setOpaque(true);
		lblAttack.setBounds(0, 0, 900, 432);
		getContentPane().add(lblAttack);

		lblDefend = new JLabel("");
		lblDefend.setOpaque(true);
		lblDefend.setBackground(new Color(244, 204, 204));
		lblDefend.setBounds(0, 432, 900, 432);
		getContentPane().add(lblDefend);

		cargarDatos(newMap, iconMap, mapName);
	}

	private void cargarDatos(Map newMap, String iconMap, String mapName) {
		boolean attack = true;
		boolean defend = true;

		if (agentNamesAttack.size() != 0) {
			lblAttackAgentName3.setText(agentNamesAttack.get(2) + " - " + agentPercentageMapAttack.get(2) + "%");
			lblAttackAgentName2.setText(agentNamesAttack.get(1) + " - " + agentPercentageMapAttack.get(1) + "%");
			lblAttackAgentName1.setText(agentNamesAttack.get(0) + " - " + agentPercentageMapAttack.get(0) + "%");
			progressBarAttackAgent3.setValue(agentPercentageMapAttack.get(2));
			progressBarAttackAgent2.setValue(agentPercentageMapAttack.get(1));
			progressBarAttackAgent1.setValue(agentPercentageMapAttack.get(0));
			lblWeaponAttack.setIcon(new ImageIcon(VMap.class.getResource(attackWeapon)));
			lblWeaponAttackName.setText(mapData.getAttackMissionWeapon(mapName));
		} else
			attack = false;

		if (agentNamesDefend.size() != 0) {
			lblDefendAgentName3.setText(agentNamesDefend.get(2) + " - " + agentPercentageMapDefend.get(2) + "%");
			lblDefendAgentName2.setText(agentNamesDefend.get(1) + " - " + agentPercentageMapDefend.get(1) + "%");
			lblDefendAgentName1.setText(agentNamesDefend.get(0) + " - " + agentPercentageMapDefend.get(0) + "%");
			progressBarDefendAgent3.setValue(agentPercentageMapDefend.get(2));
			progressBarDefendAgent2.setValue(agentPercentageMapDefend.get(1));
			progressBarDefendAgent1.setValue(agentPercentageMapDefend.get(0));
			lblWeaponDefend.setIcon(new ImageIcon(VMap.class.getResource(defendWeapon)));
			lblWeaponDefendName.setText(mapData.getDefendMissionWeapon(mapName));

		} else
			defend = false;

		if (!defend && !attack) {
			JOptionPane.showMessageDialog(this, "No hay datos ni de ataque ni de defensa en este mapa", "Error",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (!defend) {
			JOptionPane.showMessageDialog(this, "No hay datos de defensa en este mapa", "Error",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (!attack) {
			JOptionPane.showMessageDialog(this, "No hay datos de ataque en este mapa", "Error",
					JOptionPane.INFORMATION_MESSAGE);
		}

		lblMapName.setText(mapName);
		lblMapIcon.setIcon(new ImageIcon(VMap.class.getResource(iconMap)));
		textArea.setText(newMap.getMapDesc());

	}
}
