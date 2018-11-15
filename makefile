#  Alfonso Arias, aarias9
#  Partners:
#    Juan Zambrano, jzambr7
#    Robert Barrera, rbarre4
#  U. of Illinois, Chicago
#  CS 341, FAll 342
#  Term Project: Part IV

JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	AI.java \
	AI_F.java \
	AI_H.java \
	Artifact.java \
	Attack.java \
	Character.java \
	CleanLineScanner.java \
	DecisionMaker.java \
	Drop.java \
	Friendly.java \
	Game.java \
	GameTester.java \
	Get.java \
	Go.java \
	Heal.java \
	Hostile.java \
	keyboardScanner.java \
	Look.java \
	Move.java \
	NPC.java \
	Place.java \
	PLayer.java \
	PrintInfo.java \
	Quit.java \
	UI.java \
	Use.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
