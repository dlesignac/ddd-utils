package fr.lez.ddd;

import java.util.regex.Pattern;

public final class UUIDUtils {

    private static final Pattern pattern;

    static {
        pattern = Pattern.compile("[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}");
    }

    UUIDUtils() {

    }

    public static boolean matchesUUID(String string) {
        return pattern.matcher(string).matches();
    }
}
