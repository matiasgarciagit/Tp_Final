package monitor.politcs;

import monitor.politcs.interfaceBehavior.BehaviorB;

public class PoliticsB extends Politics {
    public PoliticsB() {
        interfaceBehaviorInTheNet = new BehaviorB();
    }

    @Override
    protected void which(int[] aux) {

    }
}
