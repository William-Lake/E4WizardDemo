package wizard.pages;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * WizardDemoPage2A
 * <p>
 * Custom Wizard page for the purposes of this demo.
 * 
 * @see <a href="http://help.eclipse.org/luna/index.jsp?topic=%2Forg.eclipse.platform.doc.isv%2Freference%2Fapi%2Forg%2Feclipse%2Fjface%2Fwizard%2Fpackage-summary.html" >Eclipse API, WizardPage</a>
 */
public class WizardDemoPage2A extends WizardPage
{
	
	//***CONTROLS***
	private Composite container;
	private Button button;
	
	//***VARIABLES***
	private int offsetY;
	private int offsetX;
	
	public WizardDemoPage2A()
	{
		super("Wizard Demo Page 2A");
		setTitle("Wizard Demo Page 2A Title");
		setDescription("Wizard Demo Page 2A Description");
	}
	
	/**
	 * Creates the WizardPage UI.
	 * 
	 * @param parent
	 * 			The Composite object that the Wizard's UI is built upon.
	 */
	@Override
	public void createControl(Composite parent)
	{
		//***INSTANTIATE CONTROLS***
		container = new Composite(parent, SWT.NONE);
		button = new Button(container, SWT.CHECK);
		
		//***SET TEXT***
		button.setText("Check to Finish");
		
		//***LISTENERS***
		button.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent event)
			{
				setPageComplete(true);
				getWizard().getContainer().updateButtons();
			}
		});
		
		//***SET LAYOUT***
		offsetY = -button.computeSize(SWT.DEFAULT, SWT.DEFAULT).y / 2;
		offsetX = -button.computeSize(SWT.DEFAULT, SWT.DEFAULT).x / 2;
		
		FormLayout layout = new FormLayout();
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		container.setLayout(layout);
		
		FormData fd = new FormData();
		fd.top = new FormAttachment(50,offsetY);
		fd.left = new FormAttachment(50,offsetX);
		button.setLayoutData(fd);
		
		setControl(container); 
		setPageComplete(false);
	}
	
}
