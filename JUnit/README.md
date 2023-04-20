# CoffeeMaker_SWEN352

###**SWEN-352: Software Testing**
###**Activity #1**
##JUnit and Emma: Unit Testing
**Teams:**
This assignment must be done by the teams identified in class, however, cross-team collaboration (not copying) is fine as the purpose is to learn the activity skill set.

**Slides:**
[**UnitTestingActivity #1.pptx**](https://docs.google.com/presentation/d/1qzLn5QmPXZHZePRxE3wTYd9PE8_XsTcY/edit?usp=sharing&ouid=116378854559746767728&rtpof=true&sd=true)

**Objective:
**Learn how to use:Create unit test and fix defects. Use JUnit for unit level testing to confirm defects are fixedUse [EclEmma](https://www.eclemma.org/) to measure the coverage of Unit Testing

**Assignments/Dropbox Instructions:**
- Label all filenames by Team number and activity number- Example: Activity #1 – Team 1
- Write the Professor’s name on the document
- All team member names must be on the document
- One submission for this assignment in MS Word (.docx) or PDF (.pdf) for each team
- All font in Calibri font size 12 or greater, spacing 1.15 or greater, orientation Landscape
- Submit your files (1 doc + 1 zip file) in MyCourses Assignments/Dropbox.
### **STEP 0 - Neatness, clear labels, READABLE SCREENSHOTS, organized submission – 5%**
  - Subject to Professor and Course Assistant’s discretion
    **Setup Eclipse and CoffeeMaker:**
    Get the most updated version of Eclipse
  
- https://www.eclipse.org/downloads/ (Junit should be included)

- For this class you want Eclipse for Java Developers

- For additional help with setting up Junit:
	
	- https://www.guru99.com/download-installation-junit.htmlhttps://stackoverflow.com/questions/10773979/junit-test-not-running-in-eclipseDownload 
	
- CoffeeMaker_SWEN352.zip from myCourses (Content > Activities > Activity 1)

- open it in Eclipse (File -> Open Projects From File System… -> Archive):![img](https://lh4.googleusercontent.com/4reByPzX9AghSRk7afEExeTP5WqzpfQYSyqq3VDh9MEC0U1XYQ858V3mrkh9qLad0kbzwK2FATfIpqTr8a-NV6-sb-R9JKFCcfSGyfUvqCYuD4Q0B03pfBX8gc0ZvwCtYMf9mMDZ3yy-z4mNz-MaFwA)
  **Example Unit Test with Output of Eclemma**![img](https://lh6.googleusercontent.com/WkOwQdUohejSViI-Rv5ML5VZrHtaOodiefcfkQjFetcIcSkO7p8LyauOiBqBYpIlEEW5Lx3yhyN08Mn0xuNp9diSvTfUKMA6wFTW6OUBaWZ1GRreD-hOkBCcNRQGb3ESjPwEeasWHLjrWECbekE1_2M)![img](https://lh3.googleusercontent.com/2mR2zoBoU-ZAR7K5qfIn4WiFtnkDgsBIiHhgYzmN2wInNP6vylK7O5icStnQWeIRTojhTDGMs094Og7W8B4Or1DtptHHewnOnYi_mMjTZvGXWGXnzxPZtRAmms8Qd7SAuyYKM7XWsIePt1vQSU4XhDw)
  **Create a JUnit Test Case Classes:**
  Follow the instructions in the [Unit Testing in Eclipse using JUnit](https://courses.cs.washington.edu/courses/cse143/11wi/eclipse-tutorial/junit.shtml) tutorialRead through the tutorial to learn about creating unit test with JUnit using EclipseJunit 5 is recommended, but Junit 3 or 4 is fine as well.

### **STEP 1 - Take a screen snapshot of Project Explorer showing all 4 test classes under unittests**(empty test classes) – 5%
- **Test class for the Inventory class**
- **Test class for the RecipeBook class**
- **Test class for the Recipe class**

**Writing Tests:**
- You should start with 0% *src* code coverage. Run EclEmma to see your baseline code coverage
	- Right-click the project in the project explorer in Eclipse and use the (Coverage As -> Junit Test) option
### **STEP** **#2- Provide screen snapshot for all classes with** **zero coverage** **execution for the source files using EclEmma – 5%**
- Hint: focus on the source code files, not the test ones
### **STEP #3 -** **Find, fix and submit any 4 defects in project CoffeeMaker - 20%****
- 5% per defect
- Strong Recommendation - Perform boundary test around the acceptable inputs to get the one **[Assert](https://junit.org/junit4/javadoc/4.12/org/junit/Assert.html) per Unit Test**
- Only defects found in the three classes we are testing will count towards the 4 required defects
	- **Inventory.java**
	- **RecipeBook.java** 
	- **Recipe.java**

**There are 5 defects total in the project, this activity only requires you to find 4 of them**
**Defect format should be as follows:**

- List the class the defect is found in

- 1-2 sentences explaining why it is a defect, and how can it be fixed

- A screenshot of the failed unit test that caught the defect

- A screenshot of the code that caused the defect (showcasing the defect)

- A screenshot of your code fix for the defectA screenshot of the failed unit test passing after your code fix
  Note: include as much information as you can in the screenshots such as line number, highlighting important lines with the cursors, ...etc.

**What is considered a defect:** 
- Wrong, or unexpected, outputs that do not match the method comments
- Code not handle edge cases (such as index out of bounds)
- Subject to Professor and TA’s discretion

**What is not considered a defect:** (at least for this activity)
- Unreachable code

**An example of the defect format in the submission document (The defect used in the example is fake):**
A 1-2 sentence explaining why it is a defect:
		Both the name and the comments of the method in question indicate that it should be adding coffee 		instead of multiplying it. The name of the method is AddCoffee and the JavaDoc comment reads that it 		is adding coffee units to the inventory in the CoffeeMaker system.
**A screenshot of unit test failure due to the defect**
![img](https://lh3.googleusercontent.com/pkPsmH7PWKvi938s5EIXrU0BDserHZQcEYvZWpl4m0JbFMmQN41QdG2vKJgDB-kcII2P_TSAv4C1vUMCMXWJ_Yu8h-nBEovnxx_wbHX5pN0E_tti9eBKWmT7CfGP-zQztUNzkZuw14wqIIJU4h5RPfk)
**A screenshot of the code that caused the defect (defect highlighted**)
![img](https://lh3.googleusercontent.com/A2hRsEA5973iRKQnvT1yiIOB4yw3TUXVLimuOn2qPK2Yv8yHlFoRo0jw_joNw7dU3ZvYCU27IHCIUzac4Sa-NlYPGw5FkKPonCk2cZCGyeBSkRBdG2C1uyPcNnfK8EwNf6aSLHh5eaONYlKLkmvBBqQ)
**A screenshot of the code fix (fix highlighted)**
![img](https://lh5.googleusercontent.com/vX6sxMbg8tlFk8bAkHNvCInbU3yRbKJlCExZHuPA_qyFS6a-FgC0HCZSgF0uWZadzj-DZnkndQNorMpB7-S367dAi6wSJmsxgmPXnpdanrUlCgseWpY--4tvY6ZoLsUeC5Z6WTCIODDRFz22jj9Af_A)
**A screenshot of the unit test passing again**
![img](https://lh5.googleusercontent.com/JnIMB_V0vfoq5SsawLkpDwOMBuvWSZU3ZRR8iqYhJuFiohuUz2RkHu_BLdq7p3nII2ikFhE8tiAe4aN9pWDv7DnUqunBvpgVp1rX2jc2kif5qi3uRhuHdlccEqcM6wwRMWAw0FJkW7kyLtueCLrpqrs)

### **STEP 4 - Write unit test with a goal of 100% code coverage for all three classes source files. Full credit if you get 95% or better (no partial credit). Provide a screenshot showing the coverage using EclEmma (similar to the example below) – 30%

**Inventory.java - 15%
RecipeBook.java - 5%
Recipe.java - 10%**

**![img](https://lh6.googleusercontent.com/Ys4X26fh7kcx-Y9jXcrtMFi87T8a3WiKWc_qeUaxaLPT3XM4JAak-20QBEHI6fShnDJUuQLfuufXHofu7VBKHmJtCnt_Dcjn6LAcValTFqIashtdy9pzuWLMW6bj2voCsDm4bY1GsGGTdh0uEBVPYKs)**

### **STEP 5 - Provide** **three** **screenshots (one for each class) showing the number of unit test executed in the expanded view for each test file’s count (make sure you include the Eclipse method count in the screenshot) - 30%**

**Grading will be as follows per class****:
** **Inventory - 15%:**
50 or more methods                    					15%
less than 50 and more than 25 methods   	 7%
less than 25                           							 0%

**RecipeBook - 5%:**
12 or more methods                   				  	 5%
less than 12 but more than 7         				   3%
less than 7                         			   				   0%

**Recipe - 10%:**
35 or more methods                    					10%
less than 35 but more than 15          			    5%
less than 15                          							   0%

**Note:** getters and toString() methods are only intended to be tested to get the desired coverage. One test method per each getter/toString() is sufficient.

**Note:** Methods are **not** the same as asserts. Each method should focus on testing the same functionality.

Example screenshot for the Inventory class:![Graphical user interface, text, Word  Description automatically generated](https://lh5.googleusercontent.com/-9j5NSPmKYGgvTvpE8hJ4El2bX8UrJRyxiHvhEt1KmTAsOXp3TUVrmjG7WkzAJALbue_hKnu11iCRfdeQERBOikknTG_fr5Uxk5TYTQv7FnxQXwUHzheoIfMp5kpmHpfCEEz4lZPe1Mz18DWzTdlD3I)

**STEP 6 - Submit a zip file of all your code – 5%** 
Recommendation - Test on different team member’s machines prior to ensure robustness

**SUBMISSION SUMMARY:**

STEP 0 (neatness)       5
STEP 1			              5
STEP 2			              5
STEP 3						20
STEP 4						30
STEP 5						30
STEP 6						  5

**TOTAL POINTS**	**100**