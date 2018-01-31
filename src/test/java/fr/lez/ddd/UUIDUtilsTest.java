package fr.lez.ddd;

import org.junit.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class UUIDUtilsTest {

    @Test
    public void instantiate_for_test_coverage() {
        new UUIDUtils();
    }

    @Test
    public void matchesUUID_of_valid_UUID_should_return_true() {
        String validUUID = UUID.randomUUID().toString();
        assertThat(UUIDUtils.matchesUUID(validUUID)).isTrue();
    }

    @Test
    public void matchesUUID_of_invalid_UUID_should_return_false() {
        String invalidUUID = "invalidUUID";
        assertThat(UUIDUtils.matchesUUID(invalidUUID)).isFalse();
    }

}