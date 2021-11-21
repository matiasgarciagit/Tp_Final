package petriNet;

public class SensebilizadoConTiempo {
    private final int alpha;
    private final int beta;
    private long id;
    private boolean flag;
    private long startTime;
    private long stopTime;


    public SensebilizadoConTiempo(int alpha, int beta) {
        this.alpha = alpha;
        this.beta = beta;
        this.flag = false;
        this.startTime = 0;
        this.stopTime = 0;
        this.id = -9;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setIdHelper(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }


    public void setStartTime() {
        this.startTime = System.currentTimeMillis();
        this.flag = true;
    }

    public void setStopTime() { //todo es probable que esto no se use
        stopTime = System.currentTimeMillis();
        this.flag = false; //todo ver si esta bien
    }

    public long getTime() throws Exception { //todo es probable que esto no se use
        long a = (startTime + alpha - System.currentTimeMillis());
        if (a <= 0) throw new Exception();
        return a;
    }

    public void reset() {
        this.flag = false;
        this.startTime = 0;
        this.stopTime = 0;
        this.id = -99;
    }

    public boolean testVentanaTiempo(int position) { //todo creo que no hace falta position
        long ahora = System.currentTimeMillis();
        /*if ((ahora - startTime >= alpha && (ahora - startTime) < beta))
            return true;
        else
            return false;*/
        return (ahora - startTime) >= alpha && ((ahora - startTime) < beta);
    }

    public boolean antesDeLaVentana() {
        return false;
    }

    public void setEsperando() {

    }
}
