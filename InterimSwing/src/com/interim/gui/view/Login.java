package com.interim.gui.view;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import java.awt.Insets;

import javax.swing.JTextField;

import java.awt.Dimension;

public class Login extends JPanel {
	private JTextField fieldUsername;
	private JPasswordField fieldPassword;
	private JButton btnLogin;
	private JLabel lblRegister;
	private JLabel lblPassOubli;
	

	public JLabel getLblRegister() {
		return lblRegister;
	}

	public JLabel getLblPassOubli() {
		return lblPassOubli;
	}

	public JTextField getFieldUsername() {
		return fieldUsername;
	}

	public JTextField getFieldPassword() {
		return fieldPassword;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	/**
	 * Create the panel.
	 */
	public Login() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);

		setOpaque(true);
        setBackground(Color.WHITE);  
		
		JPanel panelLoginField = new JPanel();
		panelLoginField.setPreferredSize(new Dimension(400, 300));
		panelLoginField.setBorder(
	            BorderFactory.createLineBorder(new Color(0)));
		GridBagConstraints gbc_panelLoginField = new GridBagConstraints();
		gbc_panelLoginField.insets = new Insets(0, 0, 5, 0);
		gbc_panelLoginField.gridheight = 5;
		gbc_panelLoginField.fill = GridBagConstraints.BOTH;
		gbc_panelLoginField.gridx = 1;
		gbc_panelLoginField.gridy = 0;
		add(panelLoginField, gbc_panelLoginField);
		GridBagLayout gbl_panelLoginField = new GridBagLayout();
		panelLoginField.setLayout(gbl_panelLoginField);
		
		JLabel lblUsername = new JLabel("Username");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 4;
		gbc_lblUsername.gridy = 4;
		panelLoginField.add(lblUsername, gbc_lblUsername);
		
		fieldUsername = new JTextField();
		GridBagConstraints gbc_fieldUsername = new GridBagConstraints();
		gbc_fieldUsername.gridwidth = 6;
		gbc_fieldUsername.insets = new Insets(0, 0, 5, 5);
		gbc_fieldUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldUsername.gridx = 6;
		gbc_fieldUsername.gridy = 4;
		panelLoginField.add(fieldUsername, gbc_fieldUsername);
		fieldUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 4;
		gbc_lblPassword.gridy = 5;
		panelLoginField.add(lblPassword, gbc_lblPassword);
		
		fieldPassword = new JPasswordField();
		GridBagConstraints gbc_fieldPassword = new GridBagConstraints();
		gbc_fieldPassword.gridwidth = 6;
		gbc_fieldPassword.insets = new Insets(0, 0, 5, 5);
		gbc_fieldPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldPassword.gridx = 6;
		gbc_fieldPassword.gridy = 5;
		panelLoginField.add(fieldPassword, gbc_fieldPassword);
		fieldPassword.setColumns(10);
		
		btnLogin = new JButton("Login");
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogin.gridx = 4;
		gbc_btnLogin.gridy = 6;
		panelLoginField.add(btnLogin, gbc_btnLogin);
		
		lblPassOubli = new JLabel("Pass oubli\u00E9");
		GridBagConstraints gbc_lblPassOubli = new GridBagConstraints();
		gbc_lblPassOubli.gridwidth = 3;
		gbc_lblPassOubli.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassOubli.gridx = 6;
		gbc_lblPassOubli.gridy = 6;
		panelLoginField.add(lblPassOubli, gbc_lblPassOubli);
		
		lblRegister = new JLabel("S'enregistrer");
		GridBagConstraints gbc_lblRegister = new GridBagConstraints();
		gbc_lblRegister.gridwidth = 3;
		gbc_lblRegister.insets = new Insets(0, 0, 0, 5);
		gbc_lblRegister.gridx = 10;
		gbc_lblRegister.gridy = 7;
		panelLoginField.add(lblRegister, gbc_lblRegister);

	}
	
	public static void main(String[] args) {
	/*	JFrame frame = new JFrame("Main Window");
        frame.getRootPane().setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20));
        Login app = new Login();
        frame.getContentPane().add(app);

        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100, 700);
        frame.setLocation(200, 200);
        frame.setVisible(true);
        */
	}

}
