 /**Handler : OpenWizard
  * 
  * This class is associated with the handler named "Open Wizard" in the 
  * 	Application.e4xmi.
  * 
  * This class is ran when it's associated command is triggered.
  * 	(See the "ButtonHolder" Class in the "composites" package, lines 71-92)
  * 
  * This class is tied to a command on it's handler page in the Application.e4xmi via the "Command" field.
  * This class is tied to it's associated handler in the Application.e4xmi via the "Class URI" field.
  */
package handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;

import wizard.WizardDemo;

public class OpenWizard {
	
	/**
	 * When initially generated via the "Class URI" link in the Application.e4xmi
	 * 		for this handler, the execute method does not come with a parameter.
	 * The addition of one adds some functionality.
	 * The specific parameters here tell the application two things at runtime:
	 * 		1) An object of type Shell needs to be found before this method
	 * 			is allowed to run. If not found, this method will not be
	 * 			executed.
	 * 		2) The object to be found can be located using the name
	 * 			indicated by the "@Named" annotation, and is the only Shell
	 * 			object allowed.
	 * The constant used via IServiceConstants represents the name of the current
	 * 		active shell. It is one of four constants accessible via
	 * 		IServiceConstants. The others are ACTIVE_CONTEXT, ACTIVE_PART,
	 * 		and ACTIVE_SELECTION.
	 * The "@Execute" annotation tells the application what methods should be executed
	 * 		when this handler is triggered by it's command.
	 * @param shell
	 */
	
	@Execute 
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) 
	{
		/**
		 * The WizardDialog is what hosts your custom WizardObject.
		 * It needs a shell object (hence why the active one was passed in),
		 * 		as well as a new instantiation of your custom wizard object.
		 * The custom Wizard object for this project is named "WizardDemo"
		 * 		and can be found in the "wizard" package.
		 */
		WizardDialog dialog = new WizardDialog(shell, new WizardDemo());
		dialog.open();
	}
		
}