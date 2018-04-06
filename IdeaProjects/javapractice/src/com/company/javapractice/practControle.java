/*
TYSON FELADATOK 1.:
        1. Írd ki a parancssori paramétereket a konzolra
        2. Írd ki a parancssori paramétereket a konzolra, fordított sorrendben
        3. Írd ki a parancssori paramétereket úgy, hogy az n. sorban az els n darab parancssori paramétert írja ki: els sorba csak az elst, a másodikba az els kettt szóközzel elválasztva, a harmadikba az els hármat, stb..
        java Main egy ketto kutya cica fagyi
        4. Írd ki a parancssori paraméterek közül a legnagyobbat, legkisebbet, valamint az értékek átlagát.
        5. A parancssori paraméterek alapján döntsd el, hogy egy a bemen számok számtani, mértani sorozatot alkotnak-e, vagy esetleg egyiket sem. Feltehetjük, hogy mindegyik egész szám, és legalább 3 db paraméterünk van. Az összegképletek:
        számtani: a n = a 1 + (n – 1) * d
        mértani: a n = a 1 * q n – 1
        6. Számítsd ki a parancssoron kapott két idpont (óra perc óra perc) között eltelt idt, és írasd ki a konzolra (óra perc formában). A program elkészítése során ügyelj az adatok helyességére
        bemen paraméterek száma az órák 0-23 intervallumba kell, hogy essenek a percek 0-59 intervallumba kell, hogy essenek.
*/

package com.company.javapractice;

public class practControle {

    public static void main(String[] args) {

        AritGeomSeries(args);

        timeDiff(args);

        AverMinMax(args);


        System.out.println("Error message follows: ");
        System.err.println(("Error!"));

        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        for (int i = args.length - 1; i >= 0; i--) {
            System.out.println(args[i]);
        }

        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(args[j] + " ");
            }
            System.out.println();
        }
    }

    public static void AverMinMax(String[] args) {
        int count = 0;
        double sum = 0.0;
        int max = Integer.parseInt(args[0]);
        int min = Integer.parseInt(args[0]);

        for (int i = 0; i < args.length; i++) {
            int argInt = Integer.parseInt(args[i]);
            sum += argInt;
            count++;
        }
        double average = sum / count;

        for (int i = 0; i < args.length; i++) {
            if (Integer.parseInt(args[i]) > max) {
                max = Integer.parseInt(args[i]);
            }
        }

        for (int i = 0; i < args.length; i++)
            if (Integer.parseInt(args[i]) < min) {
                min = Integer.parseInt(args[i]);
            }

        System.out.println("Average is " + average);
        System.out.println("Maximum is " + max);
        System.out.println("Average is " + min);
    }

    public static void timeDiff(String[] args) {
        int diffHour;
        int diffMin;
        if (Integer.parseInt(args[0]) > 0 && Integer.parseInt(args[0]) < 23 && Integer.parseInt(args[1]) > 0 && Integer.parseInt(args[1]) < 59 && Integer.parseInt(args[2]) > 0 && Integer.parseInt(args[2]) < 59 && Integer.parseInt(args[3]) > 0 && Integer.parseInt(args[3]) < 59) {
            int hour1 = Integer.parseInt(args[0]);
            int min1 = Integer.parseInt(args[1]);
            int hour2 = Integer.parseInt(args[2]);
            int min2 = Integer.parseInt(args[3]);
            int firstTime = (hour1 * 60) + min1;
            int secondTime = (hour2 * 60) + min2;
            diffHour = ((firstTime - secondTime) / 60);
            diffMin = ((firstTime - secondTime) % 60);
            System.out.println("The time difference is " + diffHour + " hours and " + diffMin + " minutes.");
        } else {
            System.out.println("Wrong time!");
        }
    }

    public static void AritGeomSeries(String[] args) {
        final double DIFF = Integer.parseInt(args[1]) - Integer.parseInt(args[0]);
        final double RATIO = Integer.parseInt(args[1]) / Integer.parseInt(args[0]);
        boolean isArithmetic = true;
        boolean isGeometric = true;

        for (int i = 0; i < args.length - 1; i++) {
            if (Integer.parseInt(args[i + 1]) - Integer.parseInt(args[i]) != DIFF) {
                isArithmetic = false;
                break;
            }

            if (Integer.parseInt(args[i + 1]) / Integer.parseInt(args[i]) != RATIO) {
                isGeometric = false;
                break;
            }
        }
        System.out.println("Arithmetical series: " + isArithmetic + "\n" + "Geometric series: " + isGeometric);
    }
}
