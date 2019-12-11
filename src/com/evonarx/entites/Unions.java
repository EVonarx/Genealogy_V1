package com.evonarx.entites;

import java.util.Date;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class Unions {
	private Personne lAutre;
	private Date date_debut;
	private Date date_fin;
	
	private List<Personne> listEnfants = new Vector<>();
	
	public Personne getlAutre() {
		return lAutre;
	}
	public List<Personne> getListEnfants() {
		return listEnfants;
	}
	public void setListEnfants(List<Personne> listEnfants) {
		this.listEnfants = listEnfants;
	}
	public void setlAutre(Personne lAutre) {
		this.lAutre = lAutre;
	}
	public Date getDate_debut() {
		// exception né, vivant et majeur
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	
	public Unions(Personne lAutre, Date date_debut, Date date_fin) {
		super();
		this.lAutre = lAutre;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.listEnfants = null;
	}
	
	public Unions(Personne lAutre, Date date_debut) {
		super();
		this.lAutre = lAutre;
		this.date_debut = date_debut;
		this.date_fin = null;
		this.listEnfants = null;
	}
	
	public Unions(Personne lAutre, Date date_debut, Date date_fin, List<Personne> listEnfants) {
		super();
		this.lAutre = lAutre;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.listEnfants = listEnfants;
	}
	
	public Unions() {
		super();
	}
	
	/*
	@Override
	public String toString() {
		return "Unions [lAutre=" + lAutre + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", listEnfants="
				+ listEnfants + "]";
	}
	*/
	
	
	
	
	@Override
	public String toString() {
		
		String result = "";

		Personne pTemp = this.getlAutre(); 
//		private String str_nom;
//		private String str_prenom;
//		private Genre enum_genre;
//		private Date date_naissance;
//		private Date date_deces;
//		private Personne pere;
//		private Personne mere;
//		private List<Unions> listUnions= new Vector<>();
		
		result = "\n   Liste des Unions = \n   Union => Personne [" + "\n" + "       Nom = " + pTemp.getStr_nom() + ", Prenom = " + pTemp.getStr_prenom() + ", Sexe = "
				+ pTemp.getEnum_genre() + ", Date_naissance = " + pTemp.getDate_naissance() + ", Date_deces = "
				+ pTemp.getDate_deces()  + ", Date_début = " + this.getDate_debut() + ", Date_fin = " + this.getDate_fin() + "\n"+ "       Pere = " + pTemp.getPere() + "\n"+ "       Mere = " + pTemp.getMere() +"]";
		
		
		//result = pTemp.toString();
		List<Personne> lE = this.getListEnfants();
		if (lE != null) {
			for (Personne p : lE) {
				if (p != null) {
//					Personne pere = null;
//					if (p.getPere() != null) {
//						pere = p.getPere();
//					}

					result = result + "\n   Liste des Enfants => Enfant [" +"\n" + "        Nom = " + p.getStr_nom() + ", Prenom = " + p.getStr_prenom() + ", Sexe = "
							+ p.getEnum_genre() + ", Date_naissance = " + p.getDate_naissance() + ", Date_deces = "
							+ p.getDate_deces() +"]";
					//result = result + p.toString() + "\n" +;
				} else break;
			}
			result = result + "\n" + "   ]";
		}
		
		
		return result ;
		
	}
	
}
