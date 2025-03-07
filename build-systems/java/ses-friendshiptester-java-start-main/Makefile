MAINCLASS = App
JAR = app.jar

#Compileert de bronbestanden naar de /build-directory
compile:
	javac -d ./build *.java

#packaged alle klassen naar een jar genaamd ‘app.jar’ in de ‘build’-directory met entrypoint de ‘App’-klasse
jar:
	cd ./build && jar cvfe $(JAR) $(MAINCLASS) *

#Voert de jar file uit
run: 
	cd ./build && java -cp "$(JAR)" $(MAINCLASS)

#Verwijdert de ‘.class’-bestanden en het ‘.jar’-bestand uit de ‘build’-directory
clean:
	-rm -R ./build/*
