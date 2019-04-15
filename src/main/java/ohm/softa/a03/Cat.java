package ohm.softa.a03;

import ohm.softa.a03.states.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cat {
    private static final Logger logger = LogManager.getLogger();

    // state durations (set via constructor), ie. the number of ticks in each state
    private final int sleep;
    private final int awake;
    private final int digest;

    private State currentState;

    private final String name;

    public Cat(String name, int sleep, int awake, int digest) {
        this.name = name;
        this.sleep = sleep;
        this.awake = awake;
        this.digest = digest;

        currentState = new SleepingState(sleep);
    }

    public void tick() {
        this.currentState = this.currentState.tick(this);
    }

    public void feed() {
        if (!isHungry()) {
            throw new IllegalStateException("Can't stuff a cat...");
        }

        logger.info("You feed the cat...");
        this.currentState = ((HungryState) currentState).feed(this);
    }

    public boolean isAsleep() {
        return this.currentState instanceof SleepingState;
    }

    public boolean isPlayful() {
        return this.currentState instanceof PlayfulState;
    }

    public boolean isHungry() {
        return this.currentState instanceof HungryState;
    }

    public boolean isDigesting() {
        return this.currentState instanceof DigestingState;
    }

    public boolean isDead() {
        return this.currentState instanceof DeathState;
    }

    public int getSleep() {
        return sleep;
    }

    public int getDigest() {
        return digest;
    }

    public int getAwake() {
        return awake;
    }

    @Override
    public String toString() {
        return name;
    }
}
