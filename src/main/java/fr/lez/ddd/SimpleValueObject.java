package fr.lez.ddd;

public class SimpleValueObject<T> {

    private final T value;

    public SimpleValueObject(T value) {
        this.value = ObjectUtils.requireNotNull(value);
    }

    public final T getValue() {
        return this.value;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleValueObject<?> that = (SimpleValueObject<?>) o;

        return value.equals(that.value);
    }

    @Override
    public final int hashCode() {
        return value.hashCode();
    }
}
