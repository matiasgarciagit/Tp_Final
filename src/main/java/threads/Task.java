package threads;

import monitor.Monitor;
import petriNet.PetriNet;
import petriNet.Transition;

import java.util.Date;


public class Task implements Runnable {

    private Monitor monitor;
    private PetriNet petriNet;
    private Transition[] transition;


    /**
     * Constructor de Task donde se crean las transiciones a disparar segun la cantidad de columnas de la red de petri
     *
     * @param monitor  el monitor resposible de permitir o no el disparo de una transicion
     * @param petriNet the petri net
     */
    public Task(Monitor monitor, PetriNet petriNet) {
        this.monitor = monitor;
        this.petriNet = petriNet;
        this.transition = new Transition[petriNet.transitions()];
        for (int i = 0, j = 97; i < transition.length; i++, j++) {
            transition[i] = new Transition(petriNet.isTemp(i), (char) j, i);
        }
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": Task %s: Doing a task during " + new Date() + " seconds");
    }
}
