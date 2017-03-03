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
 * WizardDemoPage1
 * <p>
 * Custom Wizard page for the purposes of this demo.
 * 
 * @see <a href="http://help.eclipse.org/luna/index.jsp?topic=%2Forg.eclipse.platform.doc.isv%2Freference%2Fapi%2Forg%2Feclipse%2Fjface%2Fwizard%2Fpackage-summary.html" >Eclipse API, WizardPage</a>
 */
public class WizardDemoPage1 extends WizardPage
{
	//***CONTROLS***
	private Composite container;
	public Button button2A;
	private Button button2B;
	
	//***VARIABLES***
	private int offsetY;
	private int offsetX;
	
	public WizardDemoPage1()
	{
		super("Wizard Demo Page 1");
		setTitle("Wizard Demo Page 1 Title");
		setDescription("Wizard Demo Page 1 Description");
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
		button2A = new Button(container, SWT.CHECK);
		button2B = new Button(container, SWT.CHECK);
		
		//***SET TEXT***
		button2A.setText("See Wizard Page 2A");
		button2B.setText("See Wizard Page 2B");
		
		//***SET LISTENERS***
		button2A.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent event)
			{
				//Un-Checks the other button (button2B) if this one (button2A) is selected.
				button2B.setSelection(false);
				setPageComplete(true);
			}
		});
		
		button2B.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent event)
			{
				//Un-Checks the other button (button2A) if this one (button2B) is selected.
				button2A.setSelection(false);
				setPageComplete(true);
			}
		});
		
		//***SET LAYOUT***
		offsetY = -button2A.computeSize(SWT.DEFAULT, SWT.DEFAULT).y / 2;
		offsetX = -button2A.computeSize(SWT.DEFAULT, SWT.DEFAULT).x / 2;
		
		FormLayout layout = new FormLayout();
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		container.setLayout(layout);
		
		FormData fd = new FormData();
		fd.top = new FormAttachment(50,offsetY);
		fd.left = new FormAttachment(50,offsetX);
		button2A.setLayoutData(fd);
		
		fd = new FormData();
		fd.top = new FormAttachment(button2A, 5);
		fd.left = new FormAttachment(50,offsetX);
		button2B.setLayoutData(fd);
		
		setControl(container); 
		setPageComplete(false); 
	}
	
	/**
	 * Checks if the Button "2A" has been checked.
	 * 
	 * @return True if Button "2A" has been checked.
	 */
	public boolean isButton2AChecked()
	{
		return button2A.getSelection();
	}
	
	/**
	 * Checks if the Button "2B" has been checked.
	 * 
	 * @return True if Button "2B" has been checked.
	 */
	public boolean isButton2BChecked()
	{
		return button2B.getSelection();
	}
	
}
