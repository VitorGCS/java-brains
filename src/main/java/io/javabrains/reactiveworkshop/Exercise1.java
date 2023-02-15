package io.javabrains.reactiveworkshop;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Exercise1 {

/*    import java.util.Arrays;

    class Solution1 {
        public int firstMissingPositive(int[] nums) {
            int min = 1;
            if(hasValueOneAndOtherPositiveValues(nums)){
                min = Arrays.stream(nums)
                        .filter(a -> a >= 0 )
                        .distinct()
                        .map( val -> {
                            if(Arrays.stream(nums).anyMatch(i -> i == val+1)){
                                return -1;
                            }else
                                return val+1;
                        })
                        .filter(a -> a>0)
                        .min().getAsInt();
            }
            return min;
        }

        private boolean hasValueOneAndOtherPositiveValues(int[] nums){
            return Arrays.stream(nums).anyMatch(val -> val > 0) && Arrays.stream(nums).anyMatch(x -> x==1);
        }
    }*/

    public static void main(String[] args) {

        int [] numbers = {-1,-2,-3,3,1,0,0,2,2,4,5};

        //special case - all negative values
        if(Arrays.stream(numbers).anyMatch( a -> a>0) && Arrays.stream(numbers).anyMatch(x ->x==1)) {
            int min = Arrays.stream(numbers)
                    .filter(a -> a >= 0)
                    //.sorted()
                    .distinct()
                    .map(value -> {
                        if (Arrays.stream(numbers).anyMatch(i -> i == value + 1)) {
                            return -1;
                        } else
                            return value + 1;
                    }).filter(a -> a > 0)
                    .min().getAsInt();
            System.out.println(min);
        }else
            System.out.println(1);

                //.forEach(System.out::println);

/*        s.flatMap(id -> StreamSources.userStream().filter(user -> user.getId()== id))
                .map(user -> user.getFirstName());
        */
        //minList.forEach(System.out::println);
        //System.out.println(sl.firstMissingPositive(numbers));
        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        /*StreamSources.intNumbersStream().forEach(System.out::println);*/

        // Print numbers from intNumbersStream that are less than 5
        /*StreamSources.intNumbersStream().filter(number -> number<5 ).forEach(System.out::println);*/

        // Print the second and third numbers in intNumbersStream that's greater than 5
        /*StreamSources.intNumbersStream().filter(number -> number>5 )
                .skip(1)
                .limit(2)
                .forEach(System.out::println);*/

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
/*        Integer value = StreamSources.intNumbersStream().filter(number -> number>5 )
                .findFirst()
                .orElse(-1);
        System.out.println(value);*/

        // Print first names of all users in userStream
/*        StreamSources.userStream()
                .map(user -> user.getFirstName())
                .forEach(System.out::println);*/

        // Print first names in userStream for users that have IDs from number stream
/*
        StreamSources.userStream()
                .filter(u -> StreamSources.intNumbersStream().anyMatch( i -> i == u.getId()))
                .forEach(System.out::println);

        var s = StreamSources.intNumbersStream();
        var s1 = s.flatMap(id -> StreamSources.userStream().filter(user -> user.getId()== id))
                .map(user -> user.getFirstName());
        s1.forEach(System.out::println);
*/


    }


}
