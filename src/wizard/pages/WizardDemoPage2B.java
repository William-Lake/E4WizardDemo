/**
 * WizardPage : WizardDemoPage2B
 * 
 * This class contains the blueprint for your custom WizardPage.
 * 
 * It is organized almost exactly like a Part class 
 * 	(See ButtonHolder class in the Composites package for comparison),
 * 	and as such has the following similar sections:
 *  	1) Controls
 *  		Controls to be placed on the Wizard.
 *  			E.g. Any buttons, labels, etc.
 *  	2) Variables
 *  	3) Instantiate Controls
 *  		Instantiation of the controls.
 *  	4) Set Text
 *  		Setting the text for the controls.
 *  	5) Set Listeners
 *  		Adding listeners to the controls.
 *  	6) Set Layout
 *  		Where you tell the application how the controls should be visually laid out on the WizardPage.
 */

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

import wizard.WizardDemo;

public class WizardDemoPage2B extends WizardPage
{
	
	//***CONTROLS***
	private Composite container;
	private Button button;
	
	//***VARIABLES***
	private int offsetY;
	private int offsetX;
	
	/**
	 * Constructor for the WizardPage.
	 * The String in the super() method is the WizardPage's name according to the application.
	 * The String in the setTitle() method is the WizardPage's title as displayed to the user.
	 * The String in the setDescription() method is the WizardPage's description
	 * 		as displayed to the user.
	 */
	public WizardDemoPage2B()
	{
		super("Wizard Demo Page 2B");
		setTitle("Wizard Demo Page 2B Title");
		setDescription("Wizard Demo Page 2B Description");
	}
	
	/**
	 * Builds the layout of the WizardPage:
	 * 		Instantiates Controls
	 * 		Sets Control Text
	 * 		Adds Control Listeners
	 * 		Sets Control Layout
	 * 
	 * There are three important differences from typical createControl() methods in Parts:
	 * 
	 * 		[1] You need to put all of your controls on your own composite,
	 * 			NOT the composite that is passed in. 
	 * 		[2] You need to instantiate your composite using the passed in composite,
	 * 			and then set YOUR composite with the setControl() method at the end.
	 * 		[3] At the end of the createControl method you need to set the
	 * 			pageComplete() method to false.
	 */
	@Override
	public void createControl(Composite parent)
	{
		//***INSTANTIATE CONTROLS***
		container = new Composite(parent, SWT.NONE); //[1]
		button = new Button(container, SWT.CHECK);
		
		//***SET TEXT***
		button.setText("Check to Finish");
		
		//***LISTENERS***
		button.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent event)
			{
				/**
				 * The setPageComplete() method indicates to the Wizard
				 * 		whether or not this page has been completed.
				 * Once set, it allows the "Next" and/or "Finish" buttons to become
				 * 		enabled depending on the circumstances HOWEVER it
				 * 		DOES NOT enable them.
				 * The getWizard().getContainer().updateButtons() triggers enabling them.
				 * In short even if all the qualifications to enable the "Finish" button
				 * 		are met, it won't happen unless you call
				 * 		getWizard().getContainer.updateButtons()
				 */
				setPageComplete(true);
				getWizard().getContainer().updateButtons();
			}
		});
		
		//***SET LAYOUT***
		/**
		 * The offset variables are not required, simply used by the author as a personal
		 * 		preference.
		 * A layout IS required, however the specific use of FormLayout is not.
		 * Additional layout options can be found here: goo.gl/9Kr0
		 */
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
		
		setControl(container); //[2]
		setPageComplete(false); //[3]
	}
	
}
