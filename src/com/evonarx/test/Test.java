package com.evonarx.test;

import com.evonarx.enumeration.Genre;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import com.evonarx.entites.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Personne> arbre = new ArrayList<Personne>();
		
		//créer des personnes
		Personne p2 = new Personne("Vonarx", "Charles", Genre.homme, null, null, null, null, null);
		Personne p3 = new Personne("Hochmuth", "Anne", Genre.femme, null, null, null, null, null);
		p2.seMarie(p3, new Date("1970/05/01"));
//		
		Personne p1 = new Personne("Vonarx", "Eric", Genre.homme, new Date("1970/01/20"), null, p2, p3, null);
		p3.aUnEnfant(p2, p1);
		Personne p4 = new Personne("Vonarx", "Sandra", Genre.femme, new Date("1970/12/21"), null, p2, p3, null);
		p3.aUnEnfant(p2, p4);

//		p1.changerDeSexe(Genre.femme);
//		System.out.println("---Après changement de sexe----");
//		System.out.println(p1);
		
//		Date dDEric = new Date("2019/11/18");
//		p1.meurt(dDEric);
//		System.out.println("---Après décès----");
//		System.out.println(p1);

		Personne p11 = new Personne("Florance", "Viviane", Genre.femme, null, null, null, null, null);
		
		p1.seMarie(p11, new Date("2019/11/19"));
//		System.out.println("---Après mariage----");
//		System.out.println(p1);
//		System.out.println(p11);
		
		p1.divorce(p11, new Date("2019/11/20"));
//		System.out.println("---Après divorce----");
//		System.out.println(p1);
//		System.out.println(p11);
		
		Personne p5 = new Personne("Vonarx", "Charly", Genre.homme, null, null, null, null, null);
		p11.aUnEnfant(p1, p5);
//		System.out.println("---Après A un enfant----");
//		System.out.println(p1);
//		System.out.println(p11);
		
		Personne p6 = new Personne("Vonarx", "Anny", Genre.femme, null, null, null, null, null);
		p11.aUnEnfant(p1, p6);
		
//		p1.meurt(new Date("2019/11/20"));
//		System.out.println("---Après le 2ème décès----");
//		System.out.println(p1);
//		System.out.println(p11);
		
		
		Personne p7 = new Personne("Broly", "Sophie", Genre.femme, null, null, null, null, null);
		p5.seMarie(p7, new Date("2019/11/21"));
		
		Personne p8 = new Personne("Vonarx", "Bertrand", Genre.homme, null, null, null, null, null);
		
		p7.aUnEnfant(p5, p8);
		
		Personne p12 = new Personne("UneFemme", "UneFemme", Genre.femme, null, null, null, null, null);
		Personne p13 = new Personne("UnEnfant", "UnEnfant", Genre.femme, null, null, null, null, null);
		p1.seMarie(p12, new Date("2019/11/22"));
		p12.aUnEnfant(p1, p13);
		
		p1.meurt(new Date("2019/11/21"));
		
		arbre.add(p1);

		System.out.println("---Voici la liste des personnes ----");
		for (Personne personne : arbre) {
			System.out.println(personne);
		}
		
	}

}
