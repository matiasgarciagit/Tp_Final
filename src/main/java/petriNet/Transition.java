package petriNet;


public class Transition {

    private boolean TYPE; // verdadero si es temporazida, falso si es inmediata

    private int POSITION;
    private char NAME;

    public Transition(boolean TYPE, char NAME, int POSITION) {
        this.TYPE = TYPE;
        this.NAME = NAME;
        this.POSITION = POSITION;
    }

    public int getPOSITION() {
        return POSITION;
    }


    public boolean isTYPE() {
        return TYPE;
    }

}