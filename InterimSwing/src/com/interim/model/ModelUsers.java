package com.interim.model;

import java.util.List;

import javax.swing.table.DefaultTableModel;

public class ModelUsers extends DefaultTableModel {
	public ModelUsers(List<Users> users) {
        addColumn("Nom");
        addColumn("Prenom");
        addColumn("Rue");
        addColumn("Code");
        addColumn("Ville");
        addColumn("Email");
        addColumn("Tel");
        addColumn("Id");
      
        for(Users user : users){
        	 addRow(new Object[] { user.getNom(), user.getPrenom(),
        			 user.getAdresses().getRue(), user.getAdresses().getCode(),
        			 user.getAdresses().getVille(), user.getLogins().getEmail(),
        			 user.getTel(), user.getIdUser() });
        } 
}

}
