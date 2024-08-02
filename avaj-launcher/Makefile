SOURCES		:= $(shell find src -name "*.java")
MAIN_CLASS	:= ro.academyplus.avaj.simulator.Simulator
OUT_DIR		:= out

all:		compile

compile:
			mkdir -p $(OUT_DIR)
			javac -d $(OUT_DIR) $(SOURCES)

run:		compile
			java -cp $(OUT_DIR) $(MAIN_CLASS) scenario.txt

clean:
			rm -rf $(OUT_DIR)

.PHONY:		all compile run clean
