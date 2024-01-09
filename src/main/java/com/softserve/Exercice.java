package com.softserve;

import java.util.Objects;
import java.util.stream.Collectors;

public class Exercice {

    private static final String REGEX_NO_SPACES = "\\s";

    public String processChain(String chain) throws Exception {
        if (Objects.isNull(chain) || chain.isEmpty()) {
            throw new Exception("The chain should be not null or empty.");
        }
        chain = removeSpaces(chain);
        if (chain.isEmpty()) {
            throw new Exception("The chain should be empty.");
        }
        chain = removeDuplicates(chain);
        return chain;
    }

    private String removeDuplicates(String chain) {
        return chain.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }

    private String removeSpaces(String chain) {
        return chain.replaceAll(REGEX_NO_SPACES, "");
    }

}
