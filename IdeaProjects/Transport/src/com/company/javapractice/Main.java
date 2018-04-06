package com.company.javapractice;

import com.company.javapractice.human.Inspector;
import com.company.javapractice.human.Passenger;

public class Main {

    public static void main(String[] args) {
        Passenger pass1 = new Passenger(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), Boolean.parseBoolean(args[3]));
        Passenger pass2 = new Passenger(args[4], Integer.parseInt(args[5]), Integer.parseInt(args[6]), Boolean.parseBoolean(args[7]));
        Passenger pass3 = new Passenger(args[8], Integer.parseInt(args[9]), Integer.parseInt(args[10]), Boolean.parseBoolean(args[11]));
        Inspector inspector = new Inspector("Rude boy", 45, 0);

        if (args[3].equals("yes")) {
            pass1.setSeasonTicket(true);
        } else if (args[3].equals("no")) {
            pass1.setSeasonTicket(false);
        }

        if (args[7].equals("yes")) {
            pass2.setSeasonTicket(true);
        } else if (args[7].equals("no")) {
            pass2.setSeasonTicket(false);
        }

        if (args[11].equals("yes")) {
            pass3.setSeasonTicket(true);
        } else if (args[11].equals("no")) {
            pass3.setSeasonTicket(false);
        }


        pass1.getOn();
        pass2.getOn();
        pass3.getOn();

        inspector.inspect(pass1);
        inspector.inspect(pass2);
        inspector.inspect(pass3);

        System.out.println(inspector);
    }
}

