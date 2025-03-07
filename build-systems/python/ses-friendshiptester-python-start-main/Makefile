MAIN = app.py
TARGET = friendshiptester.bin

#Compileert de bronbestanden naar de single ‘friendshiptester.bin’ file in de “/dist”-directory
compile:
	pyinstaller --onefile --name $(TARGET) $(MAIN)

#Verwijdert het ‘.bin’-bestand
clean:
	-rm -R ./dist/*
	-rm -R ./build/*

#Voert de ‘friendshiptester.bin’ uit
run:
	./dist/$(TARGET)

#Voert de ‘app.py’ uit
test:
	python3 $(MAIN)