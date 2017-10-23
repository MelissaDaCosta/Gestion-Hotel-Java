
JFLAGS = -g
JC = javac
J = java 
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        ControleurAccueil.java \
        Client.java \
		ClientModel.java \
		InterfaceAccueil.java \
		InterfaceChambre.java \
		ErreurReservation.java \
		ErreurClient.java \
		ControleurChambre.java \
		ControleurBouton.java \
		ControleurRadioBouton.java \
		InterfaceListe.java \
		InterfaceNoChambre.java \
		InterfaceReservation.java \
		Chambre.java \
		ChambreModel.java \
        Main.java 

default: classes

classes: $(CLASSES:.java=.class)

run: classes
	$(J) -cp "/export/documents/mariadb-client.jar:." Main

clean:
	$(RM) *.class
