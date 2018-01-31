package fr.lez.ddd;

import java.util.UUID;

public abstract class EntityId extends SimpleValueObject<UUID> {

    protected EntityId(UUID id) {
        super(id);
    }

}
