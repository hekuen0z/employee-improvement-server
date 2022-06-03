package bsuir.diplom.serverapplication.utilities;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.lang.Math;
import java.util.Set;

public final class UnicodeStream {

    private static PrintStream printStream;

    static {
        try {
            printStream = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException exception) {
            exception.printStackTrace();
        }
    }

    public UnicodeStream () {}

    public static <T> void printUnicode (Set<T> objectsSet) {
        for (T objectToPrint : objectsSet) {
            printStream.println(objectToPrint);
        }
    }

    public static void printUnicode (Object objectToPrint) {
        printStream.println(objectToPrint);
    }
}
