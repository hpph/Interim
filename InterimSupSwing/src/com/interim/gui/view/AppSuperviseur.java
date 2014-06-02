package com.interim.gui.view;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTabbedPane;

import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;

import autocomplete.AutoSuggest;

import com.interim.model.Annonces;
import com.interim.model.Contacts;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

import javax.swing.JTable;

public class AppSuperviseur extends JPanel {
	private AutoBinding<Annonces, Date, JTextField, String> BindDate;
	private AutoBinding<Annonces, String, JTextArea, String> BindDescription;
	private AutoBinding<Annonces, String, JTextField, String> BindFonction;
	private AutoBinding<Annonces, String, JTextField, String> BindSecteur;
	private AutoBinding<Contacts, String, JTextField, String> BindTel;
	private AutoBinding<Contacts, String, JTextField, String> BindEmail;
	private AutoBinding<Contacts, String, JTextField, String> BindCommune;
	private AutoBinding<Contacts, String, JTextField, String> BindAdresse;
	private AutoBinding<Contacts, String, JTextField, String> BindContact;
	private AutoBinding<Contacts, String, JTextField, String> BindEntreprise;

	JPanel panelUsers;
	JPanel panelAnnonce;
	JPanel panelContact;
	private JLabel lblEntreprise;
	private JLabel lblContact;
	private JLabel lblAdresse;
	private JLabel lblCommune;
	private JLabel lblEmail;
	private JLabel lblTel;
	private JTextField fieldEntreprise;
	private JTextField fieldContact;
	private JTextField fieldAdresse;
	private JTextField fieldCommune;
	private JTextField fieldEmail;
	private JTextField fieldTel;
	private JLabel lblDate;
	private JLabel lblSecteur;
	private JLabel lblFonction;
	private JLabel lblDescription;
	private JTextField fieldDate;
	private JTextField fieldSecteur;
	private JTextField fieldFonction;
	private JScrollPane scrollPane;
	private JTextArea textAreaDescription;
	private JPanel panelTable;
	private JTabbedPane tabbedPane;
	private JLabel lblMetier;
	private AutoSuggest listdMetier;;
	private JLabel lblContactAnnonce;
	private AutoSuggest listContact;
	private JButton btnEnregistrerContact;
	private JButton btnEnregistrerAnnonce;
	private Contacts contact = new Contacts();
	private Annonces annonce = new Annonces();
	private JButton btnVoirPreuves;
	private JButton btnContacter;
	private JScrollPane scrollPaneTablePreuves;
	private JTable tablePreuves;
	
	
	public JTable getTablePreuves() {
		return tablePreuves;
	}

	public JButton getBtnVoirPreuves() {
		return btnVoirPreuves;
	}

	public JButton getBtnContacter() {
		return btnContacter;
	}

	public JPanel getPanelTable() {
		return panelTable;
	}

	public AutoSuggest getListdMetier() {
		return listdMetier;
	}

	public AutoSuggest getListContact() {
		return listContact;
	}

	public Contacts getContact() {
		return contact;
	}

	public Annonces getAnnonce() {
		return annonce;
	}

	public JButton getBtnEnregistrerContact() {
		return btnEnregistrerContact;
	}

