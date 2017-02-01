# E4WizardDemo 
### A simple example of a wizard built using the Eclipse E4 Rich Client Platform.

----------

#### Main Page
![enter image description here](https://github.com/William-Lake/E4WizardDemo/blob/master/SamplePhotos/Main%20Page.PNG?raw=true)

#### Wizard Page 1
![enter image description here](https://github.com/William-Lake/E4WizardDemo/blob/master/SamplePhotos/Wizard%20Page%201.PNG?raw=true)

#### Wizard Page 2A
![enter image description here](https://github.com/William-Lake/E4WizardDemo/blob/master/SamplePhotos/Wizard%20Page%202A.PNG?raw=true)

#### Wizard Page 2B
![enter image description here](https://github.com/William-Lake/E4WizardDemo/blob/master/SamplePhotos/Wizard%20Page%202B.PNG?raw=true)


----------
#### Motivation
I'm relatively new to Computer Programming and as part of my work have been learning more about building software with the Eclipse E4 Rich Client Platform. I've been lucky enough to have a mentor who has guided me through some of the more confusing parts (E.g. Annotations), although I know not everyone has the same benefit. Knowing that this platform, once understood, can help a lot of newbies start bringing their own software ideas to life- I decided to share what I'd learned. I realize there are already examples out there, but I aim to build some that keep things as simple and well explained as possible. As a result, in this project you will find a minimalistic example full of comments. My hope is you will be able to leverage what you find here to successfully build your own Wizard and deeper understanding of the Eclipse E4 Rich Client Platform.


----------
#### Installation
##### This project requires the Eclipse E4 Tools to be installed:

 1. Open the "Install New Software" Window.
	 *- Navigate to the far right of the top menu and click on "Help" followed by "Install Software" near the bottom of the drop down menu.*
	 
 2. Choose the download site for your version of Eclipse.
	 *- In the drop down menu labeled "Works With" at the top of the "Install Software" window, choose the site for your Eclipse Version.*
	 
 3. Search for "E4" and install "Eclipse e4 Tools Developer Resources".
	 *- Look just below the drop down menu to find the search bar and type in "E4". Click the check box to the left of the package labeled "Eclipse e4 Tools Developer Resources" and click the "Next" button at the bottom of the window.*
	 
 4. Follow the Wizard prompts to finish installing the software.


##### Once the Tools have been installed, you can add this project like you would any other Java Project:

 1. Download the .zip file of this project [here](https://github.com/William-Lake/E4WizardDemo/blob/master/E4WizardDemo.zip).
 2. Import the project.
	 *- Navigate to Eclipse, and right click in your [Project Explorer](http://help.eclipse.org/luna/topic/org.eclipse.platform.doc.user/images/Image275_project_explorer.png), choosing "Import" about halfway down the pop-up menu.* 
	 *- Type "archive" into the search bar to easily locate the option titled "Archive File". Select it and click the "Next" button at the bottom of the window.*
	 *- Use the "Browse" button at the top right of the next page to locate your .zip file. Select it and click the "Finish" button at the bottom of the window.*


----------


#### Important Classes

 - ButtonHolder
	 - The first page you are greeted with when you open the program. Hosts the primary button which triggers launching the Wizard.
 - OpenWizard
	 - The class that runs when the button on the main page is pressed. It creates and opens the Wizard.
 - WizardDemo
	 - This is the class that instantiates, organizes, and serves up all the pages that make up your Wizard.
 - Various WizardPages
	 - I.e. WizardDemoPage1, WizardDemoPage2A, WizardDemoPage2B
	 - These classes each represent one custom WizardPage, in essence describing how they will look and some of their inherent functionality.

#### Important Application.e4xmi features

 - Handler/Command
	 - There is one Handler (Open Wizard) and one Command (Open Wizard) within this program's Application.e4xmi.
	 - The Command consists of a Label and an ID.
	 - The Handler is also given a Label and ID, but is additionally pointed towards the OpenWizard Command as well as the OpenWizard class that will run once it is activated.
	 - In short, when a Command is triggered it will activate any Handlers that are pointed at it, which in turn will run any classes that are associated with those Handlers.
 - Trimmed Window
	 - Although there is much more to it, for the purposes of this program the most important things to know here are that:
		 1. This is where you can modify where the application will open on the screen.
		 2. This is where you can modify the size of your application's window.
		 3. The Trimmed Window houses all of the important pieces that make up your application, such as Menus and Parts.
 - Part
	 - There is one Part in this program's Applicaiton.e4xmi.
	 - The "Class URI" field is most important here as it points to the class that houses code for creating and laying out controls (E.g. buttons, labels, etc.) on this Part. 


----------
If you have any questions or need any help please don't hesitate to get a hold of me here, on [LinkedIn](www.linkedin.com/in/william-lake-543535a5), or [Twitter](https://twitter.com/SynapseDynamo) and I will do the best I can to assist.

-Will
