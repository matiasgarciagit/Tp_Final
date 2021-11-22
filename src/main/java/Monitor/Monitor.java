package Monitor;

import transi.RedDePetri;
import transi.Transicion;

import java.util.concurrent.Semaphore;

public class Monitor {

    boolean k;
    RedDePetri redDePetri;
    Semaphore semaforoMonitor;
    private Colas[] cola;

    public Monitor(RedDePetri rdp) {
        semaforoMonitor = new Semaphore(1, true);
        k = false;
        redDePetri=rdp;
        cola = new Colas[redDePetri.getCantTransisiones()];
        for(int i=0;i<redDePetri.getCantTransisiones();i++){
            cola[i]=new Colas(); //Inicialización de colas.
        }
    }

    private boolean [] quienesEstan() {
        boolean[] Vc = new boolean[cola.length];
        for(int i=0;i< cola.length;i++){
            Vc[i]= !cola[i].isEmpty();
        }
        return Vc;
    }

    public void disparaTransicion(Transicion transicion) {

        try {
            semaforoMonitor.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        k=true;
        while (k){
            k=this.redDePetri.disparar();
            if(k){

             //todo deberia devolver algo
                boolean[] Vs = this.redDePetri.sensibilizadas();
                boolean[] Vc = quienesEstan();
                boolean [] m=new boolean[Vs.length];
                try {
                    m= Operaciones.andVector(Vs, Vc);
                }
                catch(IndexOutOfBoundsException e){
                    e.printStackTrace();
                    System.exit(0);
                }

                if (Operaciones.comprobarUnos(m)){
                    //todo colas ,politicas
                }else {
                    k = false;
                }

            }else {
                this.semaforoMonitor.release();
               // this.cola[transicion.getPosicion()].acquire();
            }
        }
    }
}


