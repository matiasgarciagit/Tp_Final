package monitor;

import petriNet.Transition;

import java.util.concurrent.Semaphore;

public class QueueMonitor {
    private final Semaphore semaphore; //todo ver si hace falta multiples semaforos o con uno solo alcanza
    //todo es probable que este al pedo el vector, creo que es mejor poner solo la posicion
    private int[] vector; //creo que esto seria las marcas del disparo que quiero hacer

    public QueueMonitor() {
        this.semaphore = new Semaphore(1);
    }

    public static int[] whoIsHere(int[] temp, QueueMonitor[] esperan) { //hay que hacer
        return new int[0];
    }

    private void waitThread() { //todo ver si hace falta la sincronizacion de los hilos en este punto
        try {
            semaphore.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void notifyThread() {
        semaphore.notify();
    }

    public int[] getVector() {
        return vector;
    }

    public void setVector(Transition transition) {//todo sacar este metodo
        //this.vector = transition.getVECTOR_TO_FIRE();
    }

    public void release() {
        notifyThread();
        semaphore.release();
    }

    public void acquire() throws InterruptedException {
        semaphore.acquire();
        waitThread();
    }
}