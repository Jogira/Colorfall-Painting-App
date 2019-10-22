This app is going to be a simple drawing application that will allow the user to draw pictures, save them, export them, 
and import templates.

ITERATION #1 ___________________________________________________________________________________________________________

CODE NOTES: 
The '//WORK IN PROGRESS//' header indicates codeblocks or files [if found under the import section] that were started 
but not completed for this iteration. 
WIP files include: TemplatesActivity, RecycleViewAdapter, ourPath, importActivity, GalleryItem, and galleryActivity


TESTING: 
We have successfully implemented testing for the Draw user story.

Unfortunately, due to the drawing library we’re using, we can't use Espresso to test. Espresso does not record the strokes
or movement of the brush on the canvas. This makes it impossible to perform tests where we draw on the screen, switch colors
and then draw on the screen, erase any drawings on the screen, or wiping the canvas clean after drawing on the screen.

Because of the nature of our app, drawing something on the screen and then testing if what we're drawing is actually
on the screen with Espresso is not possible. We will need to use Mockito in further iterations
to force the canvas to have dummy data.

For the Add a Drawing User Story: 
Espresso has no way to check if a drawing object exists. 

For the Draw User Story: 
The actual drawing action is not recorded and the brush movements are handled internal in the library; 
therefore, we cannot use Espresso to test it. 

For the Erase User Story: 
The actual erase action is not recorded and the eraser movements are handled internal in the library; 
therefore, we cannot use Espresso to test it. 

For the Erasing The Entire Canvas User Story: 
Espresso cannot directly check the contents of the drawing object, so it is not able to determine if the canvas is wiped.


