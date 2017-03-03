package wizard;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;

import wizard.pages.WizardDemoPage1;
import wizard.pages.WizardDemoPage2A;
import wizard.pages.WizardDemoPage2B;

/**
 * WizardDemo
 * <p>
 * Instantiates, houses, and serves up custom WizardPages.
 * 
 * @author William Lake
 * @see <a href="http://help.eclipse.org/luna/index.jsp?topic=%2Forg.eclipse.platform.doc.isv%2Freference%2Fapi%2Forg%2Feclipse%2Fjface%2Fwizard%2Fpackage-summary.html">Eclipse API, JFace Wizard</a>
 */
public class WizardDemo extends Wizard
{
	protected WizardDemoPage1 page1;
	protected WizardDemoPage2A page2A;
	protected WizardDemoPage2B page2B;
	
	public WizardDemo()
	{
		super();
	}
	
	/**
	 * Instantiates all custom Wizard Pages, adding them to the Wizard.
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
	 * Serves up the next page in the wizard.
	 * 
	 * If this method is not overridden, the order of pages being served up will mirror 
	 * the order they were added in the addPages() method via addPage().
	 * 
	 * Otherwise, you can use custom logic here to determine which of the added pages
	 * will be served up next. 
	 * 
	 * @param currentPage
	 * 			The current Wizard page being displayed.
	 * @return The next WizardPage to be served up.
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
	 * Determines whether the "Finish" button is enabled in the wizard.
	 * 
	 * If not overridden, the Finish button will become enabled when each 
	 * WizardPage is marked as finished via their individual 
	 * markPageComplete() methods. E.g. markPageComplete(true)
	 * 
	 * Otherwise you can insert custom logic here to determine when the 
	 * WizardPage can finish.
	 * 
	 * @return True if the wizard can finish. 
	 */
	@Override
	public boolean canFinish()
	{
		if (!getContainer().getCurrentPage().equals(page1)) return getContainer().getCurrentPage().isPageComplete();
		return false;
	}
	
	/**
	 * Performs the tasks within the method after the "Finish" button is pressed, 
	 * but before closing the Wizard.
	 * 
	 * If True is returned, the Wizard will close.
	 * 
	 * @return True if the Wizard is allowed to close.
	 */
	@Override
	public boolean performFinish()
	{
		return true;
	}
	
}
