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

/**
 * ButtonHolder
 * <p>
 * 
 * A part for holding a button, which in turn launches a Wizard.
 */
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
	 * Builds the UI for the part.
	 * 
	 * @param parent
	 * 			The Composite object on which to build the part's UI.
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
					@SuppressWarnings("restriction")
					Command pc = commandService.getCommand("wizarddemo.command.openwizard");
					pc.executeWithChecks(new ExecutionEvent());
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		});
		
		//***SET LAYOUT***
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