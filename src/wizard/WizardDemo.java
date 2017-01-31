/**
 * Wizard : WizardDemo
 * 
 * This class is your custom build of the General Wizard class.
 * 
 * It acts as the parent and organizer of your WizardPage classes.
 */

package wizard;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;

import wizard.pages.WizardDemoPage1;
import wizard.pages.WizardDemoPage2A;
import wizard.pages.WizardDemoPage2B;

public class WizardDemo extends Wizard
{
	/**
	 * Custom WizardPage objects added first.
	 */
	protected WizardDemoPage1 page1;
	protected WizardDemoPage2A page2A;
	protected WizardDemoPage2B page2B;
	
	public WizardDemo()
	{
		super();
	}
	
	/**
	 * Custom WizardPage objects instantiated here,
	 * 	and then added to the overall Wizard via the addPage() method.
	 */
	@Override
	public void addPages()
	{
		page1 = new WizardDemoPage1();
		page2A = new WizardDemoPage2A();
		page2B = new WizardDemoPage2B();
		addPage(page1);
		addPage(page2A);
		addPage(page2B);
	}
	
	/**
	 * Serves up the next page in the Wizard when you press the "Next" button.
	 * This method allows you to add logic to determine which page to serve up next. 
	 */
	@Override
	public IWizardPage getNextPage(IWizardPage currentPage)
	{
		if (currentPage.equals(page1))
		{
			if ( ( (WizardDemoPage1) currentPage).isButton2AChecked() )
			{
				return page2A;
			} else if ( ( (WizardDemoPage1) currentPage).isButton2BChecked() )
			{
				return page2B;
			}
		}
		
		return null;
	}
	
	/**
	 * Determines whether or not to enable the Wizard's "Finish" button.
	 * This method is where you to add logic to determine this.
	 */
	@Override
	public boolean canFinish()
	{
		if (!getContainer().getCurrentPage().equals(page1)) return getContainer().getCurrentPage().isPageComplete();
		return false;
	}
	
	/**
	 * This method is where you to add code to be executed before the wizard closes.
	 */
	@Override
	public boolean performFinish()
	{
		return true;
	}
	
}
