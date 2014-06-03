package com.interim.util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import net.sf.jooreports.templates.DocumentTemplate;
import net.sf.jooreports.templates.DocumentTemplateException;
import net.sf.jooreports.templates.DocumentTemplateFactory;


public class Lettre {
	
	private String name = "";
	private String rue = "";
	private String ville = "";
	private String tel = "";
	
	
	private String date = "";
	private String entreprise = "";
	private String contact = "";
	private String adresse = "";
	private String commune = "";
	private String metier = "";
	private String type = "";
	private String lieu = "";

	public Lettre(String name, String rue, String ville, String tel) {
		this.name = name;
		this.rue = rue;
		this.ville = ville;
		this.tel = tel;
	}
	
	
	
	
	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getRue() {
		return rue;
	}




	public void setRue(String rue) {
		this.rue = rue;
	}




	public String getVille() {
		return ville;
	}




	public void setVille(String ville) {
		this.ville = ville;
	}




	public String getTel() {
		return tel;
	}




	public void setTel(String tel) {
		this.tel = tel;
	}




	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getMetier() {
		return metier;
	}

	public void setMetier(String metier) {
		this.metier = metier;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String generate(String output) {
		DocumentTemplateFactory documentTemplateFactory = new DocumentTemplateFactory();
		DocumentTemplate template;
		output = output + "Lettre_de_motivation.odt";
		
		String avant = "";
		String arriere = "";
		
		if (getType() == "Offre") {
            avant = "Suite à l'offre parue au " + getLieu() + ", j";
            arriere = " que vous proposez";
        } else if (getType() == "Spontanee") {
            avant = "J";
        }
		
		try {
			
			template = documentTemplateFactory.getTemplate(new File("src/template/Lettre_de_motivation.odt"));
			Map data = new HashMap();
			data.put("Date", getDate());
			data.put("Name", getName());
			data.put("Rue", getRue());
			data.put("Ville", getVille());
			data.put("Tel", getTel());
			data.put("Entreprise", getEntreprise());
			data.put("Titre", getContact());
			data.put("Adresse", getAdresse());
			data.put("Commune", getCommune());
			data.put("Boulot", getMetier());
			data.put("avant", avant);
			data.put("arriere", arriere);
			template.createDocument(data, new FileOutputStream(output));
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Exception Message",
	                JOptionPane.PLAIN_MESSAGE, null);
			e.printStackTrace();
		}catch (DocumentTemplateException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Exception Message",
	                JOptionPane.PLAIN_MESSAGE, null);
			
		}
		return output;
	}
	
	public static void main(String[] args) {
	/*	Lettre lettre = new Lettre("Mehboub Sophien", "place du sud 25", "7033 quaregnon", "0473425007");
		lettre.setDate("17/02/2014");
		lettre.setEntreprise("Sa Informatics");
		lettre.setContact("Monsieur Carl Marcx");
		lettre.setAdresse("Place 16");
		lettre.setCommune("7000 Mons");
		lettre.setMetier("technicien en informatique");
		lettre.setType("Offre");
		lettre.setLieu("Forem");
		
		System.out.println(lettre.generate("D:\\Lettre.odt"));*/
	}
	
	
}
