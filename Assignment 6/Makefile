#Makefile Assignment 6

JAVAC=/usr/bin/javac
.SUFFIXES: .java .class
SRCDIR=src/
BINDIR=bin/

all:
	javac -d bin $(SRCDIR)/*.java

clean:
	rm */*.class
run:
	java -cp bin/ SimulatorOne

docs:
	javadoc -d docs/ src/*.java

cleandocs:
	rm -r docs/