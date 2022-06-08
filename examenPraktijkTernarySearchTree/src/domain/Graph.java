package domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    private final boolean[][] verbindingsMatrix;
    public static final int infty = Integer.MAX_VALUE;

    public Graph(int[][] matrix) {
        if (!isGeldigeVerbindingsMatrix(matrix))
            throw new IllegalArgumentException("No valid verbindingsmatrix");

        this.verbindingsMatrix = new boolean[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix.length; j++)
                this.verbindingsMatrix[i][j] = matrix[i][j] == 1;
    }

    private boolean isGeldigeVerbindingsMatrix(int[][] matrix) {
        if (matrix == null || matrix.length != matrix[0].length)
            return false;

        for (int i = 0; i < matrix.length; i++)
            if (matrix[i][i] != 0)
                return false;

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix.length; j++)
                if (matrix[i][j] != 0 && matrix[i][j] != 1)
                    return false;
        return true;
    }

    private int getAantalKnopen() {
        return this.verbindingsMatrix.length;
    }

    private int[] findAncestors(int start, int destination) {// nummering van
        int aantalKnopen = this.getAantalKnopen();
        int[] ancestors = new int[this.getAantalKnopen()];
        initArray(ancestors, infty);

        Queue<Integer> queue = new LinkedList<>();
        // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Queue.html
        queue.add(start);
        ancestors[start - 1] = 0;

        // oefening 1.4
        int huidig = queue.remove();
        while (huidig != destination) {
            // We gaan nu vanaf de huidige knoop door alle andere knopen gaan
            for (int i = 1; i <= aantalKnopen; i++) {
                // this.rechtstreekseVerbinding(huidig, i) => we kijken of er een verbinding is van het huidige knoop naar de andere knoop i
                // (ancestors[i - 1] == infty) => als we dat kunnen dan gaan we wel eerst kijken of we die knoop nog niet gehad hebben
                // Als beide true returnen dan hebben we die knoop dus nog niet bekeken en voegen we die toe aan de queue.
                if (this.rechtstreekseVerbinding(huidig, i) && (ancestors[i - 1] == infty)) {
                    queue.add(i);
                    ancestors[i - 1] = huidig;
                }
            }

            // Als de queue leeg is stoppen we ermee, anders gaan we door naar de volgende knoop
            if (!queue.isEmpty()) {
                huidig = queue.remove();
            } else {
                break;
            }
        }

        return ancestors;
    }

    private boolean rechtstreekseVerbinding(int van, int tot)
    {
        // De -1 is omdat de array's van 0 werken, maar in onze code werken we wel vanaf 1.
        // Als we knoop 1 dus willen moeten we in de array dus knoop 0 pakken.
        return this.getVerbindingsMatrix()[van - 1][tot - 1];
    }

    public boolean[][] getVerbindingsMatrix() {
        return verbindingsMatrix;
    }

    public List<Integer> findPath(int start, int destination) {
        if (start <= 0 || start > this.getAantalKnopen() || destination <= 0 || destination > this.getAantalKnopen())
            throw new IllegalArgumentException();

        int[] ancestors = this.findAncestors(start, destination);
        List<Integer> path = new LinkedList<>();

        // oefening 1.5
        // Al weer telkens - 1 omdat we 7 ingeven maar eigenlijk 6 moeten gebruiken (zie oef 1.4 voor meer info)
        int ouder = ancestors[destination - 1];

        while (ouder != 0 && ouder != infty) {
            path.add(0, destination);
            destination = ouder;
            ouder = ancestors[destination - 1];
        }

        if (ouder == 0) {
            path.add(0, destination);
        }

        return path;

    }

    private void initArray(int[] array, int value) {
        for (int i = 0; i < array.length; i++)
            array[i] = value;
    }


    // methode om tussenliggend resultaat te kunnen schrijven naar het scherm
    public String geefAncestors(int start, int destination) {
        String res = "Ancestors van " + start + " naar " + destination + ":\n";
        int[] ancestors = this.findAncestors(start, destination);
        for (int a = 0; a < ancestors.length; a++)
            res += ancestors[a] != infty ? ancestors[a] : "infty" + " ";

        return res;
    }

    /**
     * OPDRACHT EXAMEN!
     *
     * @param startPlaatsAn
     * @param startPlaatsBernard
     * @return
     */
    public int ontmoeting(int startPlaatsAn, int startPlaatsBernard)
    {
        int huidige_afstand = 0;
        int knooppunt = 0;

        // Voor elke knoop gaan we de paden berekenen
        for (int i = 1; i <= getAantalKnopen(); i++) {
            List<Integer> pad_an = new ArrayList<>();
            List<Integer> pad_bernard = new ArrayList<>();

            // Als het op een van de startplaatsen is kunnen we het niet berekenen!
            if (i != startPlaatsAn && i != startPlaatsBernard) {
                pad_an = this.findPath(startPlaatsAn, i);
                pad_bernard = this.findPath(startPlaatsBernard, i);

                // Lengte van pad van An + lengte van pad van Bernard
                int som_van_paden = pad_an.size() + pad_bernard.size();
                // Als de huidige afstand groter is dan de som van de paden dan veranderen we het pad
                if (huidige_afstand == 0 || huidige_afstand > som_van_paden) {
                    huidige_afstand = som_van_paden;
                    knooppunt = pad_an.get(pad_an.size() - 1);
                }
            }
        }

        return knooppunt;
    }
}
