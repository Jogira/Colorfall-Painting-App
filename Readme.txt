This app is going to be a simple drawing application that will allow the user to draw pictures, save them, export them, 
and import templates.

ITERATION #1 ___________________________________________________________________________________________________________

CODE NOTES: 
The '//WORK IN PROGRESS//' header indicates codeblocks or files [if found under the import section] that were started 
but not completed for this iteration. 
WIP files include: TemplatesActivity, RecycleViewAdapter, ourPath, importActivity, GalleryItem, and gallerActivity


TESTING: 
We have successfully implimented testing for the Draw user story.

Unfortunately, due to the drawing library wer're using, we can't use Espresso to test. There are no ways to get 
Espresso readable. 

For the Add a Drawing User Story: 
Espresso has no way to check if a drawing object exsists. 

For the Draw User Story: 
The actual drawing action is not recorrded and the brush movemnts are handled internal to the library; 
therefore, we can not use Espresso to test it. 

For the Erase User Story: 
The actual erase action is not recorrded and the eraser movemnts are handled internal to the library; 
therefore, we can not use Espresso to test it. 

For the Erasing The Entier Canvas User Story: 
Espresso cannot directly check the contents of the drawing object

We will need Mocking and other more avanced testing methods to impliment test for these User Stories. 