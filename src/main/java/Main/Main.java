package Main;

import Monitor.*;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        String mji = "src/main/resources/inicial.csv";
        String I = "src/main/resources/incidencia.csv";
        RedDePetri redDePetri= new RedDePetri(mji,I);
        Monitor monitor =new Monitor(redDePetri);
    }
}
