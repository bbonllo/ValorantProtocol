package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Frame;

import com.k33ptoo.components.KButton;

import controlador.AgentManager;
import controlador.MapManager;
import controlador.WeaponManager;
import exceptions.ExceptionManager;
import model.Agent;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VLogin extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private AgentManager agentData;
	private MapManager mapData;
	private WeaponManager weaponData;
	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPasswd;
	private JLabel lblUser;
	private JLabel lblPassword;
	private KButton btnMinimize;
	private KButton btnClose;
	private KButton btnLogin;
	private JLabel lblIcon;
	private JLabel lblHandCursor;
	private JLabel lblHandCursor2;
	private JLabel lblVersion;
	private JLabel lblTabBar;
	private JLabel lblLoginBackground;
	private JLabel lblIconBackground;
	private int x_pressed = 0;
	private int y_pressed = 0;

	/**
	 * Create the frame.
	 * 
	 * @param map
	 * @param agent
	 * @param weapon
	 */

	public VLogin(MapManager map, AgentManager agent, WeaponManager weapon) {
		agentData = agent;
		mapData = map;
		weaponData = weapon;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VLogin.class.getResource("/resources/rotGamesLogo.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(180, 100, 1560, 880);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel p = new JPanel();
		p.setForeground(Color.LIGHT_GRAY);
		p.setBounds(0, 0, 1560, 880);
		setUndecorated(true);
		contentPane.add(p);
		p.setLayout(null);

		/*
		 * Label para cambiar el cursor (el KButton no permite cambiarlo)
		 * 
		 */

		lblHandCursor2 = new JLabel("");
		lblHandCursor2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblHandCursor2.setBounds(1466, 0, 94, 31);
		p.add(lblHandCursor2);

		lblHandCursor = new JLabel("");
		lblHandCursor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblHandCursor.setBounds(237, 677, 60, 60);
		p.add(lblHandCursor);

		/*
		 * Botones de cerrado minimizado y login
		 * 
		 */

		btnClose = new KButton();
		btnClose.setFocusable(false);
		btnClose.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnClose.setBorderPainted(false);
		btnClose.setFocusPainted(false);
		btnClose.setkStartColor(new Color(130, 191, 184));
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
		btnClose.setBounds(1513, 0, 47, 31);
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
		p.add(btnClose);

		btnMinimize = new KButton();
		btnMinimize.setFocusable(false);
		btnMinimize.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnMinimize.setBorderPainted(false);
		btnMinimize.setFocusPainted(false);
		btnMinimize.setkStartColor(new Color(130, 191, 184));
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
		btnMinimize.setBounds(1466, 0, 47, 31);
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
		p.add(btnMinimize);

		btnLogin = new KButton();
		btnLogin.kHoverForeGround = Color.WHITE;
		btnLogin.kHoverColor = new Color(188, 37, 42);
		btnLogin.kBackGroundColor = new Color(209, 54, 57);
		btnLogin.setFocusable(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setFocusPainted(false);
		btnLogin.setkStartColor(Color.WHITE);
		btnLogin.kPressedColor = new Color(168, 19, 24);
		btnLogin.kAllowGradient = false;
		btnLogin.kBorderRadius = 30;
		btnLogin.setBounds(237, 677, 60, 60);
		btnLogin.setText("▶");
		btnLogin.addActionListener(this);
		p.add(btnLogin);

		/*
		 * Usuario y contraseÃƒÂ±a
		 * 
		 */

		lblUser = new JLabel("User");
		lblUser.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 22));
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setBounds(104, 346, 312, 38);
		p.add(lblUser);

		txtUser = new JTextField();
		txtUser.setHorizontalAlignment(SwingConstants.CENTER);
		txtUser.setBorder(new LineBorder(Color.BLACK, 1, true));
		txtUser.setBackground(Color.WHITE);
		txtUser.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 17));
		txtUser.setBounds(134, 383, 252, 38);
		txtUser.setColumns(10);
		txtUser.addActionListener(this);
		p.add(txtUser);

		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 22));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(104, 454, 312, 38);
		p.add(lblPassword);

		txtPasswd = new JPasswordField();
		txtPasswd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					login();
				}
			}
		});
		txtPasswd.setHorizontalAlignment(SwingConstants.CENTER);
		txtPasswd.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		txtPasswd.setBackground(Color.WHITE);
		txtPasswd.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 17));
		txtPasswd.setBounds(134, 491, 252, 38);
		txtPasswd.addActionListener(this);
		p.add(txtPasswd);

		/*
		 * Label que permite el movimiento de la ventana
		 * 
		 */

		lblTabBar = new JLabel("");
		lblTabBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x_pressed = e.getX();
				y_pressed = e.getY();
			}
		});
		lblTabBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(e.getXOnScreen() - x_pressed, e.getYOnScreen() - y_pressed);
			}
		});
		lblTabBar.setBounds(0, 0, 1477, 37);
		p.add(lblTabBar);

		/*
		 * Fondo
		 * 
		 */

		lblVersion = new JLabel("V 1.8.0");
		lblVersion.setBackground(Color.DARK_GRAY);
		lblVersion.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 15));
		lblVersion.setBounds(401, 827, 83, 20);
		p.add(lblVersion);

		lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon(VLogin.class.getResource("/resources/rotGamesLogo200x104.png")));
		lblIcon.setBounds(159, 130, 200, 104);
		p.add(lblIcon);

		lblIconBackground = new JLabel("");
		lblIconBackground.setHorizontalTextPosition(SwingConstants.LEFT);
		lblIconBackground.setIcon(new ImageIcon(VLogin.class.getResource("/resources/loginBackgroung.jpg")));
		lblIconBackground.setBounds(520, 0, 1040, 880);
		p.add(lblIconBackground);

		lblLoginBackground = new JLabel("");
		lblLoginBackground.setOpaque(true);
		lblLoginBackground.setBackground(Color.WHITE);
		lblLoginBackground.setBounds(0, 0, 520, 880);
		p.add(lblLoginBackground);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnClose)) {
			this.dispose();
		} else if (e.getSource().equals(btnMinimize)) {
			this.setState(Frame.ICONIFIED);
		} else if (e.getSource().equals(btnLogin)) {
			login();
		}
	}

	private void login() {
		if (txtUser.getText().isEmpty() || txtPasswd.getPassword().length == 0) {
			JOptionPane.showMessageDialog(this, "Campo usuario o contraseÃ±a no rellenado", "Error",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			try {
				int agentCode = Integer.parseInt(txtUser.getText());

				String agentPasswd = new String(txtPasswd.getPassword());
				Agent loginAgent = agentData.login(agentCode, agentPasswd);

				if (loginAgent == null) {
					JOptionPane.showMessageDialog(this, "Credenciales incorrectas", "Error",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (loginAgent.isAgentIsAdmin() == true) {
					VPestaniasAgente vPestaniasAgente = new VPestaniasAgente(loginAgent, mapData, agentData,
							weaponData);
					vPestaniasAgente.setVisible(true);
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(this, "no eres admin friki", "uwu", JOptionPane.WARNING_MESSAGE);
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "Usuario tiene que ser un entero", "Error",
						JOptionPane.WARNING_MESSAGE);
			} catch (ExceptionManager e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
