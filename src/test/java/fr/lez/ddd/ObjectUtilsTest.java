package fr.lez.ddd;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ObjectUtilsTest {

    @Test
    public void instantiate_for_test_coverage() {
        new ObjectUtils();
    }

    @Test(expected = IllegalArgumentException.class)
    public void requireNotNull_of_null_should_throw_an_exception() {
        ObjectUtils.requireNotNull(null);
    }

    @Test
    public void requireNotNull_of_non_null_value_should_return_the_same_value() {
        Integer actual = ObjectUtils.requireNotNull(0);
        assertThat(actual).isEqualTo(0);
    }

}