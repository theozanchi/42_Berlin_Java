SOURCES		:= $(shell find src -name "*.java")
MAIN_CLASS	:= main.java.de.fortytwoberlin.simulator.Simulator
OUT_DIR		:= out

all:		compile

compile:
			mkdir -p $(OUT_DIR)
			javac -d $(OUT_DIR) $(SOURCES)

reset:
			rm simulation.txt

run:		reset compile
			java -cp $(OUT_DIR) $(MAIN_CLASS) scenario.txt

clean:
			rm -rf $(OUT_DIR)

.PHONY:		all compile run clean
