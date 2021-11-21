package start;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Util {
    //private static start.Util INSTANCE = null;
    private static int CANTIDAD; //hilos
    private static Scanner INPUT_STREAM;

    private Util() { //para que no cree una instancia
    }
/*
    public static start.Util getInstance()//esta solo para que no se cree otra instancia
    {
        if (INSTANCE == null) {
            INSTANCE = new start.Util();
        }
        return INSTANCE;
    }*/

    public static int getNumber() {
        return CANTIDAD;
    }

    public static boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }

    public static String outPut(String filename) {
        String output="";

        try {
            File file=new File(filename);
            INPUT_STREAM = new Scanner(file);
            int i=0;
            while (INPUT_STREAM.hasNext()) {

                String line = INPUT_STREAM.next();
                String[] values = line.split(",");
                for (String value : values) {
                    output += value;
                }
                i++;
            }
            INPUT_STREAM.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return output;
    }

    public static int[][] matriz2d(String fileName) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        try {
            File file = new File(fileName);
            INPUT_STREAM = new Scanner(file);
            int i = 0;
            while (INPUT_STREAM.hasNext()) {
                a.add(new ArrayList<Integer>());
                String line = INPUT_STREAM.next();
                String[] values = line.split(",");
                for (int j = 0; j < values.length; j++) {
                    a.get(i).add(Integer.valueOf(values[j]));
                }
                i++;
            }
            INPUT_STREAM.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return a.stream().map(u -> u.stream().mapToInt(i -> i).toArray()).toArray(int[][]::new);
    }

    /**
     * Este metodo se usa para cargar un vector.
     *
     * @param fileName the file name
     * @return the int [ ]
     */
    public static int[] vector(String fileName) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        try {
            File file = new File(fileName);
            INPUT_STREAM = new Scanner(file);
            while (INPUT_STREAM.hasNext()) {

                String line = INPUT_STREAM.next();
                String[] values = line.split(",");
                for (String value : values) {
                    a.add(Integer.valueOf(value));
                }
            }
            INPUT_STREAM.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return a.stream().mapToInt(i -> i).toArray();
    }

    public static void prinThisMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static void printVector(int[] vector) {
        for (int value : vector) {
            System.out.print(value);
        }
        System.out.println();
    }

    public static void setNumber(int i) {
        CANTIDAD = i;
    }
}