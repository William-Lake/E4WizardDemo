/**
 * Part : ButtonHolder
 * 
 *  This class contains the blueprint for the ButtonHolder Part of the app.
 *  
 *  It is organized in the following sections:
 *  	1) Services
 *  		Services to be used by the part.
 *  			E.g. ECommandService to execute a command programmatically.
 *  	2) Controls
 *  		Controls to be placed on the part.
 *  			E.g. Any buttons, labels, etc.
 *  	3) Variables
 *  	4) Instantiate Controls
 *  		Instantiation of the controls.
 *  	5) Set Text
 *  		Setting the text for the controls.
 *  	6) Set Listeners
 *  		Adding listeners to the controls.
 *  	7) Set Layout
 *  		Where you tell the application how the controls should be visually laid out on the Part.
 *  
 *  This class is tied to it's associated part in the Application.e4xmi via the "Class URI" field therein.
 */
package composites;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class ButtonHolder {
	//***SERVICES***
	@Inject
	private ECommandService commandService;
	
	//***CONTROLS***
	private Button openWizard;
	
	//***VARIABLES***
	private int offsetY;
	private int offsetX;
	
	/**
	 * Builds the layout of the Part:
	 * 		Instantiates Controls
	 * 		Sets Control Text
	 * 		Adds Control Listeners
	 * 		Sets Control Layout
	 * @param parent
	 */
	@PostConstruct
	public void postConstruct(Composite parent) {
		//***INSTANTIATE CONTROLS***
		openWizard = new Button(parent, SWT.NONE);
		
		//***SET TEXT***
		openWizard.setText("Open Wizard");
		
		//***SET LISTENERS***
		openWizard.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent event)
			{
				try 
				{
					/**
					 * This listener executes a command from the Application.e4xmi programmatically.
					 * 		It does this by creating a Command object, pulling a command out of the 
					 * 		CommandService object from the Application.e4xmi using it's Application.e4xmi id,
					 * 		and then executing it using a new instantiation of an ExecutionEvent() 
					 * 		object as the parameter.
					 */
					@SuppressWarnings("restriction")
					Command pc = commandService.getCommand("wizarddemo.command.openwizard");
					pc.executeWithChecks(new ExecutionEvent());
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		});
		
		//***SET LAYOUT***
		/**
		 * The offset variables are not required, simply used by the author as a personal
		 * 		preference.
		 * A layout IS required, however the specific use of FormLayout is not.
		 * Additional layout options can be found here: goo.gl/9Kr0
		 */
		offsetY = -openWizard.computeSize(SWT.DEFAULT, SWT.DEFAULT).y / 2;
		offsetX = -openWizard.computeSize(SWT.DEFAULT, SWT.DEFAULT).x / 2;
		
		FormLayout layout = new FormLayout();
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		parent.setLayout(layout);
		
		FormData fd = new FormData();
		fd.top = new FormAttachment(50,offsetY);
		fd.left = new FormAttachment(50,offsetX);
		openWizard.setLayoutData(fd);
		
	}
	
}