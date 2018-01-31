package fr.lez.ddd;

import java.util.UUID;

public abstract class EntityId {

    private final UUID id;

    protected EntityId(UUID id) {
        this.id = ObjectUtils.requireNotNull(id);
    }

    public final UUID toUUID() {
        return this.id;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityId entityId = (EntityId) o;

        return id.equals(entityId.id);
    }

    @Override
    public final int hashCode() {
        return id.hashCode();
    }
}
