package view;

import java.util.regex.Pattern;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import controller.ProjektController;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class DialogZamjenaPodataka extends Dialog {

	protected Object result;
	protected Shell shlZamjena;
	
	ProjektController controller5 = new ProjektController();
	
	private Text txtBrojZaposlenika;
	private Text txtIme;
	private Text txtPrezime;
	private Text txtOIB;
	private Text txtPozicija;
	private Text txtPlaca;
	
	private int  praviBrojZaposlenika = -1;
	private String brojZaposlenikaP = "";
	
	
	
	
	public void setController(ProjektController controll){
		
		this.controller5 = controll;
	}


	
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public DialogZamjenaPodataka(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlZamjena.open();
		shlZamjena.layout();
		Display display = getParent().getDisplay();
		while (!shlZamjena.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}
	
	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		
		
		shlZamjena = new Shell(getParent(), getStyle());
		shlZamjena.setSize(573, 511);
		shlZamjena.setText("Zamjena podataka");
		
		MessageBox msgObavijest = new MessageBox(shlZamjena,SWT.OK);
		
		Label lblBrojZaposlenika = new Label(shlZamjena, SWT.NONE);
		lblBrojZaposlenika.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblBrojZaposlenika.setBounds(10, 10, 384, 17);
		lblBrojZaposlenika.setText("Odaberite redni broj zaposlenika kojem zelite promjeniti podatke:");
		
		txtBrojZaposlenika = new Text(shlZamjena, SWT.BORDER);
		txtBrojZaposlenika.setBounds(400, 9, 157, 23);
		txtBrojZaposlenika.setText("");
		
		Label lblOdaberiteOsobinuKoju = new Label(shlZamjena, SWT.NONE);
		lblOdaberiteOsobinuKoju.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblOdaberiteOsobinuKoju.setBounds(10, 70, 238, 17);
		lblOdaberiteOsobinuKoju.setText("Odaberite osobine koje zelite promjeniti:");
		
		Label lblIme = new Label(shlZamjena, SWT.NONE);
		lblIme.setText("Ime:");
		lblIme.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblIme.setBounds(10, 93, 28, 20);
		
		Label lblPrezime = new Label(shlZamjena, SWT.NONE);
		lblPrezime.setText("Prezime:");
		lblPrezime.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblPrezime.setBounds(10, 132, 60, 20);
		
		Label lblSpol = new Label(shlZamjena, SWT.NONE);
		lblSpol.setText("Spol:");
		lblSpol.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblSpol.setBounds(10, 169, 33, 20);
		
		Label lblDatumRid = new Label(shlZamjena, SWT.NONE);
		lblDatumRid.setText("Datum rodjenja:");
		lblDatumRid.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblDatumRid.setBounds(11, 240, 107, 20);
		
		Label lblSS = new Label(shlZamjena, SWT.NONE);
		lblSS.setText("Strucna sprema:");
		lblSS.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblSS.setBounds(11, 273, 105, 20);
		
		Label lblPozicija = new Label(shlZamjena, SWT.NONE);
		lblPozicija.setText("Pozicija u tvrtki:");
		lblPozicija.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblPozicija.setBounds(11, 308, 102, 20);
		
		Label lblPlaca = new Label(shlZamjena, SWT.NONE);
		lblPlaca.setText("Mjesecna placa:");
		lblPlaca.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblPlaca.setBounds(11, 345, 105, 20);
		
		Label lblOIB = new Label(shlZamjena, SWT.NONE);
		lblOIB.setText("OIB:");
		lblOIB.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblOIB.setBounds(10, 205, 27, 20);
		
		txtIme = new Text(shlZamjena, SWT.BORDER);
		txtIme.setBounds(44, 94, 203, 23);
		
		txtPrezime = new Text(shlZamjena, SWT.BORDER);
		txtPrezime.setBounds(76, 133, 171, 23);
		
		Combo cmboSpol = new Combo(shlZamjena, SWT.NONE);
		cmboSpol.setItems(new String[] {"M", "Z"});
		cmboSpol.setBounds(49, 169, 91, 23);
		cmboSpol.setText("Odaberi");
		
		txtOIB = new Text(shlZamjena, SWT.BORDER);
		txtOIB.setBounds(45, 203, 203, 23);
		
		DateTime dtRodnjenje = new DateTime(shlZamjena, SWT.BORDER);
		dtRodnjenje.setYear(1996);
		dtRodnjenje.setMonth(0);
		dtRodnjenje.setDay(13);
		dtRodnjenje.setBounds(124, 240, 79, 23);
		
		Combo cmboSS = new Combo(shlZamjena, SWT.NONE);
		cmboSS.setItems(new String[] {"NKV", "KV", "VKV", "SSS", "VSS"});
		cmboSS.setBounds(122, 273, 91, 23);
		cmboSS.setText("Odaberi");
		
		txtPozicija = new Text(shlZamjena, SWT.BORDER);
		txtPozicija.setBounds(119, 308, 129, 23);
		
		txtPlaca = new Text(shlZamjena, SWT.BORDER);
		txtPlaca.setBounds(119, 346, 129, 23);
		
		Label lblSIme = new Label(shlZamjena, SWT.NONE);
		lblSIme.setText("Staro ime");
		lblSIme.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblSIme.setBounds(253, 97, 164, 20);
		
		Label lblSPrezime = new Label(shlZamjena, SWT.NONE);
		lblSPrezime.setText("Staro prezime");
		lblSPrezime.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblSPrezime.setBounds(253, 132, 164, 20);
		
		Label lblSSpol = new Label(shlZamjena, SWT.NONE);
		lblSSpol.setText("Stari spol");
		lblSSpol.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblSSpol.setBounds(146, 169, 164, 20);
		
		Label lblSOIB = new Label(shlZamjena, SWT.NONE);
		lblSOIB.setText("Stari OIB");
		lblSOIB.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblSOIB.setBounds(253, 205, 164, 20);
		
		Label lblSRodje = new Label(shlZamjena, SWT.NONE);
		lblSRodje.setText("Stari datum rodjenja");
		lblSRodje.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblSRodje.setBounds(209, 240, 164, 20);
		
		Label lblSSS = new Label(shlZamjena, SWT.NONE);
		lblSSS.setText("Stara strucna sprema");
		lblSSS.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblSSS.setBounds(219, 273, 164, 20);
		
		Label lblSPozicija = new Label(shlZamjena, SWT.NONE);
		lblSPozicija.setText("Stara pozicija u tvrtki");
		lblSPozicija.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblSPozicija.setBounds(253, 308, 164, 20);
		
		Label lblSPlaca = new Label(shlZamjena, SWT.NONE);
		lblSPlaca.setText("Stara mjesecna placa");
		lblSPlaca.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblSPlaca.setBounds(254, 349, 164, 20);
		
		Button btnProvjeri = new Button(shlZamjena, SWT.NONE);
		btnProvjeri.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				 txtIme.setText("");
				 txtPrezime.setText("");
				 cmboSpol.setText("Odaberi");
				 txtOIB.setText("");
				 cmboSS.setText("Odaberi");
				 txtPlaca.setText("");
				 txtPozicija.setText("");
				
				 brojZaposlenikaP = txtBrojZaposlenika.getText();
				
				if(brojZaposlenikaP.trim().equals("")){
					
					msgObavijest.setText("Greska!");
					msgObavijest.setMessage("Polje ne smije biti prazno!");
					msgObavijest.open();
					
				}
				else{
					
					int brojZaposlenika = -1;
					int provjeraUnosa = -1;
					
					try{
						
					
					brojZaposlenika = Integer.valueOf(txtBrojZaposlenika.getText());
					
					}catch(NumberFormatException nfe){
						
					 msgObavijest.setText("Greska!");
					 msgObavijest.setMessage("U polje je moguce upisati samo brojeve");
					 msgObavijest.open();
					 
					 txtBrojZaposlenika.setText("");
					 
					 provjeraUnosa = 1;
					 
					}
					
					if(provjeraUnosa != 1){
						
					
					praviBrojZaposlenika = brojZaposlenika -1;
					
					controller5.ucitaj();
					
					
					if(brojZaposlenika < 1 || brojZaposlenika > controller5.vratiListu().size()){
						
						txtBrojZaposlenika.setText("");
						msgObavijest.setText("Greska!");
						msgObavijest.setMessage("Zaposlenik pod brojem: " + brojZaposlenika + " se ne nalazi u listi");
						msgObavijest.open();
						brojZaposlenikaP = "";
						
						
						
					}
					else
					{
						msgObavijest.setText("Obavijest");
						msgObavijest.setMessage("Odabrali ste zaposlenika pod prezimenom: " + controller5.vratiListu().get(praviBrojZaposlenika).getPrezimeZaposlenika());
						msgObavijest.open();
						
						lblSIme.setText(controller5.vratiListu().get(praviBrojZaposlenika).getImeZaposlenika());
						lblSPrezime.setText(controller5.vratiListu().get(praviBrojZaposlenika).getPrezimeZaposlenika());
						lblSSpol.setText(controller5.vratiListu().get(praviBrojZaposlenika).getSpolZaposlenika());
						lblSOIB.setText(controller5.vratiListu().get(praviBrojZaposlenika).getOibZaposlenika());
						lblSRodje.setText(controller5.vratiListu().get(praviBrojZaposlenika).getDanRodjenja() + "." + 
										controller5.vratiListu().get(praviBrojZaposlenika).getMjesecRodjenja() + "." + 
										controller5.vratiListu().get(praviBrojZaposlenika).getGodinaRodjenja() + ".");
						
						dtRodnjenje.setDay(controller5.vratiListu().get(praviBrojZaposlenika).getDanRodjenja());
						dtRodnjenje.setMonth(controller5.vratiListu().get(praviBrojZaposlenika).getMjesecRodjenja());
						dtRodnjenje.setYear(controller5.vratiListu().get(praviBrojZaposlenika).getGodinaRodjenja());
						
						lblSSS.setText(controller5.vratiListu().get(praviBrojZaposlenika).getStrucnaSpremaZaposlenika());
						lblSPozicija.setText(controller5.vratiListu().get(praviBrojZaposlenika).getPozicijaUTvrtki());
						lblSPlaca.setText(String.valueOf(controller5.vratiListu().get(praviBrojZaposlenika).getMjesecnaPlaca()));
						
						
					}
				}
			}
		}
		});
		btnProvjeri.setBounds(400, 38, 157, 26);
		btnProvjeri.setText("Provjeri/Potvrdi zaposlenika");
		
		Button btnPotvrdiPromjenu = new Button(shlZamjena, SWT.NONE);
		btnPotvrdiPromjenu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				controller5.ucitaj();
				
				//VARIJABLE ZA PROVJERU ISPUNE I PODATAKA
				 String imeZaposlenikaP = txtIme.getText();
				 String prezimeZaposlenikaP = txtPrezime.getText(); 
				 String spolZaposlenikaP = cmboSpol.getText();
				 String oibZaposlenikaP = txtOIB.getText();
				 String strucnaSpremaZaposlenikaP = cmboSS.getText();
				 String mjesecnaPlacaP = txtPlaca.getText();
				 String pozicijaUTvrtkiP = txtPozicija.getText();
				 
				 boolean provjeraSpolaM = spolZaposlenikaP.equals("M");
				 boolean provjeraSpolaZ = spolZaposlenikaP.equals("Z");
				 
				 boolean provjeraSSNKV = strucnaSpremaZaposlenikaP.equals("NKV");
				 boolean provjeraSSKV = strucnaSpremaZaposlenikaP.equals("KV");
				 boolean provjeraSSVKV = strucnaSpremaZaposlenikaP.equals("VKV");
				 boolean provjeraSSSSS = strucnaSpremaZaposlenikaP.equals("SSS");
				 boolean provjeraSSVSS = strucnaSpremaZaposlenikaP.equals("VSS");
				 
				 int gdRodjenjaP = dtRodnjenje.getYear();
				 
				 int provjeraUnosa = -1;
				 int provjeraUnosaOib = -1;
				 int provjeraUnosaOibMsg = -1;
				 double provjeraOib = 0;
				 
				 try{
					 
					 provjeraOib = Double.valueOf(oibZaposlenikaP);
					 
				 }catch(NumberFormatException nfe){
					 
					 provjeraUnosaOibMsg = 1;
					 provjeraUnosaOib = 1;
					 
				 }
				
				 //PROVJERA ISPUNE PROVJERE ZAPOSLENIKA
				 
				 if(brojZaposlenikaP.trim().equals("")){
						
						msgObavijest.setText("Greska!");
						msgObavijest.setMessage("Polje za provjeru ne smije biti prazno ili nije izvrsena provjera!");
						msgObavijest.open();
				 
				 }
				 else{
					 
					//PROVJERA KADA POLJA NISU ISPUNJENA
					 
					 if(imeZaposlenikaP.trim().equals("")){
						 
						 txtIme.setText(controller5.vratiListu().get(praviBrojZaposlenika).getImeZaposlenika());
					 }
					 
					 if(prezimeZaposlenikaP.trim().equals("")){
						 
						 txtPrezime.setText(controller5.vratiListu().get(praviBrojZaposlenika).getPrezimeZaposlenika());
					 }
					 
					 if(spolZaposlenikaP.trim().equals("") || spolZaposlenikaP.trim().equals("Odaberi")){
						 
						 cmboSpol.setText(controller5.vratiListu().get(praviBrojZaposlenika).getSpolZaposlenika());
					 }
					
					 if(oibZaposlenikaP.trim().equals("")){
						 
						 txtOIB.setText(controller5.vratiListu().get(praviBrojZaposlenika).getOibZaposlenika());
					 }
					 
					 if(strucnaSpremaZaposlenikaP.trim().equals("") || strucnaSpremaZaposlenikaP.trim().equals("Odaberi") ){
						 
						 cmboSS.setText(controller5.vratiListu().get(praviBrojZaposlenika).getStrucnaSpremaZaposlenika());
					 }
					 
					 if(mjesecnaPlacaP.trim().equals("")){
						 
						 txtPlaca.setText(String.valueOf(controller5.vratiListu().get(praviBrojZaposlenika).getMjesecnaPlaca()));
					 }
					 
					 if(pozicijaUTvrtkiP.trim().equals("")){
						 
						 txtPozicija.setText(controller5.vratiListu().get(praviBrojZaposlenika).getPozicijaUTvrtki());
					 }
					 else{
						 
						//PROVJERA DALI SU U IME UNESENI BROJEVI
						 if(Pattern.matches("[0-9]+",imeZaposlenikaP) == true){
							 
							 msgObavijest.setText("Greska!");
							 msgObavijest.setMessage("Ime nesmije sadrzavati brojeve!");
							 msgObavijest.open();
							 txtIme.setText("");
						 }
						 //PROVJERA DALI SU U PREZIME UNESENI BROJEVI
						 else if(Pattern.matches("[0-9]+",prezimeZaposlenikaP) == true){
							 
							 msgObavijest.setText("Greska!");
							 msgObavijest.setMessage("Prezime nesmije sadrzavati brojeve!");
							 msgObavijest.open();
							 txtPrezime.setText("");
							 
						 }
						 
						//PROVJERA DALI JE OIB BROJ
						 else if(provjeraUnosaOibMsg == 1){
							 
							 msgObavijest.setText("Greska!");
							 msgObavijest.setMessage("OIB mora biti broj!");
							 msgObavijest.open();
							 txtOIB.setText("");
						 }
						 
						 //PROVJERA DALI JE OIB 11 ZNAKOVA DUZINE
						 else if(oibZaposlenikaP.trim().length() != 11){
							 
							 msgObavijest.setText("Greska!");
							 msgObavijest.setMessage("Duzina OIB-a je 11 znamenki");
							 msgObavijest.open();
							 txtOIB.setText("");
							 
						 }
						 //PROVJERA DALI JE SPOL M ILI Z
						 else if(provjeraSpolaM == false && provjeraSpolaZ == false ){
							 
							 msgObavijest.setText("Greska!");
							 msgObavijest.setMessage("Spol moze biti samo M ili Z!");
							 msgObavijest.open();
							 cmboSpol.setText("Odaberi");
							 
							 
						 }
						 //PROVJERA STRUCNE SPREME
						 else if(provjeraSSNKV == false && provjeraSSKV == false && provjeraSSVKV == false && 
								 provjeraSSSSS == false && provjeraSSVSS == false ){
							 
							 msgObavijest.setText("Greska!");
							 msgObavijest.setMessage("Strucna sprema moze biti samo: NKV, KV, VKV, SSS ili VSS"); 
							 msgObavijest.open();
							 cmboSS.setText("Odaberi");
							 
						 }
						 //PROVJERA PUNOLJETNOSTI
						 else if(gdRodjenjaP > 1997){
							 
							 msgObavijest.setText("Greska!");
							 msgObavijest.setMessage("Osoba mora biti punoljetna"); 
							 msgObavijest.open();
						 }
						 //ZAMJENA PODATAKA ZAPOSLENIKA
						 else{
							 String imeZaposlenika = txtIme.getText();
							 String prezimeZaposlenika = txtPrezime.getText(); 
							 String spolZaposlenika = cmboSpol.getText();
							 int danRodjenja = dtRodnjenje.getDay();
							 
							 int mjesecRodjenja;
							 
							 if(dtRodnjenje.getMonth() == controller5.vratiListu().get(praviBrojZaposlenika).getMjesecRodjenja()){
								 
								 mjesecRodjenja = dtRodnjenje.getMonth();
							 }
							 else{
								 
								 mjesecRodjenja = dtRodnjenje.getMonth() + 1;
							 }
							
							 int godinaRodjenja = dtRodnjenje.getYear();
							 String oibZaposlenika = txtOIB.getText();
							 String strucnaSpremaZaposlenika = cmboSS.getText();
							 double mjesecnaPlaca = 0;
							 
							 try{
								 
								 mjesecnaPlaca = Double.valueOf(txtPlaca.getText());
								 
							 }catch(NumberFormatException nfe){
						 
								 msgObavijest.setText("Greska!");
								 msgObavijest.setMessage("U polje 'Mjesecna placa' moguce je upisati samo brojeve");
								 msgObavijest.open();
						 
								 provjeraUnosa = 1;
						 
								 txtPlaca.setText("");
								 
							 }
							 
							 String pozicijaUTvrtki = txtPozicija.getText();
							 
							 if(provjeraUnosa != 1 && provjeraUnosaOib != 1 ){
								 
							 
							 
							 controller5.zamjenaPodataka(praviBrojZaposlenika, imeZaposlenika, prezimeZaposlenika, spolZaposlenika, danRodjenja, mjesecRodjenja, godinaRodjenja, 
									 oibZaposlenika, strucnaSpremaZaposlenika, mjesecnaPlaca, pozicijaUTvrtki);
							 
							 controller5.spremi();
							 
							 msgObavijest.setText("Obavijest!");
							 msgObavijest.setMessage("Podatci o zaposleniku spremljeni");
							 msgObavijest.open();
							 
							 txtIme.setText("");
							 txtPrezime.setText("");
							 cmboSpol.setText("Odaberi");
							 txtOIB.setText("");
							 cmboSS.setText("Odaberi");
							 txtPlaca.setText("");
							 txtPozicija.setText("");
							 txtBrojZaposlenika.setText("");
							 lblSIme.setText("Staro ime");
							 lblSPrezime.setText("Staro prezime");
							 lblSSpol.setText("Stari spol");
							 lblSOIB.setText("Stari OIB");
							 lblSRodje.setText("Stari datumn rodjenja");
							 lblSSS.setText("Stara strucna sprema");
							 lblSPozicija.setText("Stara pozicija u tvrtki");
							 lblSPlaca.setText("Stara mjesecna placa");
							 brojZaposlenikaP = "";
							
							  
							 }
							 
						 	}
						 
					 }
					 
					
					 
				 }
				 
		}
		});
		btnPotvrdiPromjenu.setBounds(10, 383, 384, 35);
		btnPotvrdiPromjenu.setText("Potvrdi promjenu/e");
		
		
		
		
		
		Button btnZavrsiodustani = new Button(shlZamjena, SWT.NONE);
		btnZavrsiodustani.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				shlZamjena.close();
				
			}
		});
		btnZavrsiodustani.setBounds(204, 430, 190, 35);
		btnZavrsiodustani.setText("Zavrsi/Odustani");
		
		Button btnOcistiPolja = new Button(shlZamjena, SWT.NONE);
		btnOcistiPolja.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				 txtIme.setText("");
				 txtPrezime.setText("");
				 cmboSpol.setText("Odaberi");
				 txtOIB.setText("");
				 cmboSS.setText("Odaberi");
				 txtPlaca.setText("");
				 txtPozicija.setText("");
				 txtBrojZaposlenika.setText("");
				 lblSIme.setText("Staro ime");
				 lblSPrezime.setText("Staro prezime");
				 lblSSpol.setText("Stari spol");
				 lblSOIB.setText("Stari OIB");
				 lblSRodje.setText("Stari datumn rodjenja");
				 lblSSS.setText("Stara strucna sprema");
				 lblSPozicija.setText("Stara pozicija u tvrtki");
				 lblSPlaca.setText("Stara mjesecna placa");
				 
				 				 
			}
		});
		btnOcistiPolja.setBounds(10, 430, 190, 35);
		btnOcistiPolja.setText("Ocisti polja");
		
		Button btnPomoc = new Button(shlZamjena, SWT.NONE);
		btnPomoc.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				msgObavijest.setText("Pomoc!");
				msgObavijest.setMessage("1. Odaberi zaposlenika kojem zelis promjeniti podatke i klikni na button 'Provjeri/Potvrdi zaposlenika' \n"
						+ "2. Unesi novi podataka/podatke, a one koje zelis da ostanu isti, ostavi PRAZNE \n"
						+ "3. Klikni button 'Potvrdi promjenu/e' da se ispune stari podatci \n"
						+ "4. Klikni button 'Potvrdi promjenu/e' da se spreme promjene \n");
				msgObavijest.open();
			}
		});
		btnPomoc.setBounds(10, 39, 157, 25);
		btnPomoc.setText("Pomoc");
		
		
	}
}
