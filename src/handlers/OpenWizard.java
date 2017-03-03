package handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;

import wizard.WizardDemo;

/**
 * OpenWizard
 * <p>
 * Custom Handler, starts the Wizard when called.
 * 
 * @see 
 */
public class OpenWizard {
	
	/**
	 * Creates and displays the Wizard.
	 * 
	 * @param shell
	 * 			The shell currently used by the app, as defined by the IServiceConstant "ACTIVE_SHELL".
	 */
	@Execute 
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) 
	{
		WizardDialog dialog = new WizardDialog(shell, new WizardDemo());
		dialog.open();
	}
		
}