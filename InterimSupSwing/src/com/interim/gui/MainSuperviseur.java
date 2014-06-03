package com.interim.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.TextAttribute;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;

import com.interim.dao.AnnoncesDao;
import com.interim.dao.ContactsDao;
import com.interim.dao.MetiersDao;
import com.interim.dao.RdvsDao;
import com.interim.dao.UsersDao;
import com.interim.gui.view.AppSuperviseur;
import com.interim.gui.view.ContactSuperviseur;
import com.interim.gui.view.LoginSuperviseur;
import com.interim.gui.view.ProfilSuperviseur;
import com.interim.gui.view.TableAnnonce;
import com.interim.gui.view.TableUsers;
import com.interim.model.Annonces;
import com.interim.model.Contacts;
import com.interim.model.Metiers;
import com.interim.model.UserACommeMetier;
import com.interim.model.Users;
import com.interim.util.EmailValidator;
import com.interim.util.SendMailTLS;

public class MainSuperviseur extends JFrame {

			public static Users user = new Users();
	  		LoginSuperviseur login;
			AppSuperviseur app;
			ProfilSuperviseur profil;
			ContactSuperviseur contact = new ContactSuperviseur();
			ArrayList<String> listM;
			ArrayList<String> listC;
			ArrayList<String> listMois = new ArrayList<String>();
			TableUsers tableUsers;

	private MainSuperviseur() {
		
		listMois.add("Janvier");
		listMois.add("Février");
		listMois.add("Mars");
		listMois.add("Avril");
		listMois.add("Mai");
		listMois.add("Juin");
		listMois.add("Juillet");
		listMois.add("Aout");
		listMois.add("Septembre");
		listMois.add("Octobre");
		listMois.add("Novembre");
		listMois.add("Décembre");
		
		listM = new MetiersDao().getAllStringMetiers();
		listC = new ContactsDao().getAllStringContacts();
		
		login = new LoginSuperviseur();
		app = new AppSuperviseur(listM, listC);
		
		
/**************************************** create menu ******************************************/
		JMenu menuInterim;
		final JMenu menuName;
		
		setName("Main Window");
        getRootPane().setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 700);
        setLocation(200, 100);
        setVisible(true);
        
		BorderLayout Layout = new BorderLayout();
		setLayout(Layout);
		
		//JLabel lblInterim = new JLabel("INTERIM");
		//lblInterim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		//add(lblInterim, BorderLayout.NORTH);
		
		final JMenuBar menuBar = new JMenuBar();
		menuInterim = new JMenu("INTERIM");
		menuInterim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		menuName = new JMenu();
		menuName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JMenuItem menuItemProfil = new JMenuItem("Profil"){
			@Override
		    public Dimension getPreferredSize() {
		        Dimension d = super.getPreferredSize();
		        d.width = Math.max(d.width, 135); // set minimums
		        d.height = Math.max(d.height, 25);
		        return d;
		    }
		};
		menuItemProfil.setHorizontalAlignment(SwingConstants.CENTER);
		menuItemProfil.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
      
		
		JMenuItem menuItemLogout = new JMenuItem("Logout"){
			@Override
		    public Dimension getPreferredSize() {
		        Dimension d = super.getPreferredSize();
		        d.width = Math.max(d.width, 135); // set minimums
		        d.height = Math.max(d.height, 25);
		        return d;
		    }
		};
		menuItemLogout.setHorizontalAlignment(SwingConstants.CENTER);
		menuItemLogout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		menuName.add(menuItemProfil);
		menuName.add(new JSeparator());
		menuName.add(menuItemLogout);
		
		
		menuBar.add(menuInterim);
		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(menuName);
		
		/**************************************** fin create menu ******************************************/

