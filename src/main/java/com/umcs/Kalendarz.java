package com.umcs;

public class Kalendarz {
   public static int getNextMonth(int month) {
        if (month == 12) { //zepsuty kod
            return 1;
        }
        if (month < 1 ) {
            return 1;
        }
        return month + 1;
    }
}
