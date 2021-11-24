package RedDePetri;

public class VectorSensibilizadas {
    public boolean esperando;
  //  private boolean ventana;
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
            this.startTime = -1;
            this.id = -999999;
        }
    }
    VectorSensibilizadas(){
        this.esperando=false;

    }

    public boolean testVentanaTiempo() {
        long ahora = System.currentTimeMillis();
        return ((ahora - sensibilizadoConTiempo.startTime) >= sensibilizadoConTiempo.alpha )
                && ((ahora - sensibilizadoConTiempo.startTime) < sensibilizadoConTiempo.beta);
    }
 /*   public boolean setVentana(boolean ventana){
        this.ventana
    }*/

}
