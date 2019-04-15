package ohm.softa.a03.states;

import ohm.softa.a03.Cat;
import ohm.softa.a03.State;

public class DeathState extends State {
    public DeathState() {
        super(-1);
    }

    @Override
    public State successor(Cat cat) {
        return this;
    }
}
