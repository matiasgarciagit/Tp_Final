package RedDePetri;

public class VectorSensibilizadas {
    private boolean esperando;
    private boolean ventana;
    private SensibilizadoConTiempo sensibilizadoConTiempo;

    private class SensibilizadoConTiempo{
        private int alpha;
        private int beta;
        private long id;
        private boolean flag;
        private long startTime;
        SensibilizadoConTiempo(int alpha, int beta){
            this.alpha = alpha;
            this.beta = beta;
            this.flag = false;
            this.startTime = 0;
            this.id = -999999;
        }
    }
    VectorSensibilizadas(){

    }

}
