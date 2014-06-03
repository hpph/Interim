package com.interim.model;

import java.util.List;

import javax.swing.table.DefaultTableModel;

public class ModelAnnonce extends DefaultTableModel {
	public ModelAnnonce(List<Annonces> annonces) {
        //JTable table = new JTable(this);
        addColumn("Annonce");
      
        for(Annonces annonce : annonces){
        	String Annonce = "<html>"
            		+ "<body>"
            		+ "<br>"
            		+ "<b color='red'>" 
            		+ "Date de publication : "
            		+ "</b>"
            		+ annonce.getDate()
            		+ "<br><br>"
            		+ "<b color='red'>" 
            		+ "Secteur : "
            		+ "</b>"
            		+ annonce.getSecteur()
            		+ "<br><br>"
            		+ "<b color='red'>" 
            		+ "Fonction : "
            		+ "</b>"
            		+ annonce.getFonction()
            		+ "<br><br>"
            		+ "<b color='red'>" 
            		+ "Description : "
            		+ "</b>"
            		+ annonce.getDescription()
            		+ "<br><br><br><br>"
            		+ "<b color='blue'>" 
            		+ "Entreprise : "
            		+ "</b>"
            		+ annonce.getContacts().getEntreprise()
            		+ "<br><br>"
            		+ "<b color='blue'>" 
            		+ "Contact : "
            		+ "</b>"
            		+ annonce.getContacts().getContact()
            		+ "<br><br>"
            		+ "<b color='blue'>" 
            		+ "Adresse : "
            		+ "</b>"
            		+ annonce.getContacts().getAdresse()
            		+ "<br><br>"
            		+ "<b color='blue'>" 
            		+ "Ville : "
            		+ "</b>"
            		+ annonce.getContacts().getCommune()
            		+ "<br><br>"
            		+ "<b color='blue'>" 
            		+ "Email : "
            		+ "</b>"
            		+ annonce.getContacts().getEmail()
            		+ "<br><br>"
            		+ "<b color='blue'>" 
            		+ "Tel :"
            		+ "</b>"
            		+ annonce.getContacts().getTel()
            		+ "<br><br>"
            		+ "</body>"
            		+ "</html>";
        	 addRow(new Object[] { Annonce });
        } 
}

}
