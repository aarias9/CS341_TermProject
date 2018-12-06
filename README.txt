Alfonso Arias, aarias9
Partners:
    Juan Zambrano, jzambr7
    Robert Barrera, rbarre4
U. of Illinois, Chicago
CS 341, FAll 342
Term Project: Part IV
GROUP 9

Supplied Code:
    Alfonso Arias:
	Character.java
	Player.java
	NPC.java
	Friendly.java
	Hostile.java
	DecisionMaker.java
	UI.java
	AI.java
	AI_F.java
	AI_H.java
	IO.java
	aarias9CharacterUML.mdj

    Juan Zambrano:
	Direction.java, 
	IO.java,
	Place.java
	RadiatedPlace.java,
	TxtInterface.java
	jzambr7HW4_UML.mdj

    Robert Barrera:
	Artifact.java
	Move.java
	Get.java, Go.java, Drop.java
	Heal.java, Inventory.java, Look.java
	Quit.java, Use.java
	Artifact-UML-for-CS342-HW4.mdj

OTHER FILES:

	Game.java
	GameTester.java
	CleanLineScanner.java
	printInfo.java
	keyboardScanner.java
	makefile


HOW TO RUN:

NOTES:



------------------Term Project: Part V----------------------------------------

The Fallowing Changes have been made for this project.

Character.java
    This class will now be able to create characters by scanning in the information from a *.gdf file
    that has a version of 4.0 or greater.

    NPC.java & Player.java
            Children to the class, Character.java, these classes will distinguish whether if its a human player
            or computer player, as in Player will need to manually enter a command to move, NPC will move on its own.

Move.java
    This Class is contains a enum type class with all possible commands to make a move, e.g Go, Look, Use etc.
    ******NOTE******
    This and the makeMove() method in the Character/Player/NPC.java files are incomplete.

DecisionMaker Interface
    ****************Incomplete?*************************

CleanLineScanner.java
    Now instead of a being a method for each class, it has become a separate java class which any file
    from this project can call to parse a line from a file remove any comments("//") from said *.gdf file

NOTES:
    With these changes, I am able to scan a file, GDF 4.0, parse through it and create each place, direction, artifact,
    and player(s). This Project cannot actually Play the game, yet. However this project is still back-words compatible
    with *.gdf file 3.2 and still be able to play the game.

    As provided I include the mysticCity.gdf and fallout.gdf, both versions are 3.1/3.2, and I've also included
    mysticCityv4.gdf, version 4.0, to test the programs scanning abilities, yet it will not run/ play the game correctly

    It will go into an infinite loop if it does a *.gdf file of version 4.0.
    The game will set a flag to 1 once i = 4, assuming all characters made at least one move, the game will break the
    loop and quit.


-------------------Term Project: Part II---------------------------------

The Fallowing Changes has been made for the each file Requested.
GameTester.java
No longer adds the Places, Direction to the game manually, will only reads in a file

Game.java
Should now be able to pick up, use, and drop items/Artifacts.
The game class will only add the places to the game

Place.java
Is now able to keep track of itself by using the static method.
And it keeps track of the Artifacts added to the game.
ADDITIONAL METHODS
-I've added 2 methods returnItem() & removeItem()
-- returnItem(), return the artifact to the player
-- removeItem(), removes the item from the Current place

directions.java
Changed the class according to the pdf file of the assignment.

NEW CLASS
Artifacts.java
Allows us to scan in artifacts from the file and place them in their proper location.

KEYBOARDSCANNER.java
I took this class in the spring 2017, and I'm retaking the class. In the fall Prof. Bell allowed us to use this class to
 read-in files. I just wanted to include this information and not be deducted points.

TO RUN
Simply call "make" on the command line.
Then if there are no build errors, run java GameTester


INPUT COMMANDS
The user can now enter in a line, e.g. "go north" or "go n"
and the game will move the player if it's a valid direction.

NOTES:
I've also included the files, fallout.gdf and mysticCity.gdf for testing. Fallout.gdf is the file I created for testing
and works well for my project. I did test mysticity with my project and it run fine.


-------------------------TERM PROJECT I----------------------------
The following files are included:
	Direction.java
	Place.java
	Game.java
	GameTester.java
	PrintInfo.java

Directions Class
Is Done according to the the PDF file of the assignment

Place Class
Is also done according to the PDF file, yet I added 2 additional methods: UnlockPath, directionLocked.

	DirectionLocked returns true/false whether or not the path you are trying to enter is locked or not.

	UnlockPath allows the player to unlock doors/paths and return true/false
	if it was able to unlock or if it's already unlocked.

Game Class
Again, done according to the PDF.

LOOK: continue and display the current position
GO: move to a new locationif possible
EXIT/QUIT: quits the game.

TO RUN
Simply call "make" on the command line.
Then if there are no build errors, run java GameTester


INPUT COMMANDS
NOTE: This game version can only except LOOK, GO, EXIT, QUIT, NORTH, SOUTH, EAST,
and WEST whether lower case or upper case. OTHER INPUTS WILL BE DENIED.

Please when entering GO to move the player, please enter "go" then the direction.

It'll display like this:
$go(enter)
$east(enter)
//then the result will print out whether if it was valid or not.

If entered "$go west" or "$GO EAST", it will fail.

SAME TO UNLOCK A PATH/DIRECTION# CS342_TermProject
