package com.evonarx.entites;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import com.evonarx.enumeration.Genre;

public class Personne {

	private String str_nom;
	private String str_prenom;
	private Genre enum_genre;
	private Date date_naissance;
	private Date date_deces;
	private Personne pere;
	private Personne mere;
	private List<Unions> listUnions= new Vector<>();


	public String getStr_nom() {
		return str_nom;
	}
	/* */
	public void setStr_nom(String str_nom) {
		this.str_nom = str_nom;
	}
	public String getStr_prenom() {
		return str_prenom;
	}
	public void setStr_prenom(String str_prenom) {
		this.str_prenom = str_prenom;
	}
	public Genre getEnum_genre() {
		return enum_genre;
	}
	public void setEnum_genre(Genre enum_genre) {
		this.enum_genre = enum_genre;
	}
	public Date getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}
	public Date getDate_deces() {
		return date_deces;
	}
	public void setDate_deces(Date date_deces) {
		this.date_deces = date_deces;
	}
	public Personne getPere() {
		return pere;
	}
	public void setPere(Personne pere) {
		this.pere = pere;
	}
	public Personne getMere() {
		return mere;
	}
	public void setMere(Personne mere) {
		this.mere = mere;
	}
	public List<Unions> getListUnions() {
		return listUnions;
	}
	public void setListUnions(List<Unions> listUnions) {
		this.listUnions = listUnions;
	}


	public Personne(String str_nom, String str_prenom, Genre enum_genre, Date date_naissance, Date date_deces,
			Personne pere, Personne mere, List<Unions> listUnions) {
		super();
		this.str_nom = str_nom;
		this.str_prenom = str_prenom;
		this.enum_genre = enum_genre;
		this.date_naissance = date_naissance;
		this.date_deces = date_deces;
		this.pere = pere;
		this.mere = mere;
		this.listUnions = listUnions;

	}

	public Personne() {
		super();
	}

	public Personne(Personne p) {
		str_nom = p.str_prenom;
		str_prenom = p.str_prenom;
		enum_genre = p.enum_genre;
		date_naissance = p.date_naissance;
		date_deces = p.date_deces;
		pere = p.pere;
		mere = p.mere;
		listUnions= p.listUnions;

	}

	public Personne(String str_nom, String str_prenom, Genre enum_genre, Date date_naissance) {
		super();
		this.str_nom = str_nom;
		this.str_prenom = str_prenom;
		this.enum_genre = enum_genre;
		this.date_naissance = date_naissance;
		this.date_deces = null;
		this.pere = null;
		this.mere = null;
		this.listUnions = null;
	}


	@Override
	public String toString() {

		String result = "";


		//		private String str_nom;
		//		private String str_prenom;
		//		private Genre enum_genre;
		//		private Date date_naissance;
		//		private Date date_deces;
		//		private Personne pere;
		//		private Personne mere;
		//		private List<Unions> listUnions= new Vector<>();

		result = "Personne [" + "\n" + "   Nom = " + getStr_nom() + ", Prenom = " + getStr_prenom() + ", Sexe = "
				+ getEnum_genre() + ", Date_naissance = " + getDate_naissance() + ", Date_deces = "
				+ getDate_deces() + "\n" + "   Pere = " + getPere() + "\n" + "   Mere = " + getMere();

		List<Unions> lU = this.getListUnions();
		if (lU != null) {
			for (Unions uneUnion : lU) {
				if (uneUnion != null)
					result = result + uneUnion.toString() + "\n" ;
				else break;
			}
		}

		result = result + "]";

		return result ;
	}

	
	
	
	//Meurt => OK
	public void meurt(Date dateDeDeces) {
		this.setDate_deces(dateDeDeces);

		List<Unions> lU = this.getListUnions();
		if (lU != null) {	
			//c'est la dernière union qu'il faut traiter
			Unions lUAtraiter = (Unions)lU.get(lU.size()-1);
			lUAtraiter.setDate_fin(dateDeDeces);
		}

		//liste des unions de la personne
		List<Unions> lUC = this.getListUnions();
		if (lUC != null) {
			//c'est la dernière union qu'il faut traiter
			Unions unionsThisATraiter = (Unions)lUC.get(lUC.size()-1);
			//la personne qui était en union avec cette personne lors de son décès
			Personne p2 = unionsThisATraiter.getlAutre();
			//liste des unions de la personne p2
			List<Unions> unionsP2ATraiter = p2.getListUnions();
			if (unionsP2ATraiter != null) {	
				//dernière union de la personne P2
				Unions derniereUnionsP2ATraiter = (Unions)unionsP2ATraiter.get(unionsP2ATraiter.size()-1);
				derniereUnionsP2ATraiter.setDate_fin(dateDeDeces);
			}
		}

	}

