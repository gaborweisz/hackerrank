package java.mixed;

import java.util.*;
import java.text.*;

public class CurrencyFormatter {

    public static void main(String[] args) {

        double payment = 123456.9;


        NumberFormat formatUS = NumberFormat.getNumberInstance(Locale.US);
        ((DecimalFormat) formatUS).applyPattern("$###,###,###,###.00");

        NumberFormat formatChina = NumberFormat.getNumberInstance(Locale.CHINA);
        ((DecimalFormat) formatChina).applyPattern("￥###,###,###,###.00");

        NumberFormat formatFrance = NumberFormat.getNumberInstance(Locale.FRANCE);
        ((DecimalFormat) formatFrance).applyPattern("###,###,###,###.00 €");

        NumberFormat formatIndia = NumberFormat.getNumberInstance(new Locale("en", "IN"));
        ((DecimalFormat) formatIndia).applyPattern("###,###,###,###.00");

        String us = formatUS.format(payment);
        String china = formatChina.format(payment);
        String france = formatFrance.format(payment);
        String india = "Rs." + formatIndia.format(payment);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}

