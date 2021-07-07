# $Header: /repo/public.cvs/app/CupOmud/src/java/CupOmud/Makefile,v 1.2 2001/10/21 18:48:10 bruce Exp $

mStage = $(cmapp)/stage/java/CupOmud

build :
	javac -deprecation -O CupOmud.java mudclient/Applet.java
	javac -deprecation CupOmud.java

release :
	-mkdir -p $(mStage)/mudclient 2>/dev/null
	cp -f *.class $(mStage)
	cp -f mudclient/*.class $(mStage)/mudclient
