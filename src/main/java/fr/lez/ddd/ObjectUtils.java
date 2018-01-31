package fr.lez.ddd;

public final class ObjectUtils {

    private ObjectUtils() {

    }

    public static <T> T requireNotNull(T object) {
        if (object == null)
            throw new IllegalArgumentException("illegal null reference");
        return object;
    }

}
