package fr.lez.ddd;

public class SimpleValueObject<T> {

    private final T value;

    public SimpleValueObject(T value) {
        this.value = ObjectUtils.requireNotNull(value);
    }

    public T getValue() {
        return this.value;
    }

}
