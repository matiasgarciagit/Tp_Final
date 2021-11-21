package Monitor;

public class Operaciones {

    public static synchronized int[] andVector(int[] vector1, int[] vector2) throws IndexOutOfBoundsException{
        if (vector1.length==vector2.length) {
            int[] resultado = new int[vector1.length];
            for(int i = 0; i < vector1.length; i++) {
                resultado[i]=vector1[i]&vector2[i];
            }
            return resultado;
        }
        else{
            throw new IndexOutOfBoundsException("Listas de diferentes tamanios");
        }
    }

    public static synchronized boolean comprobarCeros(int[] vector){
        boolean var=false;
        for (int j : vector) {
            if (j != 0) {
                var = true;
            }
        }
        return var;
    }


    public static synchronized int[][] productoMatrices(int[][] a, int[][] b) throws IllegalArgumentException {

        int[][] c = new int[a.length][b[0].length]; //inicializo c
        //se comprueba si las matrices se pueden multiplicar
        if (a[0].length == b.length) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b[0].length; j++) {
                    for (int k = 0; k < a[0].length; k++) {
                        //se multiplica la matriz
                        c[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
        }
        else {
            System.out.print("Columas de matriz 1: \n");
            System.out.println(a[0].length);
            System.out.print("Filas de matriz 2: \n");
            System.out.println(b.length);
            throw new IllegalArgumentException("Las matrices no cumplen con las condiciones para poder efectuar la multiplicacion"); //si no se cumple la condicion tira IllegalArgumentException
        }
        return c;
    }


    public static synchronized int[][] sumaMatrices(int[][] a, int[][] b) throws IllegalArgumentException {
        int[][] c = new int[a.length][a[0].length]; //inicializo c con mismos tamanios
        if ((a[0].length == b[0].length)&&(a.length == b.length)) { //compruebo que a y b sean del mismo tamanio
            for (int x=0; x < a.length; x++) { //recorro en un for y sumo los elementos de las matrices
                for (int y=0; y < a[x].length; y++) {
                    c[x][y]=a[x][y]+b[x][y];
                }
            }
        }
        else {
            throw new IllegalArgumentException("Matrices de diferentes tamanios"); //si no se cumple la condicion tira IllegalArgumentException
        }
        return c;
    }


    /**
     * Metodo transpuesta. Realiza la transpuesta de una matriz de datos tipo int.
     * @param a Matriz a transponer
     * @return int[][] Matriz transpuesta
     */
    public static synchronized int[][] transpuesta(int[][] a){
        int[][] c = new int[a[0].length][a.length];
        for(int fila=0; fila<a.length;fila++){
            for(int columna=0; columna<a[0].length;columna++){
                c[columna][fila]=a[fila][columna];
            }
        }

        return c;
    }



}
