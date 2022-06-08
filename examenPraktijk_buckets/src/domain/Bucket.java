package domain;

import java.util.LinkedList;
import java.util.Queue;

public class Bucket {
    private final double[][] gewichtenMatrix;
    public static final int infty = Integer.MAX_VALUE;

    public Bucket(double[][] matrix) {
        if (!isGeldigeGewichtenmatrix(matrix))
            throw new IllegalArgumentException("No valid gewichtenmatrix");
        this.gewichtenMatrix = matrix;
    }

    private boolean isGeldigeGewichtenmatrix(double[][] matrix) {
        return matrix != null && matrix.length == matrix[0].length;
    }

    private int getAantalKnopen() {
        return gewichtenMatrix.length;
    }

    private void initArray(double[] array, double value) {
        for (int i = 0; i < array.length; i++)
            array[i] = value;
    }

    public static void printArray(double[] matrix) {
        String result = "";
        for (int i = 0; i < matrix.length; i++) {
            result += matrix[i] + " ";
        }
        result += "\n";
        System.out.println(result);
    }
    private double[][] getGewichtenMatrix() {
        return gewichtenMatrix;
    }

    private double rechtstreekseVerbinding(int van, int tot) {
        return this.getGewichtenMatrix()[van - 1][tot - 1];
    }

    public double buizensysteem(double input, int bron, int put) {
        int aantalKnopen = this.getAantalKnopen();
        double[] ancestors = new double[aantalKnopen];
        initArray(ancestors, infty);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(bron);
        ancestors[bron - 1] = 0;

        int huidig = queue.remove();
        while (huidig != put){
            for(int i = 1; i <=aantalKnopen; i++){
                //if(rechtstreekseVerbinding(huidig, i) && ancestors[i-1] == infty){
                    queue.add(i);
                 //   input = input * queue[i];
                }
            }
        return input;
        }

    }

