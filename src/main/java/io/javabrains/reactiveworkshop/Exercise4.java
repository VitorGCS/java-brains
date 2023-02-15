package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.Optional;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        ReactiveSources.intNumberMono().subscribe(
                number -> System.out.println(number),
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Complete")
        );

/*
        // Get the value from the Mono into an integer variable
        Optional<Integer> value = ReactiveSources.intNumberMono().blockOptional();
        Optional<User> valueUser = ReactiveSources.userMono().blockOptional();
*/


        System.out.println("Press a key to end");
        System.in.read();
    }

}
