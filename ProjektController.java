package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;

import model.ModelZaposlenik;

public class ProjektController {

	//DEFINIRANJE LISTE
	ArrayList<ModelZaposlenik> listaZaposlenika = new ArrayList<>();
	
	
	
	
	//UNOS NOVOG ZAPOSLENIKA
	public void unesiZaposlenika(String ime, String prezime, String spol,int danRodjenja,
								int mjesecRodjenja, int godinaRodjenja, String oib,String strucnaSprema,
								double mjesecnaPlaca, String pozicija){
		
		ModelZaposlenik model = new ModelZaposlenik();
		
		model.setImeZaposlenika(ime);
		model.setPrezimeZaposlenika(prezime);
		model.setSpolZaposlenika(spol);
		model.setOibZaposlenika(oib);
		model.setDanRodjenja(danRodjenja);
		model.setMjesecRodjenja(mjesecRodjenja);
		model.setGodinaRodjenja(godinaRodjenja);
		model.setStrucnaSpremaZaposlenika(strucnaSprema);
		model.setMjesecnaPlaca(mjesecnaPlaca);
		model.setPozicijaUTvrtki(pozicija);
		
		listaZaposlenika.add(model);
		
	}
	
	//SPREMANJE U DATOTEKU
	public void spremi () {
		try {
				FileOutputStream upisUDatoteku = new FileOutputStream("zaposlenici.dat"); 
				ObjectOutputStream upisObjekta = new ObjectOutputStream(upisUDatoteku);
				upisObjekta.writeObject (listaZaposlenika);
				upisObjekta.close();
			
		}
		
		catch (IOException e){
			
				e.printStackTrace();
			}
	}
	
	//CITANJE IZ DATOTEKE
	public void ucitaj () {
		try {
			FileInputStream citanjeDatoteke = new FileInputStream("zaposlenici.dat");
			
			if (citanjeDatoteke.available() > 0) {
				
				ObjectInputStream citajObjekt = new ObjectInputStream (citanjeDatoteke);
				listaZaposlenika = (ArrayList<ModelZaposlenik>) citajObjekt.readObject(); 
				citajObjekt.close();
				
				
				
			}
		}
		
		catch (ClassNotFoundException e){
			
			e.printStackTrace();
			
		}
		
		catch (IOException e){
			e.printStackTrace();
			}
	}


	//ISPIS
	public String ispis(){
		
		String ispis = "";
		int index = 0;
		int redniBroj = 1;
		
		ucitaj();
		
		for(index=0; index<listaZaposlenika.size(); index++){
			
			ispis = ispis + "Redni broj u listi: " + redniBroj + "\n" + 
					"Ime: " + listaZaposlenika.get(index).getImeZaposlenika() + "\n" + 
					"Prezime: " + listaZaposlenika.get(index).getPrezimeZaposlenika() + "\n" + 
					"Spol: " + listaZaposlenika.get(index).getSpolZaposlenika() + "\n" + 
					"OIB: " +listaZaposlenika.get(index).getOibZaposlenika() + "\n" + 
					"Datum rodjenja: " + listaZaposlenika.get(index).getDanRodjenja() + "." + 
					listaZaposlenika.get(index).getMjesecRodjenja() + "." + listaZaposlenika.get(index).getGodinaRodjenja() + "." + "\n" + 
					"Strucna sprema zaposlenika: " +listaZaposlenika.get(index).getStrucnaSpremaZaposlenika() + "\n" +
					"Pozicija u tvrki: " + listaZaposlenika.get(index).getPozicijaUTvrtki() + "\n" + 
					"Mjesecna placa: " + listaZaposlenika.get(index).getMjesecnaPlaca() + "\n\n";
			
			redniBroj++;
		}
		
		return ispis;
		
	}
	
	//BRISANJE SVIH PODATAKA IZ LISTE
	public void izbrisiSve(){
		
		ucitaj();
		
		listaZaposlenika.clear();
		
		spremi();
	}
	