/*
	@Override
	public String toString() {
		return "Personne [str_nom=" + str_nom + ", str_prenom=" + str_prenom + ", enum_genre=" + enum_genre
				+ ", date_naissance=" + date_naissance + ", date_deces=" + date_deces + ", pere=" + pere + ", mere="
				+ mere + ", listUnions=" + listUnions + "]";
	}
	*/
	
	//Changer de sexe => OK
	public void changerDeSexe(Genre genre) {
		this.setEnum_genre(genre);
	}

	//A un enfant => OK
	public void aUnEnfant(Personne conjoint, Personne unEnfant) {

		List<Unions> lU = this.getListUnions();
		if (lU == null) lU = new Vector();
		for (Unions unions : lU) {
			if (unions.getlAutre() == conjoint) {
				List<Personne> lP = unions.getListEnfants();
				if (lP == null) lP = new Vector();
				SetGenre(this, conjoint, unEnfant);
				Personne pTemp = new Personne(unEnfant);
				lP.add(pTemp);
				unions.setListEnfants(lP);
			}
		}
		
		List<Unions> lUC = conjoint.getListUnions();
		if (lUC == null) lUC = new Vector();
		for (Unions unionsC : lUC) {
			if (unionsC.getlAutre() == this) {
				List<Personne> lPC = unionsC.getListEnfants();
				if (lPC == null) lPC = new Vector();
				SetGenre(this, conjoint, unEnfant);
				Personne pTemp = new Personne(unEnfant);
				lPC.add(pTemp); 
				unionsC.setListEnfants(lPC);
			}
		}
		
	} 
	
		
	public void SetGenre(Personne obj, Personne conjoint, Personne unEnfant) {
		if (obj.getEnum_genre()== Genre.homme) {
			unEnfant.setPere(obj);
			unEnfant.setMere(conjoint);
		}
		else {
			unEnfant.setMere(obj);
			unEnfant.setPere(conjoint);
		}
	}

	//Se marie => OK
	public void seMarie(Personne sonConjoint, Date dateCeremonie) {

		//private List<Unions> listUnions= new Vector<>();
		List<Unions> lU = this.getListUnions();
		if (lU != null)
			lU.add(new Unions(sonConjoint, dateCeremonie));
		else {
			Unions uTemp = new Unions(sonConjoint, dateCeremonie);
			lU = new Vector<>();
			lU.add(uTemp);
			this.setListUnions(lU);	
		}

		List<Unions> lUConjoint = sonConjoint.getListUnions();
		if (lUConjoint != null)
			lUConjoint.add(new Unions(this, dateCeremonie));
		else {
			Unions uTemp2 = new Unions(this, dateCeremonie);
			lUConjoint = new Vector<>();
			lUConjoint.add(uTemp2);
			sonConjoint.setListUnions(lUConjoint);	
		}
	}


	//Divorce  => OK
	public void divorce(Personne sonConjoint, Date dateFin) {

		List<Unions> lU = this.getListUnions();
		if (lU != null)
			for (Unions unions : lU) {
				if (unions.getlAutre() == sonConjoint)
					unions.setDate_fin(dateFin);
			}

		List<Unions> lUConjoint = sonConjoint.getListUnions();
		if (lUConjoint != null)
			for (Unions unionsC : lUConjoint) {
				if (unionsC.getlAutre() == this)
					unionsC.setDate_fin(dateFin);
			}

	}

}



