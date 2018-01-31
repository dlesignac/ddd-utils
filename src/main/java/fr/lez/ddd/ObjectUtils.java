package fr.lez.ddd;

public final class ObjectUtils {

    ObjectUtils() {

    }

    public static <T> T requireNotNull(T object) {
        if (object == null)
            throw new IllegalArgumentException("illegal null reference");
        return object;
    }

}
