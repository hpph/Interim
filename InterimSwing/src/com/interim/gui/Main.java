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
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.io.FileExistsException;
import org.apache.commons.io.FileUtils;

import autocomplete.AutoSuggest;

import com.interim.dao.AnnoncesDao;
import com.interim.dao.ContactsDao;
import com.interim.dao.MetiersDao;
import com.interim.dao.RdvsDao;
import com.interim.dao.UserACommeMetierDao;
import com.interim.dao.UsersDao;
import com.interim.gui.view.App;
import com.interim.gui.view.Contact;
import com.interim.gui.view.Login;
import com.interim.gui.view.Profil;
import com.interim.gui.view.Register;
import com.interim.gui.view.TableAnnonce;
import com.interim.model.Annonces;
import com.interim.model.Contacts;
import com.interim.model.Metiers;
import com.interim.model.Rdvs;
import com.interim.model.RdvsId;
import com.interim.model.Roles;
import com.interim.model.UserACommeMetier;
import com.interim.model.UserACommeMetierId;
import com.interim.model.UserACommeMetierTableModel;
import com.interim.model.Users;
import com.interim.util.EmailValidator;
import com.interim.util.Lettre;
import com.interim.util.SendMailTLS;
import com.interim.util.WebPagePrinter;
import com.interim.util.FileWrite;
import com.interim.util.ZipDirectory;

public class Main extends JFrame {

			public static Users user = new Users();
	  		Login login;
			App app;
			Profil profil;
			Register register;
			Contact contact = new Contact();
			String dirTmp = "";
			String userDownload = System.getProperty("user.home") + "\\Downloads\\";
			ArrayList<String> list;
			Annonces annonce;
			ArrayList<String> listMois = new ArrayList<String>();
			static final String archive = "src/archiveEmploi/";
			static final String tmp = "src/tmpEmploi/";
	

