user = kubacki840888
programs = $(wildcard src/$(user)/*/Main.java)

compile: FORCE
	mkdir -p out
	javac -d out  $(programs)

run-a01: compile
	java -cp out $(user).a01.Main

clean: FORCE
	rm -r out

.PHONY: FORCE
