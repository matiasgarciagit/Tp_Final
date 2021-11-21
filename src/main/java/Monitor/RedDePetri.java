package Monitor;

public class RedDePetri {
    int[][] incidencia;
    // private int[][] intervalos_tiempo; //matriz de intervalos de tiempo
    final int[] mki; //marca inicial. columna. NO VARIA
    int[] mj; //la marca actual
    int[] mj_1;// la siguiente
    //private int[] e; //vector de transiciones sensibilizadas
    int[] ex; //vector de sensibilizado extendido
    //private int[] z; //Vector de transiciones des-sensibilizadas por tiempo
    public RedDePetri(String mji ,String I) {


      //  e_semaphore = new Semaphore(1, true);//no se  si lo voy a usar

        this.incidencia = Operaciones.matriz2d(I);

        this.mj = Operaciones.vector(mji);
        this.mki = mj; //marca inicial
    }

    public boolean disparar() {
        //todo hacer
        return true;
    }

    public int[] sensibilizadas() {
        //todo hacer
        return null;
    }

    public boolean[] vectoresSensibilizadosEsperando(int[] temp, int[] aux) {
        //todo hacer
        return true;

    }
}
