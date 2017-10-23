package Task6;

import Task7.Submarine;

/**
 * Atomic submarine can swim.
 */
@Submarine(name = "Atomic submarine")
public class AtomicSubmarine {

    private EngineOfAtomicSubmarine engine;

    private class EngineOfAtomicSubmarine{

    }

    public AtomicSubmarine(){
        engine= new EngineOfAtomicSubmarine();
    }

    public void startSwimming(){

    }
}