	public JButton getBtnEnregistrerAnnonce() {
		return btnEnregistrerAnnonce;
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public JTextField getFieldEntreprise() {
		return fieldEntreprise;
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

	public JTextField getFieldEmail() {
		return fieldEmail;
	}

	public JTextField getFieldTel() {
		return fieldTel;
	}

	public JTextField getFieldDate() {
		return fieldDate;
	}

	public JTextField getFieldSecteur() {
		return fieldSecteur;
	}

	public JTextField getFieldFonction() {
		return fieldFonction;
	}

	public JTextArea getTextAreaDescription() {
		return textAreaDescription;
	}
	/**
	 * Create the panel.
	 */
	public AppSuperviseur(ArrayList<String> listM, ArrayList<String> listC) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.gridheight = 16;
		gbc_tabbedPane.gridwidth = 27;
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 3;
		gbc_tabbedPane.gridy = 2;
		add(tabbedPane, gbc_tabbedPane);
		
		panelUsers = new JPanel();
		panelUsers.setBackground(Color.WHITE); 
		tabbedPane.addTab("Utilisateurs", null, panelUsers, null);
		GridBagLayout gbl_panelUsers = new GridBagLayout();
		gbl_panelUsers.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelUsers.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelUsers.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelUsers.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panelUsers.setLayout(gbl_panelUsers);
		
		panelTable = new JPanel();
		GridBagConstraints gbc_panelTable = new GridBagConstraints();
		gbc_panelTable.gridwidth = 14;
		gbc_panelTable.gridheight = 17;
		gbc_panelTable.insets = new Insets(0, 0, 5, 5);
		gbc_panelTable.fill = GridBagConstraints.BOTH;
		gbc_panelTable.gridx = 2;
		gbc_panelTable.gridy = 2;
		panelUsers.add(panelTable, gbc_panelTable);
		
		btnContacter = new JButton("Contacter");
		GridBagConstraints gbc_btnContacter = new GridBagConstraints();
		gbc_btnContacter.insets = new Insets(0, 0, 5, 5);
		gbc_btnContacter.gridx = 18;
		gbc_btnContacter.gridy = 3;
		panelUsers.add(btnContacter, gbc_btnContacter);
		
		btnVoirPreuves = new JButton("Voir Preuves");
		GridBagConstraints gbc_btnVoirPreuves = new GridBagConstraints();
		gbc_btnVoirPreuves.insets = new Insets(0, 0, 5, 5);
		gbc_btnVoirPreuves.gridx = 18;
		gbc_btnVoirPreuves.gridy = 4;
		panelUsers.add(btnVoirPreuves, gbc_btnVoirPreuves);
		
		scrollPaneTablePreuves = new JScrollPane();
		GridBagConstraints gbc_scrollPaneTablePreuves = new GridBagConstraints();
		gbc_scrollPaneTablePreuves.gridwidth = 2;
		gbc_scrollPaneTablePreuves.gridheight = 8;
		gbc_scrollPaneTablePreuves.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneTablePreuves.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneTablePreuves.gridx = 17;
		gbc_scrollPaneTablePreuves.gridy = 6;
		panelUsers.add(scrollPaneTablePreuves, gbc_scrollPaneTablePreuves);
		
		tablePreuves = new JTable();
		scrollPaneTablePreuves.setViewportView(tablePreuves);
		
		
		panelContact = new JPanel();
		panelContact.setBackground(Color.WHITE); 
		tabbedPane.addTab("Contact", null, panelContact, null);
		GridBagLayout gbl_panelContact = new GridBagLayout();
		gbl_panelContact.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelContact.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelContact.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelContact.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panelContact.setLayout(gbl_panelContact);
		
		lblEntreprise = new JLabel("Entreprise");
		GridBagConstraints gbc_lblEntreprise = new GridBagConstraints();
		gbc_lblEntreprise.insets = new Insets(0, 0, 5, 5);
		gbc_lblEntreprise.gridx = 2;
		gbc_lblEntreprise.gridy = 2;
		panelContact.add(lblEntreprise, gbc_lblEntreprise);
		
		fieldEntreprise = new JTextField();
		GridBagConstraints gbc_fieldEntreprise = new GridBagConstraints();
		gbc_fieldEntreprise.gridwidth = 6;
		gbc_fieldEntreprise.insets = new Insets(0, 0, 5, 5);
		gbc_fieldEntreprise.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldEntreprise.gridx = 4;
		gbc_fieldEntreprise.gridy = 2;
		panelContact.add(fieldEntreprise, gbc_fieldEntreprise);
		fieldEntreprise.setColumns(10);
		
		lblContact = new JLabel("Contact");
		GridBagConstraints gbc_lblContact = new GridBagConstraints();
		gbc_lblContact.insets = new Insets(0, 0, 5, 5);
		gbc_lblContact.gridx = 2;
		gbc_lblContact.gridy = 4;
		panelContact.add(lblContact, gbc_lblContact);
		
		fieldContact = new JTextField();
		GridBagConstraints gbc_fieldContact = new GridBagConstraints();
		gbc_fieldContact.gridwidth = 6;
		gbc_fieldContact.insets = new Insets(0, 0, 5, 5);
		gbc_fieldContact.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldContact.gridx = 4;
		gbc_fieldContact.gridy = 4;
		panelContact.add(fieldContact, gbc_fieldContact);
		fieldContact.setColumns(10);
		
		lblAdresse = new JLabel("Adresse");
		GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
		gbc_lblAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresse.gridx = 2;
		gbc_lblAdresse.gridy = 6;
		panelContact.add(lblAdresse, gbc_lblAdresse);
		
		fieldAdresse = new JTextField();
		GridBagConstraints gbc_fieldAdresse = new GridBagConstraints();
		gbc_fieldAdresse.gridwidth = 6;
		gbc_fieldAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_fieldAdresse.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldAdresse.gridx = 4;
		gbc_fieldAdresse.gridy = 6;
		panelContact.add(fieldAdresse, gbc_fieldAdresse);
		fieldAdresse.setColumns(10);
		
		lblCommune = new JLabel("Commune");
		GridBagConstraints gbc_lblCommune = new GridBagConstraints();
		gbc_lblCommune.insets = new Insets(0, 0, 5, 5);
		gbc_lblCommune.gridx = 2;
		gbc_lblCommune.gridy = 8;
		panelContact.add(lblCommune, gbc_lblCommune);
		
		fieldCommune = new JTextField();
		GridBagConstraints gbc_fieldCommune = new GridBagConstraints();
		gbc_fieldCommune.gridwidth = 6;
		gbc_fieldCommune.insets = new Insets(0, 0, 5, 5);
		gbc_fieldCommune.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldCommune.gridx = 4;
		gbc_fieldCommune.gridy = 8;
		panelContact.add(fieldCommune, gbc_fieldCommune);
		fieldCommune.setColumns(10);
		
		lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 2;
		gbc_lblEmail.gridy = 10;
		panelContact.add(lblEmail, gbc_lblEmail);
		
		fieldEmail = new JTextField();
		GridBagConstraints gbc_fieldEmail = new GridBagConstraints();
		gbc_fieldEmail.gridwidth = 6;
		gbc_fieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_fieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldEmail.gridx = 4;
		gbc_fieldEmail.gridy = 10;
		panelContact.add(fieldEmail, gbc_fieldEmail);
		fieldEmail.setColumns(10);
		
		lblTel = new JLabel("Tel");
		GridBagConstraints gbc_lblTel = new GridBagConstraints();
		gbc_lblTel.insets = new Insets(0, 0, 5, 5);
		gbc_lblTel.gridx = 2;
		gbc_lblTel.gridy = 12;
		panelContact.add(lblTel, gbc_lblTel);
		
		fieldTel = new JTextField();
		GridBagConstraints gbc_fieldTel = new GridBagConstraints();
		gbc_fieldTel.gridwidth = 6;
		gbc_fieldTel.insets = new Insets(0, 0, 5, 5);
		gbc_fieldTel.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldTel.gridx = 4;
		gbc_fieldTel.gridy = 12;
		panelContact.add(fieldTel, gbc_fieldTel);
		fieldTel.setColumns(10);
		
		btnEnregistrerContact = new JButton("Enregistrer");
		GridBagConstraints gbc_btnEnregistrer = new GridBagConstraints();
		gbc_btnEnregistrer.insets = new Insets(0, 0, 5, 5);
		gbc_btnEnregistrer.gridx = 2;
		gbc_btnEnregistrer.gridy = 18;
		panelContact.add(btnEnregistrerContact, gbc_btnEnregistrer);
		
		panelAnnonce = new JPanel();
		panelAnnonce.setBackground(Color.WHITE); 
		tabbedPane.addTab("Annonce", null, panelAnnonce, null);
		GridBagLayout gbl_panelAnnonce = new GridBagLayout();
		gbl_panelAnnonce.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelAnnonce.rowHeights = new int[]{51, 28, 0, 0, 0, 0, 0, 0, 26, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelAnnonce.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelAnnonce.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panelAnnonce.setLayout(gbl_panelAnnonce);
		
		lblMetier = new JLabel("Metier");
		GridBagConstraints gbc_lblMetier = new GridBagConstraints();
		gbc_lblMetier.insets = new Insets(0, 0, 5, 5);
		gbc_lblMetier.gridx = 2;
		gbc_lblMetier.gridy = 0;
		panelAnnonce.add(lblMetier, gbc_lblMetier);
		
		listdMetier = new AutoSuggest(listM);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 6;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 0;
		panelAnnonce.add(listdMetier, gbc_comboBox);
		
		lblContactAnnonce = new JLabel("Contact");
		GridBagConstraints gbc_lblContact_1 = new GridBagConstraints();
		gbc_lblContact_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblContact_1.gridx = 11;
		gbc_lblContact_1.gridy = 0;
		panelAnnonce.add(lblContactAnnonce, gbc_lblContact_1);
		
		listContact = new AutoSuggest(listC);
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 6;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 13;
		gbc_comboBox_1.gridy = 0;
		panelAnnonce.add(listContact, gbc_comboBox_1);
		
		lblDate = new JLabel("Date");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 2;
		gbc_lblDate.gridy = 2;
		panelAnnonce.add(lblDate, gbc_lblDate);
		
		fieldDate = new JTextField();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dateNow = new Date();
		String sDate= sdf.format(dateNow);
		fieldDate.setText(sDate);
		GridBagConstraints gbc_fieldDate = new GridBagConstraints();
		gbc_fieldDate.gridwidth = 6;
		gbc_fieldDate.insets = new Insets(0, 0, 5, 5);
		gbc_fieldDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldDate.gridx = 4;
		gbc_fieldDate.gridy = 2;
		panelAnnonce.add(fieldDate, gbc_fieldDate);
		fieldDate.setColumns(10);
		
		lblSecteur = new JLabel("Secteur");
		GridBagConstraints gbc_lblSecteur = new GridBagConstraints();
		gbc_lblSecteur.insets = new Insets(0, 0, 5, 5);
		gbc_lblSecteur.gridx = 2;
		gbc_lblSecteur.gridy = 4;
		panelAnnonce.add(lblSecteur, gbc_lblSecteur);
		
		fieldSecteur = new JTextField();
		GridBagConstraints gbc_fieldSecteur = new GridBagConstraints();
		gbc_fieldSecteur.gridwidth = 6;
		gbc_fieldSecteur.insets = new Insets(0, 0, 5, 5);
		gbc_fieldSecteur.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldSecteur.gridx = 4;
		gbc_fieldSecteur.gridy = 4;
		panelAnnonce.add(fieldSecteur, gbc_fieldSecteur);
		fieldSecteur.setColumns(10);
		
		lblFonction = new JLabel("Fonction");
		GridBagConstraints gbc_lblFonction = new GridBagConstraints();
		gbc_lblFonction.insets = new Insets(0, 0, 5, 5);
		gbc_lblFonction.gridx = 2;
		gbc_lblFonction.gridy = 6;
		panelAnnonce.add(lblFonction, gbc_lblFonction);
		
		fieldFonction = new JTextField();
		GridBagConstraints gbc_fieldFonction = new GridBagConstraints();
		gbc_fieldFonction.gridwidth = 6;
		gbc_fieldFonction.insets = new Insets(0, 0, 5, 5);
		gbc_fieldFonction.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldFonction.gridx = 4;
		gbc_fieldFonction.gridy = 6;
		panelAnnonce.add(fieldFonction, gbc_fieldFonction);
		fieldFonction.setColumns(10);
		
		lblDescription = new JLabel("Description");
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 2;
		gbc_lblDescription.gridy = 8;
		panelAnnonce.add(lblDescription, gbc_lblDescription);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 10;
		gbc_scrollPane.gridwidth = 14;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 4;
		gbc_scrollPane.gridy = 8;
		panelAnnonce.add(scrollPane, gbc_scrollPane);
		
		textAreaDescription = new JTextArea();
		scrollPane.setViewportView(textAreaDescription);
		
		btnEnregistrerAnnonce = new JButton("Enregistrer");
		GridBagConstraints gbc_btnEnregistrer_1 = new GridBagConstraints();
		gbc_btnEnregistrer_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnEnregistrer_1.gridx = 2;
		gbc_btnEnregistrer_1.gridy = 19;
		panelAnnonce.add(btnEnregistrerAnnonce, gbc_btnEnregistrer_1);
		initDataBindings();
		


	}


	public static void main(String[] args) {
	/*	JFrame frame = new JFrame("Main Window");
        frame.getRootPane().setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20));
        AppSuperviseur app = new AppSuperviseur();
        frame.getContentPane().add(app);

        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100, 700);
        frame.setLocation(200, 200);
        frame.setVisible(true);
        */
	}
	protected void initDataBindings() {
		BeanProperty<Contacts, String> contactsBeanProperty = BeanProperty.create("entreprise");
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty.create("text");
		BindEntreprise = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, contact, contactsBeanProperty, fieldEntreprise, jTextFieldBeanProperty);
		BindEntreprise.bind();
		//
		BeanProperty<Contacts, String> contactsBeanProperty_1 = BeanProperty.create("contact");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty.create("text");
		BindContact = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, contact, contactsBeanProperty_1, fieldContact, jTextFieldBeanProperty_1);
		BindContact.bind();
		//
		BeanProperty<Contacts, String> contactsBeanProperty_2 = BeanProperty.create("adresse");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_2 = BeanProperty.create("text");
		BindAdresse = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, contact, contactsBeanProperty_2, fieldAdresse, jTextFieldBeanProperty_2);
		BindAdresse.bind();
		//
		BeanProperty<Contacts, String> contactsBeanProperty_3 = BeanProperty.create("email");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_3 = BeanProperty.create("text");
		BindEmail = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, contact, contactsBeanProperty_3, fieldEmail, jTextFieldBeanProperty_3);
		BindEmail.bind();
		//
		BeanProperty<Contacts, String> contactsBeanProperty_4 = BeanProperty.create("tel");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_4 = BeanProperty.create("text");
		BindTel = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, contact, contactsBeanProperty_4, fieldTel, jTextFieldBeanProperty_4);
		BindTel.bind();
		//
		BeanProperty<Annonces, String> annoncesBeanProperty = BeanProperty.create("secteur");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_5 = BeanProperty.create("text");
		BindSecteur = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, annonce, annoncesBeanProperty, fieldSecteur, jTextFieldBeanProperty_5);
		BindSecteur.bind();
		//
		BeanProperty<Annonces, String> annoncesBeanProperty_1 = BeanProperty.create("fonction");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_6 = BeanProperty.create("text");
		BindFonction = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, annonce, annoncesBeanProperty_1, fieldFonction, jTextFieldBeanProperty_6);
		BindFonction.bind();
		//
		BeanProperty<Annonces, String> annoncesBeanProperty_2 = BeanProperty.create("description");
		BeanProperty<JTextArea, String> jTextAreaBeanProperty = BeanProperty.create("text");
		BindDescription = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, annonce, annoncesBeanProperty_2, textAreaDescription, jTextAreaBeanProperty);
		BindDescription.bind();
		//
		BeanProperty<Annonces, Date> annoncesBeanProperty_3 = BeanProperty.create("date");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_7 = BeanProperty.create("text");
		BindDate = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, annonce, annoncesBeanProperty_3, fieldDate, jTextFieldBeanProperty_7);
		BindDate.bind();
	}
}
