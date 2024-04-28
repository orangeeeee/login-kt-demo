package com.kt.loginktdemo.business.impl;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JSample {

    private void sampleLogic() {
        var lists = List.of("1","2","3","4","5","6","7","8","9");

        var integerList =lists.stream().map(toInt()).toList();
        var sumResult = integerList.stream().mapToInt(value -> value).sum();

        var xxOpt = opt("x");

        var xxx = xxOpt.map(String::toUpperCase);


    }


    private static @NotNull Function<String, Integer> toInt() {
        return Integer::valueOf;
    }

    private void sampleLogic2(String x) {

        Optional<String> xxOpt = Optional.ofNullable(x);

    }
    private static <T> Optional<T> opt(T val) {
        return Optional.ofNullable(val);
    }

}