	//BRISANJE ODREDJENOG ZAPOSLENIKA IZ LISTE
	public void izbrisiZaposlenika(int brojZaposlenika){
		
		int pravibrojzaposlenika = -1;
		
		ucitaj();
		
		pravibrojzaposlenika = brojZaposlenika - 1;
		
		listaZaposlenika.remove(pravibrojzaposlenika);
		
		spremi();
		
	}
	
	//ZAMJENA PODATAKA
	public void zamjenaPodataka(int brojZaposlenika, String ime, String prezime, String spol,int danRodjenja,
			int mjesecRodjenja, int godinaRodjenja, String oib,String strucnaSprema,
			double mjesecnaPlaca, String pozicija){
		
		int index = 0;
		
		ucitaj();
		
		index = brojZaposlenika;
		

		listaZaposlenika.get(index).setImeZaposlenika(ime);
		listaZaposlenika.get(index).setPrezimeZaposlenika(prezime);
		listaZaposlenika.get(index).setSpolZaposlenika(spol);
		listaZaposlenika.get(index).setOibZaposlenika(oib);
		listaZaposlenika.get(index).setDanRodjenja(Integer.valueOf(danRodjenja));
		listaZaposlenika.get(index).setMjesecRodjenja(Integer.valueOf(mjesecRodjenja));
		listaZaposlenika.get(index).setGodinaRodjenja(Integer.valueOf(godinaRodjenja));
		listaZaposlenika.get(index).setStrucnaSpremaZaposlenika(strucnaSprema);
		listaZaposlenika.get(index).setPozicijaUTvrtki(pozicija);
		listaZaposlenika.get(index).setMjesecnaPlaca(mjesecnaPlaca);
			
		
		spremi();
		
		
	}
	
