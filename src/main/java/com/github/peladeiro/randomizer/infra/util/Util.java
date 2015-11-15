package com.github.peladeiro.randomizer.infra.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

/**
 * Created by pestano on 14/11/15.
 */
public class Util {

    private static NumberFormat numberFormat;


    public static NumberFormat getNumberFormat() {
        if(numberFormat == null){
            numberFormat = DecimalFormat.getInstance();
            numberFormat.setMaximumFractionDigits(2);
            numberFormat.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
            numberFormat.setRoundingMode(RoundingMode.CEILING);
        }
        return numberFormat;
    }
}
