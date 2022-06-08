import java.util.ArrayList;
import java.util.List;

public class Recursie {


    // Oefening 1: n-de Fibonacci-getal

    public static int fibonacci(int getal) {
        if (getal < 1) throw new IllegalArgumentException("");
        else if (getal == 1 || getal == 2) return 1;
        return fibonacci(getal-1) + fibonacci(getal-2);
    }

    // Oefening 2 : som van cijfers

    public static int somVanCijfers(int getal) {
        if (Math.abs(getal) == 0) return 0;
        return (Math.abs(getal)%10 + somVanCijfers(Math.abs(getal)/10));
    }

    // Oefening 3: keer een string om
    //VERSIE 1
//    public static String keerOm(String s) {
//        if(s == null) throw new IllegalArgumentException("");
//        else if (s.isEmpty()) return s;
//        return keerOm(s.substring(1)) + s.charAt(0);
//    }

    //VERSIE 2
    public static String keerOm(String s) {
        if(s == null) throw new IllegalArgumentException("");
        else if (s.length() <= 1) return s;
        return s.charAt(s.length()-1) + keerOm(s.substring(0,s.length()-1));
    }

    //oefening 4: countX

    public static int countX(String s) {
        if(s == null) throw new IllegalArgumentException("");
        else if(s.length() == 0) return 0;

        int count = 0;
        if(s.charAt(0) == 'x') {
            count = 1;
        }

        return count + countX(s.substring(1));
    }

    //oefening 5 : countHi
    public static int countHi(String s) {
        if(s == null) throw new IllegalArgumentException("");
        else if(s.length() < 2 || (s.length() == 2 && !s.equalsIgnoreCase("Hi"))) return 0;

        int count = 0;
        if(s.substring(0,2).equalsIgnoreCase("hi")) count = 1;

        return count + countHi(s.substring(2));
    }

    // oefening 6
    public static String changeXY(String s) {
        if(s == null) throw new IllegalArgumentException("");
        else if(s.length() == 0) return s;

        return ((s.charAt(0) == 'x'? "y" : s.charAt(0)) + changeXY(s.substring(1)));

    }

    // oefening 7

    public static String changePi(String s) {
        if (s == null) throw new IllegalArgumentException("");
        else if (s.length() <= 1) return s;
        else {
            if(s.substring(0,2).equalsIgnoreCase("pi")){
                return "3.14" + changePi(s.substring(2));
            }
            else{
                return s.charAt(0) + changePi(s.substring(1));
            }
        }
    }

    // oefening 8:
    public static int tweelog(int getal) {
        if(getal <= 0) throw new IllegalArgumentException("");
        else if(getal <= 1) return 0;
        return 1 + tweelog(getal/2);
    }

    // oefening 9;
    public static double findMaximum(List<Double> lijst) {
        if(lijst == null || lijst.size() == 0) throw new IllegalArgumentException("");
        else if (lijst.size() == 1) return lijst.get(0);
        else{
            double n = findMaximum(lijst.subList(1,lijst.size()));
            if(lijst.get(0) > n){
                return lijst.get(0);
            }
            else{
                return n;
            }
        }
    }

    // oefening 10;
    public static ArrayList<String> findSubstrings(String string) {
        if(string == null) throw new IllegalArgumentException("");
        ArrayList<String> result = new ArrayList<>();
        if(string.length() <= 1){
            result.add(string);
            return result;
        }
        else{
            result.add(string.substring(0,1));
        ArrayList<String> temp = findSubstrings(string.substring(1));
        result.addAll(temp);
        for (String s : temp) {
            result.add(string.charAt(0) + s);
        }
        return result;
        }
    }

    // oefening 11;
    public static int aantalKaarten(int n){
        if (n <= 0) throw new IllegalArgumentException("");
        else if (n == 1) return 2;
        return aantalKaarten(n-1) + (n-1) + 2 * n;
    }

}