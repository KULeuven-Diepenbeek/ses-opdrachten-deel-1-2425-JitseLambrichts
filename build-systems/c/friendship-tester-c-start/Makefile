#Variabelen declareren
CC = gcc
CFLAGS = -Wall -Wextra -std=c11 	#Flags meegeven
SRCDIR = ./src
BUILDDIR = ./build

#.c files declareren
CFILES = $(wildcard $(SRCDIR)/*.c)
#.o files declareren
OBJECTS = $(patsubst $(SRCDIR)/%.c, $(BUILDDIR)/%.o, $(CFILES))

#Naam van de .bin file
TARGET = friendshiptester.bin


all: $(TARGET)

$(TARGET): $(OBJECTS)
	$(CC) -o $@ $^

$(BUILDDIR)/%.o: $(SRCDIR)/%.c
	$(CC) $(CFLAGS) -c -o $@ $<


#Je moet de makefile aanpassen zodat het C-programma kan gecompiled+gelinked worden
compile: $(TARGET)

#Binaries en object files worden gedeletet
clean:
	rm -rf $(TARGET) $(OBJECTS)

#Project kan gerund worden
run: $(TARGET)
	./$(TARGET)

