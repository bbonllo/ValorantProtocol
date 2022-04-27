package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Frame;

import model.Map;
import model.MapManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

import com.k33ptoo.components.KButton;

import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JTextPane;
import javax.swing.Box;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.JScrollBar;

public class VPestaniasAgente extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private MapManager mapData;
	private JPanel contentPane;
	private KButton btnMinimize;
	private KButton btnClose;
	private JLabel lblIcon;
	private JLabel lblHandCursor2;
	private JLabel lblBackground;
	private JTabbedPane tabbedPane;

	/**
	 * Create the frame.
	 * 
	 * @param user
	 * @param mapData
	 */
	public VPestaniasAgente(String user, MapManager map) {
		mapData = map;
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
		p.setBounds(0, 0, 1924, 1080);
		setUndecorated(true);
		contentPane.add(p);
		p.setLayout(null);

		/*
		 * Botones de cerrado minimizado y login
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

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(0, 74, 1920, 1017);
		p.add(tabbedPane);

		JPanel panelAgent = new JPanel();
		tabbedPane.addTab("New tab", null, panelAgent, null);
		panelAgent.setLayout(null);

		JPanel panelMission = new JPanel();
		tabbedPane.addTab("New tab", null, panelMission, null);
		panelMission.setLayout(null);

		JPanel panelWeapon = new JPanel();
		tabbedPane.addTab("New tab", null, panelWeapon, null);
		panelWeapon.setLayout(null);

		JPanel panelMap = new JPanel();
		tabbedPane.addTab("New tab", null, panelMap, null);
		panelMap.setLayout(null);

		JLabel agentTab = new JLabel();
		agentTab.setText("Agentes");
		agentTab.setForeground(Color.WHITE);
		agentTab.setBackground(new Color(23, 36, 63));
		agentTab.setOpaque(true);
		agentTab.setHorizontalAlignment(SwingConstants.CENTER);
		agentTab.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 15));
		agentTab.setPreferredSize(new Dimension(200, 30));
		tabbedPane.setTabComponentAt(0, agentTab);

		JLabel missionTab = new JLabel();
		missionTab.setText("Misiones");
		missionTab.setHorizontalAlignment(SwingConstants.CENTER);
		missionTab.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 15));
		missionTab.setPreferredSize(new Dimension(200, 30));
		tabbedPane.setTabComponentAt(1, missionTab);

		JLabel weaponTab = new JLabel();
		weaponTab.setText("Armas");
		// weaponTab.setIcon(new
		// ImageIcon(VPestaniasAgente.class.getResource("/resources/appBackground.jpg")));
		weaponTab.setHorizontalAlignment(SwingConstants.CENTER);
		weaponTab.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 15));
		weaponTab.setPreferredSize(new Dimension(200, 30));
		tabbedPane.setTabComponentAt(2, weaponTab);

		JLabel mapTab = new JLabel();
		mapTab.setText("Mapas");
		mapTab.setHorizontalAlignment(SwingConstants.CENTER);
		mapTab.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 15));
		mapTab.setPreferredSize(new Dimension(200, 30));
		tabbedPane.setTabComponentAt(3, mapTab);

		lblHandCursor2 = new JLabel("");
		lblHandCursor2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblHandCursor2.setBounds(1826, 0, 94, 37);
		p.add(lblHandCursor2);
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
			VLogin vMain = new VLogin(mapData);
			vMain.setVisible(true);
			this.dispose();
		} else if (e.getSource().equals(btnMinimize)) {
			this.setState(Frame.ICONIFIED);
		}
	}
}
