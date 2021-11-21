package Monitor;

import transi.Transicion;

import java.util.concurrent.Semaphore;

public class Monitor {

    boolean k;
    RedDePetri redDePetri;
    Semaphore semaforoMonitor;
    Colas colas;
    public Monitor(RedDePetri rdp) {
         semaforoMonitor = new Semaphore(1, true);
        k = false;
        redDePetri=rdp;
        //todo lugares para la cola
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
                int[] temp = this.redDePetri.sensibilizadas();
                int[] aux = this.colas.quienesEstan(temp);
                boolean [] m = this.redDePetri.vectoresSensibilizadosEsperando(temp, aux);
                if (m.Ope){
                    //todo colas politicas
                }else {
                    k = false;
                }

            }else {
                this.semaforoMonitor.release();
                this.colas.acquire();
            }
        }
    }
}


