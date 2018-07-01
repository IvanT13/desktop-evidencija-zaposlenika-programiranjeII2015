package view;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import controller.ProjektController;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Button;

public class DialogIspisiZaposlenike extends Dialog {

	protected Object result;
	protected Shell shlIspis;
	
	ProjektController controller3 = new ProjektController();
	
	public void setController(ProjektController controll){
		
		this.controller3 = controll;
	}

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public DialogIspisiZaposlenike(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlIspis.open();
		shlIspis.layout();
		Display display = getParent().getDisplay();
		while (!shlIspis.isDisposed()) {
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
		shlIspis = new Shell(getParent(), getStyle());
		shlIspis.setSize(544, 684);
		shlIspis.setText("Ispis zaposlenika");
		
		MessageBox msgObavijest = new MessageBox(shlIspis,SWT.OK);
		
		StyledText stxtIspis = new StyledText(shlIspis, SWT.BORDER | SWT.READ_ONLY | SWT.V_SCROLL);
		stxtIspis.setBounds(10, 10, 294, 635);
		stxtIspis.setAlwaysShowScrollBars(true);
		
		stxtIspis.setText(controller3.ispis()); //ISPIS PODATAKA
		
		
		
		Button btnNazad = new Button(shlIspis, SWT.NONE);
		btnNazad.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				shlIspis.close();
			}
		});
		btnNazad.setBounds(310, 610, 218, 35);
		btnNazad.setText("Nazad");
		
		Button btnZamjeniPodatkeO = new Button(shlIspis, SWT.NONE);
		btnZamjeniPodatkeO.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				boolean popunjenostListe;
				
				popunjenostListe = controller3.vratiListu().isEmpty();
				
				if(popunjenostListe == true){
					
					msgObavijest.setText("Greska!");
					msgObavijest.setMessage("Lista je prazna!");
					msgObavijest.open();
				}
				else{
					
					DialogZamjenaPodataka dlgZamjenaPodataka = new DialogZamjenaPodataka(shlIspis, SWT.DIALOG_TRIM);
					dlgZamjenaPodataka.setController(controller3);
					dlgZamjenaPodataka.open();
					
				}
				
				
				
			}
		});
		btnZamjeniPodatkeO.setBounds(310, 10, 218, 35);
		btnZamjeniPodatkeO.setText("Zamjeni podatke o zaposleniku");
		
		Button btnOcistiListuZaposlenika = new Button(shlIspis, SWT.NONE);
		btnOcistiListuZaposlenika.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				boolean popunjenostListe;
				
				popunjenostListe = controller3.vratiListu().isEmpty();
				
				if(popunjenostListe == true){
					
					msgObavijest.setText("Greska!");
					msgObavijest.setMessage("Lista je prazna!");
					msgObavijest.open();
					
					shlIspis.close();
				}
				else
				{
					controller3.izbrisiSve();
					stxtIspis.setText(controller3.ispis());
					
					msgObavijest.setText("Obavijest");
					msgObavijest.setMessage("Podatci u listi izbrisani");
					msgObavijest.open();
					
					shlIspis.close();
					
				}
				
			}
		});
		btnOcistiListuZaposlenika.setBounds(310, 303, 218, 35);
		btnOcistiListuZaposlenika.setText("Ocisti listu zaposlenika");
		
		Button btnIzbrisiZaposlenika = new Button(shlIspis, SWT.NONE);
		btnIzbrisiZaposlenika.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				boolean popunjenostListe;
				
				popunjenostListe = controller3.vratiListu().isEmpty();
				
				if(popunjenostListe == true){
					
					msgObavijest.setText("Greska!");
					msgObavijest.setMessage("Lista je prazna!");
					msgObavijest.open();
				}
				else
				{
					DialogBrisanjeZaposlenika dlgBrisanjeZaposlenika = new DialogBrisanjeZaposlenika(shlIspis,SWT.DIALOG_TRIM);
					dlgBrisanjeZaposlenika.setController(controller3);
					dlgBrisanjeZaposlenika.open();
				}
				
				
			}
		});
		btnIzbrisiZaposlenika.setBounds(310, 262, 218, 35);
		btnIzbrisiZaposlenika.setText("Izbrisi zaposlenika");
		
		Button btnOsvjezi = new Button(shlIspis, SWT.NONE);
		btnOsvjezi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				stxtIspis.setText(controller3.ispis());
				
			}
		});
		btnOsvjezi.setBounds(310, 569, 218, 35);
		btnOsvjezi.setText("Osvjezi");
		
		

	}
}
