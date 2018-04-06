/*
        1. Hozzunk létre egy 7*10-es int -eket tartalmazó tömböt, töltsük fel ket, az alábbi séma szerint: tömb[x][y] = x*y; (pl.: tömb[5][8] =
        40;)
        2. Hozzunk létre egy karakter tömböt 't' 'e' 'l' 'e' 'f' 'o' 'n' karakterekkel. Másoljuk egy új tömbbe a 'l' 'e' karaktereket
        !
        3. Írj egy osztályt, amely téglalapot reprezentál, annak oldalhosszait tárolja. Készíts neki konstruktort, amely az oldalakat inicializálja. Írj az
        osztálynak még egy konstruktort, amely csak egy paramétert vár és amellyel négyzetet lehet létrehozni. Készíts metódusokat a kerület
        és terület kiszámítására. Írj egy másik osztályt, amely futtatható (van benne main függvény), és a parancssori paramétereknek
        megfelelen létrehoz téglalap objektumokat a Téglalap osztályból, és kiszámolja a Téglalapok területének és kerületének átlagát. Példa
        a main függvényre: számhármasok, az els szám jelöli, hogy 1 vagy 2 paraméterbl inicializálódik a téglalap, azaz négyzetet vagy
        téglalapot szeretnénk létrehozni, majd az ezt követ 1 vagy 2 szám tartalmazza a téglalap oldalhosszait. java TeglalapMain 1 5 2
        10 22 2 9 8 1 100 . Ennek jelentése: Elször létrehozunk egy négyzetet, 5-ös oldalhosszal, majd téglalapot 10, 22 oldalhosszakkal,
        majd megint téglalapot 9 és 8 oldalhosszakkal, majd egy négyzet, melynek 100 az oldalhossza.
*/

package com.company.javapractice;

public class ClassPDF {
    public static void main(String[] args) {
        matrix();
        phone();
    }

    public static void matrix() {
        int matArray[][] = new int[7][10];
        for (int i = 0; i < matArray.length; i++) {
            for (int j = 0; j < matArray[i].length; j++) {
                int randomX = (int) (Math.random() * 50 + 1);
                int randomY = (int) (Math.random() * 50 + 1);
                matArray[i][j] = randomX * randomY;
                System.out.println(matArray[i][j]);
            }
        }
        for (int i = 0; i < matArray.length; i++) {
            System.out.print("\n");
            for (int j = 0; j < matArray[i].length; j++) {
                System.out.print(matArray[i][j] + " ");
            }
        }
    }

    public static void phone() {
        char telefon[] = {'t', 'e', 'l', 'e', 'f', 'o', 'n'};
        char[] copy = new char[2];
        for (int i = 0; i < telefon.length; i++) {
            if (telefon[i] == 'l') {
                copy[0] = telefon[i];
            } else if (telefon[i] == 'e' && copy[0] == 'l') {
                copy[1] = telefon[i];
            }
        }

        System.out.println();

        for (int i = 0; i < copy.length; i++) {
            System.out.println(copy[i]);
        }
    }
}
