
JFLAGS = -g
JC = javac
J = java 
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        AccueilStatistique.java \
        CamembertOccupationDate.java \
		ChoixDate.java \
		ChoixPeriode.java \
		ControleurBouton.java \
		ControleurBox.java \
		ControleurDate.java \
		ControleurPeriode.java \
		Date.java \
		DateModel.java \
		ItemState.java \
		NonPresentationDate.java \
		OccupationDate.java \
		OccupationPeriode.java \
        Main.java 

default: classes

classes: $(CLASSES:.java=.class)

run: classes
	$(J) -cp "/export/documents/mariadb-client.jar:." Main

clean:
	$(RM) *.class
