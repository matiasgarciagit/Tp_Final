package monitor.politcs;


import monitor.politcs.interfaceBehavior.InterfaceBehaviorInTheNet;
import petriNet.Transition;

public abstract class Politics {//todo ARREGLAR TODO SOBRE LA POLITICA
    public InterfaceBehaviorInTheNet interfaceBehaviorInTheNet;

    public Politics() {
    }

    protected abstract void which(int[] aux);

    public void applyPolitics(Transition transition) {
        interfaceBehaviorInTheNet.behavior(transition);
    }
}