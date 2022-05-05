package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import java.awt.Font;
import java.awt.Frame;

import model.Agent;
import model.AgentManager;
import model.MapManager;
import model.WeaponManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.awt.event.MouseAdapter;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Toolkit;

import com.k33ptoo.components.KButton;

import components.RowsRenderer;
import exceptions.ExceptionManager;
import jdk.jshell.Diag;

import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;

import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;

public class VPestaniasAgente extends JFrame implements ActionListener, MouseListener {
	private static final long serialVersionUID = 1L;
	private AgentManager agentData;
	private MapManager mapData;
	private WeaponManager weaponData;
	private JPanel contentPane;
	private KButton btnMinimize;
	private KButton btnClose;
	private JButton btnAgent;
	private JButton btnMission;
	private JButton btnWeapon;
	private JButton btnMap;
	private JButton btnRegisterAgent;
	private JButton btnModifyAgent;
	private JButton btnRemoveAgent;
	private JButton btnRegisterWeapon;
	private JButton btnModifyWeapon;
	private JButton btnRemoveWeapon;
	private JButton btnRegisterMission;
	private JButton btnHistoricMission;
	private JPanel panelAgent;
	private JPanel panelMission;
	private JPanel panelWeapon;
	private JPanel panelMap;
	private JLabel lblIcon;
	private JLabel lblHandCursor;
	private JLabel lblBackground;
	private JPanel panelRegisterAgent;
	private JPanel panelModifyAgent;
	private JPanel panelRemoveAgent;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblAgentHabilities;
	private JLabel lblBackgroundPanelAgentRegister;
	private JLabel lblBackgroundPanelAgentRegister_2;
	private JPanel panelRegisterWeapon;
	private JPanel panelRemoveWeapon;
	private JPanel panelModifyWeapon;
	private JLabel panelBackgroundRegisterWeapon;
	private JLabel panelBackgroundModifyWeapon;
	private JLabel panelBackgroundRemoveWeapon;
	private JPanel panelRegisterMission;
	private JLabel panelBackgroundRegisterMission;
	private JPanel panelHistoricMission;
	private JLabel panelBackgroundHistoricMission;
	private JLabel lblNewLabel;
	private JLabel lblPanelregistermission;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JComboBox<?> comboBoxRol;
	private JLabel lblAgentDataCode;
	private JTextField txtCode;
	private JLabel lblAgentDataName;
	private JTextField txtName;
	private JLabel lblAgentDataNationality;
	private JTextField txtNationality;
	private JLabel lblAgentDataRol;
	int cont = 0;
	private JLabel lblAgentDataAdmin;
	private JLabel lblAgentDataPasswd2;
	private JPasswordField txtPasswd1;
	private JPasswordField txtPasswd2;
	private JTextField txtHabilityName1;
	private JLabel lblAgentHabilitiesName2;
	private JTextField txtHabilityName2;
	private JLabel lblAgentHabilitiesDescription2;
	private JTextArea textAreaHabilityDescription2;
	private JTextField txtHabilityName3;
	private JLabel lblAgentHabilitiesName3;
	private JLabel lblAgentHabilitiesDescription3;
	private JTextArea textAreaHabilityDescription3;
	private JLabel lblAgentHabilitiesName4;
	private JTextField txtHabilityName4;
	private JLabel lblAgentHabilitiesDescription4;
	private JTextArea textAreaHabilityDescription4;
	private JLabel lblAgentHabilitiesOrbNum;
	private JLabel lblAgentHabilitiesOrbNumModif;
	private JSpinner spinnerModif;
	private JLabel lblAgentHabilitiesDescription4Modif;
	private JTextArea textAreaHabilityDescription4Modif;
	private JLabel lblAgentHabilitiesName4Modif;
	private JTextField txtHabilityName4Modif;
	private JLabel lblAgentHabilitiesName3Modif;
	private JTextField txtHabilityName3Modif;
	private JTextArea textAreaHabilityDescription3Modif;
	private JLabel lblAgentHabilitiesDescription3Modif;
	private JTextArea textAreaHabilityDescription2_1;
	private JLabel lblAgentHabilitiesName2Modif;
	private JTextField txtHabilityName2Modif;
	private JLabel lblAgentHabilitiesDescription2Modif;
	private JTextArea textAreaHabilityDescription1Modif;
	private JLabel lblAgentHabilitiesDescription1Modif;
	private JTextField txtHabilityName1Modif;
	private JLabel lblAgentHabilitiesName1Modif;
	private JLabel lblAgentHabilitiesTitleModif;
	private JButton btnModif;
	private JPasswordField passwordFieldModif;
	private JPasswordField passwordFieldConfirmModif;
	private JLabel lblAgentDataPasswd2Modif;
	private JLabel lblAgentDataPasswd1Modif;
	private JLabel lblAgentDataAdminModif;
	private JCheckBox chckbxNewCheckBoxModif;
	private JComboBox comboBoxRolModif;
	private JLabel lblAgentDataRolModif;
	private JTextField txtNationalityModif;
	private JLabel lblAgentDataNationalityModif;
	private JTextField txtNameModif;
	private JLabel lblAgentDataNameModif;
	private JTextField txtCodeModif;
	private JLabel lblAgentDataCodeModif;
	private JLabel lblAgentDataTitleModif;
	private JLabel lblAgentHabilitiesModif;
	private JLabel lblAgentDataModif;
	private JLabel lblBackgroundPanelAgentRegisterModif;
	private JButton btnAccept;
	private JDialog diag;

