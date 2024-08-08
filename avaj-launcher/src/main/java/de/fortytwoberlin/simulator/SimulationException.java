package main.java.de.fortytwoberlin.simulator;

public class SimulationException extends Exception {
    public SimulationException() { super(); }
    public SimulationException(String exception) { super (exception); }
    public SimulationException(Throwable exception) { super (exception); }
}
