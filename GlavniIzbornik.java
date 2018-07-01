package view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import controller.ProjektController;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class GlavniIzbornik {

	ProjektController controller = new ProjektController();
	
	
	
	protected Shell shlGlavniIzbronik;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GlavniIzbornik window = new GlavniIzbornik();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlGlavniIzbronik.open();
		shlGlavniIzbronik.layout();
		while (!shlGlavniIzbronik.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlGlavniIzbronik = new Shell();
		shlGlavniIzbronik.setSize(300, 299);
		shlGlavniIzbronik.setText("Glavni izbornik");
		
		MessageBox msgObavijest = new MessageBox(shlGlavniIzbronik, SWT.OK);
		
		Label lblTvrtkaDd = new Label(shlGlavniIzbronik, SWT.NONE);
		lblTvrtkaDd.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		lblTvrtkaDd.setBounds(96, 10, 85, 25);
		lblTvrtkaDd.setText("Tvrtka d.d.");
		
		Button btnKreirajNovogZaposlenika = new Button(shlGlavniIzbronik, SWT.NONE);
		btnKreirajNovogZaposlenika.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				controller.ucitaj();
				
				DialogKreirajZaposlenika dlgKreirajZaposlenika = new DialogKreirajZaposlenika(shlGlavniIzbronik,SWT.DIALOG_TRIM);
				dlgKreirajZaposlenika.setController(controller);
				dlgKreirajZaposlenika.open();
				
			}
		});
		btnKreirajNovogZaposlenika.setBounds(10, 53, 264, 35);
		btnKreirajNovogZaposlenika.setText("Kreiraj novog zaposlenika");
		
		Button btnIspisiSveZaposlenike = new Button(shlGlavniIzbronik, SWT.NONE);
		btnIspisiSveZaposlenike.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			
				controller.ucitaj();
				
				if(controller.vratiListu().isEmpty() == true){
	
				msgObavijest.setMessage("Lista je prazna, unesite novog zaposlenika!");
				msgObavijest.setText("Obavijest");
				msgObavijest.open();
				
				}
				else{
				
				DialogIspisiZaposlenike dlgIspisiZaposlenike = new DialogIspisiZaposlenike(shlGlavniIzbronik,SWT.DIALOG_TRIM);
				dlgIspisiZaposlenike.setController(controller);
				dlgIspisiZaposlenike.open();
				
				}
				
			}
		});
		btnIspisiSveZaposlenike.setBounds(10, 95, 264, 35);
		btnIspisiSveZaposlenike.setText("Ispisi sve zaposlenike");
		
		Button btnPretraziZaposlenika = new Button(shlGlavniIzbronik, SWT.NONE);
		btnPretraziZaposlenika.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				controller.ucitaj();
				
				if(controller.vratiListu().isEmpty() == true){
					
					msgObavijest.setMessage("Lista je prazna, unesite novog zaposlenika!");
					msgObavijest.setText("Obavijest");
					msgObavijest.open();
					
				}
				else{
					
				
				DialogTraziZaposlenika dlgTrazi = new DialogTraziZaposlenika(shlGlavniIzbronik, SWT.DIALOG_TRIM);
				dlgTrazi.setController(controller);
				dlgTrazi.open();
				
				}
				
			}
		});
		btnPretraziZaposlenika.setBounds(10, 136, 264, 35);
		btnPretraziZaposlenika.setText("Pretrazi zaposlenika");
		
		Button btnIzlaz = new Button(shlGlavniIzbronik, SWT.NONE);
		btnIzlaz.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				shlGlavniIzbronik.close();
			}
		});
		btnIzlaz.setBounds(10, 208, 264, 35);
		btnIzlaz.setText("Izlaz");

	}
}
