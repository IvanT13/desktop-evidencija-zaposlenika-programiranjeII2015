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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class DialogKreirajZaposlenika extends Dialog {
	
	protected Object result;
	protected Shell shlKreirajZaposlenika;
	private Text txtIme;
	private Text txtPrezime;
	private Text txtPozicijaUTvrtki;
	private Text txtMjesecnaPlaca;
	private Text txtOib;
	
	ProjektController controller2 = new ProjektController();
	
	public void setController(ProjektController controll){
		
		this.controller2 = controll;
	}
	
	
	
	

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public DialogKreirajZaposlenika(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlKreirajZaposlenika.open();
		shlKreirajZaposlenika.layout();
		Display display = getParent().getDisplay();
		while (!shlKreirajZaposlenika.isDisposed()) {
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
		shlKreirajZaposlenika = new Shell(getParent(), getStyle());
		shlKreirajZaposlenika.setSize(263, 476);
		shlKreirajZaposlenika.setText("Kreiraj novog zaposlenika");
		
		Label lblImeZaposlenika = new Label(shlKreirajZaposlenika, SWT.NONE);
		lblImeZaposlenika.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblImeZaposlenika.setBounds(10, 10, 28, 20);
		lblImeZaposlenika.setText("Ime:");
		
		Label lblPrezimeZaposlenika = new Label(shlKreirajZaposlenika, SWT.NONE);
		lblPrezimeZaposlenika.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblPrezimeZaposlenika.setBounds(10, 49, 60, 20);
		lblPrezimeZaposlenika.setText("Prezime:");
		
		Label lblSpolZaposlenika = new Label(shlKreirajZaposlenika, SWT.NONE);
		lblSpolZaposlenika.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblSpolZaposlenika.setBounds(10, 86, 33, 20);
		lblSpolZaposlenika.setText("Spol:");
		
		Label lblDatumRodjenja = new Label(shlKreirajZaposlenika, SWT.NONE);
		lblDatumRodjenja.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblDatumRodjenja.setBounds(11, 157, 107, 20);
		lblDatumRodjenja.setText("Datum rodjenja:");
		
		Label lblStrucnaSprema = new Label(shlKreirajZaposlenika, SWT.NONE);
		lblStrucnaSprema.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblStrucnaSprema.setBounds(11, 190, 105, 20);
		lblStrucnaSprema.setText("Strucna sprema:");
		
		Label lblPozicijaUTvrtki = new Label(shlKreirajZaposlenika, SWT.NONE);
		lblPozicijaUTvrtki.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblPozicijaUTvrtki.setBounds(11, 225, 102, 20);
		lblPozicijaUTvrtki.setText("Pozicija u tvrtki:");
		
		Label lblMjesecnaPlaca = new Label(shlKreirajZaposlenika, SWT.NONE);
		lblMjesecnaPlaca.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblMjesecnaPlaca.setBounds(11, 262, 105, 20);
		lblMjesecnaPlaca.setText("Mjesecna placa:");
		
		Label lblOib = new Label(shlKreirajZaposlenika, SWT.NONE);
		lblOib.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblOib.setBounds(10, 122, 27, 20);
		lblOib.setText("OIB:");
		
		txtIme = new Text(shlKreirajZaposlenika, SWT.BORDER);
		txtIme.setBounds(44, 11, 203, 23);
		
		txtPrezime = new Text(shlKreirajZaposlenika, SWT.BORDER);
		txtPrezime.setBounds(76, 50, 171, 23);
		
		Combo cmboSpol = new Combo(shlKreirajZaposlenika, SWT.NONE);
		cmboSpol.setItems(new String[] {"M", "Z"});
		cmboSpol.setBounds(49, 86, 91, 23);
		cmboSpol.setText("Odaberi");
		
		txtOib = new Text(shlKreirajZaposlenika, SWT.BORDER);
		txtOib.setBounds(45, 120, 203, 23);
		
		DateTime dtRodjenja = new DateTime(shlKreirajZaposlenika, SWT.BORDER);
		dtRodjenja.setBounds(124, 157, 79, 23);
		
		Combo cmboSS = new Combo(shlKreirajZaposlenika, SWT.NONE);
		cmboSS.setItems(new String[] {"NKV", "KV", "VKV", "SSS", "VSS"});
		cmboSS.setBounds(122, 190, 91, 23);
		cmboSS.setText("Odaberi");
		
		txtPozicijaUTvrtki = new Text(shlKreirajZaposlenika, SWT.BORDER);
		txtPozicijaUTvrtki.setBounds(119, 225, 129, 23);
		
		txtMjesecnaPlaca = new Text(shlKreirajZaposlenika, SWT.BORDER);
		txtMjesecnaPlaca.setBounds(119, 263, 129, 23);

		
		Button btnKreiraj = new Button(shlKreirajZaposlenika, SWT.NONE);
		btnKreiraj.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				MessageBox msgObavijest = new MessageBox(shlKreirajZaposlenika,SWT.OK);
				
				//VARIJABLE ZA PROVJERU ISPUNE I PODATAKA
				 String imeZaposlenikaP = txtIme.getText();
				 String prezimeZaposlenikaP = txtPrezime.getText(); 
				 String spolZaposlenikaP = cmboSpol.getText();
				 String oibZaposlenikaP = txtOib.getText();
				 String strucnaSpremaZaposlenikaP = cmboSS.getText();
				 String mjesecnaPlacaP = txtMjesecnaPlaca.getText();
				 String pozicijaUTvrtkiP = txtPozicijaUTvrtki.getText();
				 
				 boolean provjeraSpolaM = spolZaposlenikaP.equals("M");
				 boolean provjeraSpolaZ = spolZaposlenikaP.equals("Z");
				 
				 boolean provjeraSSNKV = strucnaSpremaZaposlenikaP.equals("NKV");
				 boolean provjeraSSKV = strucnaSpremaZaposlenikaP.equals("KV");
				 boolean provjeraSSVKV = strucnaSpremaZaposlenikaP.equals("VKV");
				 boolean provjeraSSSSS = strucnaSpremaZaposlenikaP.equals("SSS");
				 boolean provjeraSSVSS = strucnaSpremaZaposlenikaP.equals("VSS");
				 
				 int gdRodjenjaP = dtRodjenja.getYear();
				
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
				
				 //PROVJERA DALI SU POLJA ISPUNJENA
				 if(imeZaposlenikaP.trim().equals("") || prezimeZaposlenikaP.trim().equals("") || spolZaposlenikaP.trim().equals("") ||
					oibZaposlenikaP.trim().equals("") || strucnaSpremaZaposlenikaP.trim().equals("") ||  mjesecnaPlacaP.trim().equals("") ||
					pozicijaUTvrtkiP.trim().equals("")){
					 
					 msgObavijest.setText("Greska!");
					 msgObavijest.setMessage("Sva polja moraju biti popunjena");
					 msgObavijest.open();
					 
				 }
				 //PROVJERA DALI SU U IME UNESENI BROJEVI
				 else if(Pattern.matches("[0-9]+",imeZaposlenikaP) == true){
					 
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
					 txtOib.setText("");
				 }
				 
				 //PROVJERA DALI JE OIB 11 ZNAKOVA DUZINE
				 else if(oibZaposlenikaP.trim().length() != 11){
					 
					 msgObavijest.setText("Greska!");
					 msgObavijest.setMessage("Duzina OIB-a je 11 znamenki!");
					 msgObavijest.open();
					 txtOib.setText("");
					 
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
				 //KREIRANJE ZAPOSLENIKA
				 else{
					 
					 String imeZaposlenika = txtIme.getText();
					 String prezimeZaposlenika = txtPrezime.getText(); 
					 String spolZaposlenika = cmboSpol.getText();
					 int danRodjenja = dtRodjenja.getDay();
					 int mjesecRodjenja = dtRodjenja.getMonth()+ 1;
					 int godinaRodjenja = dtRodjenja.getYear();
					 String oibZaposlenika = txtOib.getText();
					 String strucnaSpremaZaposlenika = cmboSS.getText();
					 
					 double mjesecnaPlaca = 0;
					 try {
						 
						 mjesecnaPlaca = Double.valueOf(txtMjesecnaPlaca.getText());
					 }
					 catch(NumberFormatException nfe){
						 
						 msgObavijest.setText("Greska!");
						 msgObavijest.setMessage("U polje 'Mjesecna placa' moguce je upisati samo brojeve");
						 msgObavijest.open();
						 
						 provjeraUnosa = 1;
						 
						 txtMjesecnaPlaca.setText("");
					 }
					 String pozicijaUTvrtki = txtPozicijaUTvrtki.getText();
					 
					 if(provjeraUnosa != 1 && provjeraUnosaOib !=1){
						 
					 controller2.unesiZaposlenika(imeZaposlenika, prezimeZaposlenika, spolZaposlenika, 
							 danRodjenja, mjesecRodjenja, godinaRodjenja, 
							 oibZaposlenika, strucnaSpremaZaposlenika, 
							 mjesecnaPlaca, pozicijaUTvrtki);
					 
					 controller2.spremi();
					 
					 
					 msgObavijest.setMessage("Zaposlenik kreiran i spremljen");
					 msgObavijest.open();
					 
					 txtIme.setText("");
					 txtPrezime.setText("");
					 cmboSpol.setText("Odaberi");
					 txtOib.setText("");
					 cmboSS.setText("Odaberi");
					 txtMjesecnaPlaca.setText("");
					 txtPozicijaUTvrtki.setText("");
					 
					 }
					 
				 }
		
			}
			
		});
		
		btnKreiraj.setBounds(10, 299, 237, 35);
		btnKreiraj.setText("Kreiraj");
		
		Button btnOdustani = new Button(shlKreirajZaposlenika, SWT.NONE);
		btnOdustani.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				shlKreirajZaposlenika.close();
			}
		});
		btnOdustani.setBounds(10, 398, 237, 35);
		btnOdustani.setText("Odustani/Kraj unosa");
		
		
		
		
		
		
		
				
		

	}
}
