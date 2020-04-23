#Makefile Assignment 2

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

rundisplay:
	java -cp bin/ AVLGui

runtrial:
	echo "Three valid parameters" >> results/output.txt
	java -cp bin/ LSAVLApp 1 1 00 >> results/output.txt
	java -cp bin/ LSAVLApp 3 15 10 >> results/output.txt
	java -cp bin/ LSAVLApp 7 11 12 >> results/output.txt

	java -cp bin/ LSBSTApp 1 1 00 >> results/output.txt
	java -cp bin/ LSBSTApp 3 15 10 >> results/output.txt
	java -cp bin/ LSBSTApp 7 11 12 >> results/output.txt

	echo "Three invalid parameters" >> results/output.txt
	java -cp bin/ LSAVLApp 9 1 00 >> results/output.txt
	java -cp bin/ LSAVLApp 1 33 00 >> results/output.txt
	java -cp bin/ LSAVLApp 1 1 13 >> results/output.txt
	java -cp bin/ LSBSTApp 9 1 00 >> results/output.txt
	java -cp bin/ LSBSTApp 1 33 00 >> results/output.txt
	java -cp bin/ LSBSTApp 1 1 13 >> results/output.txt

	echo "No parameters" >> results/output.txt
	java -cp bin/ LSAVLApp >> results/output.txt
	java -cp bin/ LSBSTApp >> results/output.txt

run00:
	java -cp bin/ GenDataTables

docs:
	javadoc -d docs/ src/*.java

cleandocs:
	rm -r docs/
