package view;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import controller.ProjektController;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;

public class DialogTraziZaposlenika extends Dialog {

	protected Object result;
	protected Shell shlTrazi;

	ProjektController controller6 = new ProjektController();
	
	private Text txtOdabir;
	private Combo cmboTrazi;
	
	
	public void setController(ProjektController controll){
		
		this.controller6 = controll;
	}
	
	
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public DialogTraziZaposlenika(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlTrazi.open();
		shlTrazi.layout();
		Display display = getParent().getDisplay();
		while (!shlTrazi.isDisposed()) {
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
		shlTrazi = new Shell(getParent(), getStyle());
		shlTrazi.setSize(454, 752);
		shlTrazi.setText("Pretrazi zaposlenike");
		
		MessageBox msgObavijest = new MessageBox(shlTrazi,SWT.OK);
		
		Label lblPretraziPrema = new Label(shlTrazi, SWT.NONE);
		lblPretraziPrema.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblPretraziPrema.setBounds(10, 10, 89, 17);
		lblPretraziPrema.setText("Pretrazi prema:");
		
		Combo cmboTrazi = new Combo(shlTrazi, SWT.NONE);
		cmboTrazi.setItems(new String[] {"Ime", "Prezime", "Spol", "Strucna Sprema"});
		cmboTrazi.setBounds(10, 33, 112, 23);
		cmboTrazi.setText("Odaberi");
		
		StyledText stRezultati = new StyledText(shlTrazi, SWT.BORDER | SWT.READ_ONLY | SWT.V_SCROLL);
		stRezultati.setBounds(10, 123, 428, 547);
		
		txtOdabir = new Text(shlTrazi, SWT.BORDER);
		txtOdabir.setBounds(10, 62, 206, 23);
		txtOdabir.setVisible(true);;
		
		Button btnTrazi = new Button(shlTrazi, SWT.NONE);
		btnTrazi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				String ispis = "";
				
				String traziP = cmboTrazi.getText();
				
				if(traziP.trim().equals("") || traziP.trim().equals("Odaberi")){
					
					msgObavijest.setMessage("Odabir pretrage ne smije biti prazan");
					msgObavijest.setText("Greska!");
					msgObavijest.open();
				}
				else{
					
					boolean provjeraIme = traziP.trim().equals("Ime");
					boolean provjeraPrezime = traziP.trim().equals("Prezime");
					boolean provjeraSpol = traziP.trim().equals("Spol");
					boolean provjeraSS = traziP.equals("Strucna Sprema");
					
					
					if(provjeraIme == false && provjeraPrezime == false && provjeraSpol == false && provjeraSS == false){
						
						msgObavijest.setText("Greska!");
						msgObavijest.setMessage("Odabir pretrage može biti samo: Ime, Prezime, Spol ili Strucna Sprema");
						msgObavijest.open();
						cmboTrazi.setText("Odaberi");
						
					}
					else{
						
						String pojamPretrage = txtOdabir.getText();
						
						
						
						if(pojamPretrage.trim().equals("")){
							
							msgObavijest.setMessage("Polje za unos pretrage nesmije biti prazno");
							msgObavijest.setText("Greska!");
							msgObavijest.open();
						}
						else{
							
							String odabirPretrage = cmboTrazi.getText();
						
						if(odabirPretrage.trim().equals("Ime")){
							
							ispis = "Pretraga prema IME:\n\n" + controller6.traziZaposlenika(0, pojamPretrage);
							
							stRezultati.setText(ispis);	
						}
						else if(odabirPretrage.trim().equals("Prezime")){
							
							ispis = "Pretraga prema PREZIME:\n\n" + controller6.traziZaposlenika(1, pojamPretrage);
							
							stRezultati.setText(ispis);
						}
						else if(odabirPretrage.trim().equals("Spol")){
							
							boolean provjeraSpolaM = pojamPretrage.trim().equals("M");
							boolean provjeraSpolaZ = pojamPretrage.trim().equals("Z");
							
							if(provjeraSpolaM == false && provjeraSpolaZ == false){
								
								msgObavijest.setMessage("Unos moze biti samo: M ili Z");
								msgObavijest.setText("Greska!");
								msgObavijest.open();
								txtOdabir.setText("");
								
							}
							else{
								
								ispis = "Pretraga prema SPOL:\n\n" + controller6.traziZaposlenika(2, pojamPretrage);
								
								stRezultati.setText(ispis);
							}
							
						}
						else if(odabirPretrage.equals("Strucna Sprema")){
							
							boolean provjeraSSNKV = pojamPretrage.trim().equals("NKV");
							boolean provjeraSSKV = pojamPretrage.trim().equals("KV");
							boolean provjeraSSVKV = pojamPretrage.trim().equals("VKV");
							boolean provjeraSSSSS = pojamPretrage.trim().equals("SSS");
							boolean provjeraSSVSS = pojamPretrage.trim().equals("VSS");
							
							if(provjeraSSNKV == false && provjeraSSKV == false && provjeraSSVKV == false && provjeraSSSSS == false && provjeraSSVSS == false){
								
								msgObavijest.setMessage("Unos moze biti samo: NKV, KV, VKV, SSS ili VSS");
								msgObavijest.setText("Greska!");
								msgObavijest.open();
								txtOdabir.setText("");
							}
							else{
								
								ispis = "Pretraga prema STRUCNA SPREMA:\n\n" + controller6.traziZaposlenika(3, pojamPretrage);
								
								stRezultati.setText(ispis);
								
							}
					    }
						
						}
						
					}
					
				}
				
				
			}
		});
		btnTrazi.setBounds(10, 91, 206, 26);
		btnTrazi.setText("Trazi!");
		
		
		
		Button btnOdustaninazad = new Button(shlTrazi, SWT.NONE);
		btnOdustaninazad.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				shlTrazi.close();
			}
		});
		btnOdustaninazad.setBounds(10, 683, 428, 30);
		btnOdustaninazad.setText("Odustani/Nazad");
		
		

	}
	
}
