package io.javabrains;

import org.apache.commons.lang3.math.NumberUtils;

public class App {
    public static void main( String[] args )
    {
        Addition addition = new Addition();
        System.out.println(" 1+1 = "+ addition.add(1,1));
        System.out.println(NumberUtils.toDouble("1234.5") + 900000);


    }
}
