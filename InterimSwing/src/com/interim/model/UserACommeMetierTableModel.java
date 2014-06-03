package com.interim.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import org.apache.commons.lang3.StringEscapeUtils;

public class UserACommeMetierTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<UserACommeMetier> userACommeMetiers;

    public UserACommeMetierTableModel(List<UserACommeMetier> userACommeMetiers) {
        this.userACommeMetiers = new ArrayList<UserACommeMetier>(userACommeMetiers);
    }

    public List<UserACommeMetier> getUserACommeMetiers() {
		return userACommeMetiers;
	}

	@Override
    public int getRowCount() {
        return userACommeMetiers.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        String name = "??";
        switch (column) {
            case 0:
                name = "metier";
                break;
            case 1:
                name = "cv";
                break;
            case 2:
                name = "idMetier";
                break;
        }
        return name;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class type = String.class;
        switch (columnIndex) {
            case 0:
            case 1:
            	type = String.class;
                break;
            case 2:
                type = Integer.class;
                break;
        }
        return type;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    	UserACommeMetier userACommeMetier = userACommeMetiers.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = StringEscapeUtils.unescapeHtml4(userACommeMetier.getMetiers().getMetier());
                break;
            case 1:
                value = userACommeMetier.getCv();
                break;
            case 2:
                value = userACommeMetier.getId().getIdMetier();
                break;
        }
        return value;
    }   
    
    public void addRow(UserACommeMetier userACommeMetier) {
    	userACommeMetiers.add(userACommeMetier);
        fireTableRowsInserted(userACommeMetiers.size() - 1, userACommeMetiers.size() - 1);
    
    }   

    
    public void deleteRow(int rowToDelete){
    	userACommeMetiers.remove(rowToDelete);
        fireTableRowsDeleted(rowToDelete, rowToDelete);
     }
}        
	

