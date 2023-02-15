package io.javabrains.reactiveworkshop;

import java.io.IOException;

public final class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        //ReactiveSources.intNumbersFlux().subscribe(e -> System.out.println(e));
        //ReactiveSources.intNumbersFlux().subscribe(System.out::println);

        // Print all users in the ReactiveSources.userFlux stream
        ReactiveSources.userFlux().subscribe(
                number -> System.out.println(number),
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Complete")
        );

        System.out.println("Press a key to end");
        System.in.read();
    }

}
