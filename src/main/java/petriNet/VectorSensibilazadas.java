package petriNet;

import monitor.Monitor;
import start.Util;

public class VectorSensibilazadas { //todo ver como ARREGLAR eL lio que es esta clase
    private SensebilizadoConTiempo[] z;
    private boolean esperando;
    private boolean ventana;
    private boolean seCumple;

    public VectorSensibilazadas() {
        this.esperando = false;
        String intervalos = "src/main/resources/intervalos.csv";
        int[][] intervalos_tiempo = Util.matriz2d(intervalos);
        this.z = new SensebilizadoConTiempo[intervalos_tiempo.length];
        for (int i = 0; i < z.length; i++) {
            this.z[i] = new SensebilizadoConTiempo(intervalos_tiempo[i][0], intervalos_tiempo[i][1]);
        }
    }

    public boolean estaSensibilizado(Transition transition, Monitor monitor) { //todo ESTA INCOMPLETO ESTO
        boolean isAllowed;
        ventana = z[transition.getPOSITION()].testVentanaTiempo(transition.getPOSITION());
        if (ventana) {
            if (esperando) {
                seCumple = false;
            } else {
                setNuevoTimeStamp(transition.getPOSITION());
                seCumple = true;
            }
        } else {
            if (z[transition.getPOSITION()].antesDeLaVentana()) {//antes que la ventana
                z[transition.getPOSITION()].setEsperando();
                try {
                    monitor.getSemaphoreMonitor().release();// larga el monitor y duerme
                    Thread.sleep(z[transition.getPOSITION()].getTime());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    System.out.println("Time less than or equal to 0");
                } finally {
                    try {
                        monitor.getSemaphoreMonitor().acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    seCumple = true;
                }

            } else {
                seCumple = false;
            }
        }
        return seCumple;
    }

    private void setNuevoTimeStamp(int position) {
        this.esperando = true;
        z[position].setIdHelper(Thread.currentThread().getId());
        z[position].setStartTime();
    }
}
