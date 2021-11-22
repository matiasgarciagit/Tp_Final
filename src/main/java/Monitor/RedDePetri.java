package Monitor;

import transi.Transicion;

public class RedDePetri {
    int[][] incidencia;
    // private int[][] intervalos_tiempo; //matriz de intervalos de tiempo
    final int[] mki; //marca inicial. columna. NO VARIA
    private int[] vectorDeEstado; //la marca actual
    int[] mj_1;// la siguiente
    //private VectorSecibilizadas vectorSecibilizadas;
    //private int[] e; //vector de transiciones sensibilizadas
    int[] ex; //vector de sensibilizado extendido
    //private int[] z; //Vector de transiciones des-sensibilizadas por tiempo
    public RedDePetri(String mji ,String I) {

      //  e_semaphore = new Semaphore(1, true);//no se  si lo voy a usar

        this.incidencia = Operaciones.matriz2d(I);

        this.vectorDeEstado = Operaciones.vector(mji);
        this.mki = vectorDeEstado; //marca inicial

    }

    public boolean disparar(Transicion transicion) {
        //todo hacer


        return true;
    }

    public int[] sensibilizadas() {
        //todo hacer
        return null;
    }

    public boolean[] vectoresSensibilizadosEsperando(int[] temp, int[] aux) {
        //todo hacer
        return null;

    }

    public int getCantTransisiones() {
        return 1;
    }

    public void calculoDeVectorEstado(Transicion transicion){
        vectorDeEstado = Operaciones.calculoDeVectorDeEstado(vectorDeEstado, transicion.getPosicion(), incidencia);
    }

    public int[] getColumna(){

        return new int[0];
    }

    public void actualiceSensibilizadoT(){

    }

    public void setNuevoTimeStamp(){

    }

    public int[][] getIncidencia(){
        return incidencia;
    }

}
