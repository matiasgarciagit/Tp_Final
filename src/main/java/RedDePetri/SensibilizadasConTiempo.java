package RedDePetri;


    public class SensibilizadasConTiempo {
        private int alpha;
        private int beta;
        private long id;
        private boolean flag;
        private long startTime;

        SensibilizadasConTiempo(int alpha, int beta){
            this.alpha = alpha;
            this.beta = beta;
            this.flag = false;
            this.startTime = 0;
            this.id = -999999;
        }

}
