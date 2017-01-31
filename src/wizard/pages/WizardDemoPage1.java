/**
 * WizardPage : WizardDemoPage1
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

public class WizardDemoPage1 extends WizardPage
{
	//***CONTROLS***
	private Composite container;
	public Button button2A;
	private Button button2B;
	
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
	public WizardDemoPage1()
	{
		super("Wizard Demo Page 1");
		setTitle("Wizard Demo Page 1 Title");
		setDescription("Wizard Demo Page 1 Description");
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
			}
		});
		
		button2B.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent event)
			{
				//Un-Checks the other button (button2A) if this one (button2B) is selected.
				button2A.setSelection(false);
			}
		});
		
		//***SET LAYOUT***
		/**
		 * The offset variables are not required, simply used by the author as a personal
		 * 		preference.
		 * A layout IS required, however the specific use of FormLayout is not.
		 * Additional layout options can be found here: goo.gl/9Kr0
		 */
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
		
		setControl(container); //[2]
		setPageComplete(false); //[3]
	}
	
	/**
	 * Each of these methods are custom and return a boolean value corresponding
	 * 		to whether or not their corresponding buttons have been checked.
	 * 
	 * They are used by the WizardDemo class, specifically the getNextPage() method,
	 * 		to determine which page to serve up when the "Next" button is pressed.
	 * @return
	 */
	public boolean isButton2AChecked()
	{
		return button2A.getSelection();
	}
	
	public boolean isButton2BChecked()
	{
		return button2B.getSelection();
	}
	
}
