package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.AgentManager;
import exceptions.ExceptionManager;
import model.Agent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class VRemoveAgent extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private AgentManager agentData;
	private JButton btnRemove;
	private JComboBox<String> comboBox;

	/**
	 * Create the dialog.
	 * 
	 * @param vPestaniasAgente
	 * @param b
	 * @param agentData
	 */
	public VRemoveAgent(VPestaniasAgente vPestaniasAgente, boolean b, AgentManager agent) {
		super(vPestaniasAgente);
		setModal(b);
		agentData = agent;
		setBounds(730, 400, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		comboBox = new JComboBox<String>();
		try {
			List<Agent> agentsOrder = agentData.getAllAgents();
			Collections.sort(agentsOrder);

			for (Agent newAgent : agentsOrder) {
				comboBox.addItem(newAgent.getAgentName() + " // " + newAgent.getAgentCode());
			}
		} catch (ExceptionManager e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		comboBox.setBounds(66, 123, 287, 30);
		contentPanel.add(comboBox);

		JLabel lblAgentTitle = new JLabel("Selecciona el agente a borrar");
		lblAgentTitle.setFont(new Font("DINNextLTPro-Regular", Font.BOLD, 14));
		lblAgentTitle.setBounds(66, 61, 287, 44);
		contentPanel.add(lblAgentTitle);

		btnRemove = new JButton("Borrar");
		btnRemove.setFont(new Font("DINNextLTPro-Regular", Font.PLAIN, 12));
		btnRemove.setBorder(null);
		btnRemove.setBounds(250, 185, 103, 30);
		btnRemove.addActionListener(this);
		contentPanel.add(btnRemove);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnRemove)) {
			if (JOptionPane.showConfirmDialog(this, "¿Esta seguro de borrar a este agente?", "Borrar", 0) == 0) {
				JOptionPane.showMessageDialog(this, "Agente borrado correctamente", "Borrado",
						JOptionPane.INFORMATION_MESSAGE);
			} else
				JOptionPane.showMessageDialog(this, "Borrado de agente cancelado", "Borrado",
						JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		}

	}
}
