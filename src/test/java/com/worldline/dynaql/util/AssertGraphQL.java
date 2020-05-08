package com.worldline.dynaql.util;


import graphql.parser.InvalidSyntaxException;
import graphql.parser.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertGraphQL {
    public static void assertEquivalentGraphQLRequest(String expectedRequest, String actualRequest) {
        validateRequest(expectedRequest);
        validateRequest(actualRequest);

        /*
        Once requests have been deemed syntactically correct, we can remove some tokens
        to actually be able to compare them without taking into account insignificant differences.
         */
        expectedRequest = unformatRequest(expectedRequest);
        actualRequest = unformatRequest(actualRequest);

        assertEquals(expectedRequest, actualRequest);
    }

    private static void validateRequest(String request) {
        Parser parser = new Parser();
        try {
            parser.parseDocument(request);
        } catch (InvalidSyntaxException e) {
            System.err.println(request);
            throw (e);
        }
    }

    private static String unformatRequest(String request) {
        return request
                .trim()
                .replaceAll("\\s+", "")
                .replaceAll(System.getProperty("line.separator"), "")
                .replaceAll(",", "");
    }
}