	private Main() {
		
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
		
		try{
		
		list = new MetiersDao().getAllStringMetiers();
		}catch(ExceptionInInitializerError e){
			JOptionPane.showMessageDialog(null,"Démarrez votre serveur mysql");
		}
		
		login = new Login();
		app = new App();
		register = new Register(list);
		
		if(!new File(userDownload).exists()){
			new File(userDownload).mkdir();
		}
		
		
/**************************************** create menu ******************************************/
		JMenu menuInterim;
		JMenu menuRdv;
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
		
		menuRdv = new JMenu("Rdv");
		menuRdv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
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
        
        
		JMenuItem menuItemContact = new JMenuItem("Contact"){
			@Override
		    public Dimension getPreferredSize() {
		        Dimension d = super.getPreferredSize();
		        d.width = Math.max(d.width, 135); // set minimums
		        d.height = Math.max(d.height, 25);
		        return d;
		    }
		};
		menuItemContact.setHorizontalAlignment(SwingConstants.CENTER);
		menuItemContact.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
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
		menuName.add(menuItemContact);
		menuName.add(new JSeparator());
		menuName.add(menuItemLogout);
		
		
		menuBar.add(menuInterim);
		menuBar.add(menuRdv);
		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(menuName);
		
		/**************************************** fin create menu ******************************************/

        
        getContentPane().add(login);
        
        login.getBtnLogin().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				final UsersDao usersDao = new UsersDao();
				List <Users> users = usersDao.getUserbyLogin(login.getFieldUsername().getText(), login.getFieldPassword().getText());
				if(!users.isEmpty()){
				user = users.get(0);
				
				menuName.setText(user.getNom() + " " + user.getPrenom());
				list = new MetiersDao().getAllStringMetiers();
				profil = new Profil(list);
				List<UserACommeMetier> userACommeMetiersJTable = new ArrayList<UserACommeMetier>();
				Set<UserACommeMetier> userACommeMetiers = user.getUserACommeMetiers();
				for(UserACommeMetier userACommeMetier : userACommeMetiers ){
					app.getListMetier().addItem(userACommeMetier.getMetiers());
					app.getListSearchMetier().addItem(userACommeMetier.getMetiers());
					userACommeMetiersJTable.add(userACommeMetier);
			    }
				final UserACommeMetierTableModel model = new UserACommeMetierTableModel(userACommeMetiersJTable);
	            profil.getTable().setModel(model);
	            profil.getTable().getColumnModel().getColumn(0).setPreferredWidth(220);
	            profil.getTable().getColumnModel().getColumn(1).setPreferredWidth(200);
	            profil.getTable().getColumnModel().getColumn(2).setMinWidth(0);
	            profil.getTable().getColumnModel().getColumn(2).setMaxWidth(0);
	            profil.getTable().getColumnModel().getColumn(2).setPreferredWidth(0);
	            profil.getTable().setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	            
	            profil.getFieldPasswordconfirm().setText(user.getLogins().getPassword());;
	            
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
	    				}else{
	    				ArrayList<Metiers> metiers = new ArrayList<Metiers>();
	    				usersDao.saveUser(user);
	    				MetiersDao dao = new MetiersDao();
	    				ArrayList<AutoSuggest> jtexts = new ArrayList<AutoSuggest>();
	    				for(int x = 0;x < profil.getFieldMetiers().length;x++){
	    					if(profil.getFieldMetiers()[x].getSize().width > 0){
	    						AutoSuggest jtext = profil.getFieldMetiers()[x];
	    						jtexts.add(jtext);
	    					}
	    				}
	    			
	    				
	    				for(int x = 0;x < jtexts.size();x++){
	    					HashMap<String, String> m = new HashMap<String, String>();
	    					m.put("metier", jtexts.get(x).getTf().getText());
	    					List <Metiers> metierList = dao.getMetierbyCriteria(m);
	    					if(!metierList.isEmpty())
	    					metiers.add(metierList.get(0));
	    				}

	    				Set<UserACommeMetier> userACommeMetiers = new HashSet<UserACommeMetier>();
	    				UserACommeMetierDao userACommeMetierDao = new UserACommeMetierDao();
	    				for(int w = 0;w < metiers.size();w++){
	    					UserACommeMetier userACommeMetierNew = new UserACommeMetier();
	    					UserACommeMetierId userACommeMetierId = new UserACommeMetierId();
	    		
	    					userACommeMetierNew.setCv(new File(profil.getFieldCvs()[w].getText()).getName());
	    					Metiers metier = new Metiers();
	    					metier.setIdMetier(metiers.get(w).getIdMetier());
	    					metier.setMetier(metiers.get(w).getMetier());
	    					userACommeMetierId.setIdMetier(metiers.get(w).getIdMetier());	    

	    					userACommeMetierId.setIdUser(user.getIdUser());
	    					userACommeMetierNew.setId(userACommeMetierId);
	    					userACommeMetierNew.setMetiers(metier);	
	    					userACommeMetierNew.setUsers(user);
	    					userACommeMetiers.add(userACommeMetierNew);
	    					try {
	    						FileUtils.copyFile(new File(profil.getFieldCvs()[w].getText()), new File("src/template/" + user.getIdUser() + "/" + new File(profil.getFieldCvs()[w].getText()).getName()));
	    					} catch (IOException e) {
	    						// TODO Auto-generated catch block
	    						e.printStackTrace();
	    					}
	    				}
	    				
	    				for(UserACommeMetier userACommeMetier : userACommeMetiers){
	    				userACommeMetierDao.saveUserACommeMetier(userACommeMetier);
	    				model.addRow(userACommeMetier);
						app.getListSearchMetier().addItem(userACommeMetier.getMetiers());
						app.getListMetier().addItem(userACommeMetier.getMetiers());
	    				}
	    				JOptionPane.showMessageDialog(null, "Votre profil a bien été modifié");
	    				}
	    				
	    				menuName.setText(user.getNom() + " " + user.getPrenom());
	    				app.getListSearchMetier().revalidate();
	    				app.getListSearchMetier().repaint();
	    				app.getListMetier().revalidate();
	    				app.getListMetier().repaint();
	    				profil.getTable().revalidate(); 
	    				profil.getTable().repaint();
	    				
	    				for(int z = 0;z < profil.getFieldCvs().length;z++){
	    					profil.getFieldCvs()[z].setText("");
	    					profil.getFieldMetiers()[z].getTf().setText("");
	    				}
	    				
	    			}
	           });
	        
	            
	            profil.getBtnDelete().addActionListener(new ActionListener() {
	    			@Override
	    			public void actionPerformed(ActionEvent arg0) {
	    				
	    				UserACommeMetier userACommeMetierNew = new UserACommeMetier();
						UserACommeMetierId userACommeMetierId = new UserACommeMetierId();
			
						userACommeMetierNew.setCv((String) profil.getTable().getModel().getValueAt(profil.getTable().getSelectedRow(), 1));
						Metiers metier = new Metiers();
						metier.setIdMetier((Integer) profil.getTable().getModel().getValueAt(profil.getTable().getSelectedRow(), 2));
						metier.setMetier((String) profil.getTable().getModel().getValueAt(profil.getTable().getSelectedRow(), 0));
						userACommeMetierId.setIdMetier((Integer) profil.getTable().getModel().getValueAt(profil.getTable().getSelectedRow(), 2));	    

						userACommeMetierId.setIdUser(user.getIdUser());
						userACommeMetierNew.setId(userACommeMetierId);
						userACommeMetierNew.setMetiers(metier);	
						userACommeMetierNew.setUsers(user);
						
						UserACommeMetierDao userACommeMetierDao = new UserACommeMetierDao();						
	    				
						userACommeMetierDao.deleteUserACommeMetier(userACommeMetierNew);
						UserACommeMetierTableModel model = (UserACommeMetierTableModel) profil.getTable().getModel();
	    				new File("src/template/" + user.getIdUser() + "/" + profil.getTable().getModel().getValueAt(profil.getTable().getSelectedRow(), 1)).delete();
	    				model.deleteRow(profil.getTable().getSelectedRow());

						for(int i = 0;i < app.getListMetier().getItemCount();i++){
							if(app.getListMetier().getItemAt(i).getIdMetier().equals(userACommeMetierNew.getMetiers().getIdMetier())){
			    				app.getListSearchMetier().removeItemAt(i);
			    				app.getListSearchMetier().revalidate();
			    				app.getListSearchMetier().repaint();
			    				app.getListMetier().removeItemAt(i);
			    				app.getListMetier().revalidate();
			    				app.getListMetier().repaint();
							}
							
						}
						
	    			}
	           });
	            
	            for(int i = 0;i < profil.getBtnCvs().length;i++){
	         	  JButton button = profil.getBtnCvs()[i];
	         	  final JTextField field = profil.getFieldCvs()[i];
	         	  
	         	  button.addActionListener(new ActionListener() {
	       			@Override
	       			public void actionPerformed(ActionEvent arg0) {
	       				field.setText(chooseFile());
	       			}
	       		});
	            }

				if(user.isLogin()){
					getContentPane().remove(login);
					getContentPane().add(menuBar, BorderLayout.NORTH);
					getContentPane().add(app);
					app.getTabbedPane().setSelectedIndex(0);
					getContentPane().validate();
					getContentPane().repaint();
				}
				}
				
			}
		});      
        
        login.getLblRegister().addMouseListener(new MouseAdapter() {
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
				e.getComponent().setFont(original);
				e.getComponent().setForeground(Color.BLACK);
				getContentPane().remove(login);
				getContentPane().add(register);
				getContentPane().validate();
				getContentPane().repaint();
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

        
       menuName.getItem(3).addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent e) {
    		   app.getListMetier().removeAllItems();
    		   getContentPane().remove(menuBar);
    		   getContentPane().remove(app);
    		   getContentPane().remove(profil);
			   contact.setVisible(false);
    		   //getContentPane().remove(contact);
    		   user = new Users();
    		   login.getFieldUsername().setText("");
    		   login.getFieldPassword().setText("");
			   getContentPane().add(login);
			   getContentPane().validate();
			   getContentPane().repaint();

    		  }
    	});
       
       menuName.getItem(1).addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent e) {
    		   getContentPane().remove(app);
    		   getContentPane().remove(profil);
				
	    		if(contact.getParent() == null){
	    			getContentPane().add(contact);
	    			contact.setVisible(true);
    	   		}else{
    	   			contact.setVisible(true);
    	   		}
				getContentPane().validate();
				getContentPane().repaint();

    		  }
    	});
       
       menuName.getItem(0).addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent e) {
    		    getContentPane().remove(app);
				contact.setVisible(false);
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
				 contact.setVisible(false);
				 //getContentPane().remove(contact);
				 getContentPane().add(app);
				 getContentPane().validate();
				 getContentPane().repaint();	
		}
		public void menuDeselected(MenuEvent e) {}
		public void menuCanceled(MenuEvent e) {}
	});
        

     
       register.getBtnEnregistrer().addActionListener(new ActionListener() {
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
				}else{
				ArrayList<Metiers> metiers = new ArrayList<Metiers>();
				UsersDao usersDao = new UsersDao();
				List <Users> sups = usersDao.getUserSuperviseur();
				Users sup = new Users();
				if(!sups.isEmpty())
				sup = sups.get(0);
				
				Roles role = new Roles("user");
				role.setIdRole(1);
				
				Users supv = new Users();
				supv.setIdUser(sup.getIdUser());
				user.setUsers(supv);
				user.getLogins().setRoles(role);
				
				new UsersDao().saveUser(user);
				MetiersDao dao = new MetiersDao();
				ArrayList<AutoSuggest> jtexts = new ArrayList<AutoSuggest>();
				for(int x = 0;x < register.getFieldMetiers().length;x++){
					if(register.getFieldMetiers()[x].getSize().width > 0){
						AutoSuggest jtext = register.getFieldMetiers()[x];
						jtexts.add(jtext);
					}
				}
			
				
				for(int x = 0;x < jtexts.size();x++){
					HashMap<String, String> m = new HashMap<String, String>();
					m.put("metier", jtexts.get(x).getTf().getText());
					List <Metiers> metierList = dao.getMetierbyCriteria(m);
					if(!metierList.isEmpty())
					metiers.add(metierList.get(0));
				}
				
				new File("src/template/" + user.getIdUser() + "/").mkdir();
				
				Set<UserACommeMetier> userACommeMetiers = new HashSet<UserACommeMetier>();
				UserACommeMetierDao userACommeMetierDao = new UserACommeMetierDao();
				for(int w = 0;w < metiers.size();w++){
					UserACommeMetier userACommeMetierNew = new UserACommeMetier();
					UserACommeMetierId userACommeMetierId = new UserACommeMetierId();
		
					userACommeMetierNew.setCv(new File(register.getFieldCvs()[w].getText()).getName());
					Metiers metier = new Metiers();
					metier.setIdMetier(metiers.get(w).getIdMetier());
					metier.setMetier(metiers.get(w).getMetier());
					userACommeMetierId.setIdMetier(metiers.get(w).getIdMetier());	    

					userACommeMetierId.setIdUser(user.getIdUser());
					userACommeMetierNew.setId(userACommeMetierId);
					userACommeMetierNew.setMetiers(metier);	
					userACommeMetierNew.setUsers(user);
					userACommeMetiers.add(userACommeMetierNew);
					try {
						FileUtils.copyFile(new File(register.getFieldCvs()[w].getText()), new File("src/template/" + user.getIdUser() + "/" + new File(register.getFieldCvs()[w].getText()).getName()));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				for(UserACommeMetier userACommeMetier : userACommeMetiers){
				userACommeMetierDao.saveUserACommeMetier(userACommeMetier);
				}
				JOptionPane.showMessageDialog(null, "Votre compte a bien été enregistré");
				for(int z = 0;z < register.getFieldCvs().length;z++){
					register.getFieldCvs()[z].setText("");
					register.getFieldMetiers()[z].getTf().setText("");
				}
				}
			}
		});
       
       register.getLblRetourLogin().addMouseListener(new MouseAdapter() {
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
				e.getComponent().setForeground(Color.RED);
				e.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				e.getComponent().setFont(original);
				e.getComponent().setForeground(Color.RED);
				getContentPane().remove(register);
				getContentPane().add(login);
				getContentPane().validate();
				getContentPane().repaint();
			}
		});
       
       app.getBtnChoisissezUn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String fichier = chooseFile();
				if(fichier != "")
					app.getLblAucunFichier().setText(fichier);
			}
		});
       
       for(int i = 0;i < register.getBtnCvs().length;i++){
      	  JButton button = register.getBtnCvs()[i];
      	  final JTextField field = register.getFieldCvs()[i];
      	  
      	  button.addActionListener(new ActionListener() {
    			@Override
    			public void actionPerformed(ActionEvent arg0) {
    				field.setText(chooseFile());
    			}
    		});
         }
       
       app.getButtonLettre().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Calendar c = Calendar.getInstance();
				c.setTime(new Date());
			    String date = c.get(Calendar.DAY_OF_MONTH) + "-" + c.get(Calendar.MONTH) + "-" + c.get(Calendar.YEAR);
			    String entreprise = app.getFieldEntreprise().getText();
			    
			    if(entreprise.equals(""))
			    	JOptionPane.showMessageDialog(null, "Entrez le nom d'une entreprise");
			    else{
			    //copyDirTmp = user.getIdUser() + "/";
				dirTmp = user.getIdUser() + "/" + c.get(Calendar.YEAR) + "/" +
						date + "/" +
						entreprise.replaceAll(" ", "_").toLowerCase() + "/";
				dirTmp = createDir(dirTmp);
				
				/********************************** genere lettre ************************************************/
				Lettre l = new Lettre(user.getNom() + " " + user.getPrenom(),
										   user.getAdresses().getRue(),
										   user.getAdresses().getCode() + " " + user.getAdresses().getVille(),
										   user.getTel());
				l.setDate(c.get(Calendar.DAY_OF_MONTH) + "/" + c.get(Calendar.MONTH) + "/" + c.get(Calendar.YEAR));
				l.setEntreprise(app.getFieldEntreprise().getText());
				if(app.getFieldContact().getText().equals(""))
					l.setContact("Madame, Monsieur");
				else
					l.setContact(app.getFieldContact().getText());
				l.setAdresse(app.getFieldAdresse().getText());
				l.setCommune(app.getFieldCommune().getText());
				Metiers metier = (Metiers) app.getListMetier().getSelectedItem();
				l.setMetier(metier.getMetier());
				l.setType(app.getBtngrpTypeDeCandidature().getSelection().getActionCommand());
				l.setLieu(app.getFieldLieu().getText());
				
				l.generate(dirTmp);
				app.getLblAucunFichier().setText("Lettre_de_motivation.odt");
				/********************************** fin genere lettre ************************************************/
				
				if(!app.getFieldUrl().equals("Annonce interne"))
				app.getTabbedPane().setEnabledAt(1, true);
				app.getTabbedPane().setEnabledAt(2, true);
				JOptionPane.showMessageDialog(null, "La lettre a été crée " + dirTmp + "Lettre_de_motivation.odt");
				app.getLblMessageLettre().setVisible(true);
				app.getBtnActionLettre().setVisible(true);
			    }
				
			}
		});
       
       app.getBtnEnregistrer().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if((annonce != null) && (app.getFieldUrl().getText().equals("Annonce interne"))){
					String Annonce = "Date de publication : "
		            		+ annonce.getDate()
		            		+ "<br>" 
		            		+ "Secteur : "
		            		+ annonce.getSecteur()
		            		+ "<br>"
		            		+ "Fonction : "
		            		+ annonce.getFonction()
		            		+ "<br>"
		            		+ "Description : "
		            		+ annonce.getDescription()
		            		+ "<br><br>"
		            		+ "Entreprise : "
		            		+ annonce.getContacts().getEntreprise()
		            		+ "<br>"
		            		+ "Contact : "
		            		+ annonce.getContacts().getContact()
		            		+ "<br>"
		            		+ "Adresse : "
		            		+ annonce.getContacts().getAdresse()
		            		+ "<br>"
		            		+ "Ville : "
		            		+ annonce.getContacts().getCommune()
		            		+ "<br>"
		            		+ "Email : "
		            		+ annonce.getContacts().getEmail()
		            		+ "<br>"
		            		+ "Tel :"
		            		+ annonce.getContacts().getTel()
		            		+ "<br>";
					
					FileWrite.writeToFile(Annonce, dirTmp + "Annonce.txt", "<br>");
					JOptionPane.showMessageDialog(null, "Le screenShot " + dirTmp + "Annonce.txt");
					annonce = null;
				}else{
				String urlScreenShot = app.getFieldUrl().getText();
				int responseCode = 0;
				try {
					final URL url = new URL(urlScreenShot);
					HttpURLConnection huc = (HttpURLConnection) url.openConnection();
					huc.setRequestMethod("HEAD");
					responseCode = huc.getResponseCode();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Le site n'existe pas");
				}

				if (responseCode == 200) {
					new WebPagePrinter().Download(urlScreenShot, dirTmp + "Annonce.png");
					JOptionPane.showMessageDialog(null, "Le screenShot " + dirTmp + "Annonce.png");
					app.getLblMessageAnnonce().setVisible(true);
					app.getBtnActionAnnonce().setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "L'url contient une erreur");
				}
				}
			}
		});
       
       app.getBtnEnvoyer().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Metiers metier = (Metiers) app.getListMetier().getSelectedItem();
				List<File> filesFull = new ArrayList<File>();
				File l;

				if(app.getLblAucunFichier().getText().equals("Lettre_de_motivation.odt")){
					l = new File(dirTmp + "Lettre_de_motivation.odt");
				}else{
					l = new File(app.getLblAucunFichier().getText());
					new File(dirTmp + "Lettre_de_motivation.odt").delete();
					try {
						FileUtils.copyFile(l, new File(dirTmp + "Lettre_de_motivation.odt"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				String cv = "src/template/" + user.getIdUser() + "/";
				Set<UserACommeMetier> userACommeMetiers = user.getUserACommeMetiers();
				for(UserACommeMetier userACommeMetier : userACommeMetiers ){
					if(userACommeMetier.getMetiers().getIdMetier().equals(metier.getIdMetier())){
						cv = cv + userACommeMetier.getCv();
					}
			    }		
				
				
				
				File c = new File(cv);
				filesFull.add(l);
				filesFull.add(c);
				
				if(c.exists()){
				
				String contact = app.getFieldContact().getText();
				
				if(contact.equals(""))
					contact = "Madame, Monsieur";
				
				String content = contact + ",<br><br>" +
						 
					    "Par la présente, je me permets de poser ma candidature<br>" +
					    "pour un éventuel poste vacant dans votre entreprise.<br>" +
					    "Le curriculum-vitae ci-joint vous donnera de plus<br>" +
					    "amples renseignements, je reste à votre entière<br>" +
					    "disposition pour tout entretien ou tout<br>" +
					    "complémentaire.<br>" +

					    "Dans l’espoir que ma candidature soit retenue, je vous prie d’agréer, " + contact + " mes salutations respectueuses.";
				
				String formatMail = "text/html";
				
				if(EmailValidator.validate(app.getFieldEmail().getText())){	
					try {
						
						/*JOptionPane.showMessageDialog(null, user.getLogins().getEmail() + "," + user.getNom() + " " + user.getPrenom() + ","
								 + app.getFieldEmail().getText() + ","  + "Candidature" + ","
								 + content + ","  + formatMail + ","  + filesFull);*/
						new SendMailTLS(user.getLogins().getEmail(),user.getNom() + " " + user.getPrenom(),
								app.getFieldEmail().getText(), "Candidature", 
								content, formatMail, filesFull);
						
						FileWrite.writeToFile(content, dirTmp + "Message_envoye.txt", "<br>");
						
						Contacts Contact;
						if(annonce != null){
							String Annonce = "Date de publication : "
				            		+ annonce.getDate()
				            		+ "<br>" 
				            		+ "Secteur : "
				            		+ annonce.getSecteur()
				            		+ "<br>"
				            		+ "Fonction : "
				            		+ annonce.getFonction()
				            		+ "<br>"
				            		+ "Description : "
				            		+ annonce.getDescription()
				            		+ "<br><br>"
				            		+ "Entreprise : "
				            		+ annonce.getContacts().getEntreprise()
				            		+ "<br>"
				            		+ "Contact : "
				            		+ annonce.getContacts().getContact()
				            		+ "<br>"
				            		+ "Adresse : "
				            		+ annonce.getContacts().getAdresse()
				            		+ "<br>"
				            		+ "Ville : "
				            		+ annonce.getContacts().getCommune()
				            		+ "<br>"
				            		+ "Email : "
				            		+ annonce.getContacts().getEmail()
				            		+ "<br>"
				            		+ "Tel :"
				            		+ annonce.getContacts().getTel()
				            		+ "<br>";
							
							FileWrite.writeToFile(Annonce, dirTmp + "Annonce.txt", "<br>");
							Contact = annonce.getContacts();
							annonce = null;
						}else{
							ContactsDao contactsDao = new ContactsDao();
							/**************** chercher contact par entreprise pour set tel et id  ************************/
							
							HashMap<String, String> cm = new HashMap<String, String>();
		          			cm.put("entreprise", app.getFieldEntreprise().getText());
		    				List <Contacts> contactsList = contactsDao.getContactbyCriteria(cm);
		    				
		    				if(!contactsList.isEmpty())
		    					Contact = contactsList.get(0);
		    				else{	
							Contact = new Contacts();
							Contact.setEntreprise(app.getFieldEntreprise().getText());
							Contact.setContact(app.getFieldContact().getText());
							Contact.setAdresse(app.getFieldAdresse().getText());
							Contact.setCommune(app.getFieldCommune().getText());
							Contact.setEmail(app.getFieldEmail().getText());
							contactsDao.saveContact(Contact);
		    				}
						}
						
						try {
							
							FileUtils.copyFile(c, new File(dirTmp + c.getName()));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "L'email a été envoyé");
						app.getLblMessageAnnonce().setVisible(false);
						app.getBtnActionAnnonce().setVisible(false);
						app.getLblMessageLettre().setVisible(false);
						app.getBtnActionLettre().setVisible(false);
						Calendar ca = Calendar.getInstance();
						ca.setTime(new Date());
					    String date = ca.get(Calendar.DAY_OF_MONTH) + "-" + ca.get(Calendar.MONTH) + "-" + ca.get(Calendar.YEAR);
					    String entreprise = app.getFieldEntreprise().getText().replaceAll(" ", "_").toLowerCase();
						if(!new File(archive + user.getIdUser() + "/" + ca.get(Calendar.YEAR) + "/" + date + "/").exists()){
							new File(archive + user.getIdUser() + "/" + ca.get(Calendar.YEAR) + "/" + date + "/").mkdirs();
						}
							try{
								FileUtils.moveDirectory(new File(tmp + user.getIdUser() + "/" + ca.get(Calendar.YEAR) + "/" + date + "/" + entreprise + "/"), new File(archive + user.getIdUser() + "/" + ca.get(Calendar.YEAR) + "/" + date + "/" + entreprise + "/"));
								new File(tmp + user.getIdUser() + "/" + ca.get(Calendar.YEAR) + "/"  + date + "/" ).delete();
								new File(tmp + user.getIdUser() + "/" + ca.get(Calendar.YEAR) + "/").delete();
								new File(tmp + user.getIdUser() + "/").delete();
							}catch(FileExistsException e){
								//new File(tmp + user.getIdUser() + "/").delete();
								JOptionPane.showMessageDialog(null, e.getMessage());
							}
							
							Rdvs rdv = new Rdvs();
							RdvsId rdvId = new RdvsId();
							
							Contacts co = new Contacts();
							co.setIdContact(Contact.getIdContact());
							rdvId.setIdContact(Contact.getIdContact());
							rdv.setContacts(co);
							rdv.setDate(new Date());
							rdv.setDescription("Email envoye");
							rdv.setDir(archive + user.getIdUser() + "/" + ca.get(Calendar.YEAR) + "/" + date + "/" + entreprise + "/");
							Users us = new Users();
							us.setIdUser(user.getIdUser());
							rdvId.setIdUser(user.getIdUser());
							rdv.setUsers(us);
							rdv.setId(rdvId);
							
							new RdvsDao().saveRdv(rdv);
							
							app.getFieldAdresse().setText("");
							app.getFieldCommune().setText("");
							app.getFieldContact().setText("");
							app.getFieldEmail().setText("");
							app.getFieldEntreprise().setText("");
							app.getFieldLieu().setText("");
							app.getFieldUrl().setText("");
							
							app.getTabbedPane().setEnabledAt(1, false);
							app.getTabbedPane().setEnabledAt(2, false);
						

					} catch (Exception e) {
						e.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(null, "L'adresse email n'est pas valide");
				}
				}else JOptionPane.showMessageDialog(null, c.getName() + "n'existe pas");
			}
			
		});
		
		contact.getBtnEnvoyer().addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
				List<File> filesFull = new ArrayList<File>();
				String formatMail = "text/html";
				
				if(EmailValidator.validate(user.getUsers().getLogins().getEmail())){	
					try {
						new SendMailTLS(user.getLogins().getEmail(),user.getNom() + " " + user.getPrenom(),
								user.getUsers().getLogins().getEmail(), contact.getFieldSujet().getText(), 
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
		
		
		
		app.getBtnRechercher().addActionListener(new ActionListener() {
			TableAnnonce tableAnnonce;;
			List <Annonces> listAnnonces;
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Metiers> metiers = new ArrayList<Metiers>();
				Metiers metier = (Metiers) app.getListSearchMetier().getSelectedItem();
				AnnoncesDao dao = new AnnoncesDao();
				listAnnonces = dao.getAnnoncesByIdMetier(metier.getIdMetier());
				if(!listAnnonces.isEmpty()){
					if(tableAnnonce != null)
					app.getPanelSearchAnnonce().remove(tableAnnonce);
					tableAnnonce = new TableAnnonce(listAnnonces);
					app.getPanelSearchAnnonce().add(tableAnnonce);
					app.getPanelSearchAnnonce().revalidate();
					
					tableAnnonce.getButton().addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							try{
							annonce = listAnnonces.get(tableAnnonce.getTable().getSelectedRow());
							Contacts contact = annonce.getContacts();
							app.getFieldEntreprise().setText(contact.getEntreprise());
							app.getFieldContact().setText(contact.getContact());
							app.getFieldAdresse().setText(contact.getAdresse());
							app.getFieldCommune().setText(contact.getCommune());
							app.getFieldUrl().setText("Annonce interne");
							app.getFieldEmail().setText(contact.getEmail());
							app.getListMetier().getModel().setSelectedItem(annonce.getMetiers());
							}catch(java.lang.ArrayIndexOutOfBoundsException e){
								JOptionPane.showMessageDialog(null,"Selectionné l'annonce en cliquant dessus");
							}
							
						}
						
						
						});
				}
				
			}
			
			
		});
		
		app.getBtnVoir().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				RdvsDao rdv = new RdvsDao();
				DefaultTableModel model = new DefaultTableModel();
				model.setColumnIdentifiers(new Object[] {"Preuves"});
				List<Map<String, String>> array = rdv.getRdvsbyMonth(String.valueOf(app.getYearChooser().getYear()),user.getIdUser());
				;
				for(Map map : array){
					model.addRow(new Object[] {"<html><body><b color='red'>" + map.get("nombre") + " en " + listMois.get((int) map.get("moisNumeros")) + "</b></html></body>"});
				}
				app.getTablePreuves().setModel(model);
				app.getTablePreuves().validate();
			}
			
		});
		
		app.getBtnTelecharger().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				File directoryToZip = new File(archive + user.getIdUser() + "/" + app.getYearChooser().getYear() + "/");
				if(directoryToZip.exists()){

				List<File> fileList = new ArrayList<File>();
				ZipDirectory.getAllFiles(directoryToZip, fileList);
				ZipDirectory.writeZipFile(directoryToZip, fileList);
				try {
					FileUtils.copyFile(new File(app.getYearChooser().getYear() + ".zip") , new File(userDownload + app.getYearChooser().getYear() + ".zip"));
					JOptionPane.showMessageDialog(null, "L'endroit du fichier téléchargé est " + 
							userDownload + app.getYearChooser().getYear() + ".zip");
            	} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				}
			}
			
		});
		
		final JPopupMenu popupLettre = new JPopupMenu();
		popupLettre.add(new JMenuItem(new AbstractAction("Télécharger") {
            public void actionPerformed(ActionEvent e) {
            	try {
					FileUtils.copyFile(new File(dirTmp + "Lettre_de_motivation.odt") , new File(userDownload + "Lettre_de_motivation.odt"));
					JOptionPane.showMessageDialog(null, "L'endroit du fichier téléchargé est " + 
							userDownload + "Lettre_de_motivation.odt");
            	} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        }));
        popupLettre.add(new JMenuItem(new AbstractAction("Effacer") {
            public void actionPerformed(ActionEvent e) {
            	if(new File(dirTmp + "Lettre_de_motivation.odt").delete())
                JOptionPane.showMessageDialog(null, "Le fichier a bien été éffacé");
            }
        }));
        
    	app.getBtnActionLettre().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
            	popupLettre.show(e.getComponent(), e.getX(), e.getY());
            }
        });
    	
    	final JPopupMenu popupAnnonce = new JPopupMenu();
    	popupAnnonce.add(new JMenuItem(new AbstractAction("Télécharger") {
            public void actionPerformed(ActionEvent e) {
            	try {
					FileUtils.copyFile(new File(dirTmp + "Annonce.png"), new File(userDownload + "Annonce.png"));
					JOptionPane.showMessageDialog(null, "L'endroit du fichier téléchargé est " + 
							userDownload + "Annonce.png");
            	} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        }));
    	popupAnnonce.add(new JMenuItem(new AbstractAction("Effacer") {
            public void actionPerformed(ActionEvent e) {
            	if(new File(dirTmp + "Annonce.png").delete())
            	JOptionPane.showMessageDialog(null, "Le fichier a bien été éffacé");
            }
        }));
    	
    	app.getBtnActionAnnonce().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
            	popupAnnonce.show(e.getComponent(), e.getX(), e.getY());
            }
        });
      
        
	}
	
	private String chooseFile() {	
		JFileChooser choose = new JFileChooser();
		choose.setFileSelectionMode(JFileChooser.FILES_ONLY);
		choose.setMultiSelectionEnabled(false);
		String path = "";
		int retour = choose.showOpenDialog(null);

		if(retour == JFileChooser.APPROVE_OPTION){

			File file = choose.getSelectedFile();

			path = file.getAbsolutePath();

		}
		return path;
	}
	
	private String createDir(String dir){
		String dirTmp = tmp + dir;
		File directory = new File(dirTmp);
		if(!directory.exists()){
			directory.mkdirs();  
		}
		return dirTmp;
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
	            	Main main = new Main();
	            	
	  			
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