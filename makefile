# Alfonso Arias
# U.of Illinois, Chicago
# CS 342, Fall 2018
# Term Project: Part III
# 
# makefile
#

JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Direction.java \
	Game.java \
	Place.java \
	Artifact.java \
	Character.java \
	Player.java \
	NPC.java \
	DecisionMaker.java \
	keyboardScanner.java \
	CleanLineScanner.java \
	PrintInfo.java \
	GameTester.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
