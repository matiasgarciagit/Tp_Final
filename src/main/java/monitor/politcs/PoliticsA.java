package monitor.politcs;

import monitor.politcs.interfaceBehavior.BehaviorB;

public class PoliticsA extends Politics {
    public PoliticsA() {
        interfaceBehaviorInTheNet=new BehaviorB();
    }

    @Override
    protected void which(int[] aux) {

    }


}
