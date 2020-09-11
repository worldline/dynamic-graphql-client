package com.worldline.graphql.dynaql.impl.core.utils;

import com.worldline.graphql.dynaql.impl.core.DynaQLEnum;
import com.worldline.graphql.dynaql.impl.core.DynaQLInputObject;
import com.worldline.graphql.dynaql.impl.core.DynaQLVariable;
import org.eclipse.microprofile.graphql.client.core.exceptions.BuildException;

import java.lang.reflect.Array;
import java.time.LocalDate;

public class ValueFormatter {

    public static String format(Object value) throws BuildException {
        if (value == null) {
            return "null";
        } else if (value instanceof DynaQLVariable) {
            DynaQLVariable var = (DynaQLVariable) value;
            return "$" + var.getName();
        } else if (value instanceof DynaQLInputObject) {
            DynaQLInputObject inputObject = (DynaQLInputObject) value;
            return inputObject.build();
        } else if (value instanceof DynaQLEnum) {
            DynaQLEnum gqlEnum = (DynaQLEnum) value;
            return gqlEnum.build();
        } else if (value.getClass().isArray()) {
            return _processArray(value);
        } else if (value instanceof String) {
            return _getAsQuotedString(String.valueOf(value));
        } else if (value instanceof Character) {
            return _getAsQuotedString(String.valueOf(value));
        } else if (value instanceof LocalDate) {
            return _getAsQuotedString(String.valueOf(value));
        } else {
            return value.toString();
        }
    }

    private static String _processArray(Object array) throws BuildException {
        StringBuilder builder = new StringBuilder();

        int length = Array.getLength(array);
        builder.append("[");
        for (int i = 0; i < length; i++) {
            builder.append(format(Array.get(array, i)));
            if (i < length - 1) {
                builder.append(",");
            }
        }
        builder.append("]");

        return builder.toString();
    }

    private static String _getAsQuotedString(String value) {
        StringBuilder builder = new StringBuilder();

        builder.append('"');
        for (char c : value.toCharArray()) {
            switch (c) {
                case '"':
                case '\\':
                    builder.append('\\');
                    builder.append(c);
                    break;
                case '\r':
                    builder.append("\\r");
                    break;
                case '\n':
                    builder.append("\\n");
                    break;
                default:
                    if (c < 0x20) {
                        builder.append(String.format("\\u%04x", (int) c));
                    } else {
                        builder.append(c);
                    }
                    break;
            }
        }
        builder.append('"');

        return builder.toString();
    }
}
