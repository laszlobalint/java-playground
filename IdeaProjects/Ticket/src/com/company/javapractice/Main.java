package com.company.javapractice;

import com.company.javapractice.Ticket.ReturnTicket;
import com.company.javapractice.Ticket.Ticket;

public class Main {

    public static void main(String[] args) {
        int ticketNum = 0;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("single") || args[i].equals("return")) {
                i += 3;
                ticketNum++;
            }
        }

        Ticket[] tickets = new Ticket[ticketNum];
        int counter = 0;
        for (int i = 0; i < args.length; i++) {
              if (args[i].equals("single")) {
                Ticket temp = new Ticket (Integer.parseInt(args[i + 1]), args[i + 2], Integer.parseInt(args[i + 3]));
                tickets[counter] = temp;
                i += 3;
                counter++;

            } else if (args[i].equals("return")){
                ReturnTicket temp = new ReturnTicket (Integer.parseInt(args[i + 1]), args[i + 2], Integer.parseInt(args[i + 3]));
                tickets[counter] = temp;
                i += 3;
                counter++;

            } else {
                System.err.println("Wrong ticket type!");
        }
    }

        System.out.println("Number of tickets created: " + ticketNum);
        Ticket max = tickets[0];
        for (int i = 0; i < tickets.length; i++) {
            if (max.calculatePrice() < tickets[i].calculatePrice()) {
                max = tickets[i];
            }
            System.out.println(tickets[i]);
        }
        System.out.println("The most expensive ticket is: " + max);

        System.out.println();

        Ticket ticketSzegedOroshaza = new Ticket(15, "Orosháza", 50);
        ticketSzegedOroshaza.calculatePrice();
        ticketSzegedOroshaza.useTicket();
        System.out.println(ticketSzegedOroshaza);

        ReturnTicket ticketSzegedSzabadka = new ReturnTicket(45, "Szabadka", 25);
        ticketSzegedSzabadka.calculatePrice();
        ticketSzegedSzabadka.useTicket();
        System.out.println(ticketSzegedSzabadka);
    }
}
