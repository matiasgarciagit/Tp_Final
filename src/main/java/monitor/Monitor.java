package monitor;

import monitor.politcs.Politics;
import monitor.politcs.PoliticsA;
import monitor.politcs.PoliticsB;
import petriNet.PetriNet;
import petriNet.Transition;
import start.Util;

import java.util.concurrent.Semaphore;

public class Monitor extends Politics {
    private final PetriNet petriNet;

    private Semaphore semaphoreMonitor;
    private boolean colas;
    private boolean seCumple;
    private QueueMonitor[] esperan;
    private Politics politicsA;
    private Politics politicsB;
    //  private QueueMonitor[] cortesia;

    public Monitor(PetriNet petriNet) {
        semaphoreMonitor = new Semaphore(1, true);
        this.petriNet = petriNet;
        esperan = new QueueMonitor[Util.getNumber()];
        // cortesia = new QueueMonitor[start.Util.getCantidad()]; // todo hay que ver el tamanio si puedo hacer para no elementos demas
        for (int i = 0; i < Util.getNumber(); i++) { //todo quizas es mejor ir creandolos en el momento
            esperan[i] = new QueueMonitor();
            // cortesia[i] = new QueueMonitor();

        }


        politicsA = new PoliticsA();
        politicsB = new PoliticsB();
    }

    public Transition fireTransition(Transition transition) throws InterruptedException {
        //todo ver si devuelve algo o no
        semaphoreMonitor.acquire();
        seCumple = true; //esta es la k
        while (seCumple) {
            //saque el false
            seCumple = petriNet.disparar(transition, this); //aca se dispararia la red
            if (seCumple) {

                int[] temp = petriNet.sensibilizadas();
                //int[] aux = QueueMonitor.whoIsHere(temp, esperan, cortesia);
                int[] aux = QueueMonitor.whoIsHere(temp, esperan);
                boolean m = vectoresSensibilizadosEsperando(temp, aux);
                if (m) {
                    //todo ver bien nose si se me confundieron
                    // int temp2 = which(aux);// todo hay que cambiar
                    //  releaseDel(esperan, temp2);// todo hay que cambiar
                } else {
                    seCumple = false;
                }
            } else {
                semaphoreMonitor.release();
                acquireAdd(transition, esperan);
            }
        }
        semaphoreMonitor.release();
        return transition;// hay que cambiar esto
    }

    private boolean vectoresSensibilizadosEsperando(int[] temp, int[] aux) { //hay que hacer
        return Util.getRandomBoolean();
    }

    private void acquireAdd(Transition transition, QueueMonitor[] esperan) {//todo hay que ver en que elemento lo agregamos
        try {
            this.esperan[1].setVector(transition);
            this.esperan[1].acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void releaseDel(QueueMonitor[] esperan, int temp2) {//todo hay que ver en que elemento lo agregamos lo sacamos
        this.esperan[1].setVector(null);
        this.esperan[1].release();
    }

    public Semaphore getSemaphoreMonitor() {
        return semaphoreMonitor;
    }


    @Override
    protected void which(int[] aux) {

    }
}
