package fr.lez.ddd;

import org.junit.Test;

import java.util.UUID;

import static fr.lez.ddd.EntityIdTest.AnEntityIdImplementation;
import static org.assertj.core.api.Assertions.assertThat;

public class EntityTest {

    @Test(expected = IllegalArgumentException.class)
    public void can_not_be_instantiated_with_null_value() {
        new AnEntityImplementation(null);
    }

    @Test
    public void new_instance_should_return_correct_id() {
        AnEntityIdImplementation entityId = new AnEntityIdImplementation(UUID.randomUUID());
        Entity<EntityIdTest.AnEntityIdImplementation> actual = new AnEntityImplementation(entityId);

        assertThat(actual.getId()).isEqualTo(entityId);
    }

    @Test
    public void equals_other_with_same_id_should_return_true() {
        AnEntityIdImplementation entityId = new AnEntityIdImplementation(UUID.randomUUID());
        Entity<EntityIdTest.AnEntityIdImplementation> anEntity = new AnEntityImplementation(entityId);
        Entity<EntityIdTest.AnEntityIdImplementation> anotherEntity = new AnEntityImplementation(entityId);

        assertThat(anEntity).isEqualTo(anotherEntity);
    }

    @Test
    public void equals_other_with_different_value_should_return_false() {
        AnEntityIdImplementation anEntityId = new AnEntityIdImplementation(UUID.randomUUID());
        AnEntityIdImplementation anotherEntityId = new AnEntityIdImplementation(UUID.randomUUID());

        Entity<EntityIdTest.AnEntityIdImplementation> anEntity = new AnEntityImplementation(anEntityId);
        Entity<EntityIdTest.AnEntityIdImplementation> anotherEntity = new AnEntityImplementation(anotherEntityId);

        assertThat(anEntity).isNotEqualTo(anotherEntity);
    }

    @Test
    public void hashCode_should_be_the_same_for_other_with_same_id() {
        AnEntityIdImplementation entityId = new AnEntityIdImplementation(UUID.randomUUID());
        Entity<EntityIdTest.AnEntityIdImplementation> anEntity = new AnEntityImplementation(entityId);
        Entity<EntityIdTest.AnEntityIdImplementation> anotherEntity = new AnEntityImplementation(entityId);

        assertThat(anEntity.hashCode()).isEqualTo(anotherEntity.hashCode());
    }

    @Test
    public void hashCode_should_be_different_for_other_with_different_id() {
        AnEntityIdImplementation anEntityId = new AnEntityIdImplementation(UUID.randomUUID());
        AnEntityIdImplementation anotherEntityId = new AnEntityIdImplementation(UUID.randomUUID());

        Entity<EntityIdTest.AnEntityIdImplementation> anEntity = new AnEntityImplementation(anEntityId);
        Entity<EntityIdTest.AnEntityIdImplementation> anotherEntity = new AnEntityImplementation(anotherEntityId);

        assertThat(anEntity.hashCode()).isNotEqualTo(anotherEntity.hashCode());
    }

    class AnEntityImplementation extends Entity<EntityIdTest.AnEntityIdImplementation> {

        AnEntityImplementation(AnEntityIdImplementation id) {
            super(id);
        }
    }

}