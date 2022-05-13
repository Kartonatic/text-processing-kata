package com.katas.java;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class TextProcessor {

  public static final String WORD_SEPARATOR = " ";

  public TextAnalyzed analyse(String text) {

    Map<String, Long> wordsCount = Arrays.stream(text.split(WORD_SEPARATOR))
                                         .filter(word -> !word.isEmpty())
                                         .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    long numberOfwords = wordsCount.values()
                                   .stream()
                                   .mapToLong(Long::longValue)
                                   .sum();

    return new TextAnalyzed(numberOfwords, wordsCount.keySet());
  }
}
