#Makefile Assignment 1

JAVAC=/usr/bin/javac
.SUFFIXES: .java .class
SRCDIR=src/
BINDIR=bin/

all:
	javac -d bin $(SRCDIR)/*.java
clean:
	rm */*.class
run:
	java -cp bin/ LSAVLApp 1 1 00
	java -cp bin/ LSBSTApp 1 1 00
run0:
	java -cp bin/ LSAVLApp 9 1 00
	java -cp bin/ LSBSTApp 9 1 00

run00:
	java -cp bin/ GenDataTables

docs:
	javadoc -classpath ${BINDIR} -d docs/ src/*.java

cleandocs:
	rm -r docs/*
