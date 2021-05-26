/*
Hozz létre egy fix méret vermet egész számok tárolására (tömb segítségével) és valósítsd meg a push/pop mveleteket.
Írj egy futtatható osztályt, mely a Main metódusban "push" vagy "pop" utasításokat vár a konzolról. Ha pop utasítást kap, hajtsa végre
azt, és írja ki a konzolra a kivett elemet. Push utasítás esetén egy egész számnak kell következnie, ezt tegye be a verembe.
Írj meg egy kivételosztályt, amit a fenti függvények (push/pop) akkor dobnak, ha a verem megtelt vagy üres.
*/

package com.company.javapractice;

import java.util.*;

public class Stack {

    public String[] stackArray;
    public int stackCounter;

    public Stack(int n) {
        this.stackArray = new String[n];
        this.stackCounter = 0;
    }

    public void pushToStack(String element) throws Exception {
        if (stackCounter == stackArray.length) {
            throw new ExceptionStackMax("There is no more space in the stack!");
        }
        stackArray[stackCounter] = element;
        stackCounter++;
    }

    public String popFromStack() throws Exception {
        if (stackCounter == 0) {
            throw new ExceptionStackMin("There is nothing to remove from the stack!");
        }
        stackCounter--;
        return stackArray[stackCounter + 1];
    }

    public boolean search(String lookingFor) {
        for (int i = 0; i < stackCounter; i++)
        if (stackArray[i].equals(lookingFor)) {
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        for (int i = 0; i < stackArray.length; i++) {
            if (stackArray[i] != null) {
                String str = stackArray[i];
                System.out.println(str);
            }
        }

        return "This stack contains " +
                "the following element: " + Arrays.toString(stackArray) +
                ", and the number of elements are " + stackCounter  + ". ";
    }
}