	//TRAZI ZAPOSLENIKA
	public String traziZaposlenika(int odabirTrazenja, String osobina){
		
		String rezultat = "";
		int index = 0;
		String provjera = "";
		int brojPogodaka = 0;
		
		ucitaj();
			
			if(odabirTrazenja == 0) //TRAZENJE PREMA IMENU
				{
					
					for(index=0; index<listaZaposlenika.size(); index++){
						
						provjera = listaZaposlenika.get(index).getImeZaposlenika();
						
						if(provjera.equals(osobina)){
							
							rezultat = rezultat + "Ime: " + listaZaposlenika.get(index).getImeZaposlenika() + "\n" + 
									"Prezime: " + listaZaposlenika.get(index).getPrezimeZaposlenika() + "\n" + 
									"Spol: " + listaZaposlenika.get(index).getSpolZaposlenika() + "\n" + 
									"OIB: " +listaZaposlenika.get(index).getOibZaposlenika() + "\n" + 
									"Datum rodjenja: " + listaZaposlenika.get(index).getDanRodjenja() + "." + 
									listaZaposlenika.get(index).getMjesecRodjenja() + "." + listaZaposlenika.get(index).getGodinaRodjenja() + "." + "\n" + 
									"Strucna sprema zaposlenika: " +listaZaposlenika.get(index).getStrucnaSpremaZaposlenika() + "\n" +
									"Pozicija u tvrki: " + listaZaposlenika.get(index).getPozicijaUTvrtki() + "\n" + 
									"Mjesecna placa: " + listaZaposlenika.get(index).getMjesecnaPlaca() + " \n\n";
							
							brojPogodaka++;
							
						}
					}
					
					if(brojPogodaka == 0){
						
						rezultat = "U listi ne postoji zaposlenik sa imenom: " + osobina;
					}
				
				}
				
			if(odabirTrazenja == 1) //TRAZENJE PREMA PREZIMENU
				{
					
					for(index=0; index<listaZaposlenika.size(); index++){
						
						provjera = listaZaposlenika.get(index).getPrezimeZaposlenika();
						
						if(provjera.equals(osobina)){
							
							rezultat = rezultat + "Ime: " + listaZaposlenika.get(index).getImeZaposlenika() + "\n" + 
									"Prezime: " + listaZaposlenika.get(index).getPrezimeZaposlenika() + "\n" + 
									"Spol: " + listaZaposlenika.get(index).getSpolZaposlenika() + "\n" + 
									"OIB: " +listaZaposlenika.get(index).getOibZaposlenika() + "\n" + 
									"Datum rodjenja: " + listaZaposlenika.get(index).getDanRodjenja() + "." + 
									listaZaposlenika.get(index).getMjesecRodjenja() + "." + listaZaposlenika.get(index).getGodinaRodjenja() + "." + "\n" +
									"Strucna sprema zaposlenika: " +listaZaposlenika.get(index).getStrucnaSpremaZaposlenika() + "\n" +
									"Pozicija u tvrki: " + listaZaposlenika.get(index).getPozicijaUTvrtki() + "\n" + 
									"Mjesecna placa: " + listaZaposlenika.get(index).getMjesecnaPlaca() + " \n\n";
							
							brojPogodaka++;
							
						}
					}
					
					if(brojPogodaka == 0){
						
						rezultat = "U listi ne postoji zaposlenik sa prezimenom: " + osobina;
					}
					
				}
				
			if(odabirTrazenja == 2) //TRAZENJE PREMA SPOLU
				{
					for(index=0; index<listaZaposlenika.size(); index++){
						
						provjera = listaZaposlenika.get(index).getSpolZaposlenika();
						
						if(provjera.equals(osobina)){
							
							rezultat = rezultat + "Ime: " + listaZaposlenika.get(index).getImeZaposlenika() + "\n" + 
									"Prezime: " + listaZaposlenika.get(index).getPrezimeZaposlenika() + "\n" + 
									"Spol: " + listaZaposlenika.get(index).getSpolZaposlenika() + "\n" + 
									"OIB: " +listaZaposlenika.get(index).getOibZaposlenika() + "\n" + 
									"Datum rodjenja: " + listaZaposlenika.get(index).getDanRodjenja() + "." + 
									listaZaposlenika.get(index).getMjesecRodjenja() + "." + listaZaposlenika.get(index).getGodinaRodjenja() + "." + "\n" +
									"Strucna sprema zaposlenika: " +listaZaposlenika.get(index).getStrucnaSpremaZaposlenika() + "\n" +
									"Pozicija u tvrki: " + listaZaposlenika.get(index).getPozicijaUTvrtki() + "\n" + 
									"Mjesecna placa: " + listaZaposlenika.get(index).getMjesecnaPlaca() + " \n\n";
							
							brojPogodaka++;
							
						}
					}
					
					if(brojPogodaka == 0){
						
						rezultat = "U listi ne postoji zaposlenik sa spolom: " + osobina;
					}
					
					
				}
			
			if(odabirTrazenja == 3) //TRAZENJE PREMA STRUCNOJ SPREMI
				{
						for(index=0; index<listaZaposlenika.size(); index++){
						
						provjera = listaZaposlenika.get(index).getStrucnaSpremaZaposlenika();
						
						if(provjera.equals(osobina)){
							
							rezultat = rezultat + "Ime: " + listaZaposlenika.get(index).getImeZaposlenika() + "\n" + 
									"Prezime: " + listaZaposlenika.get(index).getPrezimeZaposlenika() + "\n" + 
									"Spol: " + listaZaposlenika.get(index).getSpolZaposlenika() + "\n" + 
									"OIB: " +listaZaposlenika.get(index).getOibZaposlenika() + "\n" + 
									"Datum rodjenja: " + listaZaposlenika.get(index).getDanRodjenja() + "." + 
									listaZaposlenika.get(index).getMjesecRodjenja() + "." + listaZaposlenika.get(index).getGodinaRodjenja() + "." + "\n" +
									"Strucna sprema zaposlenika: " +listaZaposlenika.get(index).getStrucnaSpremaZaposlenika() + "\n" +
									"Pozicija u tvrki: " + listaZaposlenika.get(index).getPozicijaUTvrtki() + "\n" + 
									"Mjesecna placa: " + listaZaposlenika.get(index).getMjesecnaPlaca() + " \n\n";
							
							brojPogodaka++;
							
						}
					}
					
					if(brojPogodaka == 0){
						
						rezultat = "U listi ne postoji zaposlenik sa Strucnom spremom: " + osobina;
					}
					
				}
				
		return rezultat;
		
	}
	
	
	public ArrayList<ModelZaposlenik> vratiListu(){
		
		ucitaj();
		
		return listaZaposlenika;
	}
}