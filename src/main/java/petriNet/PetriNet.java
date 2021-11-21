package petriNet;

import monitor.Monitor;
import start.Util;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class PetriNet {//todo ver que variables no hacen falta
    private int[][] incidencia;
    // private int[][] intervalos_tiempo; //matriz de intervalos de tiempo
    private final int[] mki; //marca inicial. columna. NO VARIA
    private int[] mj; //la marca actual
    private int[] mj_1;// la siguiente
    //private int[] e; //vector de transiciones sensibilizadas
    private int[] ex; //vector de sensibilizado extendido
    //private int[] z; //Vector de transiciones des-sensibilizadas por tiempo
    private int[] disparo; //esto lo definen los hilos
    private int[][] cambio; //no se si se va usar
    private Semaphore e_semaphore; //no se  si lo voy a usar
    private Semaphore semaphoreMonitor;
    private int cont;
    private VectorSensibilazadas E; //todo falta esto

    //todo ver si hace otro vector para saber si una transicion se va a disparar,
    // ver que hacer cuando una transision puede ser disparada multiples veces

    public PetriNet() {
        String mji = "src/main/resources/Inicial.csv";
        String I = "src/main/resources/incidencia.csv";


        e_semaphore = new Semaphore(1, true);//no se  si lo voy a usar

        this.incidencia = Util.matriz2d(I);
        this.cambio = incidencia;
        this.mj = Util.vector(mji);
        this.mki = mj; //marca inicial

        // todo SACAR ESTO DE ACA
        Util.printVector(mj);
        int[] mj_1 = sum(mj, 0);
        Util.printVector(mj_1);


    }

    private int[] vectorE(int[] a, int[][] b) {
        int[] temp = new int[b[0].length];
        Arrays.fill(temp, 1);
        for (int i = 0; i < b[0].length; i++) {//columnas
            for (int j = 0; j < a.length; j++) {//filas
                if (a[j] + b[j][i] < 0) {
                    temp[i] = 0;
                    break;
                }
            }
        }
        return temp;
    }

    public int transitions() {
        return incidencia[0].length;
    }

    public int places() {
        return incidencia.length;
    }

    private int[] vectorZ(int cont, int[][] intervalos_tiempo) {
        return new int[0];
    }

    private int[] vectorEX(int[] e, int[] z) {
        int[] temp = new int[e.length];
        for (int i = 0; i < temp.length; i++) {
            if (e[i] == 1 && z[i] == 1) {
                temp[i] = 1;
            } else temp[i] = 0;
        }
        return temp;
    }


    private int[] sum(int[] old, int position) {
        int[] temp = new int[old.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = old[i] + incidencia[i][position];
        }
        return temp;
    }


    public boolean disparar(Transition transition, Monitor monitor) { // todo hay que hacer

        boolean isAllowed = E.estaSensibilizado(transition, monitor); //todo se rompe aca porque no esta implementado el programa
        if (isAllowed) {
            calculoDeVectorEstado();
            return true;

        } else {
            return false;
        }
    }

    private void calculoDeVectorEstado() {

    }

    public int[] sensibilizadas() { //hay que hacer
        return null;
    }

    public void semaphoreMonitorToPN(Semaphore semaphore) {
        this.semaphoreMonitor = semaphore;
    }

    private void monitorAcquire(Monitor monitor) {
        try {
            monitor.getSemaphoreMonitor().acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("permisos acquire" + monitor.getSemaphoreMonitor().availablePermits());
        }
    }

    private void monitorRelease(Monitor monitor) {
        monitor.getSemaphoreMonitor().release();
        System.out.println("permisos realease" + monitor.getSemaphoreMonitor().availablePermits());
    }

    public boolean isTemp(int i) {//todo decir si la transcion es o no temp
        return false;
    }
}