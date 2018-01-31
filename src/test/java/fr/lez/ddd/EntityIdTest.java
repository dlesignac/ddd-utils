package fr.lez.ddd;

import org.junit.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class EntityIdTest {

    @Test(expected = IllegalArgumentException.class)
    public void can_not_be_instantiated_with_null_value() {
        new AnEntityIdImplementation(null);
    }

    @Test
    public void new_instance_should_return_correct_id() {
        UUID id = UUID.randomUUID();

        EntityId entityId = new AnEntityIdImplementation(id);

        assertThat(entityId.toUUID()).isEqualTo(id);
    }

    @Test
    public void equals_other_of_same_class_with_same_value_should_return_true() {
        UUID anId = UUID.randomUUID();
        EntityId anEntityId = new AnEntityIdImplementation(anId);
        EntityId anotherEntityId = new AnEntityIdImplementation(anId);
        assertThat(anEntityId).isEqualTo(anotherEntityId);
    }

    @Test
    public void equals_other_of_same_class_with_different_value_should_return_false() {
        UUID anId = UUID.randomUUID();
        UUID anotherId = UUID.randomUUID();
        EntityId anEntityId = new AnEntityIdImplementation(anId);
        EntityId anotherEntityId = new AnEntityIdImplementation(anotherId);
        assertThat(anEntityId).isNotEqualTo(anotherEntityId);
    }

    @Test
    public void equals_other_of_other_class_should_return_false() {
        UUID anId = UUID.randomUUID();
        EntityId anEntityId = new AnEntityIdImplementation(anId);
        EntityId anotherEntityId = new AnotherEntityIdImplementation(anId);
        assertThat(anEntityId).isNotEqualTo(anotherEntityId);
    }

    @Test
    public void hashCode_should_be_the_same_for_other_with_same_class_and_same_value() {
        UUID anId = UUID.randomUUID();
        EntityId anEntityId = new AnEntityIdImplementation(anId);
        EntityId anotherEntityId = new AnEntityIdImplementation(anId);
        assertThat(anEntityId.hashCode()).isEqualTo(anotherEntityId.hashCode());
    }

    @Test
    public void hashCode_should_be_different_for_other_with_different_value() {
        UUID anId = UUID.randomUUID();
        UUID anotherId = UUID.randomUUID();
        EntityId anEntityId = new AnEntityIdImplementation(anId);
        EntityId anotherEntityId = new AnEntityIdImplementation(anotherId);
        assertThat(anEntityId.hashCode()).isNotEqualTo(anotherEntityId.hashCode());
    }

    static class AnEntityIdImplementation extends EntityId {

        AnEntityIdImplementation(UUID id) {
            super(id);
        }
    }

    class AnotherEntityIdImplementation extends EntityId {

        AnotherEntityIdImplementation(UUID id) {
            super(id);
        }
    }

}