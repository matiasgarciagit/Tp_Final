package RedDePetri;


    public class SensibilizadasConTiempo {
        private int alpha;
        private int beta;
        private long id;
        private boolean flag;
        private long startTime;

        public boolean isEsperando() {
            return esperando;
        }

        public void setEsperando(boolean esperando) {
            this.esperando = esperando;
        }

        private boolean esperando;

        SensibilizadasConTiempo(int alpha, int beta){
            this.alpha = alpha;
            this.beta = beta;
            this.flag = false;
            this.startTime = -1;
            this.id = -999999;
        }


    public boolean testVentanaTiempo() {
        long ahora = System.currentTimeMillis();
        return ((ahora - startTime) >= alpha )
                && ((ahora - startTime) < beta);
    }


}
