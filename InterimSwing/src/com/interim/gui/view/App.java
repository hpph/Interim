package com.interim.gui.view;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTabbedPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Font;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.interim.model.Metiers;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;

import javax.swing.JList;

import com.toedter.calendar.JYearChooser;

import javax.swing.border.MatteBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class App extends JPanel {
	
	private JTextField fieldLieu;
	private JTextField fieldEntreprise;
	private JTextField fieldContact;
	private JTextField fieldAdresse;
	private JTextField fieldCommune;
	private JTextField date;
	private JTextField fieldUrl;
	private JTextField fieldEmail;
	private JTable tablePreuves;
	private JTabbedPane tabbedPane;
	private JComboBox<Metiers> listMetier;
	private JButton btnChoisissezUn;
	private JLabel lblAucunFichier;
	private JButton buttonLettre;
	private JButton btnEnregistrer;
	private JButton btnEnvoyer;
	private ButtonGroup btngrpTypeDeCandidature;
	private JButton btnActionLettre;
	private JLabel lblMessageLettre;
	private JButton btnActionAnnonce;
	private JLabel lblMessageAnnonce;
	private JComboBox<Metiers> ListSearchMetier;
	private JButton btnRechercher;
	private JPanel panelSearchAnnonce;
	private JButton btnVoir;
	private JYearChooser yearChooser;
	private JButton btnTelecharger;
	
	public JButton getBtnTelecharger() {
		return btnTelecharger;
	}
	public JButton getBtnVoir() {
		return btnVoir;
	}
	public JYearChooser getYearChooser() {
		return yearChooser;
	}
	public JButton getBtnRechercher() {
		return btnRechercher;
	}
	public JPanel getPanelSearchAnnonce() {
		return panelSearchAnnonce;
	}
	public JTable getTablePreuves() {
		return tablePreuves;
	}
	public JComboBox getListSearchMetier() {
		return ListSearchMetier;
	}
	public JButton getBtnActionLettre() {
		return btnActionLettre;
	}
	public JLabel getLblMessageLettre() {
		return lblMessageLettre;
	}
	public JButton getBtnActionAnnonce() {
		return btnActionAnnonce;
	}
	public JLabel getLblMessageAnnonce() {
		return lblMessageAnnonce;
	}

	public JTextField getFieldEmail() {
		return fieldEmail;
	}
	public JTextField getFieldUrl() {
		return fieldUrl;
	}
	public ButtonGroup getBtngrpTypeDeCandidature() {
		return btngrpTypeDeCandidature;
	}
	public JTextField getFieldLieu() {
		return fieldLieu;
	}
	public JTextField getFieldContact() {
		return fieldContact;
	}
	public JTextField getFieldAdresse() {
		return fieldAdresse;
	}
	public JTextField getFieldCommune() {
		return fieldCommune;
	}

	public JTextField getFieldEntreprise() {
		return fieldEntreprise;
	}
	public JButton getBtnEnvoyer() {
		return btnEnvoyer;
	}
	public JButton getBtnEnregistrer() {
		return btnEnregistrer;
	}
	public JButton getButtonLettre() {
		return buttonLettre;
	}
	public JButton getBtnChoisissezUn() {
		return btnChoisissezUn;
	}
	public JLabel getLblAucunFichier() {
		return lblAucunFichier;
	}
	public JComboBox<Metiers> getListMetier() {
		return listMetier;
	}
	public JTextField getDateChooser() {
		return date;
	}
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}
	/**
	 * Create the panel.
	 */
	public App() {

		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.SOUTH);
		
	 	JPanel panelLettre = new JPanel();
	 	panelLettre.setBackground(Color.WHITE);  
	 	
		panelLettre.setPreferredSize(new Dimension(900, 500));
		panelLettre.setMinimumSize(new Dimension(900, 500));
		tabbedPane.addTab("Lettre", null, panelLettre, null);
		GridBagLayout gbl_panelLettre = new GridBagLayout();
		

		gbl_panelLettre.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelLettre.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelLettre.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelLettre.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panelLettre.setLayout(gbl_panelLettre);
		
		btngrpTypeDeCandidature = new ButtonGroup();
		
		lblMessageLettre = new JLabel("Cliquez sur action pour t\u00E9l\u00E9charger le fichier ou le supprimer",SwingConstants.CENTER);
		lblMessageLettre.setPreferredSize(new Dimension(650, 25));
		lblMessageLettre.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblMessageLettre.setBackground(new Color(51, 204, 51));
		lblMessageLettre.setOpaque(true);
		GridBagConstraints gbc_lblMessage = new GridBagConstraints();
		gbc_lblMessage.gridwidth = 12;
		gbc_lblMessage.insets = new Insets(0, 0, 5, 5);
		gbc_lblMessage.gridx = 2;
		gbc_lblMessage.gridy = 0;
		lblMessageLettre.setVisible(false);
		panelLettre.add(lblMessageLettre, gbc_lblMessage);
		
		
		
		btnActionLettre = new JButton("Action");
		GridBagConstraints gbc_btnAction = new GridBagConstraints();
		gbc_btnAction.insets = new Insets(0, 0, 5, 5);
		gbc_btnAction.gridx = 14;
		gbc_btnAction.gridy = 0;
		btnActionLettre.setVisible(false);
		
		panelLettre.add(btnActionLettre, gbc_btnAction);

		
		JLabel label = new JLabel("Date de l'envoi");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 1;
		panelLettre.add(label, gbc_label);
		
		//date =  new JDateChooser();
		//dateChooser.setDateFormatString("dd/MM/yyyy");
		date =  new JTextField();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dateNow = new Date();
		String sDate= sdf.format(dateNow);
		date.setText(sDate);
		date.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		GridBagConstraints gbc_date = new GridBagConstraints();
		gbc_date.gridwidth = 5;
		gbc_date.insets = new Insets(0, 0, 5, 5);
		gbc_date.fill = GridBagConstraints.HORIZONTAL;
		gbc_date.gridx = 5;
		gbc_date.gridy = 1;
		panelLettre.add(date, gbc_date);
		date.setEditable(false);
		
		
		JLabel lblEntreprise = new JLabel("Entreprise");
		GridBagConstraints gbc_lblEntreprise = new GridBagConstraints();
		gbc_lblEntreprise.insets = new Insets(0, 0, 5, 5);
		gbc_lblEntreprise.gridx = 2;
		gbc_lblEntreprise.gridy = 3;
		panelLettre.add(lblEntreprise, gbc_lblEntreprise);
		
		fieldEntreprise = new JTextField();
		fieldEntreprise.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		GridBagConstraints gbc_fieldEntreprise = new GridBagConstraints();
		gbc_fieldEntreprise.gridwidth = 5;
		gbc_fieldEntreprise.insets = new Insets(0, 0, 5, 5);
		gbc_fieldEntreprise.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldEntreprise.gridx = 5;
		gbc_fieldEntreprise.gridy = 3;
		panelLettre.add(fieldEntreprise, gbc_fieldEntreprise);
		fieldEntreprise.setColumns(10);
		
		JLabel lblContact = new JLabel("Contact");
		GridBagConstraints gbc_lblContact = new GridBagConstraints();
		gbc_lblContact.insets = new Insets(0, 0, 5, 5);
		gbc_lblContact.gridx = 2;
		gbc_lblContact.gridy = 5;
		panelLettre.add(lblContact, gbc_lblContact);
		
		fieldContact = new JTextField();
		fieldContact.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		GridBagConstraints gbc_fieldContact = new GridBagConstraints();
		gbc_fieldContact.gridwidth = 5;
		gbc_fieldContact.insets = new Insets(0, 0, 5, 5);
		gbc_fieldContact.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldContact.gridx = 5;
		gbc_fieldContact.gridy = 5;
		panelLettre.add(fieldContact, gbc_fieldContact);
		fieldContact.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse");
		GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
		gbc_lblAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresse.gridx = 2;
		gbc_lblAdresse.gridy = 7;
		panelLettre.add(lblAdresse, gbc_lblAdresse);
		
		fieldAdresse = new JTextField();
		fieldAdresse.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		GridBagConstraints gbc_fieldAdresse = new GridBagConstraints();
		gbc_fieldAdresse.gridwidth = 5;
		gbc_fieldAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_fieldAdresse.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldAdresse.gridx = 5;
		gbc_fieldAdresse.gridy = 7;
		panelLettre.add(fieldAdresse, gbc_fieldAdresse);
		fieldAdresse.setColumns(10);
		
		JLabel lblCommune = new JLabel("Commune");
		GridBagConstraints gbc_lblCommune = new GridBagConstraints();
		gbc_lblCommune.insets = new Insets(0, 0, 5, 5);
		gbc_lblCommune.gridx = 2;
		gbc_lblCommune.gridy = 9;
		panelLettre.add(lblCommune, gbc_lblCommune);
		
		fieldCommune = new JTextField();
		fieldCommune.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		GridBagConstraints gbc_fieldCommune = new GridBagConstraints();
		gbc_fieldCommune.gridwidth = 5;
		gbc_fieldCommune.insets = new Insets(0, 0, 5, 5);
		gbc_fieldCommune.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldCommune.gridx = 5;
		gbc_fieldCommune.gridy = 9;
		panelLettre.add(fieldCommune, gbc_fieldCommune);
		fieldCommune.setColumns(10);
		
		JLabel lblMtier = new JLabel("M\u00E9tier");
		GridBagConstraints gbc_lblMtier = new GridBagConstraints();
		gbc_lblMtier.insets = new Insets(0, 0, 5, 5);
		gbc_lblMtier.gridx = 2;
		gbc_lblMtier.gridy = 11;
		panelLettre.add(lblMtier, gbc_lblMtier);
		
		listMetier = new JComboBox<Metiers>();
		listMetier.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		GridBagConstraints gbc_listMetier = new GridBagConstraints();
		gbc_listMetier.gridwidth = 5;
		gbc_listMetier.gridheight = 2;
		gbc_listMetier.insets = new Insets(0, 0, 5, 5);
		gbc_listMetier.fill = GridBagConstraints.BOTH;
		gbc_listMetier.gridx = 5;
		gbc_listMetier.gridy = 11;
		panelLettre.add(listMetier, gbc_listMetier);
		
		JLabel lblTypeDeCandidature = new JLabel("Type de candidature");
		GridBagConstraints gbc_lblTypeDeCandidature = new GridBagConstraints();
		gbc_lblTypeDeCandidature.insets = new Insets(0, 0, 5, 5);
		gbc_lblTypeDeCandidature.gridx = 2;
		gbc_lblTypeDeCandidature.gridy = 14;
		panelLettre.add(lblTypeDeCandidature, gbc_lblTypeDeCandidature);
		
		JRadioButton rdbtnOffre = new JRadioButton("Offre");
		rdbtnOffre.setActionCommand("Offre");
		
		btngrpTypeDeCandidature.add(rdbtnOffre);
		rdbtnOffre.setSelected(true);
		
		GridBagConstraints gbc_rdbtnOffre = new GridBagConstraints();
		gbc_rdbtnOffre.gridwidth = 3;
		gbc_rdbtnOffre.anchor = GridBagConstraints.WEST;
		gbc_rdbtnOffre.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnOffre.gridx = 5;
		gbc_rdbtnOffre.gridy = 14;
		panelLettre.add(rdbtnOffre, gbc_rdbtnOffre);
		
		fieldLieu = new JTextField();
		fieldLieu.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		GridBagConstraints gbc_fieldLieu = new GridBagConstraints();
		gbc_fieldLieu.gridwidth = 2;
		gbc_fieldLieu.insets = new Insets(0, 0, 5, 5);
		gbc_fieldLieu.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldLieu.gridx = 9;
		gbc_fieldLieu.gridy = 14;
		panelLettre.add(fieldLieu, gbc_fieldLieu);
		fieldLieu.setColumns(10);
		fieldLieu.setText("Forem");
		
		JLabel lblLieuOuSite = new JLabel("Lieu ou Site internet");
		GridBagConstraints gbc_lblLieuOuSite = new GridBagConstraints();
		gbc_lblLieuOuSite.insets = new Insets(0, 0, 5, 5);
		gbc_lblLieuOuSite.gridwidth = 2;
		gbc_lblLieuOuSite.gridx = 12;
		gbc_lblLieuOuSite.gridy = 14;
		panelLettre.add(lblLieuOuSite, gbc_lblLieuOuSite);
		JRadioButton rdbtnSpontane = new JRadioButton("Spontan\u00E9e");
		rdbtnSpontane.setActionCommand("Spontanee");
		btngrpTypeDeCandidature.add(rdbtnSpontane);
		
		
		
		GridBagConstraints gbc_rdbtnSpontane = new GridBagConstraints();
		gbc_rdbtnSpontane.gridwidth = 3;
		gbc_rdbtnSpontane.anchor = GridBagConstraints.WEST;
		gbc_rdbtnSpontane.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnSpontane.gridx = 5;
		gbc_rdbtnSpontane.gridy = 15;
		panelLettre.add(rdbtnSpontane, gbc_rdbtnSpontane);
		
		buttonLettre = new JButton("Cr\u00E9er");
		GridBagConstraints gbc_btnLettre = new GridBagConstraints();
		gbc_btnLettre.insets = new Insets(0, 0, 5, 5);
		gbc_btnLettre.gridx = 2;
		gbc_btnLettre.gridy = 16;
		panelLettre.add(buttonLettre, gbc_btnLettre);
		
		JPanel panelAnnonce = new JPanel();
		panelAnnonce.setBackground(Color.WHITE);  
		
		tabbedPane.addTab("Annonce", null, panelAnnonce, null);
		GridBagLayout gbl_panelAnnonce = new GridBagLayout();
		gbl_panelAnnonce.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelAnnonce.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelAnnonce.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelAnnonce.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panelAnnonce.setLayout(gbl_panelAnnonce);
		

		lblMessageAnnonce = new JLabel("Cliquez sur action pour t\u00E9l\u00E9charger le fichier ou le supprimer",SwingConstants.CENTER);
		lblMessageAnnonce.setPreferredSize(new Dimension(650, 25));
		lblMessageAnnonce.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblMessageAnnonce.setBackground(new Color(51, 204, 51));
		lblMessageAnnonce.setOpaque(true);
		GridBagConstraints gbc_lblMessage1 = new GridBagConstraints();
		gbc_lblMessage1.gridwidth = 12;
		gbc_lblMessage1.insets = new Insets(0, 0, 5, 5);
		gbc_lblMessage1.gridx = 2;
		gbc_lblMessage1.gridy = 0;
		lblMessageAnnonce.setVisible(false);
	
		
		btnActionAnnonce = new JButton("Action");
		GridBagConstraints gbc_btnAction1 = new GridBagConstraints();
		gbc_btnAction1.insets = new Insets(0, 0, 5, 5);
		gbc_btnAction1.gridx = 14;
		gbc_btnAction1.gridy = 0;
		btnActionAnnonce.setVisible(false);
		
		panelAnnonce.add(lblMessageAnnonce, gbc_lblMessage1);
		panelAnnonce.add(btnActionAnnonce, gbc_btnAction1);
		
		JLabel lblUrl = new JLabel("Url");
		GridBagConstraints gbc_lblUrl = new GridBagConstraints();
		gbc_lblUrl.gridwidth = 2;
		gbc_lblUrl.insets = new Insets(0, 0, 5, 5);
		gbc_lblUrl.gridx = 4;
		gbc_lblUrl.gridy = 2;
		panelAnnonce.add(lblUrl, gbc_lblUrl);
		
		fieldUrl = new JTextField();
		fieldUrl.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		GridBagConstraints gbc_fieldUrl = new GridBagConstraints();
		gbc_fieldUrl.gridwidth = 10;
		gbc_fieldUrl.insets = new Insets(0, 0, 5, 5);
		gbc_fieldUrl.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldUrl.gridx = 7;
		gbc_fieldUrl.gridy = 2;
		panelAnnonce.add(fieldUrl, gbc_fieldUrl);
		fieldUrl.setColumns(10);
		
		btnEnregistrer = new JButton("Enregistrer");
		GridBagConstraints gbc_btnEnregistrer = new GridBagConstraints();
		gbc_btnEnregistrer.insets = new Insets(0, 0, 5, 5);
		gbc_btnEnregistrer.gridx = 7;
		gbc_btnEnregistrer.gridy = 4;
		panelAnnonce.add(btnEnregistrer, gbc_btnEnregistrer);
		
		JPanel panelEmail = new JPanel();
		panelEmail.setBackground(Color.WHITE);  
		
		tabbedPane.addTab("Email", null, panelEmail, null);
		GridBagLayout gbl_panelEmail = new GridBagLayout();
		gbl_panelEmail.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelEmail.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelEmail.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelEmail.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panelEmail.setLayout(gbl_panelEmail);
		
		
		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.gridwidth = 2;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 4;
		gbc_lblEmail.gridy = 2;
		panelEmail.add(lblEmail, gbc_lblEmail);
		
		fieldEmail = new JTextField();
		fieldEmail.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		GridBagConstraints gbc_fieldEmail = new GridBagConstraints();
		gbc_fieldEmail.gridwidth = 5;
		gbc_fieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_fieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldEmail.gridx = 8;
		gbc_fieldEmail.gridy = 2;
		panelEmail.add(fieldEmail, gbc_fieldEmail);
		fieldEmail.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cv");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 4;
		gbc_lblNewLabel.gridy = 4;
		panelEmail.add(lblNewLabel, gbc_lblNewLabel);
		
		btnChoisissezUn = new JButton("Choisissez un fichier");
		GridBagConstraints gbc_btnChoisissezUn = new GridBagConstraints();
		gbc_btnChoisissezUn.insets = new Insets(0, 0, 5, 5);
		gbc_btnChoisissezUn.gridx = 8;
		gbc_btnChoisissezUn.gridy = 4;
		panelEmail.add(btnChoisissezUn, gbc_btnChoisissezUn);
		
		lblAucunFichier = new JLabel("Aucun fichier");
		GridBagConstraints gbc_lblAucunFichier = new GridBagConstraints();
		gbc_lblAucunFichier.insets = new Insets(0, 0, 5, 5);
		gbc_lblAucunFichier.gridx = 10;
		gbc_lblAucunFichier.gridy = 4;
		panelEmail.add(lblAucunFichier, gbc_lblAucunFichier);
		
		btnEnvoyer = new JButton("Envoyer");
		GridBagConstraints gbc_btnEnvoyer = new GridBagConstraints();
		gbc_btnEnvoyer.insets = new Insets(0, 0, 5, 5);
		gbc_btnEnvoyer.gridx = 8;
		gbc_btnEnvoyer.gridy = 6;
		panelEmail.add(btnEnvoyer, gbc_btnEnvoyer);
	 
	 	JPanel panelRecherche = new JPanel();
	 	panelRecherche.setBackground(Color.WHITE);
		
		
		tabbedPane.addTab("Recherche", null, panelRecherche, null);
		GridBagLayout gbl_panelRecherche = new GridBagLayout();
		gbl_panelRecherche.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelRecherche.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelRecherche.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelRecherche.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panelRecherche.setLayout(gbl_panelRecherche);
		
		ListSearchMetier = new JComboBox<Metiers>();
		GridBagConstraints gbc_ListSearchMetier = new GridBagConstraints();
		gbc_ListSearchMetier.gridwidth = 6;
		gbc_ListSearchMetier.insets = new Insets(0, 0, 5, 5);
		gbc_ListSearchMetier.fill = GridBagConstraints.HORIZONTAL;
		gbc_ListSearchMetier.gridx = 5;
		gbc_ListSearchMetier.gridy = 0;
		panelRecherche.add(ListSearchMetier, gbc_ListSearchMetier);
		
		btnRechercher = new JButton("rechercher");
		GridBagConstraints gbc_btnRechercher = new GridBagConstraints();
		gbc_btnRechercher.insets = new Insets(0, 0, 5, 5);
		gbc_btnRechercher.gridx = 12;
		gbc_btnRechercher.gridy = 0;
		panelRecherche.add(btnRechercher, gbc_btnRechercher);
		
		panelSearchAnnonce = new JPanel();
		GridBagConstraints gbc_panelSearchAnnonce = new GridBagConstraints();
		gbc_panelSearchAnnonce.gridheight = 13;
		gbc_panelSearchAnnonce.gridwidth = 17;
		gbc_panelSearchAnnonce.insets = new Insets(0, 0, 5, 5);
		gbc_panelSearchAnnonce.fill = GridBagConstraints.BOTH;
		gbc_panelSearchAnnonce.gridx = 1;
		gbc_panelSearchAnnonce.gridy = 1;
		panelRecherche.add(panelSearchAnnonce, gbc_panelSearchAnnonce);
		
		JPanel panelPreuves = new JPanel();
		panelPreuves.setBackground(Color.WHITE);
	 	
	 	
		tabbedPane.addTab("Preuves de Candidature", null, panelPreuves, null);
		GridBagLayout gbl_panelPreuves = new GridBagLayout();

		gbl_panelPreuves.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelPreuves.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelPreuves.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelPreuves.rowWeights = new double[]{1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panelPreuves.setLayout(gbl_panelPreuves);
		
		JLabel lblAnnee = new JLabel("Ann\u00E9e");
		GridBagConstraints gbc_lblAnnee = new GridBagConstraints();
		gbc_lblAnnee.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnnee.gridx = 5;
		gbc_lblAnnee.gridy = 2;
		panelPreuves.add(lblAnnee, gbc_lblAnnee);
		
		yearChooser = new JYearChooser();
		GridBagConstraints gbc_yearChooser = new GridBagConstraints();
		gbc_yearChooser.insets = new Insets(0, 0, 5, 5);
		gbc_yearChooser.fill = GridBagConstraints.BOTH;
		gbc_yearChooser.gridx = 7;
		gbc_yearChooser.gridy = 2;
		panelPreuves.add(yearChooser, gbc_yearChooser);
		
		btnVoir = new JButton("Voir");
		GridBagConstraints gbc_btnVoir = new GridBagConstraints();
		gbc_btnVoir.insets = new Insets(0, 0, 5, 5);
		gbc_btnVoir.gridx = 9;
		gbc_btnVoir.gridy = 2;
		panelPreuves.add(btnVoir, gbc_btnVoir);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 6;
		gbc_scrollPane.gridheight = 7;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 5;
		gbc_scrollPane.gridy = 4;
		panelPreuves.add(scrollPane, gbc_scrollPane);
		
		tablePreuves = new JTable();
		scrollPane.setViewportView(tablePreuves);
		
		btnTelecharger = new JButton("Telecharger");
		GridBagConstraints gbc_btnTelecharger = new GridBagConstraints();
		gbc_btnTelecharger.insets = new Insets(0, 0, 5, 5);
		gbc_btnTelecharger.gridx = 13;
		gbc_btnTelecharger.gridy = 4;
		panelPreuves.add(btnTelecharger, gbc_btnTelecharger);
		
    	tabbedPane.setEnabledAt(1, false);
    	tabbedPane.setEnabledAt(2, false);
    	
	}

	public static void main(String[] args) {
	/*	JFrame frame = new JFrame("Main Window");
        frame.getRootPane().setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20));
        App app = new App();
        frame.getContentPane().add(app);

        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100, 700);
        frame.setLocation(200, 200);
        frame.setVisible(true);
        */
	}

	/*
	 

		
		PanelLettre panelLettre = new PanelLettre();
		tabbedPane.addTab("Lettre", null, panelLettre.getPanelLettre(), null);
		
		
		PanelAnnonce panelAnnonce = new PanelAnnonce();
		tabbedPane.addTab("Annonce", null, panelAnnonce.getPanelAnnonce(), null);
		
		
		PanelEmail panelEmail = new PanelEmail();
		tabbedPane.addTab("Email", null, panelEmail.getPanelEmail(), null);
		
		
		PanelRecherche panelRecherche = new PanelRecherche();
		tabbedPane.addTab("Recherche", null, panelRecherche.getPanelRecherche(), null);
		
		PanelPreuves panelPreuves = new PanelPreuves();
		tabbedPane.addTab("Preuves de Candidature", null, panelPreuves.getPanelPreuves(), null);
	 
	 * */
	
}
