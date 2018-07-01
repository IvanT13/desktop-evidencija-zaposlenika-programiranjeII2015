package view;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import controller.ProjektController;

public class DialogBrisanjeZaposlenika extends Dialog {

	protected Object result;
	protected Shell shlBrisanjeZaposlenika;
	private Text txtBroj;
	
	ProjektController controller4 = new ProjektController();
	private Button btnZavrsi;
	
	public void setController(ProjektController controll){
		
		this.controller4 = controll;
	}

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public DialogBrisanjeZaposlenika(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlBrisanjeZaposlenika.open();
		shlBrisanjeZaposlenika.layout();
		Display display = getParent().getDisplay();
		while (!shlBrisanjeZaposlenika.isDisposed()) {
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
		shlBrisanjeZaposlenika = new Shell(getParent(), getStyle());
		shlBrisanjeZaposlenika.setSize(317, 140);
		shlBrisanjeZaposlenika.setText("Brisanje zaposlenika");
		
		Label lblPoruka = new Label(shlBrisanjeZaposlenika, SWT.NONE);
		lblPoruka.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblPoruka.setBounds(10, 10, 299, 17);
		lblPoruka.setText("Unesite redni broj zaposlenika kojeg zelite izbrisati:");
		
		txtBroj = new Text(shlBrisanjeZaposlenika, SWT.BORDER);
		txtBroj.setBounds(10, 33, 138, 23);
		txtBroj.setText("");
		
		MessageBox msgObavijest = new MessageBox(shlBrisanjeZaposlenika,SWT.OK);
		
		Button btnPotvrdi = new Button(shlBrisanjeZaposlenika, SWT.NONE);
		btnPotvrdi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				String brojZaposlenikaP = "";
				
				brojZaposlenikaP = txtBroj.getText();
				
				
				if(brojZaposlenikaP.trim().equals("")){
					
					msgObavijest.setText("Greska!");
					msgObavijest.setMessage("Polje mora biti popunjeno");
					msgObavijest.open();
				}
				else
				{
					int brojZaposlenika = -1;
					int provjeraUnosa = -1;
					
					try{
						
					brojZaposlenika = Integer.valueOf(txtBroj.getText());
					
					}catch(NumberFormatException nfe){
						
					 msgObavijest.setText("Greska!");
					 msgObavijest.setMessage("U polje je moguce upisati samo brojeve");
					 msgObavijest.open();
					 
					 txtBroj.setText("");
					 
					 provjeraUnosa = 1;
					 
					}
					
					if(provjeraUnosa != 1){
						
						if(controller4.vratiListu().isEmpty()){
							
							msgObavijest.setText("Greska!");
							msgObavijest.setMessage("Lista je prazna ");
							msgObavijest.open();
							
							txtBroj.setText("");
							
							shlBrisanjeZaposlenika.close();
						}
					
						else if(brojZaposlenika < 1 || brojZaposlenika > controller4.vratiListu().size()){
								
								msgObavijest.setText("Greska!");
								msgObavijest.setMessage("Zaposlenik pod brojem: " + brojZaposlenika + " se ne nalazi u listi");
								msgObavijest.open();
								
								txtBroj.setText("");
								
							}
						else{
							
							
							controller4.ucitaj();
							
							
							controller4.izbrisiZaposlenika(brojZaposlenika);
							
							msgObavijest.setText("Obavijest");
							msgObavijest.setMessage("Zaposlenik izbrisan");
							msgObavijest.open();
							
							txtBroj.setText("");
							
						}
					}
					
					
				}
			}		
		});
		btnPotvrdi.setBounds(10, 62, 138, 35);
		btnPotvrdi.setText("Potvrdi");
		
		btnZavrsi = new Button(shlBrisanjeZaposlenika, SWT.NONE);
		btnZavrsi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				shlBrisanjeZaposlenika.close();
				
				
			}
		});
		btnZavrsi.setBounds(165, 62, 136, 35);
		btnZavrsi.setText("Odustani/Zavrsi");

	}
}