	/**
	 * Create the frame.
	 * 
	 * @param loginAgent
	 * @param weapon
	 * @param agentData
	 * @param mapData
	 */
	public VPestaniasAgente(Agent loginAgent, MapManager map, AgentManager agent, WeaponManager weapon) {
		agentData = agent;
		mapData = map;
		weaponData = weapon;
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VLogin.class.getResource("/resources/rotGamesLogo.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(180, 100, 1920, 1193);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel p = new JPanel();
		p.setForeground(Color.LIGHT_GRAY);
		p.setBounds(0, 0, 1920, 1080);
		setUndecorated(true);
		contentPane.add(p);
		p.setLayout(null);

		/*
		 * Botones de cerrado y minimizado
		 * 
		 */
		btnMinimize = new KButton();
		btnMinimize.kHoverColor = new Color(238, 71, 71);
		btnMinimize.kBackGroundColor = new Color(28, 43, 73);
		btnMinimize.kAllowGradient = false;
		btnMinimize.setFocusable(false);
		btnMinimize.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnMinimize.setBorderPainted(false);
		btnMinimize.setFocusPainted(false);
		btnMinimize.setkStartColor(new Color(28, 43, 73));
		btnMinimize.setContentAreaFilled(false);
		btnMinimize.kPressedColor = new Color(168, 19, 24);
		btnMinimize.kIndicatorThickness = 0;
		btnMinimize.kBorderRadius = 0;
		btnMinimize.kSelectedColor = Color.RED;
		btnMinimize.kHoverForeGround = Color.WHITE;
		btnMinimize.kHoverStartColor = new Color(238, 71, 71);
		btnMinimize.kEndColor = Color.WHITE;
		btnMinimize.kFillButton = false;
		btnMinimize.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMinimize.setText("—");
		btnMinimize.setBounds(1826, 0, 47, 37);
		btnMinimize.addActionListener(this);
		btnMinimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMinimize.kFillButton = true; // Hacer opaco el boton
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnMinimize.kFillButton = false; // Hacer transparente el boton
			}
		});

		btnClose = new KButton();
		btnClose.kHoverColor = new Color(238, 71, 71);
		btnClose.kBackGroundColor = new Color(28, 43, 73);
		btnClose.kAllowGradient = false;
		btnClose.setFocusable(false);
		btnClose.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnClose.setBorderPainted(false);
		btnClose.setFocusPainted(false);
		btnClose.setkStartColor(new Color(28, 43, 73));
		btnClose.setContentAreaFilled(false);
		btnClose.kPressedColor = new Color(168, 19, 24);
		btnClose.kIndicatorThickness = 0;
		btnClose.kBorderRadius = 0;
		btnClose.kHoverForeGround = Color.WHITE;
		btnClose.kHoverStartColor = new Color(238, 71, 71);
		btnClose.kEndColor = Color.WHITE;
		btnClose.kFillButton = false;
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClose.setText("X");
		btnClose.setBounds(1873, 0, 47, 37);
		btnClose.addActionListener(this);
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnClose.kFillButton = true; // Hacer opaco el boton
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnClose.kFillButton = false; // Hacer transparente el boton
			}
		});
		panelAgent = new JPanel();
		panelAgent.setBounds(0, 74, 1770, 1006);
		p.add(panelAgent);
		panelAgent.setLayout(null);

		btnModifyAgent = new JButton("Modificacion");
		btnModifyAgent.setBorder(null);
		btnModifyAgent.setBounds(974, 0, 177, 50);
		btnModifyAgent.addActionListener(this);

		panelModifyAgent = new JPanel();
		panelModifyAgent.setLayout(null);
		panelModifyAgent.setBounds(0, 50, 1770, 956);
		panelAgent.add(panelModifyAgent);

		lblAgentHabilitiesOrbNumModif = new JLabel("Numero de orbes");
		lblAgentHabilitiesOrbNumModif.setForeground(Color.WHITE);
		lblAgentHabilitiesOrbNumModif.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentHabilitiesOrbNumModif.setBounds(1378, 770, 149, 53);
		panelModifyAgent.add(lblAgentHabilitiesOrbNumModif);

		spinnerModif = new JSpinner();
		spinnerModif.setBounds(1510, 782, 75, 20);
		panelModifyAgent.add(spinnerModif);

		lblAgentHabilitiesDescription4Modif = new JLabel("Descripcion de la habilidad ulti");
		lblAgentHabilitiesDescription4Modif.setForeground(Color.WHITE);
		lblAgentHabilitiesDescription4Modif.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentHabilitiesDescription4Modif.setBounds(1378, 569, 207, 53);
		panelModifyAgent.add(lblAgentHabilitiesDescription4Modif);

		textAreaHabilityDescription4Modif = new JTextArea();
		textAreaHabilityDescription4Modif.setWrapStyleWord(true);
		textAreaHabilityDescription4Modif.setLineWrap(true);
		textAreaHabilityDescription4Modif.setBounds(1378, 633, 207, 138);
		panelModifyAgent.add(textAreaHabilityDescription4Modif);

		lblAgentHabilitiesName4Modif = new JLabel("Nombre de la habilidad ulti");
		lblAgentHabilitiesName4Modif.setForeground(Color.WHITE);
		lblAgentHabilitiesName4Modif.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentHabilitiesName4Modif.setBounds(1378, 467, 207, 53);
		panelModifyAgent.add(lblAgentHabilitiesName4Modif);

		txtHabilityName4Modif = new JTextField();
		txtHabilityName4Modif.setColumns(10);
		txtHabilityName4Modif.setBounds(1378, 528, 207, 30);
		panelModifyAgent.add(txtHabilityName4Modif);

		lblAgentHabilitiesName3Modif = new JLabel("Nombre de la habilidad 3");
		lblAgentHabilitiesName3Modif.setForeground(Color.WHITE);
		lblAgentHabilitiesName3Modif.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentHabilitiesName3Modif.setBounds(998, 467, 207, 53);
		panelModifyAgent.add(lblAgentHabilitiesName3Modif);

		txtHabilityName3Modif = new JTextField();
		txtHabilityName3Modif.setColumns(10);
		txtHabilityName3Modif.setBounds(998, 528, 207, 30);
		panelModifyAgent.add(txtHabilityName3Modif);

		textAreaHabilityDescription3Modif = new JTextArea();
		textAreaHabilityDescription3Modif.setWrapStyleWord(true);
		textAreaHabilityDescription3Modif.setLineWrap(true);
		textAreaHabilityDescription3Modif.setBounds(998, 633, 207, 138);
		panelModifyAgent.add(textAreaHabilityDescription3Modif);

		lblAgentHabilitiesDescription3Modif = new JLabel("Descripcion de la habilidad 3");
		lblAgentHabilitiesDescription3Modif.setForeground(Color.WHITE);
		lblAgentHabilitiesDescription3Modif.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentHabilitiesDescription3Modif.setBounds(998, 569, 207, 53);
		panelModifyAgent.add(lblAgentHabilitiesDescription3Modif);

		textAreaHabilityDescription2_1 = new JTextArea();
		textAreaHabilityDescription2_1.setWrapStyleWord(true);
		textAreaHabilityDescription2_1.setLineWrap(true);
		textAreaHabilityDescription2_1.setBounds(1378, 294, 207, 138);
		panelModifyAgent.add(textAreaHabilityDescription2_1);

		lblAgentHabilitiesName2Modif = new JLabel("Nombre de la habilidad 2");
		lblAgentHabilitiesName2Modif.setForeground(Color.WHITE);
		lblAgentHabilitiesName2Modif.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentHabilitiesName2Modif.setBounds(1378, 128, 207, 53);
		panelModifyAgent.add(lblAgentHabilitiesName2Modif);

		txtHabilityName2Modif = new JTextField();
		txtHabilityName2Modif.setColumns(10);
		txtHabilityName2Modif.setBounds(1378, 189, 207, 30);
		panelModifyAgent.add(txtHabilityName2Modif);

		lblAgentHabilitiesDescription2Modif = new JLabel("Descripcion de la habilidad 2");
		lblAgentHabilitiesDescription2Modif.setForeground(Color.WHITE);
		lblAgentHabilitiesDescription2Modif.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentHabilitiesDescription2Modif.setBounds(1378, 230, 207, 53);
		panelModifyAgent.add(lblAgentHabilitiesDescription2Modif);

		textAreaHabilityDescription1Modif = new JTextArea();
		textAreaHabilityDescription1Modif.setWrapStyleWord(true);
		textAreaHabilityDescription1Modif.setLineWrap(true);
		textAreaHabilityDescription1Modif.setBounds(998, 294, 207, 138);
		panelModifyAgent.add(textAreaHabilityDescription1Modif);

		lblAgentHabilitiesDescription1Modif = new JLabel("Descripcion de la habilidad 1");
		lblAgentHabilitiesDescription1Modif.setForeground(Color.WHITE);
		lblAgentHabilitiesDescription1Modif.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentHabilitiesDescription1Modif.setBounds(998, 230, 207, 53);
		panelModifyAgent.add(lblAgentHabilitiesDescription1Modif);

		txtHabilityName1Modif = new JTextField();
		txtHabilityName1Modif.setColumns(10);
		txtHabilityName1Modif.setBounds(998, 189, 207, 30);
		panelModifyAgent.add(txtHabilityName1Modif);

		lblAgentHabilitiesName1Modif = new JLabel("Nombre de la habilidad 1");
		lblAgentHabilitiesName1Modif.setForeground(Color.WHITE);
		lblAgentHabilitiesName1Modif.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentHabilitiesName1Modif.setBounds(998, 128, 207, 53);
		panelModifyAgent.add(lblAgentHabilitiesName1Modif);

		lblAgentHabilitiesTitleModif = new JLabel("Habilidades del agente");
		lblAgentHabilitiesTitleModif.setForeground(Color.WHITE);
		lblAgentHabilitiesTitleModif.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 20));
		lblAgentHabilitiesTitleModif.setBounds(1098, 64, 405, 53);
		panelModifyAgent.add(lblAgentHabilitiesTitleModif);

		btnModif = new JButton("Modificar agente");
		btnModif.setForeground(Color.WHITE);
		btnModif.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 12));
		btnModif.setBorder(null);
		btnModif.setBackground(Color.RED);
		btnModif.setBounds(1584, 874, 140, 40);
		panelModifyAgent.add(btnModif);

		passwordFieldModif = new JPasswordField();
		passwordFieldModif.setBounds(497, 535, 207, 30);
		panelModifyAgent.add(passwordFieldModif);

		passwordFieldConfirmModif = new JPasswordField();
		passwordFieldConfirmModif.setBounds(151, 535, 207, 30);
		panelModifyAgent.add(passwordFieldConfirmModif);

		lblAgentDataPasswd2Modif = new JLabel("Confirmar contraseña");
		lblAgentDataPasswd2Modif.setForeground(Color.WHITE);
		lblAgentDataPasswd2Modif.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentDataPasswd2Modif.setBounds(497, 474, 207, 53);
		panelModifyAgent.add(lblAgentDataPasswd2Modif);

		lblAgentDataPasswd1Modif = new JLabel("Contraseña");
		lblAgentDataPasswd1Modif.setForeground(Color.WHITE);
		lblAgentDataPasswd1Modif.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentDataPasswd1Modif.setBounds(151, 474, 207, 53);
		panelModifyAgent.add(lblAgentDataPasswd1Modif);

		lblAgentDataAdminModif = new JLabel("Admin?");
		lblAgentDataAdminModif.setForeground(Color.WHITE);
		lblAgentDataAdminModif.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentDataAdminModif.setBounds(173, 379, 207, 53);
		panelModifyAgent.add(lblAgentDataAdminModif);

		chckbxNewCheckBoxModif = new JCheckBox("");
		chckbxNewCheckBoxModif.setHorizontalTextPosition(SwingConstants.CENTER);
		chckbxNewCheckBoxModif.setFont(new Font("DINNextLTPro-Regular", Font.PLAIN, 14));
		chckbxNewCheckBoxModif.setAlignmentX(0.5f);
		chckbxNewCheckBoxModif.setBounds(151, 397, 16, 15);
		panelModifyAgent.add(chckbxNewCheckBoxModif);

		comboBoxRolModif = new JComboBox();
		comboBoxRolModif.setSelectedIndex(-1);
		comboBoxRolModif.setBounds(497, 291, 207, 30);
		panelModifyAgent.add(comboBoxRolModif);

		lblAgentDataRolModif = new JLabel("Rol del agente");
		lblAgentDataRolModif.setForeground(Color.WHITE);
		lblAgentDataRolModif.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentDataRolModif.setBounds(497, 230, 207, 53);
		panelModifyAgent.add(lblAgentDataRolModif);

		txtNationalityModif = new JTextField();
		txtNationalityModif.setColumns(10);
		txtNationalityModif.setBounds(151, 291, 207, 30);
		panelModifyAgent.add(txtNationalityModif);

		lblAgentDataNationalityModif = new JLabel("Nacionalidad del agente");
		lblAgentDataNationalityModif.setForeground(Color.WHITE);
		lblAgentDataNationalityModif.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentDataNationalityModif.setBounds(151, 230, 207, 53);
		panelModifyAgent.add(lblAgentDataNationalityModif);

		txtNameModif = new JTextField();
		txtNameModif.setColumns(10);
		txtNameModif.setBounds(497, 189, 207, 30);
		panelModifyAgent.add(txtNameModif);

		lblAgentDataNameModif = new JLabel("Nombre del agente");
		lblAgentDataNameModif.setForeground(Color.WHITE);
		lblAgentDataNameModif.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentDataNameModif.setBounds(497, 128, 207, 53);
		panelModifyAgent.add(lblAgentDataNameModif);

		txtCodeModif = new JTextField();
		txtCodeModif.setColumns(10);
		txtCodeModif.setBounds(151, 189, 207, 30);
		panelModifyAgent.add(txtCodeModif);

		lblAgentDataCodeModif = new JLabel("Codigo del agente");
		lblAgentDataCodeModif.setForeground(Color.WHITE);
		lblAgentDataCodeModif.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentDataCodeModif.setBounds(151, 128, 207, 53);
		panelModifyAgent.add(lblAgentDataCodeModif);

		lblAgentDataTitleModif = new JLabel("Datos del agente");
		lblAgentDataTitleModif.setForeground(Color.WHITE);
		lblAgentDataTitleModif.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 20));
		lblAgentDataTitleModif.setBounds(151, 64, 405, 53);
		panelModifyAgent.add(lblAgentDataTitleModif);

		lblAgentHabilitiesModif = new JLabel("");
		lblAgentHabilitiesModif.setBorder(new LineBorder(Color.WHITE, 2));
		lblAgentHabilitiesModif.setBounds(908, 25, 816, 817);
		panelModifyAgent.add(lblAgentHabilitiesModif);

		lblAgentDataModif = new JLabel("");
		lblAgentDataModif.setBorder(new LineBorder(Color.WHITE, 2));
		lblAgentDataModif.setBounds(44, 25, 816, 817);
		panelModifyAgent.add(lblAgentDataModif);

		lblBackgroundPanelAgentRegisterModif = new JLabel("");
		lblBackgroundPanelAgentRegisterModif
				.setIcon(new ImageIcon(VPestaniasAgente.class.getResource("/resources/appBackgroundUnderPanel.jpg")));
		lblBackgroundPanelAgentRegisterModif.setBounds(0, 0, 1770, 956);
		panelModifyAgent.add(lblBackgroundPanelAgentRegisterModif);

		panelRemoveAgent = new JPanel();
		panelRemoveAgent.setBounds(0, 50, 1770, 956);
		panelAgent.add(panelRemoveAgent);
		panelRemoveAgent.setLayout(null);

		lblBackgroundPanelAgentRegister_2 = new JLabel("");
		lblBackgroundPanelAgentRegister_2
				.setIcon(new ImageIcon(VPestaniasAgente.class.getResource("/resources/appBackgroundUnderPanel.jpg")));
		lblBackgroundPanelAgentRegister_2.setBounds(0, 0, 1770, 956);
		panelRemoveAgent.add(lblBackgroundPanelAgentRegister_2);

		panelRegisterAgent = new JPanel();
		panelRegisterAgent.setBounds(0, 50, 1770, 956);
		panelAgent.add(panelRegisterAgent);
		panelRegisterAgent.setLayout(null);

		lblAgentHabilitiesOrbNum = new JLabel("Numero de orbes");
		lblAgentHabilitiesOrbNum.setForeground(Color.WHITE);
		lblAgentHabilitiesOrbNum.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentHabilitiesOrbNum.setBounds(1378, 770, 149, 53);
		panelRegisterAgent.add(lblAgentHabilitiesOrbNum);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(5, 5, 8, 1));
		spinner.setBounds(1510, 782, 75, 20);
		panelRegisterAgent.add(spinner);

		lblAgentHabilitiesDescription4 = new JLabel("Descripcion de la habilidad ulti");
		lblAgentHabilitiesDescription4.setForeground(Color.WHITE);
		lblAgentHabilitiesDescription4.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentHabilitiesDescription4.setBounds(1378, 569, 207, 53);
		panelRegisterAgent.add(lblAgentHabilitiesDescription4);

		textAreaHabilityDescription4 = new JTextArea();
		textAreaHabilityDescription4.setWrapStyleWord(true);
		textAreaHabilityDescription4.setLineWrap(true);
		textAreaHabilityDescription4.setBounds(1378, 633, 207, 138);
		panelRegisterAgent.add(textAreaHabilityDescription4);

		lblAgentHabilitiesName4 = new JLabel("Nombre de la habilidad ulti");
		lblAgentHabilitiesName4.setForeground(Color.WHITE);
		lblAgentHabilitiesName4.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentHabilitiesName4.setBounds(1378, 467, 207, 53);
		panelRegisterAgent.add(lblAgentHabilitiesName4);

		txtHabilityName4 = new JTextField();
		txtHabilityName4.setColumns(10);
		txtHabilityName4.setBounds(1378, 528, 207, 30);
		panelRegisterAgent.add(txtHabilityName4);

		lblAgentHabilitiesName3 = new JLabel("Nombre de la habilidad 3");
		lblAgentHabilitiesName3.setForeground(Color.WHITE);
		lblAgentHabilitiesName3.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentHabilitiesName3.setBounds(998, 467, 207, 53);
		panelRegisterAgent.add(lblAgentHabilitiesName3);

		txtHabilityName3 = new JTextField();
		txtHabilityName3.setColumns(10);
		txtHabilityName3.setBounds(998, 528, 207, 30);
		panelRegisterAgent.add(txtHabilityName3);

		textAreaHabilityDescription3 = new JTextArea();
		textAreaHabilityDescription3.setWrapStyleWord(true);
		textAreaHabilityDescription3.setLineWrap(true);
		textAreaHabilityDescription3.setBounds(998, 633, 207, 138);
		panelRegisterAgent.add(textAreaHabilityDescription3);

		lblAgentHabilitiesDescription3 = new JLabel("Descripcion de la habilidad 3");
		lblAgentHabilitiesDescription3.setForeground(Color.WHITE);
		lblAgentHabilitiesDescription3.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentHabilitiesDescription3.setBounds(998, 569, 207, 53);
		panelRegisterAgent.add(lblAgentHabilitiesDescription3);

		textAreaHabilityDescription2 = new JTextArea();
		textAreaHabilityDescription2.setWrapStyleWord(true);
		textAreaHabilityDescription2.setLineWrap(true);
		textAreaHabilityDescription2.setBounds(1378, 294, 207, 138);
		panelRegisterAgent.add(textAreaHabilityDescription2);

		lblAgentHabilitiesName2 = new JLabel("Nombre de la habilidad 2");
		lblAgentHabilitiesName2.setForeground(Color.WHITE);
		lblAgentHabilitiesName2.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentHabilitiesName2.setBounds(1378, 128, 207, 53);
		panelRegisterAgent.add(lblAgentHabilitiesName2);

		txtHabilityName2 = new JTextField();
		txtHabilityName2.setColumns(10);
		txtHabilityName2.setBounds(1378, 189, 207, 30);
		panelRegisterAgent.add(txtHabilityName2);

		lblAgentHabilitiesDescription2 = new JLabel("Descripcion de la habilidad 2");
		lblAgentHabilitiesDescription2.setForeground(Color.WHITE);
		lblAgentHabilitiesDescription2.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentHabilitiesDescription2.setBounds(1378, 230, 207, 53);
		panelRegisterAgent.add(lblAgentHabilitiesDescription2);

		JTextArea textAreaHabilityDescription1 = new JTextArea();
		textAreaHabilityDescription1.setBounds(998, 294, 207, 138);
		textAreaHabilityDescription1.setLineWrap(true);
		textAreaHabilityDescription1.setWrapStyleWord(true);
		panelRegisterAgent.add(textAreaHabilityDescription1);

		JLabel lblAgentHabilitiesDescription1 = new JLabel("Descripcion de la habilidad 1");
		lblAgentHabilitiesDescription1.setForeground(Color.WHITE);
		lblAgentHabilitiesDescription1.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentHabilitiesDescription1.setBounds(998, 230, 207, 53);
		panelRegisterAgent.add(lblAgentHabilitiesDescription1);

		txtHabilityName1 = new JTextField();
		txtHabilityName1.setColumns(10);
		txtHabilityName1.setBounds(998, 189, 207, 30);
		panelRegisterAgent.add(txtHabilityName1);

		JLabel lblAgentHabilitiesName1 = new JLabel("Nombre de la habilidad 1");
		lblAgentHabilitiesName1.setForeground(Color.WHITE);
		lblAgentHabilitiesName1.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentHabilitiesName1.setBounds(998, 128, 207, 53);
		panelRegisterAgent.add(lblAgentHabilitiesName1);

		JLabel lblAgentHabilitiesTitle = new JLabel("Habilidades del agente");
		lblAgentHabilitiesTitle.setForeground(Color.WHITE);
		lblAgentHabilitiesTitle.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 20));
		lblAgentHabilitiesTitle.setBounds(1098, 64, 405, 53);
		panelRegisterAgent.add(lblAgentHabilitiesTitle);

		JButton btnClean = new JButton("Limiar datos");
		btnClean.setForeground(Color.WHITE);
		btnClean.setBackground(new Color(255, 0, 0));
		btnClean.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 12));
		btnClean.setBorder(null);
		btnClean.setBounds(1409, 874, 140, 40);
		panelRegisterAgent.add(btnClean);

		JButton btnConfirm = new JButton("Añadir agente");
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.setBackground(new Color(255, 0, 0));
		btnConfirm.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 12));
		btnConfirm.setBorder(null);
		btnConfirm.setBounds(1584, 874, 140, 40);
		panelRegisterAgent.add(btnConfirm);

		txtPasswd2 = new JPasswordField();
		txtPasswd2.setBounds(497, 535, 207, 30);
		panelRegisterAgent.add(txtPasswd2);

		txtPasswd1 = new JPasswordField();
		txtPasswd1.setBounds(151, 535, 207, 30);
		panelRegisterAgent.add(txtPasswd1);

		lblAgentDataPasswd2 = new JLabel("Confirmar contraseña");
		lblAgentDataPasswd2.setForeground(Color.WHITE);
		lblAgentDataPasswd2.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentDataPasswd2.setBounds(497, 474, 207, 53);
		panelRegisterAgent.add(lblAgentDataPasswd2);

		JLabel lblAgentDataPasswd1 = new JLabel("Contraseña");
		lblAgentDataPasswd1.setForeground(Color.WHITE);
		lblAgentDataPasswd1.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentDataPasswd1.setBounds(151, 474, 207, 53);
		panelRegisterAgent.add(lblAgentDataPasswd1);

		lblAgentDataAdmin = new JLabel("Admin?");
		lblAgentDataAdmin.setForeground(Color.WHITE);
		lblAgentDataAdmin.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentDataAdmin.setBounds(173, 379, 207, 53);
		panelRegisterAgent.add(lblAgentDataAdmin);

		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setHorizontalTextPosition(SwingConstants.CENTER);
		chckbxNewCheckBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		chckbxNewCheckBox.setFont(new Font("DINNextLTPro-Regular", Font.PLAIN, 14));
		chckbxNewCheckBox.setBounds(151, 397, 16, 15);
		panelRegisterAgent.add(chckbxNewCheckBox);

		comboBoxRol = new JComboBox();
		comboBoxRol
				.setModel(new DefaultComboBoxModel(new String[] { "Duelist", "Sentinel", "Controller", "Initiator" }));
		comboBoxRol.setBounds(497, 291, 207, 30);
		comboBoxRol.setSelectedIndex(-1);
		panelRegisterAgent.add(comboBoxRol);

		lblAgentDataRol = new JLabel("Rol del agente");
		lblAgentDataRol.setForeground(Color.WHITE);
		lblAgentDataRol.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentDataRol.setBounds(497, 230, 207, 53);
		panelRegisterAgent.add(lblAgentDataRol);

		txtNationality = new JTextField();
		txtNationality.setColumns(10);
		txtNationality.setBounds(151, 291, 207, 30);
		panelRegisterAgent.add(txtNationality);

		lblAgentDataNationality = new JLabel("Nacionalidad del agente");
		lblAgentDataNationality.setForeground(Color.WHITE);
		lblAgentDataNationality.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentDataNationality.setBounds(151, 230, 207, 53);
		panelRegisterAgent.add(lblAgentDataNationality);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(497, 189, 207, 30);
		panelRegisterAgent.add(txtName);

		lblAgentDataName = new JLabel("Nombre del agente");
		lblAgentDataName.setForeground(Color.WHITE);
		lblAgentDataName.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentDataName.setBounds(497, 128, 207, 53);
		panelRegisterAgent.add(lblAgentDataName);

		txtCode = new JTextField();
		txtCode.setBounds(151, 189, 207, 30);
		panelRegisterAgent.add(txtCode);
		txtCode.setColumns(10);

		lblAgentDataCode = new JLabel("Codigo del agente");
		lblAgentDataCode.setForeground(Color.WHITE);
		lblAgentDataCode.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentDataCode.setBounds(151, 128, 207, 53);
		panelRegisterAgent.add(lblAgentDataCode);

		JLabel lblAgentDataTitle = new JLabel("Datos del agente");
		lblAgentDataTitle.setForeground(Color.WHITE);
		lblAgentDataTitle.setBounds(151, 64, 405, 53);
		lblAgentDataTitle.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 20));
		panelRegisterAgent.add(lblAgentDataTitle);

		lblAgentHabilities = new JLabel("");
		lblAgentHabilities.setBorder(new LineBorder(Color.WHITE, 2));
		lblAgentHabilities.setBounds(908, 25, 816, 817);
		panelRegisterAgent.add(lblAgentHabilities);

		JLabel lblAgentData = new JLabel("");
		lblAgentData.setBorder(new LineBorder(Color.WHITE, 2));
		lblAgentData.setBounds(44, 25, 816, 817);
		panelRegisterAgent.add(lblAgentData);

		lblBackgroundPanelAgentRegister = new JLabel("");
		lblBackgroundPanelAgentRegister
				.setIcon(new ImageIcon(VPestaniasAgente.class.getResource("/resources/appBackgroundUnderPanel.jpg")));
		lblBackgroundPanelAgentRegister.setBounds(0, 0, 1770, 956);
		panelRegisterAgent.add(lblBackgroundPanelAgentRegister);
		panelAgent.add(btnModifyAgent);

		btnRegisterAgent = new JButton("Alta");
		btnRegisterAgent.setBorder(null);
		btnRegisterAgent.setBounds(620, 0, 177, 50);
		btnRegisterAgent.addActionListener(this);
		panelAgent.add(btnRegisterAgent);

		btnRemoveAgent = new JButton("Baja");
		btnRemoveAgent.setBorder(null);
		btnRemoveAgent.setBounds(797, 0, 177, 50);
		btnRemoveAgent.addActionListener(this);
		panelAgent.add(btnRemoveAgent);

		JLabel lblBackgroundPanelAgent = new JLabel("");
		lblBackgroundPanelAgent
				.setIcon(new ImageIcon(VPestaniasAgente.class.getResource("/resources/appBackgroundPanel.jpg")));
		lblBackgroundPanelAgent.setBounds(0, 0, 1770, 1006);
		panelAgent.add(lblBackgroundPanelAgent);
		panelMission = new JPanel();
		panelMission.setLayout(null);
		panelMission.setBounds(0, 74, 1770, 1006);
		p.add(panelMission);

		panelHistoricMission = new JPanel();
		panelHistoricMission.setLayout(null);
		panelHistoricMission.setBounds(0, 50, 1770, 956);
		panelMission.add(panelHistoricMission);

		lblNewLabel = new JLabel("panelHistoricMissionhjghjghjghjghj");
		lblNewLabel.setBounds(130, 159, 284, 114);
		panelHistoricMission.add(lblNewLabel);

		panelBackgroundHistoricMission = new JLabel("");
		panelBackgroundHistoricMission
				.setIcon(new ImageIcon(VPestaniasAgente.class.getResource("/resources/appBackgroundUnderPanel.jpg")));
		panelBackgroundHistoricMission.setBounds(0, 0, 1770, 956);
		panelHistoricMission.add(panelBackgroundHistoricMission);

		panelRegisterMission = new JPanel();
		panelRegisterMission.setBounds(0, 50, 1770, 956);
		panelMission.add(panelRegisterMission);
		panelRegisterMission.setLayout(null);

		lblPanelregistermission = new JLabel("panelRegisterMissionxfggfdfgf");
		lblPanelregistermission.setBounds(240, 160, 284, 114);
		panelRegisterMission.add(lblPanelregistermission);

		panelBackgroundRegisterMission = new JLabel("");
		panelBackgroundRegisterMission
				.setIcon(new ImageIcon(VPestaniasAgente.class.getResource("/resources/appBackgroundUnderPanel.jpg")));
		panelBackgroundRegisterMission.setBounds(0, 0, 1770, 956);
		panelRegisterMission.add(panelBackgroundRegisterMission);

		btnHistoricMission = new JButton("Historial");
		btnHistoricMission.setBorder(null);
		btnHistoricMission.setBounds(884, 0, 177, 50);
		btnHistoricMission.addActionListener(this);
		panelMission.add(btnHistoricMission);

		btnRegisterMission = new JButton("Alta");
		btnRegisterMission.setBorder(null);
		btnRegisterMission.setBounds(707, 0, 177, 50);
		btnRegisterMission.addActionListener(this);
		panelMission.add(btnRegisterMission);

		JLabel lblBackgroundPanelMission = new JLabel("");
		lblBackgroundPanelMission
				.setIcon(new ImageIcon(VPestaniasAgente.class.getResource("/resources/appBackgroundPanel.jpg")));
		lblBackgroundPanelMission.setBounds(0, 0, 1770, 1006);
		panelMission.add(lblBackgroundPanelMission);
		panelWeapon = new JPanel();
		panelWeapon.setLayout(null);
		panelWeapon.setBounds(0, 74, 1770, 1006);
		p.add(panelWeapon);

		panelRegisterWeapon = new JPanel();
		panelRegisterWeapon.setBounds(0, 50, 1770, 956);
		panelWeapon.add(panelRegisterWeapon);
		panelRegisterWeapon.setLayout(null);

		lblNewLabel_3 = new JLabel("New labeldffdgdfgdfg");
		lblNewLabel_3.setBounds(151, 359, 286, 131);
		panelRegisterWeapon.add(lblNewLabel_3);

		panelBackgroundRegisterWeapon = new JLabel("");
		panelBackgroundRegisterWeapon
				.setIcon(new ImageIcon(VPestaniasAgente.class.getResource("/resources/appBackgroundUnderPanel.jpg")));
		panelBackgroundRegisterWeapon.setBounds(0, 0, 1770, 956);
		panelRegisterWeapon.add(panelBackgroundRegisterWeapon);

		panelModifyWeapon = new JPanel();
		panelModifyWeapon.setBounds(0, 50, 1770, 956);
		panelWeapon.add(panelModifyWeapon);
		panelModifyWeapon.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("New labeldffdgdfgdfg");
		lblNewLabel_1.setBounds(83, 89, 286, 131);
		panelModifyWeapon.add(lblNewLabel_1);

		panelBackgroundModifyWeapon = new JLabel("");
		panelBackgroundModifyWeapon
				.setIcon(new ImageIcon(VPestaniasAgente.class.getResource("/resources/appBackgroundUnderPanel.jpg")));
		panelBackgroundModifyWeapon.setBounds(0, 0, 1770, 956);
		panelModifyWeapon.add(panelBackgroundModifyWeapon);

		panelRemoveWeapon = new JPanel();
		panelRemoveWeapon.setBounds(0, 50, 1770, 956);
		panelWeapon.add(panelRemoveWeapon);
		panelRemoveWeapon.setLayout(null);

		lblNewLabel_2 = new JLabel("New labeldffdgdfgdfg");
		lblNewLabel_2.setBounds(0, 0, 286, 131);
		panelRemoveWeapon.add(lblNewLabel_2);

		panelBackgroundRemoveWeapon = new JLabel("");
		panelBackgroundRemoveWeapon
				.setIcon(new ImageIcon(VPestaniasAgente.class.getResource("/resources/appBackgroundUnderPanel.jpg")));
		panelBackgroundRemoveWeapon.setBounds(0, 0, 1770, 956);
		panelRemoveWeapon.add(panelBackgroundRemoveWeapon);

		btnModifyWeapon = new JButton("Modificacion");
		btnModifyWeapon.setBorder(null);
		btnModifyWeapon.setBounds(974, 0, 177, 50);
		btnModifyWeapon.addActionListener(this);
		panelWeapon.add(btnModifyWeapon);

		btnRegisterWeapon = new JButton("Alta");
		btnRegisterWeapon.setBorder(null);
		btnRegisterWeapon.setBounds(620, 0, 177, 50);
		btnRegisterWeapon.addActionListener(this);
		panelWeapon.add(btnRegisterWeapon);

		btnRemoveWeapon = new JButton("Baja");
		btnRemoveWeapon.setBorder(null);
		btnRemoveWeapon.setBounds(797, 0, 177, 50);
		btnRemoveWeapon.addActionListener(this);
		panelWeapon.add(btnRemoveWeapon);

		JLabel lblBackgroundPanelWeapon = new JLabel("");
		lblBackgroundPanelWeapon
				.setIcon(new ImageIcon(VPestaniasAgente.class.getResource("/resources/appBackgroundPanel.jpg")));
		lblBackgroundPanelWeapon.setBounds(0, 0, 1920, 1006);
		panelWeapon.add(lblBackgroundPanelWeapon);
		panelMap = new JPanel();
		panelMap.setLayout(null);
		panelMap.setBounds(0, 74, 1770, 1006);
		p.add(panelMap);

		JLabel lblBackgroundPanelMap = new JLabel("");
		lblBackgroundPanelMap
				.setIcon(new ImageIcon(VPestaniasAgente.class.getResource("/resources/appBackgroundPanel.jpg")));
		lblBackgroundPanelMap.setBounds(0, 0, 1920, 1006);
		panelMap.add(lblBackgroundPanelMap);

		lblHandCursor = new JLabel("");
		lblHandCursor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblHandCursor.setBounds(1826, 0, 94, 37);
		p.add(lblHandCursor);

		/*
		 * Panel Agente
		 * 
		 */

		/*
		 * Panel Mision
		 * 
		 */

		/*
		 * Panel Arma
		 * 
		 */

		/*
		 * Panel Mapa
		 * 
		 */

		/*
		 * Tabla lateral
		 * 
		 */

		try {
			Set<Agent> agents = agentData.getAllAgents();

			List<Agent> agentsOrder = new ArrayList<Agent>(agents);
			Collections.sort(agentsOrder);
			String matrizTabla[][] = new String[agents.size()][1];

			for (Agent newAgent : agentsOrder) {
				matrizTabla[cont][0] = newAgent.getAgentName() + " // " + newAgent.getAgentCode();
				cont++;
			}

			String titulo[] = { "Agentes" };
			scrollPane = new JScrollPane();
			scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			scrollPane.setBounds(1770, 74, 150, 1006);
			p.add(scrollPane);

			table = new JTable(matrizTabla, titulo) {
				/*
				 * 
				 */
				private static final long serialVersionUID = 1L;

				// ***********************METODO PARA HACER QUE LA TABLA NO SEA EDITABLE, Y ASI
				// HACER DOBLE CLICK************************************
				// Para ello sobreescribimos el metodo que ya tiene la clase
				// JTable.isCellEditable
				public boolean isCellEditable(int row, int column) {
					for (int i = 0; i < table.getRowCount(); i++) {
						if (row == i) {
							return false;
						}
					}
					return true;
				}
			};

			RowsRenderer rRowsRenderer = new RowsRenderer(4);
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			table.setDefaultRenderer(Object.class, rRowsRenderer);
			table.setSelectionBackground(new Color(0, 230, 168));
			table.setSelectionForeground(Color.WHITE);
			table.setRowMargin(0);
			table.setRowHeight(30);
			table.setShowVerticalLines(false);
			table.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 18));
			table.isCellEditable(agentsOrder.size(), 1);
			table.addMouseListener(this);
			centerRenderer.setHorizontalAlignment(JLabel.CENTER);
			table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
			scrollPane.setViewportView(table);

			JTableHeader tableHeader = table.getTableHeader();
			tableHeader.setBackground(new Color(0, 191, 140));
			tableHeader.setForeground(Color.WHITE);
			tableHeader.setFont(new Font("Tahoma", Font.BOLD, 15));
			tableHeader.setBorder(null);
			tableHeader.setEnabled(false);
		} catch (ExceptionManager e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		/*
		 * Boton pestaña Agente
		 */
		btnAgent = new JButton("Agente");
		btnAgent.setBorderPainted(false);
		btnAgent.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnAgent.setForeground(Color.WHITE);
		btnAgent.setBackground(new Color(0, 0, 102));
		btnAgent.setBorder(null);
		btnAgent.setBounds(531, 0, 177, 74);
		btnAgent.addActionListener(this);
		p.add(btnAgent);

		/*
		 * Boton pestaña Mision
		 */
		btnMission = new JButton("Mision");
		btnMission.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnMission.setForeground(Color.WHITE);
		btnMission.setBackground(new Color(0, 0, 102));
		btnMission.setBorder(null);
		btnMission.setBounds(708, 0, 177, 74);
		btnMission.addActionListener(this);
		p.add(btnMission);

		/*
		 * Boton pestaña Arma
		 */
		btnWeapon = new JButton("Arma");
		btnWeapon.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnWeapon.setForeground(Color.WHITE);
		btnWeapon.setBackground(new Color(0, 0, 102));
		btnWeapon.setBorder(null);
		btnWeapon.setBounds(885, 0, 177, 74);
		btnWeapon.addActionListener(this);
		p.add(btnWeapon);

		/*
		 * Boton pestaña Mapa
		 */
		btnMap = new JButton("Mapa");
		btnMap.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnMap.setForeground(Color.WHITE);
		btnMap.setBackground(new Color(0, 0, 102));
		btnMap.setBorder(null);
		btnMap.setBounds(1062, 0, 177, 74);
		btnMap.addActionListener(this);
		p.add(btnMap);
		p.add(btnClose);
		p.add(btnMinimize);

		/*
		 * Background
		 * 
		 */

		lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon(VPestaniasAgente.class.getResource("/resources/rotGamesLogo100x52.png")));
		lblIcon.setBounds(10, 11, 100, 52);
		p.add(lblIcon);

		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(VPestaniasAgente.class.getResource("/resources/appBackground.jpg")));
		lblBackground.setOpaque(true);
		lblBackground.setBackground(new Color(72, 72, 74));
		lblBackground.setBounds(0, 0, 1920, 1080);
		p.add(lblBackground);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnClose)) {
			VLogin vMain = new VLogin(mapData, agentData, weaponData);
			vMain.setVisible(true);
			this.dispose();
		} else if (e.getSource().equals(btnMinimize)) {
			this.setState(Frame.ICONIFIED);
		} else if (e.getSource().equals(btnAgent)) {
			panelAgent.setVisible(true);
			panelMission.setVisible(false);
			panelWeapon.setVisible(false);
			panelMap.setVisible(false);
		} else if (e.getSource().equals(btnMission)) {
			panelAgent.setVisible(false);
			panelMission.setVisible(true);
			panelWeapon.setVisible(false);
			panelMap.setVisible(false);
		} else if (e.getSource().equals(btnWeapon)) {
			panelAgent.setVisible(false);
			panelMission.setVisible(false);
			panelWeapon.setVisible(true);
			panelMap.setVisible(false);
		} else if (e.getSource().equals(btnMap)) {
			panelAgent.setVisible(false);
			panelMission.setVisible(false);
			panelWeapon.setVisible(false);
			panelMap.setVisible(true);
		} else if (e.getSource().equals(btnRegisterAgent)) {
			panelRegisterAgent.setVisible(true);
			panelModifyAgent.setVisible(false);
			panelRemoveAgent.setVisible(false);
		} else if (e.getSource().equals(btnModifyAgent)) {
			panelRegisterAgent.setVisible(false);
			panelModifyAgent.setVisible(true);
			panelRemoveAgent.setVisible(false);

			btnAccept = new JButton("Aceptar");
			btnAccept.setBounds(0, 900, 89, 23);
			btnAccept.addActionListener(this);
			panelModifyAgent.add(btnAccept);

			JComboBox comboBox = new JComboBox();
			try {
				Set<Agent> agents = agentData.getAllAgents();

				List<Agent> agentsOrder = new ArrayList<Agent>(agents);
				Collections.sort(agentsOrder);

				for (Agent newAgent : agentsOrder) {
					comboBox.addItem(newAgent.getAgentName() + " // " + newAgent.getAgentCode());
				}
			} catch (ExceptionManager e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Object[] options = new Object[] {};
			JOptionPane jop = new JOptionPane("Please Select", JOptionPane.QUESTION_MESSAGE,
					JOptionPane.OK_CANCEL_OPTION, null, options, -1);
			jop.add(comboBox);
			jop.add(btnAccept);

			diag = new JDialog();
			diag.setModal(true);
			diag.getContentPane().add(jop);
			diag.pack();
			diag.setVisible(true);

			String getAgente = comboBox.getSelectedItem().toString();

			/**
			 * JOptionPane.showConfirmDialog(null, comboBox, "Fav Sports",
			 * JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
			 */
			// System.out.println(JOptionPane.showConfirmDialog(null, comboBox, "Seleccione
			// el agente", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE));
		} else if (e.getSource().equals(btnRemoveAgent)) {
			panelRegisterAgent.setVisible(false);
			panelModifyAgent.setVisible(false);
			panelRemoveAgent.setVisible(true);
			VRemoveAgent vRemoveAgent = new VRemoveAgent(this, true, agentData);
			vRemoveAgent.setVisible(true);
		} else if (e.getSource().equals(btnRegisterWeapon)) {
			panelRegisterWeapon.setVisible(true);
			panelModifyWeapon.setVisible(false);
			panelRemoveWeapon.setVisible(false);
		} else if (e.getSource().equals(btnModifyWeapon)) {
			panelRegisterWeapon.setVisible(false);
			panelModifyWeapon.setVisible(true);
			panelRemoveWeapon.setVisible(false);
		} else if (e.getSource().equals(btnRemoveWeapon)) {
			panelRegisterWeapon.setVisible(false);
			panelModifyWeapon.setVisible(false);
			panelRemoveWeapon.setVisible(true);
		} else if (e.getSource().equals(btnRegisterMission)) {
			panelRegisterMission.setVisible(true);
			panelHistoricMission.setVisible(false);
		} else if (e.getSource().equals(btnHistoricMission)) {
			panelRegisterMission.setVisible(false);
			panelHistoricMission.setVisible(true);
		} else if (e.getSource().equals(btnAccept)) {
			diag.dispose();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(table)) {
			if (e.getClickCount() == 2) {
				try {
					Set<Agent> agents = agentData.getAllAgents();
					List<Agent> agentsOrder = new ArrayList<Agent>(agents);
					Collections.sort(agentsOrder);

					Agent newAgent = new Agent();
					table = (JTable) e.getSource();
					int row = table.getSelectedRow();

					Icon newIcon = new ImageIcon(
							VPestaniasAgente.class.getResource("/resources/rotGamesLogo100x52.png"));
					newAgent = agentsOrder.get(row);
					JOptionPane.showMessageDialog(this, newAgent.getAgentName() + " " + newAgent.getAgentCode(),
							"Agente", JOptionPane.DEFAULT_OPTION, newIcon);
				} catch (ExceptionManager e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
