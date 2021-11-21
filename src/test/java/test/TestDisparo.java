package test;

import monitor.Monitor;
import org.junit.Test;
import petriNet.PetriNet;
import petriNet.Transition;
import start.Util;

public class TestDisparo {

    @Test
    public void TestPrimerDisparo() {
        PetriNet petriNet = new PetriNet();
        Monitor monitor = new Monitor(petriNet);

        Transition transition = new Transition(true,'a',1);
        try {
            monitor.fireTransition(transition);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

