package fr.lez.ddd;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleValueObjectTest {

    @Test(expected = IllegalArgumentException.class)
    public void can_not_be_instantiated_with_null_value() {
        new SimpleValueObject<Integer>(null);
    }

    @Test
    public void new_instance_should_return_correct_value() {
        SimpleValueObject<Integer> actual = new SimpleValueObject<Integer>(0);

        assertThat(actual.getValue()).isEqualTo(0);
    }

    @Test
    public void equals_other_with_same_value_should_return_true() {
        SimpleValueObject<Integer> aValueObject = new SimpleValueObject<Integer>(0);
        SimpleValueObject<Integer> anotherValueObject = new SimpleValueObject<Integer>(0);
        assertThat(aValueObject).isEqualTo(anotherValueObject);
    }

    @Test
    public void equals_other_with_different_value_should_return_false() {
        SimpleValueObject<Integer> aValueObject = new SimpleValueObject<Integer>(0);
        SimpleValueObject<Integer> anotherValueObject = new SimpleValueObject<Integer>(1);
        assertThat(aValueObject).isNotEqualTo(anotherValueObject);
    }

    @Test
    public void hashCode_should_be_the_same_for_other_with_same_value() {
        SimpleValueObject<Integer> aValueObject = new SimpleValueObject<Integer>(0);
        SimpleValueObject<Integer> anotherValueObject = new SimpleValueObject<Integer>(0);
        assertThat(aValueObject.hashCode()).isEqualTo(anotherValueObject.hashCode());
    }

    @Test
    public void hashCode_should_be_different_for_other_with_different_value() {
        SimpleValueObject<Integer> aValueObject = new SimpleValueObject<Integer>(0);
        SimpleValueObject<Integer> anotherValueObject = new SimpleValueObject<Integer>(1);
        assertThat(aValueObject.hashCode()).isNotEqualTo(anotherValueObject.hashCode());
    }

}