		final JFrame frame = new JFrame("Main Window");
        frame.getRootPane().setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20));

        frame.getContentPane().add(contact);

        
        WindowAdapter exitListener = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
            	contact.getFieldSujet().setText("");
				contact.getHtmlEditor().setHTMLContent("");
	            frame.setVisible(false);
            }
        };
        frame.addWindowListener(exitListener);
        
        frame.setSize(1000, 600);
        frame.setLocation(200, 200);
		
        getContentPane().add(login);
        
        login.getBtnLogin().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				final UsersDao usersDao = new UsersDao();
				List <Users> users = usersDao.getUserbyLoginSuperviseur(login.getFieldUsername().getText(), login.getFieldPassword().getText());
				if(!users.isEmpty()){
				user = users.get(0);


				menuName.setText(user.getNom() + " " + user.getPrenom());
				profil = new ProfilSuperviseur();
				
				profil.getBtnEnregistrer().addActionListener(new ActionListener() {
	    			@Override
	    			public void actionPerformed(ActionEvent arg0) {
	    				if(profil.getFieldPasswordconfirm().getText().equals("")){
	    					JOptionPane.showMessageDialog(null, "Choisissez un mot de passe");
	    				}else if(profil.getFieldPasswordconfirm().getText().equals("") && profil.getFieldPassword().getText().equals("")){
	    					JOptionPane.showMessageDialog(null, "Choisissez un mot de passe et confirmez le");
	    				}else if(profil.getFieldPassword().getText().equals("")){
	    					JOptionPane.showMessageDialog(null, "Confirmez un mot de passe");
	    				}else if(profil.getFieldPassword().getText().length() < 6){
	    					JOptionPane.showMessageDialog(null, "Le mot de passe doit comporter au moins 6 caractere");
	    				}else if(!profil.getFieldPassword().getText().equals(profil.getFieldPasswordconfirm().getText())){
	    					JOptionPane.showMessageDialog(null, "Le mot de passe et sa confirmation ne correspondent pas");
	    				}else usersDao.saveUser(user);
	    			}
	           });
				
				tableUsers = new TableUsers(usersDao.getAllUsers());
				
				app.getPanelTable().add(tableUsers);
				

				tableUsers.getTable().getColumnModel().getColumn(7).setMinWidth(0);
				tableUsers.getTable().getColumnModel().getColumn(7).setMaxWidth(0);
				tableUsers.getTable().getColumnModel().getColumn(7).setPreferredWidth(0);
				
				app.getBtnVoirPreuves().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						RdvsDao rdv = new RdvsDao();
						DefaultTableModel model = new DefaultTableModel();
						model.setColumnIdentifiers(new Object[] {"Preuves"});
						List<Map<String, String>> array = rdv.getRdvsbyMonth(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)), (int) tableUsers.getTable().getModel().getValueAt(tableUsers.getTable().getSelectedRow(), 7));
						;
						for(Map map : array){
							model.addRow(new Object[] {"<html><body><b color='red'>" + map.get("nombre") + " en " + listMois.get((int) map.get("moisNumeros")) + "</b></html></body>"});
						}
						app.getTablePreuves().setModel(model);
						app.getTablePreuves().validate();
					}
					
				});
				
				app.getBtnContacter().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						contact.getBtnEnvoyer().addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
								List<File> filesFull = new ArrayList<File>();
								String formatMail = "text/html";
								String email = (String) tableUsers.getTable().getModel().getValueAt(tableUsers.getTable().getSelectedRow(), 5);
								String nom = (String) tableUsers.getTable().getModel().getValueAt(tableUsers.getTable().getSelectedRow(), 0);
								String prenom = (String) tableUsers.getTable().getModel().getValueAt(tableUsers.getTable().getSelectedRow(), 1);
								if(EmailValidator.validate(email)){	
									try {
										new SendMailTLS(user.getLogins().getEmail(),nom + " " + prenom,
												email, contact.getFieldSujet().getText(), 
												contact.getHtmlEditor().getHTMLContent(), formatMail, filesFull);
										JOptionPane.showMessageDialog(null, "L'email a été envoyé");
									} catch (Exception e) {
										//e.printStackTrace();
										JOptionPane.showMessageDialog(null, "Connectez vous a internet");
									}
								}else{
									JOptionPane.showMessageDialog(null, "L'adresse email n'est pas valide");
								}
							}
						});
						
						
			            frame.setVisible(true);
					}
					
				});
	        

				if(user.isLogin()){
					getContentPane().remove(login);
					getContentPane().add(menuBar, BorderLayout.NORTH);
					getContentPane().add(app);
					getContentPane().validate();
					getContentPane().repaint();
				}
				}
				
			}
		});      
        
        
        login.getLblPassOubli().addMouseListener(new MouseAdapter() {
        	Font original;
			@Override
			public void mouseEntered(MouseEvent e) {
				e.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				original = e.getComponent().getFont();
		        Map attributes = original.getAttributes();
		        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		        e.getComponent().setFont(original.deriveFont(attributes));
		        e.getComponent().setForeground(Color.BLUE);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				e.getComponent().setFont(original);
				e.getComponent().setForeground(Color.BLACK);
				e.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				JOptionPane.showMessageDialog(null, "message envoyé");
			}
		});

        
       menuName.getItem(2).addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent e) {
    		   getContentPane().remove(menuBar);
    		   app.getTablePreuves().getModel();
    		   getContentPane().remove(app);
    		   getContentPane().remove(profil);
    		   app.getPanelTable().remove(tableUsers);
    		   //getContentPane().remove(contact);
    		   user = new Users();
    		   login.getFieldUsername().setText("");
    		   login.getFieldPassword().setText("");
			   getContentPane().add(login);
			   getContentPane().validate();
			   getContentPane().repaint();

    		  }
    	});
       
       
       menuName.getItem(0).addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent e) {
    		    getContentPane().remove(app);
    		 //  getContentPane().remove(contact);
				getContentPane().add(profil);
				getContentPane().validate();
				getContentPane().repaint();

    		  }
    	});
       
       menuInterim.addMenuListener(new MenuListener() {	
		@Override
		public void menuSelected(MenuEvent e) {
				 getContentPane().remove(profil);
				 //getContentPane().remove(contact);
				 getContentPane().add(app);
				 getContentPane().validate();
				 getContentPane().repaint();	
		}
		public void menuDeselected(MenuEvent e) {}
		public void menuCanceled(MenuEvent e) {}
	});
       
       app.getListContact().addActionListener(new ActionListener() {
      		@Override
       		public void actionPerformed(ActionEvent arg0) {
    				ContactsDao contactsDao = new ContactsDao();
          			HashMap<String, String> cm = new HashMap<String, String>();
          			cm.put("entreprise", app.getListContact().getTf().getText());
    				List <Contacts> contactsList = contactsDao.getContactbyCriteria(cm);
    				
    				if(!contactsList.isEmpty()){
    					app.getFieldEntreprise().setText(contactsList.get(0).getEntreprise());
    					app.getFieldContact().setText(contactsList.get(0).getContact());
    					app.getFieldAdresse().setText(contactsList.get(0).getAdresse());
    					app.getFieldCommune().setText(contactsList.get(0).getCommune());
    					app.getFieldEmail().setText(contactsList.get(0).getEmail());
    					app.getFieldTel().setText(contactsList.get(0).getTel());
    					
    				}    				
       				
       			}
       		});
       
       app.getBtnEnregistrerContact().addActionListener(new ActionListener() {
   		@Override
   		public void actionPerformed(ActionEvent arg0) {
				ContactsDao contactsDao = new ContactsDao();
				
				Contacts contact = app.getContact();
  				
      			HashMap<String, String> cm = new HashMap<String, String>();
      			cm.put("entreprise", app.getListContact().getTf().getText());
				List <Contacts> contactsList = contactsDao.getContactbyCriteria(cm);
				
				if(!contactsList.isEmpty())
					contact.setIdContact(contactsList.get(0).getIdContact());
				
   				contactsDao.saveContact(contact);
				JOptionPane.showMessageDialog(null, "Le contact a bien été enregisté");
				app.getListContact().addItem(contact);
				app.getListContact().revalidate();
				app.getListContact().repaint();
				
				app.setContact(new Contacts());
				app.getFieldAdresse().setText("");
				app.getFieldCommune().setText("");
				app.getFieldContact().setText("");
				app.getFieldEmail().setText("");
				app.getFieldEntreprise().setText("");
				app.getFieldTel().setText("");
   			}
   		});
       
       app.getBtnEnregistrerAnnonce().addActionListener(new ActionListener() {
      		@Override
      		public void actionPerformed(ActionEvent arg0) {
      				ContactsDao contactsDao = new ContactsDao();
      				MetiersDao metiersDao = new MetiersDao();

      				Contacts contact = new Contacts();
      				Metiers metier = new Metiers();
      				
	      			HashMap<String, String> cm = new HashMap<String, String>();
	      			cm.put("entreprise", app.getListContact().getTf().getText());
					List <Contacts> contactsList = contactsDao.getContactbyCriteria(cm);
					if(!contactsList.isEmpty())
						contact.setIdContact(contactsList.get(0).getIdContact());
					
	      			HashMap<String, String> mm = new HashMap<String, String>();
	      			mm.put("metier", app.getListdMetier().getTf().getText());
					List <Metiers> metiersList = metiersDao.getMetierbyCriteria(mm);
					if(!metiersList.isEmpty())
						metier.setIdMetier(metiersList.get(0).getIdMetier());
      				
					Annonces annonce = app.getAnnonce();
					annonce.setContacts(contact);
					annonce.setMetiers(metier);
					annonce.setDate(new Date());
					
      				AnnoncesDao annoncesDao = new AnnoncesDao();
					annoncesDao.saveAnnonce(annonce);
    				JOptionPane.showMessageDialog(null, "L'annonce a bien été enregisté");
    				app.setAnnonce(new Annonces());
    				app.getListContact().setSelectedIndex(-1);
    				app.getListdMetier().setSelectedIndex(-1);
    				app.getFieldFonction().setText("");
    				app.getFieldSecteur().setText("");
    				app.getTextAreaDescription().setText("");
      			}
      		});
        
       app.getBtnEnregistrerMetier().addActionListener(new ActionListener() {
      		@Override
       		public void actionPerformed(ActionEvent arg0) {
      				Metiers metier = new Metiers(app.getFieldMetier().getText());
    				new MetiersDao().saveMetier(metier);
    				JOptionPane.showMessageDialog(null, "Le métier a bien été enregisté");
    				app.getListdMetier().addItem(metier);
    				app.getListdMetier().revalidate();
    				app.getListdMetier().repaint();
    				app.getFieldMetier().setText("");
       			}
       		});
		
       
       app.getBtnRechercher().addActionListener(new ActionListener() {
			TableAnnonce tableAnnonce;;
			List <Annonces> listAnnonces;
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Metiers> metiers = new ArrayList<Metiers>();
				HashMap<String, String> cm = new HashMap<String, String>();
      			cm.put("metier", app.getListSearchMetier().getTf().getText());
      			Metiers metier = new Metiers();
      			List<Metiers> mets = new MetiersDao().getMetierbyCriteria(cm);
      			if(!mets.isEmpty())
      				metier = mets.get(0);
				final AnnoncesDao dao = new AnnoncesDao();
				listAnnonces = dao.getAnnoncesByIdMetier(metier.getIdMetier());
				if(!listAnnonces.isEmpty()){
					if(tableAnnonce != null)
					app.getPanelSearchAnnonce().remove(tableAnnonce);
					tableAnnonce = new TableAnnonce(listAnnonces);

					tableAnnonce.getTable().getColumnModel().getColumn(1).setMinWidth(0);
					tableAnnonce.getTable().getColumnModel().getColumn(1).setMaxWidth(0);
					tableAnnonce.getTable().getColumnModel().getColumn(1).setPreferredWidth(0);
					
					app.getPanelSearchAnnonce().add(tableAnnonce);
					app.getPanelSearchAnnonce().revalidate();
					
					tableAnnonce.getButton().addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							try{
								int rowSelected = tableAnnonce.getTable().getSelectedRow();
								Annonces annonce = new Annonces();
								annonce.setIdAnnonce((int) tableAnnonce.getTable().getModel().getValueAt(rowSelected, 1));
								dao.deleteAnnonce(annonce);
								DefaultTableModel model = ((DefaultTableModel) tableAnnonce.getTable().getModel());
								model.removeRow(rowSelected);
								tableAnnonce.getTable().remove(rowSelected);
								tableAnnonce.getTable().revalidate();
								tableAnnonce.getTable().repaint();
								}catch(java.lang.ArrayIndexOutOfBoundsException e){
								JOptionPane.showMessageDialog(null,"Selectionné l'annonce en cliquant dessus");
							}
							
						}
						
						
						});
				}
				
			}
			
			
		});
	}
		
		
		
	
	public static void main(String[] args) {
		   SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {   

	        		try {
	        			UIManager.setLookAndFeel("com.jgoodies.looks.windows.WindowsLookAndFeel");
	        		} catch (ClassNotFoundException e1) {
	        			// TODO Auto-generated catch block
	        			e1.printStackTrace();
	        		} catch (InstantiationException e1) {
	        			// TODO Auto-generated catch block
	        			e1.printStackTrace();
	        		} catch (IllegalAccessException e1) {
	        			// TODO Auto-generated catch block
	        			e1.printStackTrace();
	        		} catch (UnsupportedLookAndFeelException e1) {
	        			// TODO Auto-generated catch block
	        			e1.printStackTrace();
	        		}
	            	MainSuperviseur main = new MainSuperviseur();
	            	
	  			
	            }
	        });  
		   
		 
	}
	
	
    
    
    
    /*app.getDateChooser().getDateEditor().addPropertyChangeListener(
        new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if ("date".equals(e.getPropertyName())) {
                    System.out.println(e.getPropertyName()
                        + ": " + (Date) e.getNewValue());
                }
            }
        });*/
}