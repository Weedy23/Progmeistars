package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String data = scan.nextLine();
        if (DataStnadartFormAndCheck(data)) {
            System.out.println("Valid");
        } else {
            System.out.println("Not valid");
        }
    }

    public static boolean DataStnadartFormAndCheck(String data) {
        boolean F = false;
        if (data.charAt(0) > 1 || data.charAt(1) > 2 || data.charAt(3) < 2 || data.charAt(4) < 3 ) {
            F = true;
        }
        String[] Dat = data.split(" ", 3);

        int day;
        int month;
        int year = Integer.parseInt(Dat[2]);
        if (F) {
            day = Integer.parseInt(Dat[0]);
            month = Integer.parseInt(Dat[1]);
        } else {
           day = Integer.parseInt(Dat[1]);
           month = Integer.parseInt(Dat[0]);
        }

        return Year(year, month, day);
    }

    public static boolean Year(int year, int month, int day) {
        if (year > 0 && year < 2022) {
            boolean Y = false;
            if (year % 100 == 0 && year % 400 == 0) {
                Y = true;
            }
            return Month(month, day, Y);
        } else {
            return false;
        }
    }

    public static boolean Month(int month, int day, boolean year) {
        if (month > 0 && month < 13) {
            int monthLength = 30;
            switch (month) {
                case 2:
                    if (year) {
                        monthLength = 28;
                    } else {
                        monthLength = 27;
                    }
                case 1:
                    monthLength = 31;
                case 3:
                    monthLength = 31;
                case 5:
                    monthLength = 31;
                case 7:
                    monthLength = 31;
                case 8:
                    monthLength = 31;
                case 10:
                    monthLength = 31;
                case 12:
                    monthLength = 31;
                default:
                    return Day(day, monthLength);
            }
        } else {
            return false;
        }
    }

    public static boolean Day(int day, int monthLength) {
        if (day > 0 && day < monthLength) {
            return true;
        } else {
            return false;
        }

    }
}
