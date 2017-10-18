package test;


import core.InitialStateGenerator;
import core.State;

/**
 * A product of mecha
 */
public class Main {
    public static void main(String[] args) {
        InitialStateGenerator generator = new InitialStateGenerator(3);
        State state = new State(generator.generate());
    }
}
