package start;

import monitor.Monitor;
import petriNet.PetriNet;
import threads.Pool;
import threads.Task;


public class Main {
    public static void main(String[] args) {
        Util.setNumber(10);
        PetriNet petriNet = new PetriNet();
        Monitor monitor = new Monitor(petriNet);
        Task task = new Task(monitor,petriNet); //todo ver si no hay problema al no crear el objetoSSS
        Pool pool = new Pool();
        for (int i = 0; i < 1000; i++) {//todo con esto dispara 1000 transiciones NO TAREAS
            pool.executeTask(task);
        }
        pool.apagar();
    }
}